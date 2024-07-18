package crs.controller.bean;

import com.sd.util.adf.ADFUtils;
import com.sd.util.db.DBUtil;

import gen.common.GenConstants;

import javax.faces.event.ActionEvent;

import oracle.adf.view.rich.component.rich.RichDocument;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.jbo.ViewObject;

public class GeneralSearchBean extends CrsBaseBean {

    private RichDocument doc;
    private static final String DOCUMENTS_VW_ITERATOR = "DocumentVwView1Iterator";

    public GeneralSearchBean() {
        if (!AdfFacesContext.getCurrentInstance().isPostback()) {
            ViewObject documentVo = ADFUtils.findIterator(DOCUMENTS_VW_ITERATOR).getViewObject();
            documentVo.setWhereClause(null);
            documentVo.executeQuery();
        }
    }

    public void runReport(ActionEvent actionEvent) {
        crsRunReport(actionEvent, DOCUMENTS_VW_ITERATOR, "IncomingDocumentsPk", "CrsDocumentsPk");
    }


    public void setDoc(RichDocument doc) {
        this.doc = doc;
    }

    public RichDocument getDoc() {
        return doc;
    }
}
