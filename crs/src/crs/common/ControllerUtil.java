package crs.common;

import com.sd.util.adf.ADFUtils;
import com.sd.util.db.DBUtil;

import gen.common.GenConstants;
import gen.common.GenLib;

import java.sql.Timestamp;
import java.sql.Date;
import java.util.Calendar;

import java.math.BigDecimal;


import java.sql.PreparedStatement;
import java.sql.ResultSet;

import oracle.jbo.JboException;
import oracle.jbo.Row;
import oracle.jbo.ViewObject;
import oracle.jbo.server.DBTransaction;

import oracle.jbo.server.ViewObjectImpl;



public class ControllerUtil
{
  private static final Object SELECT_FLAG = 1;
  private static final String REPORT_PARAMETER_ITERATOR = "ReportParametersRVO1Iterator";


  public static void filterSecurityLevelsAndDepartments(String iteratorName)
  {
    ViewObject vo = ADFUtils.findIterator(iteratorName).getViewObject();
    String securityLevelWhere = GenLib.getFiterDocumentsBySecurityLevelsWhereClause("SECURITY_LEVEL_FK");
    String fromDepartmentWhere = GenLib.getFilterByDepartmentWhereClause("FROM_DEPARTMENT_FK");
    String toDepartmentWhere = GenLib.getFilterByDepartmentWhereClause("TO_DEPARTMENT_FK");
    String whereClause = securityLevelWhere + " AND ( (" + fromDepartmentWhere + ") OR (" + toDepartmentWhere + " ) )";
    vo.setWhereClause(whereClause);
    vo.executeQuery();
  }

  public static void filterSecurityLevelsAndDistributionType(String iteratorName)
  {
    ViewObject vo = ADFUtils.findIterator(iteratorName).getViewObject();
    String securityLevelWhere = GenLib.getFiterDocumentsBySecurityLevelsWhereClause("SECURITY_LEVEL_FK");
    String distributionWhere = "CONFIRM_ASSIGNMENT_FL = 0 and DISTRIBUTION_TYPE_FK = " + Constants.MANUAL;
    String whereClause = securityLevelWhere + " AND (" + distributionWhere + ")";
    vo.setWhereClause(whereClause);
    vo.executeQuery();
  }

  public static String filterSupplyedTransaction()
  {
    String where = "(SUPPLY_FL IS NULL OR SUPPLY_FL = 0)";
    String filterDepToCc =
      "((TO_DEPARTMENT_FK= " + GenLib.getUserLoginDepartment() + ") or " + " ( select count(*) " +
      "from CRS_OUTGOING_DOC_CC " + "where OUTGOING_DOCUMENTS_FK = OUTGOING_DOCUMENTS_PK " +
      "and CRS_OUTGOING_DOC_CC.DEPARTMENTS_FK = " + GenLib.getUserLoginDepartment() + " ) <> 0)";

    String filterApprovedSts = "OUTING_DOC_STS_FK = " + Constants.OUTING_DOC_STS_FK;
    StringBuilder allCondition = new StringBuilder(where);
    allCondition.append(" and ");
    allCondition.append(filterDepToCc);
    allCondition.append(" and ");
    allCondition.append(filterApprovedSts);
    return allCondition.toString();
  }

  public static void insertIncomingBeneficiaries(Object beneficiariesPk, Object incomingDocumentsPk)
  {
    PreparedStatement stat = null;
    ResultSet rs = null;
    try
    {
      String insertCrsIncomingBeneficiariesSql =
        "insert into CRS_INCOMING_BENEFICIARIES " + "(INCOMING_BENEFICIARIES_PK, BENEFICIARIES_FK, " +
        "INCOMING_DOCUMENTS_FK, CREATED_BY, CREATION_DATE, USER_DEPARTMENT_FK) " + "values (null, " + beneficiariesPk +
        ", " + incomingDocumentsPk + ", " + GenLib.getUserId() + ", current_timestamp, " +
        GenLib.getUserLoginDepartment() + ")";
      DBUtil.executeDML(insertCrsIncomingBeneficiariesSql);
      GenLib.commitWithoutMessage();

    }
    catch (Exception ee)
    {

      GenLib.handleException(ee);

    }
    finally
    {
      DBUtil.close(rs);
      DBUtil.close(stat);
    }
  }

