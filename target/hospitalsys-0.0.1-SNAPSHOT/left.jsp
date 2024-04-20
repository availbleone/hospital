<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/head.jsp" %>
<script type="text/javascript">
$(function(){	
	//导航切换
	$(".menuson li").click(function(){
		$(".menuson li.active").removeClass("active")
		$(this).addClass("active");
	});
	
	$('.title').click(function(){
		var $ul = $(this).next('ul');
		$('dd').find('ul').slideUp();
		if($ul.is(':visible')){
			$(this).next('ul').slideUp();
		}else{
			$(this).next('ul').slideDown();
		}
	});
})	
</script>


</head>

<body style="background:#f0f9fd;">
	<div class="lefttop"><span></span>主菜单</div>
    
    <dl class="leftmenu">
        
    <dd>
    <div class="title">
    <span><img src="<%=path %>/images/leftico01.png" /></span>基础数据维护
    </div>
    	<ul class="menuson">
        <li class="active"><cite></cite><a href="<%=path %>/basedata/deptmain.jsp" target="rightFrame">科室维护</a><i></i></li>
        <li><cite></cite><a href="<%=path %>/basedata/rolemain.jsp" target="rightFrame">角色管理</a><i></i></li>
        <li><cite></cite><a href="<%=path %>/basedata/adminmain.jsp" target="rightFrame">人员管理</a><i></i></li>
        <li><cite></cite><a href="<%=path %>/basedata/clinicitem.jsp" target="rightFrame">收费项目维护</a><i></i></li>
        <li><cite></cite><a href="<%=path %>/basedata/druginfo.jsp" target="rightFrame">药品耗材维护</a><i></i></li>
       <!--  <li><cite></cite><a href="index.html" target="rightFrame">首页模版</a><i></i></li>
        <li><cite></cite><a href="right.html" target="rightFrame">数据列表</a><i></i></li> -->
        </ul>    
    </dd>
    
    <dd>
    <div class="title">
    <span><img src="images/leftico02.png" /></span>门诊收费</div>
    <ul class="menuson">
        <li><cite></cite><a href="<%=path %>/fee/register.jsp" target="rightFrame">挂号</a><i></i></li>
        <li><cite></cite><a href="<%=path %>/fee/feemain.jsp" target="rightFrame">收费</a><i></i></li>
        </ul>     
    </dd>   
        
    <dd><div class="title"><span><img src="images/leftico03.png" /></span>医生工作站</div>
    <ul class="menuson">
        <li><cite></cite><a href="<%=path %>/doctor/doctormain.jsp" target="rightFrame">医生工作站</a><i></i></li>
    </ul>    
    </dd>  
    
    <dd><div class="title"><span><img src="images/leftico01.png" /></span>药房管理</div>
    <ul class="menuson">
        <li><cite></cite><a href="<%=path %>/drugstore/drugmain.jsp" target="rightFrame">发药窗口</a><i></i></li>
    </ul>    
    </dd>  
    
    </dl>
</body>
</html>
