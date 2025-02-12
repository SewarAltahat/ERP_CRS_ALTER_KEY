package crs.model.eo;

import gen.common.GenLib;

import java.math.BigDecimal;

import java.sql.Timestamp;

import java.util.List;

import oracle.jbo.Key;
import oracle.jbo.RowIterator;
import oracle.jbo.server.EntityDefImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Sat Apr 01 13:33:59 GMT+03:00 2023
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class CrsIncomingDocAttachmentsImpl
  extends AuditEntityImpl
{
  /**
   * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
   */
  protected enum AttributesEnum
  {
    IncomingDocAttachmentsPk,
    AttachmentTypeFk,
    IncomingDocumentsFk,
    CreatedBy,
    CreationDate,
    ModifiedBy,
    ModifiedDate,
    UserDepartmentFk,
    DisplayInAttachDesc,
    CrsIncomingDocuments,
    CrsIncomingDocAttachTl;
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


  public static final int INCOMINGDOCATTACHMENTSPK = AttributesEnum.IncomingDocAttachmentsPk.index();
  public static final int ATTACHMENTTYPEFK = AttributesEnum.AttachmentTypeFk.index();
  public static final int INCOMINGDOCUMENTSFK = AttributesEnum.IncomingDocumentsFk.index();
  public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
  public static final int CREATIONDATE = AttributesEnum.CreationDate.index();
  public static final int MODIFIEDBY = AttributesEnum.ModifiedBy.index();
  public static final int MODIFIEDDATE = AttributesEnum.ModifiedDate.index();
  public static final int USERDEPARTMENTFK = AttributesEnum.UserDepartmentFk.index();
  public static final int DISPLAYINATTACHDESC = AttributesEnum.DisplayInAttachDesc.index();
  public static final int CRSINCOMINGDOCUMENTS = AttributesEnum.CrsIncomingDocuments.index();
  public static final int CRSINCOMINGDOCATTACHTL = AttributesEnum.CrsIncomingDocAttachTl.index();

  /**
   * This is the default constructor (do not remove).
   */
  public CrsIncomingDocAttachmentsImpl()
  {
  }

  /**
   * @return the definition object for this instance class.
   */
  public static synchronized EntityDefImpl getDefinitionObject()
  {
    return EntityDefImpl.findDefObject("crs.model.eo.CrsIncomingDocAttachments");
  }


  /**
   * Gets the attribute value for IncomingDocAttachmentsPk, using the alias name IncomingDocAttachmentsPk.
   * @return the value of IncomingDocAttachmentsPk
   */
  public BigDecimal getIncomingDocAttachmentsPk()
  {
    return (BigDecimal) getAttributeInternal(INCOMINGDOCATTACHMENTSPK);
  }

  /**
   * Sets <code>value</code> as the attribute value for IncomingDocAttachmentsPk.
   * @param value value to set the IncomingDocAttachmentsPk
   */
  public void setIncomingDocAttachmentsPk(BigDecimal value)
  {
    setAttributeInternal(INCOMINGDOCATTACHMENTSPK, value);
  }

  /**
   * Gets the attribute value for AttachmentTypeFk, using the alias name AttachmentTypeFk.
   * @return the value of AttachmentTypeFk
   */
  public BigDecimal getAttachmentTypeFk()
  {
    return (BigDecimal) getAttributeInternal(ATTACHMENTTYPEFK);
  }

  /**
   * Sets <code>value</code> as the attribute value for AttachmentTypeFk.
   * @param value value to set the AttachmentTypeFk
   */
  public void setAttachmentTypeFk(BigDecimal value)
  {
    setAttributeInternal(ATTACHMENTTYPEFK, value);
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
   * Gets the attribute value for DisplayInAttachDesc, using the alias name DisplayInAttachDesc.
   * @return the value of DisplayInAttachDesc
   */
  public String getDisplayInAttachDesc()
  {
    return (String) getAttributeInternal(DISPLAYINATTACHDESC);
  }

  /**
   * Sets <code>value</code> as the attribute value for DisplayInAttachDesc.
   * @param value value to set the DisplayInAttachDesc
   */
  public void setDisplayInAttachDesc(String value)
  {
    setAttributeInternal(DISPLAYINATTACHDESC, value);
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
   * @return the associated entity oracle.jbo.RowIterator.
   */
  public RowIterator getCrsIncomingDocAttachTl()
  {
    return (RowIterator) getAttributeInternal(CRSINCOMINGDOCATTACHTL);
  }


  /**
   * @param incomingDocAttachmentsPk key constituent

   * @return a Key object based on given key constituents.
   */
  public static Key createPrimaryKey(BigDecimal incomingDocAttachmentsPk)
  {
    return new Key(new Object[] { incomingDocAttachmentsPk });
  }

  @Override
  public void remove()
  {
    GenLib.removeTranlationRows(getCrsIncomingDocAttachTl());
    super.remove();
  }
   
  
  
  protected void doDML(int operation, oracle.jbo.server.TransactionEvent e){
    super.doDML(operation, e);
        if (operation == DML_INSERT){
          BigDecimal maxCrsIncomingDocAttachmentNumber = gen.common.GenLib.getPrimaryKeyValue(getDBTransaction(), "CRS_INCOMING_DOC_ATTACHMENTS_S");
          setIncomingDocAttachmentsPk(maxCrsIncomingDocAttachmentNumber);
          insertIntoCrsIncomingDocAttachmentsTranslation(); 
        }
  }
  
  private void insertIntoCrsIncomingDocAttachmentsTranslation  () {
      oracle.jbo.server.EntityDefImpl crsIncomingDocAttachTlDefinition = CrsIncomingDocAttachTlImpl.getDefinitionObject();
    java.util.List<Integer> activeLanguages = gen.common.GenLib.getActiveDataLanguages(getDBTransaction());
      for (Integer languageId : activeLanguages) {
        CrsIncomingDocAttachTlImpl crsIncomingDocAttachTlImpl = (CrsIncomingDocAttachTlImpl) crsIncomingDocAttachTlDefinition.createInstance2(getDBTransaction(), null);
        crsIncomingDocAttachTlImpl.setIncomingDocAttachmentsFk(getIncomingDocAttachmentsPk());
        crsIncomingDocAttachTlImpl.setLanguagesFk(new BigDecimal(languageId));
        crsIncomingDocAttachTlImpl.setInAttachDesc(getDisplayInAttachDesc());
    }
  }
}
