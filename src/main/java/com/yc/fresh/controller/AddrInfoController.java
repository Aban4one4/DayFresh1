package com.yc.fresh.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.fresh.entity.AddrInfo;
import com.yc.fresh.entity.MenberInfo;
import com.yc.fresh.service.IAddrInfoService;
import com.yc.fresh.util.StringUtil;

@Controller
@RequestMapping("/addr")
@ResponseBody
public class AddrInfoController {
	@Autowired
	private IAddrInfoService service;
/**
 * 增加地址
 * @param session
 * @param af
 * @return
 */
	@RequestMapping("/add")
	public int add(HttpSession session ,AddrInfo af){
		Object obj =session.getAttribute("currentMenberInfo");
		if(obj==null){
			return -2;
		}
		MenberInfo mf=(MenberInfo) obj;
		af.setMno(mf.getMno());
		return service.add(af);
	}
	/**
	 * 更新地址
	 * @param addrs
	 * @return
	 */
	
	@RequestMapping("/update")
	public int add(String addrs){
		if(StringUtil.isNull(addrs)){
			return -2;
		}
		return service.update(addrs.split(","));
	}
	
	/**
	 * 查找地址
	 * @param session
	 * @return
	 */
	@RequestMapping("/findByMno")
	public List<AddrInfo> findByMno(HttpSession session){
		Object obj =session.getAttribute("currentMenberInfo");
		if(obj==null){
			return null;
		}
		MenberInfo mf=(MenberInfo) obj;
		return service.findByMno(mf.getMno());
	}
}
