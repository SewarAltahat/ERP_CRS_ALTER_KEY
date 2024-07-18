package crs.controller.bean;

import com.sd.util.adf.ADFUtils;

import crs.common.ControllerUtil;

import gen.common.GenLib;

import javax.faces.event.ValueChangeEvent;

import oracle.adf.view.rich.component.rich.RichDocument;
import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.adf.view.rich.event.DialogEvent;
import oracle.adf.view.rich.event.PopupCanceledEvent;


public class DepartmentReferenceBean extends CrsBaseBean
{
  
  private RichDocument departmentreference;
   
  private static final String  CRS_FILES_LOCATION_VIEW_ITERATOR = "CrsFilesLocationView3Iterator";

  public DepartmentReferenceBean() {
    if (!AdfFacesContext.getCurrentInstance().isPostback()) {
      GenLib.filterByDepartmentAndSecurityLevels("HcmDepartmentsVwView1Iterator","DEPARTMENTS_PK","DEPARTMENTS_PK");
    }
  }

  public void cancelTranslationFilesLocation(PopupCanceledEvent de) {
    cancelTranslation(de, CRS_FILES_LOCATION_VIEW_ITERATOR);
  }

  public void commitTranslationFilesLocation(DialogEvent de){
    commitTranslation(de, CRS_FILES_LOCATION_VIEW_ITERATOR);
  }

  public void displayFileLocationPkChanged(ValueChangeEvent vce) {
    masterTranslationChanged(vce, CRS_FILES_LOCATION_VIEW_ITERATOR, "FilesLocationPk", "CrsFilesLocationTlView3Iterator",
                             "FileLocationDesc");
  }

  public void setDepartmentreference(RichDocument departmentreference) {
    this.departmentreference = departmentreference;
  }

  public RichDocument getDepartmentreference() {
    return departmentreference;
  }

 
}
