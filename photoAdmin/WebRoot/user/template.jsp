<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="GB18030"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- main JS libs -->
<script src="../js/libs/modernizr.min.js"></script>
<script src="../js/libs/jquery-1.10.0.js"></script>
<script src="../js/libs/jquery-ui.min.js"></script>
<script src="../js/libs/bootstrap.min.js"></script>

<!-- Style CSS -->
<link href="../css/bootstrap.css" media="screen" rel="stylesheet">
<link href="../style.css" media="screen" rel="stylesheet">

<!-- scripts -->
<script src="../js/general.js"></script>

<!-- Include all needed stylesheets and scripts here -->





<!--[if lt IE 9]><script src="../js/respond.min.js"></script><![endif]-->
<!--[if gte IE 9]>
<style type="text/css">
    .gradient {filter: none !important;}
</style>
<![endif]-->

	<script type="text/javascript" >
		
		function getObj(id) {
			   return document.getElementById(id);
			}		
		//���ڳ�������
		//ȫ��ʡ���ؼ���
// JavaScript Document

//������Ͻ������
var city1 = ["������","������","������","������","������","������","��̨��","ʯ��ɽ��","��ɽ��","ͨ����","˳����","��ͷ����","��ƽ��","������","������","ƽ����","������","������"]; 
//�Ϻ���Ͻ������
var city2 = ["������","¬����","�����","������","������","������","բ����","�����","������","��ɽ��","������","�ζ���","�ֶ�����","��ɽ��","�ɽ���","������","�ϻ���","������","������"]; 
//�����Ͻ������
var city3 = ["��ƽ��","�Ӷ���","������","�Ͽ���","�ӱ���","������","������","������","�����","������","������","������","������","������","������","������","������","����"]; 
//������Ͻ������
var city4 = ["������","��ɿ���","������","ɳƺ����","��������","�ϰ���","������","��ʢ��","˫����","�山��","������","������","������","������","�ϴ���","������","�ϴ���","������","�뽭��","������","�ٲ���","��ɽ��","������","ͭ����","��ƽ��","�ǿ���","�潭��","��¡��","�ᶼ��","�� ��","�� ��","������","������������","�����","��ɽ��","��Ϫ��","�ϱ���","�к���","�Ӷ���","������","������"]; 
//�ӱ�ʡ��Ҫ��������
var city5 = ["ʯ��ׯ��","��ɽ��","�ػʵ���","������","��̨��","������","�żҿ���","�е���","������","�ȷ���","��ˮ��"];
//ɽ��ʡ��Ҫ��������
var city6 = ["̫ԭ��","��ͬ��","��Ȫ��","������","������","˷����","������","�˳���","������","�ٷ���","������"];
//����ʡ��Ҫ��������
var city7 = ["������","������","��ɽ��","��˳��","��Ϫ��","������","������","Ӫ����","������","������","�̽���","������","������","��«����"];
//����ʡ��Ҫ��������
var city8 = ["������","������","��ƽ��","��Դ��","ͨ����","��ɽ��","��ԭ��","�׳���","�ӱ߳�����������"];
//����ʡ��Ҫ��������
var city9 = ["֣����","������","������","ƽ��ɽ��","������","�ױ���","������","������","�����","�����","�����","����Ͽ��","������","������","������","�ܿ���","פ�����","��Դ��"];
//����ʡ��Ҫ��������
var city10 = ["�Ͼ���","������","������","������","������","��ͨ��","���Ƹ���","������","�γ���","������","����","̩����","��Ǩ��"];
//�㽭ʡ��Ҫ��������
var city11 = ["������","������","������","������","������","������","����","������","��ɽ��","̨����","��ˮ��"];
//����ʡ��Ҫ��������
var city12 = ["�Ϸ���","�ߺ���","������","������","��ɽ��","������","ͭ����","������","��ɽ��","������","������","������","������","������","������","������","������"];
//����ʡ��Ҫ��������
var city13 = ["������","������","������","������","Ȫ����","������","��ƽ��","������","������"];
//����ʡ��Ҫ��������
var city14 = ["�ϲ���","��������","Ƽ����","�Ž���","������","ӥ̶��","������","������","�˴���","������","������"];
//ɽ��ʡ��Ҫ��������
var city15 = ["������","�ൺ��","�Ͳ���","��ׯ��","��Ӫ��","��̨��","Ϋ����","������","������","̩����","������","������","������","������","�ĳ���","������","������"];
//����ʡ��Ҫ��������
var city16 = ["�人��","��ʯ��","�差��","ʮ����","������","�˲���","������","������","Т����","�Ƹ���","������","������","��ʩ��","������","Ǳ����","������","��ũ������"];
//����ʡ��Ҫ��������
var city17 = ["��ɳ��","������","��̶��","������","������","������","������","�żҽ���","������","������","������","������","¦����","������"];
//�㶫ʡ��Ҫ��������
var city18 = ["������","������","�麣��","��ͷ��","�ع���","��ɽ��","������","տ����","ï����","������","������","÷����","��β��","��Դ��","������","��Զ��","��ݸ��","��ɽ��","������","������","�Ƹ���"];
//����ʡ��Ҫ��������
var city19 = ["������","������","��Ӣ��","��ɽ��","������","������"];
//�Ĵ�ʡ��Ҫ��������
var city20 = ["�ɶ���","�Թ���","��֦����","������","������","������","��Ԫ��","������","�ڽ���","��ɽ��","�ϳ���","�˱���","�㰲��","������","üɽ��","�Ű���","������","������","������","������","��ɽ��"];
//����ʡ��Ҫ��������
var city21 = ["������","����ˮ��","������","��˳��","ͭ�ʵ���","�Ͻڵ���","ǭ������","ǭ������","ǭ����"];
//����ʡ��Ҫ��������
var city22 = ["������","������","������","��Ϫ��","��ͨ��","������","�����","��ɽ��","˼é��","��˫������","��ɽ��","�º���","������","ŭ����","������","�ٲ���"];
//����ʡ��Ҫ��������
var city23 = ["������","ͭ����","������","������","μ����","�Ӱ���","������","������","������","������"];
//����ʡ��Ҫ��������
var city24 = ["������","��������","�����","������","��ˮ��","������","��Ҵ��","ƽ����","��Ȫ��","������","������","¤����","������","������"];
//�ຣʡ��Ҫ��������
var city25 = ["������","��������","������","������","������","������","������","������"];
//������ʡ��Ҫ��������
var city26 = ["��������","���������","������","�׸���","˫Ѽɽ��","������","������","��ľ˹��","��̨����","ĵ������","�ں���","�绯��","���˰������"];
//���ɹ���������Ҫ��������
var city27 = ["���ͺ�����","��ͷ��","�ں���","�����","ͨ����","������˹��","���ױ�����","�����׶���","�����첼��","�˰���","���ֹ�����","��������"];
//����׳����������Ҫ��������
var city28 = ["������","������","������","������","������","���Ǹ���","������","�����","������","��ɫ��","������","�ӳ���","������","������"];
//������������Ҫ��������
var city29 = ["������","��������","ɽ�ϵ���","�տ������","��������","�������","��֥����"];
//���Ļ�����������Ҫ��������
var city30 = ["������","ʯ��ɽ��","������","��ԭ��","������"];
//�½�ά�����������Ҫ��������
var city31 = ["��³ľ����","����������","��³������","���ܵ���","�������","�����յ���","��ʲ����","�������տ¶�����������","���������ɹ�������","��������������","���������ɹ�������","���������������","���ǵ���","����̩����","ʯ������","��������","ͼľ�����","�������"];
//̨��ʡ��Ҫ��������
var city32 = ["̨����","������","��¡��","̨����","̨����","������","������","̨����","������","��԰��","������","������","̨����","�û���","��Ͷ��","������","������","̨����","������","������","�����","̨����","������"];
//����ر���������ҪϽ������
var city33 = ["������","����","��������","������","����","��ˮ����","�ƴ�����","������","�ͼ�����","�뵺��","������","����","������","ɳ����","������","������","������","Ԫ����"];
//���ŵ���
var city34 = ["���ŵ���"];
//��������
var city35 = ["��������"];

