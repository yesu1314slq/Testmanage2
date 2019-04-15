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
	<link rel="stylesheet" href="<%=request.getContextPath()%>/static/js/bootstrap-3.3.7-dist/bootstrap-treeview-master/src/css/bootstrap-treeview.css">
	<script type="text/javascript" src="<%=request.getContextPath()%>/static/js/bootstrap-3.3.7-dist/bootstrap-treeview-master/src/js/bootstrap-treeview.js"></script>
	<link href="<%=request.getContextPath()%>/static/js/bootstrap-3.3.7-dist/bootstrap-addtabs/bootstrap.addtabs.css" rel="stylesheet" />
	<script src="<%=request.getContextPath()%>/static/js/bootstrap-3.3.7-dist/bootstrap-addtabs/bootstrap.addtabs.min.js"></script>

<script src="<%=request.getContextPath()%>/static/js/echarts/echarts.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>首页</title>
</head>
<body>
<nav class="navbar navbar-inverse">
	 	<div class="container-fluid">
	    <div class="navbar-header">
	      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
	        <span class="sr-only">Toggle navigation</span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	      </button>
	      <a class="navbar-brand" href="#">欢迎${staff.name}登录</a>
	      <a class="navbar-brand" href="<%=request.getContextPath()%>/login/logout.html">注销</a>
	    </div>
	  </div>
</nav>
	<div class='row'>
		<div class="col-md-2">
		<!--treeview 插件树-->
		<shiro:hasPermission name="user:create">  
		 <shiro:principal/><div id="tree"></div><br/>  
		</shiro:hasPermission>  
			                  				
		</div>
		<div class="col-md-10">
		<!--右侧tab页--->
			 <div id="tabs">
                   <!-- Nav tabs -->
                 <ul class="nav nav-tabs" role="tablist">
                     <li role="presentation" class="active">
                         <a href="#home" aria-controls="home" role="tab" data-toggle="tab">欢迎</a></li>
                 </ul>
                 <!-- Tab panes -->
                 <div class="tab-content">
                     <div role="tabpanel" class="tab-pane active" id="home">
                     	<div id="productBar" style="width:400px;height:400px;float:left"></div>
                     	<div id="productPinBar" style="width:400px;height:400px;float:left"></div>
                     </div>
                 </div>
	         </div>
		</div>
	</div>
</body>
<script type="text/javascript">
function getTree() {
	var shu="";
	 $.ajax({
		 url:"<%=request.getContextPath()%>/tree/getTree.html",
		 type:"post",
		 dateType:"json",
		 async:false,
		 success:function(data){
			 shu=data;
		 },error:function(){2
			 alert("树获取错误");
		 }
	 })
	 return shu;
}
$('#tree').treeview({  
    data:getTree(), 
    onNodeSelected: function(event, data) {
		$.addtabs({iframeHeight:580})
		if(data.url!=null&&""!=data.url){
			if(!$.addtabs('exists',data.text)){
				$.addtabs.add({
					 "id": data.id,
					 "title": data.text,
					 "url": "<%=request.getContextPath()%>"+data.url,
					})
			}
		}
		
	}
});
</script>
</html>