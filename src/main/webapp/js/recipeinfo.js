aid = JSON.parse(sessionStorage.admin).aid;
var obj;
var currentindex = -1;
var pathhere ="http://localhost:8888/hospitalsys_war_exploded";
window.onload=function(){
	$("#key").val(1);
	$("#operatorid").val(aid);
	//患者列表加载
	$('#tt').datagrid({    
	    url: pathhere+'/register/selectDz?aid='+aid,
	    loadMsg: '正在加载信息...',
		fitColumns: true,
		height:448,
		border:false,
		frozenColumns:[[{field:'ck',checkbox:true}]],
		onLoadSuccess:function(){
			if(currentindex!=-1){  //有选中行时加载数据后设置选中行   
                $('#tt').datagrid('selectRow',currentindex);        
           }else{
        	   $('#tt').datagrid('selectRow',0); 
           }
		},
		onClickRow:function selectpatient(index,row){
			obj = row;
			currentindex = index;
			$("#operatorid").val(aid);
			$("#patientno").val(row.patientno);
			$("#patientname").val(row.patientname);
			$("#regid").val(row.regid);
			$("#no").html('病历号：'+row.patientno);
			$("#idcard").html('身份证号：'+row.idnumber);
			$("#name").html('患者姓名：'+row.patientname);
			$("#xb").html('性别：'+((row.sex==1)?'男':'女'));
			$("#nl").html('年龄：'+row.age+'岁');
			sxlb();
			scdl();
			schistory();
			currentindex=$('#tt').datagrid('getRowIndex', $("#tt").datagrid('getSelected'));  
			
		}
	});
};
//检查项目列表
function sxlb(){
	$('#jclist').datagrid({
		url: pathhere+'/recipeinfo/selectByProperty',
	    loadMsg: '正在加载信息...',
		fitColumns: true,
		frozenColumns:[[{field:'ck',checkbox:true}]],
		queryParams: {
			regid: obj.regid,
			rtype:$("#key").val()
		},
		toolbar: [{
			text:'项目作废',
			iconCls: 'icon-cancel',
			handler: deletexm
		}]
	});
}
//删除开立项目
function deletexm(){
	var row = $("#jclist").datagrid("getSelected");
	if(row){
		$.messager.confirm('确认','您确认想要删除记录吗？',function(r){    
		    if (r){  
		    	if(row.sfstate!=1){
		    		$.post(pathhere+"/recipeinfo/deletexm","rid="+row.rid+"&fid="+row.fid,function(result){
			    		if(result==1){
			    			$("#dlg").dialog('close');
			    			$("#jclist").datagrid("reload");
			    			$.messager.alert('提示','操作成功！');
			    		}else{
			    			$.messager.alert('提示','操作失败！');
			    		}
			    	})  
		    	}else{
		    		$.messager.alert('警告','该项目已经交费不能删除！');
		    	}
		    }    
		});  
	}else{
		$.messager.alert('提示','必须选中一行！');
	}
}
//格式化性别列
function transsex(value,row,index){
	return (value==1)?'男':'女';
};
//清屏
function cleara(){
	$("#fm").form('clear');
	row = $("#tt").datagrid("getSelected");
	$("#patientno").val(row.patientno);
	$("#patientname").val(row.patientname);
	$("#regid").val(row.regid);
	$("#operatorid").val(aid);
	$("#rtype").val($("#key").val());
}

//保存
function save(flag){
	//alert(flag);
	var url;
	if(flag==1){
		url = pathhere+'/record/insert';

	}
	if(flag==2){
		url = pathhere+'/recipeinfo/insert';
	}
	$("#fm").form('submit',{
		url:url,
		success:function(result){
			if(result==1){
				$.messager.alert('提示','操作成功！');
				if(flag==2){
					cleara();
				}
				$("#tt").datagrid("reload");
				$("#jclist").datagrid("reload");
			}else{
				$.messager.alert('提示','操作失败！');
			}
		}
	})
}
//检查检验项目下拉组合框
function xmlist(type){
	$('#did1').combogrid({    
	    panelWidth:450,    
	    idField:'did1',    
	    textField:'dname',    
	    url:pathhere+'/clinicitem/selectXm?flag='+type,
	    columns:[[    
	        {field:'itemid',title:'项目编号',width:100},    
	        {field:'iname',title:'项目名',width:200},    
	        {field:'iprice',title:'单价（元）',width:100}  
	    ]],
	    keyHandler:{
            query: function(q) {
                //动态搜索
               $('#did1').combogrid("grid").datagrid("reload", {'value': q});
               $('#did1').combogrid("setValue", q);
            }
        },
        onSelect:function(index,row){
        		$("#did1").combogrid('setValue',row.iname);
        		$("#did").val(row.itemid);
        		$("#dname").val(row.iname);
        		$("#unitprice").val(row.iprice);
        		$("#rtype").val($("#key").val());
        }
        
	});  

}
//Tab页切换



