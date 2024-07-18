package crs.controller.bean;

import com.sd.util.adf.ADFUtils;

import crs.common.ControllerUtil;

import crs.common.ScannerUtils;

import gen.common.GenConstants;
import gen.common.GenLib;

import java.io.OutputStream;

import java.math.BigDecimal;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.adf.view.rich.event.DialogEvent;
import oracle.adf.view.rich.event.PopupCanceledEvent;
import oracle.adf.view.rich.render.ClientEvent;

public class OutDocBean extends CrsBaseBean
{
  public RichTable crsOutgoingDocCcTable;
  private static final String  CRS_OUTGOING_DOCUMENTS_VIEW1_ITERATOR = "CrsOutgoingDocumentsView1Iterator";
  private static final String  CRS_OUTGOING_ARCHIVE_VIEW1_ITERATOR = "CrsOutgoingArchiveView1Iterator";
  private static final String  CRS_OUTGOING_DOC_CC_VIEW1_ITERATOR = "CrsOutgoingDocCcView1Iterator";
  private static final String  OUTGOING_DOCUMENT_PK = "OutgoingDocumentsPk";
  private static final String  CRS_OUTGOING_COMMENTS_VIEW1_ITERATOR = "CrsOutgoingCommentsView1Iterator";
  private static final String  CRS_OUTGOING_DOCUMENTS_TL_VIEW1_ITERATOR = "CrsOutgoingDocumentsTlView1Iterator";
  private static final String  CRS_OUTGOING_DOC_ATTACHMENTS_VIEW1_ITERATOR = "CrsOutgoingDocAttachmentsView1Iterator";
  private static final String  REPORT_PARAMETERS_RVO1_ITERATOR = "ReportParametersRVO1Iterator";

  public OutDocBean()
  {
    Object outgoingDocumentPk = ADFUtils.getAttribute(CRS_OUTGOING_DOCUMENTS_VIEW1_ITERATOR, OUTGOING_DOCUMENT_PK);
    if (outgoingDocumentPk != null && !AdfFacesContext.getCurrentInstance().isPostback())
    {
      GenLib.filterByDepartmentAndSecurityLevels("HcmDepartmentsVwView1Iterator", "DEPARTMENTS_PK", "DEPARTMENTS_PK");
      GenLib.filterDocumentsBySecurityLevels(CRS_OUTGOING_ARCHIVE_VIEW1_ITERATOR, "SECURITY_LEVEL_FK");
    }
  }

  public String insertBeneficiaries(){
    showPopup("beneficiariesPopup");
    return null;
  }

  public void commitBeneficiaries(DialogEvent de) {
    commitTranslation(de, "CrsBeneficiariesView1Iterator");
    Object beneficiariyPk = ADFUtils.getAttributeInViewObject("CrsBeneficiariesView1", "BeneficiariesPk");
    Object outgoingDocumentPk = ADFUtils.getAttribute(CRS_OUTGOING_DOCUMENTS_VIEW1_ITERATOR, OUTGOING_DOCUMENT_PK);
    ControllerUtil.insertOutgoingBeneficiaries(beneficiariyPk, outgoingDocumentPk, null);
    refreshIterator("CrsOutgoingBeneficiariesView1Iterator");
  }

  public void cancelAddbeneficiaries(PopupCanceledEvent de){
    cancelTranslation(de, "CrsBeneficiariesView1Iterator");
  }

  public void executionDateHChanged(ValueChangeEvent vce){
    convertHijriToGregorian(vce, CRS_OUTGOING_DOC_CC_VIEW1_ITERATOR, "ExecutionDateG", "crsOutgoingDocCcExecutiondateg");
  }

  public void executionDateGChanged(ValueChangeEvent vce) {
    convertGregorianToHijri(vce, CRS_OUTGOING_DOC_CC_VIEW1_ITERATOR, "ExecutionDateH", "crsOutgoingDocCcExecutiondateh"); 
  }

  public void displayCommentValueChanged(ValueChangeEvent vce){
    masterTranslationChanged(vce, CRS_OUTGOING_COMMENTS_VIEW1_ITERATOR, "OutgoingCommentsPk",
                             "CrsOutgoingCommentsTlView3Iterator", "CommentValue");
  }

  public void displayOutSubjectChanged(ValueChangeEvent vce) {
    masterTranslationChanged(vce, CRS_OUTGOING_DOCUMENTS_VIEW1_ITERATOR, OUTGOING_DOCUMENT_PK,
                             CRS_OUTGOING_DOCUMENTS_TL_VIEW1_ITERATOR, "OutSubject");
  }

