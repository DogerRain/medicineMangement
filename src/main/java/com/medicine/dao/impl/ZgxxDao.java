package com.medicine.dao.impl;

import org.springframework.stereotype.Repository;

import po.Zgxx;
@Repository
public class ZgxxDao extends BaseDaoImpl<Zgxx>{
	public ZgxxDao(){
		super.setNs("com.medicine.mapper.ZgxxMapper");
	}
}
