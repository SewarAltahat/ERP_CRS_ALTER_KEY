package crs.controller.bean;

import com.sd.util.adf.ADFUtils;
import com.sd.util.adf.JSFUtils;
import com.sd.util.db.DBUtil;
import com.sd.util.email.EmailMessage;

import gen.common.GenConstants;
import gen.common.GenLib;

import java.io.OutputStream;

import java.math.BigDecimal;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.RichDocument;
import oracle.adf.view.rich.component.rich.input.RichInputFile;
import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.adf.view.rich.event.DialogEvent;

import oracle.jbo.Key;
import oracle.jbo.Row;
import oracle.jbo.ViewObject;

import oracle.jbo.server.ViewObjectImpl;

import org.apache.myfaces.trinidad.model.UploadedFile;

public class SearchDocBean extends CrsBaseBean {
    private RichDocument doc;
    private String email;
    private String CC;
    private String BCC;
    private String subject;
    private String body;
    private RichInputFile uploadAttachment;
    private UploadedFile uploadedFile;
    private static final String DOCUMENT_ITERATOR = "DocumentVwView1Iterator";

    public SearchDocBean() {
        if (!AdfFacesContext.getCurrentInstance().isPostback()) {
            GenLib.filterDocumentsBySecurityLevels(DOCUMENT_ITERATOR, "SECURITY_LEVEL_FK");
            GenLib.filterDocumentsBySecurityLevels("ArchiveVwView1Iterator", "SECURITY_LEVEL_FK");
        }
    }

    public void downloadDocumentAttachment(FacesContext context, OutputStream os) {
        downloadFile(context, os, "ArchiveVwView1Iterator", "ArcFilePath");
    }

    //IN CASE LIKE THIS PREFER TO BE SWITCH NOT IF
    public String editRecord() {
        int documentType = DBUtil.nvl(ADFUtils.getAttribute(DOCUMENT_ITERATOR, "DocTypeFk"), 0);
        switch (documentType) {
        case GenConstants.INCOMING_DOCUMENT:
            return "indoc";
        case GenConstants.OUTGOING_DOCUMENT:
            return "outDoc";
        case GenConstants.OUTGOING_PREPARE_DOCUMENT:
            return "outDocPreparation";
        default:
            return null;
        }
    }
    
    public void viewAction() {
      showPopup(returnPouupName());
    }

  public String returnPouupName() {
    int documentType = DBUtil.nvl(ADFUtils.getAttribute(DOCUMENT_ITERATOR, "DocTypeFk"), 0);
    switch (documentType) {
    case GenConstants.INCOMING_DOCUMENT:
      return "inDocViewPopup";
    case GenConstants.OUTGOING_DOCUMENT:
      return"outDocViewPopup";
    case GenConstants.OUTGOING_PREPARE_DOCUMENT:
      return"outPreDocViewPopup";
    default:
        return null;
    }  
  }
    
    public void runReport(ActionEvent actionEvent) {
        crsRunReport(actionEvent, DOCUMENT_ITERATOR, "IncomingDocumentsPk", "CrsDocumentsPk");
    }

    public String insertDataToIncoming() {
        try {
            // Retrieve incoming document
            Row[] incomingDocuments = findIncomingDocument();

            // Create new outgoing document
            Row newOutgoing = createNewOutgoingDocument(incomingDocuments[0]);

            // Insert related data to outgoing document
            Object outgoingDocumentPk = newOutgoing.getAttribute("OutgoingDocumentsPk");
            insertDetailsToOutgoingDocument(outgoingDocumentPk , incomingDocuments[0].getAttribute("IncomingDocumentsPk"));

            // Update flag for Reply Action in incoming document
            updateReplyFlagInIncomingDocument(incomingDocuments);

            ADFUtils.commitWithoutMessage();
            JSFUtils.setRequestAttribute("DocumentsPk", outgoingDocumentPk);
            return "outDoc";
        } catch (Exception e) {
            // Rollback transaction in case of error
            ADFUtils.rollback();
            // Rethrow the exception or handle it accordingly
            throw new RuntimeException("Failed to insert data to incoming document.", e);
        }
    }

