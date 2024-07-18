package crs.controller.bean;

import com.sd.util.adf.ADFUtils;

import com.sd.util.adf.JSFUtils;
import com.sd.util.db.DBUtil;

import crs.common.Constants;

import gen.common.GenLib;

import javax.faces.event.ValueChangeEvent;

import oracle.adf.view.rich.component.rich.RichDocument;
import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.adf.view.rich.event.DialogEvent;

import oracle.adf.view.rich.event.PopupCanceledEvent;

import oracle.jbo.ViewObject;


public class TaskListBean extends CrsBaseBean 
{
 private RichDocument doc;
 private static final String  INCOMING_DOC_CC_ITERATOR = "CrsIncomingDocCcView3Iterator";
 private static final String  INCOMING_DOC_CC_PK = "IncomingDocCcPk"; 
    
  public TaskListBean() {
    if (!AdfFacesContext.getCurrentInstance().isPostback()) {
      ViewObject incomingDocumentCCVwView = ADFUtils.findIterator("IncomingDocumentCCVwView1Iterator").getViewObject();
      incomingDocumentCCVwView.setWhereClause(" INCOMING_DOC_STS_FK = " + Constants.CC_DOCUMENT_NEW + 
                        " and CC_DEPARTMENTS_FK = " + GenLib.getUserLoginDepartment());
      incomingDocumentCCVwView.executeQuery();
    }
  }
  
    public String updateIncomingDocStsFk() {

    if (JSFUtils.getFromSession("incomingDocStsFk").equals(Integer.toString(Constants.CC_DOCUMENT_REFERRAL) )){
      ADFUtils.executeOperator("CreateInsertCrsIncomingDocCcView3");
    } 
    
    showPopup("UpdateIncomingDocStsFkPopup");
    return null;
  }
    
  public void setIncomingDocStatus(DialogEvent dialogEvent) {
    String incomingDocStsFk = (String)JSFUtils.getFromSession("incomingDocStsFk");

    String updateIncomingDocStatusSql =
      " update CRS_INCOMING_DOC_CC " + 
      " set incoming_DOC_STS_FK = " + incomingDocStsFk +
      " where INCOMING_DOC_CC_PK = " + 
      ADFUtils.getAttribute("IncomingDocumentCCVwView1Iterator", INCOMING_DOC_CC_PK);
   
    try {
      DBUtil.executeDML(updateIncomingDocStatusSql);
      ADFUtils.commit();
    }
    
    catch (Exception e) {
      GenLib.handleException(e);
    }
  
    ADFUtils.findIterator("IncomingDocumentCCVwView1Iterator").executeQuery();

  }
  
  public void displayRejectReasonChanged(ValueChangeEvent vce) {
    masterTranslationChanged(vce, INCOMING_DOC_CC_ITERATOR, INCOMING_DOC_CC_PK, "CrsIncomingDocCcTlView2Iterator", "RejectReason");
  }
  
  public void displayIncomingDocGuidanceChanged(ValueChangeEvent vce) {
    masterTranslationChanged(vce, INCOMING_DOC_CC_ITERATOR, INCOMING_DOC_CC_PK, "CrsIncomingDocCcTlView2Iterator", "IncomingDocGuidance");
  }
  
  public void displayNotesChanged(ValueChangeEvent vce) {
    masterTranslationChanged(vce, INCOMING_DOC_CC_ITERATOR, INCOMING_DOC_CC_PK, "CrsIncomingDocCcTlView2Iterator", "Notes");
  }
  
  public void cancelIncomingDocStsFk(PopupCanceledEvent de) {
    ADFUtils.rollback();
  }

  public void executionDateGChanged(ValueChangeEvent vce) {
    convertGregorianToHijri(vce, INCOMING_DOC_CC_ITERATOR, "ExecutionDateH", "crsIncomingDocCcExecutiondateh");
  }
  
  public void executionDateHChanged(ValueChangeEvent vce) {
    convertHijriToGregorian(vce, INCOMING_DOC_CC_ITERATOR, "ExecutionDateG", "crsIncomingDocCcExecutiondateg");
  }
  
  public String viewAction() {
    showPopup("inDocViewPopup");
    return null;
  }
  
  public void setDoc(RichDocument doc) {
    this.doc = doc;
  }

  public RichDocument getDoc() {
    return doc;
  }
}
