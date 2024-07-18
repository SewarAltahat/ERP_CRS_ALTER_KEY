package crs.model.eo;

import java.math.BigDecimal;

import java.sql.Timestamp;

import oracle.jbo.Key;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.EntityImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Sat Apr 01 13:33:02 GMT+03:00 2023
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class CrsAllowedSendDepartmentsImpl
  extends AuditEntityImpl
{
  /**
   * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
   */
  protected enum AttributesEnum
  {
    AllowedSendDepartmentsPk,
    DepartmentsFk,
    SentDepartmentFk,
    CreatedBy,
    CreationDate,
    ModifiedBy,
    ModifiedDate,
    UserDepartmentFk,
    DepartmentTypeFk,
    HcmDepartments,
    HcmDepartments1;
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


  public static final int ALLOWEDSENDDEPARTMENTSPK = AttributesEnum.AllowedSendDepartmentsPk.index();
  public static final int DEPARTMENTSFK = AttributesEnum.DepartmentsFk.index();
  public static final int SENTDEPARTMENTFK = AttributesEnum.SentDepartmentFk.index();
  public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
  public static final int CREATIONDATE = AttributesEnum.CreationDate.index();
  public static final int MODIFIEDBY = AttributesEnum.ModifiedBy.index();
  public static final int MODIFIEDDATE = AttributesEnum.ModifiedDate.index();
  public static final int USERDEPARTMENTFK = AttributesEnum.UserDepartmentFk.index();
  public static final int DEPARTMENTTYPEFK = AttributesEnum.DepartmentTypeFk.index();
  public static final int HCMDEPARTMENTS = AttributesEnum.HcmDepartments.index();
  public static final int HCMDEPARTMENTS1 = AttributesEnum.HcmDepartments1.index();

  /**
   * This is the default constructor (do not remove).
   */
  public CrsAllowedSendDepartmentsImpl()
  {
  }

  /**
   * @return the definition object for this instance class.
   */
  public static synchronized EntityDefImpl getDefinitionObject()
  {
    return EntityDefImpl.findDefObject("crs.model.eo.CrsAllowedSendDepartments");
  }


  /**
   * Gets the attribute value for AllowedSendDepartmentsPk, using the alias name AllowedSendDepartmentsPk.
   * @return the value of AllowedSendDepartmentsPk
   */
  public BigDecimal getAllowedSendDepartmentsPk()
  {
    return (BigDecimal) getAttributeInternal(ALLOWEDSENDDEPARTMENTSPK);
  }

  /**
   * Sets <code>value</code> as the attribute value for AllowedSendDepartmentsPk.
   * @param value value to set the AllowedSendDepartmentsPk
   */
  public void setAllowedSendDepartmentsPk(BigDecimal value)
  {
    setAttributeInternal(ALLOWEDSENDDEPARTMENTSPK, value);
  }

  /**
   * Gets the attribute value for DepartmentsFk, using the alias name DepartmentsFk.
   * @return the value of DepartmentsFk
   */
  public BigDecimal getDepartmentsFk()
  {
    return (BigDecimal) getAttributeInternal(DEPARTMENTSFK);
  }

  /**
   * Sets <code>value</code> as the attribute value for DepartmentsFk.
   * @param value value to set the DepartmentsFk
   */
  public void setDepartmentsFk(BigDecimal value)
  {
    setAttributeInternal(DEPARTMENTSFK, value);
  }

  /**
   * Gets the attribute value for SentDepartmentFk, using the alias name SentDepartmentFk.
   * @return the value of SentDepartmentFk
   */
  public BigDecimal getSentDepartmentFk()
  {
    return (BigDecimal) getAttributeInternal(SENTDEPARTMENTFK);
  }

  /**
   * Sets <code>value</code> as the attribute value for SentDepartmentFk.
   * @param value value to set the SentDepartmentFk
   */
  public void setSentDepartmentFk(BigDecimal value)
  {
    setAttributeInternal(SENTDEPARTMENTFK, value);
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
   * Gets the attribute value for DepartmentTypeFk, using the alias name DepartmentTypeFk.
   * @return the value of DepartmentTypeFk
   */
  public BigDecimal getDepartmentTypeFk()
  {
    return (BigDecimal) getAttributeInternal(DEPARTMENTTYPEFK);
  }

  /**
   * Sets <code>value</code> as the attribute value for DepartmentTypeFk.
   * @param value value to set the DepartmentTypeFk
   */
  public void setDepartmentTypeFk(BigDecimal value)
  {
    setAttributeInternal(DEPARTMENTTYPEFK, value);
  }

  /**
   * @return the associated entity HcmDepartmentsImpl.
   */
  public HcmDepartmentsImpl getHcmDepartments()
  {
    return (HcmDepartmentsImpl) getAttributeInternal(HCMDEPARTMENTS);
  }

  /**
   * Sets <code>value</code> as the associated entity HcmDepartmentsImpl.
   */
  public void setHcmDepartments(HcmDepartmentsImpl value)
  {
    setAttributeInternal(HCMDEPARTMENTS, value);
  }

  /**
   * @return the associated entity HcmDepartmentsImpl.
   */
  public HcmDepartmentsImpl getHcmDepartments1()
  {
    return (HcmDepartmentsImpl) getAttributeInternal(HCMDEPARTMENTS1);
  }

  /**
   * Sets <code>value</code> as the associated entity HcmDepartmentsImpl.
   */
  public void setHcmDepartments1(HcmDepartmentsImpl value)
  {
    setAttributeInternal(HCMDEPARTMENTS1, value);
  }


  /**
   * @param allowedSendDepartmentsPk key constituent

   * @return a Key object based on given key constituents.
   */
  public static Key createPrimaryKey(BigDecimal allowedSendDepartmentsPk)
  {
    return new Key(new Object[] { allowedSendDepartmentsPk });
  }

  protected void doDML(int operation, oracle.jbo.server.TransactionEvent e)
  {
    super.doDML(operation, e);

    if ( operation == DML_INSERT )
    {
      BigDecimal allowedSendDepartmentsPk = gen.common.GenLib.getPrimaryKeyValue(getDBTransaction(), "CRS_ALLOWED_SEND_DEPARTMENTS_");
      setAllowedSendDepartmentsPk(allowedSendDepartmentsPk);
    }
  }

}
