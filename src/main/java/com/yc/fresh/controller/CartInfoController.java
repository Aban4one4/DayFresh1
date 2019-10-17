package com.yc.fresh.controller;


import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.fresh.entity.CartInfo;
import com.yc.fresh.entity.MenberInfo;
import com.yc.fresh.service.ICartInfoService;

@Controller
@RequestMapping("/cart")
@ResponseBody
public class CartInfoController {

	@Autowired
	private  ICartInfoService service;

	@RequestMapping("/add")
	public int add(HttpSession session,CartInfo cf,HttpServletResponse response){

		//先校验用户是否登录
		Object obj=session.getAttribute("currentMenberInfo");
		if(obj==null){
			return -1;
		}
		MenberInfo mf=(MenberInfo) obj;
		cf.setMno(mf.getMno());
		cf.setNum(1);

		//将商品信息加入数据库
		return service.add(cf);
	}


	@RequestMapping("/find")
	public List<CartInfo> find(HttpSession session){
		Object obj=session.getAttribute("currentMenberInfo");

		if(obj==null){
			return null;
		}
		MenberInfo mf=(MenberInfo) obj;
		return service.findByMno(mf.getMno());
	}

	
	@RequestMapping("/getInfo")
	public List<CartInfo> getInfo(HttpSession session){
		Object obj=session.getAttribute("currentMenberInfo");

		if(obj==null){
			return null;
		}
		MenberInfo mf=(MenberInfo) obj;
		return service.finds(mf.getMno());
	}
  
	@RequestMapping("/update")
     public int update(HttpSession session,CartInfo cf){
    	 Object obj=session.getAttribute("currentMenberInfo");

 		if(obj==null){
 			return -1;
 		}
 		MenberInfo mf=(MenberInfo) obj;
 		cf.setMno(mf.getMno());
     return service.update(cf);
     }
  
	@RequestMapping("/del")
	public int del(int cno){
		return service.deleteByCno(cno);
	}
	
	
	@RequestMapping("/findByCnos")
	public List<CartInfo> findByCnos(String cno){
		return service.findByCnos(cno.split(","));
	}


	 
}
