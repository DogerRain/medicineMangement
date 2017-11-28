package com.medicine.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import pagination.Page;
import po.Ckxx;
import po.Gys;
import po.Ypkcxx;

import com.medicine.dao.BaseDao;
@Repository
public class GysDao extends BaseDaoImpl<Gys>{
	public GysDao(){
		super.setNs("com.medicine.mapper.GysMapper");
	}
	

}
