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

@Controller
public class YpkcxxController extends BaseController{
	
	@RequestMapping("/Ypkcxx")
	public void findYpxx(YpkcxxReqVo ypkcxxReqVo,HttpServletResponse response) throws IOException{
		Page<Ypxx> page=ypkcxxService.findYpkcxx(ypkcxxReqVo);
		JSONObject jsonObject=new JSONObject();
		jsonObject.element("rows", page.getResults());
		jsonObject.element("total", page.getTotalRecord());
		response.setCharacterEncoding("UTF-8");  
		response.setContentType("application/json; charset=utf-8");  
		response.getWriter().print(jsonObject.toString());
		
	}
	@RequestMapping("/updateYpkcxx")
	public void updateYpkcxx(Ypkcxx ypkcxx,HttpServletResponse response) throws IOException{
		System.out.println(ypkcxx);
		ypkcxxService.updateYpkcxx(ypkcxx);
		response.sendRedirect("ypkcxx.html");
	}
	@RequestMapping("/addYpkcxx")
	public String addYpkcxx(Ypkcxx ypkcxx,HttpServletResponse response,HttpServletRequest request) throws IOException{
		
		ypkcxxService.addYpkcxx(ypkcxx);
		request.setAttribute("ypkcxx", ypkcxx);
		return "addypkcxxsucc.jsp";
	}
	@RequestMapping("/delYpkcxx")
	public void delYpkcxx(String ids,HttpServletResponse response) throws IOException{
		String[] id=ids.split(",");
		Integer[] integers=new Integer[id.length];
		for(int i=0;i<id.length;++i)
			integers[i]=Integer.parseInt(id[i]);
		ypkcxxService.delYpkcxx(integers);
		response.sendRedirect("ypkcxx.html");
	}
	@RequestMapping("/checkypbm")
	public void checkYPBM(Integer yPBM,HttpServletResponse response) throws IOException{
		Ypkcxx ypxx= ypkcxxService.getYpkcxx(yPBM);
		if(ypxx==null)
			response.getWriter().print("null");
		else
			response.getWriter().print(ypxx.getyPMC());
	}
	/*
	@RequestMapping("/findAllYpxx")
	public void findAllYpxx(HttpServletResponse response) throws IOException{
		
		response.setCharacterEncoding("UTF-8");  
		response.setContentType("application/json; charset=utf-8"); 
		JsonObject jsonObject=new JsonObject();
		JSONArray jsonArray=JSONArray.fromObject(ypkcxxService.findAll());
		response.getWriter().print(jsonArray.toString());
	}
	*/
}