  public static void insertCrsDocDelivery(String iteratorName, String attributeName, int deliveryTypeFk)
  {

    try
    {

      DBTransaction dbt = ADFUtils.getDefaultDBTransaction();
      BigDecimal incomingDocumentsPk = null;
      BigDecimal outgoingDocumentsPk = null;
      BigDecimal statementNumber = GenLib.getNextMax(dbt, "CRS_DOCUMENTS_DELIVERY", "STATEMENT_NUMBER");

      if (deliveryTypeFk == GenConstants.OUTGOING_DOCUMENT)
      {
        outgoingDocumentsPk = (BigDecimal) ADFUtils.getAttribute(iteratorName, attributeName);
      }
      else if (deliveryTypeFk == GenConstants.INCOMING_DOCUMENT)
      {
        incomingDocumentsPk = (BigDecimal) ADFUtils.getAttribute(iteratorName, attributeName);
      }
      String insertToCrsDocumentDelivarySql =
        "insert into CRS_DOCUMENTS_DELIVERY " + "(DOCUMENTS_DELIVERY_PK, DELIVERY_TYPE_FK, INCOMING_DOCUMENTS_FK , " +
        "OUTGOING_DOCUMENTS_FK , CREATED_BY, CREATION_DATE, STATEMENT_NUMBER, USER_DEPARTMENT_FK) " + "values (null, " +
        deliveryTypeFk + ", " + incomingDocumentsPk + ", " + outgoingDocumentsPk + ", " + GenLib.getUserId() + ", " +
        "current_timestamp, " + statementNumber + ", " + GenLib.getUserLoginDepartment() + ")";
      DBUtil.executeDML(insertToCrsDocumentDelivarySql);
      ADFUtils.commitWithoutMessage();
      ADFUtils.setAttribute(REPORT_PARAMETER_ITERATOR, "StatementNumber", statementNumber);

    }
    catch (Exception e)
    {
      GenLib.handleException(e);
    }
  }

  public static void insertOutgoingBeneficiaries(Object beneficiariyId, Object outgoingDocumentId,
                                                 Object outgoingDocPreparationId)
  {
    PreparedStatement stat = null;
    ResultSet rs = null;
    try
    {

      String insertToCrsOutingBeneficiariesSql =
        "insert into CRS_OUTGOING_BENEFICIARIES " +
        "(OUTGOING_BENEFICIARIES_PK, BENEFICIARIES_FK, OUTGOING_DOCUMENTS_FK, " +
        "OUTGOING_DOC_PREPARATION_FK, CREATED_BY, CREATION_DATE, USER_DEPARTMENT_FK) " + "values (null, " +
        beneficiariyId + ", " + outgoingDocumentId + ", " + outgoingDocPreparationId + ", " + GenLib.getUserId() +
        ", current_timestamp, " + GenLib.getUserLoginDepartment() + ")";
      DBUtil.executeDML(insertToCrsOutingBeneficiariesSql);
      GenLib.commitWithoutMessage();

    }
    catch (Exception ee)
    {
      GenLib.handleException(ee);

    }
    finally
    {

      DBUtil.close(rs);
      DBUtil.close(stat);
    }
  }

  public static void insertIncomingDocCcFromDocClass(BigDecimal incomingDocumentId, Object classificationFk)
  {
    ViewObjectImpl crsDocClassCcVO =
      (ViewObjectImpl) ADFUtils.getDefaultApplicationModuleForDataControl().findViewObject("CrsDocClassCcView1");
    crsDocClassCcVO.setWhereClause("DOC_CLASS_FK = " + classificationFk);
    crsDocClassCcVO.executeQuery();
    int crsDocClassCcCount = (int) crsDocClassCcVO.getEstimatedRowCount();
    crsDocClassCcVO.first();
    for (int i = 0; i < crsDocClassCcCount; i++)
    {
      Row documentClassCurrentRow = crsDocClassCcVO.getCurrentRow();
      BigDecimal departmentId = (BigDecimal) documentClassCurrentRow.getAttribute("DepartmentsFk");
      BigDecimal actionId = (BigDecimal) documentClassCurrentRow.getAttribute("ActionFk");
      ControllerUtil.insertDocumenttoCc(null, incomingDocumentId, departmentId, null, actionId);
      crsDocClassCcVO.next();
    }
    ADFUtils.findIterator("CrsIncomingDocCcView1Iterator").executeQuery();

  }

  public static void commitDocumentCc(String iteratorName, String attributeName, String refreshIteratorName,
                                      String viewName)
  {

    checkUniqukeyforGroupCC(iteratorName, attributeName, viewName);
    Object actionFk = ADFUtils.getAttribute(REPORT_PARAMETER_ITERATOR, "ActionFk");
    Object departmentGroupId = ADFUtils.getAttribute(REPORT_PARAMETER_ITERATOR, "DeptGroupFk");
    BigDecimal documentId = (BigDecimal) ADFUtils.getAttribute(iteratorName, attributeName);

    ViewObjectImpl crsDeptGroupDeptsVO =
      (ViewObjectImpl) ADFUtils.getDefaultApplicationModuleForDataControl().findViewObject("CrsDeptGroupDeptsView1");
    crsDeptGroupDeptsVO.setWhereClause("DEPT_GROUP_FK = " + departmentGroupId);
    crsDeptGroupDeptsVO.executeQuery();
    int crsDeptGroupDeptscount = (int) crsDeptGroupDeptsVO.getEstimatedRowCount();
    crsDeptGroupDeptsVO.first();
    for (int i = 0; i < crsDeptGroupDeptscount; i++)
    {
      Row deptGroupCurrentRow = crsDeptGroupDeptsVO.getCurrentRow();
      BigDecimal departmentId = (BigDecimal) deptGroupCurrentRow.getAttribute("DepartmentsFk");
      BigDecimal userFk = (BigDecimal) deptGroupCurrentRow.getAttribute("UsersFk");
      ControllerUtil.insertDocumenttoCc(iteratorName, documentId, departmentId, userFk, actionFk);
      crsDeptGroupDeptsVO.next();
    }
    ADFUtils.commit();
    ADFUtils.findIterator(refreshIteratorName).executeQuery();
  }