    private Row[] findIncomingDocument() {
        Object incomingDocumentsPk = ADFUtils.getAttribute(DOCUMENT_ITERATOR, "IncomingDocumentsPk");
        Key incomingDocumentsPkkey = new Key(new Object[] { incomingDocumentsPk });
        return ADFUtils.findIterator("CrsIncomingDocumentsView1Iterator")
                       .getViewObject()
                       .findByKey(incomingDocumentsPkkey, 1);
    }

    private Row createNewOutgoingDocument(Row incomingDocument) {
        ViewObject crsOutgoing = ADFUtils.getViewObjectFromAppModule("CrsOutgoingDocumentsView1");
        Row newOutgoing = crsOutgoing.createRow();
        // Copy attributes from incoming document to outgoing document
        transferFromIncomingToOutgoing(incomingDocument, newOutgoing);
        return newOutgoing;
    }

    private void transferFromIncomingToOutgoing(Row source, Row target) {
        target.setAttribute("OutDocYear", source.getAttribute("InDocYear"));
        target.setAttribute("OutDocDateG", source.getAttribute("InDocDateG"));
        target.setAttribute("OutDocDateH", source.getAttribute("InDocDateH"));
        target.setAttribute("OutDocTypeFk", source.getAttribute("InDocTypeFk"));
        target.setAttribute("OutgoingTypeFk", GenConstants.EXTERNAL_DEPARTMENT_TYPE);
        target.setAttribute("FromDepartmentFk", source.getAttribute("FromDepartmentFk"));
        target.setAttribute("ToDepartmentFk", source.getAttribute("ToDepartmentFk"));
        target.setAttribute("PriorityFk", source.getAttribute("PriorityFk"));
        target.setAttribute("SecurityLevelFk", source.getAttribute("SecurityLevelFk"));
        target.setAttribute("AttachmentsNo", source.getAttribute("AttachmentsNo"));
        target.setAttribute("FilesLocationFk", source.getAttribute("FilesLocationFk"));
        target.setAttribute("Barcode", source.getAttribute("Barcode"));
        target.setAttribute("RespondPeriod", source.getAttribute("RespondPeriod"));
        target.setAttribute("ReceivedDateG", source.getAttribute("ReceivedDateG"));
        target.setAttribute("ReceivedDateH", source.getAttribute("ReceivedDateH"));
        target.setAttribute("DisplayOutSubject", source.getAttribute("DisplayInSubject"));
        target.setAttribute("DisplayKeyword", source.getAttribute("DisplayKeyword"));
        target.setAttribute("ClassificationFk", source.getAttribute("ClassificationFk"));
        target.setAttribute("DisplayNotes", source.getAttribute("DisplayNotes"));
        target.setAttribute("OutgoingDocumentsNo", source.getAttribute("IncomingDocumentsNo"));
        target.setAttribute("DistributionTypeFk", source.getAttribute("DistributionTypeFk"));
        ADFUtils.commitWithoutMessage();
    }

    private void insertDetailsToOutgoingDocument(Object outgoingDocumentPk ,Object IncomingDocumentPk) {
        // Insert details to outgoing document
        insertIncommingDocumentArchive(outgoingDocumentPk,IncomingDocumentPk);
        insertIncommingDocumentBeneficiaries(outgoingDocumentPk,IncomingDocumentPk);
        insertIncommingDocumentComments(outgoingDocumentPk,IncomingDocumentPk);
        insertIncommingDocumentAttachment(outgoingDocumentPk,IncomingDocumentPk);
        insertIncommingDocumentRelatedLetters(outgoingDocumentPk,IncomingDocumentPk);
        insertIncommingDocumentCc(outgoingDocumentPk,IncomingDocumentPk);
    }

