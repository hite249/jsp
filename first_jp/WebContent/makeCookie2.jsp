<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.net.URLEncoder" %>
<%
	Cookie cookie = new Cookie("name", URLEncoder.encode("최범균","utf-8"));
	response.addCookie(cookie);
	
	Cookie cookie2 = new Cookie("adrress", URLEncoder.encode("서울 강남","utf-8"));
	response.addCookie(cookie2);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>znzltodtjd</title>
</head>
<body>
<%= cookie.getName() %>쿠키의 값 ="<%=cookie.getValue() %>"
<br>
<%= cookie2.getName() %>쿠키2의 값 ="<%=cookie2.getValue() %>"
</body>
</html>