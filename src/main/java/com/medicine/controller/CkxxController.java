package com.medicine.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pagination.Page;
import po.Ckxx;
import po.Rkxx;
import po.Ypkcxx;
import po.Ypxx;
import requestvo.CkxxReqVo;
import requestvo.RkxxReqVo;
import requestvo.YpkcxxReqVo;

import com.medicine.dao.impl.YpkcxxDao;
import com.medicine.dao.impl.RkxxDao;
import com.medicine.service.impl.RkxxService;

@Controller
public class CkxxController extends BaseController{
	
	@RequestMapping("/Ckxx")
	public void findCkxx(CkxxReqVo ckxxReqVo ,HttpServletResponse response) throws IOException{
		Page<Ckxx> page=ckxxService.findCkxx(ckxxReqVo);
		JSONObject jsonObject=new JSONObject();
		jsonObject.element("rows", page.getResults());
		jsonObject.element("total", page.getTotalRecord());
		response.setCharacterEncoding("UTF-8");  
		response.setContentType("application/json; charset=utf-8");  
		response.getWriter().print(jsonObject.toString());
		
	}
	@RequestMapping("/updateCkxx")
	public void updateCkxx(Ckxx ckxx,HttpServletResponse response) throws IOException{
		System.out.println(ckxx);
		ckxxService.updateCkxx(ckxx);
		response.sendRedirect("ckxx.html");
	}
	
	@RequestMapping("/addCkxx")
	public void addCkxx(Ckxx ckxx,HttpServletResponse response) throws IOException{
		
		ckxxService.addCkxx(ckxx);
		response.sendRedirect("ckxx.html");
	}
	
	@RequestMapping("/delCkxx")
	public void addCpxx(String ids,HttpServletResponse response) throws IOException{
		String[] id=ids.split(",");
		Integer[] integers=new Integer[id.length];
		for(int i=0;i<id.length;++i)
			integers[i]=Integer.parseInt(id[i]);
		ckxxService.delCkxx(integers);
		response.sendRedirect("rkxx.html");
	}
	
	
}
