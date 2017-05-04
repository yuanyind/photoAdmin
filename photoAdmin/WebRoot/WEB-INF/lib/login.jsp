<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body style="BACKGROUND-COLOR: #f4f7f9" onload="createCode()">
  <center>
    	<h1>用户登录界面</h1><br/>
    	<form action="user!checkUser.action" method="post">
    	<a href="user/register.jsp">注册新用户</a><br/>
    	用户名：<input type="text" name="user.userName" style="width: 150px;"/><br/>
    	密&nbsp;&nbsp;&nbsp;&nbsp;码：<input type="password" name="user.userPassword" style="width: 150px;"/>
    	<br/>
    	<input type="submit" value="登录"/>
    	</form>
    </center>
</body>
</html>