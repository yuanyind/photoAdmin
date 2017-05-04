<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="refresh" content="3;url=http://localhost:8080/photoAdmin/login.jsp">
<title>Insert title here</title>

</head>

<body onLoad="setTimeout('delayedRedirect()',3000)">

<h2><a href="../login.jsp">3秒钟后将自动跳转到登陆页面</a> </h2>
</body>
</html>