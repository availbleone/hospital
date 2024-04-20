<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="/head.jsp" %>
<script type="text/javascript">
var count = 0;
$(function(){
	//待发药患者列表
	$("#tt").datagrid({
		url:'<%=path%>/feeinfo/selectDfyList',
		height:448,
		border:false,
		loadMsg: '正在加载信息...',
		fitColumns: true,
		frozenColumns:[[{field:'ck',checkbox:true}]],
		toolbar: [{
			text:'发药',
			iconCls: 'icon-ok',
			handler: senddrug
		}],
		onLoadSuccess:function(data){
			$("#tt").datagrid('checkRow',0);
			count = $("#tt").datagrid('getRows').length;
			wsRefresh();
		},
		onSelect:function(index,row){
			$("#pno").html(row.patientno);
			$("#pname").html(row.patientname);
			(row.sex==0)?$("#sex").html('女'):$("#sex").html('男');
			$("#age").html(row.age);
			$("#idno").html(row.idnumber);
			(row.diagnose==undefined)?$("#diagnose").html('无'):$("#diagnose").html(row.diagnose);
			$.post('<%=path%>/recipeinfo/selectByFid','fid='+row.fid,function(result){
				$("#dglist").datagrid('loadData',result)
			})
		}
	});
	//药品列表
	$("#dglist").datagrid({
		url:'',
		loadMsg: '正在加载信息...',
		fitColumns: true
	});
});
//发药功能
function senddrug(){
	var row = $("#tt").datagrid('getSelected');
	if(row==null){
		$.messager.alert('提示','您还未选择发药信息！');
	}else{
		$.post('<%=path%>/feeinfo/sendDrug','fid='+row.fid,function(result){
			if(result==1){
				$.messager.alert('提示','发药成功！');
				$("#tt").datagrid('reload');
				count = $("#tt").datagrid('getRows').length;
			}else{
				$.messager.alert('提示','库存不足，发药失败！');
			}
		})
	}
}
//格式化性别
function sex(value,row,index){
	return ((value==0)?'女':'男')
};

//有新药品收费信息，推送刷新药品列表

//验证浏览器是否支持WebSocket协议  
if(!window.WebSocket){
    alert("你的浏览器不支持webscocket!");  
}  
var ws;  
function wsRefresh(){  
    //创建websocket对象
    ws = new WebSocket("ws://localhost:8080/hospital/RefreshDrug/"+count);  
    //回调函数：打开WebSocket  
    ws.onopen = function(event){  
        //alert("websocket连接成功！");
    }
    //回调函数：收到服务器端返回消息  
    ws.onmessage = function(event){ 
    	if(count!=event.data){
    		$("#tt").datagrid('reload');
    	}
    	
    }  
    //回调函数：发生错误  
    ws.onerror = function(event){}  
    //回调函数：关闭WebSocket  
    ws.onclose = function(event){}   
} 

</script>
</head>
<body>
<div class="place">
    <span>位置：</span>
    <ul class="placeul">
	    <li><a href="#">药房</a></li>
	    <li><a href="#">发药窗口</a></li>
    </ul>
</div>
    
<div class="mainbox">
    
<div class="mainleft">
<form id="fm" action="" method="post">
	  	<div id="tab1" class="mytabson" style="height: 485px; width: 95%">
	    	<div class="formtitle" style="margin-left: 8px;width: 98%"><span>患者信息</span></div>
		    <div class="toolsli">
			    <table style="margin-left: 8px">
			    	<tr style="height: 35px">
			    		<th style="width: 60px" align="right">病历号：</th>
			    		<td style="width: 150px"><span id="pno"></span></td>
			    		<th style="width: 40px">姓名：</th>
			    		<td style="width: 100px"><span id="pname"></span></td>
			    		<th style="width: 40px">性别：</th>
			    		<td style="width: 50px"><span id="sex"></span></td>
			    		<th style="width: 40px">年龄：</th>
			    		<td style="width: 50px"><lable id="age"></lable>岁</td>
			    		<th style="width: 60px">身份证号：</th>
			    		<td style="width: 150px"><span id="idno"></span></td>
			    	</tr>
			    	<tr>
			    		<th>诊断：</th>
			    		<td colspan="9" style="color: red"><lable id="diagnose"></lable></td>
			    	</tr>
			    </table>
		    </div>
		    
		    <div class="formtitle" style="margin-left: 8px;width: 98%"><span>药品列表</span></div>
			<div style="margin-left: 8px;width: 98%">
				<table id="dglist"> 
			    	<thead>
				    <tr>
				    	<th field="did" width="15">药品编号</th>
				    	<th data-options="field:'dname',width:40,styler:function(){return 'color:blue;font-weight: bolder;'}">药品名称</th>
				    	<th field="guige" width="20">规格</th>
				    	<th field="minunit" width="25">生产厂家</th>
				    	<th field="unitprice" width="15">单价（元 ）</th>
				    	<th data-options="field:'dnum',width:10,styler:function(){return 'color:red;font-weight: bolder;'}">数量</th>
				    	<th field="operatorid" width="15">开单医生</th>
				    	<th field="operatetime" width="35">开立时间 </th>
				    </tr>
				    </thead>
			    </table> 
		    </div>
	    </div> 
</form>
</div>
    
<div class="mainright">
    <div class="dflist"  style="height: 485px">
    <div class="listtitle">
    	发药列表&nbsp;&nbsp;&nbsp;<input type="text" id="patientno" name="patientno" placeholder="输入病历号或身份证号" style="height: 25px">
    	<a href="#" class="more1">查询</a>
    </div>    
    <table id="tt"singleSelect="true"> 
    	<thead>
	    <tr>
	    	<th field="patientno" width="55">病历号</th>
	    	<th field="patientname" width="30">姓名</th>
	    	<th field="sex" width="15" formatter=sex >性别</th>
	    	<th field="age" width="15">年龄</th>
	    </tr>
	    </thead>
    </table> 
    </div>
</div>
    <!--mainright end-->
    
</div>

</body>
</html>