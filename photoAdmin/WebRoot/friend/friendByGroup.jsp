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
<link href="stylefunky.css" media="screen" rel="stylesheet">
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

	<!-- 显示好友列表 -->
	<div class="row">
	<!-- Widget Profile -->
		<c:forEach items="${friends}" var="gf" >
			<div class="col-sm-3">
          <div class="tabs-framed tabs-framed-right boxed widget-container widget-profile">
              <div class="tab-content">
                 <div class="tab-pane fade in active" id="profile2">
                      <div class="profile-image">
                      	<c:forEach items="${icons}" var="icons">
                      	<c:choose>
                      	  <c:when test="${gf.userInfoByOtheruserId.userId==icons.userInfo.userId}">
                          <img width=150 height=150 src="/upicon/${icons.iconImage}" alt="" />
                          </c:when>
                        </c:choose>
                        </c:forEach>
                        
                      </div>
                      <div class="bottom">
                          <div class="profile-desc">
                              <a target="Conframe" href="user!listUserInfo.action?userInfo.userId=${u.userId}&otherUserInfo.userId=${gf.userInfoByOtheruserId.userId}" class="profile-title">${gf.userInfoByOtheruserId.userNickname}</a>
                              <a href="friend!chooseFgroup.action?fid=${gf.FId}"><span class="profile-subtitle">${gf.fgroupInfo.fgName}</span></a>
                          </div>
                          
                      </div>
                  </div>
              </div>
          </div>
      </div>
		</c:forEach>
	
	</div>
	
	
	
</body>
</html>