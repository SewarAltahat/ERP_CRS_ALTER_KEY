package crs.controller.bean;

import java.io.OutputStream;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

public class SearchBeneficiaryDocumentBean extends CrsBaseBean 
{
  public void downloadDocumentAttachment(FacesContext context, OutputStream os) {
    downloadFile(context, os, "ArchiveVwView1Iterator", "ArcFilePath");
  }
  
  public void runReport(ActionEvent actionEvent) { 
    crsRunReport(actionEvent,"DocumentBeneficiariesVwView1Iterator", "IncomingDocumentsPk","CrsDocumentsPk"); 
  }
 
}