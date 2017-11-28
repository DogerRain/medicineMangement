package com.medicine.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pagination.Page;
import po.Cgdd;
import po.Rkxx;
import po.Ypkcxx;
import po.Ypxx;
import po.Zgxx;
import requestvo.CgddReqVo;
import requestvo.RkxxReqVo;
import requestvo.YpkcxxReqVo;

import com.medicine.dao.impl.YpkcxxDao;
import com.medicine.dao.impl.RkxxDao;
import com.medicine.service.impl.RkxxService;

@Controller
public class CgddController extends BaseController{
	
	@RequestMapping("/Cgdd")
	public void findCgdd(CgddReqVo cgddReqVo ,HttpServletResponse response) throws IOException{
		Page<Cgdd> page=cgddService.findCgdd(cgddReqVo);
		JSONObject jsonObject=new JSONObject();
		jsonObject.element("rows", page.getResults());
		jsonObject.element("total", page.getTotalRecord());
		response.setCharacterEncoding("UTF-8");  
		response.setContentType("application/json; charset=utf-8");  
		response.getWriter().print(jsonObject.toString());
		
	}
	@RequestMapping("/updateCgdd")
	public void updateCgdd(Cgdd cgdd,HttpServletResponse response) throws IOException{
		System.out.println("采购订单"+"\n"+cgdd);
		cgddService.updateCgdd(cgdd);
		response.sendRedirect("cgdd.html");
	}
	
	@RequestMapping("/addCgdd")
	public void addCgdd(Cgdd cgdd,HttpServletResponse response,HttpSession session) throws IOException{
	/*	Zgxx zgxx=(Zgxx) session.getAttribute("user");
		cgdd.setZgbm(zgxx.getZgbm());*/
		cgddService.addCgdd(cgdd);
		response.sendRedirect("cgdd.html");
	}
	
	@RequestMapping("/delCgdd")
	public void addCpxx(String ids,HttpServletResponse response) throws IOException{
		String[] id=ids.split(",");
		Integer[] integers=new Integer[id.length];
		for(int i=0;i<id.length;++i)
			integers[i]=Integer.parseInt(id[i]);
		cgddService.delCgdd(integers);
		response.sendRedirect("cgdd.html");
	}
	
	
}
