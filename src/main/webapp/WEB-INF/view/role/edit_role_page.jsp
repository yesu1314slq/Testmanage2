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

<%--<link rel="stylesheet" href="<%=request.getContextPath()%>/static/js/bootstrap-3.3.7-dist/bootstrap-datetimepicker-master/css/bootstrap-datetimepicker.min.css">
<script src="<%=request.getContextPath()%>/static/js/bootstrap-3.3.7-dist/bootstrap-datetimepicker-master/js/moment-with-locales.js" ></script>
<script src="<%=request.getContextPath()%>/static/js/bootstrap-3.3.7-dist/bootstrap-datetimepicker-master/js/bootstrap-datetimepicker.min.js"></script>--%>
</head>
<body>
<form id="update_role_from" class="form-horizontal" action="<%=request.getContextPath()%>/role/updateRole.html" method="post">
    <div class="tab-content">
        <div role="tabpanel" class="tab-pane active" id="product">
            <div class="form-group">
                <label  class="col-sm-2 control-label">角色名称</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control" placeholder="角色名称" name="name" value="${role.name}">
                    <input type="hidden" name="role_id" value="${role.role_id}">
                </div>
            </div>
            <div class="form-group">
                <label  class="col-sm-2 control-label">角色描述</label>
                <div class="col-md-6">
                    <input type="text" name="description" class="form-control" placeholder="角色描述" value="${role.description}"/>
                </div>
            </div>
            <div class="form-group">
                <label  class="col-sm-2 control-label">创建时间</label>
                <div class="col-md-6">
                    <input type="text" name="create_dt" class="form-control" placeholder="创建时间" value="<f:formatDate value="${role.create_dt}" pattern="yyyy-MM-dd"></f:formatDate>"/>
                </div>
            </div>
            <div class="form-group">
                <label  class="col-sm-2 control-label">生效日期</label>
                <div class="col-md-6">
                    <input type="text" name="start_dt" class="form-control" placeholder="生效日期" value="<f:formatDate value="${role.start_dt}" pattern="yyyy-MM-dd"></f:formatDate>"/>
                </div>
            </div>
            <div class="form-group">
                <label  class="col-sm-2 control-label">结束日期</label>
                <div class="col-md-6">
                    <input type="text" name="end_dt" class="form-control" placeholder="结束日期" value="<f:formatDate value="${role.end_dt}" pattern="yyyy-MM-dd"></f:formatDate>"/>
                </div>
            </div>
            <div class="form-group">
                <label  class="col-sm-2 control-label">版本号</label>
                <div class="col-md-6">
                    <input type="text" name="version" class="form-control" placeholder="版本号" value="<f:formatDate value="${role.version}" pattern="yyyy-MM-dd"></f:formatDate>"/>
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
  /* $(function(){
        datepiceker();
    })
    function datepiceker(){
        $('#create_dt').datetimepicker({
            format: 'YYYY-MM-DD',
            locale: 'zh-CN',
            showClear: true,
        });
        $('#start_dt').datetimepicker({
            format: 'YYYY-MM-DD',
            locale: 'zh-CN',
            showClear: true,
        });
        $('#end_dt').datetimepicker({
            format: 'YYYY-MM-DD',
            locale: 'zh-CN',
            showClear: true,
        });
        $('#version').datetimepicker({
            format: 'YYYY-MM-DD',
            locale: 'zh-CN',
            showClear: true,
        });
    }*/
    $(document).ready(function() {
        $('#update_role_from').bootstrapValidator({
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
                            message: '角色名称只能是中文、英文'
                        },
                    }
                },
                description:{
                    validators:{
                        notEmpty:{
                            message:"不能为空"
                        },regexp: {
                            regexp: /^[\u4e00-\u9fa5_a-zA-Z]+$/,
                            message: '角色描述只能是中文、英文'
                        }
                    }
                },
                create_dt:{
                    validators:{
                        notEmpty:{
                            message:"不能为空"
                        }
                    }
                },
                start_dt:{
                    validators:{
                        notEmpty:{
                            message:"不能为空"
                        }
                    }
                },
                end_dt:{
                    validators:{
                        notEmpty:{
                            message:"不能为空"
                        }
                    }
                },
                version:{
                    validators:{
                        notEmpty:{
                            message:"不能为空"
                        }
                    }
                }
            }
        });
    });
</script>
</html>