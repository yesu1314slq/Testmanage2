<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="<%=request.getContextPath()%>/static/js/jquery-3.0.0.min.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/static/js/bootstrap-3.3.7-dist/css/bootstrap.min.css">
<script src="<%=request.getContextPath()%>/static/js/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

<script src="<%=request.getContextPath()%>/static/js/bootstrap-3.3.7-dist/bootstrap-table-master/src/bootstrap-table.min.js"></script>
<link href="<%=request.getContextPath()%>/static/js/bootstrap-3.3.7-dist/bootstrap-table-master/src/bootstrap-table.min.css" rel="stylesheet" />
<script src="<%=request.getContextPath()%>/static/js/bootstrap-3.3.7-dist/bootstrap-table-master/src/locale/bootstrap-table-zh-CN.js"></script>

<link rel="stylesheet" href="<%=request.getContextPath()%>/static/js/bootstrap-3.3.7-dist/bootstrap-datetimepicker-master/css/bootstrap-datetimepicker.min.css">
	<script src="<%=request.getContextPath()%>/static/js/bootstrap-3.3.7-dist/bootstrap-datetimepicker-master/js/moment-with-locales.js" ></script>
<script src="<%=request.getContextPath()%>/static/js/bootstrap-3.3.7-dist/bootstrap-datetimepicker-master/js/bootstrap-datetimepicker.min.js"></script>
</head>
<body>
<div class="panel panel-info">
	 	<div class="panel-heading">查询条件</div>
	 	 <div class="panel-body">
	 	 	<form class="form-horizontal" role="form" id="productFormId" method="post">
            	<div class="form-group">
                          <label class="col-sm-2 control-label" >接口名称</label>
                          <div class="col-sm-4">
                             <input class="form-control" id="interfaceNameEache" name="interface_name" type="text" placeholder="请输入接口"/>
                          </div>
                          <label class="col-sm-2 control-label">调用省份</label>
                          <div class="col-sm-4">
                            <input class="form-control" id="callProvinceEache" name="call_province" type="text" placeholder="请输入省份名称"/>
                          </div>
                 </div>
                <div class="form-group">
                          <label class="col-sm-2 control-label" >调用时间</label>
                          <div class="col-sm-4">
                            <div class="input-group" >
								<input type="text" class="form-control" id="minCalltime"  name="minCalltime" />
								<span class="input-group-addon">
								<i class="glyphicon glyphicon-transfer"></i>
								</span>
								<input type="text"class="form-control" id="maxCalltime"  name="maxCalltime"  />
							</div>
                          </div>
                 </div>
		         <div class="clearfix form-actions" style="text-align:center">
								
						<button class="btn btn-primary" type="button" onclick="allInterface()">
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
 <table id="tb_allList" border="1"class="table table-striped table-borderedtable-condensed"></table>
</body>
<script type="text/javascript">
function allInterface(){
	$("#tb_allList").bootstrapTable("refresh",{
		query:{
			"interface_name":$("#interfaceNameEache").val(),
			"call_province":$("#callProvinceEache").val(),
			"minCalltime":$("#minCalltime").val(),
			"maxCalltime":$("#maxCalltime").val(),
		}
	})
}
$(function(){
	chaxun();
	datepiceker();
})
	function chaxun(){
	$('#tb_allList').bootstrapTable({
        url: '<%=request.getContextPath()%>/acc/getAllInterfaceList.html',         //请求后台的URL（*）
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
            field: 'interface_name',
            title: '接口名称'
        }, {
            field: 'interface_efficiency',
            title: '接口效率'
        },{
            field: 'call_province',
            title: '调用省份'
        },{
            field: 'id',
            title: '操作',
            formatter:function(value,row,index){
        		return "<input type='button' onclick='delAllInterface(\""+value+"\")' value='删除' class='btn btn-danger'/>";
        	}
        }]
    });
	}
function datepiceker(){
	$('#minCalltime').datetimepicker({
        format: 'YYYY-MM-DD',
        locale: 'zh-CN',
        showClear: true,
    });
    $('#maxCalltime').datetimepicker({
        format: 'YYYY-MM-DD',
        locale: 'zh-CN',
        showClear: true,
    });
}

function delAllInterface(id) {
    $.ajax({
        url:"<%=request.getContextPath()%>/acc/deleteALLById.html",
        dateType:"post",
        data:{"id":id},
        success:function(data){
            if(data=="ok"){
                $('#tb_allList').bootstrapTable('refresh');
            }else{
                alert("没有删除的对象")
            }
        },
        error:function(){
            alert("删除出现错误")
        }
    })
}
</script>
</html>