    private void updateReplyFlagInIncomingDocument(Row[] incomingDocumentRow) {
        // Update flag for Reply Action in incoming document
        incomingDocumentRow[0].setAttribute("ReplyFl", 1);
        ADFUtils.commitWithoutMessage();
    }

    //  Insert to Archive
    private void insertIncommingDocumentArchive(Object outgoingDocumentPk ,Object incomingDocumentPk ) {
      ViewObjectImpl crsIncomingArchive =(ViewObjectImpl)ADFUtils.getDefaultApplicationModuleForDataControl().findViewObject("CrsIncomingArchiveView1");
      crsIncomingArchive.setWhereClause(  "INCOMING_DOCUMENTS_FK = " + incomingDocumentPk);
      crsIncomingArchive.executeQuery();
      int crsIncomingArchivecount = (int) crsIncomingArchive.getEstimatedRowCount();
      crsIncomingArchive.first();
      for (int i = 0; i < crsIncomingArchivecount; i++) {
      Row selectedcrsIncomingArchive = crsIncomingArchive.getCurrentRow();
      ViewObject crsArchiveOutgoing = ADFUtils.getViewObjectFromAppModule("CrsOutgoingArchiveView2");
      Row newcrsArchiveOutgoing = crsArchiveOutgoing.createRow();
      newcrsArchiveOutgoing.setAttribute("ArcFilePath", selectedcrsIncomingArchive.getAttribute("ArcFilePath"));
      newcrsArchiveOutgoing.setAttribute("OutgoingDocumentsFk", outgoingDocumentPk);
      newcrsArchiveOutgoing.setAttribute("SecurityLevelFk", selectedcrsIncomingArchive.getAttribute("SecurityLevelFk"));
      newcrsArchiveOutgoing.setAttribute("DisplayArcDocName",selectedcrsIncomingArchive.getAttribute("DisplayArcDocName"));
      newcrsArchiveOutgoing.setAttribute("DisplayArcDocDesc",selectedcrsIncomingArchive.getAttribute("DisplayArcDocDesc"));
      crsIncomingArchive.next();
    }
    }
    
    // Insert to Beneficiaries
    private void insertIncommingDocumentBeneficiaries(Object outgoingDocumentPk ,Object incomingDocumentPk ) {
      ViewObjectImpl crsIncomingBeneficiaries =(ViewObjectImpl)ADFUtils.getDefaultApplicationModuleForDataControl().findViewObject("CrsIncomingBeneficiariesView1");
      crsIncomingBeneficiaries.setWhereClause(  "INCOMING_DOCUMENTS_FK = " + incomingDocumentPk);
      crsIncomingBeneficiaries.executeQuery();
      int crsIncomingBeneficiariescount = (int) crsIncomingBeneficiaries.getEstimatedRowCount();
      crsIncomingBeneficiaries.first();
      for (int i = 0; i < crsIncomingBeneficiariescount; i++) {
      Row selectedcrsIncomingBeneficiaries = crsIncomingBeneficiaries.getCurrentRow();
      ViewObject crsBeneficiariesOutgoing = ADFUtils.getViewObjectFromAppModule("CrsOutgoingBeneficiariesView3");
      Row newBeneficiariesOut = crsBeneficiariesOutgoing.createRow();
      newBeneficiariesOut.setAttribute("BeneficiariesFk",selectedcrsIncomingBeneficiaries.getAttribute("BeneficiariesFk"));
      newBeneficiariesOut.setAttribute("OutgoingDocumentsFk", outgoingDocumentPk);
      crsIncomingBeneficiaries.next();
        }
    }

