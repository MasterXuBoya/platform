<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/5/10
  Time: 19:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0;">
    <title>钛比科技电表服务</title>
    <link href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <style type="text/css">
        litop {
            width: 100%;
            height: 300px;
            margin-bottom: 30px;
        }
        div.col-down{
            margin-bottom:7%;
        }
        div.moveup{
            margin-bottom: -2%;
        }
        div.myline{
            border-top:1px solid #d5d4d4;
            width:100%;
            margin-bottom:3.5%;
            height:1px;
        }
        body{
            background-color:rgb(255,255,255)
        }
        button.mainbutton{
            -webkit-appearance:button;
            height:60%;
            width:80%;
            font-size:100%;
            padding:0;
            color:rgb(255,255,255);
            background-color:rgb(12,157,128);
            border-radius:6px;
        }
        .mainbutton:hover{
            background-color:rgb(12,157,128);
            color:rgb(255,255,255);
        }
        .mainbutton:active{
            position:relative;
            top:1px;
        }
        p.mytext{
            margin-bottom:2%;
        }
        td.money{
            text-align:right;
            width:100px;
        }
        th.tmoney{
            text-align:right;
        }
        tr.main{
            background-color: rgb(208,235,228);
            height:15px;
            font-size:18px;
            color:rgb(8,138,122);
            border-width:0.5px;

        }
        tr.data{
            background-color: rgb(256,256,256);
            font-size:17px;
            color:rgb(102,102,102);
        }
    </style>
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <!-- 引入 echarts.js -->
    <script src="/static/js/echarts.min.js"></script>
    <script src="/static/js/walden.js"></script>
    <script>
        var timeSpan = "${timespan}";
    </script>
    <script src="/static/js/showgraph.js"></script>
    <script type="text/javascript">
        $(document).ready(function(){
            Init();
        });
    </script>
</head>
<body>
<div align = "center">
    <litop><img src="/static/pic/titleall.png" width = "100%" height = "150%" align="center"/>
    </litop>
</div>
<div id="id1" style="width:100%;height:20%;margin-bottom:3%; padding-right:-5%;">
    <div id="id2" style="margin-top:3%;margin-left:3%;width:30%;height:20%;float:left; display:inline-block;font-size:19px;color:rgb(8,138,122);"><p id="time">${timespan}</p></div>
    <div id="id3" style="margin-top:2%;margin-left:27%;width:40%;height:20%;float:left;">
        <button type="button" class="btn btn-default btn-block mainbutton"><p class="mytext" id="changetable" onclick="change()">切换为图表</p></button>
    </div>
    <div id="id4" style="clear:both"></div>
</div>
<div class = "myline"id = "flipline"> </div>
<div id="main" style="height:380%;"></div>
</body>

</html>