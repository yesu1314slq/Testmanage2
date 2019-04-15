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
    <script src="<%=request.getContextPath()%>/static/js/echarts/echarts.min.js"></script>

</head>
<body>
<div class="alert alert-success" role="alert">接口调用成功详情注图</div>
<div>
    <div id="productBar" style="width:800px;height:400px;float:top"></div>
</div>
<div class="alert alert-success" role="alert">接口调用成功详情注图</div>
<div>
    <div id="Bar" style="width:800px;height:400px;float:top"></div>
</div>
</body>
<script type="text/javascript">
    $(function(){
        //初始化echarts报表
        $.ajax({
            url:"<%=request.getContextPath()%>/datareport/getDataReportList.html",
            type:"post",
            dateType:"json",
            success:function(data){
                var myChart = echarts.init(document.getElementById('productBar'));
                var chart = echarts.init(document.getElementById('Bar'));
                data=eval("("+data+")");
                var option = {
                    title : {
                        text: 'ct10000uam-accessmanage',
                        subtext: '各个接口',
                        x:'center'
                    },
                    tooltip : {
                        trigger: 'item',
                        formatter: "{a} <br/>{b} : {c} ({d}%)"
                    },
                    legend: {
                        orient: 'vertical',
                        left: 'left',
                        data:data.legend,
                    },
                    series : [
                        {
                            name: '调用比例',
                            type: 'pie',
                            radius : '55%',
                            center: ['50%', '60%'],
                            data:data.series,
                            itemStyle: {
                                emphasis: {
                                    shadowBlur: 10,
                                    shadowOffsetX: 0,
                                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                                }
                            }
                        }
                    ]

                };
                // 使用刚指定的配置项和数据显示图表。
                myChart.setOption(option);
                chart.setOption(option);
            }
        })
    })
</script>
</html>