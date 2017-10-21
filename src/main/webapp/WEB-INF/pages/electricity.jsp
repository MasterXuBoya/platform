<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/5/9
  Time: 11:52
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
        p.label1{
            font-family:PingFangSC-Regular, sans-serif;
            font-size:100%;
            margin-left:5%;
        }
        div.fl{
            width:93.5%;
            height:50px;
            position:absolute;
            text-align:left;

        }
        div.fc{
            width:93.5%;
            height:50px;
            position:absolute;
            text-align:left;
            margin-left:32%;

        }
        .fl .p{
            display:inline-block;
            font-size:21px;
            color:rgb(8,138,122);
        }
        .fc .n{
            margin-top:0.5%;
            display:inline-block;
            font-size:21px;
            color:rgb(39,39,39);
        }
        body{
            background-color:rgb(255,255,255)
        }
        div.moveup{
            margin-top:-3%;
        }
        button.mainbutton{
            -webkit-appearance:button;
            height:50px;
            margin-top:5%;
            font-size:170%;
            color:rgb(255,255,255);
            background-color:rgb(12,157,128);
            border-radius:10px;
        }
        .mainbutton:hover{
            background-color: rgb(8,138,122);
            color:rgb(255,255,255);
        }
        .mainbutton:active{
            position:relative;
            top:1px;
        }
        button.movedown{
            margin-top:10%;
            margin-bottom:2%;
            font-size:135%;
            color:rgb(102,102,102);
            background-color:rgb(239,239,239);
            border-radius:6px;
            padding-left:17%;
        }
        button.moveleft{
            padding-left:12%;
        }
        .movedown:hover {
            background-color: #089a7a;
            color:rgb(255,255,255);
        }
        div.moveup{
            margin-top:-6%;
        }
        div.col-down{
            margin-top:3%;
            font-size:120%;
            color:#888888;
        }
        div.col-wide{
            width:37%;
            margin-right:-5.5%;
            margin-bottom:1%;
            margin-top:9%;
        }
        div.col-wide12{
            margin-left:-4.5%;
            font-size:120%;
            margin-top:2%;
        }
        div.col-wide1{
            width:37%;
            margin-right:-5.5%;
            margin-bottom:1%;
            margin-top:-2%;
        }
        div.col-down1{
            margin-top:-1%;
            font-size:120%;
            color:#888888;
        }
    </style>
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="/static/js/electricity.js"></script>

</head>
<body>
<div align = "center">
    <litop><img src="/static/pic/titleall.png" width = "100%" height = "150%" align="center"/>
    </litop>
</div>
<div class="container">
    <div class="row clearfix">
        <div id="id1" style="width:100%;height:20%;margin-bottom:3%;">
            <div id="id2" style="margin-top:3%;margin-left:15px;width:35%;height:20%;float:left; display:inline-block;font-size:21px;color:rgb(8,138,122);"><b>查询寝室：</b></div>
            <div id="id2" style="margin-top:3%;margin-left:0%;width:59%;height:20%;float:left; display:inline-block;font-size:21px;color:rgb(102,102,102);"> ${campus}校区-${building}舍-${room}</div>
            <div id="id4" style="clear:both"></div>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-xs-12 column moveup">
            <hr />
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-xs-12 column col-down1">
            <div class="fl">
                <span class="p" ><b>查询范围:</b></span>
            </div>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-xs-4 column col-wide">
            <button type="button" class="btn btn-default btn-block movedown moveleft" onclick="threeMonth()">3个月内</button>
        </div>
        <div class="col-xs-4 column col-wide">
            <button type="button" class="btn btn-default btn-block movedown" onclick="sixMonth()">半年内</button>
        </div>
        <div class="col-xs-4 column col-wide">
            <button type="button" class="btn btn-default btn-block movedown" onclick="oneYear()">一年内</button>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-xs-4 column col-wide1">
            <button type="button" class="btn btn-default btn-block movedown" onclick="thisYear()">2017年</button>
        </div>
        <div class="col-xs-4 column col-wide1">
            <button type="button" class="btn btn-default btn-block movedown" onclick="lastYear()">2016年</button>
        </div>
        <div class="col-xs-4 column col-wide1"/>
    </div>
</div>
<div class="row clearfix">
    <div class="col-xs-12 column col-wide12" id = "showmessage" >
        <p class = "label1 "><font color="white">请选择查询条件</font></p>
    </div>
</div>
<div class="row clearfix">
    <div class="col-xs-12 column">
        <button type="button" class="btn btn-default btn-block mainbutton" onclick="onSubmit()">查询</button>
    </div>
</div>
</body>
</html>