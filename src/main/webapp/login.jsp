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
    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/js/bootstrap-3.3.7-dist/bootstrapvalidator/bootstrapValidator.min.css"></head>
<body>
<form  class="form-horizontal" id="login_form">
    <div class="form-group">
        <label class="col-sm-2 control-label">用户登录名称</label>
        <div class="col-sm-6">
            <input type="text" class="form-control" name="name"  placeholder="用户登录名称">
        </div>
    </div>
    <div class="form-group">
        <label  class="col-sm-2 control-label">用户密码</label>
        <div class="col-md-6">
            <input type="password" name="pwd" class="form-control" placeholder="用户密码"/>
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label" >验证码</label>
        <div class="col-sm-2">
            <input class="form-control" name="imgCode" type="text" placeholder="请输入验证码"/>
            <img src="<%=request.getContextPath()%>/imageCode"  id="yanzheng"/>
            <a href="javascript:shuaxin()">看不清楚?换一张</a>
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="button" class="btn btn-primary" onclick="tijiao()">
                <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>登录
            </button>
            <button type="reset" class="btn btn-default">
                <span class="glyphicon glyphicon-repeat" aria-hidden="true"></span>重置
            </button>
            <button type="button" class="btn btn-default" onclick="zhuce()">
                <span class="glyphicon glyphicon-repeat" aria-hidden="true"></span>注册
            </button>
        </div>
    </div>
</form>
</body>
<script type="text/javascript">
    $(document).ready(function() {
        $('#login_form').bootstrapValidator({
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            name: {
                validators: {
                    notEmpty: {
                        message: '不能为空'
                    },
                    regexp: {
                        regexp: /^[\u4e00-\u9fa5_a-zA-Z]+$/,
                        message: '用户名中文、英文'
                    },
                }
            },
            pwd:{
                validators:{
                    notEmpty:{
                        message:"不能为空"
                    },regexp:{
                        regexp:/^[a-zA-Z0-9_\.]+$/,
                        message:'密码只能是英文、数字、下划线、小数点'
                    }
                }
            },
            imgCode: {
                validators: {
                    notEmpty: {
                        message: '不能为空'
                    },
                    regexp: {
                        regexp: /^[0-9]+$/,
                        message: '只能是数字'
                    }
                }
            }
        });
    });
</script>
<script type="text/javascript">
    function shuaxin(){
        $("#yanzheng").attr("src",src="<%=request.getContextPath()%>/imageCode?ret="+ Math.random());
    }
    function zhuce(){
        location.href="<%=request.getContextPath()%>/login/toUserAddPage.html";
    }
    function tijiao(){
        $.ajax({
            url:"<%=request.getContextPath()%>/login/userLogin.html",
            dateType:"json",
            type:"post",
            data:$("#login_form").serialize(),
            success:function(data){
                if(data==1){
                    location.href="<%=request.getContextPath()%>/login/getIndexPage.html";
                }else if(data==0){
                    alert("账号密码不匹配");
                }else{
                    alert("验证码输入不正确")
                }
            },error:function(){
                alert("登录错误")
            }
        })
    }
</script>
</html>