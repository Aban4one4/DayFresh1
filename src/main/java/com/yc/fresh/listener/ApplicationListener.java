package com.yc.fresh.listener;

import java.io.File;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ApplicationListener
 *
 */

//监听器当servlet程序启动时自动启动
@WebListener
public class ApplicationListener implements ServletContextListener {



	public void contextDestroyed(ServletContextEvent arg0)  { 
	}


	public void contextInitialized(ServletContextEvent arg0)  { 
		String path="pics";
		String temp=arg0.getServletContext().getInitParameter("uploadPath");
		if(temp!=null &&!"".equals(temp)){
			path=temp;
		}
		String basePath=arg0.getServletContext().getRealPath("/");
		File fl=new  File(basePath,"../"+path);
		if(!fl.exists()){
			fl.mkdirs();
		}

	}

}
