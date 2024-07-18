package crs.model.eo;

import com.sd.hijri.common.HijriUtil;
import com.sd.util.db.DBUtil;
import crs.common.Constants;
import gen.common.GenConstants;
import gen.common.GenLib;

import java.math.BigDecimal;

import java.sql.Date;
import java.sql.Timestamp;

import java.util.List;

import oracle.jbo.AttributeList;
import oracle.jbo.JboException;
import oracle.jbo.Key;
import oracle.jbo.RowIterator;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.EntityImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Sat Apr 01 13:34:07 GMT+03:00 2023
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class CrsIncomingDocCcImpl
  extends AuditEntityImpl
{
  /**
   * Validation method for DepartmentsFk.
   */
  public boolean validateDepartmentsFk(BigDecimal departmentsfk){
    if (getEmployeeFk() != null && getIncomingDocumentsFk() != null && departmentsfk != null){
     checkForUniqueInDocCc  ( departmentsfk  ,getEmployeeFk() , getIncomingDocumentsFk());
    }
    return true;
  }

  /**
   * Validation method for EmployeeFk.
   */
  public boolean validateEmployeeFk(BigDecimal employeefk) {
    if (employeefk != null && getIncomingDocumentsFk() != null && getDepartmentsFk() != null){
    checkForUniqueInDocCc  ( getDepartmentsFk()  ,employeefk , getIncomingDocumentsFk());
  }
    return true;
  }

  /**
   * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
   */
  protected enum AttributesEnum
  {
    IncomingDocCcPk,
    IncomingDocumentsFk,
    DepartmentsFk,
    CreatedBy,
    CreationDate,
    ModifiedBy,
    ModifiedDate,
    UserDepartmentFk,
    ActionFk,
    ExecutionDateG,
    ExecutionDateH,
    DisplayNotes,
    EmployeeFk,
    DisplayRejectReason,
    DisplayIncomingDocGuidance,
    IncomingDocStsFk,
    CrsIncomingDocuments,
    CrsIncomingDocCcTl,
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


  public static final int INCOMINGDOCCCPK = AttributesEnum.IncomingDocCcPk.index();
  public static final int INCOMINGDOCUMENTSFK = AttributesEnum.IncomingDocumentsFk.index();
  public static final int DEPARTMENTSFK = AttributesEnum.DepartmentsFk.index();
  public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
  public static final int CREATIONDATE = AttributesEnum.CreationDate.index();
  public static final int MODIFIEDBY = AttributesEnum.ModifiedBy.index();
  public static final int MODIFIEDDATE = AttributesEnum.ModifiedDate.index();
  public static final int USERDEPARTMENTFK = AttributesEnum.UserDepartmentFk.index();
  public static final int ACTIONFK = AttributesEnum.ActionFk.index();
  public static final int EXECUTIONDATEG = AttributesEnum.ExecutionDateG.index();
  public static final int EXECUTIONDATEH = AttributesEnum.ExecutionDateH.index();
  public static final int DISPLAYNOTES = AttributesEnum.DisplayNotes.index();
  public static final int EMPLOYEEFK = AttributesEnum.EmployeeFk.index();
  public static final int DISPLAYREJECTREASON = AttributesEnum.DisplayRejectReason.index();
  public static final int DISPLAYINCOMINGDOCGUIDANCE = AttributesEnum.DisplayIncomingDocGuidance.index();
  public static final int INCOMINGDOCSTSFK = AttributesEnum.IncomingDocStsFk.index();
  public static final int CRSINCOMINGDOCUMENTS = AttributesEnum.CrsIncomingDocuments.index();
  public static final int CRSINCOMINGDOCCCTL = AttributesEnum.CrsIncomingDocCcTl.index();
  public static final int HCMDEPARTMENTS = AttributesEnum.HcmDepartments.index();

  /**
   * This is the default constructor (do not remove).
   */
  public CrsIncomingDocCcImpl()
  {
  }

  /**
   * @return the definition object for this instance class.
   */
  public static synchronized EntityDefImpl getDefinitionObject()
  {
    return EntityDefImpl.findDefObject("crs.model.eo.CrsIncomingDocCc");
  }


  /**
   * Gets the attribute value for IncomingDocCcPk, using the alias name IncomingDocCcPk.
   * @return the value of IncomingDocCcPk
   */
  public BigDecimal getIncomingDocCcPk()
  {
    return (BigDecimal) getAttributeInternal(INCOMINGDOCCCPK);
  }

  /**
   * Sets <code>value</code> as the attribute value for IncomingDocCcPk.
   * @param value value to set the IncomingDocCcPk
   */
  public void setIncomingDocCcPk(BigDecimal value)
  {
    setAttributeInternal(INCOMINGDOCCCPK, value);
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
    setEmployeeFk(null);
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
   * Gets the attribute value for ActionFk, using the alias name ActionFk.
   * @return the value of ActionFk
   */
  public BigDecimal getActionFk()
  {
    return (BigDecimal) getAttributeInternal(ACTIONFK);
  }

  /**
   * Sets <code>value</code> as the attribute value for ActionFk.
   * @param value value to set the ActionFk
   */
  public void setActionFk(BigDecimal value)
  {
    setAttributeInternal(ACTIONFK, value);
  }

  /**
   * Gets the attribute value for ExecutionDateG, using the alias name ExecutionDateG.
   * @return the value of ExecutionDateG
   */
  public Date getExecutionDateG()
  {
    return (Date) getAttributeInternal(EXECUTIONDATEG);
  }

  /**
   * Sets <code>value</code> as the attribute value for ExecutionDateG.
   * @param value value to set the ExecutionDateG
   */
  public void setExecutionDateG(Date value)
  {
    setAttributeInternal(EXECUTIONDATEG, value);
  }

  /**
   * Gets the attribute value for ExecutionDateH, using the alias name ExecutionDateH.
   * @return the value of ExecutionDateH
   */
  public BigDecimal getExecutionDateH()
  {
    return (BigDecimal) getAttributeInternal(EXECUTIONDATEH);
  }

  /**
   * Sets <code>value</code> as the attribute value for ExecutionDateH.
   * @param value value to set the ExecutionDateH
   */
  public void setExecutionDateH(BigDecimal value)
  {
    setAttributeInternal(EXECUTIONDATEH, value);
  }

  /**
   * Gets the attribute value for DisplayNotes, using the alias name DisplayNotes.
   * @return the value of DisplayNotes
   */
  public String getDisplayNotes()
  {
    return (String) getAttributeInternal(DISPLAYNOTES);
  }

  /**
   * Sets <code>value</code> as the attribute value for DisplayNotes.
   * @param value value to set the DisplayNotes
   */
  public void setDisplayNotes(String value)
  {
    setAttributeInternal(DISPLAYNOTES, value);
  }

  /**
   * Gets the attribute value for EmployeeFk, using the alias name EmployeeFk.
   * @return the value of EmployeeFk
   */
  public BigDecimal getEmployeeFk()
  {
    return (BigDecimal) getAttributeInternal(EMPLOYEEFK);
  }

  /**
   * Sets <code>value</code> as the attribute value for EmployeeFk.
   * @param value value to set the EmployeeFk
   */
  public void setEmployeeFk(BigDecimal value)
  {
    setAttributeInternal(EMPLOYEEFK, value);
  }

  /**
   * Gets the attribute value for DisplayRejectReason, using the alias name DisplayRejectReason.
   * @return the value of DisplayRejectReason
   */
  public String getDisplayRejectReason()
  {
    return (String) getAttributeInternal(DISPLAYREJECTREASON);
  }

  /**
   * Sets <code>value</code> as the attribute value for DisplayRejectReason.
   * @param value value to set the DisplayRejectReason
   */
  public void setDisplayRejectReason(String value)
  {
    setAttributeInternal(DISPLAYREJECTREASON, value);
  }

  /**
   * Gets the attribute value for DisplayIncomingDocGuidance, using the alias name DisplayIncomingDocGuidance.
   * @return the value of DisplayIncomingDocGuidance
   */
  public String getDisplayIncomingDocGuidance()
  {
    return (String) getAttributeInternal(DISPLAYINCOMINGDOCGUIDANCE);
  }

  /**
   * Sets <code>value</code> as the attribute value for DisplayIncomingDocGuidance.
   * @param value value to set the DisplayIncomingDocGuidance
   */
  public void setDisplayIncomingDocGuidance(String value)
  {
    setAttributeInternal(DISPLAYINCOMINGDOCGUIDANCE, value);
  }

  /**
   * Gets the attribute value for IncomingDocStsFk, using the alias name IncomingDocStsFk.
   * @return the value of IncomingDocStsFk
   */
  public BigDecimal getIncomingDocStsFk()
  {
    return (BigDecimal) getAttributeInternal(INCOMINGDOCSTSFK);
  }

  /**
   * Sets <code>value</code> as the attribute value for IncomingDocStsFk.
   * @param value value to set the IncomingDocStsFk
   */
  public void setIncomingDocStsFk(BigDecimal value)
  {
    setAttributeInternal(INCOMINGDOCSTSFK, value);
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
  public RowIterator getCrsIncomingDocCcTl()
  {
    return (RowIterator) getAttributeInternal(CRSINCOMINGDOCCCTL);
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
   * @param incomingDocCcPk key constituent

   * @return a Key object based on given key constituents.
   */
  public static Key createPrimaryKey(BigDecimal incomingDocCcPk)
  {
    return new Key(new Object[] { incomingDocCcPk });
  }

  protected void create(AttributeList attributeList)
  {
    super.create(attributeList);
    setIncomingDocStsFk(new BigDecimal(Constants.CC_DOCUMENT_NEW));
    setExecutionDateG(GenLib.getCurrentSqlDate());
    setExecutionDateH(HijriUtil.getTodayHijriBigDecimalWithDate());
  }
  
 
  
  protected void doDML(int operation, oracle.jbo.server.TransactionEvent e){
    if ((operation == DML_INSERT ||(operation == DML_UPDATE && isAttributeChanged("DepartmentsFk")))&&
                 getEmployeeFk() == null && getIncomingDocumentsFk() != null && getDepartmentsFk() != null){
        checkForUniqueInDocCc(getDepartmentsFk(),getEmployeeFk ()   , getIncomingDocumentsFk());
    }
    super.doDML(operation, e);
    if (operation == DML_INSERT) {
      BigDecimal maxCrsIncomingDocCcNumber = gen.common.GenLib.getPrimaryKeyValue(getDBTransaction(), "CRS_INCOMING_DOC_CC_SEQ");
      setIncomingDocCcPk(maxCrsIncomingDocCcNumber);
      insertIntoCrsIncomingDocCcTranslation();
    }
  }
  
  private void checkForUniqueInDocCc  (BigDecimal departmentNumber  , BigDecimal employeeNumber ,BigDecimal incomingDocumentNumber ){
    StringBuilder returnCountForDocCc = new StringBuilder("select count(incoming_doc_cc_pk)");
    returnCountForDocCc.append(" from crs_incoming_doc_cc ");
    returnCountForDocCc.append(" where departments_fk = "); 
    returnCountForDocCc.append(departmentNumber);
    if (employeeNumber!=null) {
      returnCountForDocCc.append(" and employee_fk  = ");
      returnCountForDocCc.append(employeeNumber);
    } else { 
      returnCountForDocCc.append(" and employee_fk is null");      
    }
    returnCountForDocCc.append(" and incoming_documents_fk = ");
    returnCountForDocCc.append(incomingDocumentNumber);
    int countForDocCc = DBUtil.getQueryResultAsInt(returnCountForDocCc.toString());
    if (countForDocCc != BigDecimal.ZERO.intValue()){
      throw new JboException(GenLib.getMessage("error.DuplicateCode"));
    }
  }
  
  private void insertIntoCrsIncomingDocCcTranslation  () {
    oracle.jbo.server.EntityDefImpl crsIncomingDocCcTlDefinition = CrsIncomingDocCcTlImpl.getDefinitionObject();
    java.util.List<Integer> activeLanguages = gen.common.GenLib.getActiveDataLanguages(getDBTransaction());
      for (Integer languageId : activeLanguages) {
      CrsIncomingDocCcTlImpl crsIncomingDocCcTlImpl = (CrsIncomingDocCcTlImpl)crsIncomingDocCcTlDefinition.createInstance2(getDBTransaction(), null);
      crsIncomingDocCcTlImpl.setLanguagesFk(new BigDecimal(languageId));
      crsIncomingDocCcTlImpl.setIncomingDocCcFk(getIncomingDocCcPk());
      crsIncomingDocCcTlImpl.setNotes(getDisplayNotes());
      crsIncomingDocCcTlImpl.setRejectReason(getDisplayRejectReason());
      crsIncomingDocCcTlImpl.setIncomingDocGuidance(getDisplayIncomingDocGuidance());
    }
  }
  

  public void remove()
  {
    gen.common.GenLib.removeTranlationRows(getCrsIncomingDocCcTl());
    super.remove();
  }
}

