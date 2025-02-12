package crs.model.vo;

import crs.model.eo.CrsDeptGroupImpl;

import java.math.BigDecimal;

import java.sql.Date;
import java.sql.Timestamp;

import oracle.jbo.RowIterator;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed Jul 26 12:11:39 EEST 2023
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class CrsDeptGroupViewRowImpl
  extends ViewRowImpl
{

  public static final int ENTITY_CRSDEPTGROUP = 0;

  /**
   * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
   */
  protected enum AttributesEnum
  {
    DeptGroupPk,
    CreatedBy,
    CreationDate,
    ModifiedBy,
    ModifiedDate,
    UserDepartmentFk,
    ActiveFl,
    DisplayGroupName,
    DisplayGroupNameSearch,
    StartDate,
    EndDate,
    CrsDeptGroupDeptsView,
    CrsDeptGroupTlView;
    private static AttributesEnum[] vals = null;
    ;
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

  public static final int DEPTGROUPPK = AttributesEnum.DeptGroupPk.index();
  public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
  public static final int CREATIONDATE = AttributesEnum.CreationDate.index();
  public static final int MODIFIEDBY = AttributesEnum.ModifiedBy.index();
  public static final int MODIFIEDDATE = AttributesEnum.ModifiedDate.index();
  public static final int USERDEPARTMENTFK = AttributesEnum.UserDepartmentFk.index();
  public static final int ACTIVEFL = AttributesEnum.ActiveFl.index();
  public static final int DISPLAYGROUPNAME = AttributesEnum.DisplayGroupName.index();
  public static final int DISPLAYGROUPNAMESEARCH = AttributesEnum.DisplayGroupNameSearch.index();
  public static final int STARTDATE = AttributesEnum.StartDate.index();
  public static final int ENDDATE = AttributesEnum.EndDate.index();
  public static final int CRSDEPTGROUPDEPTSVIEW = AttributesEnum.CrsDeptGroupDeptsView.index();
  public static final int CRSDEPTGROUPTLVIEW = AttributesEnum.CrsDeptGroupTlView.index();

  /**
   * This is the default constructor (do not remove).
   */
  public CrsDeptGroupViewRowImpl()
  {
  }

  /**
   * Gets CrsDeptGroup entity object.
   * @return the CrsDeptGroup
   */
  public CrsDeptGroupImpl getCrsDeptGroup()
  {
    return (CrsDeptGroupImpl) getEntity(ENTITY_CRSDEPTGROUP);
  }

  /**
   * Gets the attribute value for DEPT_GROUP_PK using the alias name DeptGroupPk.
   * @return the DEPT_GROUP_PK
   */
  public BigDecimal getDeptGroupPk()
  {
    return (BigDecimal) getAttributeInternal(DEPTGROUPPK);
  }

  /**
   * Sets <code>value</code> as attribute value for DEPT_GROUP_PK using the alias name DeptGroupPk.
   * @param value value to set the DEPT_GROUP_PK
   */
  public void setDeptGroupPk(BigDecimal value)
  {
    setAttributeInternal(DEPTGROUPPK, value);
  }

  /**
   * Gets the attribute value for CREATED_BY using the alias name CreatedBy.
   * @return the CREATED_BY
   */
  public BigDecimal getCreatedBy()
  {
    return (BigDecimal) getAttributeInternal(CREATEDBY);
  }

  /**
   * Sets <code>value</code> as attribute value for CREATED_BY using the alias name CreatedBy.
   * @param value value to set the CREATED_BY
   */
  public void setCreatedBy(BigDecimal value)
  {
    setAttributeInternal(CREATEDBY, value);
  }

  /**
   * Gets the attribute value for CREATION_DATE using the alias name CreationDate.
   * @return the CREATION_DATE
   */
  public Timestamp getCreationDate()
  {
    return (Timestamp) getAttributeInternal(CREATIONDATE);
  }

  /**
   * Sets <code>value</code> as attribute value for CREATION_DATE using the alias name CreationDate.
   * @param value value to set the CREATION_DATE
   */
  public void setCreationDate(Timestamp value)
  {
    setAttributeInternal(CREATIONDATE, value);
  }

  /**
   * Gets the attribute value for MODIFIED_BY using the alias name ModifiedBy.
   * @return the MODIFIED_BY
   */
  public BigDecimal getModifiedBy()
  {
    return (BigDecimal) getAttributeInternal(MODIFIEDBY);
  }

  /**
   * Sets <code>value</code> as attribute value for MODIFIED_BY using the alias name ModifiedBy.
   * @param value value to set the MODIFIED_BY
   */
  public void setModifiedBy(BigDecimal value)
  {
    setAttributeInternal(MODIFIEDBY, value);
  }

  /**
   * Gets the attribute value for MODIFIED_DATE using the alias name ModifiedDate.
   * @return the MODIFIED_DATE
   */
  public Timestamp getModifiedDate()
  {
    return (Timestamp) getAttributeInternal(MODIFIEDDATE);
  }

  /**
   * Sets <code>value</code> as attribute value for MODIFIED_DATE using the alias name ModifiedDate.
   * @param value value to set the MODIFIED_DATE
   */
  public void setModifiedDate(Timestamp value)
  {
    setAttributeInternal(MODIFIEDDATE, value);
  }

  /**
   * Gets the attribute value for USER_DEPARTMENT_FK using the alias name UserDepartmentFk.
   * @return the USER_DEPARTMENT_FK
   */
  public BigDecimal getUserDepartmentFk()
  {
    return (BigDecimal) getAttributeInternal(USERDEPARTMENTFK);
  }

  /**
   * Sets <code>value</code> as attribute value for USER_DEPARTMENT_FK using the alias name UserDepartmentFk.
   * @param value value to set the USER_DEPARTMENT_FK
   */
  public void setUserDepartmentFk(BigDecimal value)
  {
    setAttributeInternal(USERDEPARTMENTFK, value);
  }

  /**
   * Gets the attribute value for ACTIVE_FL using the alias name ActiveFl.
   * @return the ACTIVE_FL
   */
  public BigDecimal getActiveFl()
  {
    return (BigDecimal) getAttributeInternal(ACTIVEFL);
  }

  /**
   * Sets <code>value</code> as attribute value for ACTIVE_FL using the alias name ActiveFl.
   * @param value value to set the ACTIVE_FL
   */
  public void setActiveFl(BigDecimal value)
  {
    setAttributeInternal(ACTIVEFL, value);
  }

  /**
   * Gets the attribute value for DISPLAY_GROUP_NAME using the alias name DisplayGroupName.
   * @return the DISPLAY_GROUP_NAME
   */
  public String getDisplayGroupName()
  {
    return (String) getAttributeInternal(DISPLAYGROUPNAME);
  }

  /**
   * Sets <code>value</code> as attribute value for DISPLAY_GROUP_NAME using the alias name DisplayGroupName.
   * @param value value to set the DISPLAY_GROUP_NAME
   */
  public void setDisplayGroupName(String value)
  {
    setAttributeInternal(DISPLAYGROUPNAME, value);
  }

  /**
   * Gets the attribute value for the calculated attribute DisplayGroupNameSearch.
   * @return the DisplayGroupNameSearch
   */
  public String getDisplayGroupNameSearch()
  {
    return (String) getAttributeInternal(DISPLAYGROUPNAME);
  }

  /**
   * Sets <code>value</code> as the attribute value for the calculated attribute DisplayGroupNameSearch.
   * @param value value to set the  DisplayGroupNameSearch
   */
  public void setDisplayGroupNameSearch(String value)
  {
    setAttributeInternal(DISPLAYGROUPNAMESEARCH, value);
  }

  /**
   * Gets the attribute value for START_DATE using the alias name StartDate.
   * @return the START_DATE
   */
  public Date getStartDate()
  {
    return (Date) getAttributeInternal(STARTDATE);
  }

  /**
   * Sets <code>value</code> as attribute value for START_DATE using the alias name StartDate.
   * @param value value to set the START_DATE
   */
  public void setStartDate(Date value)
  {
    setAttributeInternal(STARTDATE, value);
  }

  /**
   * Gets the attribute value for END_DATE using the alias name EndDate.
   * @return the END_DATE
   */
  public Date getEndDate()
  {
    return (Date) getAttributeInternal(ENDDATE);
  }

  /**
   * Sets <code>value</code> as attribute value for END_DATE using the alias name EndDate.
   * @param value value to set the END_DATE
   */
  public void setEndDate(Date value)
  {
    setAttributeInternal(ENDDATE, value);
  }

  /**
   * Gets the associated <code>RowIterator</code> using master-detail link CrsDeptGroupDeptsView.
   */
  public RowIterator getCrsDeptGroupDeptsView()
  {
    return (RowIterator) getAttributeInternal(CRSDEPTGROUPDEPTSVIEW);
  }

  /**
   * Gets the associated <code>RowIterator</code> using master-detail link CrsDeptGroupTlView.
   */
  public RowIterator getCrsDeptGroupTlView()
  {
    return (RowIterator) getAttributeInternal(CRSDEPTGROUPTLVIEW);
  }
}

