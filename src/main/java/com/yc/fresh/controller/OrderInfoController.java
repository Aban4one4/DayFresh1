package com.yc.fresh.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.fresh.entity.OrderInfo;
import com.yc.fresh.service.IOrderInfoService;

@Controller
@RequestMapping("/order")
@ResponseBody
public class OrderInfoController {
	@Autowired
	private IOrderInfoService service;
 
	@RequestMapping("/add")
	public int add(OrderInfo of){
		return service.add(of);
	}
}
