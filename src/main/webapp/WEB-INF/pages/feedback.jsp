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
            width:110%;
            margin-top:-5%;
            margin-left:-5%;
            font-size:120%;
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
            font-size:120%;
            color:#888888;
        }
        p.label1{
            font-family:PingFangSC-Regular, sans-serif;
            font-size:90%;
            margin-left:0%;
        }
        p.moveright{
            margin-left:12px;
        }
        div.moveup{
            margin-top:-10%;
            margin-left:-5%;
            margin-bottom:5%;
        }
        textarea.mytext{
            font-size:18px;
            margin-bottom:3%;
        }
        input::-webkit-input-placeholder, textarea::-webkit-input-placeholder {
            color: #000;
        }
        .psection{
            color: #FFC0CB;
        }
    </style>
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
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
        <div class="col-xs-12 column col-down">
            <form role="form" method="post" action="/feedbacktip" id="form" onsubmit="return onSubmit()">
                <div class="form-group">
                    <textarea class="form-control mytext" rows="1" placeholder-class="psection" placeholder="姓名" id="name" name="name"></textarea>
                    <textarea class="form-control mytext" rows="1" placeholder="电话" id="tel" name="tel"></textarea>
                    <textarea class="form-control mytext" rows="8" placeholder="输入详细内容" id="text" name="text"></textarea>
                </div>
                <div class="form-group">
                    <div class="col-xs-12 column col-down">
                        <div class = "moveup"id = "showmessage" >
                            <p class = "label1 "><font color=#EBEBEB>请选择查询条件</font></p>
                        </div>
                        <button type="submit" id="btn" class="btn btn-default mainbutton">提交</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<script>
    var VAR ={
        repeatTemp:[]
    }
    var COM = {
        repeat:function(s,t){//限制执行频率，默认为60秒 允许执行时返回false
            t = t ? t * 1000 : 60000;//毫秒
            var time = microtime();
            if(!VAR.repeatTemp[s]){
                VAR.repeatTemp[s] = time;
                return false;//允许
            }
            else{
                var ts = t - (time - VAR.repeatTemp[s]);
                ts = parseInt(ts/1000);
                if(ts > 0){
                    alert("频率限制：还有 <b>"+ ts +"</b> 秒才可以再执行！");
                    return true;//禁止执行
                }
                else{
                    VAR.repeatTemp[s] = time;//更新时间
                    return false;//允许
                }
            }
        }
    }
    //刷新
    function ref(){
        var btn = COM.repeat('btn');
        if(!btn){alert("可以执行了！");}else{return;}
    }
    //获取毫秒级时间戳
    function microtime(){
        return new Date().getTime();
    }
    function showTip(tipTxt) {
        document.getElementById("showmessage").innerHTML="<p class = 'label1'><font color='grey'>"+tipTxt+"</font></p>";
        setTimeout(function () {
            document.getElementById("showmessage").innerHTML="<p class = 'label1'><font color=#EBEBEB>请选择查询条件</font></p>";
        }, 1000);
    }
    function onSubmit(){
        var name = $("#name").val();
        var tel = $("#tel").val();
        var text=$("#text").val();
        var patrn = /^13[0-9]{9}$|^15[0-9]{9}$|^18[0-9]{9}$/;
        if($.trim(name) == ""){
            showTip('请填写姓名')
            return false;
        }
        if($.trim(tel) == ""){
            showTip('请填写手机号码')
            return false;
        }
        if (!patrn.exec($.trim(tel))) {
            showTip('请正确填写手机号码')
            return false;
        }
        if($.trim(text) == ""){
            showTip('请填写反馈内容')
            return false;
        }
        return true;
    }
</script>
</body>
</html>
