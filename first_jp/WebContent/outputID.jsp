<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%! public String getIdNPwd(String id, String pwd){
		String result="";
		for(int i=1;i<=10;i++){
			result +=i+"."+id+","+pwd+"<br/>";
		}
		return result;
		}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%

String id = request.getParameter("id");
String pwd = request.getParameter("pwd");

String result = getIdNPwd(id,pwd);

%>
<%=result %>

</body>
</html>