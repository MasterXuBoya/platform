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
            width:100%;
            height:100%;
            position:absolute;
            text-align:left;
            margin-left:32%;
            margin-top:0;
        }
        div.fc1{
            margin-top:0%;
            margin-left:47%;
        }
        .fl .p{
            display:inline-block;
            font-size:21px;
            color:rgb(102,102,102);
        }
        .fc .n{
            display:inline-block;
            font-size:21px;
            color:rgb(0,0,0);
            margin-top:0.8%;
        }
        .fc .n1{
            display:inline-block;
            font-size:32px;
            color:rgb(14,156,118);
        }
        body{
            background-color:rgb(255,255,255)
        }
        button.mainbutton{
            -webkit-appearance:button;
            height:50px;
            margin-top:15%;
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
        div.moveup{
            margin-top:-6%;
            margin-bottom:-4%;
        }
        div.col-down{
            margin-top:3%;
            font-size:120%;
            color:#888888;
        }
        div.col-down1{
            margin-top:1%;
            font-size:120%;
            color:#888888;
        }
    </style>
    <script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
    <script type="text/javascript" src="http://lib.sinaapp.com/js/jquery/1.10.1/jquery-1.10.1.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
<div align = "center">
    <litop><img src="/static/pic/titleall.png" width = "100%" height = "150%" align="center"/>
    </litop>
</div>
<div id="id1" style="width:100%;height:20%;margin-bottom:3%; padding-right:-5%;">
    <div id="id2" style="margin-top:3%;margin-left:5%;width:35%;height:20%;float:left; display:inline-block;font-size:20px;color:rgb(102,102,102);"><b>查询寝室：</b></div>
    <div id="id2" style="margin-top:3%;margin-left:0%;width:55%;height:20%;float:left; display:inline-block;font-size:20px;color:rgb(102,102,102);">${campus}校区-${building}舍-${room}</div>
    <div id="id4" style="clear:both"></div>
</div>
<div class="container">
    <div class="row clearfix">
        <div class="col-xs-12 column moveup">
            <hr />
        </div>
    </div>
    <div class="row clearfix">
        <div id="id1" style="width:100%;height:20%;margin-bottom:3%; padding-right:-5%;">
            <div id="id2" style="margin-top:3%;margin-left:5%;width:50%;height:20%;float:left; display:inline-block;font-size:20px;color:rgb(102,102,102);"><b>现金账户余额：</b></div>
            <div id="id2" style="margin-top:1.5%;margin-left:0%;width:40%;height:20%;float:left; display:inline-block;font-size:26px;color:rgb(8,138,122);">${remain}元</div>
            <div id="id4" style="clear:both"></div>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-xs-12 column">
            <button type="button" class="btn btn-default btn-block mainbutton" onclick="onSubmit()">充值</button>
        </div>
    </div>
</div>
<script>
    function onSubmit(){
        location.href ='/paybill';
        return;
    }
</script>


</body>
</html>