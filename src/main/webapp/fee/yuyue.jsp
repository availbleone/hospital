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
		loadMsg: '正在加载信息...',
		height:350,
		fitColumns: true 
	});
	if(sessionStorage.admin){
		$("#operatorid").val(JSON.parse(sessionStorage.admin).aid);
	}
	//加载科室、医生
	$('#aid').combobox({    
	    url:"<%=path%>/admin/selectList",    
	    valueField:'aid',    
	    textField:'aname'
	});
	$('#deptid').combobox({    
	    url:"<%=path%>/dept/selectGh",    
	    valueField:'deptid',    
	    textField:'dname'
	});  
	$("#deptid").combobox({
		onChange:function(){
			$('#aid').combobox({    
			    url:'<%=path%>/admin/selectByDept?deptid='+$('#deptid').combobox('getValue'),    
			    valueField:'aid',    
			    textField:'aname'
			});
			$('#aid').combobox('textbox').bind('focus',function(){  
			    $('#aid').combobox('showPanel');  
			});
		}	
	});
			
});
//处理病历号、身份证号回车事件
$(function(){
    $('#patientno').textbox('textbox').bind('keydown', function(e){
    	if (e.keyCode == 13){	// 当按下回车键时接受输入的值。
    		$.post('<%=path%>/patientinfo/selectOne','patientno='+$('#patientno').val(),function(result){
    			if(result!=''){
    				$("#patientno").textbox('setValue', result.patientno);
	    			$("#idnumber").textbox('setValue', result.idnumber);
	    			$("#patientname").textbox('setValue', result.patientname);
	    			$("#sex").combobox('setValue', result.sex);
	    			$("#age").textbox('setValue', result.age);
	    			$('#deptid').combobox('textbox').focus();
    			}else{
    				$('#idnumber').textbox('textbox').focus();
    			}
    		})
    	}
    });
    
    $('#idnumber').textbox('textbox').bind('keydown', function(e){
    	if (e.keyCode == 13){	// 当按下回车键时接受输入的值。
    		$.post('<%=path%>/patientinfo/selectByIdnumber','idnumber='+$('#idnumber').val(),function(result){
    			if(result!=''){
	    			$("#patientno").textbox('setValue', result.patientno);
	    			$("#patientname").textbox('setValue', result.patientname);
	    			$("#sex").combobox('setValue', result.sex);
	    			$("#age").textbox('setValue', result.age);
	    			$('#deptid').combobox('textbox').focus();
    			}else{
    				$("#patientname").textbox('textbox').focus();
    			}
    		})
    	}
    });
    
    //获得光标时自动展示下拉列表内容
    $('#deptid').combobox('textbox').bind('focus',function(){  
        $('#deptid').combobox('showPanel');  
    });  
    $('#aid').combobox('textbox').bind('focus',function(){  
        $('#aid').combobox('showPanel');  
    });  
});
//保存挂号数据
function insert(){
	$("#fm").form('submit',{
		url:'<%=path%>/register/insert',
		onSubmit:function(){
			return $("#fm").form('validate');
		},
		success:function(result){
			if(result==1){
				$(".easyui-datagrid").datagrid({
					url:'<%=path%>/register/selectLast'});
				$("#fm").form('clear');
				$('#dlg').dialog('close');
				$.messager.alert('提示','挂号成功！');  
			}else{
				$.messager.alert('提示','挂号失败！');  
			}
		}
	})
}
function sf(){
	$('#dlg').dialog('open').dialog('setTitle', '收费结算');
}
function qx(){
	$('#dlg').dialog('close');
	$("#fm").form('clear');
}
//计算器
$(function(){
	 $('#ss').textbox('textbox').bind('keydown', function(e){
		 if (e.keyCode == 13){	// 当按下回车键时接受输入的值。
			 var ss = $("#ss").textbox('getValue');
			 var zl;
			 if(ss==''){
				 zl = 0;
			 }else{
				 zl = parseInt(ss)-10;
			 }
			 $("#zl").html('￥'+zl);
			 $("#sf").linkbutton({
				 selected:true
			 });
		 }
	 })
});
//格式化性别
function sex(value,row,index){
	return ((value==0)?'女':'男')
}
</script>
</head>
<body>
<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">门诊收费</a></li>
    <li><a href="#">挂号管理</a></li>
    </ul>
</div>
<!--挂号信息 -->
<div style="padding-top: 20px; padding-bottom: 20px">
	<form id="fm" action="" method="post">
		<table>
			<tr style="height: 40px">
				<td style="width:70px">病历号：</td>
				<td style="width:160px"><input id="patientno" name="patientno" class="easyui-textbox"></td>
				<td style="width:70px">身份证号：</td>
				<td style="width:160px"><input id="idnumber" name="idnumber" class="easyui-textbox" required></td>
				<td style="width:50px">姓名：</td>
				<td style="width:160px"><input id="patientname" name="patientname" class="easyui-textbox" required></td>
				<td style="width:50px">性别：</td>
				<td style="width:160px">
					<select id="sex" name="sex" class="easyui-combobox" style="width: 70px" required>
						<option value="1">男</option>
						<option value="0">女</option>
					</select>
				</td>
			</tr>
			<tr style="height: 40px">
				<td style="width:70px">年龄：</td>
				<td style="width:160px"><input id="age" name="age" class="easyui-numberbox" required></td>
				<td style="width:70px">挂号科室：</td>
				<td style="width:160px">
					<input id="deptid" name="deptid" class="easyui-combobox" required>
				</td>
				<td style="width:70px">看诊医生：</td>
				<td style="width:160px">
					<input id="aid" name="aid" class="easyui-combobox" required>
					<input id="operatorid" name="operatorid" type="hidden">
				</td>
				<td colspan="2">
				<ul class="toolbar">
       				<li style="width: 80px" onclick="sf()"><span><img src="<%=path %>/images/t01.png"/></span>挂号</li>
       			</ul>
				</td>
			</tr>
		</table>
	</form>
</div>
<div class="xline"></div>
<!-- 挂号列表 -->
<div style="padding-top: 20px;">
	<table class="easyui-datagrid" title="患者列表">
		<thead>
			<tr>
			<th field="regid" width="10">就诊编号</th>
			<th field="patientno" width="20">病历号</th>
			<th field="idnumber" width="20">身份证号</th>
			<th field="patientname" width="20">患者姓名</th>
			<th field="sex" width="20" formatter=sex>性别</th>
			<th field="age" width="20">年龄（岁）</th>
			<th field="regdate" width="30">挂号日期</th>
			<th field="dname" width="20">挂号科室</th>
			<th field="aname" width="20">看诊医生</th>
			</tr>
		</thead>
	</table>
</div>
<!-- 交费窗口 -->
<div id="dlg" class="easyui-dialog" style="width: 360px; height: 300px; padding: 10px 20px;overflow: hidden;"
       data-options="closed:true,buttons:'#dlg-buttons',modal:true">
      <span style="font-size: 20px">应收金额：</span><span style="color: red;font-size: 35px">￥10.00</span>
      <div class="xline" style="margin-bottom: 10px"></div>
      <span style="font-size: 20px">实收金额：<input id="ss" class="easyui-textbox" style="width: 120px"/></span><br>
      <span style="font-size: 20px">找零：</span><span id="zl" style="color: red;font-size: 20px"></span>
      <div class="xline" style="margin-bottom: 10px"></div>
      <a id="sf" class="easyui-linkbutton c8" href="javascript:insert()">收费</a>
      <a class="easyui-linkbutton c8" href="javascript:qx()">取消</a>
</div>
</body>
</html>