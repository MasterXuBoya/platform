<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/5/9
  Time: 11:48
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
        div.fc{
            width:93.5%;
            height:100px;
            overflow:hidden;
            position:absolute;
            top:0;
            left:4px;
            font-size:13px;
            text-align:right;
        }
        .fc .n{
            margin-top:0.85%;
            display:inline-block;
            font-size:21px;
            color:rgb(8,138,122);
        }
        .fc .d{
            margin-top:3%;
            display:inline-block;
            font-size:20px;
            color:rgb(0,0,0);
        }
        body{
            background-color:rgb(255,255,255)
        }

        div.col-wide{
            width:110%;
            text-align:left;
            margin-left:-10%;
            margin-right:-10%;

            background-color: rgb(208,235,228);
            border-style: solid;
            border-width: 0.5px;
            border-color:rgb(213,212,212);
        }
        div.col-data{
            width:110%;
            text-align:left;
            margin-left:-10%;
            margin-right:-10%;
            background-color: rgb(255,255,255);
            border-style: solid;
            border-width: 0.5px;
            border-color:rgb(213,212,212);
        }
        span.cname{
            display:inline-block;
            margin-top:3%;
            margin-left:11%;
            height:27px;
            text-align:left;
            line-height:16px;
            font-size:21px;
            color:rgb(8,138,122);

        }
        span.dname{
            display:inline-block;
            margin-top:5%;
            margin-left:11%;
            height:33px;
            text-align:left;
            line-height:16px;
            font-size:20px;
            color:rgb(102,102,102);
        }
        span.dname1{
            margin-left:3%;
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
    <script src="/static/js/queryrecord.js"></script>
    <script type="text/javascript">
        window.onload = function(){
            Init();
        }
    </script>
</head>
<body>
<div align = "center">
    <litop><img src="static/pic/titleall.png" width = "100%" height = "150%" align="center"/>
    </litop>
</div>
<table class="table" id = "mytable">
</table>
</body>
</html>