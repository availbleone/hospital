<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>医生工作站</title>
<%@ include file="/head.jsp" %>
<script type="text/javascript">
    var pathhere ="http://localhost:8888/hospitalsys_war_exploded";
//加载列表
$(function(){
	$('#tt').edatagrid({    
	    url: pathhere+'/role/selectList',
	    saveUrl: pathhere+'/role/insert',
	    updateUrl: pathhere+'/role/update',
	    loadMsg: '正在加载信息...',
		fitColumns: true,
		frozenColumns:[[{field:'ck',checkbox:true}]]
	}); 
});
//添加
function insert(){
	$("#tt").edatagrid('addRow');
}
//保存
function save(){
	$("#tt").edatagrid('saveRow');
	$("#tt").datagrid("reload");
}
//删除
function deleterole(){
	var row = $("#tt").datagrid("getSelected");
	if(row){
		$.messager.confirm('确认','您确认想要删除记录吗？',function(r){    
		    if (r){    
		    	$.post(pathhere+"/role/delete","roleid="+row.roleid,function(result){
		    		if(result==1){
		    			$("#tt").datagrid("reload");
		    			$.messager.alert('提示','操作成功！');
		    		}else{
		    			$.messager.alert('提示','操作失败！');
		    		}
		    	})  
		    }    
		});  
	}else{
		$.messager.alert('提示','必须选中一行！');
	}
}
//取消编辑
function canceledit(){
	var row = $("#tt").datagrid("getSelected");
	if(row){
		var index = $("#tt").datagrid("getRowIndex",row);
		$("#tt").datagrid('cancelEdit',index);
	}
	$("#tt").datagrid("reload");
}
</script>
</head>
<body>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">基础数据维护</a></li>
    <li><a href="#">角色管理</a></li>
    </ul>
    </div>
    
<div class="rightinfo">
    
    <div class="tools">
    
    	<ul class="toolbar">
        <li onclick="insert()"><span><img src="<%=path %>/images/t01.png" /></span>添加</li>
        <li onclick="save()"><span><img src="<%=path %>/images/ico04.png" /></span>保存</li>
        <li onclick="deleterole()"><span><img src="<%=path %>/images/t03.png" /></span>删除</li>
        <li onclick="canceledit()"><span><img src="<%=path %>/images/undo.png" /></span>取消</li>
        </ul>
    </div>
    <table id="tt" title="角色列表" idField="id"  singleSelect="true"> 
	    <thead>
	    <tr>
	    	<th field="roleid" width="100" editor="{type:'validatebox',options:{required:true}}">角色编号</th>
	    	<th field="rolename" width="100" editor="{type:'validatebox',options:{required:true}}">角色名</th>
	    	<th field="bz" width="100" editor="text">备注</th>
	    </tr>
	    </thead>
    </table>
   
</div>

</body>
</html>