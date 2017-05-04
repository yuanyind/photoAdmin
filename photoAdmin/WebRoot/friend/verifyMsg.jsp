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
<form action="friend!verifyMsg.action?otherFid=${otherFid}" method="post">
<div class="row">
            <div class="col-sm-3 col-sm-offset-4">
                <h6 class="foo">选择好友分组</h6>
                 <!-- Dropdown Menu -->
					<select class="select_styled select_styled_red" name="fgInfo.fgId" >
							<c:forEach items="${fgroups}" var="f">
							<option value="${f.fgId}">${f.fgName}</option>
						</c:forEach>
					</select>
                <!--/ Dropdown Menu -->
                
                  <div class="field_text field_textarea">
                      <div id="edit_buttons" class="edit_buttons"></div>
                      <label for="styled_message" class="label_title">验证消息:</label>
                      <textarea cols="30" rows="10" name="verifyMsg" id="styled_message" class="textarea textarea_middle"></textarea>
                  </div>
                  <div align="center"><br/><span class="btn"><input  type="submit" value="发送"/></span>
    			  <span class="btn"><input type="reset" value="取消"/></span></div>
            </div>
            
        </div>
        <!--/ row -->

</form>
</body>
</html>