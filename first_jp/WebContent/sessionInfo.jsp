<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session = "true" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%
	Date time = new Date();
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Session Info</title>
</head>
<body>
세션 ID : <%= session.getId() %><br>

<%
	time.setTime(session.getCreationTime());
%>
세션생성시간 : <%=formatter.format(time) %><br>
<%
	time.setTime(session.getLastAccessedTime());
%>
최근 접근시간 : <%= formatter.format(time) %>

</body>
</html>