//ȫ��ʡ�ᣬֱϽ�У�����������
var provinceName = ["������","�Ϻ���","�����","������","�ӱ�ʡ","ɽ��ʡ","����ʡ","����ʡ","����ʡ","����ʡ","�㽭ʡ","����ʡ","����ʡ","����ʡ","ɽ��ʡ","����ʡ","����ʡ","�㶫ʡ","����ʡ","�Ĵ�ʡ","����ʡ","����ʡ","����ʡ","����ʡ","�ຣʡ","������ʡ","���ɹ�������","����׳��������","����������","���Ļ���������","�½�ά���������","̨��ʡ","����ر�������","�����ر�������","����"];

function province() 
{ 
var e = getObj('province'); 
for (var i=0; i<provinceName.length; i++) {
e.options.add(new Option(provinceName[i],i+1)); 
 
} 
}
function cityName(n) 
{
var e = getObj('city'); 
for (var i=e.options.length; i>0; i--) e.remove(i); 
if (n == "") return;

var a = eval("city"+ n); //�õ����е������� 
for (var i=0; i<a.length; i++) e.options.add(new Option(a[i], a[i])); 
} 
function onloadprovince() 
{ 
province(); //��ʼʱ��ʡ�������˵�������  
}
		

	</script>
	<script>
	
	$("#testForm").html5Validate(function() {
		alert("ȫ��ͨ����");
		//this.submit();	
	}, {
		// novalidate: false	
	});
	// ��ѡ
	var mousedownleft, btnmarginleft, flagFollow = false;
	$(".bar_btn").bind({
		"mousedown": function(e) {
			mousedownleft = e.pageX;
			btnmarginleft = parseInt($(this).css("marginLeft")) || 0;
			flagFollow = $(this);
		}	
	});
	$(document).bind({
		"mousemove": function(e) {
			var nowmouseleft = e.pageX, finalposleft = nowmouseleft - mousedownleft + btnmarginleft;
			if (flagFollow) {
				if (finalposleft > 190) {
					finalposleft = 190;
				} else if (finalposleft < -10) {
					finalposleft = -10;
				}
				var score = Math.round((finalposleft + 10) / 40);
				flagFollow.css("marginLeft", finalposleft).attr("data-content", score);
				$("#" + flagFollow.attr("data-rel")).val(score);
			}
		},
		"mouseup": function() {
			flagFollow = false;
		}
	});
	
	</script>

