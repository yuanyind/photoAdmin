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
	<div class="col-sm-14 ">
	<div class="col-sm-3">
	<form action="friend!deleteGroup.action" method="post">
		<div class="pricing_box price_style1 clearfix">
                    <ul>
	   		 <li class="price_col price_col_green col_active">
                            <!--pricing item-->
                            <div class="price_item">
                                <div class="inner">
                                    
                                    <div class="price_col_head">
                                        <span class="price"><sup>我的好友</sup><span>${u.userNickname}</span></span>
                                    </div>
                                    <div class="price_col_body clearfix">
                                        <div class="price_body_inner">
                                        <c:forEach items="${fgroups}" var="fg" >
                                            <div class="price_body_top">
                                                <strong><a target="subConframe" href="friend!listGroupFriend.action?fgInfo.fgId=${fg.fgId}">${fg.fgName}</a></strong>
                                                <span>${fg.fgNumber}&nbsp;位好友&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                <c:if test="${fg.fgName!='moren'}">
                                                <input type="checkbox" name="fgs" value="${fg.fgId}"/>
                                                </c:if>
                                                </span>
                                                
                                            </div>
                                         </c:forEach>
                                           
                                        </div>
                                    </div>
                                    <div class="price_col_foot">
                                        <div class="sign_up"><a target="subConframe" href="friend/newFgroup.jsp" class="btn btn-red "><span>新建好友分组</span></a></div>
                                        <div class="sign_up"><span class="btn"><input type="submit" value="删除所选好友分组"></span></div>
                                    
                                    </div>
                                </div>
                            </div>
                            <!--/ pricing-item -->
                        </li>
                        </ul>
                        </div>
			</form>
			</div>
			<div class="col-sm-8" class="subConframe">
				<iframe onload= "this.height=subConframe.document.body.scrollHeight+20 " width=100% height=100%  name="subConframe" id="subConframe" src="friend!listAll.action"></iframe>
			</div>
	</div>
	</div>
</body>
</html>