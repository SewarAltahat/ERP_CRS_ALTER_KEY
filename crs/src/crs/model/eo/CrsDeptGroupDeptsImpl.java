package crs.model.eo;

import com.sd.util.adf.ADFUtils;

import com.sd.util.db.DBUtil;

import gen.common.GenLib;

import java.math.BigDecimal;

import java.sql.Timestamp;

import oracle.jbo.JboException;
import oracle.jbo.Key;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.EntityImpl;
public class CrsDeptGroupDeptsImpl
  extends AuditEntityImpl
{
  /**
   * Validation method for DepartmentsFk.
   */
  public boolean validateDepartmentsFk(BigDecimal departmentsfk){
    if (getUsersFk()!=null ){
      verifyUniqueDepartmentAssignment(departmentsfk,getUsersFk(),getDeptGroupFk());
    }
    return true;
  }

  /**
   * Validation method for UsersFk.
   */
  
  

  public boolean validateUsersFk(BigDecimal usersfk)
  {
    
//    if (usersfk!=null && getDepartmentsFk() != null) {
//      verifyUniqueDepartmentAssignment(getDepartmentsFk(),usersfk,getDeptGroupFk());
//    }
    return true;
  }

  /**
   * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
   */
    enum AttributesEnum
  {
    DeptGroupDeptsPk,
    DeptGroupFk,
    DepartmentsFk,
    CreatedBy,
    CreationDate,
    ModifiedBy,
    ModifiedDate,
    UserDepartmentFk,
    UsersFk,
    CrsDeptGroup,
    HcmDepartments;
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


  public static final int DEPTGROUPDEPTSPK = AttributesEnum.DeptGroupDeptsPk.index();
  public static final int DEPTGROUPFK = AttributesEnum.DeptGroupFk.index();
  public static final int DEPARTMENTSFK = AttributesEnum.DepartmentsFk.index();
  public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
  public static final int CREATIONDATE = AttributesEnum.CreationDate.index();
  public static final int MODIFIEDBY = AttributesEnum.ModifiedBy.index();
  public static final int MODIFIEDDATE = AttributesEnum.ModifiedDate.index();
  public static final int USERDEPARTMENTFK = AttributesEnum.UserDepartmentFk.index();
  public static final int USERSFK = AttributesEnum.UsersFk.index();
  public static final int CRSDEPTGROUP = AttributesEnum.CrsDeptGroup.index();
  public static final int HCMDEPARTMENTS = AttributesEnum.HcmDepartments.index();

  /**
   * This is the default constructor (do not remove).
   */
  public CrsDeptGroupDeptsImpl()
  {
  }

  /**
   * @return the definition object for this instance class.
   */
  public static synchronized EntityDefImpl getDefinitionObject()
  {
    return EntityDefImpl.findDefObject("crs.model.eo.CrsDeptGroupDepts");
  }


  /**
   * Gets the attribute value for DeptGroupDeptsPk, using the alias name DeptGroupDeptsPk.
   * @return the value of DeptGroupDeptsPk
   */
  public BigDecimal getDeptGroupDeptsPk()
  {
    return (BigDecimal) getAttributeInternal(DEPTGROUPDEPTSPK);
  }

  /**
   * Sets <code>value</code> as the attribute value for DeptGroupDeptsPk.
   * @param value value to set the DeptGroupDeptsPk
   */
  public void setDeptGroupDeptsPk(BigDecimal value)
  {
    setAttributeInternal(DEPTGROUPDEPTSPK, value);
  }

  /**
   * Gets the attribute value for DeptGroupFk, using the alias name DeptGroupFk.
   * @return the value of DeptGroupFk
   */
  public BigDecimal getDeptGroupFk()
  {
    return (BigDecimal) getAttributeInternal(DEPTGROUPFK);
  }

  /**
   * Sets <code>value</code> as the attribute value for DeptGroupFk.
   * @param value value to set the DeptGroupFk
   */
  public void setDeptGroupFk(BigDecimal value)
  {
    setAttributeInternal(DEPTGROUPFK, value);
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
    setUsersFk(null);
    setAttributeInternal(DEPARTMENTSFK, value);
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
   * Gets the attribute value for UsersFk, using the alias name UsersFk.
   * @return the value of UsersFk
   */
  public BigDecimal getUsersFk()
  {
    return (BigDecimal) getAttributeInternal(USERSFK);
  }

  /**
   * Sets <code>value</code> as the attribute value for UsersFk.
   * @param value value to set the UsersFk
   */
  public void setUsersFk(BigDecimal value)
  {
    setAttributeInternal(USERSFK, value);
  }

  /**
   * @return the associated entity CrsDeptGroupImpl.
   */
  public CrsDeptGroupImpl getCrsDeptGroup()
  {
    return (CrsDeptGroupImpl) getAttributeInternal(CRSDEPTGROUP);
  }

  /**
   * Sets <code>value</code> as the associated entity CrsDeptGroupImpl.
   */
  public void setCrsDeptGroup(CrsDeptGroupImpl value)
  {
    setAttributeInternal(CRSDEPTGROUP, value);
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
   * @param deptGroupDeptsPk key constituent

   * @return a Key object based on given key constituents.
   */
  public static Key createPrimaryKey(BigDecimal deptGroupDeptsPk)
  {
    return new Key(new Object[] { deptGroupDeptsPk });
  }

  protected void doDML(int operation, oracle.jbo.server.TransactionEvent e)
  {
     
    if ( operation == DML_INSERT  ||operation == DML_UPDATE) {
      verifyUniqueDepartmentAssignment(getDepartmentsFk(),getUsersFk(),getDeptGroupFk());
    }
    super.doDML(operation, e);

    if ( operation == DML_INSERT )
    {
      BigDecimal deptGroupDeptsPk = gen.common.GenLib.getPrimaryKeyValue(getDBTransaction(), "CRS_DEPT_GROUP_DEPTS_SEQ");
      setDeptGroupDeptsPk(deptGroupDeptsPk);
    }
    
  }
  
  private void verifyUniqueDepartmentAssignment(BigDecimal departmentNumber,BigDecimal usersNumber,BigDecimal departmentGroupNumber)
    {
      StringBuilder sqlCountOfGroup = new StringBuilder("");
      if (departmentGroupNumber!=null && departmentNumber!=null  ) {
        sqlCountOfGroup.append(" select   count(dept_group_depts_pk) from crs_dept_group_depts\n");
        sqlCountOfGroup.append( " where departments_fk=").append(departmentNumber);
        sqlCountOfGroup.append(" \n");
        if (usersNumber != null) {
            sqlCountOfGroup.append(" and users_fk = ").append(usersNumber);
        } else {
            sqlCountOfGroup.append(" and users_fk is null");
        }
        sqlCountOfGroup.append(" \n"); 
        sqlCountOfGroup.append(" and dept_group_fk   = ").append(departmentGroupNumber); 
         int countOfGroup = DBUtil.getQueryResultAsInt(sqlCountOfGroup.toString());
       
          if (countOfGroup != 0) {
              throw new JboException(GenLib.getMessage("error.DuplicateCode"));
          }
     
    }}

}

