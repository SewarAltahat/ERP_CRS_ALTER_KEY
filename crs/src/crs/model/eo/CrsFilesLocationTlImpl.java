package crs.model.eo;

import java.math.BigDecimal;

import java.sql.Timestamp;

import oracle.jbo.Key;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.EntityImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Sat Apr 01 13:33:32 GMT+03:00 2023
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class CrsFilesLocationTlImpl
  extends AuditEntityImpl
{
  /**
   * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
   */
  protected enum AttributesEnum
  {
    FilesLocationTlPk,
    FileLocationDesc,
    LanguagesFk,
    FilesLocationFk,
    CreatedBy,
    CreationDate,
    ModifiedBy,
    ModifiedDate,
    UserDepartmentFk,
    CrsFilesLocation;
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


  public static final int FILESLOCATIONTLPK = AttributesEnum.FilesLocationTlPk.index();
  public static final int FILELOCATIONDESC = AttributesEnum.FileLocationDesc.index();
  public static final int LANGUAGESFK = AttributesEnum.LanguagesFk.index();
  public static final int FILESLOCATIONFK = AttributesEnum.FilesLocationFk.index();
  public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
  public static final int CREATIONDATE = AttributesEnum.CreationDate.index();
  public static final int MODIFIEDBY = AttributesEnum.ModifiedBy.index();
  public static final int MODIFIEDDATE = AttributesEnum.ModifiedDate.index();
  public static final int USERDEPARTMENTFK = AttributesEnum.UserDepartmentFk.index();
  public static final int CRSFILESLOCATION = AttributesEnum.CrsFilesLocation.index();

  /**
   * This is the default constructor (do not remove).
   */
  public CrsFilesLocationTlImpl()
  {
  }

  /**
   * @return the definition object for this instance class.
   */
  public static synchronized EntityDefImpl getDefinitionObject()
  {
    return EntityDefImpl.findDefObject("crs.model.eo.CrsFilesLocationTl");
  }


  /**
   * Gets the attribute value for FilesLocationTlPk, using the alias name FilesLocationTlPk.
   * @return the value of FilesLocationTlPk
   */
  public BigDecimal getFilesLocationTlPk()
  {
    return (BigDecimal) getAttributeInternal(FILESLOCATIONTLPK);
  }

  /**
   * Sets <code>value</code> as the attribute value for FilesLocationTlPk.
   * @param value value to set the FilesLocationTlPk
   */
  public void setFilesLocationTlPk(BigDecimal value)
  {
    setAttributeInternal(FILESLOCATIONTLPK, value);
  }

  /**
   * Gets the attribute value for FileLocationDesc, using the alias name FileLocationDesc.
   * @return the value of FileLocationDesc
   */
  public String getFileLocationDesc()
  {
    return (String) getAttributeInternal(FILELOCATIONDESC);
  }

  /**
   * Sets <code>value</code> as the attribute value for FileLocationDesc.
   * @param value value to set the FileLocationDesc
   */
  public void setFileLocationDesc(String value)
  {
    setAttributeInternal(FILELOCATIONDESC, value);
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
   * Gets the attribute value for FilesLocationFk, using the alias name FilesLocationFk.
   * @return the value of FilesLocationFk
   */
  public BigDecimal getFilesLocationFk()
  {
    return (BigDecimal) getAttributeInternal(FILESLOCATIONFK);
  }

  /**
   * Sets <code>value</code> as the attribute value for FilesLocationFk.
   * @param value value to set the FilesLocationFk
   */
  public void setFilesLocationFk(BigDecimal value)
  {
    setAttributeInternal(FILESLOCATIONFK, value);
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
   * @return the associated entity CrsFilesLocationImpl.
   */
  public CrsFilesLocationImpl getCrsFilesLocation()
  {
    return (CrsFilesLocationImpl) getAttributeInternal(CRSFILESLOCATION);
  }

  /**
   * Sets <code>value</code> as the associated entity CrsFilesLocationImpl.
   */
  public void setCrsFilesLocation(CrsFilesLocationImpl value)
  {
    setAttributeInternal(CRSFILESLOCATION, value);
  }


  /**
   * @param filesLocationTlPk key constituent

   * @return a Key object based on given key constituents.
   */
  public static Key createPrimaryKey(BigDecimal filesLocationTlPk)
  {
    return new Key(new Object[] { filesLocationTlPk });
  }

  protected void doDML(int operation, oracle.jbo.server.TransactionEvent e)
  {
    super.doDML(operation, e);

    if ( operation == DML_INSERT )
    {
      BigDecimal pk = gen.common.GenLib.getPrimaryKeyValue(getDBTransaction(), "CRS_FILES_LOCATION_TL_SEQ");
      setFilesLocationTlPk(pk);
    }
  }

}

