package com.medicine.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;








import com.medicine.dao.impl.CgddDao;
import com.medicine.dao.impl.CkxxDao;
import com.medicine.dao.impl.GysDao;
import com.medicine.dao.impl.YpkcxxDao;
import com.medicine.dao.impl.RkxxDao;
import com.medicine.dao.impl.YpxxDao;
import com.medicine.dao.impl.ZgxxDao;

public class BaseServiceImpl {
	@Autowired
	YpkcxxDao ypkcxxDao;
	@Autowired
	YpxxDao ypxxDao;
	@Autowired
	RkxxDao rkxxDao;
	@Autowired
	CkxxDao ckxxDao;
	@Autowired
	GysDao gysDao;
	@Autowired
	ZgxxDao zgxxDao;
	@Autowired
	CgddDao cgddDao;
	
}
