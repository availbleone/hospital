<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="/head.jsp" %>
<script language="javascript">
	$(function(){
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
	$(window).resize(function(){  
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
    })  
});  
</script> 

<script type="text/javascript">
function login(){
	$.post('<%=path%>/admin/selectLogin',{'aid':$("#aid").val(),'apwd':$("#apwd").val()},function(result){
		if(result!=""){
			sessionStorage.admin = JSON.stringify(result);
			location='<%=path%>/index.jsp';
		}else{
			$("#msg").html("登录失败！").css("color","red");
			sessionStorage.clear();
		}
	})
}
</script>

</head>

<body style="background-color:#1c77ac; background-image:url(images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">



    <div id="mainBody">
      <div id="cloud1" class="cloud"></div>
      <div id="cloud2" class="cloud"></div>
    </div>  


<div class="logintop">    
    <span>欢迎登录区域医疗信息平台</span>    
     
    </div>
    
    <div class="loginbody">
    
    <span class="systemlogo"></span> 
       
    <div class="loginbox">
    <form id="fm" action="" method="post">
    <ul>
    <li><input id="aid" name="aid" type=text class="loginuser" value="admin" onclick="JavaScript:this.value=''"/></li>
    <li><input id="apwd" name="apwd" type="password" class="loginpwd" value="密码" onclick="JavaScript:this.value=''"/></li>
    <li><input type="button" class="loginbtn" value="预约"  onclick="location='<%=path%>/guahao.jsp'"  />
    <input type="button" class="loginbtn" value="登录"  onclick="login()"  /><label id="msg"></label></li>
    </ul>
    </form>
    
    </div>
    
    </div>
    
    
    
    <div class="loginbm">版权所有   </div>
</body>
</html>