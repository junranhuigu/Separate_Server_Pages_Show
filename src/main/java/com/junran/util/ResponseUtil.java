package com.junran.util;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.LoggerFactory;

public class ResponseUtil {
	
	public static void writeMessage(String result, HttpServletRequest request, HttpServletResponse response){
		String callback = request.getParameter("callback");
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		try {
			PrintWriter out = response.getWriter();
			out.print(callback + "(" + result + ")");
		} catch (Exception e) {
			StackTraceElement stack[] = Thread.currentThread().getStackTrace();
			LoggerFactory.getLogger(ResponseUtil.class).error(request.getRemoteAddr() + "调用" +  stack[2].getClassName() + "." + stack[2].getMethodName() + "()方法输出出错", e);
		}
	}
	
}
