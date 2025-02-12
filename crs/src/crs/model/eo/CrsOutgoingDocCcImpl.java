package crs.model.eo;

import com.sd.util.db.DBUtil;

import gen.common.GenLib;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

import java.util.List;

import oracle.jbo.JboException;
import oracle.jbo.Key;
import oracle.jbo.RowIterator;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.EntityImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Sat Apr 01 13:34:55 GMT+03:00 2023
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class CrsOutgoingDocCcImpl
  extends AuditEntityImpl
{
  /**
   * Validation method for EmployeeFk.
   */
  public boolean validateEmployeeFk(BigDecimal employeefk){
    if (employeefk != null && getOutgoingDocumentsFk() != null && getDepartmentsFk() != null){
      checkForUniqueOutDocCc(getDepartmentsFk(), employeefk, getOutgoingDocumentsFk());
    }
    return true;
  }

  /**
   * Validation method for DepartmentsFk.
   */
  public boolean validateDepartmentsFk(BigDecimal departmentsfk){
    if (getEmployeeFk() != null && getOutgoingDocumentsFk() != null && departmentsfk != null){
      checkForUniqueOutDocCc(departmentsfk, getEmployeeFk(), getOutgoingDocumentsFk());
    }
    return true;
  }

  /**
   * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
   */
  protected enum AttributesEnum
  {
    OutgoingDocCcPk,
    OutgoingDocumentsFk,
    OutgoingDocPreparationFk,
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
    DisplayOutgoingDocGuidance,
    CrsOutgoingDocuments,
    CrsOutgoingDocPreparation,
    CrsOutgoingDocCcTl,
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


  public static final int OUTGOINGDOCCCPK = AttributesEnum.OutgoingDocCcPk.index();
  public static final int OUTGOINGDOCUMENTSFK = AttributesEnum.OutgoingDocumentsFk.index();
  public static final int OUTGOINGDOCPREPARATIONFK = AttributesEnum.OutgoingDocPreparationFk.index();
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
  public static final int DISPLAYOUTGOINGDOCGUIDANCE = AttributesEnum.DisplayOutgoingDocGuidance.index();
  public static final int CRSOUTGOINGDOCUMENTS = AttributesEnum.CrsOutgoingDocuments.index();
  public static final int CRSOUTGOINGDOCPREPARATION = AttributesEnum.CrsOutgoingDocPreparation.index();
  public static final int CRSOUTGOINGDOCCCTL = AttributesEnum.CrsOutgoingDocCcTl.index();
  public static final int HCMDEPARTMENTS = AttributesEnum.HcmDepartments.index();

  /**
   * This is the default constructor (do not remove).
   */
  public CrsOutgoingDocCcImpl()
  {
  }

  /**
   * @return the definition object for this instance class.
   */
  public static synchronized EntityDefImpl getDefinitionObject()
  {
    return EntityDefImpl.findDefObject("crs.model.eo.CrsOutgoingDocCc");
  }


  /**
   * Gets the attribute value for OutgoingDocCcPk, using the alias name OutgoingDocCcPk.
   * @return the value of OutgoingDocCcPk
   */
  public BigDecimal getOutgoingDocCcPk()
  {
    return (BigDecimal) getAttributeInternal(OUTGOINGDOCCCPK);
  }

  /**
   * Sets <code>value</code> as the attribute value for OutgoingDocCcPk.
   * @param value value to set the OutgoingDocCcPk
   */
  public void setOutgoingDocCcPk(BigDecimal value)
  {
    setAttributeInternal(OUTGOINGDOCCCPK, value);
  }

  /**
   * Gets the attribute value for OutgoingDocumentsFk, using the alias name OutgoingDocumentsFk.
   * @return the value of OutgoingDocumentsFk
   */
  public BigDecimal getOutgoingDocumentsFk()
  {
    return (BigDecimal) getAttributeInternal(OUTGOINGDOCUMENTSFK);
  }

  /**
   * Sets <code>value</code> as the attribute value for OutgoingDocumentsFk.
   * @param value value to set the OutgoingDocumentsFk
   */
  public void setOutgoingDocumentsFk(BigDecimal value)
  {
    setAttributeInternal(OUTGOINGDOCUMENTSFK, value);
  }

  /**
   * Gets the attribute value for OutgoingDocPreparationFk, using the alias name OutgoingDocPreparationFk.
   * @return the value of OutgoingDocPreparationFk
   */
  public BigDecimal getOutgoingDocPreparationFk()
  {
    return (BigDecimal) getAttributeInternal(OUTGOINGDOCPREPARATIONFK);
  }

  /**
   * Sets <code>value</code> as the attribute value for OutgoingDocPreparationFk.
   * @param value value to set the OutgoingDocPreparationFk
   */
  public void setOutgoingDocPreparationFk(BigDecimal value)
  {
    setAttributeInternal(OUTGOINGDOCPREPARATIONFK, value);
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
   * Gets the attribute value for DisplayOutgoingDocGuidance, using the alias name DisplayOutgoingDocGuidance.
   * @return the value of DisplayOutgoingDocGuidance
   */
  public String getDisplayOutgoingDocGuidance()
  {
    return (String) getAttributeInternal(DISPLAYOUTGOINGDOCGUIDANCE);
  }

  /**
   * Sets <code>value</code> as the attribute value for DisplayOutgoingDocGuidance.
   * @param value value to set the DisplayOutgoingDocGuidance
   */
  public void setDisplayOutgoingDocGuidance(String value)
  {
    setAttributeInternal(DISPLAYOUTGOINGDOCGUIDANCE, value);
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
   * @return the associated entity CrsOutgoingDocPreparationImpl.
   */
  public CrsOutgoingDocPreparationImpl getCrsOutgoingDocPreparation()
  {
    return (CrsOutgoingDocPreparationImpl) getAttributeInternal(CRSOUTGOINGDOCPREPARATION);
  }

  /**
   * Sets <code>value</code> as the associated entity CrsOutgoingDocPreparationImpl.
   */
  public void setCrsOutgoingDocPreparation(CrsOutgoingDocPreparationImpl value)
  {
    setAttributeInternal(CRSOUTGOINGDOCPREPARATION, value);
  }

  /**
   * @return the associated entity oracle.jbo.RowIterator.
   */
  public RowIterator getCrsOutgoingDocCcTl()
  {
    return (RowIterator) getAttributeInternal(CRSOUTGOINGDOCCCTL);
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
   * @param outgoingDocCcPk key constituent

   * @return a Key object based on given key constituents.
   */
  public static Key createPrimaryKey(BigDecimal outgoingDocCcPk)
  {
    return new Key(new Object[] { outgoingDocCcPk });
  }

  protected void doDML(int operation, oracle.jbo.server.TransactionEvent e){
    
    if (operation == DML_INSERT) {
      checkForUniqueOutDocCc(getDepartmentsFk() , getEmployeeFk(), getOutgoingDocumentsFk());
    }
    if (operation == DML_UPDATE && isAttributeChanged("DepartmentsFk")){
      checkForUniqueOutDocCc(getDepartmentsFk(), getEmployeeFk(), getOutgoingDocumentsFk());
    }
    super.doDML(operation, e);


    if (operation == DML_INSERT){
      BigDecimal outgoingDocCcPk = gen.common.GenLib.getPrimaryKeyValue(getDBTransaction(), "CRS_OUTGOING_DOC_CC_SEQ");
      setOutgoingDocCcPk(outgoingDocCcPk);
      insertIntoCrsOutgoingDocCcTl();  
    }
  }
  
  private void checkForUniqueOutDocCc(BigDecimal departmentsFk , BigDecimal employeeFk , BigDecimal outgoingDocumentsFk){
    
      StringBuilder selectQuery = new StringBuilder("select count(Outgoing_doc_cc_pk)");
      selectQuery.append(" from crs_Outgoing_doc_cc ");
      selectQuery.append(" where departments_fk = ").append(departmentsFk);
      if (employeeFk != null) {
         selectQuery.append(" and employee_fk = ").append(employeeFk);
      } else {
         selectQuery.append(" and employee_fk is null");
      }
      selectQuery.append(" and Outgoing_documents_fk = ").append(outgoingDocumentsFk);
      
      int countOutgoingDocCc = DBUtil.getQueryResultAsInt(selectQuery.toString());
      if (countOutgoingDocCc != BigDecimal.ZERO.intValue()){
        throw new JboException(GenLib.getMessage("error.DuplicateCode"));
      }
  }

  private void insertIntoCrsOutgoingDocCcTl(){
    oracle.jbo.server.EntityDefImpl crsOutgoingDocCcTlDef = CrsOutgoingDocCcTlImpl.getDefinitionObject();
    List<Integer> activeLanguages = GenLib.getActiveDataLanguages(getDBTransaction());
    for (Integer languageId : activeLanguages){
      CrsOutgoingDocCcTlImpl crsOutgoingDocCcTl = (CrsOutgoingDocCcTlImpl)crsOutgoingDocCcTlDef.
                                                                          createInstance2(getDBTransaction(), null);
      crsOutgoingDocCcTl.setLanguagesFk(BigDecimal.valueOf(languageId));
      crsOutgoingDocCcTl.setOutgoingDocCcFk(getOutgoingDocCcPk());
      crsOutgoingDocCcTl.setNotes(getDisplayNotes());
      crsOutgoingDocCcTl.setOutgoingDocGuidance(getDisplayOutgoingDocGuidance());
    }
  }
  
  public void remove(){
    gen.common.GenLib.removeTranlationRows(getCrsOutgoingDocCcTl());
    super.remove();
  }
}