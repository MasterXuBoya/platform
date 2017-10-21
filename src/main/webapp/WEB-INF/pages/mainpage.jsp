<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/5/7
  Time: 21:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <title>钛比科技电表服务</title>
    <link rel="stylesheet" href="https://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <style type="text/css">
        ul {
            margin-left:5px;
            margin-right:10px;
            margin-top:10px;
        }
        litop {
            width: 100%;
            height: 300px;
            margin-bottom: 15px;
        }
        li {
            width: 45%;
            float: left;
            margin-left:1.5%;
            height: 340px;
            display: inline;
            line-height: 90px;
            color: #fff;
            font-size: x-large;
            word-break:break-all;
            word-wrap : break-word;
            margin-bottom: 12px;
            border-radius: 20px;
            border-style: solid ;
            border-color:rgb(213,212,212);
            border-width:3px;
            padding-top:5%;

        }
        linew {
            width:25%;
            float: left;
            margin-left:25.5%;
            height: 30%;
            display: inline;
            line-height: 110px;
            color: #fff;
            font-size: x-large;
            word-break:break-all;
            word-wrap : break-word;
            padding-top:2%;
        }
        a {
            -webkit-tap-highlight-color: rgba(0,0,0,0);
            text-decoration:none;
            color:#fff;
        }
        a:link{
            -webkit-tap-highlight-color: rgba(0,0,0,0);
            text-decoration:none;
            color:#000;
        }
        a:visited{
            -webkit-tap-highlight-color: rgba(0,0,0,0);
            text-decoration:none;
            color:#fff;
        }
        a:hover{
            -webkit-tap-highlight-color: rgba(0,0,0,0);
            text-decoration:none;
            color:#fff;
        }
        a:active{
            -webkit-tap-highlight-color: rgba(0,0,0,0);
            text-decoration:none;
            color:#fff;
        }
        body{
            background-color:rgb(235,235,235);
            margin:0px;
            padding:0px;
        }
    </style>
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body ontouchstart="">
<div align = "center">
    <litop><img src="/static/pic/titleall.png" width = "100%" height = "150%" align="center"/>
    </litop>
</div>
<div align = "center">
    <litop><img src="/static/pic/imgback.png" width = "5%"/>
    </litop>
</div>
<div align="center">
    <ul>
        <li style="background-color:rgb(255,255,255)">
            <linew>
                <a href="/paybill">
                    <img src="/static/pic/iconpay.png" width = "180%" align="center" style="padding-left:14%;margin-bottom:20%;"/>
                </a>
                <img src="/static/pic/z_wychongzhi.png" width="180%" align="center" style="padding-left:9%;"/>
            </linew>
        </li>
        <li style="background-color:rgb(255,255,255)">
            <linew>
                <a href="/queryrecord">
                    <img src="/static/pic/iconbill.png" width = "180%" align="center" style="padding-left:14%;margin-bottom:20%;"/>
                </a>
                <img src="/static/pic/z_czjilu.png" width="180%" align="center" style="padding-left:9%;"/>
            </linew>
        </li>
        <li style="background-color:rgb(255,255,255)">
            <linew>
                <a href="/personalbalance">
                    <img src="/static/pic/iconquery.png" width = "180%" align="center" style="padding-left:14%;margin-bottom:20%;"/>
                </a>
                <img src="/static/pic/z_yechaxun.png" width="180%" align="center" style="padding-left:9%;"/>
            </linew>
        </li>
        <li style="background-color:rgb(255,255,255)">
            <linew>
                <a href="/electricity">
                    <img src="/static/pic/iconrecord.png" width = "180%" align="center" style="padding-left:14%;margin-bottom:20%;"/>
                </a>
                <img src="/static/pic/z_dlchaxun.png" width="180%" align="center" style="padding-left:9%;"/>
            </linew>
        </li>
        <li style="background-color:rgb(255,255,255)">
            <linew>
                <a href="/feedback">
                    <img src="/static/pic/iconchat.png" width = "180%" align="center" style="padding-left:14%;margin-bottom:20%;"/>
                </a>
                <img src="/static/pic/z_yhfankui.png" width="180%" align="center" style="padding-left:9%;"/>
            </linew>
        </li>
        <li style="background-color:rgb(255,255,255)">
            <linew>
                <img src="/static/pic/iconback.png" width = "180%" align="center" style="padding-left:14%;margin-bottom:20%;" onclick="WeixinJSBridge.call('closeWindow');"/>
                <img src="/static/pic/z_fanhui.png" width="90%" align="center" style="padding-left:58%;"/>
            </linew>
        </li>
    </ul>
</div>
</body>
</html>
