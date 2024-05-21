<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>医生工作站</title>
<%@ include file="/head.jsp" %>
<script type="text/javascript">
$(function(){	
	//顶部导航切换
	$(".nav li a").click(function(){
		$(".nav li a.selected").removeClass("selected")
		$(this).addClass("selected");
	})	
	$("#user").html(JSON.parse(sessionStorage.admin).aname);
	$("#dept").html(JSON.parse(sessionStorage.admin).dname);
})
function logoff(){
	sessionStorage.clear();
}
</script>
<style>
	#t{
	color:white;
	font-size:25px;
	text-decoration: none;
	font-weight:900;
	display: inline-block;
	margin-top: 20px;
	}
</style>
</head>
<body style="background:url(images/topbg.gif) repeat-x;">
    <div class="topleft">
    <a href="<%=path %>/index.jsp" target="_parent" id="t">&nbsp;&nbsp;&nbsp;门诊医生工作站</a>
    </div>
    <div class="topright">    
    <ul>
    <li><span><img src="images/help.png" title="帮助"  class="helpimg"/></span><a href="#">帮助</a></li>
    <li><a href="#">关于</a></li>
    <li><a href="<%=path %>/login.jsp" target="_parent" onclick="logoff()">退出</a></li>
    </ul>
     
    <div class="user">
    <span id="user"></span>
    <i id="dept"></i>
    </div>    
    
    </div>
</body>
</html>
