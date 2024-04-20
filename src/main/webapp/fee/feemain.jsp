<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="/head.jsp" %>
<script type="text/javascript">
$(function(){
	$(".easyui-datagrid").datagrid({
		url:'<%=path%>/recipeinfo/selectDsfList',
		loadMsg: '正在加载信息...',
		fitColumns: true,
		height:380,
		frozenColumns:[[{field:'ck',checkbox:true}]] 
	});
	$("#operatorid").val(JSON.parse(sessionStorage.admin).aid);
});
//处理病历号、身份证号回车事件
$(function(){
    $('#patientno').textbox('textbox').bind('keydown', function(e){
    	if (e.keyCode == 13){	// 当按下回车键时接受输入的值。
    		chaxun();
    	}
    });
    
    $('#idnumber').textbox('textbox').bind('keydown', function(e){
    	if (e.keyCode == 13){	// 当按下回车键时接受输入的值。
    		chaxun();
    	}
    });
});
//查询
function chaxun(){
	$.post('<%=path%>/recipeinfo/selectDsfList',{'pno':$("#patientno").val(),'idno':$("#idnumber").val(),'pname':$("#patientname").val()},function(result){
		$(".easyui-datagrid").datagrid("loadData",result);
		if($("#patientno").val()!=''||$("#idnumber").val()!=''||$("#patientname").val()!=''){
			$(".easyui-datagrid").datagrid("selectAll");
		}
		$("#fm").form('clear');
	})
}
//格式化性别
function sex(value,row,index){
	return ((value==0)?'女':'男')
};
//格式化项目类型
function xmtype(value,row,index){
	switch (value) {
	case 1:
		return "检查";
	case 2:
		return "检验";
	case 3:
		return "药品";
	case 4:
		return "耗材";

	default:
		break;
	}
};
//收费窗口
function sf(){
	var total=0;
	var rows = $(".easyui-datagrid").datagrid("getChecked");
	if(rows.length!=0){
		for(i=0;i<rows.length;i++){
			total+=rows[i].unitprice*rows[i].dnum
		}
		$('#dlg').dialog('open').dialog('setTitle', '收费结算');
		$('#ys').text('￥'+total);
	}else{
		$.messager.alert('提示','您还未选择费用信息！'); 
	}
	
	
};
//取消
function qx(){
	$('#dlg').dialog('close');
	$("#fm").form('clear');
	$(".easyui-datagrid").datagrid("clearChecked");
};

//计算器
$(function(){
	 $('#ss').textbox('textbox').bind('keydown', function(e){
		 if (e.keyCode == 13){	// 当按下回车键时接受输入的值。
			 var ss = $("#ss").textbox('getValue');
			 var ys = $("#ys").text().substr(1);
			 var zl;
			 if(ss==''){
				 zl = 0;
			 }else{
				 zl = (parseFloat(ss)-parseFloat(ys)).toFixed(2);
			 }
			 $("#zl").html('￥'+zl);
			 $("#sf").linkbutton({
				 selected:true
			 });
		 }
	 })
});
//收费结算
function insert(){
	var rids = [];
	var rows = $(".easyui-datagrid").datagrid("getChecked");
	$.each(rows,function(){
		rids.push(this.rid);
	});
	$.post('<%=path%>/feeinfo/insert','rids='+rids+'&aid='+$('#operatorid').val(),function(result){
		if(result==1){
			$(".easyui-datagrid").datagrid("reload");
			$("#fm").form('clear');
			$('#dlg').dialog('close');
			$.messager.alert('提示','收费成功！');  
		}else{
			$.messager.alert('提示','收费失败！');  
		}
	})
}
</script>
</head>
<body>
<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">门诊收费</a></li>
    <li><a href="#">收费管理</a></li>
    </ul>
</div>
<!--挂号信息 -->
<div style="padding-top: 20px; padding-bottom: 20px">
<input id="operatorid" name="operatorid" type="hidden">
	<form id="fm" action="" method="post">
		<table>
			<tr style="height: 40px">
				<td style="width:70px">病历号：</td>
				<td style="width:160px"><input id="patientno" name="patientno" class="easyui-textbox"></td>
				<td style="width:70px">身份证号：</td>
				<td style="width:160px"><input id="idnumber" name="idnumber" class="easyui-textbox"></td>
				<td style="width:70px">患者姓名：</td>
				<td style="width:160px"><input id="patientname" name="patientname" class="easyui-textbox"></td>
				<td colspan="2">
				<ul class="toolbar">
       				<li style="width: 80px" onclick="chaxun()"><span><img src="<%=path %>/images/search1.png"/></span>查询</li>
       				<li style="width: 80px" onclick="sf()"><span><img src="<%=path %>/images/ok.png"/></span>收费</li>
       			</ul>
				</td>
			</tr>
		</table>
	</form>
</div>
<div class="xline"></div>
<!-- 收费列表 -->
<div style="padding-top: 20px;">
	<table class="easyui-datagrid" title="患者列表">
		<thead>
			<tr>
			<th field="regid" width="15">就诊编号</th>
			<th field="patientno" width="30">病历号</th>
			<th field="idnumber" width="30">身份证号</th>
			<th field="patientname" width="20">患者姓名</th>
			<th field="sex" width="10" formatter=sex>性别</th>
			<th field="dname" width="30">项目名称</th>
			<th field="unitprice" width="15">单价（元）</th>
			<th field="dnum" width="15">开立数量</th>
			<th field="rtype" width="15" formatter=xmtype>项目类型</th>
			<th field="operatorid" width="20">看诊医生</th>
			<th field="operatetime" width="30">开单时间</th>
			</tr>
		</thead>
	</table>
</div>
<!-- 交费窗口 -->
<div id="dlg" class="easyui-dialog" style="width: 360px; height: 300px; padding: 10px 20px;overflow: hidden;"
       data-options="closed:true,buttons:'#dlg-buttons',modal:true">
      <span style="font-size: 20px">应收金额：</span><span id="ys" style="color: red;font-size: 35px">￥10.00</span>
      <div class="xline" style="margin-bottom: 10px"></div>
      <span style="font-size: 20px">实收金额：<input id="ss" class="easyui-textbox" style="width: 120px"/></span><br>
      <span style="font-size: 20px">找零：</span><span id="zl" style="color: red;font-size: 20px"></span>
      <div class="xline" style="margin-bottom: 10px"></div>
      <a id="sf" class="easyui-linkbutton c8" href="javascript:insert()">收费</a>
      <a class="easyui-linkbutton c8" href="javascript:qx()">取消</a>
</div>
</body>
</html>