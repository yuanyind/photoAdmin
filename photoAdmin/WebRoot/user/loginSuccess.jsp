<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="bs.photoAdmin.model.UserInfo"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="refresh" content="0.01;url=http://localhost:8080/photoAdmin/user!myInfoShow.action?user.userId=${u.userId}">
<title>Insert title here</title>

</head>

<body onLoad="setTimeout('delayedRedirect()',3000)">
 <%UserInfo user = (UserInfo)session.getAttribute("u"); %>

</body>
</html>