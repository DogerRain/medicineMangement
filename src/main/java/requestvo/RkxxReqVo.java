package requestvo;

import java.sql.Timestamp;

import po.Rkxx;
import po.Ypxx;

public class RkxxReqVo extends Rkxx{
	Integer rKL1;
	Integer rKL2;
	String rKRQ1;
	String rKRQ2;
	Integer page;
	Integer rows;
	public Integer getrKL1() {
		return rKL1;
	}
	public void setrKL1(Integer rKL1) {
		this.rKL1 = rKL1;
	}
	public Integer getrKL2() {
		return rKL2;
	}
	public void setrKL2(Integer rKL2) {
		this.rKL2 = rKL2;
	}
	public String getrKRQ1() {
		return rKRQ1;
	}
	public void setrKRQ1(String rKRQ1) {
		this.rKRQ1 = rKRQ1;
	}
	public String getrKRQ2() {
		return rKRQ2;
	}
	public void setrKRQ2(String rKRQ2) {
		this.rKRQ2 = rKRQ2;
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
