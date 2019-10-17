package com.yc.fresh.controller;


import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.fresh.entity.MenberInfo;
import com.yc.fresh.service.IMenberInfoService;
import com.yc.fresh.util.SendMailUtil;

@Controller
@RequestMapping("/menber")
@ResponseBody
public class MenberInfoController {
	@Autowired
	private IMenberInfoService service;
	@Autowired
	private SendMailUtil sendMailUtil;

	@RequestMapping("/login")
	@ResponseBody
	public int login(MenberInfo mb,HttpSession session){
		System.out.println(111);
		System.out.println(mb);

		MenberInfo menberInfo=service.login(mb);
		System.out.println(menberInfo);

		if(menberInfo!=null){
			session.setAttribute("currentMenberInfo", menberInfo);
			return 1;
		}
		return 0;
	}
	
	/**
	 * 发送验证码的方法
	 * @param name
	 * @param email
	 * @param session
	 * @return
	 */
	@RequestMapping("/code")
	public  int code(String name,String email,HttpSession session){
		int result=-1;

		try {
			String code="";
			Random rd=new Random();
			while(code.length()<6){
				code +=rd.nextInt(10);
			}
			if(sendMailUtil.sendHtmlMail(email, name, code)){
				session.setAttribute("code", code);
				System.out.println(code);
				//启用一个定时任务，当三分钟后清空这个session的值
				
				TimerTask task=new TimerTask() {

					@Override
					public void run() {
						session.setAttribute("code", "");
						session.removeAttribute("code");		
					}
				};
				Timer timer =new Timer();
				timer.schedule(task, 18000);
				result =1;
			}else{
				result=0;
			}
		} catch (MessagingException e) {
			e.printStackTrace();
		}

		return result;
	}

    @RequestMapping("/reg")
	public int code (HttpSession session ,MenberInfo mf){
		String code=(String) session.getAttribute("code");
		System.out.println(session.getAttribute(code)+"11111111");
		System.out.println(mf.getRealName());
	
		if(!code.equals(mf.getRealName())){
			return -2;
		}
    	return service.add(mf);
		
	}
   @RequestMapping("/check")
    public MenberInfo checkLogin(HttpSession session){
    	Object obj =session.getAttribute("currentMenberInfo");
    	if(obj==null){
    		return new MenberInfo();
    	}
    	return  (MenberInfo) obj;
    }

}
