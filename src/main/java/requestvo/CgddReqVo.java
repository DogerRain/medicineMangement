package requestvo;

import po.Cgdd;

public class CgddReqVo extends Cgdd{
	String ddrq1;
	String ddrq2;
	Integer page;
	Integer rows;
	
	public String getDdrq1() {
		return ddrq1;
	}
	public void setDdrq1(String ddrq1) {
		this.ddrq1 = ddrq1;
	}
	public String getDdrq2() {
		return ddrq2;
	}
	public void setDdrq2(String ddrq2) {
		this.ddrq2 = ddrq2;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	
}
