package crs.controller.bean;


import com.sd.util.adf.ADFUtils;
import com.sd.util.db.DBUtil;

import crs.common.Constants;
import crs.common.ControllerUtil;

import gen.common.GenConstants;
import gen.common.GenLib;

import java.io.OutputStream;

import java.math.BigDecimal;

import javax.faces.context.FacesContext;

import oracle.adf.view.rich.component.rich.RichDocument;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.jbo.Key;
import oracle.jbo.Row;
import oracle.jbo.ViewObject;
import oracle.jbo.server.ViewObjectImpl;

public class InternalDocBean extends CrsBaseBean
{
  private RichPopup outDoc;
  private RichDocument doc;
  private static final String  OUTGOING_DOCUMENTS_FK = "Outgoing_Documents_Fk";
  
  public InternalDocBean(){
    if (!AdfFacesContext.getCurrentInstance().isPostback()){
      String whereClauseBySecurity = GenLib.getFiterDocumentsBySecurityLevelsWhereClause("SECURITY_LEVEL_FK");
      String whereClauseByDepartment = GenLib.getFilterByDepartmentWhereClause("USER_DEPARTMENT_FK");
      ViewObject crsOutgoingDocumentsVo = ADFUtils.findIterator("CrsOutgoingDocumentsView4Iterator").getViewObject();
      String whereClause = ControllerUtil.filterSupplyedTransaction();
      StringBuilder allCondition=new StringBuilder(whereClauseBySecurity);
      allCondition.append(" and ");
      allCondition.append(whereClauseByDepartment);
      allCondition.append(" and ");
      allCondition.append(whereClause); 
      crsOutgoingDocumentsVo.setWhereClause(allCondition.toString());  
      crsOutgoingDocumentsVo.executeQuery();
      GenLib.filterDocumentsBySecurityLevels("CrsOutgoingArchiveView4Iterator", "SECURITY_LEVEL_FK");  
    }
  }
  public void downloadOutgoingArchiveAttachment(FacesContext context, OutputStream os) {
    downloadFile(context, os, "CrsOutgoingArchiveView4Iterator", "ArcFilePath");
  }
  
  public void insertDataToIncoming() {
      Row[] crsOutgoingDocumentsList = ADFUtils.findIterator("CrsOutgoingDocumentsView4Iterator").getAllRowsInRange();
      BigDecimal StatuesFlag =
                (BigDecimal) ADFUtils.getAttribute("CrsOutgoingDocumentsView4Iterator", "SeletedFl");
      if(StatuesFlag != null)
      {
      for (Row crsOutgoingDocument: crsOutgoingDocumentsList) {
        if (isSelected(crsOutgoingDocument)) {
          processSelectedDocument(crsOutgoingDocument);
        }
      }
      ADFUtils.commit();
      ADFUtils.findIterator("CrsOutgoingDocumentsView4Iterator").executeQuery();
      }
      else
      {
        GenLib.showErrorMessage("error.SelectOperation");
      }
    }

    private boolean isSelected(Row crsOutgoingDocument) {
      Object selectedFlag = DBUtil.nvl(crsOutgoingDocument.getAttribute("SeletedFl"), 0);
      return selectedFlag.equals(Constants.ACTIVE);
    }

    private void processSelectedDocument(Row crsOutgoingDocument) {
      BigDecimal outgoingDocumentPk = (BigDecimal) crsOutgoingDocument.getAttribute("OutgoingDocumentsPk");
      Object incomingDocumentPk = insertDataToIncomingDocuments(outgoingDocumentPk);
      insertDataToIncomingArchive(incomingDocumentPk, outgoingDocumentPk);
      insertDataToIncomingBeneficiaries(incomingDocumentPk, outgoingDocumentPk);
      insertDataToIncomingComments(incomingDocumentPk, outgoingDocumentPk);
      insertDataToIncomingDocAttachments(incomingDocumentPk, outgoingDocumentPk);
      insertDataToIncomingDocCc(incomingDocumentPk, outgoingDocumentPk);
      insertDataToIncomingRelatedLetters(incomingDocumentPk, outgoingDocumentPk);
    }

