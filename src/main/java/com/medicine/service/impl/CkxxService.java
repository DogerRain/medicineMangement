package com.medicine.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.medicine.dao.impl.CkxxDao;

import exception.YpkcxxNotFind;
import exception.ZgxxNotFind;
import pagination.Page;
import po.Ckxx;
import po.Rkxx;
import po.Ypkcxx;
import po.Ypxx;
import po.Zgxx;
import requestvo.CkxxReqVo;
import requestvo.YpkcxxReqVo;

@Service
public class CkxxService extends BaseServiceImpl{
	public Page findCkxx(CkxxReqVo ckxxReqVo){
		Page<Ckxx> page=new Page<>();
		if (ckxxReqVo.getYpbm() != null)
			page.getParams().put("ypbm", ckxxReqVo.getYpbm());  //"ypbm"对应mapper的params.ypmc
		if(ckxxReqVo.getYpmc()!=null) page.getParams().put("ypmc", "%"+ckxxReqVo.getYpmc()+"%");
		if(ckxxReqVo.getZgbm()!=null) page.getParams().put("zgbm", ckxxReqVo.getZgbm());

		if(ckxxReqVo.getSl1()!=null) page.getParams().put("sl1", ckxxReqVo.getSl1());
		if(ckxxReqVo.getSl2()!=null) page.getParams().put("sl2", ckxxReqVo.getSl2());
		if(ckxxReqVo.getCkrq1()!=null&&!"".equals((ckxxReqVo.getCkrq1())))
			page.getParams().put("ckrq1",ckxxReqVo.getCkrq1());
		if(ckxxReqVo.getCkrq2()!=null&&!"".equals((ckxxReqVo.getCkrq2())))
			page.getParams().put("ckrq2",ckxxReqVo.getCkrq2());
		
		page.setPageNo(ckxxReqVo.getPage());
		page.setPageSize(ckxxReqVo.getRows());
		page.setResults(ckxxDao.findPage(page));
		return page;
	}
	
	
	
	public void updateCkxx(Ckxx ckxx) {
		// TODO Auto-generated method stub
		ckxxDao.update(ckxx);
		
	}
	@Transactional
	public void addCkxx(Ckxx ckxx) {
		// TODO Auto-generated method stub
		ckxxDao.insert(ckxx);
		Ypkcxx	ypkcxx  = ypkcxxDao.get(ckxx.getYpbm());
		if(ypkcxx==null){
			throw new YpkcxxNotFind(ckxx.getYpbm());		
		}
		else{
			Zgxx zgxx=zgxxDao.get(ckxx.getZgbm());
			if(zgxx==null) throw new ZgxxNotFind(ckxx.getZgbm());
			ypkcxx.setyPSL(ypkcxx.getyPSL()-ckxx.getSl());
			ypkcxxDao.update(ypkcxx);
		}
		
	}
	public void delCkxx(Integer[] integers) {
		// TODO Auto-generated method stub
		ckxxDao.delete(integers);
	}

}
