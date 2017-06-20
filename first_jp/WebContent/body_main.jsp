<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Info</title>
</head>
<body>
body_main의  name 파라미터 값: <%= request.getParameter("name") %>
<br>
body_main의  key 파라미터 값: <%= request.getParameter("key") %>
<hr>

<jsp:include page="body_sub.jsp" flush="false">
	<jsp:param name="name" value="최범균"/>
	<jsp:param name="key" value="열쇠"/>
</jsp:include>

<hr/>

</body>
</html>