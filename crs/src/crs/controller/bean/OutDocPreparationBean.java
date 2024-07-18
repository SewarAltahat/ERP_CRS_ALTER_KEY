package crs.controller.bean;

import com.sd.util.adf.ADFUtils;
import com.sd.util.adf.JSFUtils;

import crs.common.ControllerUtil;

import crs.common.ScannerUtils;

import gen.common.GenLib;

import java.io.OutputStream;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.adf.view.rich.event.DialogEvent;
import oracle.adf.view.rich.event.PopupCanceledEvent;
import oracle.adf.view.rich.render.ClientEvent;

import oracle.jbo.Row;

import org.apache.myfaces.trinidad.context.RequestContext;

public class OutDocPreparationBean extends CrsBaseBean
{
  private RichTable crsOutgoingDocCcTable;
  private static final String OUTGOING_DOC_PREPRATION_ITERATOR = "CrsOutgoingDocPreparationView1Iterator";
  private static final String OUTGOING_ARCHIVE_ITERATOR = "CrsOutgoingArchiveView1Iterator";
  
  public OutDocPreparationBean(){
    
    Object outgoingDocumentPrePk = ADFUtils.getAttribute(OUTGOING_DOC_PREPRATION_ITERATOR, "OutgoingDocPreparationPk");
      if (outgoingDocumentPrePk != null && !AdfFacesContext.getCurrentInstance().isPostback()){
        GenLib.filterDocumentsBySecurityLevels(OUTGOING_ARCHIVE_ITERATOR, "SECURITY_LEVEL_FK");
    }
  }

  public String insertBeneficiaries() {
    showPopup("beneficiariesPopup");
    return null;
  }
  
  public void commitBeneficiaries(DialogEvent de){
    commitTranslation(de, "CrsBeneficiariesView1Iterator");
    Object beneficiaryPk = ADFUtils.getAttributeInViewObject("CrsBeneficiariesView1", "BeneficiariesPk");
    Object outgoingDocPreparationPk = ADFUtils.getAttribute(OUTGOING_DOC_PREPRATION_ITERATOR, "OutgoingDocPreparationPk");
    
    ControllerUtil.insertOutgoingBeneficiaries(beneficiaryPk, null, outgoingDocPreparationPk);
    ADFUtils.findIterator("CrsOutgoingBeneficiariesView1Iterator").executeQuery();
  }

  public void cancelAddbeneficiaries(PopupCanceledEvent de){
    cancelTranslation(de, "CrsBeneficiariesView1Iterator");
  }

  public void executionDateHChanged(ValueChangeEvent vce){
    convertHijriToGregorian(vce, "CrsOutgoingDocCcView1Iterator", "ExecutionDateG", "crsOutgoingDocCcExecutiondateg");
  }
  
  public void executionDateGChanged(ValueChangeEvent vce) {
    convertGregorianToHijri(vce, "CrsOutgoingDocCcView1Iterator", "ExecutionDateH", "crsOutgoingDocCcExecutiondateh");
  }

  public void displayOutSubjectChanged(ValueChangeEvent vce){
    masterTranslationChanged(vce, OUTGOING_DOC_PREPRATION_ITERATOR, "OutgoingDocPreparationPk",
                             "CrsOutgoingDocPreTlView1Iterator", "OutSubject");
  }

  public void displayKeywordChanged(ValueChangeEvent vce){
    masterTranslationChanged(vce, OUTGOING_DOC_PREPRATION_ITERATOR, "OutgoingDocPreparationPk",
                             "CrsOutgoingDocPreTlView1Iterator", "Keyword");
  }

  public void displayNotesChanged(ValueChangeEvent vce){
    masterTranslationChanged(vce, OUTGOING_DOC_PREPRATION_ITERATOR, "OutgoingDocPreparationPk",
                             "CrsOutgoingDocPreTlView1Iterator", "Notes");  
  }
  
  public void displayCommentValueChanged(ValueChangeEvent vce){
    masterTranslationChanged(vce, "CrsOutgoingCommentsView4Iterator", "OutgoingCommentsPk",
                             "CrsOutgoingCommentsTlView4Iterator", "CommentValue");
  }
  
