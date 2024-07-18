package crs.controller.bean;

import oracle.adf.view.rich.event.PopupCanceledEvent;


public class DocClassBean extends CrsBaseBean {
  
  private static final String  CRS_DOC_CLASS_ITERATOR = "CrsDocClassView1Iterator";
  private static final String  CRS_DOC_CLASS_CC_ITERATOR = "CrsDocClassCcView1Iterator";
  
  public void displayDocClassChanged(javax.faces.event.ValueChangeEvent vce){
    masterTranslationChanged(vce, CRS_DOC_CLASS_ITERATOR, "DocClassPk", 
                             "CrsDocClassTlView1Iterator", "DocClass");
     }
  
  public void displayNotesChanged(javax.faces.event.ValueChangeEvent vce) {
    masterTranslationChanged(vce, CRS_DOC_CLASS_CC_ITERATOR, "DocClassCcPk", 
                             "CrsDocClassCcTlView1Iterator", "Notes");
  }

  public void commitCrsDocClassTlTranslation(oracle.adf.view.rich.event.DialogEvent de){
    commitTranslation(de, CRS_DOC_CLASS_ITERATOR);
  }

  public void cancelCrsDocClassTlTranslation(oracle.adf.view.rich.event.PopupCanceledEvent de){
    cancelTranslation(de, CRS_DOC_CLASS_ITERATOR);
  }

  public void commitCrsDocClassCcTlTranslation(oracle.adf.view.rich.event.DialogEvent de){
    commitTranslation(de, CRS_DOC_CLASS_CC_ITERATOR);
  }
  
  public void cancelCrsDocClassCcTlTranslation(PopupCanceledEvent de){
    cancelTranslation(de, CRS_DOC_CLASS_CC_ITERATOR);
  }
 

 

}