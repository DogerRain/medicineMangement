package com.medicine.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import pagination.Page;
import po.Ypkcxx;
import po.Ypxx;

import com.medicine.dao.BaseDao;
@Repository
public class YpxxDao extends BaseDaoImpl<Ypxx>{
	public YpxxDao(){
		super.setNs("com.medicine.mapper.YpxxMapper");
	}
	

}