    // insert to comment
    private void insertIncommingDocumentComments(Object outgoingDocumentPk ,Object incomingDocumentPk ) {
      ViewObjectImpl crsIncomingComments =(ViewObjectImpl)ADFUtils.getDefaultApplicationModuleForDataControl().findViewObject("CrsIncomingCommentsView1");
      crsIncomingComments.setWhereClause(  "INCOMING_DOCUMENTS_FK = " + incomingDocumentPk);
      crsIncomingComments.executeQuery();
      int crsIncomingCommentscount = (int) crsIncomingComments.getEstimatedRowCount();
      crsIncomingComments.first();
      for (int i = 0; i < crsIncomingCommentscount; i++) {
      Row selectedcrsIncomingComments = crsIncomingComments.getCurrentRow();
      ViewObject crsOutgoingComments = ADFUtils.getViewObjectFromAppModule("CrsOutgoingCommentsView2");
      Row newOutgoingComments = crsOutgoingComments.createRow();
      newOutgoingComments.setAttribute("OutgoingDocumentsFk", outgoingDocumentPk);
      newOutgoingComments.setAttribute("DisplayCommentValue",selectedcrsIncomingComments.getAttribute("DisplayCommentValue"));
      crsIncomingComments.next();
            }
    }

    //Insert to  Attachment
    private void insertIncommingDocumentAttachment(Object outgoingDocumentPk ,Object incomingDocumentPk ) {
      ViewObjectImpl crsIncomingDocAttachments =(ViewObjectImpl)ADFUtils.getDefaultApplicationModuleForDataControl().findViewObject("CrsIncomingDocAttachmentsView1");
      crsIncomingDocAttachments.setWhereClause(  "INCOMING_DOCUMENTS_FK = " + incomingDocumentPk);
      crsIncomingDocAttachments.executeQuery();
      int crsIncomingDocAttachmentsCount = (int) crsIncomingDocAttachments.getEstimatedRowCount();
      crsIncomingDocAttachments.first();
      for (int i = 0; i < crsIncomingDocAttachmentsCount; i++) {
      Row selectedcrsIncomingDocAttachments = crsIncomingDocAttachments.getCurrentRow();
      ViewObject OutgoingDocAttach = ADFUtils.getViewObjectFromAppModule("CrsOutgoingDocAttachmentsView2");
      Row newOutgoingDocAttach = OutgoingDocAttach.createRow();
      newOutgoingDocAttach.setAttribute("AttachmentTypeFk",selectedcrsIncomingDocAttachments.getAttribute("AttachmentTypeFk"));
      newOutgoingDocAttach.setAttribute("OutgoingDocumentsFk", outgoingDocumentPk);
      newOutgoingDocAttach.setAttribute("DisplayAttachmentTypeFk", selectedcrsIncomingDocAttachments.getAttribute("DisplayAttachmentTypeFk"));
      newOutgoingDocAttach.setAttribute("DisplayOutAttachDesc",selectedcrsIncomingDocAttachments.getAttribute("DisplayInAttachDesc"));
      crsIncomingDocAttachments.next();
        
            }
    }
    //Insert to  RelatedLetters
    private void insertIncommingDocumentRelatedLetters(Object outgoingDocumentPk ,Object incomingDocumentPk ) {
      ViewObjectImpl crsIncomingRelatedLetters =(ViewObjectImpl)ADFUtils.getDefaultApplicationModuleForDataControl().findViewObject("CrsIncomingRelatedLettersView1");
      crsIncomingRelatedLetters.setWhereClause(  "INCOMING_DOCUMENTS_FK = " + incomingDocumentPk);
      crsIncomingRelatedLetters.executeQuery();
      int crsIncomingRelatedLettersCount = (int) crsIncomingRelatedLetters.getEstimatedRowCount();
      crsIncomingRelatedLetters.first();
      for (int i = 0; i < crsIncomingRelatedLettersCount; i++) {
      Row selectedcrsIncomingRelatedLetters = crsIncomingRelatedLetters.getCurrentRow();
      ViewObject crsOutgoingRelatedLetters = ADFUtils.getViewObjectFromAppModule("CrsOutgoingRelatedLettersView2");
      Row newOutgoingRelated = crsOutgoingRelatedLetters.createRow();
      newOutgoingRelated.setAttribute("RelatedDocumentTypeFk",selectedcrsIncomingRelatedLetters.getAttribute("RelatedDocumentTypeFk"));
      newOutgoingRelated.setAttribute("OutgoingDocumentsFk", outgoingDocumentPk);
      newOutgoingRelated.setAttribute("DisplayDocDateG",selectedcrsIncomingRelatedLetters.getAttribute("DisplayDocDateG"));
      newOutgoingRelated.setAttribute("DisplayDocDateH", selectedcrsIncomingRelatedLetters.getAttribute("DisplayDocDateH"));
      newOutgoingRelated.setAttribute("RelatedOutgoingDocumentFk",selectedcrsIncomingRelatedLetters.getAttribute("RelatedOutgoingDocumentsFk"));
      newOutgoingRelated.setAttribute("RelatedIncomingDocumentsFk", selectedcrsIncomingRelatedLetters.getAttribute("RelatedIncomingDocumentFk"));
      crsIncomingRelatedLetters.next();
            }
        }

