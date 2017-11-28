package com.medicine.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pagination.Page;
import po.Ypkcxx;

import po.Ypxx;
import requestvo.YpkcxxReqVo;

import com.google.gson.JsonObject;
import com.medicine.dao.impl.YpkcxxDao;
import com.medicine.dao.impl.RkxxDao;

//@Controller
public class MedicineController extends BaseController{
	
	@RequestMapping("/sss")
	public void findYpxx(YpkcxxReqVo ypxxReqVo,HttpServletResponse response) throws IOException{
		Page<Ypxx> page=ypxxService.findYpxx(ypxxReqVo);
		JSONObject jsonObject=new JSONObject();
		jsonObject.element("rows", page.getResults());
		jsonObject.element("total", page.getTotalRecord());
		response.setCharacterEncoding("UTF-8");  
		response.setContentType("application/json; charset=utf-8");  
		response.getWriter().print(jsonObject.toString());
		
	}
	@RequestMapping("/updateYpxx")
	public void updateYpxx(Ypxx ypxx,HttpServletResponse response) throws IOException{
		System.out.println(ypxx);
		ypxxService.updateYpxx(ypxx);
		response.sendRedirect("med.html");
	}
	@RequestMapping("/addYpxx")
	public void addYpxx(Ypxx ypxx,HttpServletResponse response) throws IOException{
		
		ypxxService.addYpxx(ypxx);
		response.sendRedirect("med.html");
	}
	@RequestMapping("/delYpxx")
	public void addYpxx(String ids,HttpServletResponse response) throws IOException{
		String[] id=ids.split(",");
		Integer[] integers=new Integer[id.length];
		for(int i=0;i<id.length;++i)
			integers[i]=Integer.parseInt(id[i]);
		ypxxService.delYpxx(integers);
		response.sendRedirect("med.html");
	}
	@RequestMapping("/checkYPBM")
	public void checkYPBM(Integer yPBM,HttpServletResponse response) throws IOException{
		Ypxx ypxx= ypxxService.getYpxx(yPBM);
		if(ypxx==null)
			response.getWriter().print("null");
		else
			response.getWriter().print(ypxx.getyPMC());
	}
	@RequestMapping("/findAllYpxx")
	public void findAllYpxx(HttpServletResponse response) throws IOException{
		
		response.setCharacterEncoding("UTF-8");  
		response.setContentType("application/json; charset=utf-8"); 
		JsonObject jsonObject=new JsonObject();
		JSONArray jsonArray=JSONArray.fromObject(ypxxService.findAll());
		response.getWriter().print(jsonArray.toString());
	}
	
}
