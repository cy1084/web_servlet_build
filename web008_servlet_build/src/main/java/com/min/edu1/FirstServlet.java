package com.min.edu1;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/firstServlet.do")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(this.getClass().getName()+"doPost 요청");
		
		request.setCharacterEncoding("UTF-8"); //한글깨짐 방지
		String name=request.getParameter("name");
		System.out.println("post로 요청된 값: "+name);
		
		//흐름 제어: 다른 servlet을 요청
		//parameter의 전송, attribute의 전송
		//response의 전송
		
		
		//1)
//		String encode=URLEncoder.encode(name,"UTF-8");
////		response.setContentType("text/html; charset=UTF-8;");
//		response.sendRedirect("./secondServlet.do?name="+encode);
		
		
		//2)
		request.setAttribute("firstValue", "firstValue");
		request.getRequestDispatcher("/secondServlet.do").forward(request, response);
		//서블릿에서는 서블릿 요청 못함
		
	}

}
