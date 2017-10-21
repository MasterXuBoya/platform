<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/5/9
  Time: 11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="content-type" content="text/html;charset=utf-8"/>
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
        p.labelnew{
            font-family:PingFangSC-Regular, sans-serif;
            font-size:135%;
            color:rgb(136,136,136);
            margin-top:6%;
        }
        body{
            background-color:rgb(255,255,255)
        }
        div.moveup{
            margin-top:-5%;
        }
        input.changeinput{
            margin-top:3%;
            margin-bottom:2%;
            font-size:110%;
            text-align:center;
            padding-top:22%;
            padding-bottom:22%;
            color:rgb(102,102,102);
            background-color:rgb(239,239,239);
            border-radius:6px;
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
        .fl.p{
            display:inline-block;
            font-size:21px;
            color:rgb(102,102,102);
        }
        .fc.n{

            display:inline-block;
            font-size:21px;
            color:rgb(8,138,122);
        }
        .fc.bigmoney{

            display:inline-block;
            font-size:35px;
            color:rgb(8,138,122);
            margin-top:-3%;
        }
        body{
            background-color:rgb(255,255,255)
        }
        span.cname{
            display:inline-block;
            height:27px;
            text-align:left;
            line-height:16px;
            font-size:21px;
            color:rgb(8,138,122);

        }
        div.movedown{
            margin-top:1%;
        }
        button.mainbutton{
            -webkit-appearance:button;
            height:50px;
            margin-top:10%;
            font-size:170%;
            color:rgb(255,255,255);
            background-color:#089a7a;
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
        button.moveup{
            margin-top:5%;
            background-color:rgb(233,233,233);
            color:rgb(102,102,102);
        }
        .moveup:hover{
            background-color:rgb(233,233,233);
            color:rgb(102,102,102);
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
<div class="container">
    <div class="row clearfix">
        <div class="col-xs-12 column">
            <p class="labelnew">
                订单详情
            </p>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-xs-12 column moveup">
            <hr />
        </div>
    </div>
    <div class="row clearfix">
        <div id="id1" style="width:100%;height:20%;margin-bottom:3%; padding-right:-5%;">
            <div id="id2" style="margin-top:3%;margin-left:5%;width:33%;height:20%;float:left; display:inline-block;font-size:20px;color:rgb(102,102,102);"><b>充值寝室：</b></div>
            <div id="id2" style="margin-top:3%;margin-left:0%;width:60%;height:20%;float:left; display:inline-block;font-size:20px;color:rgb(8,138,122);"><b> ${campus}校区-${building}舍-${room}</b></div>
            <div id="id4" style="clear:both"></div>
        </div>
    </div>
    <div class="row clearfix movedown">

        <div id="id1" style="width:100%;height:20%;margin-bottom:3%; padding-right:-5%;">
            <div id="id2" style="margin-top:3%;margin-left:5%;width:33%;height:20%;float:left; display:inline-block;font-size:20px;color:rgb(102,102,102);"><b>消费项目：</b></div>
            <div id="id2" style="margin-top:3%;margin-left:0%;width:60%;height:20%;float:left; display:inline-block;font-size:20px;color:rgb(8,138,122);"><b>智能电表充值</b></div>
            <div id="id4" style="clear:both"></div>
        </div>
    </div>
    <div class="row clearfix movedown">
        <div id="id1" style="width:100%;height:20%;margin-bottom:3%; padding-right:-5%;">
            <div id="id2" style="margin-top:3%;margin-left:5%;width:33%;height:20%;float:left; display:inline-block;font-size:20px;color:rgb(102,102,102);"><b>消费金额：</b></div>
            <div id="money" style="margin-top:3%;margin-left:0%;width:60%;height:20%;float:left; display:inline-block;font-size:20px;color:rgb(8,138,122);">
                <b>${money}元</b>
            </div>
            <div id="id4" style="clear:both"></div>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-xs-12 column">
            <button type="button" class="btn btn-default btn-block mainbutton" onclick="callpay()">立即充值</button>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-xs-12 column">
            <button type="button" class="btn btn-default btn-block mainbutton moveup" onclick="goBack()">取消</button>
        </div>
    </div>
</div>

</body>
</html>