package crs.controller.bean;

import com.sd.util.adf.ADFUtils;
import com.sd.util.adf.JSFUtils;

import com.sd.util.db.DBUtil;

import crs.common.ControllerUtil;

import crs.common.ScannerUtils;

import gen.common.GenConstants;
import gen.common.GenLib;

import java.io.OutputStream;

import java.math.BigDecimal;

import java.sql.Timestamp;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.adf.view.rich.event.DialogEvent;
import oracle.adf.view.rich.event.PopupCanceledEvent;
import oracle.adf.view.rich.event.PopupFetchEvent;
import oracle.adf.view.rich.render.ClientEvent;

import oracle.jbo.JboException;
import oracle.jbo.Row;

import oracle.jbo.ViewObject;
import oracle.jbo.server.ViewObjectImpl;

import org.apache.myfaces.trinidad.context.RequestContext;

public class IndocBean extends CrsBaseBean
{
  private RichTable crsIncomingDocCcTable;
  private static final String INCOMING_DOCUMENT_ITERATOR = "CrsIncomingDocumentsView1Iterator";
  private static final String INCOMING_ARCHIVE_ITERATOR = "CrsIncomingArchiveView1Iterator";
  private static final String INCOMING_DOC_CC_ITERATOR = "CrsIncomingDocCcView1Iterator";
  private static final String INCOMING_DOCUMENT_PK = "IncomingDocumentsPk";
  private static final BigDecimal  ACTIVE_FLAG =  new  BigDecimal(1) ;

  public IndocBean() {
    Object incomingDocumentPk = ADFUtils.getAttribute(INCOMING_DOCUMENT_ITERATOR, INCOMING_DOCUMENT_PK);

    if (incomingDocumentPk != null && !AdfFacesContext.getCurrentInstance().isPostback()){
      GenLib.filterDocumentsBySecurityLevels(INCOMING_ARCHIVE_ITERATOR, "SECURITY_LEVEL_FK");
    }
    
  }

  public String insertBeneficiaries() {
    showPopup("beneficiariesPopup");
    return null;
  }

  public void executeIterator( String iteratorName){
    ADFUtils.findIterator(iteratorName).executeQuery();
  }
  public void commitBeneficiaries(DialogEvent de){
    commitTranslation(de, "CrsBeneficiariesView1Iterator");
    Object beneficiaryPk = ADFUtils.getAttributeInViewObject("CrsBeneficiariesView1", "BeneficiariesPk");
    Object incomingDocumentPk = ADFUtils.getAttribute(INCOMING_DOCUMENT_ITERATOR, INCOMING_DOCUMENT_PK);
    ControllerUtil.insertIncomingBeneficiaries(beneficiaryPk, incomingDocumentPk);
    executeIterator("CrsIncomingBeneficiariesView1Iterator");
  }

  public void cancelAddBeneficiaries(PopupCanceledEvent de){
    cancelTranslation(de, "CrsBeneficiariesView1Iterator");
  }

  public void inDocDateHChanged(ValueChangeEvent vce){
    convertHijriToGregorian(vce, INCOMING_DOCUMENT_ITERATOR, "InDocDateG", "crsIncomingDocumentsIndocdateg");
  }

  public void inDocDateGChanged(ValueChangeEvent vce){
    convertGregorianToHijri(vce, INCOMING_DOCUMENT_ITERATOR, "InDocDateH", "crsIncomingDocumentsIndocdateh");
  }

  public void executionDateHChanged(ValueChangeEvent vce){
    convertHijriToGregorian(vce, INCOMING_DOC_CC_ITERATOR, "ExecutionDateG", "crsIncomingDocCcExecutiondateg");
  }

  public void executionDateGChanged(ValueChangeEvent vce){
    convertGregorianToHijri(vce, INCOMING_DOC_CC_ITERATOR, "ExecutionDateH", "crsIncomingDocCcExecutiondateh");
  }

