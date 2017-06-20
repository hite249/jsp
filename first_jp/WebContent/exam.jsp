<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>1-100까지의 합</title>
</head>
<body>
<%

	int sum = 0;
	int maxint = 100;
	for(int i=1,max=maxint ;i<=max;i++){
		sum =sum + i;
	}
%>
1부터 100까지의 합은 <%=sum %>입니다.

</body>
</html>
