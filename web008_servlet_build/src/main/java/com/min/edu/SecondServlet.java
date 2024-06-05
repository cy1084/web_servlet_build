package com.min.edu;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecondServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 591745080341264238L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(this.getClass().getName() + "Get 요청");

		// 1) parameter 요청을 받을 수 있지만
		// redirect로 전송했을 경우엔 객체인 attribute는 받을 수 없다
		req.setCharacterEncoding("UTF-8");
		String name = req.getParameter("name");
		String encodeName = URLEncoder.encode(name, StandardCharsets.UTF_8.toString());
		System.out.println("firstServlet에서 전달한 queryString 값: " + encodeName);

		// 2)
//		String name=req.getParameter("name");
//		String firstValue=(String)req.getAttribute("firstValue");
//		System.out.println("firstServlet의 parameter: "+name);
//		System.out.println("firstServlet의 attribute: "+firstValue);
	}

}
