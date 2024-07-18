package crs.model.ro;

import java.math.BigDecimal;

import java.sql.Timestamp;

import oracle.jbo.RowSet;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Thu Apr 06 10:22:56 GMT+03:00 2023
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class BeneficiariesVwViewRowImpl
  extends ViewRowImpl {
  /**
   * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
   */
  protected enum AttributesEnum
  {
        DocTypeFk,
        IncomingBeneficiariesPk,
        BeneficiariesFk,
        IncomingDocumentsFk,
        CreatedBy,
        CreationDate,
        ModifiedBy,
        ModifiedDate,
        DisplayDocTypeFk,
        DisplayCreatedBy,
        DisplayModifiedBy,
        DisplayBeneficiarieEmail,
        DisplayBeneficiarieMobileno,
        DisplayBeneficiariesFk,
        UserDepartmentFk,
        DisplayDocTypeFkSearch,
        DocTypeFkSearch,
        DisplayCreatedBySearch,
        DisplayModifiedBySearch,
        SsoActiveLookupValuesVwDocTyypeFk;
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


    public static final int DOCTYPEFK = AttributesEnum.DocTypeFk.index();
    public static final int INCOMINGBENEFICIARIESPK = AttributesEnum.IncomingBeneficiariesPk.index();
    public static final int BENEFICIARIESFK = AttributesEnum.BeneficiariesFk.index();
    public static final int INCOMINGDOCUMENTSFK = AttributesEnum.IncomingDocumentsFk.index();
    public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
    public static final int CREATIONDATE = AttributesEnum.CreationDate.index();
    public static final int MODIFIEDBY = AttributesEnum.ModifiedBy.index();
    public static final int MODIFIEDDATE = AttributesEnum.ModifiedDate.index();
    public static final int DISPLAYDOCTYPEFK = AttributesEnum.DisplayDocTypeFk.index();
    public static final int DISPLAYCREATEDBY = AttributesEnum.DisplayCreatedBy.index();
    public static final int DISPLAYMODIFIEDBY = AttributesEnum.DisplayModifiedBy.index();
    public static final int DISPLAYBENEFICIARIEEMAIL = AttributesEnum.DisplayBeneficiarieEmail.index();
    public static final int DISPLAYBENEFICIARIEMOBILENO = AttributesEnum.DisplayBeneficiarieMobileno.index();
    public static final int DISPLAYBENEFICIARIESFK = AttributesEnum.DisplayBeneficiariesFk.index();
    public static final int USERDEPARTMENTFK = AttributesEnum.UserDepartmentFk.index();
    public static final int DISPLAYDOCTYPEFKSEARCH = AttributesEnum.DisplayDocTypeFkSearch.index();
    public static final int DOCTYPEFKSEARCH = AttributesEnum.DocTypeFkSearch.index();
    public static final int DISPLAYCREATEDBYSEARCH = AttributesEnum.DisplayCreatedBySearch.index();
    public static final int DISPLAYMODIFIEDBYSEARCH = AttributesEnum.DisplayModifiedBySearch.index();
    public static final int SSOACTIVELOOKUPVALUESVWDOCTYYPEFK =
        AttributesEnum.SsoActiveLookupValuesVwDocTyypeFk.index();

    /**
     * This is the default constructor (do not remove).
     */
  public BeneficiariesVwViewRowImpl()
  {
  }

  /**
   * Gets the attribute value for the calculated attribute DocTypeFk.
   * @return the DocTypeFk
   */
  public BigDecimal getDocTypeFk()
  {
    return (BigDecimal) getAttributeInternal(DOCTYPEFK);
  }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute DocTypeFk.
     * @param value value to set the  DocTypeFk
     */
    public void setDocTypeFk(BigDecimal value) {
        setAttributeInternal(DOCTYPEFK, value);
    }


    /**
     * Gets the attribute value for the calculated attribute IncomingBeneficiariesPk.
     * @return the IncomingBeneficiariesPk
     */
    public BigDecimal getIncomingBeneficiariesPk() {
        return (BigDecimal) getAttributeInternal(INCOMINGBENEFICIARIESPK);
    }

    /**
     * Gets the attribute value for the calculated attribute BeneficiariesFk.
     * @return the BeneficiariesFk
     */
    public BigDecimal getBeneficiariesFk() {
        return (BigDecimal) getAttributeInternal(BENEFICIARIESFK);
    }

    /**
     * Gets the attribute value for the calculated attribute DisplayDocTypeFk.
     * @return the DisplayDocTypeFk
     */
  public String getDisplayDocTypeFk()
  {
    return (String) getAttributeInternal(DISPLAYDOCTYPEFK);
  }


    /**
     * Gets the attribute value for the calculated attribute DisplayDocTypeFkSearch.
     * @return the DisplayDocTypeFkSearch
     */
  public String getDisplayDocTypeFkSearch()
  {
    return (String) getAttributeInternal(DISPLAYDOCTYPEFK);
  }

  /**
   * Sets <code>value</code> as the attribute value for the calculated attribute DisplayDocTypeFkSearch.
   * @param value value to set the  DisplayDocTypeFkSearch
   */
  public void setDisplayDocTypeFkSearch(String value)
  {
    setAttributeInternal(DISPLAYDOCTYPEFKSEARCH, value);
  }

  /**
   * Gets the attribute value for the calculated attribute DocTypeFkSearch.
   * @return the DocTypeFkSearch
   */
  public BigDecimal getDocTypeFkSearch()
  {
    return (BigDecimal) getAttributeInternal(DOCTYPEFK);
  }

  /**
   * Sets <code>value</code> as the attribute value for the calculated attribute DocTypeFkSearch.
   * @param value value to set the  DocTypeFkSearch
   */
  public void setDocTypeFkSearch(BigDecimal value)
  {
    setAttributeInternal(DOCTYPEFKSEARCH, value);
  }


    /**
     * Gets the attribute value for the calculated attribute IncomingDocumentsFk.
     * @return the IncomingDocumentsFk
     */
  public BigDecimal getIncomingDocumentsFk()
  {
    return (BigDecimal) getAttributeInternal(INCOMINGDOCUMENTSFK);
  }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute IncomingDocumentsFk.
     * @param value value to set the  IncomingDocumentsFk
     */
    public void setIncomingDocumentsFk(BigDecimal value) {
        setAttributeInternal(INCOMINGDOCUMENTSFK, value);
    }

    /**
     * Gets the attribute value for the calculated attribute CreatedBy.
     * @return the CreatedBy
     */
  public BigDecimal getCreatedBy()
  {
    return (BigDecimal) getAttributeInternal(CREATEDBY);
  }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute CreatedBy.
     * @param value value to set the  CreatedBy
     */
    public void setCreatedBy(BigDecimal value) {
        setAttributeInternal(CREATEDBY, value);
    }

    /**
     * Gets the attribute value for the calculated attribute CreationDate.
     * @return the CreationDate
     */
  public Timestamp getCreationDate()
  {
    return (Timestamp) getAttributeInternal(CREATIONDATE);
  }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute CreationDate.
     * @param value value to set the  CreationDate
     */
    public void setCreationDate(Timestamp value) {
        setAttributeInternal(CREATIONDATE, value);
    }

    /**
     * Gets the attribute value for the calculated attribute ModifiedBy.
     * @return the ModifiedBy
     */
  public BigDecimal getModifiedBy()
  {
    return (BigDecimal) getAttributeInternal(MODIFIEDBY);
  }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute ModifiedBy.
     * @param value value to set the  ModifiedBy
     */
    public void setModifiedBy(BigDecimal value) {
        setAttributeInternal(MODIFIEDBY, value);
    }

    /**
     * Gets the attribute value for the calculated attribute ModifiedDate.
     * @return the ModifiedDate
     */
  public Timestamp getModifiedDate()
  {
    return (Timestamp) getAttributeInternal(MODIFIEDDATE);
  }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute ModifiedDate.
     * @param value value to set the  ModifiedDate
     */
    public void setModifiedDate(Timestamp value) {
        setAttributeInternal(MODIFIEDDATE, value);
    }

    /**
     * Gets the attribute value for the calculated attribute UserDepartmentFk.
     * @return the UserDepartmentFk
     */
  public BigDecimal getUserDepartmentFk()
  {
    return (BigDecimal) getAttributeInternal(USERDEPARTMENTFK);
  }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute UserDepartmentFk.
     * @param value value to set the  UserDepartmentFk
     */
    public void setUserDepartmentFk(BigDecimal value) {
        setAttributeInternal(USERDEPARTMENTFK, value);
    }

    /**
     * Gets the attribute value for the calculated attribute DisplayCreatedBy.
     * @return the DisplayCreatedBy
     */
  public String getDisplayCreatedBy()
  {
    return (String) getAttributeInternal(DISPLAYCREATEDBY);
  }


    /**
     * Gets the attribute value for the calculated attribute DisplayCreatedBySearch.
     * @return the DisplayCreatedBySearch
     */
  public String getDisplayCreatedBySearch()
  {
    return (String) getAttributeInternal(DISPLAYCREATEDBY);
  }

  /**
   * Sets <code>value</code> as the attribute value for the calculated attribute DisplayCreatedBySearch.
   * @param value value to set the  DisplayCreatedBySearch
   */
  public void setDisplayCreatedBySearch(String value)
  {
    setAttributeInternal(DISPLAYCREATEDBYSEARCH, value);
  }

  /**
   * Gets the attribute value for the calculated attribute DisplayModifiedBy.
   * @return the DisplayModifiedBy
   */
  public String getDisplayModifiedBy()
  {
    return (String) getAttributeInternal(DISPLAYMODIFIEDBY);
  }


    /**
     * Gets the attribute value for the calculated attribute DisplayBeneficiarieEmail.
     * @return the DisplayBeneficiarieEmail
     */
    public String getDisplayBeneficiarieEmail() {
        return (String) getAttributeInternal(DISPLAYBENEFICIARIEEMAIL);
    }

    /**
     * Gets the attribute value for the calculated attribute DisplayBeneficiarieMobileno.
     * @return the DisplayBeneficiarieMobileno
     */
    public String getDisplayBeneficiarieMobileno() {
        return (String) getAttributeInternal(DISPLAYBENEFICIARIEMOBILENO);
    }

    /**
     * Gets the attribute value for the calculated attribute DisplayBeneficiariesFk.
     * @return the DisplayBeneficiariesFk
     */
    public String getDisplayBeneficiariesFk() {
        return (String) getAttributeInternal(DISPLAYBENEFICIARIESFK);
    }

    /**
     * Gets the attribute value for the calculated attribute DisplayBeneficiarieMobileNo.
     * @return the DisplayBeneficiarieMobileNo
     */
  public String getDisplayBeneficiarieMobileNo()
  {
    return (String) getAttributeInternal(DISPLAYBENEFICIARIEMOBILENO);
  }

  /**
   * Sets <code>value</code> as the attribute value for the calculated attribute DisplayBeneficiarieMobileNo.
   * @param value value to set the  DisplayBeneficiarieMobileNo
   */
  public void setDisplayBeneficiarieMobileNo(String value)
  {
    setAttributeInternal(DISPLAYBENEFICIARIEMOBILENO, value);
  }


    /**
     * Gets the attribute value for the calculated attribute DisplayModifiedBySearch.
     * @return the DisplayModifiedBySearch
     */
  public String getDisplayModifiedBySearch()
  {
    return (String) getAttributeInternal(DISPLAYMODIFIEDBY);
  }

  /**
   * Sets <code>value</code> as the attribute value for the calculated attribute DisplayModifiedBySearch.
   * @param value value to set the  DisplayModifiedBySearch
   */
  public void setDisplayModifiedBySearch(String value)
  {
    setAttributeInternal(DISPLAYMODIFIEDBYSEARCH, value);
  }

  /**
   * Gets the view accessor <code>RowSet</code> SsoActiveLookupValuesVwDocTyypeFk.
   */
  public RowSet getSsoActiveLookupValuesVwDocTyypeFk()
  {
    return (RowSet) getAttributeInternal(SSOACTIVELOOKUPVALUESVWDOCTYYPEFK);
  }
}

