package crs.controller.bean;

import gen.common.BaseMenuBean;
import javax.faces.context.FacesContext;
import org.apache.myfaces.trinidad.util.Service;
import org.apache.myfaces.trinidad.render.ExtendedRenderKitService;

@SuppressWarnings("oracle.jdeveloper.java.serialversionuid-field-missing")
public class MenuBean extends BaseMenuBean
{
  public boolean isUpdateAllowed()
  {
    //return operationAllowed(UPDATE_OPERATION);
    return true;
  }
  
  public boolean isUpdatePrivilegeAllowed()
  {
    return operationAllowed(UPDATE_OPERATION);
  }

  public boolean isInsertAllowed()
  {
    return operationAllowed(INSERT_OPERATION);
  }

  public boolean isDeleteAllowed()
  {
    return operationAllowed(DELETE_OPERATION);
  }

  public boolean isSelectAllowed()
  {
    return operationAllowed(SELECT_OPERATION);
  }
  
  public String genericDeleteAction()
    {
      FacesContext context = FacesContext.getCurrentInstance();
      ExtendedRenderKitService service = Service.getRenderKitService(context, ExtendedRenderKitService.class);
      service.addScript(context, "openPopup();");
      return null;
    }
  
  public String getDeleteIcon()
  {
    return "/images/delete.png";
  }
  
  public String getCreateInsertIcon()
  {
    return "/images/createInsert.png";
  }
  
  public String getPrintLabelIcon()
  {
    return "/images/barcode.png";
  }
  
  public String getCommitIcon()
  {
    return "/images/commit.png";
  }
  
  public String getRollbackIcon()
  {
    return "/images/rollback.png";
  }
  
  public String getExcelIcon()
  {
    return "/images/excel.png";
  }
  
  public boolean isRollbackVisible()
    {
      return true;
    }
    
      public boolean isPrintVisible()
    {
      return false;
    }
    
    public boolean isExcelVisible()
    {
      return true;
    }
  
}