  public static void insertDocumenttoCc(String iteratorName, BigDecimal incomingDocumentsPk, Object departments_fk,
                                        Object employee_fk, Object action_fk)
  {
    PreparedStatement stat = null;
    ResultSet rs = null;
    String tableName =
      iteratorName == "CrsOutgoingDocumentsView1Iterator"? "CRS_OUTGOING_DOC_CC": "crs_incoming_doc_cc";

    try
    {
      String insertDocumenttoCcsql =
        "insert into " + tableName + " (" +
        (iteratorName == "CrsOutgoingDocumentsView1Iterator"? "OUTGOING_DOC_CC_PK": "incoming_doc_cc_pk") + " ," +
        (iteratorName == "CrsOutgoingDocumentsView1Iterator"? "OUTGOING_DOCUMENTS_FK": "incoming_documents_fk") +
        " , " + "departments_fk, action_fk, CREATED_BY, CREATION_DATE, USER_DEPARTMENT_FK,employee_fk) " +
        "values (null, " + incomingDocumentsPk + ", " + departments_fk + ", " + action_fk + ", " + GenLib.getUserId() +
        ", current_timestamp, " + GenLib.getUserLoginDepartment() + ", " + employee_fk + ")";
      DBUtil.executeDML(insertDocumenttoCcsql);

    }
    catch (Exception ee)
    {
      GenLib.handleException(ee);
    }
    finally
    {
      DBUtil.close(rs);
      DBUtil.close(stat);
    }
  }

  public static void checkUniqukeyforGroupCC(String iteratorName, String attributeName, String viewName)
  {
    Object departmentGroupFk = ADFUtils.getAttribute(REPORT_PARAMETER_ITERATOR, "DeptGroupFk");
    BigDecimal documentId = (BigDecimal) ADFUtils.getAttribute(iteratorName, attributeName);
    ViewObjectImpl crsDeptGroupDeptsVO =
      (ViewObjectImpl) ADFUtils.getDefaultApplicationModuleForDataControl().findViewObject("CrsDeptGroupDeptsView1");
    crsDeptGroupDeptsVO.setWhereClause("DEPT_GROUP_FK = " + departmentGroupFk);
    crsDeptGroupDeptsVO.executeQuery();
    int crsDeptGroupDeptscount = (int) crsDeptGroupDeptsVO.getEstimatedRowCount();
    crsDeptGroupDeptsVO.first();
    for (int i = 0; i < crsDeptGroupDeptscount; i++)
    {
      Row departmentGroupCurrentRow = crsDeptGroupDeptsVO.getCurrentRow();
      BigDecimal departmentId = (BigDecimal) departmentGroupCurrentRow.getAttribute("DepartmentsFk");
      BigDecimal userFk = (BigDecimal) departmentGroupCurrentRow.getAttribute("UsersFk");
      checkUniqukeyforCrsIncomingDocCc(iteratorName, viewName, userFk, departmentId, documentId);
      crsDeptGroupDeptsVO.next();
    }

  }

  public static void checkUniqukeyforCrsIncomingDocCc(String iteratorName, String viewName, BigDecimal usersFk,
                                                      BigDecimal departmentFk, BigDecimal documentsPk)
  {

    ViewObject crsIncomingDocCcView = ADFUtils.getViewObjectFromAppModule(viewName);
    String documenttoCc = setDocumentFktoCc(iteratorName, documentsPk);
    crsIncomingDocCcView.setWhereClause(documenttoCc);
    crsIncomingDocCcView.executeQuery();
    int crsIncomingDocCcViewcount = (int) crsIncomingDocCcView.getEstimatedRowCount();
    crsIncomingDocCcView.first();
    for (int i = 0; i < crsIncomingDocCcViewcount; i++)
    {
      Row incomingDocumentCcCurrentRow = crsIncomingDocCcView.getCurrentRow();
      BigDecimal departmentId = (BigDecimal) incomingDocumentCcCurrentRow.getAttribute("DepartmentsFk");
      BigDecimal employeeId = (BigDecimal) incomingDocumentCcCurrentRow.getAttribute("EmployeeFk");
      if (departmentId.equals(departmentFk) && employeeId == (usersFk))
      {
        GenLib.showErrorMessage("error.DuplicateCode");
        throw new JboException("");
      }
      crsIncomingDocCcView.next();

    }
  }


