package crs.common;

import com.sd.util.adf.ADFUtils;

import gen.common.GenLib;

import oracle.adf.view.rich.render.ClientEvent;

import oracle.jbo.Row;

import org.apache.myfaces.trinidad.context.RequestContext;

public class ScannerUtils
{
  public static void updateUploadPath
        (ClientEvent clientEvent , String iteratorName  , String attributeName , String componentName) {

    String fileName = (String) clientEvent.getParameters().get("currentFileName");
    fileName = GenLib.getUploadPathSuffix() + fileName + ".pdf";
    Row statmentAttachRow = ADFUtils.findIterator(iteratorName).getViewObject().getCurrentRow();
    if (statmentAttachRow == null) {
      GenLib.showErrorMessage("error.insertAttachment");
      return;
    }
    statmentAttachRow.setAttribute(attributeName, fileName);
    
    refreshComponent(componentName);
    
  }
  
  private static void refreshComponent(String componentName){
    RequestContext.getCurrentInstance().addPartialTarget(ADFUtils.findComponentInRoot(componentName));
  }
}
