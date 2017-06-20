<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "util.Cookies" %>

<%
	Cookies cookies = new Cookies(request);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
name 쿠키 = <%= cookies.getValue("name") %> <br>
<%  if (cookies.getCookieMap().containsKey("id")) { %>
id 쿠키 = <%= cookies.getValue("id") %> <br>
<%  }  %>

adress 쿠키 = <%= cookies.getValue("adress") %> <br>
<%  if (cookies.getCookieMap().containsKey("adress")) { %>
id 쿠키 = <%= cookies.getValue("adress") %> <br>
<%  }  %>

</body>
</html>