//加载药品列表
var roles;
var depts;
function scdl(){
	$('#druglist').edatagrid({   
	    url: pathhere+'/recipeinfo/selectByProperty',
	    saveUrl: pathhere+'/recipeinfo/insert',
	    updateUrl: pathhere+'/recipeinfo/update',
	    loadMsg: '正在加载信息...',
		//fitColumns: true,
		frozenColumns:[[{field:'ck',checkbox:true}]],
		queryParams: {
			regid: obj.regid,
			rtype: 3
		},
		columns : [[{
        	field : 'did',
            title : '药品编号',
            width : 80,
            editor : {type:'text'}
        },{
        	field : 'dname',
            title : '药品名',
            width : 200,
            editor : {
            	type:'combogrid',
            	options:{
            		required:true,
            		panelWidth:650,    
            	    idField:'did1',    
            	    textField:'dname',    
            	    url:pathhere+'/druginfo/selectYp',
            	    columns:[[    
            	        {field:'did',title:'药品编号',width:70},    
            	        {field:'dname',title:'药品名',width:150},    
            	        {field:'price',title:'单价（元）',width:80},  
            	        {field:'bz',title:'规格',width:80},
            	        {field:'dnum',title:'剩余库存',width:60},
            	        {field:'provider',title:'生产厂家',width:200},
            	    ]],
            	    keyHandler:{
                        query: function(q) {
                            //动态搜索
                           $('.combogrid-f').combogrid('grid').datagrid("reload", {'value': q});
                           $('.combogrid-f').combogrid("setValue", q);
                        }
                    },
                    onSelect:function(index,row){
                    	$('.combogrid-f').combogrid('setValue',row.dname);
                    	var row1 = $('#druglist').datagrid('getSelected');
                        if (row1) {
                            var i=$('#druglist').datagrid('getRowIndex',row1);
                            var did=$('.datagrid-body td[field="did"]')[i];
                            var unitprice=$('.datagrid-body td[field="unitprice"]')[i];
                            var minunit=$('.datagrid-body td[field="minunit"]')[i];
                            var unit=$('.datagrid-body td[field="unit"]')[i];
                            var div = $(did).find('div input')[0];
                            var unitpricediv = $(unitprice).find('div input')[0];
                            var minunitdiv = $(minunit).find('div input')[0];
                            var unitdiv = $(unit).find('div input')[0];
                            $(div).val(row.did);
                            $(unitpricediv).val(row.price);
                            $(minunitdiv).val(row.minunit);
                            $(unitdiv).val(row.unit);
                            
                        }
                	}
            	
            	}
            }
        },{
        	field : 'unitprice',
            title : '单价（元）',
            width : 80,
            editor : {type:'text'}
        },{
        	field : 'dnum',
            title : '开立数量',
            width : 80,
            editor : {type:'text',options:{required:true}}
        },{
        	field : 'unit',
            title : '包装单位',
            width : 80,
            editor : {type:'text',options:{required:true}}
        },{
        	field : 'qty',
            title : '单次用量',
            width : 80,
            editor : {type:'text',options:{required:true}}
        },{
        	field : 'minunit',
            title : '单位',
            width : 80,
            editor : {type:'text'}
        },{field : 'freq',
            title : '频次',
            width : 80,
            editor : {
                type : 'combobox',
                options : {
                    valueField : "freq",
                    textField : "freqname",
                    required:true,
                    data : [{freq: '一日一次',freqname: '一日一次'},{freq: '一日两次',freqname: '一日两次'},{freq: '一日三次',freqname: '一日三次'},{freq: '其他',freqname: '其他'}]
                }
            }
        },{
        	field : 'patientno',
            title : '病历号',
            width : 50,
            hidden : true,
            editor : {type:'text'}
        },{
        	field : 'regid',
            title : '就诊id',
            width : 50,
            hidden : true,
            editor : {type:'text'}
        },{
        	field : 'patientname',
            title : '姓名',
            width : 50,
            hidden : true,
            editor : {type:'text'}
        },{
        	field : 'rtype',
            title : '类型',
            width : 50,
            hidden : true,
            editor : {type:'text'}
        },{
        	field : 'operatorid',
            title : '类型',
            width : 50,
            hidden : true,
            editor : {type:'text'}
        }
    ]]
});
};

