package requestvo;

import java.sql.Timestamp;

import po.Ypkcxx;
import po.Ypxx;

public class YpkcxxReqVo extends Ypkcxx{
	String yXRQ1;
	String yXRQ2;
	Integer page;
	Integer rows;
	Double yPSJ1;
	Double yPSJ2;
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
	public String getyXRQ1() {
		return yXRQ1;
	}
	public void setyXRQ1(String yXRQ1) {
		this.yXRQ1 = yXRQ1;
	}
	public String getyXRQ2() {
		return yXRQ2;
	}
	public void setyXRQ2(String yXRQ2) {
		this.yXRQ2 = yXRQ2;
	}
	public Double getyPSJ1() {
		return yPSJ1;
	}
	public void setyPSJ1(Double yPSJ1) {
		this.yPSJ1 = yPSJ1;
	}
	public Double getyPSJ2() {
		return yPSJ2;
	}
	public void setyPSJ2(Double yPSJ2) {
		this.yPSJ2 = yPSJ2;
	}
	
	
}
