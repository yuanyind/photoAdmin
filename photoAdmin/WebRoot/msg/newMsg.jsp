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
</head>
<body>
   <%UserInfo user = (UserInfo)session.getAttribute("u"); %>

	
	<div class="row">
	<div class="col-sm-10 col-sm-offset-1">
	<!-- tabs -->
    <div class="tabs_framed styled">
        <div class="inner">
            <ul class="tabs clearfix active_bookmark1">
                <li class="active"><a href="#events" data-toggle="tab">添加好友请求</a></li>
                <li><a href="#reminders" data-toggle="tab">好友请求回执</a></li>
                <li><a href="#starred" data-toggle="tab">相片新评论</a></li>
            </ul>

            <div class="tab-content clearfix">
                <div class="tab-pane fade in active" id="events">
                	<table>
                	<c:forEach items="${msgs1}" var="msg1" >
						<tr>
							<td><h4><a href="user!listUserInfo.action?userInfo.userId=${u.userId}&otherUserInfo.userId=${msg1.userInfoByMsgFromUserId.userId}">${msg1.userInfoByMsgFromUserId.userNickname}</a></h4></td>
							<td><p>&nbsp;&nbsp;&nbsp;请求添加您为好友&nbsp;&nbsp;&nbsp;<font color="#d0cccc">|</font>&nbsp;&nbsp;&nbsp;</p></td>
							<td><p>验证信息：</p></td>
							<td>${msg1.msgVerify}</td>
							<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color="#d0cccc">|</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<a target="content" href="msg!agreeToAdd.action?msgInfo.msgId=${msg1.msgId}"><font color="#d0cccc">同意</font></a>&nbsp;&nbsp;&nbsp;
							<a target="content" href="msg!disagreeToAdd.action?msgInfo.msgId=${msg1.msgId}"><font color="#d0cccc">不同意</font>&nbsp;&nbsp;&nbsp;&nbsp;<font color="#d0cccc">|</font></a>
							</td>
							<td><p>&nbsp;&nbsp;&nbsp;<font color="#d0cccc">${msg1.msgCreatetime}</font></p></td>
						</tr>
					</c:forEach>
					</table>
                </div>
                <div class="tab-pane fade" id="reminders">
                	
                	<table>
                	<c:forEach items="${msgs2}" var="msg2" >
						<tr>
							<td><h4><a target="subConframe" href="user!listUserInfo.action?userInfo.userId=${u.userId}&otherUserInfo.userId=${msg2.userInfoByMsgFromUserId.userId}">${msg2.userInfoByMsgFromUserId.userNickname}</a></h4></td>
							<td><p>&nbsp;&nbsp;&nbsp;已同意添加您为好友&nbsp;&nbsp;&nbsp;<font color="#d0cccc">|</font>&nbsp;&nbsp;&nbsp;&nbsp;</p></td>
							<td><p><a target="content" href="msg!deleteMsg.action?msgInfo.msgId=${msg2.msgId}"><font color="#d0cccc">点击确认&nbsp;&nbsp;&nbsp;&nbsp;</font></a><font color="#d0cccc">|</font></p></td>
							<td><p>&nbsp;&nbsp;&nbsp;<font color="#d0cccc">${msg2.msgCreatetime}</font></p></td>
						</tr>
					</c:forEach>
					</table>
                </div>
                <div class="tab-pane fade" id="starred">
			    <c:forEach items="${notice}" var="notice" >
                    <!-- post comments -->
                <div class="comment-list clearfix" id="comments">
                    <ol>
                        <li class="comment">
                            <div class="comment-body">
                                <div class="comment-arrow"></div>
                                <div class="comment-avatar">
                                    <div class="avatar"><img src="/upload/${notice.photoInfo.PPath}"/></div>
                                </div>
                                <div class="comment-text">
                                    <div class="comment-author clearfix">
                                        <a href="user!listUserInfo.action?userInfo.userId=${u.userId}&otherUserInfo.userId=${notice.userInfoByUserFromUserId.userId}" class="link-author">${notice.userInfoByUserFromUserId.userNickname}</a> <span class="comment-date">${notice.noticeCreatetime}</span> | <a href="photo!checkComment.action?noticeId=${notice.noticeId}" class="link-reply anchor">查看</a>
                                    </div>
                                    <div class="comment-entry">
                                        ${notice.noticeContent}
                                    </div>
                                </div>
                                <div class="clear"></div>
                            </div>
                        </li>
                    </ol>
                </div>
                <!--/ post comments -->
                </c:forEach>
                </div>
            </div>
        </div>
    </div>
    <!--/ tabs -->
	</div>
	</div>
</body>
</html>