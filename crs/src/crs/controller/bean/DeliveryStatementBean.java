package crs.controller.bean;

import com.sd.util.adf.ADFUtils;
import com.sd.util.db.DBUtil;

import gen.common.GenConstants;
import gen.common.GenLib;

import java.math.BigDecimal;

import javax.faces.event.ActionEvent;

import oracle.adf.view.rich.component.rich.RichDocument;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.jbo.Row;
import oracle.jbo.ViewObject;
import oracle.jbo.server.DBTransaction;

public class DeliveryStatementBean extends CrsBaseBean {
  private RichDocument doc;
  private static final String  INCOMING_DOCUMENT_ITERATOR = "CrsIncomingDocumentsView1Iterator";
  private static final String  OUTGOING_DOCUMENT_ITERATOR = "CrsOutgoingDocumentsView1Iterator";
  private static final String  DELIVERY_DOCUMENT_PVO_ITERATOR = "DeliverySelectedDocumentsPVO1Iterator";
  
  public DeliveryStatementBean(){
    if (!AdfFacesContext.getCurrentInstance().isPostback()) {
      GenLib.filterDocumentsBySecurityLevels(OUTGOING_DOCUMENT_ITERATOR, "SECURITY_LEVEL_FK");
      GenLib.filterDocumentsBySecurityLevels(INCOMING_DOCUMENT_ITERATOR, "SECURITY_LEVEL_FK");
    }
  }
  
  public String viewIncomingDocuments(ActionEvent actionEvent) {
    
    BigDecimal incomingDocumentsPk = (BigDecimal) ADFUtils.getAttribute(INCOMING_DOCUMENT_ITERATOR,
        "IncomingDocumentsPk");
    BigDecimal incomingDocumentsNo = (BigDecimal) ADFUtils.getAttribute(INCOMING_DOCUMENT_ITERATOR, 
        "IncomingDocumentsNo");
    
    boolean isDocAddedResult = isDocAdded(INCOMING_DOCUMENT_ITERATOR, "IncomingDocumentsPk", 
        new BigDecimal(GenConstants.INCOMING_DOCUMENT), "IncomingInsertFl");

    if (isDocAddedResult) {
      GenLib.showErrorMessage("error.OperationExcists");
      return null;  
    }

    insertDeliverySelectedDocumentsPvo(incomingDocumentsPk, incomingDocumentsNo ,new BigDecimal(GenConstants.INCOMING_DOCUMENT) ) ;
    
    return null;
  }

  public void insertDeliverySelectedDocumentsPvo
        (BigDecimal documentsPk, BigDecimal documentsNo , BigDecimal documentType) {
    ViewObject deliverySelectedDocumentsPvo = ADFUtils.findIterator(DELIVERY_DOCUMENT_PVO_ITERATOR).getViewObject();
    Row rowDeliveryDocumentPvo = deliverySelectedDocumentsPvo.createRow();

    rowDeliveryDocumentPvo.setAttribute("DocumentPk", documentsPk);
    rowDeliveryDocumentPvo.setAttribute("DocumentType", documentType);
    rowDeliveryDocumentPvo.setAttribute("DocumentNo", documentsNo);

    deliverySelectedDocumentsPvo.insertRow(rowDeliveryDocumentPvo);
  }
    
  public String viewOutgoingDocuments(ActionEvent actionEvent) {
    
    BigDecimal outDocNo = (BigDecimal) ADFUtils.getAttribute(OUTGOING_DOCUMENT_ITERATOR, "OutgoingDocumentsNo");
    BigDecimal outgoingDocumentsPk = (BigDecimal) ADFUtils.getAttribute(OUTGOING_DOCUMENT_ITERATOR, "OutgoingDocumentsPk");

    boolean isDocAddedResult = isDocAdded(OUTGOING_DOCUMENT_ITERATOR, "OutgoingDocumentsPk", 
                                          new BigDecimal(GenConstants.OUTGOING_DOCUMENT), "OutgoingInsertFl");
    
    if (isDocAddedResult){
      return null;
    }
    
    insertDeliverySelectedDocumentsPvo(outgoingDocumentsPk, outDocNo ,new BigDecimal(GenConstants.OUTGOING_DOCUMENT) ) ;

    return null;
  }
  

