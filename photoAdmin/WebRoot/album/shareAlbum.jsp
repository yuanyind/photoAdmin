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
<!-- Audio Player -->
<link href="css/jplayer.css" rel="stylesheet">
<script src="js/jquery.jplayer.min.js"></script>
<script src="js/jplayer.playlist.min.js"></script>




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

<div class="row">

<div class="col-sm-16 ">
	
	
	<div class="col-sm-2 col-sm-offset-1" >
	
                <div class="row">
                <div class="widget-container widget-audio boxed">
                    <div class="inner">
                 
                <div  class='title'>
                
                <c:choose>
						<c:when test="${album.ANumber==0}">
							<img width=198 height=146 src="/upload/200.png" alt='' />
						</c:when>
					</c:choose>
					
					<c:forEach items="${photos}" var="ps">
						<c:choose>
						<c:when test="${ps.albumInfo.AId==album.AId}">
							<img width=198 height=146 src="/upload/${ps.PPath}" alt='' />
						</c:when>
						</c:choose>
					</c:forEach>
                <div>
                <strong>
                	<c:choose>
							<c:when test="${album.userInfo.userId==u.userId}">我</c:when>
							<c:otherwise>${album.userInfo.userName}</c:otherwise>
					</c:choose>的相册	
				</strong>
				<span>${as.AName}</span>
				<span>${album.ADes}<strong>${album.tagInfo.tagName}</strong>
    			相片数：${album.ANumber}</span>
    			
                </div></div>
               
                </div>
                </div>
             
    </div>
                
                  <div class="row">
         <!-- 修改权限 -->
			<c:if test="${album.userInfo.userId==u.userId}">
			<div>
			<form action="friend!ifModifyAlbum.action?ad=${ad}" method="post">
				<select class="select_styled select_styled_red" name="ifModify" >
						<option value="${album.albumIfsee}">
							<c:choose>
							<c:when test="${album.albumIfsee==true}">
							共享好友共同修改
							</c:when>
							<c:otherwise>
							仅我自己修改
							</c:otherwise>
							</c:choose>
						</option>
						<c:choose>
							<c:when test="${album.albumIfsee==true}">
							<option value="false">仅我自己修改</option>
							</c:when>
							<c:otherwise>
							<option value="true">共享好友共同修改</option>
							</c:otherwise>
						</c:choose>
				</select>
				<div align="center"><br/><input class="btn" type="submit" value="确认修改共享权限"/></div>
					</form>
			</div>
			</c:if>
	<!-- /修改权限 -->
         </div>     
	</div>

	
	
	<div class="col-sm-8 col-sm-offset-1">
	<form action="album!shareAlbum.action?albumInfo.AId=${ad}" method="post">
	 
     <!-- Widget Schedule -->
     <c:forEach items="${fgroups}" var="fg">
 	 <div class="row">
 	 <div class="col-sm-16">
 	 <c:if test="${fg.fgNumber!=0}">
     <h6 class="widget-title"><font color="#ffffff">${fg.fgName}</font></h6>
     <!-- 好友 -->
     <c:forEach items="${fs}" var="fs">
     <c:if test="${fs.fgroupInfo.fgId == fg.fgId}">
     <div class="col-sm-4">
    <div class="widget-container widget-schedule clearfix">
     <div class="carousel">
            <ul id="schedule">
                <li class="schedule-item clearfix">
                    <div class="schedule-left">
                        <div class="schedule-name">${fs.userInfoByOtheruserId.userNickname}</div>
                        <div class="schedule-date">${fs.userInfoByOtheruserId.userGender}</div>
                        <div class="schedule-date"><script type="text/javascript">
		            var n=${fs.userInfoByOtheruserId.userProvince}; 
		            var provinceName = ["北京市","上海市","天津市","重庆市","河北省","山西省","辽宁省","吉林省","河南省","江苏省","浙江省","安徽省","福建省","江西省","山东省","湖北省","湖南省","广东省","海南省","四川省","贵州省","云南省","陕西省","甘肃省","青海省","黑龙江省","内蒙古自治区","广西壮族自治区","西藏自治区","宁夏回族自治区","新疆维吾尔自治区","台湾省","香港特别行政区","澳门特别行政区","其它"];
		             document.write(provinceName[n-1]);
		             </script>
		             &nbsp;${fs.userInfoByOtheruserId.userCity} </div>
		            <div class="schedule-date"><input type="checkbox" name="uds" value="${fs.userInfoByOtheruserId.userId}">共享相册</div>
                    </div>
                    
                    <div class="schedule-right">
                        <div class="schedule-avatar">
                       
                        <c:forEach items="${icons}" var="icons">
						<c:if test="${icons.userInfo.userId==fs.userInfoByOtheruserId.userId}">
							<img width=120 height=123 src="/upicon/${icons.iconImage}"/>
						</c:if>
						</c:forEach>
                       </div>
                        <div class="schedule-links" style="text-align: center;">
                            <a class="schedule-details" href="user!listUserInfo.action?userInfo.userId=${u.userId}&otherUserInfo.userId=${fs.userInfoByOtheruserId.userId}"><i class="icon-small-info"></i>详细信息</a>
                            <i class="icon-small-star"></i>我的好友
                        </div>
                    </div>
                </li>
            </ul>
        </div>
	</div>
	</div>
	</c:if>
 	</c:forEach>
 	<br/>
 	</c:if>
 	</div>
 	</div>
 	</c:forEach>
 	<!-- /好友 -->
 	<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class="btn" type="submit" value="共享相册"/></div>
 	</form>
 	</div>
 	
 	
	
	</div>
	
	</div>
</body>
</html>