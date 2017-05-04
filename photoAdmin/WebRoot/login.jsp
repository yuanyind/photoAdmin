<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="zh-cn">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

	 <base href="<%=basePath%>">
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  	
  	 <script language="javascript" type="text/javascript">
    
     var code ; //在全局 定义验证码
     function createCode()
     { 
       code = "";
       var codeLength = 4;//验证码的长度
       var checkCode = document.getElementById("checkCode");
       var selectChar = new Array(0,1,2,3,4,5,6,7,8,9);//所有候选组成验证码的字符，当然也可以用中文的
        
       for(var i=0;i<codeLength;i++)
       {
      
        
       var charIndex = Math.floor(Math.random()*10);
       code +=selectChar[charIndex];
       
       
       }
//       alert(code);
       if(checkCode)
       {
         checkCode.className="code";
         checkCode.value = code;
       }
       
     }
     
      function validate ()
     {
       var inputCode = document.getElementById("input1").value;
       if(inputCode.length <=0)
       {
           alert("请输入验证码！");
           return false;
       }
       else if(inputCode != code )
       {
          alert("验证码输入错误！");
          createCode();//刷新验证码
          return false;
       }
       else{
       		return true;
       }
     }
       
    </script>
  	
<title>登陆</title>
</head>

<body style="background:url(/upload/index-bg.png) no-repeat" onload="createCode()">
	<br/><br/><br/><br/><br/><br/>
	<div class="container">
		<div class="col-sm-6 col-md-4 col-lg-3">
    	<h1 class="text-center">Sign In</h1><br/>
    	<form action="user!checkUser.action" method="post">
	    	<div class="jumbotron">
	    	
	    	<a href="user/iconRegister.jsp">Sign Up Now!</a><br/>
	    	<br/>
	    	
	    	<div class=to><SPAN class=tol></SPAN></div>
				<div class=in>
				<dl>
				  <dt>用户名</dt>
				  <dd><input style="width: 150px" type=text name="user.userName"></dd>
				  <dd class=e></dd></dl>
				<dl>
				  <dt>密　码</dt>
				  <dd><input style="width: 150px" type=password name="user.userPassword"></dd>
				  <dd class=e></dd></dl>
				<dl>
				<dt>验证码</dt>
				  <dd><input style="width: 80px" type=text id="input1"></dd>
				  <dd style="PADDING-TOP: 5px">
				  <input type="text" onclick="createCode()" readonly id="checkCode" class="unchanged" style="width: 50px;"/></dd>
				  <dd class=e></dd></dl>
				  </div>
				<div class=su>
				<span><input class="btn btn-lg btn-success" type="submit" value="登录" onclick="return validate();"/></span>
				</div>
	    	</div>
    	</form>
    	</div>
        <div>
  		 <img src="/upload/index.png"/>
    	</div>
	</div>
    
</body>
</html>