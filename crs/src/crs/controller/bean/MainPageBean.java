package crs.controller.bean;

import gen.common.MainBaseBean;

import oracle.adf.view.rich.component.rich.RichDocument;

public class MainPageBean extends MainBaseBean
{

  private RichDocument doc;

  public void setDoc(RichDocument doc)
  {
    this.doc = doc;
  }

  public RichDocument getDoc()
  {
    return doc;
  }
}
