package po;

import java.util.Date;


//药品订单
public class Cgdd  {
	private Integer ddid;
	private Integer zgbm;
	private Integer gysbm;
	private Date ddrq;
	private Integer ypbm;
	private String ypmc;
	private Integer sl;
	public Integer getDdid() {
		return ddid;
	}
	public void setDdid(Integer ddid) {
		this.ddid = ddid;
	}
	
	public Integer getZgbm() {
		return zgbm;
	}
	public void setZgbm(Integer zgbm) {
		this.zgbm = zgbm;
	}
	public Integer getGysbm() {
		return gysbm;
	}
	public void setGysbm(Integer gysbm) {
		this.gysbm = gysbm;
	}
	public Date getDdrq() {
		return ddrq;
	}
	public void setDdrq(Date ddrq) {
		this.ddrq = ddrq;
	}
	public Integer getYpbm() {
		return ypbm;
	}
	public void setYpbm(Integer ypbm) {
		this.ypbm = ypbm;
	}
	public String getYpmc() {
		return ypmc;
	}
	public void setYpmc(String ypmc) {
		this.ypmc = ypmc;
	}
	public Integer getSl() {
		return sl;
	}
	public void setSl(Integer sl) {
		this.sl = sl;
	}
	
}