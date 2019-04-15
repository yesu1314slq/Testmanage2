<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Insert title here</title>
	<script type="text/javascript" src="<%=request.getContextPath()%>/static/js/jquery-3.0.0.min.js"></script>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/static/js/bootstrap-3.3.7-dist/css/bootstrap.min.css">
	<script src="<%=request.getContextPath()%>/static/js/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

	<script src="<%=request.getContextPath()%>/static/js/bootstrap-3.3.7-dist/bootstrap-table-master/src/bootstrap-table.min.js"></script>
	<link href="<%=request.getContextPath()%>/static/js/bootstrap-3.3.7-dist/bootstrap-table-master/src/bootstrap-table.min.css" rel="stylesheet" />
	<script src="<%=request.getContextPath()%>/static/js/bootstrap-3.3.7-dist/bootstrap-table-master/src/locale/bootstrap-table-zh-CN.js"></script>

	<link rel="stylesheet" href="<%=request.getContextPath()%>/static/js/bootstrap-3.3.7-dist/bootstrap-datetimepicker-master/css/bootstrap-datetimepicker.min.css">
	<script src="<%=request.getContextPath()%>/static/js/bootstrap-3.3.7-dist/bootstrap-datetimepicker-master/js/moment-with-locales.js" type="text/javascript" ></script>
	<script src="<%=request.getContextPath()%>/static/js/bootstrap-3.3.7-dist/bootstrap-datetimepicker-master/js/bootstrap-datetimepicker.min.js" type="text/javascript"></script>
	<!-- 弹框bootbox-->
	<script type="text/javascript" src="<%=request.getContextPath()%>/static/js/bootstrap-3.3.7-dist/bootstrap-bootbox/bootbox.js"></script>
<body>
<div class="panel panel-info">
	<div class="panel-heading">查询条件</div>
	<div class="panel-body">
		<form class="form-horizontal" role="form" id="productFormId">
			<div class="form-group">
				<label class="col-sm-2 control-label">用户名</label>
				<div class="col-sm-4">
					<input class="form-control" id="nameEache" name="name" type="text" placeholder="请输入用户名"/>
				</div>
				<label class="col-sm-2 control-label">工号</label>
				<div class="col-sm-4">
					<input class="form-control" id="staffNumberEache" name="staff_number" type="text" placeholder="请输入工号"/>
				</div>
			</div>
			<div class="clearfix form-actions" style="text-align:center">

				<button class="btn btn-primary" type="button" onclick="staffEache()">
					<i class="glyphicon glyphicon-ok"></i>
					查询
				</button>
				<button class="btn btn-default" type="reset">
					<i class="glyphicon glyphicon-refresh"></i>
					重置
				</button>

			</div>
		</form>
	</div>
</div>
<shiro:hasPermission name="staff：toStaffAddPage">
	<button id="btn_add" type="button" class="btn btn-primary" onclick="addStaff()">
		<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
	</button>
</shiro:hasPermission>
<shiro:hasPermission name="staff:exportExcel">
	<button id="btn_delete" type="button" class="btn btn-success" onclick="exportExcel()">
		<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>导出Excel
	</button>
</shiro:hasPermission>
<table id="tb_staffList" border="1"class="table table-striped table-borderedtable-condensed"></table>
</body>
<script type="text/javascript">
    function staffEache(){
        $("#tb_staffList").bootstrapTable("refresh",{
            query:{
                "name":$("#nameEache").val(),
                "staff_number":$("#staffNumberEache").val(),
            }
        })
    }
    $(function(){
        chaxun();
    })
    function chaxun(){
        $('#tb_staffList').bootstrapTable({
            url: '<%=request.getContextPath()%>/staff/getstaffList.html',         //请求后台的URL（*）
            contentType: 'application/x-www-form-urlencoded;charset=UTF-8',//这里我就加了个 utf-8
            method: 'post',                      //请求方式（*）
            toolbar: '#toolbar',                //工具按钮用哪个容器
            striped: true,                      //是否显示行间隔色
            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,                   //是否显示分页（*）
            sortable: false,                     //是否启用排序
            sortOrder: "asc",                   //排序方式
            sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
            pageNumber:1,                       //初始化加载第一页，默认第一页
            pageSize:5,                       //每页的记录行数（*）
            pageList: [5, 25, 50, 100],
            search: false,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
            strictSearch: true,
            showColumns: true,                  //是否显示所有的列
            showRefresh: true,                  //是否显示刷新按钮
            minimumCountColumns: 2,             //最少允许的列数
            clickToSelect: true,                //是否启用点击选中行
            height: 500,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            uniqueId: "id",                     //每一行的唯一标识，一般为主键列
            showToggle:true,                    //是否显示详细视图和列表视图的切换按钮
            cardView: false,                    //是否显示详细视图
            dataType:"json",
            detailView: false,                   //是否显示父子表
            columns: [{
                checkbox: true
            }, {
                field: 'name',
                title: '员工名称'
            }, {
                field: 'org_id',
                title: '组织ID'
            },{
                field: 'spell',
                title: '简拼'
            },{
                field: 'staff_number',
                title: '工号'
            },{
                field: 'link_tel',
                title: '联系电话'
            },{
                field: 'remark',
                title: '备注',
            },{
                field: 'id',
                title: '角色',
                formatter:function(value,row,index){
                    return "<input type='button' onclick='roleDetails(\""+value+"\")' value='角色详情' class='btn btn-warning'/> ";
                }
            },{
                field:'id',
                title:'操作',
                formatter:function(value,row,index){
					return "<input type='button' onclick='editStaff(\""+value+"\")' value='编辑' class='btn btn-warning'/>"+
                        "<input type='button' onclick='delStaff(\""+value+"\")' value='删除' class='btn btn-danger'/>";
                }
            }]
        });
    }

    function roleDetails(id){
        bootbox.dialog({
            message:getDivUrl("<%=request.getContextPath()%>/role/roleDetailsPage.html?id="+id),
            title: "角色详情",
            buttons: {
                Cancel: {
                    label: "取消",
                    className: "btn-default",
                    callback: function () {

                    }
                }
                , OK: {
                    label: "返回",
                    className: "btn-primary",
                    callback: function () {
                    }
                }
            }
        });
    }
    function addStaff(){
        location.href="<%=request.getContextPath()%>/staff/toStaffAddPage.html";
    }

    function editStaff(id){
        location.href="<%=request.getContextPath()%>/staff/toStaffEditPage.html?id="+id;
    }

    function editRole(id){
        Location.href="<%=request.getContextPath()%>/staff/toUpdateStaffRole.html?id="+id;
    }
    function getDivUrl(url){
        var fan_page="";
        $.ajax({
            url:url,
            type:"post",
            dateType:"text",
            async:false,
            success:function(data){
                fan_page=data;
            },error:function(){
                alert("获取页面报错");
            }
        })
        return fan_page;
    }

    function delStaff(id) {
        $.ajax({
            url:"<%=request.getContextPath()%>/staff/deleteStaffById.html",
            dateType:"post",
            data:{"id":id},
            success:function(data){
                if(data=="ok"){
                    $('#tb_staffList').bootstrapTable('refresh');
                }else{
                    alert("没有删除的对象")
                }

            },
            error:function(){
                alert("删除出现错误")
            }
        })
    }

    function exportExcel(){

        window.location.href="<%=request.getContextPath()%>/staff/exportExcel.html";
    }

</script>
</html>