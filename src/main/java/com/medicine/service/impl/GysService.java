package com.medicine.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.medicine.dao.impl.CkxxDao;
import com.medicine.dao.impl.GysDao;

import pagination.Page;
import po.Ckxx;
import po.Gys;
import po.Rkxx;
import po.Ypxx;
import requestvo.GysReqVo;
import requestvo.YpkcxxReqVo;

@Service
public class GysService extends BaseServiceImpl{
	public Page findGys(GysReqVo gysReqVo){
		Page<Gys> page=new Page<>();
		if (gysReqVo.getGysbm() != null)
			page.getParams().put("gysbm", gysReqVo.getGysbm());
		if(gysReqVo.getGysmc()!=null) page.getParams().put("gysmc", "%"+gysReqVo.getGysmc()+"%");
		if(gysReqVo.getGysfzr()!=null) page.getParams().put("gysfzr", gysReqVo.getGysfzr());
		if(gysReqVo.getGyslxfs()!=null) page.getParams().put("gyslxfs", "%"+gysReqVo.getGyslxfs()+"%");
		if(gysReqVo.getGysfzr()!=null) page.getParams().put("gysfzr", "%"+gysReqVo.getGysfzr()+"%");
		if(gysReqVo.getGysdz()!=null) page.getParams().put("gysdz", "%"+gysReqVo.getGysdz()+"%");
		page.setPageNo(gysReqVo.getPage());
		page.setPageSize(gysReqVo.getRows());
		page.setResults(gysDao.findPage(page));
		return page;
	}
	
	
	
	public void updateGys(Gys gys)  {
		// TODO Auto-generated method stub
		gysDao.update(gys);
		
	}
	public void addGys(Gys gys) {
		// TODO Auto-generated method stub
		gysDao.insert(gys);
	}
	public void delGys(Integer[] integers) {
		// TODO Auto-generated method stub
		gysDao.delete(integers);
	}

}