   public Object  insertDataToIncomingDocuments( BigDecimal outgoingDocumentPk ) {
    Key key = new Key(new Object[] { outgoingDocumentPk });
    Row[] crsOutgoingDocument = ADFUtils.findIterator("CrsOutgoingDocumentsView4Iterator").getViewObject().findByKey(key, 1);
    ViewObject crsIncomingDocument = ADFUtils.getViewObjectFromAppModule("CrsIncomingDocumentsView1");
    Row newCrsIncomingDocument = crsIncomingDocument.createRow();
    Row selectedOutgoingDocument = crsOutgoingDocument[0];
    newCrsIncomingDocument.setAttribute("InDocYear", selectedOutgoingDocument.getAttribute("OutDocYear"));
    newCrsIncomingDocument.setAttribute("InDocDateG", selectedOutgoingDocument.getAttribute("OutDocDateG"));
    newCrsIncomingDocument.setAttribute("InDocDateH", selectedOutgoingDocument.getAttribute("OutDocDateH"));
    newCrsIncomingDocument.setAttribute("InDocTypeFk", selectedOutgoingDocument.getAttribute("OutDocTypeFk"));
    newCrsIncomingDocument.setAttribute("IncomingTypeFk", GenConstants.INTERNAL_DEPARTMENT_TYPE);
    newCrsIncomingDocument.setAttribute("FromDepartmentFk", selectedOutgoingDocument.getAttribute("FromDepartmentFk"));
    newCrsIncomingDocument.setAttribute("ToDepartmentFk", selectedOutgoingDocument.getAttribute("ToDepartmentFk"));
    newCrsIncomingDocument.setAttribute("PriorityFk", selectedOutgoingDocument.getAttribute("PriorityFk"));
    newCrsIncomingDocument.setAttribute("SecurityLevelFk", selectedOutgoingDocument.getAttribute("SecurityLevelFk"));
    newCrsIncomingDocument.setAttribute("AttachmentsNo", selectedOutgoingDocument.getAttribute("AttachmentsNo"));
    newCrsIncomingDocument.setAttribute("FilesLocationFk", selectedOutgoingDocument.getAttribute("FilesLocationFk"));
    newCrsIncomingDocument.setAttribute("Barcode", selectedOutgoingDocument.getAttribute("Barcode"));
    newCrsIncomingDocument.setAttribute("RespondPeriod", selectedOutgoingDocument.getAttribute("RespondPeriod"));
    newCrsIncomingDocument.setAttribute("ReceivedDateG", selectedOutgoingDocument.getAttribute("ReceivedDateG"));
    newCrsIncomingDocument.setAttribute("ReceivedDateH", selectedOutgoingDocument.getAttribute("ReceivedDateH"));
    newCrsIncomingDocument.setAttribute("DisplayInSubject", selectedOutgoingDocument.getAttribute("DisplayOutSubject"));
    newCrsIncomingDocument.setAttribute("DisplayKeyword", selectedOutgoingDocument.getAttribute("DisplayKeyword"));
    newCrsIncomingDocument.setAttribute("ClassificationFk", selectedOutgoingDocument.getAttribute("ClassificationFk"));
    newCrsIncomingDocument.setAttribute("DisplayNotes", selectedOutgoingDocument.getAttribute("DisplayNotes"));
    newCrsIncomingDocument.setAttribute("IncomingDocumentsNo", selectedOutgoingDocument.getAttribute("OutgoingDocumentsNo"));
    newCrsIncomingDocument.setAttribute("DistributionTypeFk", selectedOutgoingDocument.getAttribute("DistributionTypeFk"));
    newCrsIncomingDocument.setAttribute("OutgoingDocumentsFk", outgoingDocumentPk);
    newCrsIncomingDocument.setAttribute("ConfirmAssignmentFl", Constants.ACTIVE);
    ADFUtils.commitWithoutMessage();
    selectedOutgoingDocument.setAttribute("SupplyFl", Constants.ACTIVE);
    return  newCrsIncomingDocument.getAttribute("IncomingDocumentsPk");
       
  }
  
