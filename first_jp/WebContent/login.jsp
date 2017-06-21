<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<script>

var xmlHttpObj;
 
function getHttpXmlObj(){
    //해당브라우져가 익스플로러 7.0 이상이거나 파이어폭스, 크롭 등일경우
	if(window.XMLHttpRequest){
  		return new XMLHttpRequest();
 	}else if(window.ActiveXObject){
  		//해당 브라우져가 익스플로러 6.0 이하일경우
  		return new ActiveXObject("Microsoft.XMLHTTP");
 	}
	//해당 브라우져가 듣보잡일경우.. 어떤 브라우져 인진 나도 모름.
	alert("해당 브라우져가  Ajax를 지원하지 않습니다.");
}
function doGetUserList(){
	xmlHttpObj = getHttpXmlObj(); 
	var url = "./loginAction.user?";
   	var method = "get";
   	var params = "action=USERLIST"

   	var sync = true;
	
   	xmlHttpObj.onreadystatechange=function(){
   		if (xmlHttpObj.readyState==4 && xmlHttpObj.status==200){
       		document.getElementById("resultDiv").innerHTML=decodeURIComponent(xmlHttpObj.responseText);
        }
    }
    //open으로 위의 기술한 jsp명과 통신을 연결합니다. 
   	xmlHttpObj.open(method, url+params, sync);
   	xmlHttpObj.send();
	
}
function signup(){
	xmlHttpObj = getHttpXmlObj(); 
	var userid = document.getElementById("id").value;
	var userpwd = document.getElementById("pwd").value;
	var username = document.getElementById("name").value;
	var userage = document.getElementById("age").value;
   	//통신할 jsp명입니다.
   	var url = "./loginAction.user?";
   	var method = "get";
   	var params = "action=SIGNUP&id=" + encodeURIComponent(userid) + "&pwd=" + encodeURIComponent(userpwd)
   				+"&name=" + encodeURIComponent(username)+"&age=" + encodeURIComponent(userage);

   	var sync = true;
   	
   	xmlHttpObj.onreadystatechange=function(){
   		if (xmlHttpObj.readyState==4 && xmlHttpObj.status==200){
       		document.getElementById("resultDiv").innerHTML=decodeURIComponent(xmlHttpObj.responseText);
        }
    }
    //open으로 위의 기술한 jsp명과 통신을 연결합니다. 
   	xmlHttpObj.open(method, url+params, sync);
   	xmlHttpObj.send();
}
function doBoardWrite(){
	xmlHttpObj = getHttpXmlObj(); 
	var boardTitle = document.getElementById("Title").value;
	var boardContent = document.getElementById("Content").value;
	//통신할 jsp명입니다.
   	var url = "./boardAction.board?";
   	var method = "get";
   	var params = "action=BOARDWRITE&Title=" + encodeURIComponent(boardTitle) + "&Content=" + encodeURIComponent(boardContent);
   				

   	var sync = true;
   	
   	xmlHttpObj.onreadystatechange=function(){
   		if (xmlHttpObj.readyState==4 && xmlHttpObj.status==200){
       		document.getElementById("resultDiv").innerHTML=decodeURIComponent(xmlHttpObj.responseText);
        }
    }
    //open으로 위의 기술한 jsp명과 통신을 연결합니다. 
   	xmlHttpObj.open(method, url+params, sync);
   	xmlHttpObj.send();
}
function doGetBoardList(){
	xmlHttpObj = getHttpXmlObj(); 
	var url = "./boardAction.board?";
   	var method = "get";
   	var params = "action=BOARDLIST"

   	var sync = true;
	
   	xmlHttpObj.onreadystatechange=function(){
   		if (xmlHttpObj.readyState==4 && xmlHttpObj.status==200){
       		document.getElementById("resultDiv").innerHTML=decodeURIComponent(xmlHttpObj.responseText);
        }
    }
    //open으로 위의 기술한 jsp명과 통신을 연결합니다. 
   	xmlHttpObj.open(method, url+params, sync);
   	xmlHttpObj.send();
	
	
}
function doSearchBoard(){
	var searchTitle = document.getElementById('search_title').value;
	var url = "./boardAction.board?";
   	var method = "get";
   	var params = "action=BOARDLIST&search_title=" + encodeURIComponent(searchTitle);

   	var sync = true;
   	
   	xmlHttpObj.onreadystatechange=function(){
   		if (xmlHttpObj.readyState==4 && xmlHttpObj.status==200){
       		document.getElementById("resultDiv").innerHTML=decodeURIComponent(xmlHttpObj.responseText);
        }
    }
    //open으로 위의 기술한 jsp명과 통신을 연결합니다. 
   	xmlHttpObj.open(method, url+params, sync);
   	xmlHttpObj.send();
}
function doLogout(){
	xmlHttpObj = getHttpXmlObj(); 
	var url = "./loginAction.user?";
   	var method = "get";
   	var params = "action=LOGOUT"

   	var sync = true;
	
   	xmlHttpObj.onreadystatechange=function(){
   		if (xmlHttpObj.readyState==4 && xmlHttpObj.status==200){
       		document.getElementById("resultDiv").innerHTML=decodeURIComponent(xmlHttpObj.responseText);
        }
    }
    //open으로 위의 기술한 jsp명과 통신을 연결합니다. 
   	xmlHttpObj.open(method, url+params, sync);
   	xmlHttpObj.send();
}
function doBoardModify(board){
	xmlHttpObj = getHttpXmlObj(); 
	var url = "./boardAction.board?";
   	var method = "get";
   	var params = "action=BOARDMODIFY&board_num="+board_num;

   	var sync = true;
	
   	xmlHttpObj.onreadystatechange=function(){
   		if (xmlHttpObj.readyState==4 && xmlHttpObj.status==200){
       		document.getElementById("resultDiv").innerHTML=decodeURIComponent(xmlHttpObj.responseText);
        }
    }
    //open으로 위의 기술한 jsp명과 통신을 연결합니다. 
   	xmlHttpObj.open(method, url+params, sync);
   	xmlHttpObj.send();
}
function doSignout(user_num){
	xmlHttpObj = getHttpXmlObj(); 
	var url = "./loginAction.user?";
   	var method = "get";
   	var params = "action=SIGNOUT&user_num="+user_num;

   	var sync = true;
	
   	xmlHttpObj.onreadystatechange=function(){
   		if (xmlHttpObj.readyState==4 && xmlHttpObj.status==200){
       		document.getElementById("resultDiv").innerHTML=decodeURIComponent(xmlHttpObj.responseText);
        }
    }
    //open으로 위의 기술한 jsp명과 통신을 연결합니다. 
   	xmlHttpObj.open(method, url+params, sync);
   	xmlHttpObj.send();
}
function doBoardDelete(board_num, boardWriter){
	xmlHttpObj = getHttpXmlObj(); 
	var url = "./boardAction.board?";
   	var method = "get";
   	var params = "action=DELETE&board_num="+board_num;

   	var sync = true;
	
   	xmlHttpObj.onreadystatechange=function(){
   		if (xmlHttpObj.readyState==4 && xmlHttpObj.status==200){
       		document.getElementById("resultDiv").innerHTML=decodeURIComponent(xmlHttpObj.responseText);
        }
    }
    //open으로 위의 기술한 jsp명과 통신을 연결합니다. 
   	xmlHttpObj.open(method, url+params, sync);
   	xmlHttpObj.send();
}
function goWriteJsp(){
	location.href="./boardWrite.jsp";
	}

