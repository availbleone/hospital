<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="/head.jsp" %>
<script type="text/javascript">
//加载列表
var roles;
var depts;
var pathhere ="http://localhost:8888/hospitalsys_war_exploded";
$(function(){
	$.post(pathhere+'/dept/selectList','',function(result){
		depts = result;
		$.post(pathhere+'/role/selectList','',function(result){
			roles = result;
			$('#tt').edatagrid({   
			    url: pathhere+'/admin/selectList',
			    saveUrl: pathhere+'/admin/insert',
			    updateUrl: pathhere+'/admin/update',
			    loadMsg: '正在加载信息...',
				fitColumns: true,
				frozenColumns:[[{field:'ck',checkbox:true}]],
				columns : [[{
		        	field : 'aid',
		            title : '员工编号',
		            width : 50,
		            editor : {type:'validatebox',options:{required:true}}
		        },{
		        	field : 'aname',
		            title : '员工姓名',
		            width : 50,
		            editor : {type:'validatebox',options:{required:true}}
		        },{
		        	field : 'apwd',
		            title : '密码',
		            width : 50,
		            editor : {type:'text',options:{required:true}}
		        },{
		        	field : 'deptid',
		            title : '所属科室',
		            width : 50,
		            editor : {
		                type : 'combobox',
		                options : {
		                    valueField : "deptid",
		                    textField : "dname",
		                    data : depts,
		                    required: true 
		                }
		            },formatter : function (value, row, index) {
		                for (var i = 0; i < depts.length; i++) {
		                    if (depts[i].deptid == value) {
		                        return depts[i].dname;
		                    }
		                }
		                return row["deptid"];
		            }
		        },{
		        	field : 'roleid',
		            title : '角色',
		            width : 50,
		            editor : {
		                type : 'combobox',
		                options : {
		                    valueField : "roleid",
		                    textField : "rolename",
		                    data : roles,
		                    required: true 
		                }
		            },formatter : function (value, row, index) {
		                for (var i = 0; i < roles.length; i++) {
		                    if (roles[i].roleid == value) {
		                        return roles[i].rolename;
		                    }
		                }
		                return row["roleid"];
		            }
		        },{
		            field : 'alevel',
		            title : '职称',
		            width : 50,
		            editor : {
		                type : 'combobox',
		                options : {
		                    valueField : "alevel",
		                    textField : "level",
		                    data : [{alevel: 1,level: '主任医师'},{alevel: 2,level: '主治医师'}]
		                }
		            },
		            formatter : function (value, row, index) {
		                  if (value == 1) {
		                        return '主任医师';
		                }
		                  if (value == 2){
		                	return '主治医师';
		                }
		                return row["alevel"];
		            }
		        },{
		        	field : 'bz',
		            title : '备注',
		            width : 50,
		            editor : {type:'text'}
		        }
		    ]]
			
			});
		})
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
function admindelete(){
	var row = $("#tt").datagrid("getSelected");
	if(row){
		$.messager.confirm('确认','您确认想要删除记录吗？',function(r){    
		    if (r){    
		    	$.post(pathhere+"/admin/delete","aid="+row.aid,function(result){
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
    <li><a href="#">人员管理</a></li>
    </ul>
</div>
    
<div class="rightinfo">
    
    <div class="tools">
    
    	<ul class="toolbar">
        <li onclick="insert()"><span><img src="<%=path %>/images/t01.png" /></span>添加</li>
        <li onclick="save()"><span><img src="<%=path %>/images/ico04.png" /></span>保存</li>
        <li onclick="admindelete()"><span><img src="<%=path %>/images/t03.png" /></span>删除</li>
        <li onclick="canceledit()"><span><img src="<%=path %>/images/undo.png" /></span>取消</li>
        </ul>
    </div>
    <table id="tt" title="员工列表" idField="id"  singleSelect="true"> 
	    
    </table>
    
</div>

</body>
</html>