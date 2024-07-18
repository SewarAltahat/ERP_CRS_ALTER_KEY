package crs.controller.bean;

import com.sd.util.adf.ADFUtils;

import gen.common.GenConstants;
import gen.common.GenLib;

import java.sql.Timestamp;

import javax.faces.event.ValueChangeEvent;

import oracle.jbo.ApplicationModule;
import oracle.jbo.server.ViewObjectImpl;


public class EntryCountReportBean extends CrsBaseBean {
  
  private static final String  REPORT_PARAMETERS_RVO_ITERATOR = "ReportParametersRVO1Iterator";
  private static final String  DATE_TO_PARAM = "DateTo";
  
  public String getEntryCountReportData(){
    Timestamp dateToParameter = (Timestamp) ADFUtils.getAttribute(REPORT_PARAMETERS_RVO_ITERATOR, DATE_TO_PARAM);
    
    if (dateToParameter != null) {
      java.util.Date addOneDayToDate = addDays(dateToParameter, 1);
      ADFUtils.setAttribute(REPORT_PARAMETERS_RVO_ITERATOR, "AddDayToDateTo", addOneDayToDate);
    }
    
    ViewObjectImpl entryCountDocView = (ViewObjectImpl) ADFUtils.getDefaultApplicationModuleForDataControl().
                                                                 findViewObject("EntryCountDocView1");
    entryCountDocView.setNamedWhereClauseParam("p_from_department_fk", 
                                               ADFUtils.getAttribute(REPORT_PARAMETERS_RVO_ITERATOR,"FromDepartmentFk"));
    entryCountDocView.setNamedWhereClauseParam("p_to_department_fk", 
                                               ADFUtils.getAttribute(REPORT_PARAMETERS_RVO_ITERATOR, "ToDepartmentFk"));
    entryCountDocView.setNamedWhereClauseParam("p_doc_type_fk",
                                               ADFUtils.getAttribute(REPORT_PARAMETERS_RVO_ITERATOR, "DocTypeFk"));
    entryCountDocView.setNamedWhereClauseParam("p_security_level_fk", 
                                               ADFUtils.getAttribute(REPORT_PARAMETERS_RVO_ITERATOR,"SecurityLevelFk"));
    entryCountDocView.setNamedWhereClauseParam("p_priority_fk",
                                               ADFUtils.getAttribute(REPORT_PARAMETERS_RVO_ITERATOR, "PriorityFk"));
    entryCountDocView.setNamedWhereClauseParam("p_date_from", 
                                               ADFUtils.getAttribute(REPORT_PARAMETERS_RVO_ITERATOR, "DateFrom"));
    entryCountDocView.setNamedWhereClauseParam("p_date_to",
                                               ADFUtils.getAttribute(REPORT_PARAMETERS_RVO_ITERATOR, DATE_TO_PARAM));

    entryCountDocView.executeQuery();

    return null;
  }


  public void hijriDateFromChanged(ValueChangeEvent vce)
  {
    convertHijriToGregorian(vce, REPORT_PARAMETERS_RVO_ITERATOR, "DateFrom", "DateFrom");
  }

  public void dateFromChanged(ValueChangeEvent vce)
  {
    convertGregorianToHijri(vce, REPORT_PARAMETERS_RVO_ITERATOR, "HijriDateFrom", "HijriDateFrom");
  }

  public void dateToChanged(ValueChangeEvent vce)
  {
    convertGregorianToHijri(vce, REPORT_PARAMETERS_RVO_ITERATOR, "HijriDateTo", "HijriDateTo");
  }

  public void hijriDateToChanged(ValueChangeEvent vce)
  {
    convertHijriToGregorian(vce, REPORT_PARAMETERS_RVO_ITERATOR, DATE_TO_PARAM, DATE_TO_PARAM);
  }
}
