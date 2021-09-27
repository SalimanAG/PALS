package com.sil.gpc.utilities;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class SalTools {
	
	public static ServletRequestAttributes  getAppContex() {
		return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes());
	}
	
	public static void sendErr(String msg) {
		HttpServletResponse response = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getResponse();
		
		response.setStatus(444);
		response.setContentType("application/json");//("text/plain;charset=utf-8");
		PrintWriter out;
		try {
			out = response.getWriter();
			out.print("{\"text\":\""+msg+"\"}");
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
}
