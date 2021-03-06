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
 <body>
 	<div class="row">
 	<div class="col-sm-14 col-sm-offset-1 ">
    	<c:forEach items="${photos}" var="ps" >
    		
                <!-- post comments -->
                <div class="col-sm-5">
                <div class="comment-list clearfix" id="comments">
                    <ol>
                        <li class="comment">
                            <div class="comment-body">
                                
                                <div class="comment-avatar">
                                <div class="avatar">
                                	<c:forEach items="${icons}" var="icons">
										<c:if test="${icons.userInfo.userId==ps.userInfo.userId}">
											<img src="/upicon/${icons.iconImage}"/>
										</c:if>
									</c:forEach>
									</div>
               
                                </div>
                                <div class="comment-text">
                                    <div class="comment-author clearfix">
                						<a target="Conframe" href="user!listUserInfo.action?userInfo.userId=${u.userId}&otherUserInfo.userId=${ps.userInfo.userId}" class="link-author">${ps.userInfo.userNickname}</a> <span class="comment-date">${ps.PCreatetime}</span> | <a target="Conframe" href="photo!showPhotoInfo.action?photoInfo.PId=${ps.PId}" class="link-reply anchor">Reply</a>
                                    </div>
                                    <div class="comment-entry">
                                        更新了相册
                                        <b><a target="Conframe" href="photo!showPhotos.action?albumId=${ps.albumInfo.AId}"><font size=4 color=000000>${ps.albumInfo.AName}</font></a></b>
                                    </div>
                                     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                 <div class="tabs_framed styled">
                    <div class="inner">
                        <div class="tab-content clearfix">
                            <div class="tab-pane fade in active" id="events">
                                <div class="tab_image"><a target="Conframe" href="photo!showPhotoInfo.action?photoInfo.PId=${ps.PId}"><img src="/upload/${ps.PPath}" alt="" /></a></div>
                               
                            </div>
                        </div>
                    </div>
                </div>

                                </div>
                                <div class="clear"></div>
                            </div>
                        </li>
                    </ol>
                </div>
                </div>
                <!--/ post comments -->
    	</c:forEach>
    	   </div>
		</div>
 
 </body>