package com.medicine.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import pagination.Page;
import po.Ckxx;
import po.Ypkcxx;

import com.medicine.dao.BaseDao;
@Repository
public class CkxxDao extends BaseDaoImpl<Ckxx>{
	public CkxxDao(){
		super.setNs("com.medicine.mapper.CkxxMapper");
	}
	

}
