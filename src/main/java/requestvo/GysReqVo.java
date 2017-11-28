package requestvo;

import java.sql.Timestamp;

import po.Ckxx;
import po.Gys;
import po.Rkxx;
import po.Ypxx;

public class GysReqVo extends Gys{
	
	Integer page;
	Integer rows;
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
