package com.yc.fresh.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class FrontForwardInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if(request.getSession().getAttribute("currentMenberInfo")==null){
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out =response.getWriter();
			out.print("<script>alert('清先登录...');localStorage.setItem('targetUrl','front/cart.html');location.href='../login.html';<script>");
			out.flush();
			return false;
		}
		String path=request.getServletPath();
		path=path.substring(path.lastIndexOf("/")+1);
		request.getRequestDispatcher("/WEB-INF/front/" +path).forward(request, response);
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}



}
