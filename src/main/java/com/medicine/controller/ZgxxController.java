package com.medicine.controller;

import java.io.IOException;

import pagination.Page;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.medicine.service.impl.ZgxxService;

import po.Gys;
import po.Zgxx;
import requestvo.ZgxxReqVo;

@Controller
public class ZgxxController extends BaseController {
	@RequestMapping("/Zgxx")
		public void findZgxx(ZgxxReqVo zgxxReqVo,HttpServletResponse response)throws IOException{
		Page<Zgxx> page=zgxxService.findZgxx(zgxxReqVo);
		JSONObject jsonObject=new JSONObject();
		jsonObject.element("rows", page.getResults());
		jsonObject.element("total", page.getTotalRecord());
		response.setCharacterEncoding("UTF-8");  
		response.setContentType("application/json; charset=utf-8");  
		response.getWriter().print(jsonObject.toString());
	}
	@RequestMapping("/updateZgxx")
	public void updateZgxx(Zgxx zgxx,HttpServletResponse response) throws IOException{
		System.out.println(zgxx);
		zgxxService.updateZgxx(zgxx);
		response.sendRedirect("zgxx.html");
	}
	@RequestMapping("/addZgxx")
	public void addZgxx(Zgxx zgxx,HttpServletResponse response) throws IOException{
		
		zgxxService.addZgxx(zgxx);
		response.sendRedirect("zgxx.html");
	}
	@RequestMapping("/delZgxx")
	public void delZgxx(String ids,HttpServletResponse response) throws IOException{
		String[] id=ids.split(",");
		Integer[] integers=new Integer[id.length];
		for(int i=0;i<id.length;++i)
			integers[i]=Integer.parseInt(id[i]);
		zgxxService.delZgxx(integers);
		response.sendRedirect("zgxx.html");
	}
	@RequestMapping("/login")
	public void login(Integer zgbm,String zgmm,HttpServletResponse response,HttpSession session ) throws IOException{
		Zgxx zgxx=zgxxService.getZgxx(zgbm);
		if(zgxx==null||!zgmm.equals(zgxx.getZgmm())){
			response.sendRedirect("login.html");
		}
		else{
			session.setAttribute("user", zgxx);
			response.sendRedirect("medicine.jsp");
		}
	}
	@RequestMapping("/outLogin")
	public void outlogin(HttpServletResponse response,HttpSession session ) throws IOException{
			session.removeAttribute("user");
			response.sendRedirect("login.html");
		
	}
	@RequestMapping("/getUser")
	public void getUser(HttpServletResponse response,HttpSession session) throws IOException{
		Zgxx zgxx=(Zgxx) session.getAttribute("user");
		response.getWriter().print(zgxx.getZgbm());
		
	}
}