  public void displayKeywordChanged(ValueChangeEvent vce)  {
    masterTranslationChanged(vce, CRS_OUTGOING_DOCUMENTS_VIEW1_ITERATOR, OUTGOING_DOCUMENT_PK,
                             CRS_OUTGOING_DOCUMENTS_TL_VIEW1_ITERATOR, "Keyword");
  }

  public void displayNotesChanged(ValueChangeEvent vce) {
    masterTranslationChanged(vce, CRS_OUTGOING_DOCUMENTS_VIEW1_ITERATOR, OUTGOING_DOCUMENT_PK,
                             CRS_OUTGOING_DOCUMENTS_TL_VIEW1_ITERATOR, "Notes");
  }

  public void displayArcDocDescChanged(ValueChangeEvent vce) {
    masterTranslationChanged(vce, CRS_OUTGOING_ARCHIVE_VIEW1_ITERATOR, "OutgoingArchivePk",
                             "CrsOutgoingArchiveTlView3Iterator", "ArcDocDesc");
  }

  public void displayArcDocNameChanged(ValueChangeEvent vce) {
    masterTranslationChanged(vce, CRS_OUTGOING_ARCHIVE_VIEW1_ITERATOR, "OutgoingArchivePk",
                             "CrsOutgoingArchiveTlView3Iterator", "ArcDocName");
  }

  public void displayOutAttachDescChanged(ValueChangeEvent vce) {
    masterTranslationChanged(vce, CRS_OUTGOING_DOC_ATTACHMENTS_VIEW1_ITERATOR, "OutgoingDocAttachmentsPk",
                             "CrsOutgoingDocAttachTlView3Iterator", "OutAttachDesc");
  }

  public void commitTranslation(DialogEvent de) {
    String outgoingDocumentPk = ADFUtils.getAttribute(CRS_OUTGOING_DOCUMENTS_VIEW1_ITERATOR, OUTGOING_DOCUMENT_PK) + "";
    commitTranslationWithRowKey(de, CRS_OUTGOING_DOCUMENTS_VIEW1_ITERATOR, outgoingDocumentPk);
  }

  public void cancelTranslation(PopupCanceledEvent de) {
    cancelTranslation(de, CRS_OUTGOING_DOCUMENTS_VIEW1_ITERATOR);
  }

  public void commitTranslation1(DialogEvent de) {
    commitTranslationWithNoPreserveRow(de, CRS_OUTGOING_ARCHIVE_VIEW1_ITERATOR);
  }

  public void cancelTranslation1(PopupCanceledEvent de) {
    cancelTranslation(de, CRS_OUTGOING_ARCHIVE_VIEW1_ITERATOR);
  }

  public void commitTranslation2(DialogEvent de) {
    commitTranslation(de, CRS_OUTGOING_DOC_ATTACHMENTS_VIEW1_ITERATOR);
  }

  public void cancelTranslation2(PopupCanceledEvent de) {
    cancelTranslation(de, CRS_OUTGOING_DOC_ATTACHMENTS_VIEW1_ITERATOR);
  }

  public void commitTranslation3(DialogEvent de) {
    commitTranslation(de, CRS_OUTGOING_COMMENTS_VIEW1_ITERATOR);
  }

  public void cancelTranslation3(PopupCanceledEvent de){
    cancelTranslation(de, CRS_OUTGOING_COMMENTS_VIEW1_ITERATOR);
  }
  
  public void downloadOutgoingArchiveAttachment(FacesContext context, OutputStream os) {
    downloadFile(context, os, CRS_OUTGOING_ARCHIVE_VIEW1_ITERATOR, "ArcFilePath");
  }

  public void uploadOutgoingArchiveAttachment(ValueChangeEvent valueChangeEvent) {
    uploadFile(valueChangeEvent, CRS_OUTGOING_ARCHIVE_VIEW1_ITERATOR, "ArcFilePath");
  }

  public String rollbackAction() {
    ADFUtils.rollback();
    executeOperator("CreateInsertIntoCrsOutgoingDocuments");
    return null;
  }

  public String createInsertAction() {
    executeOperator("CreateInsertIntoCrsOutgoingDocuments");
    return null;
  }
  public void executeOperator( String operatorName) {
      ADFUtils.executeOperator(operatorName);
    }
  public void cancelCrsOutgoingDocCcTl(PopupCanceledEvent de) {
    cancelTranslation(de, CRS_OUTGOING_DOC_CC_VIEW1_ITERATOR);
  }

  public void commitCrsOutgoingDocCcTl(DialogEvent de) {
    commitTranslation(de, CRS_OUTGOING_DOC_CC_VIEW1_ITERATOR);
  }
  
  public void displayoutCCNotesChanged(ValueChangeEvent vce) {
    masterTranslationChanged(vce, CRS_OUTGOING_DOC_CC_VIEW1_ITERATOR, "OutgoingDocCcPk",
                             "CrsOutgoingDocCcTlView2Iterator", "Notes");
  }

