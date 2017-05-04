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
	
	<!-- row -->

	
        <div class="row">
			<!-- search 好友or相片 -->
					<div class="col-sm-4 col-sm-offset-1">
				      <div class="widget-container widget_search boxed">
				          <div class="inner">
				              <form target="Conframe" method="get" id="searchform2" action="album!addAlbum.action">
				                  
				                  <div class="clearfix">
				                  		<input type="hidden" name="albumInfo.userInfo.userId" value="${u.userId}"/>
				                     <div class="col-sm-10">
				                     <div class="col-sm-12">
				                      <div class="input_wrap"><input class="inputField" name="albumInfo.AName" id="s2" placeholder="相册名"  value="" type="text" /></div>
				                      </div>
				                      <div class="col-sm-12">
				                      <div class="input_wrap">&nbsp;&nbsp;&nbsp;&nbsp;<input class="inputField" name="albumInfo.ADes" id="s2" placeholder="相册描述"  value="" type="text" /></div>
				                  		</div>
				                  		</div>
				                  		
				                  		<div class="col-sm-10">
				           				<br/>       		
				                  		<div class="col-sm-9">
				           
				                  		<select class="select_styled select_styled_red" name="tagId" >
											<c:forEach items="${tags}" var="t">
												<option value="${t.tagId}">${t.tagName}</option>
											</c:forEach>
										</select>
				                  		</div>
				                  		<div class="col-sm-1 col-sm-offset-1">
				                  		<span class="btn btn-red"><input type="button" onclick="window.location.href='tag/newTag.jsp'" value="+"></span>
				                  		</div>
				                  		</div>
				                  		
				                  		<div class="col-sm-3">
				                  			 <span class="btn"><input type="submit" id="searchsubmit2" value="创建" /></span>
				                 		</div>
				                  </div>
				                
				              </form>
				              <br/>
				          </div>
				      </div>
				      </div>
			      <!--/ search widget -->
           
        </div>
        <!--/ row -->
      
</body>
</html>