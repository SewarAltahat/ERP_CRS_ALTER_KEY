package crs.model.vo;

import crs.model.eo.CrsBeneficiariesImpl;

import java.math.BigDecimal;

import java.sql.Timestamp;

import oracle.jbo.RowIterator;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed Apr 26 09:13:47 EEST 2023
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class CrsBeneficiariesViewRowImpl
  extends ViewRowImpl {


    public static final int ENTITY_CRSBENEFICIARIES = 0;

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
  protected enum AttributesEnum
  {
        BeneficiariesPk,
        BeneficiaryId,
        MobileNo,
        Email,
        CreatedBy,
        CreationDate,
        ModifiedBy,
        ModifiedDate,
        UserDepartmentFk,
        DisplayBeneficiaryName,
        DisplayNotes,
        DisplayBeneficiaryNameSearch,
        DisplayNotesSearch,
        CrsBeneficiariesTlView,
        CrsIncomingBeneficiariesView,
        CrsOutgoingBeneficiariesView;
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


    public static final int BENEFICIARIESPK = AttributesEnum.BeneficiariesPk.index();
    public static final int BENEFICIARYID = AttributesEnum.BeneficiaryId.index();
    public static final int MOBILENO = AttributesEnum.MobileNo.index();
    public static final int EMAIL = AttributesEnum.Email.index();
    public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
    public static final int CREATIONDATE = AttributesEnum.CreationDate.index();
    public static final int MODIFIEDBY = AttributesEnum.ModifiedBy.index();
    public static final int MODIFIEDDATE = AttributesEnum.ModifiedDate.index();
    public static final int USERDEPARTMENTFK = AttributesEnum.UserDepartmentFk.index();
    public static final int DISPLAYBENEFICIARYNAME = AttributesEnum.DisplayBeneficiaryName.index();
    public static final int DISPLAYNOTES = AttributesEnum.DisplayNotes.index();
    public static final int DISPLAYBENEFICIARYNAMESEARCH = AttributesEnum.DisplayBeneficiaryNameSearch.index();
    public static final int DISPLAYNOTESSEARCH = AttributesEnum.DisplayNotesSearch.index();
    public static final int CRSBENEFICIARIESTLVIEW = AttributesEnum.CrsBeneficiariesTlView.index();
    public static final int CRSINCOMINGBENEFICIARIESVIEW = AttributesEnum.CrsIncomingBeneficiariesView.index();
    public static final int CRSOUTGOINGBENEFICIARIESVIEW = AttributesEnum.CrsOutgoingBeneficiariesView.index();

    /**
     * This is the default constructor (do not remove).
     */
  public CrsBeneficiariesViewRowImpl()
  {
  }

  /**
   * Gets CrsBeneficiaries entity object.
   * @return the CrsBeneficiaries
   */
  public CrsBeneficiariesImpl getCrsBeneficiaries()
  {
    return (CrsBeneficiariesImpl) getEntity(ENTITY_CRSBENEFICIARIES);
  }

  /**
   * Gets the attribute value for BENEFICIARIES_PK using the alias name BeneficiariesPk.
   * @return the BENEFICIARIES_PK
   */
  public BigDecimal getBeneficiariesPk()
  {
    return (BigDecimal) getAttributeInternal(BENEFICIARIESPK);
  }

  /**
   * Sets <code>value</code> as attribute value for BENEFICIARIES_PK using the alias name BeneficiariesPk.
   * @param value value to set the BENEFICIARIES_PK
   */
  public void setBeneficiariesPk(BigDecimal value)
  {
    setAttributeInternal(BENEFICIARIESPK, value);
  }

  /**
   * Gets the attribute value for BENEFICIARY_ID using the alias name BeneficiaryId.
   * @return the BENEFICIARY_ID
   */
  public String getBeneficiaryId()
  {
    return (String) getAttributeInternal(BENEFICIARYID);
  }

  /**
   * Sets <code>value</code> as attribute value for BENEFICIARY_ID using the alias name BeneficiaryId.
   * @param value value to set the BENEFICIARY_ID
   */
  public void setBeneficiaryId(String value)
  {
    setAttributeInternal(BENEFICIARYID, value);
  }

  /**
   * Gets the attribute value for MOBILE_NO using the alias name MobileNo.
   * @return the MOBILE_NO
   */
  public String getMobileNo()
  {
    return (String) getAttributeInternal(MOBILENO);
  }

  /**
   * Sets <code>value</code> as attribute value for MOBILE_NO using the alias name MobileNo.
   * @param value value to set the MOBILE_NO
   */
  public void setMobileNo(String value)
  {
    setAttributeInternal(MOBILENO, value);
  }

  /**
   * Gets the attribute value for EMAIL using the alias name Email.
   * @return the EMAIL
   */
  public String getEmail()
  {
    return (String) getAttributeInternal(EMAIL);
  }

  /**
   * Sets <code>value</code> as attribute value for EMAIL using the alias name Email.
   * @param value value to set the EMAIL
   */
  public void setEmail(String value)
  {
    setAttributeInternal(EMAIL, value);
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
   * Gets the attribute value for DISPLAY_BENEFICIARY_NAME using the alias name DisplayBeneficiaryName.
   * @return the DISPLAY_BENEFICIARY_NAME
   */
  public String getDisplayBeneficiaryName()
  {
    return (String) getAttributeInternal(DISPLAYBENEFICIARYNAME);
  }

  /**
   * Sets <code>value</code> as attribute value for DISPLAY_BENEFICIARY_NAME using the alias name DisplayBeneficiaryName.
   * @param value value to set the DISPLAY_BENEFICIARY_NAME
   */
  public void setDisplayBeneficiaryName(String value)
  {
    setAttributeInternal(DISPLAYBENEFICIARYNAME, value);
  }

  /**
   * Gets the attribute value for DISPLAY_NOTES using the alias name DisplayNotes.
   * @return the DISPLAY_NOTES
   */
  public String getDisplayNotes()
  {
    return (String) getAttributeInternal(DISPLAYNOTES);
  }

  /**
   * Sets <code>value</code> as attribute value for DISPLAY_NOTES using the alias name DisplayNotes.
   * @param value value to set the DISPLAY_NOTES
   */
  public void setDisplayNotes(String value)
  {
    setAttributeInternal(DISPLAYNOTES, value);
  }

  /**
   * Gets the attribute value for the calculated attribute DisplayBeneficiaryNameSearch.
   * @return the DisplayBeneficiaryNameSearch
   */
  public String getDisplayBeneficiaryNameSearch()
  {
    return (String) getAttributeInternal(DISPLAYBENEFICIARYNAME);//(DISPLAYBENEFICIARYNAMESEARCH);
  }

  /**
   * Gets the attribute value for the calculated attribute DisplayNotesSearch.
   * @return the DisplayNotesSearch
   */
  public String getDisplayNotesSearch()
  {
    return (String) getAttributeInternal(DISPLAYNOTES);//(DISPLAYNOTESSEARCH);
  }

  /**
   * Gets the associated <code>RowIterator</code> using master-detail link CrsBeneficiariesTlView.
   */
  public RowIterator getCrsBeneficiariesTlView()
  {
    return (RowIterator) getAttributeInternal(CRSBENEFICIARIESTLVIEW);
  }

  /**
   * Gets the associated <code>RowIterator</code> using master-detail link CrsIncomingBeneficiariesView.
   */
  public RowIterator getCrsIncomingBeneficiariesView()
  {
    return (RowIterator) getAttributeInternal(CRSINCOMINGBENEFICIARIESVIEW);
  }

  /**
   * Gets the associated <code>RowIterator</code> using master-detail link CrsOutgoingBeneficiariesView.
   */
  public RowIterator getCrsOutgoingBeneficiariesView()
  {
    return (RowIterator) getAttributeInternal(CRSOUTGOINGBENEFICIARIESVIEW);
  }
}
