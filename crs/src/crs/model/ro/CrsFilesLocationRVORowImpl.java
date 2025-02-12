package crs.model.ro;

import java.math.BigDecimal;

import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Tue Sep 05 11:25:56 GMT+03:00 2023
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class CrsFilesLocationRVORowImpl
  extends ViewRowImpl
{
  /**
   * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
   */
  protected enum AttributesEnum
  {
    FilesLocationPk,
    DisplayFilesLocationPk;
    private static AttributesEnum[] vals = null;
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
  public static final int FILESLOCATIONPK = AttributesEnum.FilesLocationPk.index();
  public static final int DISPLAYFILESLOCATIONPK = AttributesEnum.DisplayFilesLocationPk.index();

  /**
   * This is the default constructor (do not remove).
   */
  public CrsFilesLocationRVORowImpl()
  {
  }
}

