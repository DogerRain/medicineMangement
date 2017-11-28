package com.medicine.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import exception.YpkcxxNotFind;
import exception.ZgxxNotFind;
import pagination.Page;
import po.Rkxx;
import po.Ypkcxx;
import po.Ypxx;
import po.Zgxx;
import requestvo.RkxxReqVo;
import requestvo.YpkcxxReqVo;

@Service
public class RkxxService extends BaseServiceImpl{
	
	public Page findRkxx(RkxxReqVo rkxxReqVo){
		Page<Rkxx> page=new Page<>();
		if (rkxxReqVo.getyPBM() != null)
			page.getParams().put("yPBM", rkxxReqVo.getyPBM());
		if(rkxxReqVo.getyPMC()!=null) page.getParams().put("yPMC", "%"+rkxxReqVo.getyPMC()+"%");
		if(rkxxReqVo.getzGBM()!=null) page.getParams().put("zGBM", rkxxReqVo.getzGBM());

		if(rkxxReqVo.getrKL1()!=null) page.getParams().put("rKL1", rkxxReqVo.getrKL1());
		if(rkxxReqVo.getrKL2()!=null) page.getParams().put("rKL2", rkxxReqVo.getrKL2());
		if(rkxxReqVo.getrKRQ1()!=null&&!"".equals((rkxxReqVo.getrKRQ1())))
			page.getParams().put("rKRQ1",rkxxReqVo.getrKRQ1());
		if(rkxxReqVo.getrKRQ2()!=null&&!"".equals((rkxxReqVo.getrKRQ2())))
			page.getParams().put("rKRQ2",rkxxReqVo.getrKRQ2());
		
		page.setPageNo(rkxxReqVo.getPage());
		page.setPageSize(rkxxReqVo.getRows());
		page.setResults(rkxxDao.findPage(page));
		return page;
	}
	
	
	
	public void updateRkxx(Rkxx rkxx) {
		// TODO Auto-generated method stub
		rkxxDao.update(rkxx);
		
	}
	@Transactional
	public void addRkxx(Rkxx rkxx) {
		// TODO Auto-generated method stub
		rkxxDao.insert(rkxx);
		Ypkcxx	ypkcxx  = ypkcxxDao.get(rkxx.getyPBM());
		if(ypkcxx==null){
			throw new YpkcxxNotFind(rkxx.getyPBM());		
		}
		else{
			Zgxx zgxx=zgxxDao.get(rkxx.getzGBM());
			if(zgxx==null) throw new ZgxxNotFind(rkxx.getzGBM());
			ypkcxx.setyPSL(ypkcxx.getyPSL()+rkxx.getrKL());
			ypkcxxDao.update(ypkcxx);
		}
	}
	public void delRkxx(Integer[] integers) {
		// TODO Auto-generated method stub
		rkxxDao.delete(integers);
	}

}