  public void insertDataToIncomingArchive(  Object incomingDocumentPk   , BigDecimal outgoingDocumentPk ) {
    ViewObjectImpl crsOutgoingArchives =(ViewObjectImpl)ADFUtils.getDefaultApplicationModuleForDataControl().findViewObject("CrsOutgoingArchiveView1");
    crsOutgoingArchives.setWhereClause( OUTGOING_DOCUMENTS_FK+" = " + outgoingDocumentPk);
    crsOutgoingArchives.executeQuery();
    int crsOutgoingArchiveCount = (int) crsOutgoingArchives.getEstimatedRowCount();
    crsOutgoingArchives.first();
    for (int i = 0; i < crsOutgoingArchiveCount; i++) {
    Row selectedcrsOutgoingArchive = crsOutgoingArchives.getCurrentRow();
    ViewObject crsIncomingArchives = ADFUtils.getViewObjectFromAppModule("CrsIncomingArchiveView2");
    Row newIncomingArchives = crsIncomingArchives.createRow();
    newIncomingArchives.setAttribute("ArcFilePath",  selectedcrsOutgoingArchive.getAttribute("ArcFilePath"));
    newIncomingArchives.setAttribute("IncomingDocumentsFk", incomingDocumentPk);
    newIncomingArchives.setAttribute("SecurityLevelFk",selectedcrsOutgoingArchive.getAttribute("SecurityLevelFk"));
    newIncomingArchives.setAttribute("DisplayArcDocName", selectedcrsOutgoingArchive.getAttribute("DisplayArcDocName"));
    newIncomingArchives.setAttribute("DisplayArcDocDesc", selectedcrsOutgoingArchive.getAttribute("DisplayArcDocDesc"));
    crsOutgoingArchives.next();
    }
  }
  
      public void insertDataToIncomingBeneficiaries(  Object incomingDocumentPk   , BigDecimal outgoingDocumentPk ) {
        ViewObjectImpl crsOutgoingBeneficiaries=(ViewObjectImpl)ADFUtils.getDefaultApplicationModuleForDataControl().findViewObject("CrsOutgoingBeneficiariesView1");
        crsOutgoingBeneficiaries.setWhereClause( OUTGOING_DOCUMENTS_FK+" = " + outgoingDocumentPk);
        crsOutgoingBeneficiaries.executeQuery();
        int crsOutgoingBeneficiariesCount = (int) crsOutgoingBeneficiaries.getEstimatedRowCount();
        crsOutgoingBeneficiaries.first();
        for (int i = 0; i < crsOutgoingBeneficiariesCount; i++) {
        ViewObject crsIncomingBeneficiaries = ADFUtils.getViewObjectFromAppModule("CrsIncomingBeneficiariesView3");
        Row newCrsIncomingBeneficiaries = crsIncomingBeneficiaries.createRow();
        newCrsIncomingBeneficiaries.setAttribute("BeneficiariesFk", crsOutgoingBeneficiaries.getCurrentRow().getAttribute("BeneficiariesFk"));
        newCrsIncomingBeneficiaries.setAttribute("IncomingDocumentsFk", incomingDocumentPk);
        crsOutgoingBeneficiaries.next();
        }
      }
      public void insertDataToIncomingComments(  Object incomingDocumentPk   , BigDecimal outgoingDocumentPk ){
        ViewObjectImpl crsOutgoingComments =(ViewObjectImpl)ADFUtils.getDefaultApplicationModuleForDataControl().findViewObject("CrsOutgoingCommentsView1");
        crsOutgoingComments.setWhereClause( OUTGOING_DOCUMENTS_FK+" = " + outgoingDocumentPk);
        crsOutgoingComments.executeQuery();
        int crsOutgoingCommentsCount = (int) crsOutgoingComments.getEstimatedRowCount();
        crsOutgoingComments.first();
        for (int i = 0; i < crsOutgoingCommentsCount; i++) {
        ViewObject crsIncomingComments = ADFUtils.getViewObjectFromAppModule("CrsIncomingCommentsView2");
        Row newCrsIncomingComments = crsIncomingComments.createRow();
        newCrsIncomingComments.setAttribute("IncomingDocumentsFk", incomingDocumentPk);
        newCrsIncomingComments.setAttribute("DisplayCommentValue", crsOutgoingComments.getCurrentRow().getAttribute("DisplayCommentValue"));
        crsOutgoingComments.next();
        }
      }

