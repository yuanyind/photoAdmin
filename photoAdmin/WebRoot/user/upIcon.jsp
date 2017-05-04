<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="bs.photoAdmin.model.UserInfo"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>上传头像</title>
</head>
<body>
	<center>
	<form action="${pageContext.request.contextPath}/icon/icon.do" enctype="multipart/form-data" method="post">
            <div>
            	<table>
          			<tr>
            			<td>
            			选择头像图片:<input type="file" name="image" ><br/>
            			</td>
          			</tr>
            		<tr><td><input type="submit" value="上传" /></td></tr>
                </table>
               </div>
        </form>
        </center>
</body>
</html>