  public void displayArcDocDescChanged(ValueChangeEvent vce){
    masterTranslationChanged(vce, OUTGOING_ARCHIVE_ITERATOR, "OutgoingArchivePk",
                             "CrsOutgoingArchiveTlView4Iterator", "ArcDocDesc");
  }

  public void displayArcDocNameChanged(ValueChangeEvent vce){
    masterTranslationChanged(vce, OUTGOING_ARCHIVE_ITERATOR, "OutgoingArchivePk",
                             "CrsOutgoingArchiveTlView4Iterator", "ArcDocName");
  }
  
  public void commitTranslationOfOutgoingDocPreparation(DialogEvent de){
    commitTranslationWithRowKey(de, OUTGOING_DOC_PREPRATION_ITERATOR,
      ADFUtils.getAttribute(OUTGOING_DOC_PREPRATION_ITERATOR, "OutgoingDocPreparationPk") + "");
  }
  
  public void cancelTranslationOfOutgoingDocPreparation(PopupCanceledEvent de){
    cancelTranslation(de, OUTGOING_DOC_PREPRATION_ITERATOR);
  }
  
  public void commitTranslationOfOutgoingArchive(DialogEvent de){
    commitTranslationWithNoPreserveRow(de, OUTGOING_ARCHIVE_ITERATOR);
  }

  public void cancelTranslationOfOutgoingArchive(PopupCanceledEvent de){
    cancelTranslation(de, OUTGOING_ARCHIVE_ITERATOR);
  }

  public void cancelTranslationOfOutgoingDocAttachment(PopupCanceledEvent de){
    cancelTranslation(de, "CrsOutgoingDocAttachmentsView1Iterator");
  }

  public void commitTranslationOfOutgoingDocAttachment(DialogEvent de){
    commitTranslation(de, "CrsOutgoingDocAttachmentsView1Iterator");
  }
  
  public void cancelTranslationOfOutgoingComments(PopupCanceledEvent de){
    cancelTranslation(de, "CrsOutgoingCommentsView4Iterator");
  }

  public void commitTranslationOfOutgoingComments(DialogEvent de){
    commitTranslation(de, "CrsOutgoingCommentsView4Iterator");
  }
  
  public void downloadOutgoingArchiveAttachment(FacesContext context, OutputStream os){
    downloadFile(context, os, OUTGOING_ARCHIVE_ITERATOR, "ArcFilePath");
  }

  public void uploadOutgoingArchiveAttachment(ValueChangeEvent valueChangeEvent) {
    uploadFile(valueChangeEvent, OUTGOING_ARCHIVE_ITERATOR, "ArcFilePath");
  }
  
  public void displayOutAttachDescChanged(ValueChangeEvent vce){
    masterTranslationChanged(vce, "CrsOutgoingDocAttachmentsView1Iterator", "OutgoingDocAttachmentsPk",
                             "CrsOutgoingDocAttachTlView4Iterator", "OutAttachDesc");
  }
  
  public String rollbackAction(){
    ADFUtils.rollback();
    callExecuteOperator("CrsOutgoingDocPreparationCreateInsert");

    return null;
  }
  
  public String createInsertAction(){
    callExecuteOperator("CrsOutgoingDocPreparationCreateInsert");
    
    return null;
  }
  
  public void callExecuteOperator(String bindingOperatorName){
    ADFUtils.executeOperator(bindingOperatorName);
  }

  public void refreshFromScanner(ClientEvent clientEvent) {
  
    ScannerUtils.updateUploadPath(clientEvent , OUTGOING_ARCHIVE_ITERATOR , "FilePath" , "CrsOutgoingArchive1" );
  }
  
  public void outgoingRunReport(ActionEvent actionEvent){
    crsRunReport(actionEvent, OUTGOING_DOC_PREPRATION_ITERATOR, "OutgoingDocPreparationPk", "CrsDocumentsPk");
  }
  
  public void setCrsOutgoingDocCcTable(RichTable crsOutgoingDocCcTable){
    this.crsOutgoingDocCcTable = crsOutgoingDocCcTable;
  }
  
  public RichTable getCrsOutgoingDocCcTable() {
    
    return crsOutgoingDocCcTable;
  }
}