    //insert to Document CC
    private void insertIncommingDocumentCc(Object outgoingDocumentsPk,Object incomingDocumentPk ) {
      ViewObjectImpl crsIncomingDocCc =(ViewObjectImpl)ADFUtils.getDefaultApplicationModuleForDataControl().findViewObject("CrsIncomingDocCcView1");
      crsIncomingDocCc.setWhereClause(  "INCOMING_DOCUMENTS_FK = " + incomingDocumentPk);
      crsIncomingDocCc.executeQuery();
    int crsIncomingDocCcCount = (int) crsIncomingDocCc.getEstimatedRowCount();
    crsIncomingDocCc.first();
    for (int i = 0; i < crsIncomingDocCcCount; i++) {
      Row selectedcrsIncomingDocCc = crsIncomingDocCc.getCurrentRow();
      ViewObject crsOutgoingDocCc = ADFUtils.getViewObjectFromAppModule("CrsOutgoingDocCcView2");
      Row newCrsOutgoingDocCc = crsOutgoingDocCc.createRow();
      newCrsOutgoingDocCc.setAttribute("OutgoingDocumentsFk", outgoingDocumentsPk);
      newCrsOutgoingDocCc.setAttribute("ExecutionDateG", selectedcrsIncomingDocCc.getAttribute("ExecutionDateG"));
      newCrsOutgoingDocCc.setAttribute("ExecutionDateH", selectedcrsIncomingDocCc.getAttribute("ExecutionDateH"));
      newCrsOutgoingDocCc.setAttribute("ActionFk", selectedcrsIncomingDocCc.getAttribute("ActionFk"));
      newCrsOutgoingDocCc.setAttribute("DepartmentsFk", selectedcrsIncomingDocCc.getAttribute("DepartmentsFk"));
      newCrsOutgoingDocCc.setAttribute("DisplayNotes", selectedcrsIncomingDocCc.getAttribute("DisplayNotes"));
      newCrsOutgoingDocCc.setAttribute("EmployeeFk", selectedcrsIncomingDocCc.getAttribute("EmployeeFk"));
      newCrsOutgoingDocCc.setAttribute("DisplayOutgoingDocGuidance",selectedcrsIncomingDocCc.getAttribute("DisplayIncomingDocGuidance"));
      crsIncomingDocCc.next();
            }   
    }


    public void uploadFile(ValueChangeEvent valueChangeEvent) {
        try {
            ADFUtils.executeOperator("CreateInsert");
            String filePath = GenLib.getUploadPathSuffix();
            uploadFile(valueChangeEvent, "EmailAttachRo1Iterator", "FileName");
            ADFUtils.setAttribute("EmailAttachRo1Iterator", "FilePath", filePath);
            uploadAttachment.setValue(null);
        } catch (Exception e) {
            GenLib.handleException(e);
        }
    }