  public void displayCommentValueChanged(ValueChangeEvent vce) {
    masterTranslationChanged(vce, "CrsIncomingCommentsView1Iterator", "IncomingCommentsPk",
                             "CrsIncomingCommentsTlView3Iterator", "CommentValue");
  }
  
  public void displayNotesValueChanged(ValueChangeEvent vce){
    masterTranslationChanged(vce, INCOMING_DOC_CC_ITERATOR, "IncomingDocCcPk",
                             "CrsIncomingDocCcTlView3Iterator", "Notes");
  }

  public void displayIncomingDocGuidanceValueChanged(ValueChangeEvent vce){
    masterTranslationChanged(vce, INCOMING_DOC_CC_ITERATOR, "IncomingDocCcPk",
                             "CrsIncomingDocCcTlView3Iterator", "IncomingDocGuidance");
  }
  public void displayInSubjectChanged(ValueChangeEvent vce){
    masterTranslationChanged(vce, INCOMING_DOCUMENT_ITERATOR, INCOMING_DOCUMENT_PK,
                             "CrsIncomingDocumentsTlView1Iterator", "InSubject");
  }

  public void displayKeywordChanged(ValueChangeEvent vce){
    masterTranslationChanged(vce, INCOMING_DOCUMENT_ITERATOR, INCOMING_DOCUMENT_PK,
                             "CrsIncomingDocumentsTlView1Iterator", "Keyword");
  }

  public void displayNotesChanged(ValueChangeEvent vce){
    masterTranslationChanged(vce, INCOMING_DOCUMENT_ITERATOR, INCOMING_DOCUMENT_PK,
                             "CrsIncomingDocumentsTlView1Iterator", "Notes");
  }

  public void displayArcDocDescChanged(ValueChangeEvent vce){
    masterTranslationChanged(vce, INCOMING_ARCHIVE_ITERATOR, "IncomingArchivePk",
                             "CrsIncomingArchiveTlView3Iterator", "ArcDocDesc");
  }

  public void displayArcDocNameChanged(ValueChangeEvent vce){
    masterTranslationChanged(vce, INCOMING_ARCHIVE_ITERATOR, "IncomingArchivePk",
                             "CrsIncomingArchiveTlView3Iterator", "ArcDocName");
  }

  public void displayInAttachDescChanged(ValueChangeEvent vce){
    masterTranslationChanged(vce, "CrsIncomingDocAttachmentsView1Iterator", "IncomingDocAttachmentsPk",
                             "CrsIncomingDocAttachTlView3Iterator", "InAttachDesc");
  }

  public void commitIncomingDocumentTranslation(DialogEvent de){
    commitTranslationWithRowKey(de, INCOMING_DOCUMENT_ITERATOR,
                                ADFUtils.getAttribute(INCOMING_DOCUMENT_ITERATOR, INCOMING_DOCUMENT_PK) + "");
  }

  public void cancelIncomingDocumentTranslation(PopupCanceledEvent de){
    cancelTranslation(de, INCOMING_DOCUMENT_ITERATOR);
  }

  public void commitIncomingArchiveTranslation(DialogEvent de){
    commitTranslationWithNoPreserveRow(de, INCOMING_ARCHIVE_ITERATOR);
  }

  public void cancelIncomingArchiveTranslation(PopupCanceledEvent de){
    cancelTranslation(de, INCOMING_ARCHIVE_ITERATOR);
  }

  public void commitIncomingDocAttachmentTranslation(DialogEvent de){
    commitTranslation(de, "CrsIncomingDocAttachmentsView1Iterator");
  }

  public void cancelIncomingDocAttachmentTranslation(PopupCanceledEvent de){
    cancelTranslation(de, "CrsIncomingDocAttachmentsView1Iterator");
  }

  public void commitIncomingCommentsTranslation(DialogEvent de){
    commitTranslation(de, "CrsIncomingCommentsView1Iterator");
  }

  public void cancelIncomingCommentsTranslation(PopupCanceledEvent de){
    cancelTranslation(de, "CrsIncomingCommentsView1Iterator");
  }
  
  
  public void commitTranslationDetail(DialogEvent de){
    commitTranslation(de, INCOMING_DOCUMENT_ITERATOR);
  }