      public void insertDataToIncomingDocAttachments(  Object incomingDocumentPk   , BigDecimal outgoingDocumentPk ) {
        ViewObjectImpl crsOutgoingDocAttachments =(ViewObjectImpl)ADFUtils.getDefaultApplicationModuleForDataControl().findViewObject("CrsOutgoingDocAttachmentsView1");
        crsOutgoingDocAttachments.setWhereClause( OUTGOING_DOCUMENTS_FK+" = " + outgoingDocumentPk);
        crsOutgoingDocAttachments.executeQuery();
        int crsOutgoingDocAttachmentsCount = (int) crsOutgoingDocAttachments.getEstimatedRowCount();
        crsOutgoingDocAttachments.first();
        for (int i = 0; i < crsOutgoingDocAttachmentsCount; i++) {
        Row selectedcrsOutgoingDocAttachment = crsOutgoingDocAttachments.getCurrentRow();
        ViewObject crsIncomingDocAttachments = ADFUtils.getViewObjectFromAppModule("CrsIncomingDocAttachmentsView2");
        Row newCrsIncomingDocAttachments = crsIncomingDocAttachments.createRow();
        newCrsIncomingDocAttachments.setAttribute("AttachmentTypeFk",selectedcrsOutgoingDocAttachment.getAttribute("AttachmentTypeFk"));
        newCrsIncomingDocAttachments.setAttribute("IncomingDocumentsFk", incomingDocumentPk);
        newCrsIncomingDocAttachments.setAttribute("DisplayAttachmentTypeFk",selectedcrsOutgoingDocAttachment.getAttribute("DisplayAttachmentTypeFk"));
        newCrsIncomingDocAttachments.setAttribute("DisplayInAttachDesc", selectedcrsOutgoingDocAttachment.getAttribute("DisplayOutAttachDesc"));
        crsOutgoingDocAttachments.next();
        }
      }
      
