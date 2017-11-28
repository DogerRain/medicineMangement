package com.medicine.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import pagination.Page;
import po.Ypxx;
import requestvo.YpkcxxReqVo;

@Service
public class YpxxService extends BaseServiceImpl{
	public Page findYpxx(YpkcxxReqVo ypxxReqVo){
		Page<Ypxx> page=new Page<>();
		if(ypxxReqVo.getyPBM()!=null) page.getParams().put("yPBM",ypxxReqVo.getyPBM());
		if(ypxxReqVo.getyPMC()!=null) page.getParams().put("yPMC", "%"+ypxxReqVo.getyPMC()+"%");
		if(ypxxReqVo.getyPSJ1()!=null) page.getParams().put("yPSJ1", ypxxReqVo.getyPSJ1());
		if(ypxxReqVo.getyPSJ2()!=null) page.getParams().put("yPSJ2", ypxxReqVo.getyPSJ2());
		if(ypxxReqVo.getyXRQ1()!=null&&!"".equals((ypxxReqVo.getyXRQ1())))
			page.getParams().put("yXRQ1",ypxxReqVo.getyXRQ1());
		if(ypxxReqVo.getyXRQ2()!=null&&!"".equals((ypxxReqVo.getyXRQ2())))
			page.getParams().put("yXRQ2",ypxxReqVo.getyXRQ2());
		if(ypxxReqVo.getyPJX()!=null)
			page.getParams().put("yPJX",ypxxReqVo.getyPJX() );
		page.setPageNo(ypxxReqVo.getPage());
		page.setPageSize(ypxxReqVo.getRows());
		page.setResults(ypxxDao.findPage(page));
		return page;
	}
	public void updateYpxx(Ypxx ypxx){
		ypxxDao.update(ypxx);
	}
	public void addYpxx(Ypxx ypxx) {
		// TODO Auto-generated method stub
		ypxxDao.insert(ypxx);
		
	}
	public void delYpxx(Integer[] integers) {
		// TODO Auto-generated method stub
		ypxxDao.delete(integers);
		
	}
	public Ypxx getYpxx(Integer yPBM){
		return ypxxDao.get(yPBM);
	}
	public List<Ypxx> findAll(){
		return ypxxDao.find(new HashMap<>());
	}
}