  public void insertSelectedCrsDocDelivery(ActionEvent actionEvent) {
    
    DBTransaction dbt = ADFUtils.getDefaultDBTransaction();
    ADFUtils.findIterator(DELIVERY_DOCUMENT_PVO_ITERATOR).setRangeSize(-1);

    Row[] selectedDeliveryDocRows = ADFUtils.findIterator(DELIVERY_DOCUMENT_PVO_ITERATOR).getAllRowsInRange();
    BigDecimal statementNumber = GenLib.getNextMax(dbt, "CRS_DOCUMENTS_DELIVERY", "STATEMENT_NUMBER");
        
    for (int i = 0; i < selectedDeliveryDocRows.length; i++) {
      
      try {
          BigDecimal incomingDocumentsPk = null;
          BigDecimal outgoingDocumentsPk = null;
          BigDecimal deliveryTypeFk = (BigDecimal)selectedDeliveryDocRows[i].getAttribute("DocumentType");
       
        if (deliveryTypeFk.equals( new BigDecimal(GenConstants.OUTGOING_DOCUMENT))) {
          outgoingDocumentsPk = (BigDecimal)selectedDeliveryDocRows[i].getAttribute("DocumentPk");
        } else if (deliveryTypeFk.equals(new BigDecimal(GenConstants.INCOMING_DOCUMENT))){
          incomingDocumentsPk = (BigDecimal) selectedDeliveryDocRows[i].getAttribute("DocumentPk");
        }

        String insertDocumentDeliverySql =
          "insert into CRS_DOCUMENTS_DELIVERY (DOCUMENTS_DELIVERY_PK, DELIVERY_TYPE_FK, " +
          "INCOMING_DOCUMENTS_FK , OUTGOING_DOCUMENTS_FK , CREATED_BY, CREATION_DATE, STATEMENT_NUMBER, USER_DEPARTMENT_FK) " +
          "values (null, " + deliveryTypeFk + ", " + incomingDocumentsPk + ", " + outgoingDocumentsPk + ", " +
          GenLib.getUserId() + ", " + "current_timestamp, " + statementNumber + ", " + GenLib.getUserLoginDepartment() +
          ")";
        DBUtil.executeDML(insertDocumentDeliverySql);
      } catch (Exception e) {
        GenLib.handleException(e);
      }
    }
    
    ADFUtils.commitWithoutMessage();
    ADFUtils.findIterator(DELIVERY_DOCUMENT_PVO_ITERATOR).executeQuery(); 
    ADFUtils.setAttribute("ReportParametersRVO1Iterator", "StatementNumber", statementNumber);
    
    super.runReport(actionEvent);
  }
   
  public boolean isDocAdded
        (String iteratorName , String documentPkAttribute , BigDecimal documentType , String selectFlagName) { 
    Object selectedDocumentPK = ADFUtils.getAttribute(iteratorName, documentPkAttribute);
    ADFUtils.findIterator(DELIVERY_DOCUMENT_PVO_ITERATOR).setRangeSize(-1);
    Row[] deliverySelectedRows = ADFUtils.findIterator(DELIVERY_DOCUMENT_PVO_ITERATOR).getAllRowsInRange();
    
    if (deliverySelectedRows.length != 0) {
      for (int j = 0; j < deliverySelectedRows.length; j++) {
        if (deliverySelectedRows[j].getAttribute("DocumentPk").equals(selectedDocumentPK) &&
            deliverySelectedRows[j].getAttribute("DocumentType").equals(documentType)) {
          ADFUtils.setAttribute(iteratorName, selectFlagName, 0);
         
          return true;
        }
      }
    }
    
    return false;
  }

  public void setDoc(RichDocument doc){
    this.doc = doc;
  }

  public RichDocument getDoc() {
    return doc;
  }
}