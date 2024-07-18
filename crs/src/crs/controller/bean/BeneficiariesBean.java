package crs.controller.bean;

import javax.faces.event.ValueChangeEvent;

import oracle.adf.view.rich.event.DialogEvent;
import oracle.adf.view.rich.event.PopupCanceledEvent;


public class BeneficiariesBean extends CrsBaseBean
{
  private static final String  CRS_BENEFICIARIES_VIEW_ITERATOR = "CrsBeneficiariesView1Iterator";

  public void displayBeneficiaryNameChanged(ValueChangeEvent vce) {
    masterTranslationChanged(vce, CRS_BENEFICIARIES_VIEW_ITERATOR, "BeneficiariesPk", 
                             "CrsBeneficiariesTlView1Iterator", "BeneficiaryName");
  }
  
  public void displayNotesChanged(ValueChangeEvent vce) {
    masterTranslationChanged(vce, CRS_BENEFICIARIES_VIEW_ITERATOR, "BeneficiariesPk", 
                             "CrsBeneficiariesTlView1Iterator", "Notes");
  }

  public void commitTranslation(DialogEvent de) {
    commitTranslation(de, CRS_BENEFICIARIES_VIEW_ITERATOR);
  }

  public void cancelTranslation(PopupCanceledEvent de) {
    cancelTranslation(de, CRS_BENEFICIARIES_VIEW_ITERATOR);
  }
}
