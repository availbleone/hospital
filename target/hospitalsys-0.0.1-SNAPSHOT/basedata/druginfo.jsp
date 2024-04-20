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
	    url: '<%=path%>/druginfo/selectList',    
	    saveUrl: '<%=path%>/druginfo/insert',    
	    updateUrl: '<%=path%>/druginfo/update',
	    loadMsg: '正在加载信息...',
		fitColumns: true,
		frozenColumns:[[{field:'ck',checkbox:true}]],
		columns : [[{
        	field : 'did',
            title : '药品编号',
            width : 30,
            editor : {type:'validatebox',options:{required:true}}
        },{
        	field : 'dname',
            title : '药品名称',
            width : 100,
            editor : {type:'validatebox',options:{required:true}}
        },{
            field : 'dtype',
            title : '药品类型',
            width : 40,
            editor : {
                type : 'combobox',
                options : {
                    valueField : "dtype",
                    textField : "type",
                    required:true,
                    data : [{dtype: 1,type: '西药'},{dtype: 2,type: '中成药'},{dtype: 3,type: '草药'}]
                }
            },
            formatter : function (value, row, index) {
            	 if (value == 1) {
                     return '西药';
             }
               if (value == 2){
             	return '中成药';
             }
               if (value == 3){
             	return '草药';
             }
             return row["dtype"];
            }
        },{
            field : 'unit',
            title : '包装单位',
            width : 40,
            editor : {
                type : 'combobox',
                options : {
                    valueField : "unit",
                    textField : "uname",
                    required:true,
                    data : [{unit: '盒',uname: '盒'},{unit: '支',uname: '支'},{unit: '袋',uname: '袋'},{unit: '瓶',uname: '瓶'},{unit: '只',uname: '只'},{unit: '副',uname: '副'},{unit: '包',uname: '包'}]
                }
            }
        },{
        	field : 'unitnum',
            title : '包装数量',
            width : 40,
            editor : {type:'numberbox',options:{required:true}}
        },{
            field : 'minunit',
            title : '最小单位',
            width : 40,
            editor : {
                type : 'combobox',
                options : {
                    valueField : "minunit",
                    textField : "mname",
                    required:true,
                    data : [{minunit: '粒',mname: '粒'},{minunit: '支',mname: '支'},{minunit: '片',mname: '片'},{minunit: '袋',mname: '袋'},{minunit: '瓶',mname: '瓶'}]
                }
            }
        },{
        	field : 'price',
            title : '单价（元）',
            width : 40,
            editor : {type:'validatebox',options:{required:true}}
        },{
        	field : 'deadline',
            title : '有效期',
            width : 60,
            editor : {type:'datebox',options:{required:true}}
        },{
            field : 'dstate',
            title : '状态',
            width : 40,
            editor : {
                type : 'combobox',
                options : {
                    valueField : "dstate",
                    textField : "state",
                    required:true,
                    data : [{dstate: 1,state: '正常'},{dstate: 0,state: '停用'}]
                }
            },
            formatter : function (value, row, index) {
            	return (value == 0)?'停用':'正常';
             return row["dstate"];
            }
        },{
        	field : 'pcode',
            title : '拼音简码',
            width : 50,
            editor : {type:'text'},
            hidden : true
        },{
        	field : 'dnum',
            title : '当前库存',
            width : 50,
            editor : {type:'numberbox',options:{required:true}},
        },{
        	field : 'provider',
            title : '生产厂家',
            width : 80,
            editor : {type:'validatebox',options:{required:true}}
        },{
        	field : 'bz',
            title : '规格',
            width : 50
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
function deletedrug(){
	var row = $("#tt").datagrid("getSelected");
	if(row){
		$.messager.confirm('确认','您确认想要删除记录吗？',function(r){    
		    if (r){    
		    	$.post("<%=path%>/druginfo/delete","did="+row.did,function(result){
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
    <li><a href="#">药品耗材维护</a></li>
    </ul>
    </div>
    
<div class="rightinfo">
    
    <div class="tools">
    
   <ul class="toolbar">
        <li onclick="insert()"><span><img src="<%=path %>/images/t01.png" /></span>添加</li>
        <li onclick="save()"><span><img src="<%=path %>/images/ico04.png" /></span>保存</li>
        <li onclick="deletedrug()"><span><img src="<%=path %>/images/t03.png" /></span>删除</li>
        <li onclick="canceledit()"><span><img src="<%=path %>/images/undo.png" /></span>取消</li>
        </ul>
    </div>
    <table id="tt" title="项目列表" idField="id"  singleSelect="true"> 
    </table>
   
</div>

</body>
</html>