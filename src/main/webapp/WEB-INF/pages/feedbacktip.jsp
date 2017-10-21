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
        body{
            background-color:rgb(235,235,235)
        }
        button.mainbutton{
            -webkit-appearance:button;
            height:50px;
            margin-top:1%;
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
        div.col-down{
            margin-top:5%;
            font-size:150%;
            color:rgb(102,102,102);
        }
    </style>
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script  type="text/javascript">
        window.onload = function(){
            var a = "success";
            if(a=="success"){
                document.getElementById("showmessage").innerHTML=" <span class='p'><b>您的反馈已提交，我们会尽快处理，祝您生活愉快！</b></span>";
            }
            else{
                document.getElementById("showmessage").innerHTML=" <span class='p' ><b>您的反馈提交出现问题，请重新提交！</b></span>";
            }
        }
    </script>
</head>
<body>
<div align = "center">
    <litop><img src="/static/pic/titleall.png" width = "100%" height = "150%" align="center"/>
    </litop>
</div>
<div class="container">

    <div class="row clearfix">
        <div class="col-xs-12 column col-down">
            <div class="fl" id="showmessage">

            </div>
        </div>
    </div>

</div>

</body>
</html>