  public void displayoutCCGuidanceChanged(ValueChangeEvent vce) {
    masterTranslationChanged(vce, CRS_OUTGOING_DOC_CC_VIEW1_ITERATOR, "OutgoingDocCcPk",
                             "CrsOutgoingDocCcTlView2Iterator", "OutgoingDocGuidance");
  }
  
  public void refreshFromScanner(ClientEvent clientEvent) {
  
    ScannerUtils.updateUploadPath(clientEvent , CRS_OUTGOING_ARCHIVE_VIEW1_ITERATOR , "FilePath" , "CrsOutgoingArchive1" );
  }
  
  
  public void outgoingRunReport(ActionEvent actionEvent) {
    crsRunReport(actionEvent, CRS_OUTGOING_DOCUMENTS_VIEW1_ITERATOR, OUTGOING_DOCUMENT_PK, "CrsDocumentsPk");
  }

  public void insertCrsDocDelivery(ActionEvent actionEvent) {
    try {
      ControllerUtil.insertCrsDocDelivery(CRS_OUTGOING_DOCUMENTS_VIEW1_ITERATOR, OUTGOING_DOCUMENT_PK,
                                          GenConstants.OUTGOING_DOCUMENT);
      super.runReport(actionEvent);
    } catch (Exception e) {
      GenLib.handleException(e);
    }
  }

  public void setCrsOutgoingDocCcTable(RichTable crsOutgoingDocCcTable) {
    this.crsOutgoingDocCcTable = crsOutgoingDocCcTable;
  }

  public RichTable getCrsOutgoingDocCcTable() {
    return crsOutgoingDocCcTable;
  }
  
  public String insertDocCc() {
    refreshIterator(REPORT_PARAMETERS_RVO1_ITERATOR);
    showPopup("docCcPopup");
    return null;
  }
  
  public void commitDocCc(DialogEvent de) {
    ControllerUtil.commitDocumentCc(CRS_OUTGOING_DOCUMENTS_VIEW1_ITERATOR, OUTGOING_DOCUMENT_PK, CRS_OUTGOING_DOC_CC_VIEW1_ITERATOR, "CrsOutgoingDocCcView2");
  }

  public void cancelAddDocCc(PopupCanceledEvent de){
    cancelTranslation(de, CRS_OUTGOING_DOC_CC_VIEW1_ITERATOR);
  }

  public String insertDocCcDept() {
    refreshIterator(REPORT_PARAMETERS_RVO1_ITERATOR);
    refreshIterator("DeparmentsRVOIterator");
    showPopup("docCcDeptPopup");
    return null;
  }

  public void cancelAddDocDeptCc(PopupCanceledEvent de) {
    cancelTranslation(de, CRS_OUTGOING_DOC_CC_VIEW1_ITERATOR);
  }

  public void commitDocDeptCc(DialogEvent dialogEvent) {
   ControllerUtil.commitDocumentDepartmentCc(CRS_OUTGOING_DOCUMENTS_VIEW1_ITERATOR, OUTGOING_DOCUMENT_PK, CRS_OUTGOING_DOC_CC_VIEW1_ITERATOR, "CrsOutgoingDocCcView2");
  }


  public void printTemplat(ActionEvent actionEvent) {
    BigDecimal outgoingDocumentPk = (BigDecimal)ADFUtils.getAttribute(CRS_OUTGOING_DOCUMENTS_VIEW1_ITERATOR, OUTGOING_DOCUMENT_PK);
    BigDecimal  letterTemplatesFK =   (BigDecimal)ADFUtils.getAttribute(REPORT_PARAMETERS_RVO1_ITERATOR, "LetterTemplatesFK");
    ADFUtils.setAttribute(REPORT_PARAMETERS_RVO1_ITERATOR, "LetterTemplatesFK", letterTemplatesFK);
    ADFUtils.setAttribute(REPORT_PARAMETERS_RVO1_ITERATOR, "CrsDocumentsPk", outgoingDocumentPk);
    super.runReport(actionEvent);
  }

  public void cancelTranslationAllDetail(PopupCanceledEvent popupCanceledEvent){
    cancelTranslation(popupCanceledEvent, CRS_OUTGOING_DOCUMENTS_VIEW1_ITERATOR);
  }

  public void commitTranslationAllDetail(DialogEvent dialogEvent) {
    commitTranslation(dialogEvent, CRS_OUTGOING_DOCUMENTS_VIEW1_ITERATOR);
  }
  
  public void refreshIterator(String  iteratorName) {
    ADFUtils.findIterator(iteratorName).executeQuery();
  }
}
