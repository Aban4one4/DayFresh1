package com.yc.fresh.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.fresh.entity.AdminInfo;
import com.yc.fresh.service.IAdminInfoService;

@Controller
@RequestMapping("/back")
public class AdminInfoController {
	@Autowired
	private IAdminInfoService service;

	@RequestMapping("/login")
	@ResponseBody
	public int login(AdminInfo af,HttpSession session){
		AdminInfo adminInfo=service.login(af);
		if(adminInfo!=null){
			session.setAttribute("currentAdminInfo", adminInfo);
			return 1;
		}
		return 0;
	}
	@RequestMapping("/admin/findAll")
	@ResponseBody
	public List<AdminInfo> findAll(){
		return service.findAll();
	}
	@RequestMapping("/admin/add")
	@ResponseBody
	public int add(AdminInfo af){
		return service.add(af);
	}
	
	@RequestMapping("/admin/update")
	@ResponseBody
	public int update(int aid){
		return service.updatePwd(aid);
	}
	
	@RequestMapping("/manager")
	public String successLogin(){
		return "index";
	}

}
