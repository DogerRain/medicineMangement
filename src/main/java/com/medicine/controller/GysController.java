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
import po.Gys;
import po.Ypkcxx;
import po.Ypxx;
import requestvo.GysReqVo;
import requestvo.YpkcxxReqVo;

import com.google.gson.JsonObject;
import com.medicine.dao.impl.GysDao;
import com.medicine.dao.impl.YpkcxxDao;
import com.medicine.dao.impl.RkxxDao;

@Controller
public class GysController extends BaseController{
	@Autowired
	GysDao gysDao;
	@RequestMapping("/Gys")
	public void findGys(GysReqVo gysReqVo,HttpServletResponse response) throws IOException{
		Page<Gys> page=gysService.findGys(gysReqVo);
		JSONObject jsonObject=new JSONObject();
		jsonObject.element("rows", page.getResults());
		jsonObject.element("total", page.getTotalRecord());
		response.setCharacterEncoding("UTF-8");  
		response.setContentType("application/json; charset=utf-8");  
		response.getWriter().print(jsonObject.toString());
		
	}
	@RequestMapping("/updateGys")
	public void updateGys(Gys gys,HttpServletResponse response) throws IOException{
		System.out.println(gys);
		gysService.updateGys(gys);
		response.sendRedirect("gys.html");
	}
	@RequestMapping("/addGys")
	public void addGys(Gys gys,HttpServletResponse response) throws IOException{
		
		gysService.addGys(gys);
		response.sendRedirect("gys.html");
	}
	@RequestMapping("/delGys")
	public void delGys(String ids,HttpServletResponse response) throws IOException{
		String[] id=ids.split(",");
		Integer[] integers=new Integer[id.length];
		for(int i=0;i<id.length;++i)
			integers[i]=Integer.parseInt(id[i]);
		gysService.delGys(integers);
		response.sendRedirect("gys.html");
	}
	@RequestMapping("/checkgys")
	public void checkYPBM(Integer gysbm,HttpServletResponse response) throws IOException{
		Gys gys=gysDao.get(gysbm);
		if(gys==null)
			response.getWriter().print("");
		else
			response.getWriter().print("live");
	}
	/*@RequestMapping("/findAllYpxx")
	public void findAllYpxx(HttpServletResponse response) throws IOException{
		
		response.setCharacterEncoding("UTF-8");  
		response.setContentType("application/json; charset=utf-8"); 
		JsonObject jsonObject=new JsonObject();
		JSONArray jsonArray=JSONArray.fromObject(ypkcxxService.findAll());
		response.getWriter().print(jsonArray.toString());
	}
	*/
}
