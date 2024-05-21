<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>护士工作站</title>


    <%@ include file="/head.jsp" %>
    <link rel="stylesheet" type="text/css" href="../easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="../easyui/themes/icon.css">
    <script type="text/javascript" src="../easyui/jquery.min.js"></script>
    <script type="text/javascript" src="../easyui/jquery.easyui.min.js"></script>
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
                            <li><a href="#tab2" onclick="changejcjy(3)">床位管理</a></li>
                            <li><a href="#tab3" onclick="changejcjy(1)">医嘱管理</a></li>
                        </ul>
                    </div>
                    <div id="tab1" class="tabson" style="height: 450px;">


                    </div>
                    <!--------------------------------- 门诊病历 end ------------------------------------------->

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

                    <!-------------------------------床位页面 end  -------------------------->
                    <div id="tab3" class="tabson" style="height: 450px">

                        <div>
                            <h1>医嘱管理</h1>
                            <div style="margin-bottom:20px">
                                <a href="#" class="easyui-linkbutton" onclick="executeOrders()">执行</a>
                                <a href="#" class="easyui-linkbutton" onclick="deleteOrders()">删除</a>
                            </div>
                            <table id="doctorOrders" class="easyui-datagrid" style="width:700px;height:400px"
                                   url="/doctorOrders" toolbar="#toolbar" pagination="true"
                                   rownumbers="true" fitColumns="true" singleSelect="true">
                                <thead>
                                <tr>
                                    <th field="id" checkbox="true"></th>
                                    <th field="patientName">病人姓名</th>
                                    <th field="doctorName">医生姓名</th>
                                    <th field="medicationInfo">药物信息</th>
                                    <th field="orderTime">时间</th>
                                    <th field="orderInfo">医嘱信息</th>
                                </tr>
                                </thead>
                            </table>
                        </div>

                    </div>
                    <!--------------------------------- 医嘱end ------------------------------------------->

                </div>
            </div>
        </form>
    </div>
    <style>

    </style>
    <script type="text/javascript">
        $("#usual1 ul").idTabs();
    </script>
</div>
</body>
    <script type="text/javascript">
        function executeOrders() {
        var row = $('#doctorOrders').datagrid('getSelected');
        if (row) {
        $.post('/executeOrder', {id: row.id}, function(result) {
        if (result.success) {
        $('#doctorOrders').datagrid('reload');    // reload the user data
    } else {
        $.messager.show({    // show error message
        title: 'Error',
        msg: result.errorMsg
    });
    }
    }, 'json');
    }
    }

        function deleteOrders() {
        var row = $('#doctorOrders').datagrid('getSelected');
        if (row) {
        $.post('/deleteOrder', {id: row.id}, function(result) {
        if (result.success) {
        $('#doctorOrders').datagrid('reload');    // reload the user data
    } else {
        $.messager.show({    // show error message
        title: 'Error',
        msg: result.errorMsg
    });
    }
    }, 'json');
    }
    }
</script>

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