package crs.model.ro;

import gen.common.GenLib;

import oracle.jbo.server.ViewObjectImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Tue Sep 12 16:13:07 GMT+03:00 2023
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class CrsDeptGroupRVOImpl
  extends ViewObjectImpl
{
  /**
   * This is the default constructor (do not remove).
   */
  public CrsDeptGroupRVOImpl()
  {
  }

  @Override
  protected void executeQueryForCollection(Object object, Object[] object2, int i)
  {
    String EndDate = "";
    if (GenLib.isDataBaseOracle())
    {
      EndDate = " end_date + 1";
    }
    else if (GenLib.isDataBaseMySql())
    {
      EndDate = " DATE_ADD(end_date, INTERVAL 1 DAY)";
    }
    String where = "( current_date >=start_date or start_date is null)\n" + 
    "and (current_date  <="+EndDate+" or end_date is null ) and active_fl =   1";
     setWhereClause(where);
    super.executeQueryForCollection(object, object2, i);
  }
}

