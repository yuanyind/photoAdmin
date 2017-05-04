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

</head>
<body>
   <%UserInfo user = (UserInfo)session.getAttribute("u"); %>

  <div>
  <img src="/upload/title.png">
  </div>

  
 
<div class="content " role="main">

 <!-- row -->
        <div class="row">

            <div class="col-sm-3">
		          <!-- 用户头像 -->
					 <div class="col-sm-8 col-sm-offset-1">
					 <!-- Avatar Placeholder -->
				                <div class="widget-container widget_avatar boxed">
				                    <div class="inner">
				                        <h5>${u.userNickname}</h5>
				                        <div class="avatar">
				                      	<a target="Conframe" href="user/iconModify.jsp?user.userId=${u.userId}"><img src="/upicon/${icons.iconImage}"/></a>
				                        </div>
				                        <div align="center">
				                        <br>
				                        <a href="user!logoutUser.action?user.userId=${u.userId}"><span><font color="#d0cccc">退出登录</font></span></a>
				                        </div>
				                    </div>
				                </div>
	                 <!--/ Avatar Placeholder -->
					 </div>
		          <!-- 用户头像 -->

            </div>

            <div class="col-sm-8">
   
                <div class="row">
				  <!-- search 好友or相片 -->
					<div class="col-sm-6 col-sm-offset-1">
				      <div class="widget-container widget_search boxed">
				          <div class="inner">
				              
				                  
				                  <div class="clearfix">
				                  <form target="Conframe" method="get" id="searchform2" action="user!searchItems.action">
				                      <span class="btn"><input type="submit" id="searchsubmit2" value="搜索" /></span>
				                      <div class="input_wrap"><span class="input_icon"></span><input class="inputField" name="searchCon" id="s2" placeholder="搜索"  value="" type="text" /></div>
				                      <br>
				                      <div class="input_styled inlinelist pull-left"><div class="rowRadio"><input type="radio" name="chooseSearch" value="1" id="radio_v1"  checked><label for="radio_v1">朋友</label></div></div>
				                      <div class="input_styled inlinelist pull-left"><div class="rowRadio"><input type="radio" name="chooseSearch" value="2" id="radio_v2"><label for="radio_v2">相片</label></div></div>
		                          </form>
				                        
				                   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				                   <a target="Conframe" href="photo!showColorPhoto.action?colorNo=${0}"><img src="/upload/black.png"></a>
				                   <a target="Conframe" href="photo!showColorPhoto.action?colorNo=${1}"><img src="/upload/grey.png"></a>
				                   <a target="Conframe" href="photo!showColorPhoto.action?colorNo=${2}"><img src="/upload/white.png"></a>
				                   <a target="Conframe" href="photo!showColorPhoto.action?colorNo=${3}"><img src="/upload/gll.png"></a>
				                   <a target="Conframe" href="photo!showColorPhoto.action?colorNo=${4}"><img src="/upload/hl.png"></a>
				                   <a target="Conframe" href="photo!showColorPhoto.action?colorNo=${5}"><img src="/upload/fl.png"></a>
				                   <a target="Conframe" href="photo!showColorPhoto.action?colorNo=${6}"><img src="/upload/ql.png"></a>
				                   <a target="Conframe" href="photo!showColorPhoto.action?colorNo=${7}"><img src="/upload/sl.png"></a>
				                   <a target="Conframe" href="photo!showColorPhoto.action?colorNo=${8}"><img src="/upload/lz.png"></a>
				                   <a target="Conframe" href="photo!showColorPhoto.action?colorNo=${9}"><img src="/upload/z.png"></a>
				                   <a target="Conframe" href="photo!showColorPhoto.action?colorNo=${10}"><img src="/upload/f.png"></a>
				                   <a target="Conframe" href="photo!showColorPhoto.action?colorNo=${11}"><img src="/upload/h.png"></a>
				                   <a target="Conframe" href="photo!showColorPhoto.action?colorNo=${12}"><img src="/upload/hs.png"></a>
				                   <a target="Conframe" href="photo!showColorPhoto.action?colorNo=${13}"><img src="/upload/th.png"></a>
				                   <a target="Conframe" href="photo!showColorPhoto.action?colorNo=${14}"><img src="/upload/c.png"></a>
				                   <a target="Conframe" href="photo!showColorPhoto.action?colorNo=${15}"><img src="/upload/lh.png"></a>
				                  </div>
				                 
				             
				          </div>
				      </div>
				      </div>
			      <!--/ search widget -->
			      
			      <!-- reminder 消息 -->
			      <div class="col-sm-3 col-sm-offset-1">
			      <div class="tabs_framed styled">
                    <div class="inner">
                        <ul class="tabs clearfix active_bookmark1">
                            <li><a  href="msg!listMsgRecver.action"><sup class="note">${count}</sup>未读消息</a></li>
                        </ul>
 					</div>
 				  </div>
 				  </div>
			      <!-- / reminder 消息 -->
			      
			     </div>
             
                <!-- Website Menu -->
      <div class="dropdown-wrap">
          <ul class="dropdown clearfix">
           	  <li class="menu-level-0"><a target="Conframe" href="user!newUpdate.action?userInfo.userId=${u.userId}"><span>新鲜事</span></a></li>
              <li class="menu-level-0"><a target="Conframe" href="user!listMyInfo.action?userInfo.userId=${u.userId}"><span>我的信息</span></a></li>
              <li class="menu-level-0"><a target="Conframe" href="friend!listAllGroup.action"><span>我的好友分组</span></a></li>
              <li class="menu-level-0"><a target="Conframe" href="album!listAllAlbum.action"><span>我的相册</span></a></li>
              <li class="menu-level-0"><a target="Conframe" href="photo!chooseAlbum.action"><span>上传图片</span></a></li>
           </ul>
      </div>
        <!--/ Website Menu -->
            </div>
        </div>
        <!--/ row -->
</div>

		<div class="Conframe">
            <iframe onload= "this.height=Conframe.document.body.scrollHeight+20 " width=100% height=100%  name="Conframe" id="Conframe" src="user!newUpdate.action?user.userId=${u.userId}"></iframe>
        </div>
		
		


</body>
</html>