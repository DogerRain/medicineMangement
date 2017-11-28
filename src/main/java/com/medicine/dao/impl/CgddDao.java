package com.medicine.dao.impl;

import org.springframework.stereotype.Repository;

import po.Cgdd;
import po.Ckxx;

@Repository
public class CgddDao extends BaseDaoImpl<Cgdd>{
	public CgddDao(){
		super.setNs("com.medicine.mapper.CgddMapper");
	}
	

}