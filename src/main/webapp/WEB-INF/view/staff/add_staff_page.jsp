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

<script type="text/javascript" src="<%=request.getContextPath()%>/static/js/bootstrap-3.3.7-dist/bootstrapvalidator/bootstrapValidator.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/static/js/bootstrap-3.3.7-dist/bootstrapvalidator/zh_CN.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/static/js/bootstrap-3.3.7-dist/bootstrapvalidator/bootstrapValidator.min.css">
</head>
<body>
<form id="add_user_from" class="form-horizontal" action="<%=request.getContextPath()%>/login/insertUser.html" method="post">
  <div class="tab-content">
    <div role="tabpanel" class="tab-pane active" id="product">
    	  <div class="form-group">
	    <label class="col-sm-2 control-label">用户姓名</label>
	    <div class="col-sm-6">
	      <input type="text" class="form-control"  placeholder="用户姓名" name="name">
	    </div>
	  </div>
	  <div class="form-group">
	  	<label class="col-sm-2 control-label">用户密码</label>
		<div class="col-md-6">
        	<input type="password" name="pwd" class="form-control" placeholder="用户密码"/>
        </div>
      </div>
	</div>
	  <div class="form-group">
	    <div class="col-sm-offset-2 col-sm-10">
	      <button type="submit" class="btn btn-primary">
	      	<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>保存
	      </button>
	      <button type="reset" class="btn btn-default">
	      	<span class="glyphicon glyphicon-repeat" aria-hidden="true"></span>重置
	      </button>
	      </div>
	    </div>
  </div>
</form>
</body>
<script type="text/javascript">
    $(document).ready(function() {
        $('#add_user_from').bootstrapValidator({
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
                name: {
                    validators: {
                        notEmpty: {
                            message: '不能为空'
                        },
                        regexp: {
                            regexp: /^[\u4e00-\u9fa5_a-zA-Z]+$/,
                            message: '用户名由中文、英文'
                        },
                    }
                },
                pwd:{
                    validators:{
                        notEmpty:{
                            message:"不能为空"
                        },regexp:{
                            regexp:/^[a-zA-Z0-9_\.]+$/,
                            message:"只能是英文、数字、下划线、小数点"
                        }
                    }
                }
            }
        });
    });
</script>

</html>