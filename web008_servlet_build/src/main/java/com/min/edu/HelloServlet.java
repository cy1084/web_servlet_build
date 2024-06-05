package com.min.edu;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * HttpServlet을 extends 하여 화면의 요청을 처리하는 클래스
 * Life-Cycle 개발로 진행되어야 함
 */
public class HelloServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9173344449137691064L;
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(this.getClass().getName()+"요청된 서비스 doGet Protocol처리");
		
		//주소로(GET) 전달받은 요청값(Parameter)을 java 객체로 변환 
		//무조건 문자열로만 받을 수 있으므로 형변환 해야 함
		//요청된 파라미터는 HttpServletRequest에 담겨있다
		String val=req.getParameter("name");
		System.out.println("요청받은 값: "+val);
		
		//흐름처리 작성 부분
		//1) 응답(값(html)을 전송 or 화면만 요청할 때 사용(ws 페이지))
		//응답해줄 값의 형태를 지정해준다(mime type)
		resp.setContentType("text/html; charset=UTF-8;"); //text 보낼거니까 html로 읽어
		
		
//		StringBuffer sb=new StringBuffer();
//		sb.append("<html>");
//		sb.append("<head>");
//		sb.append("<title>server에서 HTML 전달</title>");
//		sb.append("</head>");
//		sb.append("<h1>");
//		sb.append(val);
//		sb.append("</h1>");
//		sb.append("</html>");
//		resp.getWriter().println(sb.toString()); //1-1)HTML을 내가 만들어서 보냄
//		
		
		
		//1-2) 화면만 요청할 때(WS 페이지) 값을 전달할 수 있다
		//ws에 생성되어 있는 정적 페이지 요청
		//보안 영역은 호출할 수 없다!!
		//resp.sendRedirect는 브라우저의 주소에 작성하는 것과 같다- 서블릿을 통해서는 못들어감
//		resp.sendRedirect("./WEB-INF/views/hello_newPage.html");
		
		//2) 요청(값(java)을 통해 HTML을 만들어서 새로 요청할 때 : jsp)
		String newStr=val.concat(" 다음날은 화요일이다.");
		req.setAttribute("newStr", newStr); //값을 담음
		req.getRequestDispatcher("/WEB-INF/views/hello_newPage.jsp").forward(req, resp); //값을 붙여서 이동!
	}

	@Override
	public void destroy() {
		System.out.println("ㅋㅋㅋ"+this.getClass().getName()+"소멸 되었습니다");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("ㅎㅎㅎ"+this.getClass().getName()+"초기화 되었습니다");
		
	}
	
	

}
