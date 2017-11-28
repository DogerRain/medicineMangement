package com.medicine.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import pagination.Page;
import po.Ypkcxx;
import po.Ypxx;
import requestvo.YpkcxxReqVo;

@Service
public class YpkcxxService extends BaseServiceImpl{
	public Page findYpkcxx(YpkcxxReqVo ypkcxxReqVo){
		Page<Ypkcxx> page=new Page<>();
		if(ypkcxxReqVo.getyPBM()!=null) page.getParams().put("yPBM",ypkcxxReqVo.getyPBM());
		if(ypkcxxReqVo.getyPMC()!=null) page.getParams().put("yPMC", "%"+ypkcxxReqVo.getyPMC()+"%");
		if(ypkcxxReqVo.getyPSJ1()!=null) page.getParams().put("yPSJ1", ypkcxxReqVo.getyPSJ1());
		if(ypkcxxReqVo.getyPSJ2()!=null) page.getParams().put("yPSJ2", ypkcxxReqVo.getyPSJ2());
		if(ypkcxxReqVo.getyXRQ1()!=null&&!"".equals((ypkcxxReqVo.getyXRQ1())))
			page.getParams().put("yXRQ1",ypkcxxReqVo.getyXRQ1());
		if(ypkcxxReqVo.getyXRQ2()!=null&&!"".equals((ypkcxxReqVo.getyXRQ2())))
			page.getParams().put("yXRQ2",ypkcxxReqVo.getyXRQ2());
		if(ypkcxxReqVo.getyPJX()!=null)
			page.getParams().put("yPJX",ypkcxxReqVo.getyPJX() );
		page.setPageNo(ypkcxxReqVo.getPage());
		page.setPageSize(ypkcxxReqVo.getRows());
		page.setResults(ypkcxxDao.findPage(page));
		return page;
	}
	public void updateYpkcxx(Ypkcxx ypkcxx){
		ypkcxxDao.update(ypkcxx);
	}
	public void addYpkcxx(Ypkcxx ypkcxx) {
		// TODO Auto-generated method stub
		ypkcxxDao.insert(ypkcxx);
		
	}
	public void delYpkcxx(Integer[] integers) {
		// TODO Auto-generated method stub
		ypkcxxDao.delete(integers);
		
	}
	public Ypkcxx getYpkcxx(Integer yPBM){
		return ypkcxxDao.get(yPBM);
	}
	public List<Ypkcxx> findAll(){
		return ypkcxxDao.find(new HashMap<>());
	}
}
