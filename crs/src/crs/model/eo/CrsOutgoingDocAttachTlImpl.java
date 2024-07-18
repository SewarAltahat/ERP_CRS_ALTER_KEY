package crs.model.eo;

import java.math.BigDecimal;
import java.sql.Timestamp;
import oracle.jbo.Key;
import oracle.jbo.server.EntityDefImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Sat Apr 01 13:34:51 GMT+03:00 2023
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class CrsOutgoingDocAttachTlImpl
  extends AuditEntityImpl
{
  /**
   * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
   */
  protected enum AttributesEnum
  {
    OutgoingDocAttachTlPk,
    OutAttachDesc,
    LanguagesFk,
    OutgoingDocAttachmentsFk,
    CreatedBy,
    CreationDate,
    ModifiedBy,
    ModifiedDate,
    UserDepartmentFk,
    CrsOutgoingDocAttachments;
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

  public static final int OUTGOINGDOCATTACHTLPK = AttributesEnum.OutgoingDocAttachTlPk.index();
  public static final int OUTATTACHDESC = AttributesEnum.OutAttachDesc.index();
  public static final int LANGUAGESFK = AttributesEnum.LanguagesFk.index();
  public static final int OUTGOINGDOCATTACHMENTSFK = AttributesEnum.OutgoingDocAttachmentsFk.index();
  public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
  public static final int CREATIONDATE = AttributesEnum.CreationDate.index();
  public static final int MODIFIEDBY = AttributesEnum.ModifiedBy.index();
  public static final int MODIFIEDDATE = AttributesEnum.ModifiedDate.index();
  public static final int USERDEPARTMENTFK = AttributesEnum.UserDepartmentFk.index();
  public static final int CRSOUTGOINGDOCATTACHMENTS = AttributesEnum.CrsOutgoingDocAttachments.index();

  /**
   * This is the default constructor (do not remove).
   */
  public CrsOutgoingDocAttachTlImpl()
  {
  }

  /**
   * @return the definition object for this instance class.
   */
  public static synchronized EntityDefImpl getDefinitionObject()
  {
    return EntityDefImpl.findDefObject("crs.model.eo.CrsOutgoingDocAttachTl");
  }

  /**
   * Gets the attribute value for OutgoingDocAttachTlPk, using the alias name OutgoingDocAttachTlPk.
   * @return the value of OutgoingDocAttachTlPk
   */
  public BigDecimal getOutgoingDocAttachTlPk()
  {
    return (BigDecimal) getAttributeInternal(OUTGOINGDOCATTACHTLPK);
  }

  /**
   * Sets <code>value</code> as the attribute value for OutgoingDocAttachTlPk.
   * @param value value to set the OutgoingDocAttachTlPk
   */
  public void setOutgoingDocAttachTlPk(BigDecimal value)
  {
    setAttributeInternal(OUTGOINGDOCATTACHTLPK, value);
  }

  /**
   * Gets the attribute value for OutAttachDesc, using the alias name OutAttachDesc.
   * @return the value of OutAttachDesc
   */
  public String getOutAttachDesc()
  {
    return (String) getAttributeInternal(OUTATTACHDESC);
  }

  /**
   * Sets <code>value</code> as the attribute value for OutAttachDesc.
   * @param value value to set the OutAttachDesc
   */
  public void setOutAttachDesc(String value)
  {
    setAttributeInternal(OUTATTACHDESC, value);
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
   * Gets the attribute value for OutgoingDocAttachmentsFk, using the alias name OutgoingDocAttachmentsFk.
   * @return the value of OutgoingDocAttachmentsFk
   */
  public BigDecimal getOutgoingDocAttachmentsFk()
  {
    return (BigDecimal) getAttributeInternal(OUTGOINGDOCATTACHMENTSFK);
  }

  /**
   * Sets <code>value</code> as the attribute value for OutgoingDocAttachmentsFk.
   * @param value value to set the OutgoingDocAttachmentsFk
   */
  public void setOutgoingDocAttachmentsFk(BigDecimal value)
  {
    setAttributeInternal(OUTGOINGDOCATTACHMENTSFK, value);
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
   * @return the associated entity CrsOutgoingDocAttachmentsImpl.
   */
  public CrsOutgoingDocAttachmentsImpl getCrsOutgoingDocAttachments()
  {
    return (CrsOutgoingDocAttachmentsImpl) getAttributeInternal(CRSOUTGOINGDOCATTACHMENTS);
  }

  /**
   * Sets <code>value</code> as the associated entity CrsOutgoingDocAttachmentsImpl.
   */
  public void setCrsOutgoingDocAttachments(CrsOutgoingDocAttachmentsImpl value)
  {
    setAttributeInternal(CRSOUTGOINGDOCATTACHMENTS, value);
  }

  /**
   * @param outgoingDocAttachTlPk key constituent

   * @return a Key object based on given key constituents.
   */
  public static Key createPrimaryKey(BigDecimal outgoingDocAttachTlPk)
  {
    return new Key(new Object[] { outgoingDocAttachTlPk });
  }

  protected void doDML(int operation, oracle.jbo.server.TransactionEvent e){
    
    super.doDML(operation, e);

    if (operation == DML_INSERT) {
      BigDecimal outgoingDocAttachTlPk = gen.common.GenLib.getPrimaryKeyValue(getDBTransaction(), "CRS_OUTGOING_DOC_ATTACH_TL_SEQ");
      setOutgoingDocAttachTlPk(outgoingDocAttachTlPk);
    }
  }
}