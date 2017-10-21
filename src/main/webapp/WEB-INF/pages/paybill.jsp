<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
        ul { list-style: none; }
        linew {
            width:25%;
            float: left;
            margin-left:25.5%;
            height: 100px;
            display: inline;
            line-height: 100px;
            color: #fff;
            font-size: x-large;
            word-break:break-all;
            word-wrap : break-word;
            padding-top:2%;
        }
        p.label1{
            font-family:PingFangSC-Regular, sans-serif;
            font-size:135%;
            color:rgb(8,138,122);
            margin-top:-1.5%;
        }
        p.labelnew{
            font-family:PingFangSC-Regular, sans-serif;
            font-size:135%;
            color:rgb(8,138,122);
            margin-top:6%;
            margin-bottom:3%;
        }
        p.labelmessage{
            font-family:PingFangSC-Regular, sans-serif;
            font-size:120%;
            color:rgb(136,136,136);
            margin-top:8%;
            margin-bottom:3%;
        }
        p.data{
            font-family:PingFangSC-Regular, sans-serif;
            font-size:160%;
            color:#272727;
            margin-bottom:-2%;
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
            margin-bottom:2%;
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
        button.movedown{
            margin-top:3%;
            margin-bottom:2%;
            font-size:135%;
            color:rgb(102,102,102);
            background-color:rgb(239,239,239);
            border-radius:6px;
        }
        .movedown:hover {
            background-color: #089a7a;
            color:rgb(255,255,255);
        }
        div.panel-moveup{
            margin-top:-3%;
        }
        div.page-heading-up{
            margin-top:-3%;
        }
        div.col-down{
            margin-top:5%;
            font-size:120%;
            color:#888888;
        }
        div.col-wide{
            width:37%;
            margin-right:-5.5%;
            margin-bottom:1%;
        }
        div.col-wide8{
            margin-right:-5.5%;
            margin-bottom:1%;
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
    </style>

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
    <script type="text/javascript" src="http://lib.sinaapp.com/js/jquery/1.10.1/jquery-1.10.1.min.js"></script>
    <script src="/static/js/paybill.js"></script>
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
                充值寝室：
            </p>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-xs-12 column">
            <p class="data">
                ${campus}校区-${building}舍-${room}
            </p>
        </div>
    </div>
    <hr />
    <div class="row clearfix">
        <div class="col-xs-12 column">
            <p class="label1">
                充值金额：
            </p>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-xs-4 column col-wide">
            <button type="button" class="btn btn-default btn-block movedown" onclick="changeTen()">10元</button>
        </div>
        <div class="col-xs-4 column col-wide">
            <button type="button" class="btn btn-default btn-block movedown" onclick="changeTwenty()">20元</button>
        </div>
        <div class="col-xs-4 column col-wide">
            <button type="button" class="btn btn-default btn-block movedown" onclick="changeThirty()">30元</button>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-xs-4 column col-wide">
            <button type="button" class="btn btn-default btn-block movedown" onclick="changeFifty()">50元</button>
        </div>
        <div class="col-xs-4 column col-wide">
            <button type="button" class="btn btn-default btn-block movedown" onclick="changeHundred()">100元</button>
        </div>
        <div class="col-xs-4 column col-wide">
            <button type="button" class="btn btn-default btn-block movedown" onclick="changeTwoHund()">200元</button>
        </div>
        <div class="col-xs-4 column col-wide">
            <input type="text" class="form-control changeinput" id="inputmoney" align="center" onclick="changeNull()"placeholder="输入金额"/>
        </div>
        <div class="col-xs-8 column col-wide8" >
            <p class="label1" id = "showmessage">
            </p>
        </div>

    </div>
    <div class="row clearfix">
        <div class="col-xs-12 column col-down" align="center">
            <p>充值单笔最大限额200元</p>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-xs-12 column">
            <button type="button" class="btn btn-default btn-block mainbutton" onclick="onSubmit()">立即充值</button>
        </div>
    </div>
</div>

</body>
</html>