      public void insertDataToIncomingDocCc(  Object incomingDocumentPk   , BigDecimal outgoingDocumentPk ) {
        ViewObjectImpl crsOutgoingDocCc =(ViewObjectImpl)ADFUtils.getDefaultApplicationModuleForDataControl().findViewObject("CrsOutgoingDocCcView1");
        crsOutgoingDocCc.setWhereClause( OUTGOING_DOCUMENTS_FK+" = " + outgoingDocumentPk);
        crsOutgoingDocCc.executeQuery();
        int crsOutgoingDocCcCount = (int) crsOutgoingDocCc.getEstimatedRowCount();
        crsOutgoingDocCc.first();
        for (int i = 0; i < crsOutgoingDocCcCount; i++) {
        ViewObject crsIncomingDocCc = ADFUtils.getViewObjectFromAppModule("CrsIncomingDocCcView2");
        Row selectedcrsOutgoingDocCc= crsOutgoingDocCc.getCurrentRow();
        Row newCrsIncomingDocCc = crsIncomingDocCc.createRow();
        newCrsIncomingDocCc.setAttribute("IncomingDocumentsFk", incomingDocumentPk);
        newCrsIncomingDocCc.setAttribute("ExecutionDateG",selectedcrsOutgoingDocCc.getAttribute("ExecutionDateG") );
        newCrsIncomingDocCc.setAttribute("ExecutionDateH", selectedcrsOutgoingDocCc.getAttribute("ExecutionDateH") );
        newCrsIncomingDocCc.setAttribute("ActionFk", selectedcrsOutgoingDocCc.getAttribute("ActionFk") );
        newCrsIncomingDocCc.setAttribute("DepartmentsFk", selectedcrsOutgoingDocCc.getAttribute("DepartmentsFk"));
        newCrsIncomingDocCc.setAttribute("DisplayNotes", selectedcrsOutgoingDocCc.getAttribute("DisplayNotes") );
        newCrsIncomingDocCc.setAttribute("EmployeeFk",selectedcrsOutgoingDocCc.getAttribute("EmployeeFk"));
        newCrsIncomingDocCc.setAttribute("DisplayIncomingDocGuidance",selectedcrsOutgoingDocCc.getAttribute("DisplayOutgoingDocGuidance") );
        newCrsIncomingDocCc.setAttribute("IncomingDocStsFk", Constants.CC_DOCUMENT_NEW);
        crsOutgoingDocCc.next();
        }
      }

      public void insertDataToIncomingRelatedLetters(  Object incomingDocumentPk   , BigDecimal outgoingDocumentPk ) {
        ViewObjectImpl crsOutgoingRelatedLetters =(ViewObjectImpl)ADFUtils.getDefaultApplicationModuleForDataControl().findViewObject("CrsOutgoingRelatedLettersView1");
        crsOutgoingRelatedLetters.setWhereClause( OUTGOING_DOCUMENTS_FK+" = " + outgoingDocumentPk);
        crsOutgoingRelatedLetters.executeQuery();
        int crsOutgoingRelatedLettersCount = (int) crsOutgoingRelatedLetters.getEstimatedRowCount();
        crsOutgoingRelatedLetters.first();
          for (int i = 0; i < crsOutgoingRelatedLettersCount; i++) {
            Row selectedcrsOutgoingRelatedLetters= crsOutgoingRelatedLetters.getCurrentRow();
            ViewObject crsIncomingRelatedLetters = ADFUtils.getViewObjectFromAppModule("CrsIncomingRelatedLettersView2");
            Row newCrsIncomingRelatedLetters= crsIncomingRelatedLetters.createRow();
            newCrsIncomingRelatedLetters.setAttribute("RelatedDocumentTypeFk",selectedcrsOutgoingRelatedLetters.getAttribute("RelatedDocumentTypeFk"));
            newCrsIncomingRelatedLetters.setAttribute("IncomingDocumentsFk", incomingDocumentPk);
            newCrsIncomingRelatedLetters.setAttribute("RelatedOutgoingDocumentsFk", selectedcrsOutgoingRelatedLetters.getAttribute("RelatedOutgoingDocumentFk"));
            newCrsIncomingRelatedLetters.setAttribute("RelatedIncomingDocumentFk",selectedcrsOutgoingRelatedLetters.getAttribute("RelatedIncomingDocumentsFk"));
          crsOutgoingRelatedLetters.next();
        }
      }
      
  public String viewAction() {
    RichPopup.PopupHints hints = new RichPopup.PopupHints();
    this.getOutDoc().show(hints);
    return null;
  }

  public void setOutDoc(RichPopup outDoc) {
    this.outDoc = outDoc;
  }

  public RichPopup getOutDoc() {
    return outDoc;
  }

  public void setDoc(RichDocument doc) {
    this.doc = doc;
  }

  public RichDocument getDoc() {
    return doc;
  }
}
