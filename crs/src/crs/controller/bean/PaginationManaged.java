package crs.controller.bean;


import java.util.ArrayList;
import java.util.List;

public class PaginationManaged
{
  private boolean bindPreviousButton;
  private boolean bindFirstButton;
  private boolean bindNextButton;
  private boolean bindLastButton;
  private boolean paginnationPG;
  private int rowsPerPage = 8;
  private int pgNO; 
  private long paginationRows = 20;
  private List<Integer> li = new ArrayList<Integer>();
  private long first = 1;
  private long last = 8;
  private long total;
  private boolean renderPG;
  private Long rowCount;
  private long midvalue;
  private long temp;
  private int count;

  public PaginationManaged()
  {
    super();
  }

  public void setFirst(long first)
  {
    this.first = first;
  }

  public long getFirst()
  {
    return first;
  }

  public void setRowsPerPage(int rowsPerPage)
  {
    this.rowsPerPage = rowsPerPage;
  }

  public int getRowsPerPage()
  {
    return rowsPerPage;
  } 

  public void setMidvalue(long midvalue)
  {
    this.midvalue = midvalue;
  }

  public long getMidvalue()
  {
    return midvalue;
  }

  public void setRowCount(Long rowCount)
  {
    this.rowCount = rowCount;
  }

  public Long getRowCount()
  {
    return rowCount;
  }

  public void setPgNO(int pgNO)
  {
    this.pgNO = pgNO;
  }

  public int getPgNO()
  {
    return pgNO;
  } 

  public void setRows(long rows)
  {
    this.paginationRows = rows;
  }

  public long getRows()
  {
    return paginationRows;
  }

  public void setLi(List<Integer> li)
  {
    this.li = li;
  }

  public List<Integer> getLi()
  {
    return li;
  }

  public void setLast(long last)
  {
    this.last = last;
  }

  public long getLast()
  {
    return last;
  }

  public void setTotal(long total)
  {
    this.total = total;
  }

  public long getTotal()
  {
    return total;
  }

  public void setTemp(long temp)
  {
    this.temp = temp;
  }

  public long getTemp()
  {
    return temp;
  }

  public void setCount(int count)
  {
    this.count = count;
  }

  public int getCount()
  {
    return count;
  }

  public void setRenderPG(boolean renderPG)
  {
    this.renderPG = renderPG;
  }

  public boolean isRenderPG()
  {
    return renderPG;
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
}

