<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<form id="update_user_from" class="form-horizontal" action="<%=request.getContextPath()%>/staff/updateStaff.html" method="post">
    <div class="tab-content">
        <div role="tabpanel" class="tab-pane active" id="product">
            <div class="form-group">
                <label  class="col-sm-2 control-label">员工名称</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control" placeholder="用户姓名" name="name" value="${staffmap.name}">
                    <input type="hidden" name="id" value="${staffmap.id}">
                </div>
            </div>
            <div class="form-group">
                <label  class="col-sm-2 control-label">角色名称</label>
                <div class="col-sm-6">
                    <c:forEach var="l" items="${roleList}">
                        <input type="checkbox" name="role_id" value="${l.role_id}" ${l.ben==true?"checked":""}>
                        <label>${l.name}</label>
                    </c:forEach>
                </div>
            </div>
            <div class="form-group">
                <label  class="col-sm-2 control-label">组织ID</label>
                <div class="col-md-6">
                    <input type="text" name="org_id" class="form-control" placeholder="组织ID" value="${staffmap.org_id}"/>
                </div>
            </div>
            <div class="form-group">
                <label  class="col-sm-2 control-label">简拼</label>
                <div class="col-md-6">
                    <input type="text" name="spell" class="form-control" placeholder="简拼" value="${staffmap.spell}"/>
                </div>
            </div>
            <div class="form-group">
                <label  class="col-sm-2 control-label">工号</label>
                <div class="col-md-6">
                    <input type="text" name="staff_number" class="form-control" placeholder="工号" value="${staffmap.staff_number}"/>
                </div>
            </div>
            <div class="form-group">
                <label  class="col-sm-2 control-label">联系电话</label>
                <div class="col-md-6">
                    <input type="text" name="link_tel" class="form-control" placeholder="联系电话" value="${staffmap.link_tel}"/>
                </div>
            </div>
            <div class="form-group">
                <label  class="col-sm-2 control-label">备注</label>
                <div class="col-md-6">
                    <input type="text" name="remark" class="form-control" placeholder="备注" value="${staffmap.remark}"/>
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
        $('#update_user_from').bootstrapValidator({
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
                            message: '用户名只能是中文、英文'
                        },
                    }
                },
                org_id:{
                    validators:{
                        notEmpty:{
                            message:"不能为空"
                        },regexp: {
                            regexp: /^[\u4e00-\u9fa5_a-zA-Z0-9_]+$/,
                            message: '组织ID只能是中文、英文、数字、下划线'
                        }
                    }
                },
                spell:{
                    validators:{
                        notEmpty:{
                            message:"不能为空"
                        },regexp: {
                            regexp: /^[\u4e00-\u9fa5_a-zA-Z0-9_]+$/,
                            message: '简拼只能是中文、英文、下划线'
                        }
                    }
                },
                staff_number:{
                    validators:{
                        notEmpty:{
                            message:"不能为空"
                        },regexp: {
                            regexp: /^[a-zA-Z0-9]+$/,
                            message: '工号只能是英文、数字'
                        }
                    }
                },
                link_tel:{
                    validators:{
                        notEmpty:{
                            message:"不能为空"
                        },regexp: {
                            regexp: /^[0-9]+$/,
                            message: '联系电话只能是数字'
                        }
                    }
                },
                remark:{
                    validators:{
                        notEmpty:{
                            message:"不能为空"
                        },regexp: {
                            regexp: /^[\u4e00-\u9fa5_a-zA-Z]+$/,
                            message: '备注只能是中文、英文'
                        }
                    }
                }
            }
        });
    });
</script>
</html>