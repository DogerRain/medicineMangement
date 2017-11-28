package com.medicine.controller;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import com.medicine.service.impl.CgddService;
import com.medicine.service.impl.CkxxService;
import com.medicine.service.impl.GysService;
import com.medicine.service.impl.RkxxService;
import com.medicine.service.impl.YpkcxxService;
import com.medicine.service.impl.YpxxService;
import com.medicine.service.impl.ZgxxService;
public class BaseController {
	@Autowired
	YpxxService ypxxService;
	@Autowired
	RkxxService rkxxService;
	@Autowired
	YpkcxxService ypkcxxService;
	@Autowired
	CkxxService ckxxService;
	@Autowired
	GysService gysService;
	@Autowired
	ZgxxService zgxxService;
	@Autowired
	CgddService cgddService;
}
