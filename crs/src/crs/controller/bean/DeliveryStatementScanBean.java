package crs.controller.bean;

import com.sd.util.adf.ADFUtils;

import crs.common.ScannerUtils;

import crs.model.eo.CrsIncomingArchiveTlImpl;
import crs.model.eo.CrsOutgoingArchiveTlImpl;

import gen.common.GenConstants;
import gen.common.GenLib;

import java.math.BigDecimal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;


import java.sql.SQLException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.util.Map;

import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import oracle.adf.view.rich.component.rich.RichDocument;
import oracle.adf.view.rich.render.ClientEvent;

import oracle.jbo.server.DBTransactionImpl;

import oracle.jbo.server.EntityDefImpl;


public class DeliveryStatementScanBean
  extends CrsBaseBean
{
  private RichDocument doc;
  private static final String DELIVERY_STATEMENT_ATTACHED_ITERATOR="DeliveryStatmentAttachPVO1Iterator";
   //Upload files method
  public void uploadAttachment(ValueChangeEvent valueChangeEvent) {
  
    uploadFile(valueChangeEvent, DELIVERY_STATEMENT_ATTACHED_ITERATOR, "FilePath");
  }


    //Insert to incoming/outgoing Archive based on Dilivery Type
  public void insertIntoArchive(ActionEvent actionEvent)
  {
    BigDecimal statementNo = (BigDecimal) ADFUtils.getAttribute("DeliveryStatmentAttachPVO1Iterator", "StatementNo");
    String filePath = (String) ADFUtils.getAttribute("DeliveryStatmentAttachPVO1Iterator", "FilePath");
    if (statementNo != null && filePath != null)
    {
      DBTransactionImpl dbTransaction = (DBTransactionImpl) ADFUtils.getDefaultDBTransaction(); // Integration point
      boolean showFlag = false;
      try
      {
        List<Map<String, Object>> documentsInfo = retrieveDocumentsInfo(statementNo, dbTransaction);
        for (Map<String, Object> documentInfo: documentsInfo)
        {
          Integer deliveryType = (Integer) documentInfo.get("DELIVERY_TYPE_FK");
          BigDecimal documentPk =
            (BigDecimal) documentInfo.get(deliveryType == GenConstants.INCOMING_DOCUMENT? "INCOMING_DOCUMENTS_FK":
                                          "OUTGOING_DOCUMENTS_FK");
          insertDocumentArchive(deliveryType, documentPk, filePath, statementNo, dbTransaction);
          showFlag = true;
        }
        if (!showFlag)
        {
          GenLib.showErrorMessage("error.DeliveryNotUsed");
        }
        else
        {
          ADFUtils.commit();
        }
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
      finally
      {
        ADFUtils.setAttribute("DeliveryStatmentAttachPVO1Iterator", "FilePath", null);
        ADFUtils.setAttribute("DeliveryStatmentAttachPVO1Iterator", "StatementNo", null);
      }
    }
  }

  private List<Map<String, Object>> retrieveDocumentsInfo(BigDecimal statementNo, DBTransactionImpl dbTransaction)
    throws SQLException
  {
    String retreiveDocumentByStatementNumberSQL =
      "SELECT DELIVERY_TYPE_FK, OUTGOING_DOCUMENTS_FK, INCOMING_DOCUMENTS_FK " + "FROM CRS_DOCUMENTS_DELIVERY " +
      "WHERE STATEMENT_NUMBER = ?";
    try (PreparedStatement statement = dbTransaction.createPreparedStatement(retreiveDocumentByStatementNumberSQL, 1))
    {
      statement.setBigDecimal(1, statementNo);
      try (ResultSet resultSet = statement.executeQuery())
      {
        List<Map<String, Object>> documentsInfo = new ArrayList<>();
        while (resultSet.next())
        {
          Map<String, Object> info = new HashMap<>();
          info.put("DELIVERY_TYPE_FK", resultSet.getInt("DELIVERY_TYPE_FK"));
          info.put("INCOMING_DOCUMENTS_FK", resultSet.getBigDecimal("INCOMING_DOCUMENTS_FK"));
          info.put("OUTGOING_DOCUMENTS_FK", resultSet.getBigDecimal("OUTGOING_DOCUMENTS_FK"));
          documentsInfo.add(info);
        }
        return documentsInfo;
      }
    }
  }

  private void insertDocumentArchive(int deliveryType, BigDecimal documentPk, String filePath, BigDecimal statementNo,
                                     DBTransactionImpl dbTransaction)
  {
    String statementName = GenLib.getMessage("label.deliverystatement");
    try
    {
      BigDecimal archivePk = gen.common.GenLib.getPrimaryKeyValue(dbTransaction, deliveryType == GenConstants.INCOMING_DOCUMENT ? "CRS_INCOMING_ARCHIVE_SEQ": "CRS_OUTGOING_ARCHIVE_SEQ");
      String tableName = deliveryType == GenConstants.INCOMING_DOCUMENT? "CRS_INCOMING_ARCHIVE": "CRS_OUTGOING_ARCHIVE";

      String insertDocumentArchiveSql =
        "INSERT INTO " + tableName + " (ARC_FILE_PATH, " +
        (deliveryType == GenConstants.INCOMING_DOCUMENT? "INCOMING_DOCUMENTS_FK": "OUTGOING_DOCUMENTS_FK") +
        ", CREATED_BY, CREATION_DATE, USER_DEPARTMENT_FK) " + "VALUES (?, ?, ?, current_timestamp, ?)";
      try (PreparedStatement statement = dbTransaction.createPreparedStatement(insertDocumentArchiveSql, 1))
      {
        statement.setString(1, filePath);
        statement.setBigDecimal(2, documentPk);
        statement.setObject(3, GenLib.getUserId());
        statement.setObject(4, GenLib.getUserLoginDepartment());
        statement.executeUpdate();
      }

      EntityDefImpl def =
        deliveryType == GenConstants.INCOMING_DOCUMENT ? CrsIncomingArchiveTlImpl.getDefinitionObject():
        CrsOutgoingArchiveTlImpl.getDefinitionObject();
      List<Integer> languages = gen.common.GenLib.getActiveDataLanguages(dbTransaction);
      for (int lang: languages)
      {
        if (deliveryType == GenConstants.INCOMING_DOCUMENT)
        {
          CrsIncomingArchiveTlImpl tl = (CrsIncomingArchiveTlImpl) def.createInstance2(dbTransaction, null);
          tl.setLanguagesFk(new BigDecimal(lang));
          tl.setArcDocName(statementName + " " + statementNo);
          tl.setIncomingArchiveFk(archivePk);
        }
        else
        {
          CrsOutgoingArchiveTlImpl tl = (CrsOutgoingArchiveTlImpl) def.createInstance2(dbTransaction, null);
          tl.setLanguagesFk(new BigDecimal(lang));
          tl.setArcDocName(statementName + " " + statementNo);
          tl.setOutgoingArchiveFk(archivePk);
        }
      }
    }
    catch (Exception e)
    {
      GenLib.handleException(e);
    }
  }

  //method to refresh scanner
  public void refreshFromScanner(ClientEvent clientEvent)
  {
    ScannerUtils.updateUploadPath(clientEvent, DELIVERY_STATEMENT_ATTACHED_ITERATOR, "FilePath",
                                  "DeliveryStatmentAttachPVO1");

  }

  // Accessor
  public void setDoc(RichDocument doc)
  {

    this.doc = doc;
  }

  public RichDocument getDoc()
  {

    return doc;
  }
}
