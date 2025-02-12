package crs.model.eo;

import java.math.BigDecimal;

import java.sql.Timestamp;

import oracle.jbo.Key;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.EntityImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Mon Jul 03 17:04:57 GMT+03:00 2023
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class CrsIncomingDocCcTlImpl
  extends AuditEntityImpl
{
  /**
   * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
   */
  protected enum AttributesEnum
  {
    IncomingDocCcTlPk,
    IncomingDocCcFk,
    LanguagesFk,
    Notes,
    CreatedBy,
    CreationDate,
    ModifiedBy,
    ModifiedDate,
    UserDepartmentFk,
    RejectReason,
    IncomingDocGuidance,
    CrsIncomingDocCc;
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


  public static final int INCOMINGDOCCCTLPK = AttributesEnum.IncomingDocCcTlPk.index();
  public static final int INCOMINGDOCCCFK = AttributesEnum.IncomingDocCcFk.index();
  public static final int LANGUAGESFK = AttributesEnum.LanguagesFk.index();
  public static final int NOTES = AttributesEnum.Notes.index();
  public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
  public static final int CREATIONDATE = AttributesEnum.CreationDate.index();
  public static final int MODIFIEDBY = AttributesEnum.ModifiedBy.index();
  public static final int MODIFIEDDATE = AttributesEnum.ModifiedDate.index();
  public static final int USERDEPARTMENTFK = AttributesEnum.UserDepartmentFk.index();
  public static final int REJECTREASON = AttributesEnum.RejectReason.index();
  public static final int INCOMINGDOCGUIDANCE = AttributesEnum.IncomingDocGuidance.index();
  public static final int CRSINCOMINGDOCCC = AttributesEnum.CrsIncomingDocCc.index();

  /**
   * This is the default constructor (do not remove).
   */
  public CrsIncomingDocCcTlImpl()
  {
  }

  /**
   * @return the definition object for this instance class.
   */
  public static synchronized EntityDefImpl getDefinitionObject()
  {
    return EntityDefImpl.findDefObject("crs.model.eo.CrsIncomingDocCcTl");
  }


  /**
   * Gets the attribute value for IncomingDocCcTlPk, using the alias name IncomingDocCcTlPk.
   * @return the value of IncomingDocCcTlPk
   */
  public BigDecimal getIncomingDocCcTlPk()
  {
    return (BigDecimal) getAttributeInternal(INCOMINGDOCCCTLPK);
  }

  /**
   * Sets <code>value</code> as the attribute value for IncomingDocCcTlPk.
   * @param value value to set the IncomingDocCcTlPk
   */
  public void setIncomingDocCcTlPk(BigDecimal value)
  {
    setAttributeInternal(INCOMINGDOCCCTLPK, value);
  }

  /**
   * Gets the attribute value for IncomingDocCcFk, using the alias name IncomingDocCcFk.
   * @return the value of IncomingDocCcFk
   */
  public BigDecimal getIncomingDocCcFk()
  {
    return (BigDecimal) getAttributeInternal(INCOMINGDOCCCFK);
  }

  /**
   * Sets <code>value</code> as the attribute value for IncomingDocCcFk.
   * @param value value to set the IncomingDocCcFk
   */
  public void setIncomingDocCcFk(BigDecimal value)
  {
    setAttributeInternal(INCOMINGDOCCCFK, value);
  }

  /**
   * Gets the attribute value for LanguagesFk, using the alias name LanguagesFk.
   * @return the value of LanguagesFk
   */
  public BigDecimal getLanguagesFk()
  {
    return (BigDecimal) getAttributeInternal(LANGUAGESFK);
  }

  /**
   * Sets <code>value</code> as the attribute value for LanguagesFk.
   * @param value value to set the LanguagesFk
   */
  public void setLanguagesFk(BigDecimal value)
  {
    setAttributeInternal(LANGUAGESFK, value);
  }

  /**
   * Gets the attribute value for Notes, using the alias name Notes.
   * @return the value of Notes
   */
  public String getNotes()
  {
    return (String) getAttributeInternal(NOTES);
  }

  /**
   * Sets <code>value</code> as the attribute value for Notes.
   * @param value value to set the Notes
   */
  public void setNotes(String value)
  {
    setAttributeInternal(NOTES, value);
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
   * Gets the attribute value for RejectReason, using the alias name RejectReason.
   * @return the value of RejectReason
   */
  public String getRejectReason()
  {
    return (String) getAttributeInternal(REJECTREASON);
  }

  /**
   * Sets <code>value</code> as the attribute value for RejectReason.
   * @param value value to set the RejectReason
   */
  public void setRejectReason(String value)
  {
    setAttributeInternal(REJECTREASON, value);
  }

  /**
   * Gets the attribute value for IncomingDocGuidance, using the alias name IncomingDocGuidance.
   * @return the value of IncomingDocGuidance
   */
  public String getIncomingDocGuidance()
  {
    return (String) getAttributeInternal(INCOMINGDOCGUIDANCE);
  }

  /**
   * Sets <code>value</code> as the attribute value for IncomingDocGuidance.
   * @param value value to set the IncomingDocGuidance
   */
  public void setIncomingDocGuidance(String value)
  {
    setAttributeInternal(INCOMINGDOCGUIDANCE, value);
  }

  /**
   * @return the associated entity CrsIncomingDocCcImpl.
   */
  public CrsIncomingDocCcImpl getCrsIncomingDocCc()
  {
    return (CrsIncomingDocCcImpl) getAttributeInternal(CRSINCOMINGDOCCC);
  }

  /**
   * Sets <code>value</code> as the associated entity CrsIncomingDocCcImpl.
   */
  public void setCrsIncomingDocCc(CrsIncomingDocCcImpl value)
  {
    setAttributeInternal(CRSINCOMINGDOCCC, value);
  }


  /**
   * @param incomingDocCcTlPk key constituent

   * @return a Key object based on given key constituents.
   */
  public static Key createPrimaryKey(BigDecimal incomingDocCcTlPk)
  {
    return new Key(new Object[] { incomingDocCcTlPk });
  }

  protected void doDML(int operation, oracle.jbo.server.TransactionEvent e){
    super.doDML(operation, e);
    if ( operation == DML_INSERT ){
      BigDecimal maxCrsIncomingDocCcNumber = gen.common.GenLib.getPrimaryKeyValue(getDBTransaction(), "CRS_INCOMING_DOC_CC_TL_SEQ");
      setIncomingDocCcTlPk(maxCrsIncomingDocCcNumber);
    }
  }

}

