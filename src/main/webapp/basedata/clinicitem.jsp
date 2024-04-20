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
	$('#tt').edatagrid({    
	    url: '<%=path%>/clinicitem/selectList',    
	    saveUrl: '<%=path%>/clinicitem/insert',    
	    updateUrl: '<%=path%>/clinicitem/update',
	    loadMsg: '正在加载信息...',
		fitColumns: true,
		frozenColumns:[[{field:'ck',checkbox:true}]],
		columns : [[{
        	field : 'itemid',
            title : '项目编号',
            width : 50
        },{
        	field : 'iname',
            title : '项目名称',
            width : 50,
            editor : {type:'validatebox',options:{required:true}}
        },{
        	field : 'iprice',
            title : '单价',
            width : 50,
            editor : {type:'validatebox',options:{required:true}}
        },{
            field : 'ctype',
            title : '项目类别',
            width : 50,
            editor : {
                type : 'combobox',
                options : {
                    valueField : "ctype",
                    textField : "type",
                    data : [{ctype: 0,type: '挂号费'},{ctype: 1,type: '检查费'},{ctype: 2,type: '检验费'}]
                }
            },
            formatter : function (value, row, index) {
            	 if (value == 0) {
                     return '挂号费';
             }
               if (value == 1){
             	return '检查费';
             }
               if (value == 2){
             	return '检验费';
             }
             return row["ctype"];
            }
        },{
            field : 'cstate',
            title : '状态',
            width : 50,
            editor : {
                type : 'combobox',
                options : {
                    valueField : "cstate",
                    textField : "state",
                    data : [{cstate: 0,state: '停用'},{cstate: 1,state: '正常'}]
                }
            },
            formatter : function (value, row, index) {
            	return (value == 0)?'停用':'正常';
             return row["cstate"];
            }
        },{
        	field : 'pcode',
            title : '拼音简码',
            width : 50,
            editor : {type:'text'},
            hidden : true
        },{
        	field : 'bz',
            title : '备注',
            width : 50,
            editor : {type:'text'}
        }
    ]]
	}); 
	
});
function save(){
	$("#tt").edatagrid('saveRow');
	$("#tt").datagrid("reload");
}
function insert(){
	$("#tt").edatagrid('addRow');
};
//删除
function deleteitems(){
	var row = $("#tt").datagrid("getSelected");
	if(row){
		$.messager.confirm('确认','您确认想要删除记录吗？',function(r){    
		    if (r){    
		    	$.post("<%=path%>/clinicitem/delete","itemid="+row.itemid,function(result){
		    		if(result==1){
		    			$("#dlg").dialog('close');
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
};
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
    <li><a href="#">检查检验项目维护</a></li>
    </ul>
    </div>
    
<div class="rightinfo">
    
    <div class="tools">
    
    	<ul class="toolbar">
        <li onclick="insert()"><span><img src="<%=path %>/images/t01.png" /></span>添加</li>
        <li onclick="save()"><span><img src="<%=path %>/images/ico04.png" /></span>保存</li>
        <li onclick="deleteitems()"><span><img src="<%=path %>/images/t03.png" /></span>删除</li>
        <li onclick="canceledit()"><span><img src="<%=path %>/images/undo.png" /></span>取消</li>
        </ul>
    </div>
    <table id="tt" title="项目列表" idField="id"  singleSelect="true"> 
    </table>
   
</div>

</html>