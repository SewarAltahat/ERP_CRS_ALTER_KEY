package crs.model.eo;

import gen.common.GenConstants;
import gen.common.GenLib;

import java.math.BigDecimal;

import java.sql.Timestamp;

import oracle.jbo.JboException;
import oracle.jbo.Key;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.EntityImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Sat Apr 01 13:34:12 GMT+03:00 2023
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class CrsIncomingRelatedLettersImpl
  extends AuditEntityImpl
{
  /**
   * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
   */
  protected enum AttributesEnum
  {
    IncomingRelatedLettersPk,
    IncomingDocumentsFk,
    RelatedIncomingDocumentFk,
    CreatedBy,
    CreationDate,
    ModifiedBy,
    ModifiedDate,
    UserDepartmentFk,
    RelatedOutgoingDocumentsFk,
    RelatedDocumentTypeFk,
    CrsIncomingDocuments,
    CrsIncomingDocuments1,
    CrsOutgoingDocuments;
    private static AttributesEnum[] vals = null;
    private static final int firstIndex = 0;

    protected int index()
    {
      return AttributesEnum.firstIndex() + ordinal();
    }

    protected static final int firstIndex()
    {
      return firstIndex;
    }

    protected static int count()
    {
      return AttributesEnum.firstIndex() + AttributesEnum.staticValues().length;
    }

    protected static final AttributesEnum[] staticValues()
    {
      if (vals == null)
      {
        vals = AttributesEnum.values();
      }
      return vals;
    }
  }


  public static final int INCOMINGRELATEDLETTERSPK = AttributesEnum.IncomingRelatedLettersPk.index();
  public static final int INCOMINGDOCUMENTSFK = AttributesEnum.IncomingDocumentsFk.index();
  public static final int RELATEDINCOMINGDOCUMENTFK = AttributesEnum.RelatedIncomingDocumentFk.index();
  public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
  public static final int CREATIONDATE = AttributesEnum.CreationDate.index();
  public static final int MODIFIEDBY = AttributesEnum.ModifiedBy.index();
  public static final int MODIFIEDDATE = AttributesEnum.ModifiedDate.index();
  public static final int USERDEPARTMENTFK = AttributesEnum.UserDepartmentFk.index();
  public static final int RELATEDOUTGOINGDOCUMENTSFK = AttributesEnum.RelatedOutgoingDocumentsFk.index();
  public static final int RELATEDDOCUMENTTYPEFK = AttributesEnum.RelatedDocumentTypeFk.index();
  public static final int CRSINCOMINGDOCUMENTS = AttributesEnum.CrsIncomingDocuments.index();
  public static final int CRSINCOMINGDOCUMENTS1 = AttributesEnum.CrsIncomingDocuments1.index();
  public static final int CRSOUTGOINGDOCUMENTS = AttributesEnum.CrsOutgoingDocuments.index();

  /**
   * This is the default constructor (do not remove).
   */
  public CrsIncomingRelatedLettersImpl()
  {
  }

  /**
   * @return the definition object for this instance class.
   */
  public static synchronized EntityDefImpl getDefinitionObject()
  {
    return EntityDefImpl.findDefObject("crs.model.eo.CrsIncomingRelatedLetters");
  }


  /**
   * Gets the attribute value for IncomingRelatedLettersPk, using the alias name IncomingRelatedLettersPk.
   * @return the value of IncomingRelatedLettersPk
   */
  public BigDecimal getIncomingRelatedLettersPk()
  {
    return (BigDecimal) getAttributeInternal(INCOMINGRELATEDLETTERSPK);
  }

  /**
   * Sets <code>value</code> as the attribute value for IncomingRelatedLettersPk.
   * @param value value to set the IncomingRelatedLettersPk
   */
  public void setIncomingRelatedLettersPk(BigDecimal value)
  {
    setAttributeInternal(INCOMINGRELATEDLETTERSPK, value);
  }

  /**
   * Gets the attribute value for IncomingDocumentsFk, using the alias name IncomingDocumentsFk.
   * @return the value of IncomingDocumentsFk
   */
  public BigDecimal getIncomingDocumentsFk()
  {
    return (BigDecimal) getAttributeInternal(INCOMINGDOCUMENTSFK);
  }

  /**
   * Sets <code>value</code> as the attribute value for IncomingDocumentsFk.
   * @param value value to set the IncomingDocumentsFk
   */
  public void setIncomingDocumentsFk(BigDecimal value)
  {
    setAttributeInternal(INCOMINGDOCUMENTSFK, value);
  }

  /**
   * Gets the attribute value for RelatedIncomingDocumentFk, using the alias name RelatedIncomingDocumentFk.
   * @return the value of RelatedIncomingDocumentFk
   */
  public BigDecimal getRelatedIncomingDocumentFk()
  {
    return (BigDecimal) getAttributeInternal(RELATEDINCOMINGDOCUMENTFK);
  }

  /**
   * Sets <code>value</code> as the attribute value for RelatedIncomingDocumentFk.
   * @param value value to set the RelatedIncomingDocumentFk
   */
  public void setRelatedIncomingDocumentFk(BigDecimal value)
  {
    setAttributeInternal(RELATEDINCOMINGDOCUMENTFK, value);
  }

  /**
   * Gets the attribute value for CreatedBy, using the alias name CreatedBy.
   * @return the value of CreatedBy
   */
  public BigDecimal getCreatedBy()
  {
    return (BigDecimal) getAttributeInternal(CREATEDBY);
  }

  /**
   * Sets <code>value</code> as the attribute value for CreatedBy.
   * @param value value to set the CreatedBy
   */
  public void setCreatedBy(BigDecimal value)
  {
    setAttributeInternal(CREATEDBY, value);
  }

  /**
   * Gets the attribute value for CreationDate, using the alias name CreationDate.
   * @return the value of CreationDate
   */
  public Timestamp getCreationDate()
  {
    return (Timestamp) getAttributeInternal(CREATIONDATE);
  }

  /**
   * Sets <code>value</code> as the attribute value for CreationDate.
   * @param value value to set the CreationDate
   */
  public void setCreationDate(Timestamp value)
  {
    setAttributeInternal(CREATIONDATE, value);
  }

  /**
   * Gets the attribute value for ModifiedBy, using the alias name ModifiedBy.
   * @return the value of ModifiedBy
   */
  public BigDecimal getModifiedBy()
  {
    return (BigDecimal) getAttributeInternal(MODIFIEDBY);
  }

  /**
   * Sets <code>value</code> as the attribute value for ModifiedBy.
   * @param value value to set the ModifiedBy
   */
  public void setModifiedBy(BigDecimal value)
  {
    setAttributeInternal(MODIFIEDBY, value);
  }

  /**
   * Gets the attribute value for ModifiedDate, using the alias name ModifiedDate.
   * @return the value of ModifiedDate
   */
  public Timestamp getModifiedDate()
  {
    return (Timestamp) getAttributeInternal(MODIFIEDDATE);
  }

  /**
   * Sets <code>value</code> as the attribute value for ModifiedDate.
   * @param value value to set the ModifiedDate
   */
  public void setModifiedDate(Timestamp value)
  {
    setAttributeInternal(MODIFIEDDATE, value);
  }

  /**
   * Gets the attribute value for UserDepartmentFk, using the alias name UserDepartmentFk.
   * @return the value of UserDepartmentFk
   */
  public BigDecimal getUserDepartmentFk()
  {
    return (BigDecimal) getAttributeInternal(USERDEPARTMENTFK);
  }

  /**
   * Sets <code>value</code> as the attribute value for UserDepartmentFk.
   * @param value value to set the UserDepartmentFk
   */
  public void setUserDepartmentFk(BigDecimal value)
  {
    setAttributeInternal(USERDEPARTMENTFK, value);
  }

  /**
   * Gets the attribute value for RelatedOutgoingDocumentsFk, using the alias name RelatedOutgoingDocumentsFk.
   * @return the value of RelatedOutgoingDocumentsFk
   */
  public BigDecimal getRelatedOutgoingDocumentsFk()
  {
    return (BigDecimal) getAttributeInternal(RELATEDOUTGOINGDOCUMENTSFK);
  }

  /**
   * Sets <code>value</code> as the attribute value for RelatedOutgoingDocumentsFk.
   * @param value value to set the RelatedOutgoingDocumentsFk
   */
  public void setRelatedOutgoingDocumentsFk(BigDecimal value)
  {
    setAttributeInternal(RELATEDOUTGOINGDOCUMENTSFK, value);
  }

  /**
   * Gets the attribute value for RelatedDocumentTypeFk, using the alias name RelatedDocumentTypeFk.
   * @return the value of RelatedDocumentTypeFk
   */
  public BigDecimal getRelatedDocumentTypeFk()
  {
    return (BigDecimal) getAttributeInternal(RELATEDDOCUMENTTYPEFK);
  }

  /**
   * Sets <code>value</code> as the attribute value for RelatedDocumentTypeFk.
   * @param value value to set the RelatedDocumentTypeFk
   */
  public void setRelatedDocumentTypeFk(BigDecimal value)
  {
    setRelatedIncomingDocumentFk(null);
    setRelatedOutgoingDocumentsFk(null);
    setAttributeInternal(RELATEDDOCUMENTTYPEFK, value);
  }

  /**
   * @return the associated entity CrsIncomingDocumentsImpl.
   */
  public CrsIncomingDocumentsImpl getCrsIncomingDocuments()
  {
    return (CrsIncomingDocumentsImpl) getAttributeInternal(CRSINCOMINGDOCUMENTS);
  }

  /**
   * Sets <code>value</code> as the associated entity CrsIncomingDocumentsImpl.
   */
  public void setCrsIncomingDocuments(CrsIncomingDocumentsImpl value)
  {
    setAttributeInternal(CRSINCOMINGDOCUMENTS, value);
  }

  /**
   * @return the associated entity CrsIncomingDocumentsImpl.
   */
  public CrsIncomingDocumentsImpl getCrsIncomingDocuments1()
  {
    return (CrsIncomingDocumentsImpl) getAttributeInternal(CRSINCOMINGDOCUMENTS1);
  }

  /**
   * Sets <code>value</code> as the associated entity CrsIncomingDocumentsImpl.
   */
  public void setCrsIncomingDocuments1(CrsIncomingDocumentsImpl value)
  {
    setAttributeInternal(CRSINCOMINGDOCUMENTS1, value);
  }

  /**
   * @return the associated entity CrsOutgoingDocumentsImpl.
   */
  public CrsOutgoingDocumentsImpl getCrsOutgoingDocuments()
  {
    return (CrsOutgoingDocumentsImpl) getAttributeInternal(CRSOUTGOINGDOCUMENTS);
  }

  /**
   * Sets <code>value</code> as the associated entity CrsOutgoingDocumentsImpl.
   */
  public void setCrsOutgoingDocuments(CrsOutgoingDocumentsImpl value)
  {
    setAttributeInternal(CRSOUTGOINGDOCUMENTS, value);
  }


  /**
   * @param incomingRelatedLettersPk key constituent

   * @return a Key object based on given key constituents.
   */
  public static Key createPrimaryKey(BigDecimal incomingRelatedLettersPk)
  {
    return new Key(new Object[] { incomingRelatedLettersPk });
  }

  protected void doDML(int operation, oracle.jbo.server.TransactionEvent e) {
    if (operation != DML_DELETE) {
      checkRequiredField();
    }
    super.doDML(operation, e);
    if (operation == DML_INSERT) {
      BigDecimal maxCrsIncomingRelatedLettersNumber = gen.common.GenLib.getPrimaryKeyValue(getDBTransaction(), "CRS_INCOMING_RELATED_LETTERS_S");
      setIncomingRelatedLettersPk(maxCrsIncomingRelatedLettersNumber);
    }
  }
  
  private void checkRequiredField (){
    BigDecimal  incomingDocument = new BigDecimal( GenConstants.INCOMING_DOCUMENT) ;
    BigDecimal  outgoingDocument = new BigDecimal( GenConstants.OUTGOING_DOCUMENT) ;
    if (getRelatedDocumentTypeFk().equals(incomingDocument) && getRelatedIncomingDocumentFk() == null){
      throw new JboException(GenLib.getMessage("error.RelatedIncomingDocumentFk"));
    }
    if (getRelatedDocumentTypeFk().equals(outgoingDocument) && getRelatedOutgoingDocumentsFk() == null) {
      throw new JboException(GenLib.getMessage("error.RelatedOutgoingDocumentsFk"));
    }
  }
}
