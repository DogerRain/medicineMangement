package com.medicine.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import exception.GysNotFind;
import exception.YpkcxxNotFind;
import exception.ZgxxNotFind;
import pagination.Page;
import po.Cgdd;
import po.Gys;
import po.Ypkcxx;
import po.Zgxx;
import requestvo.CgddReqVo;
@Service
public class CgddService extends BaseServiceImpl{
		public Page findCgdd(CgddReqVo cgddReqVo){
			Page<Cgdd> page=new Page<>();
			if (cgddReqVo.getDdid() != null)
				page.getParams().put("ddid", cgddReqVo.getDdid());
			if(cgddReqVo.getZgbm()!=null) 
				page.getParams().put("zgbm", cgddReqVo.getZgbm());
			if(cgddReqVo.getGysbm()!=null) 
				page.getParams().put("gysbm", cgddReqVo.getGysbm());
			if(cgddReqVo.getSl()!=null) 
				page.getParams().put("sl", cgddReqVo.getSl());		
			if(cgddReqVo.getDdrq()!=null&&!"".equals((cgddReqVo.getDdrq())))
				page.getParams().put("ddrq",cgddReqVo.getDdrq());
			if(cgddReqVo.getDdrq1()!=null&&!"".equals((cgddReqVo.getDdrq1())))
				page.getParams().put("ddrq1",cgddReqVo.getDdrq1());
			if(cgddReqVo.getDdrq2()!=null&&!"".equals((cgddReqVo.getDdrq2())))
				page.getParams().put("ddrq2",cgddReqVo.getDdrq2());
			if(cgddReqVo.getYpbm()!=null&&!"".equals(cgddReqVo.getYpbm()))
				page.getParams().put("ypbm", cgddReqVo.getYpbm());
			if(cgddReqVo.getYpmc()!=null&&!"".equals(cgddReqVo.getYpmc()))
				page.getParams().put("ypmc", cgddReqVo.getYpmc());
			
			page.setPageNo(cgddReqVo.getPage());
			page.setPageSize(cgddReqVo.getRows());
			page.setResults(cgddDao.findPage(page));
			return page;
		}
		
		
		
		public void updateCgdd(Cgdd cgdd) {
			// TODO Auto-generated method stub
			cgddDao.update(cgdd);
			
		}
		@Transactional
		public void addCgdd(Cgdd cgdd) {
			// TODO Auto-generated method stub
			cgddDao.insert(cgdd);
			Ypkcxx ypkcxx=ypkcxxDao.get(cgdd.getYpbm());
			if(ypkcxx==null) throw new YpkcxxNotFind(cgdd.getYpbm());
			Gys gys=gysDao.get(cgdd.getGysbm());
			if(gys==null) throw new GysNotFind(cgdd.getGysbm());
			Zgxx zgxx=zgxxDao.get(cgdd.getZgbm());
			if(zgxx==null) throw new ZgxxNotFind(cgdd.getZgbm());
		}
		public void delCgdd(Integer[] integers) {
			// TODO Auto-generated method stub
			cgddDao.delete(integers);
		}

}
