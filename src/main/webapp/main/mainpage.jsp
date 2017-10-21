<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<link rel="stylesheet" type="text/css" href="/platform/static/css/mainpage.css" />
<link rel="stylesheet" type="text/css" href="/platform/static/css/font.css" />
<script type="text/javascript" src="/platform/static/js/echarts.js"></script>
<script type="text/javascript" src="/platform/static/js/mainpage.js"></script>
<script type="text/javascript" src="/platform/static/js/jquery-3.2.1.min.js"></script>
<title>mainpage</title>
<style type="text/css">
            html,body { height: 94%;}
</style>
</head>
<body style="background-color:white;" onload="query();querygraph();">

<h1 id="header">24小时数据</h1>

<!-- 3个图文标识  -->

<div class="mark">
<input type="button" style="background-image: url(/platform/static/pic/used.png);height:30px;width:123px;border-style:none;outline:none;" onclick="opendata()">
</div>

<div class="mark">
<input type="button" style="background-image: url(/platform/static/pic/recharge.png);height:30px;width:123px;border-style:none;outline:none;" onclick="openrecharge()">
</div>

<div class="mark">
<input type="button" style="background-image: url(/platform/static/pic/warning.png);height:30px;width:190px;border-style:none;outline:none;" onclick="openwarning()">
</div>

<!-- 3个数字显示  -->
<div class="number" id="power">

</div>

<div class="number" id="payment">

</div>

<div class="number" id="alarm" style="color:#f2737e;">

</div>

<!-- 折线图容器  -->
<div id="main" style="height:70%;width:90%;margin-top:100px;margin-left:5%;" >

</div>

</body>
</html>