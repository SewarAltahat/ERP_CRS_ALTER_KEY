package crs.controller.bean;


public class CrsTaskListBean extends CrsBaseBean
{
  private static final String  CRS_INCOMING_DOCUMENT_ITERATOR = "CrsIncomingDocumentsView1Iterator";
  private static final String  CRS_INCOMING_DOCUMENT_TL_ITERATOR = "CrsIncomingDocumentsTlView1Iterator";
  private static final String  CRS_INCOMING_BENEFICIARIES_ITERATOR = "CrsIncomingBeneficiariesView1Iterator";
  private static final String  CRS_INCOMING_BENEFICIARIES_TL_ITERATOR = "CrsIncomingBeneficiariesTlView1Iterator";
  private static final String  INCOMING_RELATED_LETTER_ITERATOR = "CrsIncomingRelatedLettersView1Iterator";
  private static final String  INCOMING_RELATED_LETTER_TL_ITERATOR = "CrsIncomingRelatedLettersTlView1Iterator";
  private static final String  CRS_OUTGOING_DOCUMENT_ITERATOR = "CrsOutgoingDocumentsView1Iterator";
  private static final String  CRS_OUTGOING_DOCUMENT_TL_ITERATOR = "CrsOutgoingDocumentsTlView1Iterator";


  public void displayInDocTypeFkChanged(javax.faces.event.ValueChangeEvent vce){
    masterTranslationChanged(vce, CRS_INCOMING_DOCUMENT_ITERATOR, "null", 
                             CRS_INCOMING_DOCUMENT_TL_ITERATOR, "InDocTypeFk");
  }

  public void displayIncomingTypeFkChanged(javax.faces.event.ValueChangeEvent vce){
    masterTranslationChanged(vce, CRS_INCOMING_DOCUMENT_ITERATOR, "null", 
                             CRS_INCOMING_DOCUMENT_TL_ITERATOR, "IncomingTypeFk");
  }

  public void displayFromDepartmentFkChanged(javax.faces.event.ValueChangeEvent vce){
    masterTranslationChanged(vce, CRS_INCOMING_DOCUMENT_ITERATOR, "null", 
                             CRS_INCOMING_DOCUMENT_TL_ITERATOR, "FromDepartmentFk");
  }

  public void displayToDepartmentFkChanged(javax.faces.event.ValueChangeEvent vce){
    masterTranslationChanged(vce, CRS_INCOMING_DOCUMENT_ITERATOR, "null", 
                             CRS_INCOMING_DOCUMENT_TL_ITERATOR, "ToDepartmentFk");
  }

  public void displayPriorityFkChanged(javax.faces.event.ValueChangeEvent vce){
    masterTranslationChanged(vce, CRS_INCOMING_DOCUMENT_ITERATOR, "null", 
                             CRS_INCOMING_DOCUMENT_TL_ITERATOR, "PriorityFk");
  }

  public void displaySecurityLevelFkChanged(javax.faces.event.ValueChangeEvent vce){
    masterTranslationChanged(vce, CRS_INCOMING_DOCUMENT_ITERATOR, "null", 
                             CRS_INCOMING_DOCUMENT_TL_ITERATOR, "SecurityLevelFk");
  }

  public void displayFilesLocationFkChanged(javax.faces.event.ValueChangeEvent vce){
    masterTranslationChanged(vce, CRS_INCOMING_DOCUMENT_ITERATOR, "null", 
                             CRS_INCOMING_DOCUMENT_TL_ITERATOR, "FilesLocationFk");
  }

  public void displayInSubjectChanged(javax.faces.event.ValueChangeEvent vce){
    masterTranslationChanged(vce, CRS_INCOMING_DOCUMENT_ITERATOR, "null", 
                             CRS_INCOMING_DOCUMENT_TL_ITERATOR, "InSubject");
  }

  public void displayKeywordChanged(javax.faces.event.ValueChangeEvent vce){
    masterTranslationChanged(vce, CRS_INCOMING_DOCUMENT_ITERATOR, "null", 
                             CRS_INCOMING_DOCUMENT_TL_ITERATOR, "Keyword");
  }

  public void displayClassificationFkChanged(javax.faces.event.ValueChangeEvent vce){
    masterTranslationChanged(vce, CRS_INCOMING_DOCUMENT_ITERATOR, "null", 
                             CRS_INCOMING_DOCUMENT_TL_ITERATOR, "ClassificationFk");
  }

  public void displayNotesChanged(javax.faces.event.ValueChangeEvent vce){
    masterTranslationChanged(vce, CRS_INCOMING_DOCUMENT_ITERATOR, "null", 
                             CRS_INCOMING_DOCUMENT_TL_ITERATOR, "Notes");
  }

  public void displayCommentValueChanged(javax.faces.event.ValueChangeEvent vce){
    masterTranslationChanged(vce, "CrsIncomingCommentsView1Iterator", "null", 
                             "CrsIncomingCommentsTlView1Iterator", "CommentValue");
  }

  public void displayArcDocNameChanged(javax.faces.event.ValueChangeEvent vce){
    masterTranslationChanged(vce, "CrsIncomingArchiveView1Iterator", "null", 
                             "CrsIncomingArchiveTlView1Iterator", "ArcDocName");
  }

