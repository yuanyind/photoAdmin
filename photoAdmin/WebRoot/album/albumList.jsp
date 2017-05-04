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
<!-- /去除滚动条 -->
<!-- Audio Player -->
<link href="css/jplayer.css" rel="stylesheet">
<script src="js/jquery.jplayer.min.js"></script>
<script src="js/jplayer.playlist.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>相册列表</title>
</head>
<body>
   <%UserInfo user = (UserInfo)session.getAttribute("u"); %>
  <div>
	
	<form action="album!deleteAlbum.action" method="post">
		 <div class="row">
            <div class="col-sm-10 col-sm-offset-1">
		<c:forEach items="${albums}" var="as" >
		 <!-- Widget album -->
              <div class="col-sm-3 ">
                <div class="widget-container widget-audio boxed">
                    <div class="inner">
                 
                <div  class='title'>
                <c:choose>
						<c:when test="${as.ANumber==0}">
							<img width=212 height=146 src="/upload/200.png" alt='' />
						</c:when>
					</c:choose>
					
					<c:forEach items="${photos}" var="ps">
						<c:choose>
						<c:when test="${ps.albumInfo.AId==as.AId}">
							<img width=212 height=146 src="/upload/${ps.PPath}" alt='' />
						</c:when>
						</c:choose>
					</c:forEach>
                <div>
                <strong>
                	<c:choose>
							<c:when test="${as.userInfo.userId==u.userId}">我</c:when>
							<c:otherwise><a href="user!listUserInfo.action?otherUserInfo.userId=${as.userInfo.userId}">${as.userInfo.userNickname}</a></c:otherwise>
					</c:choose>的相册	
				</strong>
				<span><input type="checkbox" name="as" value="${as.AId}"/><a href="photo!showPhotos.action?albumId=${as.AId}"><font color="#ffffff">${as.AName}</font>	</a></span>
				<span>${as.ADes}<strong>${as.tagInfo.tagName}</strong>
    			相片数：${as.ANumber}</span>
    			<span><a href="friend!getShareFriends.action?ad=${as.AId}">共享相册</a></span>
                </div></div>
                </div>
                </div>
                
		</div>
		</c:forEach>
		</div>
		
		</div>
		<div class="col-sm-10 col-sm-offset-1">
		<span class="btn"><input  type="button" value="新建相册" onclick="window.location.href='album!chooseTag.action'"/></span>
		<span class="btn"><input type="submit" value="删除所选相册" /></span>
		</div>
		</form>
	</div>
	
	

</body>
</html>