  public static String setDocumentFktoCc(String iteratorName, BigDecimal documentsPk)
  {

    String setDocumentFk =
      iteratorName == "CrsOutgoingDocumentsView1Iterator"? "OUTGOING_DOCUMENTS_FK = " + documentsPk:
      "INCOMING_DOCUMENTS_FK = " + documentsPk;
    return setDocumentFk;
  }


  public static void commitDocumentDepartmentCc(String iteratorName, String attributeName, String refreshIteratorName,
                                                String viewName)
  {
    checkUniqukeyforDepartmentcc(iteratorName, attributeName, viewName);
    Row[] deparmentsRows = ADFUtils.findIterator("DeparmentsRVOIterator").getAllRowsInRange();
    for (int i = 0; i < deparmentsRows.length; i++)
    {
      Object SelectedFl = DBUtil.nvl(deparmentsRows[i].getAttribute("SelectedFl"), 0);
      if (SelectedFl.equals(SELECT_FLAG))
      {
        BigDecimal departmentsPk = (BigDecimal) deparmentsRows[i].getAttribute("DepartmentsPk");
        BigDecimal actionFk = (BigDecimal) ADFUtils.getAttribute(REPORT_PARAMETER_ITERATOR, "ActionFk");
        BigDecimal documentsPk = (BigDecimal) ADFUtils.getAttribute(iteratorName, attributeName);
        ControllerUtil.insertDocumenttoCc(iteratorName, documentsPk, departmentsPk, null, actionFk);
      }
    }
    ADFUtils.commit();
    ADFUtils.findIterator(refreshIteratorName).executeQuery();
  }

  public static void checkUniqukeyforDepartmentcc(String iteratorName, String attributeName, String viewName)
  {
    Row[] departmentsRows = ADFUtils.findIterator("DeparmentsRVOIterator").getAllRowsInRange();
    //    int i2 = 0; i2 < deparmentsRows.length; i2++
    for (Row departmentRow: departmentsRows)
    {
      BigDecimal departmentsPk = (BigDecimal) departmentRow.getAttribute("DepartmentsPk");
      Object SelectedFlag = DBUtil.nvl(departmentRow.getAttribute("SelectedFl"), 0);

      if (SelectedFlag.equals(SELECT_FLAG))
      {
        BigDecimal documentsPk = (BigDecimal) ADFUtils.getAttribute(iteratorName, attributeName);
        checkUniqukeyforCrsIncomingDocCc(iteratorName, viewName, null, departmentsPk, documentsPk);
      }
    }
  }

  public static BigDecimal getNumberingDependencyFk()
  {
    BigDecimal userLoginDepartment = gen.common
                                        .GenLib
                                        .getUserLoginDepartment();
    PreparedStatement statement = null;
    ResultSet rs = null;
    String getnumberingDependencyFkSql =
      "select numbering_dependency_fk " + "from hcm_departments " +
      "where numbering_dependency_fk is not null and departments_pk = " + userLoginDepartment;

    try
    {
      statement = ADFUtils.getDefaultDBTransaction().createPreparedStatement(getnumberingDependencyFkSql, 1);
      rs = statement.executeQuery();
      if (rs.next())
      {

        return rs.getBigDecimal("numbering_dependency_fk");

      }
      else
      {

        return userLoginDepartment;
      }

    }
    catch (Exception e)
    {

      e.printStackTrace();

    }
    finally
    {
      DBUtil.close(rs);
      DBUtil.close(statement);
    }
    return null;
  }

  public static String getDateTimeWithSecondsFormat()
  {
    return "dd/MM/yyyy HH:mm:ss";
  }

  public static String getDateTimeWithoutSecondsFormat()
  {
    return "dd/MM/yyyy HH:mm";
  }

  public static String getDateFormat()
  {
    return "dd/MM/yyyy";
  }

  public static Timestamp setTimeToEndOfDay(Timestamp timestamp)
  {
    if (timestamp == null)
    {
      return null;
    }

    Calendar calendar = Calendar.getInstance();
    calendar.setTimeInMillis(timestamp.getTime());
    calendar.set(Calendar.HOUR_OF_DAY, 23);
    calendar.set(Calendar.MINUTE, 59);
    calendar.set(Calendar.SECOND, 59);
    calendar.set(Calendar.MILLISECOND, 999);
    return new Timestamp(calendar.getTimeInMillis());
  }
}