  public void displayArcDocDescChanged(javax.faces.event.ValueChangeEvent vce){
    masterTranslationChanged(vce, "CrsIncomingArchiveView1Iterator", "null", 
                             "CrsIncomingArchiveTlView1Iterator", "ArcDocDesc");
  }

  public void displayBeneficiariesFkChanged(javax.faces.event.ValueChangeEvent vce){
    masterTranslationChanged(vce, CRS_INCOMING_BENEFICIARIES_ITERATOR, "null", 
                             CRS_INCOMING_BENEFICIARIES_TL_ITERATOR, "BeneficiariesFk");
  }

  public void displayBeneficiarieBeneficiaryIdChanged(javax.faces.event.ValueChangeEvent vce){
    masterTranslationChanged(vce, CRS_INCOMING_BENEFICIARIES_ITERATOR, "null", 
                             CRS_INCOMING_BENEFICIARIES_TL_ITERATOR, "BeneficiarieBeneficiaryId");
  }

  public void displayBeneficiarieEmailChanged(javax.faces.event.ValueChangeEvent vce) {
    masterTranslationChanged(vce, CRS_INCOMING_BENEFICIARIES_ITERATOR, "null", 
                             CRS_INCOMING_BENEFICIARIES_TL_ITERATOR, "BeneficiarieEmail");
  }

  public void displayBeneficiarieMobileNoChanged(javax.faces.event.ValueChangeEvent vce) {
    masterTranslationChanged(vce, CRS_INCOMING_BENEFICIARIES_ITERATOR, "null", 
                             CRS_INCOMING_BENEFICIARIES_TL_ITERATOR, "BeneficiarieMobileNo");
  }

  public void displayRequestReasonChanged(javax.faces.event.ValueChangeEvent vce){
    masterTranslationChanged(vce, "CrsBorrowRequestsView1Iterator", "null", 
                             "CrsBorrowRequestsTlView1Iterator", "RequestReason");
  }

  public void displayAttachmentTypeFkChanged(javax.faces.event.ValueChangeEvent vce){
    masterTranslationChanged(vce, "CrsIncomingDocAttachmentsView1Iterator", "null", 
                             "CrsIncomingDocAttachmentsTlView1Iterator", "AttachmentTypeFk");
  }

  public void displayInAttachDescChanged(javax.faces.event.ValueChangeEvent vce){
    masterTranslationChanged(vce, "CrsIncomingDocAttachmentsView1Iterator", "null", 
                             "CrsIncomingDocAttachmentsTlView1Iterator", "InAttachDesc");
  }

  public void displayDepartmentsFkChanged(javax.faces.event.ValueChangeEvent vce){
    masterTranslationChanged(vce, "CrsIncomingDocCcView1Iterator", "null", 
                             "CrsIncomingDocCcTlView1Iterator", "DepartmentsFk");
  }

  public void displayActionFkChanged(javax.faces.event.ValueChangeEvent vce){
    masterTranslationChanged(vce, "CrsIncomingDocCcView1Iterator", "null", 
                             "CrsIncomingDocCcTlView1Iterator", "ActionFk");
  }

  public void displayRelatedIncomingDocumentFkChanged(javax.faces.event.ValueChangeEvent vce){
    masterTranslationChanged(vce, INCOMING_RELATED_LETTER_ITERATOR, "null", 
                             INCOMING_RELATED_LETTER_TL_ITERATOR, "RelatedIncomingDocumentFk");
  }

  public void displayDocDateHChanged(javax.faces.event.ValueChangeEvent vce){
    masterTranslationChanged(vce, INCOMING_RELATED_LETTER_ITERATOR, "null",
                             INCOMING_RELATED_LETTER_TL_ITERATOR, "DocDateH");
  }

  public void displayDocNoChanged(javax.faces.event.ValueChangeEvent vce){
    masterTranslationChanged(vce, INCOMING_RELATED_LETTER_ITERATOR, "null", 
                             INCOMING_RELATED_LETTER_TL_ITERATOR, "DocNo");
  }

  public void displayOutgoingTypeFkChanged(javax.faces.event.ValueChangeEvent vce){
    masterTranslationChanged(vce, CRS_OUTGOING_DOCUMENT_ITERATOR, "null", 
                             CRS_OUTGOING_DOCUMENT_TL_ITERATOR, "OutgoingTypeFk");
  }

  public void displayOutDocTypeFkChanged(javax.faces.event.ValueChangeEvent vce){
    masterTranslationChanged(vce, CRS_OUTGOING_DOCUMENT_ITERATOR, "null", 
                             CRS_OUTGOING_DOCUMENT_TL_ITERATOR, "OutDocTypeFk");
  }

  public void displayOutSubjectChanged(javax.faces.event.ValueChangeEvent vce){
    masterTranslationChanged(vce, CRS_OUTGOING_DOCUMENT_ITERATOR, "null", 
                             CRS_OUTGOING_DOCUMENT_TL_ITERATOR, "OutSubject");
  }

  public void displayTopicClassficationFkChanged(javax.faces.event.ValueChangeEvent vce){
    masterTranslationChanged(vce, "CrsOutgoingDocPreparationView1Iterator", "null", 
                             "CrsOutgoingDocPreparationTlView1Iterator", "TopicClassficationFk");
  }
}