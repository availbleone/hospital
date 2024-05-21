<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>医生工作站</title>
<%@ include file="/head.jsp" %>
<script type="text/javascript" src="<%=path%>/js/jquery.idTabs.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/select-ui.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/recipeinfo.js"></script>
<script type="text/javascript" src="<%=path%>/js/recipeinfo.js"></script>
</head>
<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">医生工作站</a></li>
    <li><a href="#">工作台</a></li>
    <span style="padding-left: 130px;"><img src="<%=path%>/images/i07.png" height="42px"></span>
    <span id="name">患者姓名：</span>
    <span id="no">病历号：</span>
    <span id="idcard">身份证号：</span>
    <span id="xb">性别：</span>
    <span id="nl">年龄：</span>
    <span style="padding-left: 150px;"><a onclick="closeover()"  class="ibtn" style="color: blue;margin-top: 8px">诊毕</a></span>
    </ul>
    </div>
    
<div class="mainbox">
    
<div class="mainleft">
<input name="key" id="key" type="hidden" class="dfinput" />
<form id="fm" action="" method="post">
    <div class="formbody">
	<div id="usual1" class="usual"> 
	    <div class="itab">
		  	<ul> 
		    <li><a href="#tab1" class="selected">门诊病历</a></li>
		    <li><a href="#tab2" onclick="changejcjy(3)">开立处方</a></li>
		    <li><a href="#tab3" onclick="changejcjy(1)">检查申请单</a></li>
		    <li><a href="#tab3" onclick="changejcjy(2)">检验申请单</a></li>
		    <li><a href="#tab5" onclick="changejcjy(4)">历史处方</a></li>
		  	</ul>
	    </div> 
	    <!--------------------------------- 门诊病历 begin ------------------------------------------->
	  	<div id="tab1" class="tabson" style="height: 450px;">
	    	 <ul class="forminfo" style="margin-top: 10px">
			    <li><label>主诉症状</label><input name="symptom" id="symptom" type="text" class="dfinput" /></li>
			    <li><label>病史</label><input name="history" id="history" type="text" class="dfinput" /></li>
			    <li>
			    	<label>体温</label><input name="temperature" id="temperature" type="text" class="dfinput" style="width: 70px;" />&nbsp;&nbsp;℃&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			    	血压&nbsp;&nbsp;
			    	<input name="bloodpre" id="bloodpre" type="text" class="dfinput" style="width: 80px;"/>
			    </li>
			    <li><label>诊断</label><input name="diagnose" id="diagnose" type="text" class="dfinput" /></li>
			    <li><label>门诊处置</label><textarea id="measure" name="measure" cols="" rows="" s="" class="textinput"></textarea></li>
			    <li>
			    	<label>&nbsp;</label>
			    	<input type="button" class="btn" value="确认保存" onclick="save(1)"/>
			    	<input type="button" class="btn" value="清空" onclick="javascript:cleara()"/>
			    </li>
