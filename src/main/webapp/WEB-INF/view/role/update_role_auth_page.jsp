<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="text/javascript" src="<%=request.getContextPath()%>/static/js/jquery-3.0.0.min.js"></script>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/js/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <script src="<%=request.getContextPath()%>/static/js/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

    <link rel="stylesheet" href="<%=request.getContextPath() %>/static/js/font-awesome-4.5.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/static/js/icheck/skins/all.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/static/js/bootstrap-datetimepicker/css/bootstrap-datetimepicker.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/static/js/zTree/css/metroStyle/metroStyle.css">

    <script type="text/javascript" src="<%=request.getContextPath()%>/static/js/icheck/icheck.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/static/js/zTree/js/jquery.ztree.core.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/static/js/zTree/js/jquery.ztree.excheck.js"></script>
    <title>权限管理页面</title>
</head>
<body>
<div class="container-fluid">
    <div class="panel panel-info">
        <div class="panel-heading">权限列表</div>
        <div class="panel-body">
            <div class="row">
                <div class="col-md-4">
                    <ul id="menuTree" class="ztree"></ul>
                </div>
            </div>
        </div>
        <div class="panel-footer" style="text-align:right;"><a href="#" class="btn btn-primary" role="button" onclick="grantPermission();">赋权限</a></div>
    </div>
</div>
</body>
<
<script !src="">
    var menuTree;
    $(function() {
        initTree();
    })
    function grantPermission() {
        var v_roleId = '${role_id}';
        // 获取菜单树选中的复选框
        var nodes = menuTree.getCheckedNodes(true);
        var v_menuIds = "";
        for (var i = 0; i < nodes.length; i++) {
            var v_node = nodes[i];
            v_menuIds += "," + v_node.id;
        }
        if (v_menuIds.length > 0) {
            v_menuIds = v_menuIds.substring(1);
        }
        $.ajax({
            type:"post",
            url:"<%=request.getContextPath()%>/role/grantPermission.html",
            data:{"role_id":v_roleId,"id":v_menuIds},
            success:function(data) {
                if (data == "success") {
                    window.location.href = "<%=request.getContextPath()%>/role/getRolePage.html";
                }
            }
        })
    }

    function initTree() {
        var setting = {
            check: {
                enable: true
            },
            data: {
                simpleData: {
                    enable: true
                }
            }
        };
        var zNodes = ${menuJson};
        menuTree = $.fn.zTree.init($("#menuTree"), setting, zNodes);
        menuTree.expandAll(true);
    }
</script>
</html>