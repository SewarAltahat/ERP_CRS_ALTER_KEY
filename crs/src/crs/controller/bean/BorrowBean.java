package crs.controller.bean;

import javax.faces.event.ValueChangeEvent;

import oracle.adf.view.rich.event.DialogEvent;
import oracle.adf.view.rich.event.PopupCanceledEvent;


public class BorrowBean extends CrsBaseBean
{
  private static final String  CRS_BORROW_REQUESTS_VIEW_ITERATOR = "CrsBorrowRequestsView1Iterator";
  
  public BorrowBean() {
  }

  public void cancelTranslation(PopupCanceledEvent de) {
    cancelTranslation(de, CRS_BORROW_REQUESTS_VIEW_ITERATOR);
  }

  public void commitTranslation(DialogEvent de) {
    commitTranslation(de, CRS_BORROW_REQUESTS_VIEW_ITERATOR);
  }

  public void displayRequestReasonChanged(ValueChangeEvent vce) {
    masterTranslationChanged(vce, CRS_BORROW_REQUESTS_VIEW_ITERATOR, "BorrowRequestsPk",
                             "CrsBorrowRequestsTlView1Iterator", "RequestReason");
  }

  public void displayNotesChanged(ValueChangeEvent vce) {
    masterTranslationChanged(vce, CRS_BORROW_REQUESTS_VIEW_ITERATOR, "BorrowRequestsPk",
                             "CrsBorrowRequestsTlView1Iterator", "Notes");
  }
}
