<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp는 html로 만들어지는 페이지</title>
</head>
<!-- 자바영역 -->
<%
	String str=(String)request.getAttribute("newStr");  //값을 받음
	//서버로부터 전달된 값은 모두 Object
	//따라서 형변환(downcasting) 해야 함
	
	String param=request.getParameter("name");
%>
<body>
	<h1>getAttribute("newStr"): <%=str %></h1>
	<h1>getParameter("name"): <%=param %></h1>
	<!-- 파라미터는 한번 전송 -->
</body>
</html>