<input type="hidden" id="operatorid" name="operatorid" class="dfinput"/>
<input type="hidden" id="patientno1" name="patientno" class="dfinput"/>
<input type="hidden" id="regid" name="regid" class="dfinput"/>
<input type="hidden" id="patientname" name="patientname" class="dfinput"/>
	
			 </ul>
		
	    </div> 
	    <!--------------------------------- 门诊病历 end ------------------------------------------->
	  	
	    <!-------------------------------处方页面 begin  -------------------------->
	  	<div id="tab2" class="tabson" style="height: 450px">
		    <div class="tools" style="margin-top: 10px">
		    	<ul class="toolbar">
			        <li onclick="insert()"><span><img src="<%=path%>/images/t01.png" /></span>添加</li>
			        <li onclick="savedrug()"><span><img src="<%=path%>/images/ico04.png" /></span>保存</li>
			        <li onclick="deleteyp()"><span><img src="<%=path%>/images/t03.png" /></span>删除</li>
			        <li onclick="canceledit()"><span><img src="<%=path%>/images/undo.png" /></span>取消</li>
		        </ul>
	    	</div>
		    <table id="druglist" title="项目列表" singleSelect="true"></table>
	    
	    </div> 
	    <!-------------------------------处方页面 end  -------------------------->
	    
	    <!--------------------------------- 检查检验 begin ------------------------------------------->
	  	<div id="tab3" class="tabson" style="height: 450px">
	  	<div>
		    <ul class="forminfo" style="margin-top: 10px">
		    	<li><label>项目开立</label><input name="did1" id="did1" type="text" class="dfinput" /></li>
		    	<li><label>数量</label><input name="dnum" id="dnum" type="text" class="dfinput"/></li>
		    	<li><label id="bzsm1"></label><input name="bz" id="bz" type="text" class="dfinput" /></li>
		    	<li>
			    	<label>&nbsp;</label><br>
			    	<input type="button" class="btn" value="确认保存" onclick="save(2)"/>
				    <input type="button" class="btn" value="清空" onclick="javascript:cleara()"/>
				</li>
		    	
		    	<input name="dname" id="dname" type="hidden" class="dfinput" />
		    	<input name="unitprice" id="unitprice" type="hidden" class="dfinput" />
		    	<input name="rtype" id="rtype" type="hidden" class="dfinput" />
		    	<input name="did" id="did" type="hidden" class="dfinput" />
		    	
		    </ul>
	    </div>
	    <div style="margin-top: 33px">
	    	<table id="jclist" singleSelect="true" height="225px" title="已开项目" class="easyui-datagrid">
		    	<thead>
			    <tr>
			    	<th field="did" width="20">项目编号</th>
			    	<th field="dname" width="40">项目名</th>
			    	<th field="unitprice" width="15">单价（元）</th>
			    	<th field="dnum" width="15">数量</th>
			    	<th field="bz" width="15">部位/样本</th>
			    	<th field="operatetime" width="30">开立时间</th>
			    	<%--<th field="sfstate" width="10">是否交费</th>--%>
			    	<th field="zxstate" width="10">是否执行</th>
			    </tr>
			    </thead>
		    </table>
		</div>
	    </div>
	    <!--------------------------------- 检查检验end ------------------------------------------->
	  	 
	  	  
	  	<!--------------------------------- 历史处方 begin ------------------------------------------->
	  	<div id="tab5" class="tabson" style="height: 450px">
	    	<table id="historylist"></table>
	    </div>
	    <!--------------------------------- 历史处方 end ------------------------------------------->
	</div> 
    </div>
</form>
</div>
    
<div class="mainright">
    <div class="dflist"  style="height: 485px">
    <div class="listtitle">
    	待诊患者&nbsp;&nbsp;&nbsp;<input type="text" id="patientno" name="patientno" placeholder="输入病历号或身份证号" style="height: 25px">
    	<a href="#" class="more1">查询</a>
    </div>    
    <table id="tt" singleSelect="true"  data-options="onLoadSuccess:function(){ $('#tt').datagrid('selectRow',currentindex);}"> 
    	<thead>
	    <tr>
	    	<th field="patientno" width="55">病历号</th>
	    	<th field="patientname" width="30">姓名</th>
	    	<th field="sex" width="15" formatter=transsex >性别</th>
	    	<th field="age" width="15">年龄</th>
	    	<th field="regid" width="15" hidden="true">年龄</th>
	    </tr>
	    </thead>
    </table> 
    </div>
</div>
    <!--mainright end-->
    
<script type="text/javascript"> 
	$("#usual1 ul").idTabs(); 
</script>
    
<script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
</script>
</div>
</body>
<script type="text/javascript">
	function changejcjy(type){
		row = $("#tt").datagrid('getSelected');
		if(row==null){
			$.messager.alert('提示','您还未选择患者!');
		}
		if(type==2){
			$("#bzsm1").html('检验样本');
			$("#key").val(2)
			sxlb();
			xmlist(type);
		}
		if(type==1){
			$("#bzsm1").html('检查部位');
			$("#key").val(1)
			sxlb();
			xmlist(type);
		}
		if(type==3){
			$("#key").val(3)
			scdl();
		}else{
			schistory();
		}
	}
</script>
</html>