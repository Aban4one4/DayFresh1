package com.yc.fresh.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DownLoadServlet")
public class UploadServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
		this.doPost(request, response);
    }
	
	
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String filename="images/goods/goods001.jpg";
        //当文件名不是英文名的时候，最好使用url解码器去编码一下，
        filename=URLEncoder.encode(filename,"UTF-8");
        //将响应的类型设置为图片
        response.setContentType("application/x-msdownload");
        response.setHeader("Content-Disposition", "attachment;filename=" + filename);
        
        //好了 ，现在通过IO流来传送数据
        InputStream input=getServletContext().getResourceAsStream("/images/goods/goods001.jpg");
        System.out.println(input);
        OutputStream output = response.getOutputStream();
        byte[]buff=new byte[1024*10];//可以自己 指定缓冲区的大小
        int len=0;
        while((len=input.read(buff))>-1)
        {
            output.write(buff,0,len);
        }
        //关闭输入输出流
        input.close();
        output.close();
         
    }
 
}