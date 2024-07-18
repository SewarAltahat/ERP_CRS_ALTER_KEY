package crs.controller.bean;

import com.sd.util.adf.ADFUtils;

import gen.common.BaseBean;
import gen.common.GenLib;

import java.sql.Timestamp;

import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import oracle.jbo.Row;
import oracle.jbo.ViewObject;

public class CrsBaseBean extends BaseBean 
{
  
  private static final String  REPORT_PARAMETERS_RVO_ITERATOR = "ReportParametersRVO1Iterator";
  
  public void crsRunReport(ActionEvent actionEvent, String iteratorName, String screenAttributeName, String reportAttributeName) {
    Object crsDocumentPk = ADFUtils.getAttribute(iteratorName, screenAttributeName);
    ADFUtils.setAttribute(REPORT_PARAMETERS_RVO_ITERATOR, reportAttributeName, crsDocumentPk);
    super.runReport(actionEvent);
  }
  
  public void runScreenReport(ActionEvent actionEvent) {
    Timestamp dateTo = (Timestamp)ADFUtils.getAttribute(REPORT_PARAMETERS_RVO_ITERATOR, "DateTo"); 
    if (dateTo != null) {
      java.util.Date addOneDayToDate = addDays(dateTo, 1);
      ADFUtils.setAttribute(REPORT_PARAMETERS_RVO_ITERATOR, "AddDayToDateTo", addOneDayToDate);
    }
    ADFUtils.setAttribute(REPORT_PARAMETERS_RVO_ITERATOR, "DepartmentWhere", GenLib.getFilterByDepartmentWhereClause("USER_DEPARTMENT_FK"));
    ADFUtils.setAttribute(REPORT_PARAMETERS_RVO_ITERATOR, "SecurityWhere", GenLib.getFiterDocumentsBySecurityLevelsWhereClause("SECURITY_LEVEL_FK"));
    super.runReport(actionEvent);
  }
  
  public void dateFromReportChanged(ValueChangeEvent vce){
    convertGregorianToHijri(vce, REPORT_PARAMETERS_RVO_ITERATOR, "HijriDateFrom", "HijriDateFrom");
  }

  public void hijriDateFromReportChanged(ValueChangeEvent vce) {
    convertHijriToGregorian(vce, REPORT_PARAMETERS_RVO_ITERATOR, "DateFrom", "DateFrom");
  }
  
  public void dateToReportChanged(ValueChangeEvent vce) {
    convertGregorianToHijri(vce, REPORT_PARAMETERS_RVO_ITERATOR, "HijriDateTo", "HijriDateTo");
  }

  public void hijriDateToReportChanged(ValueChangeEvent vce) {
    convertHijriToGregorian(vce, REPORT_PARAMETERS_RVO_ITERATOR, "DateTo", "DateTo");
  }
  
  public void selectAll(ActionEvent e)
  {
    changeSelection(e, 1);
  }

  public void deSelectAll(ActionEvent e)
  {
    changeSelection(e, 0);
  }
  
  public void selectAllInFregment(ActionEvent e)
  {
    changeSelectionInFregment(e, 1);
  }
  
  public void deSelectAllInFregment(ActionEvent e)
  {
    changeSelectionInFregment(e, 0);
  }

  public void changeSelection(ActionEvent e, int value)
  {
    String iteratorName = (String) e.getComponent().getAttributes().get("iteratorName"); 
    ADFUtils.findIterator(iteratorName).setRangeSize(-1);
    Row[] rows = ADFUtils.findIterator(iteratorName).getAllRowsInRange();
    for (int i = 0; i < rows.length; i++)
    {
      rows[i].setAttribute("SelectedFl", new oracle.jbo.domain.Number(value));
    }
  }
  
  public void changeSelectionInFregment(ActionEvent e, int value)
  {
    String iteratorName = (String) e.getComponent().getAttributes().get("iteratorName"); 
    ADFUtils.findIterator(iteratorName).setRangeSize(-1);
    Row[] rows = ADFUtils.findIterator(iteratorName).getAllRowsInRange();
    for (int i = 0; i < rows.length; i++)
    {
      System.err.println("Befor SelectedFl === "+rows[i].getAttribute("SelectedFl"));
      rows[i].setAttribute("SelectedFl", new oracle.jbo.domain.Number(value));
      System.err.println("     ");
      System.err.println("After SelectedFl === "+rows[i].getAttribute("SelectedFl"));

    } 
  }
}