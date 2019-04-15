<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<form id="update_account_from" class="form-horizontal" action="<%=request.getContextPath()%>/account/updateAccount.html" method="post">
    <div class="tab-content">
        <div role="tabpanel" class="tab-pane active" id="product">
            <div class="form-group">
                <label  class="col-sm-2 control-label">统一账号</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control" placeholder="统一账号" name="unified_id" value="${account.unified_id}" readonly>
                    <input type="hidden" name="logic_id" value="${account.logic_id}">
                </div>
            </div>
            <div class="form-group">
                <label  class="col-sm-2 control-label">原密码</label>
                <div class="col-sm-6">
                    <input type="password" class="form-control"  name="unified_pwd" placeholder="原密码" value="${account.unified_pwd}">
                </div>
            </div>
            <div class="form-group">
                <label  class="col-sm-2 control-label">新密码</label>
                <div class="col-md-6">
                    <input type="password"  class="form-control" name="unified_new_pwd" placeholder="新密码">
                </div>
            </div>
            <div class="form-group" >
                <label  class="col-sm-2 control-label">确认密码</label>
                <div class="col-md-6">
                    <input type="password" class="form-control" name="unified_confirm_pwd" placeholder="确认密码">
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
    </div>
</form>
</body>
<script type="text/javascript">
    $(document).ready(function() {
        $('#update_account_from').bootstrapValidator({
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
                unified_id:{
                    validators:{
                        notEmpty:{
                            message:"*统一账号不能为空"
                        }
                    }
                },
                unified_pwd: {
                    validators: {
                        notEmpty: {
                            message: "*原密码不能为空"
                        }
                    }
                },
                unified_new_pwd:{
                    validators:{
                        notEmpty:{
                            message:"*新密码不能为空"
                        }
                    }
                },
                unified_confirm_pwd: {
                    validators: {
                        notEmpty: {
                            message: '*确认密码不能为空'
                        },
                        identical: {
                            field: 'unified_new_pwd',
                            message: '*两次输入密码不一致'
                        }
                    }
                }
             }
    });
});
</script>
</html>