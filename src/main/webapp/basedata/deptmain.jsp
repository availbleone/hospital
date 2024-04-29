<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>医生工作站</title>
<%@ include file="/head.jsp" %>
<script type="text/javascript">
//加载列表
var data = [{dtype: 1,type: '诊室'},{dtype: 2,type: '其他'}];
var pathhere ="http://localhost:8888/hospitalsys_war_exploded";
$(function(){
	$('#tt').edatagrid({    
	    url: pathhere+'/dept/selectList',
	    saveUrl: pathhere+'/dept/insert',
	    updateUrl: pathhere+'/dept/update',
	    loadMsg: '正在加载信息...',
		fitColumns: true,
		frozenColumns:[[{field:'ck',checkbox:true}]],
		columns : [[{
        	field : 'deptid',
            title : '科室编号',
            width : 50,
            editor : {type:'validatebox',options:{required:true}}
        },{
        	field : 'dname',
            title : '科室名称',
            width : 50,
            editor : {type:'validatebox',options:{required:true}}
        },{
            field : 'dtype',
            title : '科室类型',
            width : 50,
            editor : {
                type : 'combobox',
                options : {
                    valueField : "dtype",
                    textField : "type",
                    data : data
                }
            },
            formatter : function (value, row, index) {
                for (var i = 0; i < data.length; i++) {
                    if (data[i].dtype == value) {
                        return data[i].type;
                    }
                }
                return row["dtype"];
            }
        },{
        	field : 'dloc',
            title : '科室位置',
            width : 50,
            editor : {type:'text'}
        },{
        	field : 'bz',
            title : '备注',
            width : 50,
            editor : {type:'text'}
        }
    ]]
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
function deptdelete(){
	var row = $("#tt").datagrid("getSelected");
	if(row){
		$.messager.confirm('确认','您确认想要删除记录吗？',function(r){    
		    if (r){    
		    	$.post(pathhere+"/dept/delete","deptid="+row.deptid,function(result){
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
    <li><a href="#">科室维护</a></li>
    </ul>
    </div>
    
<div class="rightinfo">
    
    <div class="tools">
    
    	<ul class="toolbar">
        <li onclick="insert()"><span><img src="<%=path %>/images/t01.png" /></span>添加</li>
        <li onclick="save()"><span><img src="<%=path %>/images/ico04.png" /></span>保存</li>
        <li onclick="deptdelete()"><span><img src="<%=path %>/images/t03.png" /></span>删除</li>
        <li onclick="canceledit()"><span><img src="<%=path %>/images/undo.png" /></span>取消</li>
        </ul>
    </div>
    <table id="tt" title="科室列表" idField="id"  singleSelect="true"> 
    </table>
    
</div>

</body>
</html>