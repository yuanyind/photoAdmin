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

<title>相片信息</title>
</head>
<body>
	<div class="row">
	<div class="col-sm-10 col-sm-offset-1">
	
	<!--相片部分  -->
	<div class="row">
	<div class="col-sm-3">	
		<div class="widget-container widget-audio boxed">	
		   <div class="inner">
		  <div  class='title'>
			<img width=220 height=146 src="/upload/${photoInfo.PPath}"/>
		  </div>
		  </div>
		</div>
	</div>
	<div class="col-sm-6 ">
		相册名称:${photoInfo.albumInfo.AName}<font color="#d0cccc">&nbsp;&nbsp;${photoInfo.userInfo.userNickname}的相册&nbsp;&nbsp;</font>
		<c:choose>
		<c:when test="${photoInfo.userInfo.userId==u.userId}">
		<a href="photo!changeAlbum.action?photoInfo.PId=${photoInfo.PId}">修改</a>
		</c:when >
		</c:choose>
		<br><br>
		相片描述:
				<c:choose>
					<c:when test="${photoInfo.PDes == null}">
					<c:choose>
						<c:when test="${photoInfo.userInfo.userId==u.userId}">
							<form action="photo!addPhotoDes.action">
							<input type="hidden" name="photoInfo.PId" value="${photoInfo.PId}"/>
							<textarea name="photoInfo.PDes"/></textarea>
							<span class="btn"><input type="submit" value="确认" /></span>
							</form>
						</c:when >
						<c:when test="${photoInfo.PIfmodify==true}">
						<c:if test="${ifOwner==1}">
							<form action="photo!addPhotoDes.action">
							<input type="hidden" name="photoInfo.PId" value="${photoInfo.PId}"/>
							<textarea name="photoInfo.PDes"/></textarea>
							<span class="btn"><input type="submit" value="确认" /></span>
							</form>
						</c:if>
						</c:when>
						</c:choose>
					</c:when>
					<c:otherwise>
						${photoInfo.PDes}	<br>
					</c:otherwise>
				</c:choose>
		<br>
		
		相片标签：${photoInfo.tagInfo.tagName}
		<c:choose>
		<c:when test="${photoInfo.userInfo.userId==u.userId}">
		<a href="photo!changeTag.action?photoInfo.PId=${photoInfo.PId}">修改</a>
		</c:when >
		<c:when test="${photoInfo.PIfmodify==true}">
		<c:if test="${ifOwner==1}">
		<a href="photo!changeTag.action?photoInfo.PId=${photoInfo.PId}">修改</a>
		</c:if>
		</c:when>
		</c:choose>
		
		<br>
		<br>
		<!-- 修改权限 -->
	<c:if test="${photoInfo.userInfo.userId==u.userId}">
	<div class="col-sm-6">
	<form action="photo!ifModifyToge.action?PId=${photoInfo.PId}" method="post">
	<select name="ifModify" >
				<option value="${photoInfo.PIfmodify}">
					<c:choose>
					<c:when test="${photoInfo.PIfmodify==true}">
					共享好友共同修改
					</c:when>
					<c:otherwise>
					仅我自己修改
					</c:otherwise>
					</c:choose>
				</option>
				<c:choose>
				<c:when test="${photoInfo.PIfmodify==true}">
				<option value="false">仅我自己修改</option>
				</c:when>
				<c:otherwise>
				<option value="true">共享好友共同修改</option>
				</c:otherwise>
				</c:choose>
			</select>
			<span class="btn"><input type="submit" value="确认"/></span>
			</form>
	</div>
	</c:if>
	<!-- /修改权限 -->
		</div>
		</div>
	<!-- /相片部分 -->
	
	<br><br><br>
	<div class="row">
	<form action="photo!addComment.action">
	<input type="hidden" name="photoInfo.PId" value="${photoInfo.PId}"/>
	<br>
	<div class="col-sm-10">
	<c:forEach items="${comments}" var="cs">
	
      <!-- post comments -->
      <div class="comment-list clearfix" id="comments">
          <ol>
              <li class="comment">
                  <div class="comment-body">
                      <div class="comment-arrow"></div>
                      <div class="comment-avatar">
                      <c:forEach items="${icons}" var="icons">
                      	<c:if test="${cs.userInfoByCommentFromUserid.userId==icons.userInfo.userId}">
                          <div class="avatar"><img src="/upicon/${icons.iconImage}" alt="" /></div>
                        </c:if>
                       </c:forEach>
                      </div>
                      <div class="comment-text">
                          <div class="comment-author clearfix">
                              <a class="link-author">${cs.userInfoByCommentFromUserid.userNickname}
                              <c:if test="${cs.userInfoByCommentToUserId !=null}">
								<font color="#d0cccc">&nbsp;&nbsp;@&nbsp;&nbsp;</font>${cs.userInfoByCommentToUserId.userNickname}</c:if></a>
								<span class="comment-date">${cs.commentCreateTime}</span> 
                          </div>
                          
                          <div class="comment-entry">
                              ${cs.commentContent}
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
	
	
	<div class="row">
	<div class="col-sm-6">
	<table>
	<tr>
		<td>@
			<select name="otherFid" >
				<option value="">对所有人</option>
				<c:forEach items="${fs}" var="fs">
					<option value="${fs.userInfoByOtheruserId.userId}">${fs.userInfoByOtheruserId.userNickname}</option>
				</c:forEach>
			</select>
		</td>
	</tr>
	<tr>
		<td><textarea name="commentInfo.commentContent"/></textarea></td>
	</tr>
	<tr><td><div class="btn"><input  type="submit" value="回复"/></div></td></tr>
	</table>
	</div>
	</div>
	</form>
	</div>
	</div>
	</div>
</body>
</html>