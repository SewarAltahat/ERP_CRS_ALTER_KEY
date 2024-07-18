package crs.model.eo;

import java.math.BigDecimal;
import java.sql.Timestamp;
import oracle.jbo.Key;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.EntityImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Mon Jul 03 17:05:08 GMT+03:00 2023
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class CrsOutgoingDocCcTlImpl
  extends AuditEntityImpl
{
  /**
   * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
   */
  protected enum AttributesEnum
  {
    OutgoingDocCcTlPk,
    OutgoingDocCcFk,
    LanguagesFk,
    Notes,
    CreatedBy,
    CreationDate,
    ModifiedBy,
    ModifiedDate,
    UserDepartmentFk,
    OutgoingDocGuidance,
    CrsOutgoingDocCc;
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


  public static final int OUTGOINGDOCCCTLPK = AttributesEnum.OutgoingDocCcTlPk.index();
  public static final int OUTGOINGDOCCCFK = AttributesEnum.OutgoingDocCcFk.index();
  public static final int LANGUAGESFK = AttributesEnum.LanguagesFk.index();
  public static final int NOTES = AttributesEnum.Notes.index();
  public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
  public static final int CREATIONDATE = AttributesEnum.CreationDate.index();
  public static final int MODIFIEDBY = AttributesEnum.ModifiedBy.index();
  public static final int MODIFIEDDATE = AttributesEnum.ModifiedDate.index();
  public static final int USERDEPARTMENTFK = AttributesEnum.UserDepartmentFk.index();
  public static final int OUTGOINGDOCGUIDANCE = AttributesEnum.OutgoingDocGuidance.index();
  public static final int CRSOUTGOINGDOCCC = AttributesEnum.CrsOutgoingDocCc.index();

  /**
   * This is the default constructor (do not remove).
   */
  public CrsOutgoingDocCcTlImpl()
  {
  }

  /**
   * @return the definition object for this instance class.
   */
  public static synchronized EntityDefImpl getDefinitionObject()
  {
    return EntityDefImpl.findDefObject("crs.model.eo.CrsOutgoingDocCcTl");
  }


  /**
   * Gets the attribute value for OutgoingDocCcTlPk, using the alias name OutgoingDocCcTlPk.
   * @return the value of OutgoingDocCcTlPk
   */
  public BigDecimal getOutgoingDocCcTlPk()
  {
    return (BigDecimal) getAttributeInternal(OUTGOINGDOCCCTLPK);
  }

  /**
   * Sets <code>value</code> as the attribute value for OutgoingDocCcTlPk.
   * @param value value to set the OutgoingDocCcTlPk
   */
  public void setOutgoingDocCcTlPk(BigDecimal value)
  {
    setAttributeInternal(OUTGOINGDOCCCTLPK, value);
  }

  /**
   * Gets the attribute value for OutgoingDocCcFk, using the alias name OutgoingDocCcFk.
   * @return the value of OutgoingDocCcFk
   */
  public BigDecimal getOutgoingDocCcFk()
  {
    return (BigDecimal) getAttributeInternal(OUTGOINGDOCCCFK);
  }

  /**
   * Sets <code>value</code> as the attribute value for OutgoingDocCcFk.
   * @param value value to set the OutgoingDocCcFk
   */
  public void setOutgoingDocCcFk(BigDecimal value)
  {
    setAttributeInternal(OUTGOINGDOCCCFK, value);
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
   * Gets the attribute value for OutgoingDocGuidance, using the alias name OutgoingDocGuidance.
   * @return the value of OutgoingDocGuidance
   */
  public String getOutgoingDocGuidance()
  {
    return (String) getAttributeInternal(OUTGOINGDOCGUIDANCE);
  }

  /**
   * Sets <code>value</code> as the attribute value for OutgoingDocGuidance.
   * @param value value to set the OutgoingDocGuidance
   */
  public void setOutgoingDocGuidance(String value)
  {
    setAttributeInternal(OUTGOINGDOCGUIDANCE, value);
  }

  /**
   * @return the associated entity CrsOutgoingDocCcImpl.
   */
  public CrsOutgoingDocCcImpl getCrsOutgoingDocCc()
  {
    return (CrsOutgoingDocCcImpl) getAttributeInternal(CRSOUTGOINGDOCCC);
  }

  /**
   * Sets <code>value</code> as the associated entity CrsOutgoingDocCcImpl.
   */
  public void setCrsOutgoingDocCc(CrsOutgoingDocCcImpl value)
  {
    setAttributeInternal(CRSOUTGOINGDOCCC, value);
  }


  /**
   * @param outgoingDocCcTlPk key constituent

   * @return a Key object based on given key constituents.
   */
  public static Key createPrimaryKey(BigDecimal outgoingDocCcTlPk)
  {
    return new Key(new Object[] { outgoingDocCcTlPk });
  }

  protected void doDML(int operation, oracle.jbo.server.TransactionEvent e) {
    
    super.doDML(operation, e);

    if (operation == DML_INSERT){
      BigDecimal outgoingDocCcTlPk = gen.common.GenLib.getPrimaryKeyValue(getDBTransaction(), "CRS_OUTGOING_DOC_CC_TL_SEQ");
      setOutgoingDocCcTlPk(outgoingDocCcTlPk);
    }
  }
}