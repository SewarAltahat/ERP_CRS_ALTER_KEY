package crs.controller.bean;

import com.sd.util.adf.ADFUtils;

import java.math.BigDecimal;

import oracle.adf.view.rich.event.DialogEvent;

import oracle.jbo.Row;

public class DocCcBean {
    public DocCcBean() {
        super();
    }

    public void choiseDeptCc(DialogEvent dialogEvent) {
        Row deptGroupCurrentRow = ADFUtils.findIterator("CrsDeptGroupRVOIterator").getCurrentRow();
        BigDecimal departmentGroupPk = (BigDecimal) deptGroupCurrentRow.getAttribute("DeptGroupPk");
        String departmentGroupName = (String) deptGroupCurrentRow.getAttribute("DisplayDeptGroupPk");
        ADFUtils.setAttribute("ReportParametersRVO1Iterator", "DeptGroupFk", departmentGroupPk);
        ADFUtils.setAttribute("ReportParametersRVO1Iterator", "DisplayDeptGroupFk", departmentGroupName);
    }
}
