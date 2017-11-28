package requestvo;

import java.sql.Timestamp;

import po.Ckxx;
import po.Rkxx;
import po.Ypxx;

public class CkxxReqVo extends Ckxx{
	Integer sl1;
	Integer sl2;
	String ckrq1;
	String ckrq2;
	Integer page;
	Integer rows;
	public Integer getSl1() {
		return sl1;
	}
	public void setSl1(Integer sl1) {
		this.sl1 = sl1;
	}
	public Integer getSl2() {
		return sl2;
	}
	public void setSl2(Integer sl2) {
		this.sl2 = sl2;
	}
	public String getCkrq1() {
		return ckrq1;
	}
	public void setCkrq1(String ckrq1) {
		this.ckrq1 = ckrq1;
	}
	public String getCkrq2() {
		return ckrq2;
	}
	public void setCkrq2(String ckrq2) {
		this.ckrq2 = ckrq2;
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
