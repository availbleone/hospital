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
		$('#druglist').edatagrid({
		    url: pathhere+'/recipeinfo/selectByProperty',
		    saveUrl: pathhere+'/recipeinfo/insert',
		    updateUrl: pathhere+'/recipeinfo/update',
		    loadMsg: '正在加载信息...',
			fitColumns: true,
			frozenColumns:[[{field:'ck',checkbox:true}]],
			queryParams: {
				regid: 41,
				rtype: ''
			},
			columns : [[{
	        	field : 'did',
	            title : '员工编号',
	            width : 50
	        },{
	        	field : 'dname',
	            title : '员工姓名',
	            width : 50,
	            editor : {
	            	type:'combogrid',
	            	options:{
	            		required:true,
	            		panelWidth:450,    
	            	    idField:'did1',    
	            	    textField:'dname',    
	            	    url:pathhere+'/clinicitem/selectXm?flag=1',
	            	    columns:[[    
	            	        {field:'itemid',title:'项目编号',width:100},    
	            	        {field:'iname',title:'项目名',width:200},    
	            	        {field:'iprice',title:'单价（元）',width:100}  
	            	    ]],
	            	    keyHandler:{
	                        query: function(q) {
	                            //动态搜索
	                           $('.combogrid-f').combogrid('grid').datagrid("reload", {'value': q});
	                           $('.combogrid-f').combogrid("setValue", q);
	                        }
	                    },
	                    onSelect:function(index,row){
	                    	$('.combogrid-f').combogrid('setValue',row.iname);
	                    	var row1 = $('#druglist').datagrid('getSelected');
	                        if (row1) {
	                            var i=$('#druglist').datagrid('getRowIndex',row1);
	                            var did=$('.datagrid-body td[field="did"]')[i];
	                            var unitprice=$('.datagrid-body td[field="unitprice"]')[i];
	                            var div = $(did).find('div')[0];
	                            var unitpricediv = $(unitprice).find('div')[0];
	                            $(div).html(row.itemid);
	                            $(unitpricediv).html(row.iprice);
	                        }
	                	}
	            	
	            	}
	            }
	        },{
	        	field : 'unitprice',
	            title : '单价',
	            width : 50
	        },{
	        	field : 'patientno',
	            title : '病历号',
	            width : 50
	        },{
	        	field : 'regid',
	            title : '就诊id',
	            width : 50
	        }
	    ]]
	});
});


//添加
function insert(){
	$("#druglist").edatagrid('addRow');
	var row = $('#druglist').datagrid('getSelected');
    if (row) {
        var i=$('#druglist').datagrid('getRowIndex',row);
        var patientno=$('.datagrid-body td[field="patientno"]')[i];
        var regid=$('.datagrid-body td[field="regid"]')[i];
        var div1 = $(patientno).find('div')[0];
        var div2 = $(regid).find('div')[0];
        $(div1).text('111');
        $(div2).text('222');
    }
}
//保存
function savedrug(){
	$("#druglist").edatagrid('saveRow');
	$("#druglist").datagrid("reload");
}

</script>
</head>
<body>
<div class="rightinfo">
    
    <div class="tools">
    	<ul class="toolbar">
	        <li onclick="insert()"><span><img src="<%=path %>/images/t01.png" /></span>添加</li>
	        <li onclick="savedrug()"><span><img src="<%=path %>/images/ico04.png" /></span>保存</li>
	        <li onclick=""><span><img src="<%=path %>/images/t03.png" /></span>删除</li>
        </ul>
    </div>
    <table id="druglist" title="项目列表" singleSelect="true"> 
    </table>
    
</div>

</body>
</html>