    public void sendEmailDialog(@SuppressWarnings("oracle.jdeveloper.java.unused-parameter") DialogEvent dialogEvent) {
        EmailMessage message = new EmailMessage();
        String[] to = new String[1];
        to[0] = getEmail();
        String[] cc = new String[1];
        cc[0] = getCC();
        String[] bcc = new String[1];
        bcc[0] = getBCC();
        message.setSubject(getSubject());
        message.setMessageText(getBody());
        message.setTo(to);
        message.setCc(cc);
        message.setBcc(bcc);
        message.setAttachmentFileList(getFilesAttachmentPaths());
        GenLib.sendMail(message);
        GenLib.showSuccessMessage("message.success");
    }

    private String[][] getFilesAttachmentPaths() {
        DCIteratorBinding emailAttachRoIter = ADFUtils.findIterator("EmailAttachRo1Iterator");
        String[][] arrFileAttachPaths = null;
        int emailAttachRoIterRowCount = emailAttachRoIter.getViewObject().getRowCount();
        if (emailAttachRoIterRowCount == 0) {
            return arrFileAttachPaths;
        }
        arrFileAttachPaths = new String[emailAttachRoIterRowCount][2];
        for (int i = 0; i < emailAttachRoIterRowCount; i++) {
            Row fileAttachrow = emailAttachRoIter.getRowAtRangeIndex(i);
            if (fileAttachrow != null) {
                arrFileAttachPaths[i][GenConstants.FILE_NAME] = (String) fileAttachrow.getAttribute("FileName");
                arrFileAttachPaths[i][GenConstants.FILE_PATH] = (String) fileAttachrow.getAttribute("FilePath");
            }
        }
        return arrFileAttachPaths;
    }

    public String getBody() {
        String fromDepartmentFkLabel = GenLib.getMessage("DocumentVw.FromDepartmentFk");
        String inDocNoLabel = GenLib.getMessage("DocumentVw.InDocNo");
        String subjectLabel = GenLib.getMessage("DocumentVw.Subject");
        Object displayFromDepartmentFk = ADFUtils.getAttribute(DOCUMENT_ITERATOR, "DisplayFromDepartmentFk");
        Object inDocNo = ADFUtils.getAttribute(DOCUMENT_ITERATOR, "InDocNo");
        Object subject = ADFUtils.getAttribute(DOCUMENT_ITERATOR, "DisplaySubjectDoc");
        int rtl = GenLib.getIsRTL();
        String dir = "dir='ltr'";
        if (rtl == 1) {
            dir = "dir='rtl'";
        }
        String emailMessage =
            "<br/><br/><center>" + "<table align='center' border='1' width='500px' " + dir + ">" + "<tr>" +
            "<th><h3><font color='#0000ff'>" + fromDepartmentFkLabel + "</font></h3></th>" +
            "<th><h3><font color='#0000ff'>" + inDocNoLabel + "</font></h3></th>" + "<th><h3><font color='#0000ff'>" +
            subjectLabel + "</font></h3></th>" + "</tr>" +

            "<tr align='center'>" + "<td><font size='3'>" + displayFromDepartmentFk + "</font></td>" +
            "<td><font size='3'>" + inDocNo + "</font></td>" + "<td><font size='3'>" + subject + "</font></td>" +
            "</tr>" + "</table>" + "<br/><br/>" + "</center>" + "<br/></br/>";
        return emailMessage;
    }

    public void setDoc(RichDocument doc) {
        this.doc = doc;
    }

    public RichDocument getDoc() {
        return doc;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public RichInputFile getUploadAttachment() {
        return uploadAttachment;
    }

    public void setUploadAttachment(RichInputFile uploadAttachment) {
        this.uploadAttachment = uploadAttachment;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setCC(String CC) {
        this.CC = CC;
    }

    public String getCC() {
        return CC;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setBCC(String BCC) {
        this.BCC = BCC;
    }

    public String getBCC() {
        return BCC;
    }

    public void setUploadedFile(UploadedFile uploadedFile) {
        this.uploadedFile = uploadedFile;
    }

    public UploadedFile getUploadedFile() {
        return uploadedFile;
    }
}
