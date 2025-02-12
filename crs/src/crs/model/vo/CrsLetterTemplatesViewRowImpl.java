package crs.model.vo;

import crs.model.eo.CrsLetterTemplatesImpl;

import java.math.BigDecimal;

import java.sql.Timestamp;

import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Mon Sep 04 10:58:11 GMT+03:00 2023
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class CrsLetterTemplatesViewRowImpl
  extends ViewRowImpl
{

  public static final int ENTITY_CRSLETTERTEMPLATES = 0;

  /**
   * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
   */
  protected enum AttributesEnum
  {
    LetterTemplatesPk,
    DepartmentsFk,
    TemplateName,
    TemplateHeader,
    TemplateContent,
    TemplateFooter,
    CreatedBy,
    CreationDate,
    ModifiedBy,
    ModifiedDate,
    UserDepartmentFk,
    TemplateNameSearch;
    private static AttributesEnum[] vals = null;
    ;
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

  public static final int LETTERTEMPLATESPK = AttributesEnum.LetterTemplatesPk.index();
  public static final int DEPARTMENTSFK = AttributesEnum.DepartmentsFk.index();
  public static final int TEMPLATENAME = AttributesEnum.TemplateName.index();
  public static final int TEMPLATEHEADER = AttributesEnum.TemplateHeader.index();
  public static final int TEMPLATECONTENT = AttributesEnum.TemplateContent.index();
  public static final int TEMPLATEFOOTER = AttributesEnum.TemplateFooter.index();
  public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
  public static final int CREATIONDATE = AttributesEnum.CreationDate.index();
  public static final int MODIFIEDBY = AttributesEnum.ModifiedBy.index();
  public static final int MODIFIEDDATE = AttributesEnum.ModifiedDate.index();
  public static final int USERDEPARTMENTFK = AttributesEnum.UserDepartmentFk.index();
  public static final int TEMPLATENAMESEARCH = AttributesEnum.TemplateNameSearch.index();

  /**
   * This is the default constructor (do not remove).
   */
  public CrsLetterTemplatesViewRowImpl()
  {
  }

  /**
   * Gets CrsLetterTemplates entity object.
   * @return the CrsLetterTemplates
   */
  public CrsLetterTemplatesImpl getCrsLetterTemplates()
  {
    return (CrsLetterTemplatesImpl) getEntity(ENTITY_CRSLETTERTEMPLATES);
  }

  /**
   * Gets the attribute value for LETTER_TEMPLATES_PK using the alias name LetterTemplatesPk.
   * @return the LETTER_TEMPLATES_PK
   */
  public BigDecimal getLetterTemplatesPk()
  {
    return (BigDecimal) getAttributeInternal(LETTERTEMPLATESPK);
  }

  /**
   * Sets <code>value</code> as attribute value for LETTER_TEMPLATES_PK using the alias name LetterTemplatesPk.
   * @param value value to set the LETTER_TEMPLATES_PK
   */
  public void setLetterTemplatesPk(BigDecimal value)
  {
    setAttributeInternal(LETTERTEMPLATESPK, value);
  }

  /**
   * Gets the attribute value for DEPARTMENTS_FK using the alias name DepartmentsFk.
   * @return the DEPARTMENTS_FK
   */
  public BigDecimal getDepartmentsFk()
  {
    return (BigDecimal) getAttributeInternal(DEPARTMENTSFK);
  }

  /**
   * Sets <code>value</code> as attribute value for DEPARTMENTS_FK using the alias name DepartmentsFk.
   * @param value value to set the DEPARTMENTS_FK
   */
  public void setDepartmentsFk(BigDecimal value)
  {
    setAttributeInternal(DEPARTMENTSFK, value);
  }

  /**
   * Gets the attribute value for TEMPLATE_NAME using the alias name TemplateName.
   * @return the TEMPLATE_NAME
   */
  public String getTemplateName()
  {
    return (String) getAttributeInternal(TEMPLATENAME);
  }

  /**
   * Sets <code>value</code> as attribute value for TEMPLATE_NAME using the alias name TemplateName.
   * @param value value to set the TEMPLATE_NAME
   */
  public void setTemplateName(String value)
  {
    setAttributeInternal(TEMPLATENAME, value);
  }

  /**
   * Gets the attribute value for TEMPLATE_HEADER using the alias name TemplateHeader.
   * @return the TEMPLATE_HEADER
   */
  public String getTemplateHeader()
  {
    return (String) getAttributeInternal(TEMPLATEHEADER);
  }

  /**
   * Sets <code>value</code> as attribute value for TEMPLATE_HEADER using the alias name TemplateHeader.
   * @param value value to set the TEMPLATE_HEADER
   */
  public void setTemplateHeader(String value)
  {
    setAttributeInternal(TEMPLATEHEADER, value);
  }

  /**
   * Gets the attribute value for TEMPLATE_CONTENT using the alias name TemplateContent.
   * @return the TEMPLATE_CONTENT
   */
  public String getTemplateContent()
  {
    return (String) getAttributeInternal(TEMPLATECONTENT);
  }

  /**
   * Sets <code>value</code> as attribute value for TEMPLATE_CONTENT using the alias name TemplateContent.
   * @param value value to set the TEMPLATE_CONTENT
   */
  public void setTemplateContent(String value)
  {
    setAttributeInternal(TEMPLATECONTENT, value);
  }

  /**
   * Gets the attribute value for TEMPLATE_FOOTER using the alias name TemplateFooter.
   * @return the TEMPLATE_FOOTER
   */
  public String getTemplateFooter()
  {
    return (String) getAttributeInternal(TEMPLATEFOOTER);
  }

  /**
   * Sets <code>value</code> as attribute value for TEMPLATE_FOOTER using the alias name TemplateFooter.
   * @param value value to set the TEMPLATE_FOOTER
   */
  public void setTemplateFooter(String value)
  {
    setAttributeInternal(TEMPLATEFOOTER, value);
  }

  /**
   * Gets the attribute value for CREATED_BY using the alias name CreatedBy.
   * @return the CREATED_BY
   */
  public BigDecimal getCreatedBy()
  {
    return (BigDecimal) getAttributeInternal(CREATEDBY);
  }

  /**
   * Sets <code>value</code> as attribute value for CREATED_BY using the alias name CreatedBy.
   * @param value value to set the CREATED_BY
   */
  public void setCreatedBy(BigDecimal value)
  {
    setAttributeInternal(CREATEDBY, value);
  }

  /**
   * Gets the attribute value for CREATION_DATE using the alias name CreationDate.
   * @return the CREATION_DATE
   */
  public Timestamp getCreationDate()
  {
    return (Timestamp) getAttributeInternal(CREATIONDATE);
  }

  /**
   * Sets <code>value</code> as attribute value for CREATION_DATE using the alias name CreationDate.
   * @param value value to set the CREATION_DATE
   */
  public void setCreationDate(Timestamp value)
  {
    setAttributeInternal(CREATIONDATE, value);
  }

  /**
   * Gets the attribute value for MODIFIED_BY using the alias name ModifiedBy.
   * @return the MODIFIED_BY
   */
  public BigDecimal getModifiedBy()
  {
    return (BigDecimal) getAttributeInternal(MODIFIEDBY);
  }

  /**
   * Sets <code>value</code> as attribute value for MODIFIED_BY using the alias name ModifiedBy.
   * @param value value to set the MODIFIED_BY
   */
  public void setModifiedBy(BigDecimal value)
  {
    setAttributeInternal(MODIFIEDBY, value);
  }

  /**
   * Gets the attribute value for MODIFIED_DATE using the alias name ModifiedDate.
   * @return the MODIFIED_DATE
   */
  public Timestamp getModifiedDate()
  {
    return (Timestamp) getAttributeInternal(MODIFIEDDATE);
  }

  /**
   * Sets <code>value</code> as attribute value for MODIFIED_DATE using the alias name ModifiedDate.
   * @param value value to set the MODIFIED_DATE
   */
  public void setModifiedDate(Timestamp value)
  {
    setAttributeInternal(MODIFIEDDATE, value);
  }

  /**
   * Gets the attribute value for USER_DEPARTMENT_FK using the alias name UserDepartmentFk.
   * @return the USER_DEPARTMENT_FK
   */
  public BigDecimal getUserDepartmentFk()
  {
    return (BigDecimal) getAttributeInternal(USERDEPARTMENTFK);
  }

  /**
   * Sets <code>value</code> as attribute value for USER_DEPARTMENT_FK using the alias name UserDepartmentFk.
   * @param value value to set the USER_DEPARTMENT_FK
   */
  public void setUserDepartmentFk(BigDecimal value)
  {
    setAttributeInternal(USERDEPARTMENTFK, value);
  }

  /**
   * Gets the attribute value for the calculated attribute TemplateNameSearch.
   * @return the TemplateNameSearch
   */
  public String getTemplateNameSearch()
  {
    return (String) getAttributeInternal(TEMPLATENAME);
  }

  /**
   * Sets <code>value</code> as the attribute value for the calculated attribute TemplateNameSearch.
   * @param value value to set the  TemplateNameSearch
   */
  public void setTemplateNameSearch(String value)
  {
    setAttributeInternal(TEMPLATENAMESEARCH, value);
  }
}