</head>

<body onload="onloadprovince()">
  
  
 
   	<div class="container">
   	<div class="content " role="main">
   	 <div class="form-inner">
   		 <div class="field_text">
   		 <h1 class="text-center"  style="font-weight: normal;"><br></h1><h1 style="font-weight: normal;">&nbsp; <strong><font size="6" color="#425e8c">Sign Up Now</font></strong></h1><br/><br/>	
   		<form id="testForm" action="${pageContext.request.contextPath}/icon/icon.do" method="post" enctype="multipart/form-data"> 
   		<table>
   		<tr><td><strong>��¼��</strong>��</td><td><input class="inputtext input_middle required" type="text" name="userInfo.userName" id="dengluming" required="required"  style="height: 20px"/></td></tr>
   		<tr><td>&nbsp;</td></tr>
   		<tr><td><strong>�ǳ�</strong>��</td><td><input  type="text" name="userInfo.userNickname" id="nicheng" required="required" style="height: 20px"/></td></tr>
   		<tr><td>&nbsp;</td></tr>
   		<tr><td><strong>����</strong>��</td><td><input type="password" name="userInfo.userPassword" id="mima" required="required" style="height: 20px"/></td></tr>
   		<tr><td>&nbsp;</td></tr>
   		<tr><td><strong>����</strong>��</td> <td><input type="email" name="userInfo.userEmail" id="youxiang" required="required" style="height: 20px"/></td></tr> 
   		<tr><td>&nbsp;</td></tr>
   		<tr><td><strong>�Ա�</strong>��</td>
   		<td><select name="userInfo.userGender">
        <option value="��" selected>��</option>
        <option value="Ů">Ů</option>
        </select>
        </tr>
        <tr><td>&nbsp;</td></tr>
        <tr><td><strong>���ڳ���</strong>��</td>
   		 <td><select id="province" name="userInfo.userProvince" onchange="cityName(this.value);">
            <option value="">
             ��ѡ��ʡ��
            </option>
		</select>
		</td>
		<td><select id="city" name="userInfo.userCity">
           <option value="">
            ��ѡ�������
           </option>
		</select>     
		</td>
		</tr>
		<tr><td>&nbsp;</td></tr>
		<tr><td><strong>��ϵ�绰</strong>��</td>
		<td><input type="text" name="userInfo.userPhone"  style="height: 20px"/></td>
		</tr>
		<tr><td>&nbsp;</td></tr>
		</table>
		<table>
		<tr><td><strong>�ϴ�ͷ��</strong>��</td>
		<td><input type="file" name="image" ></td></tr>
		</table>
   	          	<input class="btn btn-inverse" style="width: 90px; height: 40px;" type="submit" value="ȷ�����" />
   </form>
   </div>
   </div>
</div>
</div>
</body>
</html>