//添加
function insert(){
	$("#druglist").edatagrid('addRow');
	var row = $('#druglist').datagrid('getSelected');
    if (row) {
        var i=$('#druglist').datagrid('getRowIndex',row);
        var patientno=$('.datagrid-body td[field="patientno"]')[i];
        var regid=$('.datagrid-body td[field="regid"]')[i];
        var patientname=$('.datagrid-body td[field="patientname"]')[i];
        var rtype=$('.datagrid-body td[field="rtype"]')[i];
        var operatorid=$('.datagrid-body td[field="operatorid"]')[i];
        var div1 = $(patientno).find('div input')[0];
        var div2 = $(regid).find('div input')[0];
        var div3 = $(patientname).find('div input')[0];
        var div4 = $(rtype).find('div input')[0];
        var div5 = $(operatorid).find('div input')[0];
        $(div1).val($('#patientno').val());
        $(div2).val($('#regid').val());
        $(div3).val($('#patientname').val());
        $(div4).val(3);
        $(div5).val($('#operatorid').val());
        
    }
}
//保存药品
function savedrug(){
	$("#druglist").edatagrid('saveRow');
	$("#druglist").datagrid("reload");
}
//取消编辑
function canceledit(){
	var row = $("#druglist").datagrid("getSelected");
	if(row){
		var index = $("#druglist").datagrid("getRowIndex",row);
		$("#druglist").datagrid('cancelEdit',index);
	}
	$("#druglist").datagrid("reload");
}
//删除药品
function deleteyp(){
	var row = $("#druglist").datagrid("getSelected");
	if(row){
		$.messager.confirm('确认','您确认想要删除记录吗？',function(r){    
		    if (r){  
		    	if(row.sfstate!=1){
		    		$.post(pathhere+"/recipeinfo/deletexm","rid="+row.rid+"&fid="+row.fid,function(result){
			    		if(result==1){
			    			$("#dlg").dialog('close');
			    			$("#druglist").datagrid("reload");
			    			$.messager.alert('提示','操作成功！');
			    		}else{
			    			$.messager.alert('提示','操作失败！');
			    		}
			    	})  
		    	}else{
		    		$.messager.alert('警告','该药品已经收费不能删除！');
		    	}
		    }    
		});  
	}else{
		$.messager.alert('提示','必须选中一行！');
	}
}
//生成历史病历列表
function schistory(){
	$("#historylist").datagrid({
		url:pathhere+'/record/selectByPno?pno='+obj.patientno,
		title:'历史处方',
		border:false,
		height:448,
		fit : true,
		columns : [ [ {
			field : "regid",
			title : "就诊id",
			hidden : true
			},{
				field : "operatetime",
				title : "就诊日期",
			},{
				field : "diagnose",
				title : "诊断",
			},{
				field : "symptom",
				title : "症状",
			} ] ],
			view:detailview,
			detailFormatter:function(index,row){
			return "<div><table id='ddv-"+index+"'></table></div>";
			},
			onExpandRow:function(index,row){
				$("#ddv-"+index).datagrid({
				url:pathhere+'/recipeinfo/selectByRegid?regid='+row.regid,
				width:600,
				height:"auto",
				columns:[[
					{field:"minunit",title:"项目类型"},
				    {field:"did",title:"项目编号"},
				    {field:"dname",title:"项目名称"},
				    {field:"bz",title:"检查部位"},
				    {field:"dnum",title:"数量"},
				    {field:"qty",title:"单次用量"},
				    {field:"freq",title:"频次"},
				]],
				onResize:function(){  
				                    $('#historylist').datagrid('fixDetailRowHeight',index);  
				                },  
				                onLoadSuccess:function(){
				                    setTimeout(function(){
				                        $('#historylist').datagrid('fixDetailRowHeight',index);  
				                    },0);  
				                }
				});
				$('#historylist').datagrid('fixDetailRowHeight',index);
				}
	})
}
//诊毕功能
function closeover(){
	if(obj){
		$.post(pathhere+'/register/updateState','regid='+obj.regid,function(result){
			if(result==1){
				$.messager.alert('提示','操作成功！');
				currentindex = -1;
				$("#tt").datagrid("reload");
			}else{
				$.messager.alert('提示','请选择诊毕的患者！');
			}
			
		})
	}
}
