<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="bs.photoAdmin.model.UserInfo"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<!--[if lt IE 7 ]><html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]><html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]><html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]><html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--><html lang="en" class="no-js"> <!--<![endif]-->
<head>
<meta charset="utf-8">
<meta name="author" content="">
<meta name="keywords" content="">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>PhotoAdmin</title>
 <base href="<%=basePath%>">
<!-- main JS libs -->
<script src="js/libs/modernizr.min.js"></script>
<script src="js/libs/jquery-1.10.0.js"></script>
<script src="js/libs/jquery-ui.min.js"></script>
<script src="js/libs/bootstrap.min.js"></script>

<!-- Style CSS -->
<link href="css/bootstrap.css" media="screen" rel="stylesheet">
<link href="style.css" media="screen" rel="stylesheet">
<!-- styled select -->
<link rel="stylesheet" href="css/cusel.css">
<script src="js/cusel-min.js"></script>
<!-- custom input -->
<script src="js/jquery.customInput.js"></script>
<script type="text/javascript" src="js/custom.js"></script>
<!-- scripts -->
<script src="js/general.js"></script>

<!-- Include all needed stylesheets and scripts here -->





<!--[if lt IE 9]><script src="js/respond.min.js"></script><![endif]-->
<!--[if gte IE 9]>
<style type="text/css">
    .gradient {filter: none !important;}
</style>
<![endif]-->
<!-- 去除滚动条 -->
	<style>
		html { overflow-x:hidden; }
	</style> 
<!-- 去除滚动条 --> 
</head>
<body>
 <%UserInfo user = (UserInfo)session.getAttribute("u"); %>

<div class="col-sm-10">
<form action="photo!makeChangeTag.action?photoInfo.PId=${photoInfo.PId}" method="post">
        <div class="row">
           
            <div class="col-sm-4  col-sm-offset-4">
                 <h6 class="foo">选择标签:</h6>
                 <div class="col-sm-10">
                 <!-- Dropdown Menu -->
				<select class="select_styled select_styled_red" name="tagId" >
						<option value="${photoInfo.tagInfo.tagId}">${photoInfo.tagInfo.tagName}</option>
							<c:forEach items="${tags}" var="t">
								<c:if test="${photoInfo.tagInfo.tagId!=t.tagId}">
								<option value="${t.tagId}">${t.tagName}</option>
								</c:if>
							</c:forEach>
					</select>
					</div>
               	 <div class="col-sm-1">
               	<span class="btn btn-red"><input type="button" onclick="window.location.href='photo!toNewTag.action?photoInfo.PId=${photoInfo.PId}'" value="+"></span>
                </div>
                <!--/ Dropdown Menu -->
            </div>
           
        </div>
        <!--/ row -->
<div align="center"><br/><span class="btn"><input type="submit" value="确认"/></span></div>
</form>
</div>
</body>
</html>