function doLogin(){
	xmlHttpObj = getHttpXmlObj(); 
	var userid = document.getElementById("id").value;
	var userpwd = document.getElementById("pwd").value;
   	//통신할 jsp명입니다.
   	var url = "./loginAction.user?";
   	var method = "get";
   	var params = "action=LOGIN&id=" + encodeURIComponent(userid) + "&pwd=" + encodeURIComponent(userpwd);

   	var sync = true;
   	
   	xmlHttpObj.onreadystatechange=function(){
   		if (xmlHttpObj.readyState==4 && xmlHttpObj.status==200){
       		document.getElementById("resultDiv").innerHTML=decodeURIComponent(xmlHttpObj.responseText);
        }
    }
    //open으로 위의 기술한 jsp명과 통신을 연결합니다. 
   	xmlHttpObj.open(method, url+params, sync);
   	xmlHttpObj.send();
}
</script>
<table border="1" cellspacing="0" cellpadding="0">
	<tr>
		<td colspan="2"> 로그인 </td> 
	</tr>
	<tr>
		<td> ID : </td>
		<td><input type="text" name="id" id="id" value="admin"/></td>
	</tr>
	<tr>
		<td> PassWord : </td>
		<td><input type="text" name="pwd" id="pwd" value="admin@@"/></td>
	</tr>
	<tr>
		<td colspan="2"><input type="button" value="Login" onclick="doLogin();"/></td>
	</tr>
</table>
<div id="resultDiv"></div>
</body>
</html>