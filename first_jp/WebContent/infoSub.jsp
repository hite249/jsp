<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String type = request.getParameter("type");
	if(type==null){
		return;
	}
%>
<br>
<table width ="100%" border="1" cellpadding ="0" cellspacing="0">
<tr>
	<td>타입</td>
	<tb><b><%=type %></b></tb>
</tr>
<tr>
	<td>특징</td>
	<td>
<%	if(type.equals("A")){ %>
	강한내구성.
<%	}else if(type.equals("B")){ %>
	뛰어난 대처 능력
<%	}else { %>
	모르겠다
<%	} %>
</td>



</table>
