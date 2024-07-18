package crs.controller.bean;

import com.sd.util.adf.ADFUtils;
import com.sd.util.adf.JSFUtils;
import com.sd.util.db.DBUtil;

import crs.common.ControllerUtil;

import crs.model.AppModuleImpl;

import gen.common.GenLib;

import java.io.OutputStream;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.MethodExpression;
import javax.el.ValueExpression;

import javax.faces.application.Application;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCDataControl;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.model.generic.DCRowSetIteratorImpl;
import oracle.adf.share.ADFContext;
import oracle.adf.view.rich.component.rich.RichDialog;
import oracle.adf.view.rich.component.rich.RichDocument;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.layout.RichPanelTabbed;
import oracle.adf.view.rich.component.rich.layout.RichShowDetailItem;
import oracle.adf.view.rich.component.rich.nav.RichCommandLink;
import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.adf.view.rich.event.DialogEvent;
import oracle.adf.view.rich.event.PopupCanceledEvent;

import oracle.adf.view.rich.event.QueryEvent;

import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewObject;
import oracle.jbo.server.ViewObjectImpl;

import org.apache.myfaces.trinidad.component.UIXIterator;

public class DocAssignmentBean
  extends CrsBaseBean
{
  private PaginationManaged paginationManaged = new PaginationManaged();;
  // iter
  private UIXIterator laborJobsROView1Iterator;
  private UIXIterator pageNoIterator;
  private boolean bindPreviousButton;
  private boolean bindFirstButton;
  private boolean bindNextButton;
  private boolean bindLastButton;
  private boolean paginnationPG;
  private RichCommandLink pagiCommand; 

  // 
  int pageNum ;
  
  private int val = 1;

  private RichDocument docAssignment;
  private RichDocument docassignment;
  private RichTable crsIncomingDocCcTable;
  private static final String CRS_INCOMING_DOCUMENTS_DOC_ASSIGNMENT_VIEW_ITERATOR =
    "CrsIncomingDocumentsDocAssignmentViewIterator";
  private static final String CRS_INCOMING_DOCUMENTS_COPY_DOC_CC_VIEW_ITERATOR =
    "CrsIncomingDocumentsCopyDocCcViewIterator";
  private static final String CRS_INCOMING_DOC_CC_DOC_ASSIGNMENT_VIEW_ITERATOR =
    "CrsIncomingDocCcDocAssignmentViewIterator";
  private static final String INCOMING_DOCUMENTS_PK = "IncomingDocumentsPk";
  private static final BigDecimal ACTIVE_FLAG = new BigDecimal(1);
  private static final Object SELECT_FLAG = 1;
  private RichShowDetailItem archiveSDI = new RichShowDetailItem();
  private RichDialog inDocViewDialog;
  private RichPopup inDocViewPopup;
  private RichPopup docReferralPopup;
  private RichPopup copyDocCCPopup;
  private RichPopup updateConfirmAssignmentFlPopup;
  private RichPopup crsIncomingArchivePopup;
  private RichPopup crsIncomingDocCcTlPopup;

  public void setPageNum(int pageNum)
  {
    this.pageNum = pageNum;
  }

  public int getPageNum()
  {
    return pageNum;
  }

  public DocAssignmentBean()
  { 
    if (!AdfFacesContext.getCurrentInstance().isPostback())
    {
      ControllerUtil.filterSecurityLevelsAndDistributionType(CRS_INCOMING_DOCUMENTS_DOC_ASSIGNMENT_VIEW_ITERATOR);
      ControllerUtil.filterSecurityLevelsAndDistributionType(CRS_INCOMING_DOCUMENTS_COPY_DOC_CC_VIEW_ITERATOR);
      GenLib.filterDocumentsBySecurityLevels("CrsIncomingArchiveDocAssignmentViewIterator", "SECURITY_LEVEL_FK");
    }
    if (!AdfFacesContext.getCurrentInstance().isPostback())
    { 
      setVal(1);
      paginationManaged.setFirst(1);
      paginationManaged.setMidvalue(paginationManaged.getRowsPerPage());
      setBindPreviousButton(true);
      setBindNextButton(false);
      defaultMethod();
    }
  }

  public static Object getManagedBeanValue(String beanName)
  {
    StringBuffer buff = new StringBuffer("#{");
    buff.append(beanName);
    buff.append("}");
    return resolveExpression(buff.toString());
  }

  public static Object resolveExpression(String expression)
  {
    FacesContext facesContext = getFacesContext();
    Application app = facesContext.getApplication();
    ExpressionFactory elFactory = app.getExpressionFactory();
    ELContext elContext = facesContext.getELContext();
    ValueExpression valueExp = elFactory.createValueExpression(elContext, expression, Object.class);
    return valueExp.getValue(elContext);
  }

  public static FacesContext getFacesContext()
  {
    return FacesContext.getCurrentInstance();
  }

  public void setArchiveSDI(RichShowDetailItem archiveSDI)
  {
    this.archiveSDI = archiveSDI;
  }

  public RichShowDetailItem getArchiveSDI()
  {
    return archiveSDI;
  }  
  

  public void downloadIncomingArchiveAttachment(FacesContext context, OutputStream os)
  {
    downloadFile(context, os, "CrsIncomingArchiveDocAssignmentViewIterator", "ArcFilePath");
  }

  public void commitDocCc(DialogEvent de)
  {
    if (de.getOutcome() == DialogEvent.Outcome.ok) 
    {
     ControllerUtil.commitDocumentCc(CRS_INCOMING_DOCUMENTS_DOC_ASSIGNMENT_VIEW_ITERATOR, INCOMING_DOCUMENTS_PK,
                                     CRS_INCOMING_DOC_CC_DOC_ASSIGNMENT_VIEW_ITERATOR,
                                     "CrsIncomingDocCcDocAssignmentView");
    } 
  }

  public void cancelAddDocCc(PopupCanceledEvent de)
  {
    cancelTranslation(de, CRS_INCOMING_DOC_CC_DOC_ASSIGNMENT_VIEW_ITERATOR);
  }

  public void cancelAddDocDeptCc(PopupCanceledEvent de)
  {
    cancelTranslation(de, CRS_INCOMING_DOC_CC_DOC_ASSIGNMENT_VIEW_ITERATOR);
  }

  public void commitDocDeptCc(DialogEvent dialogEvent)
  {
    ControllerUtil.commitDocumentDepartmentCc(CRS_INCOMING_DOCUMENTS_DOC_ASSIGNMENT_VIEW_ITERATOR,
                                              INCOMING_DOCUMENTS_PK, CRS_INCOMING_DOC_CC_DOC_ASSIGNMENT_VIEW_ITERATOR,
                                              "CrsIncomingDocCcDocAssignmentView");
  }

  public void updateConfirmAssignmentFl(DialogEvent dialogEvent)
  {
    ADFUtils.setAttribute(CRS_INCOMING_DOCUMENTS_DOC_ASSIGNMENT_VIEW_ITERATOR, "ConfirmAssignmentFl", ACTIVE_FLAG);
    ADFUtils.commit();
    refreshIterator(CRS_INCOMING_DOCUMENTS_DOC_ASSIGNMENT_VIEW_ITERATOR);
    refreshIterator(CRS_INCOMING_DOCUMENTS_COPY_DOC_CC_VIEW_ITERATOR);
  }

  public void cancelTranslation(PopupCanceledEvent de)
  {
    cancelTranslation(de, CRS_INCOMING_DOCUMENTS_DOC_ASSIGNMENT_VIEW_ITERATOR);
  }

  public void setDocAssignment(RichDocument docAssignment)
  {
    this.docAssignment = docAssignment;
  }

  public RichDocument getDocAssignment()
  {
    return docAssignment;
  }

  public void setDocassignment(RichDocument docassignment)
  {
    this.docassignment = docassignment;
  }

  public RichDocument getDocassignment()
  {
    return docassignment;
  } 

  public String insertDocReferral()
  {
    refreshIterator("ReportParametersRVO1Iterator");
    RichPopup.PopupHints hints = new RichPopup.PopupHints(); 
    this.docReferralPopup.show(hints); 
//    showPopup("docReferralPopup");
    return null;
  }

  public void executionDateHChanged(ValueChangeEvent vce)
  {
    convertHijriToGregorian(vce, CRS_INCOMING_DOC_CC_DOC_ASSIGNMENT_VIEW_ITERATOR, "ExecutionDateG",
                            "crsIncomingDocCcExecutiondateg");
  }

  public void executionDateGChanged(ValueChangeEvent vce)
  {
    convertGregorianToHijri(vce, CRS_INCOMING_DOC_CC_DOC_ASSIGNMENT_VIEW_ITERATOR, "ExecutionDateH",
                            "crsIncomingDocCcExecutiondateh");
  }

  public String rollbackAction()
  {
    ADFUtils.rollback();
    ADFUtils.executeOperator("CreateInsert");
    return null;
  }

  public void setCrsIncomingDocCcTable(RichTable crsIncomingDocCcTable)
  {
    this.crsIncomingDocCcTable = crsIncomingDocCcTable;
  }

  public RichTable getCrsIncomingDocCcTable()
  {
    return crsIncomingDocCcTable;
  }

  public String editRecord()
  {
    return "indoc";
  }

  public String viewAction()
  {
  RichPopup.PopupHints hints = new RichPopup.PopupHints(); 
  this.inDocViewPopup.show(hints);
//  showPopup("r1:p1");
    return null;
  }

  public void cancelCopyDocCC(PopupCanceledEvent de)
  {
    cancelTranslation(de, CRS_INCOMING_DOCUMENTS_COPY_DOC_CC_VIEW_ITERATOR);
  }

  public void commitCopyDocCC(DialogEvent dialogEvent)
  {
    selectedDocCC();
    ADFUtils.commit();
    refreshIterator(CRS_INCOMING_DOC_CC_DOC_ASSIGNMENT_VIEW_ITERATOR);
  }

  public void selectedDocCC()
  {
    BigDecimal incomingDocumentPk =
      (BigDecimal) ADFUtils.getAttribute(CRS_INCOMING_DOCUMENTS_DOC_ASSIGNMENT_VIEW_ITERATOR, INCOMING_DOCUMENTS_PK);
    Row[] crsIncomingDocumentList =
      ADFUtils.findIterator(CRS_INCOMING_DOCUMENTS_COPY_DOC_CC_VIEW_ITERATOR).getAllRowsInRange();
    for (int i = 0; i < crsIncomingDocumentList.length; i++)
    {
      Object seletedFlag = DBUtil.nvl(crsIncomingDocumentList[i].getAttribute("SelectFl"), 0);
      if (seletedFlag.equals(SELECT_FLAG))
      {
        BigDecimal incomingDocumentFk = (BigDecimal) crsIncomingDocumentList[i].getAttribute(INCOMING_DOCUMENTS_PK);
        if (!incomingDocumentPk.equals(incomingDocumentFk))
        {
          deleteFromDocCC(incomingDocumentFk);
          insertIntoDocCC(incomingDocumentPk, incomingDocumentFk);
        }
      }
    }
  }

  public void deleteFromDocCC(BigDecimal incomingDocumentFk)
  {
    String removeAllTranslateData =
      "delete from crs_incoming_doc_cc where incoming_documents_fk = " + incomingDocumentFk;
    try
    {
      DBUtil.executeDML(removeAllTranslateData);
    }
    catch (Exception e1)
    {
      e1.printStackTrace();
    }
  }

  public void insertIntoDocCC(BigDecimal IncomingDocumentsPk, BigDecimal incomingDocumentFk)
  {
    ViewObjectImpl crsDocClassCcVo =
      (ViewObjectImpl) ADFUtils.getDefaultApplicationModuleForDataControl().findViewObject("CrsIncomingDocCcCopyView");
    crsDocClassCcVo.setWhereClause("INCOMING_DOCUMENTS_FK = " + IncomingDocumentsPk);
    crsDocClassCcVo.executeQuery();
    int crsDocClassCcCount = (int) crsDocClassCcVo.getEstimatedRowCount();
    crsDocClassCcVo.first();
    for (int i = 0; i < crsDocClassCcCount; i++)
    {
      Object departmentsFk = crsDocClassCcVo.getCurrentRow().getAttribute("DepartmentsFk");
      Object actionFk = crsDocClassCcVo.getCurrentRow().getAttribute("ActionFk");
      Object employeeFk = crsDocClassCcVo.getCurrentRow().getAttribute("EmployeeFk");
      ControllerUtil.insertDocumenttoCc(null, IncomingDocumentsPk, departmentsFk, employeeFk, actionFk);
      crsDocClassCcVo.next();
    }
  }

  public String refreshView()
  {
    refreshIterator(CRS_INCOMING_DOCUMENTS_COPY_DOC_CC_VIEW_ITERATOR);
    RichPopup.PopupHints hints = new RichPopup.PopupHints(); 
    this.copyDocCCPopup.show(hints);
//    showPopup("CopyDocCCPopup");
    return null;
  }

  public void refreshIterator(String iteratorName)
  {
    ADFUtils.findIterator(iteratorName).executeQuery();
  }

  public String openArchive()
  {
    archiveSDI.setDisclosed(true);
    return null;
  }

  public void commitCrsIncomingDocCcTlTranslation(oracle.adf.view.rich.event.DialogEvent de)
  {
    commitTranslation(de, "CrsIncomingDocCcDocAssignmentViewIterator");
  }

  public void cancelCrsIncomingDocCcTlTranslation(oracle.adf.view.rich.event.PopupCanceledEvent de)
  {
    cancelTranslation(de, "CrsIncomingDocCcDocAssignmentViewIterator");
  }

  //iter Methods
  public void setLaborJobsROView1Iterator(UIXIterator laborJobsROView1Iterator)
  {
    this.laborJobsROView1Iterator = laborJobsROView1Iterator;
  }

  public UIXIterator getLaborJobsROView1Iterator()
  {
    return laborJobsROView1Iterator;
  }

  public void setPageNoIterator(UIXIterator pageNoIterator)
  {
    this.pageNoIterator = pageNoIterator;
  }

  public UIXIterator getPageNoIterator()
  {
    return pageNoIterator;
  }

  public void setBindPreviousButton(boolean bindPreviousButton)
  {
    this.bindPreviousButton = bindPreviousButton;
  }

  public boolean isBindPreviousButton()
  {
    return bindPreviousButton;
  }

  public void setBindFirstButton(boolean bindFirstButton)
  {
    this.bindFirstButton = bindFirstButton;
  }

  public boolean isBindFirstButton()
  {
    return bindFirstButton;
  }

  public void setBindNextButton(boolean bindNextButton)
  {
    this.bindNextButton = bindNextButton;
  }

  public boolean isBindNextButton()
  {
    return bindNextButton;
  }

  public void setBindLastButton(boolean bindLastButton)
  {
    this.bindLastButton = bindLastButton;
  }

  public boolean isBindLastButton()
  {
    return bindLastButton;
  }

  public void setPaginnationPG(boolean paginnationPG)
  {
    this.paginnationPG = paginnationPG;
  }

  public boolean isPaginnationPG()
  {
    return paginnationPG;
  }

  public void setPagiCommand(RichCommandLink pagiCommand)
  {
    this.pagiCommand = pagiCommand;
  }

  public RichCommandLink getPagiCommand()
  {
    return pagiCommand;
  } 
  public void setVal(int val)
  {
    this.val = val;
  }

  public int getVal()
  {
    return val;
  }
  // --------------------------------------
  // Iter Button methods
  //this methods is call for first button Action Listener
  //this methods is call for first button Action Listener
  public void firstActionListener(ActionEvent actionEvent)
  {
    try
    {
      this.laborJobsROView1Iterator.setFirst(0);
      this.getPageNoIterator().setFirst(0);
      paginationManaged.setFirst(1);
      setVal(1);
      paginationManaged.setLast(paginationManaged.getRowsPerPage());

      setBindFirstButton(true);
      setBindLastButton(false);
      setBindNextButton(false);
      setBindPreviousButton(true);

    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }
  // this methods is call for previous button Action Listener
  public void previousActionListener(ActionEvent actionEvent)
  {
    try
    {
      setVal(getVal() - 1);

      this.laborJobsROView1Iterator.setFirst(this.laborJobsROView1Iterator.getFirst() -
                                             paginationManaged.getRowsPerPage());
      setBindFirstButton(false);
      setBindLastButton(false);
      setBindNextButton(false);
      setBindPreviousButton(false);

      if (getVal() == 1)
      {
       setBindPreviousButton(true);
       setBindFirstButton(true);
      }
      if (getPageNum() <= 8)
      {
        this.getPageNoIterator().setFirst(0);
      }
      else
      {
        this.getPageNoIterator().setFirst(this.getPageNoIterator().getFirst() - 1);
      }
      paginationManaged.setFirst(paginationManaged.getFirst() - paginationManaged.getRowsPerPage());
      paginationManaged.setLast(paginationManaged.getFirst() + paginationManaged.getRowsPerPage() - 1);

    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }
  //this methods is used to next button Action Listener
  public void nextActionListener(ActionEvent actionEvent)
  {System.err.println(getPageNum());
    try
    {
      int val = getVal() + 1;
      int firest = this.getPageNoIterator().getFirst() + 1 ;
      int IteratorFirst = this.laborJobsROView1Iterator.getFirst() ;
      int rowsPerPage = paginationManaged.getRowsPerPage() ;
      int noOfPAge = getPageNum() ; 

      setVal(val);
      this.getPageNoIterator().setFirst(firest);

      this.laborJobsROView1Iterator.setFirst(IteratorFirst + rowsPerPage);
      // archiveBulletinsManagedBean.setBindPreviousButton(false);
      setBindFirstButton(false);
      setBindLastButton(false);
      setBindNextButton(false);
      setBindPreviousButton(false);
       
      if (noOfPAge == val)
      {
        setBindNextButton(true);
        setBindLastButton(true); 
      }
      else
      {
        setBindNextButton(false); 
      }
      if (getPageNum() <= 8)
      {
        this.getPageNoIterator().setFirst(0);
      }
      if ((getPageNum() > 8) &&
          (getPageNum() - getVal() <= 8))
      {
        this.getPageNoIterator().setFirst(getPageNum() - 8);
      }
      paginationManaged.setFirst(this.paginationManaged.getFirst() + 1);
      paginationManaged.setLast(this.laborJobsROView1Iterator.getFirst() + paginationManaged.getRowsPerPage()); 
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }
  //this methods is call for last button action Listener
  public void lastActionListener(ActionEvent actionEvent)
  {
    try
    {
      setVal(getPageNum());
      int rowCount = ((getVal() - 1) * (paginationManaged.getRowsPerPage()));
      this.laborJobsROView1Iterator.setFirst(rowCount);
      setBindPreviousButton(false);
      setBindNextButton(false);
      if (getPageNum() <= 8)
      {
        this.getPageNoIterator().setFirst(0);
      }
      else
      {
        this.getPageNoIterator().setFirst(getPageNum() - 8);
      }
      setBindFirstButton(false);
      setBindLastButton(false);
      setBindNextButton(false);
      setBindPreviousButton(false);
      if (getPageNum() == getVal())
      {
        setBindLastButton(true);
        setBindNextButton(true);
      }
      else
      {
        setBindLastButton(false);
        setBindNextButton(false);
      }
      paginationManaged.setFirst(this.laborJobsROView1Iterator.getFirst() + 1);
      paginationManaged.setLast(this.laborJobsROView1Iterator.getFirst() + paginationManaged.getRowsPerPage());
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }

  public void defaultMethod()
  {
    System.out.println("calling default method");
    
    long tableRowsCount = ADFUtils.findIterator("CrsIncomingDocumentsDocAssignmentViewIterator").getViewObject().getEstimatedRowCount();
    Integer  tableRowsCountInt = (int) (long) tableRowsCount;
    int rowPerPage = paginationManaged.getRowsPerPage() ;
    
    paginationManaged.setRowCount(tableRowsCount);
    paginationManaged.setTotal(tableRowsCount);
    paginationManaged.setMidvalue(rowPerPage);
    
    
    
    if (tableRowsCount % rowPerPage == 0)
    {
     setPageNum(tableRowsCountInt /rowPerPage); 
    }
    else
    {
     setPageNum(tableRowsCountInt / rowPerPage + 1); 
    }
    
    if (tableRowsCountInt < rowPerPage)
    {
      paginationManaged.setPaginnationPG(false);
    }
    else
    {
      paginationManaged.setPaginnationPG(true);
    }
    int paginationListNumber = getPageNum();
    
    if (paginationManaged.getLi() != null)
    {
      paginationManaged.getLi().clear();
      for (int i = 0; i < paginationListNumber; i++)
      {
        paginationManaged.getLi().add(i + 1);
      }
    }
    if (paginationManaged.getLi().size() == 1)
    {
      setBindNextButton(true);
      setBindLastButton(true);
    }
    else
    {
      setBindNextButton(false);
      setBindLastButton(false);
    }
    setBindFirstButton(true); 
    setBindPreviousButton(true);System.err.println("getPageNum ========================== "+getPageNum());
  }
  
  public void callPage(ActionEvent actionEvent)
  {
    System.out.println("calling method inside page link");
    try
    {
      RichCommandLink cmdLink = (RichCommandLink) actionEvent.getComponent();

      setVal(Integer.valueOf(cmdLink.getText()));
      if (getPageNum() <= 8)
      {
        this.getPageNoIterator().setFirst(0);
        setBindNextButton(false);
        setBindPreviousButton(false);
        setBindFirstButton(true);
        setBindLastButton(true);
      }
      else
      {
        getPageNoIterator().setFirst(getVal() - 1);
        setBindFirstButton(false);
        setBindLastButton(false);
        setBindNextButton(false);
        setBindPreviousButton(false);
      }
      if (getVal() == 1)
      {
       setBindFirstButton(true);
        setBindPreviousButton(true); 
        this.getPageNoIterator().setFirst(0);
      }
      if ((getPageNum() > 8) && (getPageNum() - getVal() <= 8))
      {
        this.getPageNoIterator().setFirst(getPageNum() - 8);
      }

      if (getVal() == getPageNum())
      {
        setBindNextButton(true);
        setBindLastButton(true);

      }
      else
      {
        setBindNextButton(false);

      } 
      this.laborJobsROView1Iterator.setFirst((getVal() - 1) * paginationManaged.getRowsPerPage());
      paginationManaged.setFirst((getVal() - 1) * paginationManaged.getRowsPerPage() + 1);
      paginationManaged.setLast(getVal() * paginationManaged.getRowsPerPage());
      if (getVal() == getPageNum())
      {
        paginationManaged.setFirst((getVal() - 1) * paginationManaged.getRowsPerPage() + 1);
        paginationManaged.setLast((paginationManaged.getFirst() - 1) +  paginationManaged.getTotal() % paginationManaged.getRowsPerPage());
      }
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }

  }   
  
  public void setCurrentRowIndex(ActionEvent actionEvent) { 
    RichPopup.PopupHints hints = new RichPopup.PopupHints(); 
    this.inDocViewPopup.show(hints);
    }

  public void setInDocViewPopup(RichPopup inDocViewPopup)
  {
    this.inDocViewPopup = inDocViewPopup;
  }

  public RichPopup getInDocViewPopup()
  {
    return inDocViewPopup;
  }

  public void setDocReferralPopup(RichPopup docReferralPopup)
  {
    this.docReferralPopup = docReferralPopup;
  }

  public RichPopup getDocReferralPopup()
  {
    return docReferralPopup;
  }

  public void setCopyDocCCPopup(RichPopup copyDocCCPopup)
  {
    this.copyDocCCPopup = copyDocCCPopup;
  }

  public RichPopup getCopyDocCCPopup()
  {
    return copyDocCCPopup;
  }

  public void setUpdateConfirmAssignmentFlPopup(RichPopup updateConfirmAssignmentFlPopup)
  {
    this.updateConfirmAssignmentFlPopup = updateConfirmAssignmentFlPopup;
  }

  public RichPopup getUpdateConfirmAssignmentFlPopup()
  {
    return updateConfirmAssignmentFlPopup;
  }

  public void setCrsIncomingArchivePopup(RichPopup crsIncomingArchivePopup)
  {
    this.crsIncomingArchivePopup = crsIncomingArchivePopup;
  }

  public RichPopup getCrsIncomingArchivePopup()
  {
    return crsIncomingArchivePopup;
  }

  public void setCrsIncomingDocCcTlPopup(RichPopup crsIncomingDocCcTlPopup)
  {
    this.crsIncomingDocCcTlPopup = crsIncomingDocCcTlPopup;
  }

  public RichPopup getCrsIncomingDocCcTlPopup()
  {
    return crsIncomingDocCcTlPopup;
  }

  public void cardsQueryListener(QueryEvent queryEvent)
  {  
    this.laborJobsROView1Iterator.setFirst(0);
    this.getPageNoIterator().setFirst(0);
    paginationManaged.setFirst(1);
    setVal(1);
    paginationManaged.setLast(paginationManaged.getRowsPerPage());

    setBindFirstButton(true);
    setBindLastButton(false);
    setBindNextButton(false);
    setBindPreviousButton(true);
    
    resetIteratorToFirstRow("CrsIncomingArchiveDocAssignmentViewIterator");
    invokeMethodExpression("#{bindings.CrsIncomingDocumentsViewCriteriaSearchCardsQuery.processQuery}", Object.class, QueryEvent.class, queryEvent);
    setVal(1);
    paginationManaged.setFirst(1);
    paginationManaged.setMidvalue(paginationManaged.getRowsPerPage()); 
    defaultMethod();
  }
  public Object invokeMethodExpression(String expr, Class returnType, Class[] argTypes, Object[] args){
     FacesContext fc = FacesContext.getCurrentInstance(); 
     ELContext elctx = fc.getELContext();
     ExpressionFactory elFactory = fc.getApplication().getExpressionFactory(); 
     MethodExpression methodExpr = elFactory.createMethodExpression(elctx,expr,returnType,argTypes);    
     return methodExpr.invoke(elctx,args); 
  }
     
  public Object invokeMethodExpression(String expr, Class returnType,Class argType, Object argument){ 
     return invokeMethodExpression(expr, returnType,new Class[]{argType}, new Object[]{argument});
  }
  
  public void resetIteratorToFirstRow(String iteratorName) {
      // Retrieve the ViewObject
      ViewObject vo = ADFUtils.findIterator(iteratorName).getViewObject();
      
      // Ensure the ViewObject is not null
      if (vo != null) {
          // Get the RowSetIterator from the ViewObject
          RowSetIterator rsi = vo.createRowSetIterator(null);
          
          // Reset the iterator to the first row
          rsi.reset();
          
          // Close the iterator if it's no longer needed to free up resources
          rsi.closeRowSetIterator();
      } else {
          // Handle the case where the ViewObject is not found
          System.out.println("ViewObject not found for iterator: " + iteratorName);
      }
  }

}
