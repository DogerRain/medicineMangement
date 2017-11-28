package com.medicine.service.impl;

import org.springframework.stereotype.Service;

import com.medicine.dao.impl.ZgxxDao;

import pagination.Page;
import po.Gys;
import po.Zgxx;
import requestvo.ZgxxReqVo;


@Service
public class ZgxxService extends BaseServiceImpl {
	public Page findZgxx(ZgxxReqVo zgxxReqVo){
		Page<Zgxx> page=new Page<>();
		if (zgxxReqVo.getZgmm() != null)
			page.getParams().put("zgmm", zgxxReqVo.getZgmm());
		if(zgxxReqVo.getZgbm()!=null) page.getParams().put("zgbm", zgxxReqVo.getZgbm());
		if(zgxxReqVo.getZgmc()!=null) page.getParams().put("zgmc", "%"+zgxxReqVo.getZgmc()+"%");
	
		page.setPageNo(zgxxReqVo.getPage());
		page.setPageSize(zgxxReqVo.getRows());
		page.setResults(zgxxDao.findPage(page));
		return page;
	}
	
	
	
	public void updateZgxx(Zgxx zgxx)  {
		// TODO Auto-generated method stub
		zgxxDao.update(zgxx);
		
	}
	public void addZgxx(Zgxx zgxx) {
		// TODO Auto-generated method stub
		zgxxDao.insert(zgxx);
	}
	public void delZgxx(Integer[] integers) {
		// TODO Auto-generated method stub
		zgxxDao.delete(integers);
	}
	public Zgxx getZgxx(Integer id){
		return zgxxDao.get(id);
	}

}