  public void cancelTranslationDetail(PopupCanceledEvent de) {
    cancelTranslation(de, INCOMING_DOCUMENT_ITERATOR);
  }

  public void downloadIncomingArchiveAttachment(FacesContext context, OutputStream os){
    downloadFile(context, os, INCOMING_ARCHIVE_ITERATOR, "ArcFilePath");
  }

  public void uploadIncomingArchiveAttachment(ValueChangeEvent valueChangeEvent){
    uploadFile(valueChangeEvent, INCOMING_ARCHIVE_ITERATOR, "ArcFilePath");
  }

  public String rollbackAction(){
    ADFUtils.rollback();
    ADFUtils.executeOperator("CrsIncomingDocumentsCreateInsert");
    return null;
  }

  public String createInsertAction(){
    ADFUtils.executeOperator("CrsIncomingDocumentsCreateInsert");
    ADFUtils.setAttribute(INCOMING_DOCUMENT_ITERATOR, "ToDepartmentFk", GenLib.getUserLoginDepartment());

    return null;
  }

  public void refreshFromScanner(ClientEvent clientEvent) {
  
    ScannerUtils.updateUploadPath(clientEvent , INCOMING_ARCHIVE_ITERATOR , "FilePath" , "CrsIncomingArchive1" );
  }
  

  public void runReport(ActionEvent actionEvent) {
    crsRunReport(actionEvent, INCOMING_DOCUMENT_ITERATOR, INCOMING_DOCUMENT_PK, "CrsDocumentsPk");
  }

  public void insertCrsDocDelivery(ActionEvent actionEvent){
    try {
      ControllerUtil.insertCrsDocDelivery(INCOMING_DOCUMENT_ITERATOR, INCOMING_DOCUMENT_PK,
                                          GenConstants.INCOMING_DOCUMENT);
      super.runReport(actionEvent);
    }
    catch (Exception e) {
      GenLib.handleException(e);
    }
  }

  public void setCrsIncomingDocCcTable(RichTable crsIncomingDocCcTable){
    this.crsIncomingDocCcTable = crsIncomingDocCcTable;
  }

  public RichTable getCrsIncomingDocCcTable() {
    return crsIncomingDocCcTable;
  }

  public String insertDocCc(){
    executeIterator("ReportParametersRVO1Iterator");
    showPopup("docCcPopup");
    return null;
  }

  public void commitDocCc(DialogEvent de){
    ControllerUtil.commitDocumentCc(INCOMING_DOCUMENT_ITERATOR, INCOMING_DOCUMENT_PK, INCOMING_DOC_CC_ITERATOR, "CrsIncomingDocCcView2");

  }

  public void cancelAddDocCc(PopupCanceledEvent de){
    cancelTranslation(de, INCOMING_DOC_CC_ITERATOR);
  }

  public String insertDocCcDept() {
    executeIterator("ReportParametersRVO1Iterator");
    executeIterator("DeparmentsRVOIterator");
    showPopup("docCcDeptPopup");
    return null;

  }

  public void cancelAddDocDeptCc(PopupCanceledEvent de){
    cancelTranslation(de, INCOMING_DOC_CC_ITERATOR);
  }

  public void commitDocDeptCc(DialogEvent dialogEvent){
    ControllerUtil.commitDocumentDepartmentCc(INCOMING_DOCUMENT_ITERATOR, INCOMING_DOCUMENT_PK, 
                                              INCOMING_DOC_CC_ITERATOR, "CrsIncomingDocCcView2");
  }

  public void updateConfirmAssignmentFl(DialogEvent dialogEvent){

    Row incomingDocumentrow = ADFUtils.findIterator(INCOMING_DOCUMENT_ITERATOR).getViewObject().getCurrentRow();
    incomingDocumentrow.setAttribute("ConfirmAssignmentFl", ACTIVE_FLAG);
    ADFUtils.commit();

  }
}
