package crs.controller.bean;


public class DepartmentGroupsBean extends CrsBaseBean
{
  private static final String  CRS_DEPT_GROUP_ITERATOR = "CrsDeptGroupView1Iterator";
  
  public void displayGroupNameChanged(javax.faces.event.ValueChangeEvent vce){
    masterTranslationChanged(vce, CRS_DEPT_GROUP_ITERATOR, "DeptGroupPk", 
                             "CrsDeptGroupTlView1Iterator", "GroupName");
  }
  
  public void commitCrsDeptGroupTlTranslation(oracle.adf.view.rich.event.DialogEvent de) {
    commitTranslation(de, CRS_DEPT_GROUP_ITERATOR);
  }

  public void cancelCrsDeptGroupTlTranslation(oracle.adf.view.rich.event.PopupCanceledEvent de){
    cancelTranslation(de, CRS_DEPT_GROUP_ITERATOR);
  }

}