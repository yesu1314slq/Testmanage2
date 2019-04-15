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

</head>
<body>
	<div class="panel panel-info">
	 	<div class="panel-heading">查询条件</div>
	 	 <div class="panel-body">
	 	 	<form class="form-horizontal" role="form" id="productFormId" method="post">
            	<div class="form-group">
                          <label class="col-sm-2 control-label">省份名称</label>
                          <div class="col-sm-4">
                             <input class="form-control" id="provinceNameEache" name="province_name" type="text" placeholder="请输入省份名"/>
                          </div>
                          <label class="col-sm-2 control-label">接口效率</label>
                          <div class="col-sm-4">
                             <div class="input-group">
								<input type="number" class="input-sm form-control" id="minPrice"  name="minPrice" value="0"/>
								<span class="input-group-addon">
								<i class="glyphicon glyphicon-transfer"></i>
								</span>
								<input type="number" class="input-sm form-control" id="maxPrice"  name="maxPrice" value="0"/>
							</div>
                          </div>
                 </div>
                 <div class="form-group">
                          <label class="col-sm-2 control-label" >创建时间</label>
                          <div class="col-sm-4">
                            <div class="input-group" >
								<input type="text" class="form-control" id="minCreatetime"  name="minCreatetime" />
								<span class="input-group-addon">
								<i class="glyphicon glyphicon-transfer"></i>
								</span>
								<input type="text"class="form-control" id="maxCreatetime"  name="maxCreatetime"  />
							</div>
                          </div>
                           <label class="col-sm-2 control-label" >是否成功</label>
                          <div class="col-sm-4">
                           	<input type="radio" name="sortBy" value="asc" checked>
             				<label>成功</label>
             				<input type="radio" name="sortBy" value="desc">
             				<label>失败</label>
                          </div>
                  </div>
		         <div class="clearfix form-actions" style="text-align:center">
								
						<button class="btn btn-primary" type="button" onclick="callEache()">
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
			 <button id="btn_delete" type="button" class="btn btn-success" onclick="exportExcel()">
				<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>导出Excel
			</button>
			<button id="btn_export" type="button" class="btn btn-success" onclick="exportXml()">
				<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>导出Xml
			</button>
 <table id="tb_callList" border="1"class="table table-striped table-borderedtable-condensed"></table>
</body>
<script type="text/javascript">
function callEache(){
	$("#tb_callList").bootstrapTable("refresh",{
		query:{
			"province_name":$("#provinceNameEache").val(),
			"minPrice":$("#minPrice").val(),
			"maxPrice":$("#maxPrice").val(),
			"minCreatetime":$("#minCreatetime").val(),
			"maxCreatetime":$("#maxCreatetime").val(),
		}
	})
}
$(function(){
	chaxun();
})
	function chaxun(){
	$('#tb_callList').bootstrapTable({
        url: '<%=request.getContextPath()%>/acc/getProvincesCallList.html',         //请求后台的URL（*）
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
            title: '省份名称'
        }, {
            field: 'interface_efficiency',
            title: '接口效率'
        },{
            field: 'request_message',
            title: '请求报文'
        },{
            field: 'interface_Protocol',
            title: '接口协议'
        },{
            field: 'id',
            title: '操作',
            formatter:function(value,row,index){
                return "<input type='button' onclick='delProvincesCall(\""+value+"\")' value='删除' class='btn btn-danger'/>";
            }
        }]
    });
	}
function delProvincesCall(id) {
    $.ajax({
        url:"<%=request.getContextPath()%>/acc/deleteAgreementsById.html",
        dateType:"post",
        data:{"id":id},
        success:function(data){
            if(data=="ok"){
                $('#tb_agreementsList').bootstrapTable('refresh');
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