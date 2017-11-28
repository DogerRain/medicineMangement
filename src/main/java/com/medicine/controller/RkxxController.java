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
import po.Rkxx;
import po.Ypkcxx;
import po.Ypxx;
import requestvo.RkxxReqVo;
import requestvo.YpkcxxReqVo;

import com.medicine.dao.impl.YpkcxxDao;
import com.medicine.dao.impl.RkxxDao;
import com.medicine.service.impl.RkxxService;

@Controller
public class RkxxController extends BaseController{
	
	@RequestMapping("/Rkxx")
	public void findRkxx(RkxxReqVo rkxxReqVo ,HttpServletResponse response) throws IOException{
		Page<Rkxx> page=rkxxService.findRkxx(rkxxReqVo);
		JSONObject jsonObject=new JSONObject();
		jsonObject.element("rows", page.getResults());
		jsonObject.element("total", page.getTotalRecord());
		response.setCharacterEncoding("UTF-8");  
		response.setContentType("application/json; charset=utf-8");  
		response.getWriter().print(jsonObject.toString());
		
	}
	@RequestMapping("/updateRkxx")
	public void updateYprkjl(Rkxx rkxx,HttpServletResponse response) throws IOException{
		System.out.println(rkxx);
		rkxxService.updateRkxx(rkxx);
		response.sendRedirect("rkxx.html");
	}
	
	@RequestMapping("/addRkxx")
	public void addRkxx(Rkxx rkxx,HttpServletResponse response) throws IOException{
		
		rkxxService.addRkxx(rkxx);
		response.sendRedirect("rkxx.html");
	}
	
	@RequestMapping("/delRkxx")
	public void addYpxx(String ids,HttpServletResponse response) throws IOException{
		String[] id=ids.split(",");
		Integer[] integers=new Integer[id.length];
		for(int i=0;i<id.length;++i)
			integers[i]=Integer.parseInt(id[i]);
		rkxxService.delRkxx(integers);
		response.sendRedirect("rkxx.html");
	}
	
	
}
