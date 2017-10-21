<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<link rel="stylesheet" type="text/css" href="/platform/static/css/warning.css"/>
<link rel="stylesheet" type="text/css" href="/platform/static/css/table.css"/>
<script type="text/javascript" src="/platform/static/js/warning.js"></script>
<script language="javascript" src="/platform/static/js/jquery-3.2.1.min.js"></script>
<script language="javascript" src="/platform/static/js/inquiry.js"></script>
<script type="text/javascript" src="/platform/static/js/jPage.js"></script>
<link rel="stylesheet" type="text/css" href="/platform/static/css/jPage.css"/>
<title>warning</title>
</head>

<body onload="loadtime()">

<div style="margin-left:2%;margin-top:20px;font-family:萍方-简;">
选择时间：
<input type="datetime-local" id="start" class="time" step="60" value="年月日">
-
<input type="datetime-local" id="end" class="time" step="60" value="年月日">

<input type="submit" value="查询" onclick="warningquery()" class="ibutton">

<!-- 时间的3个按钮  -->
<!--
<button id="week" class="select" onclick="cb();" style="margin-left:20px;">
近一周
</button>

<button id="month" class="select" onclick="changebackb();">
近一月
</button>

<button id="year" class="select" onclick="changebackc();">
近一年
</button>
 -->
</div>

<!-- 加载表格  -->
<div  id="information" style="table-layout:fixed;width:96%;height:30px;margin-left:2%;margin-top:20px;">
<div style="width:100%;" id="theaddiv">
<table border="1" id="thead" style="display:none;">
    <tr>
    <th id="time" style="width:16.6%">时间</th>
    <th id="imei" style="width:16.6%">终端IMEI</th>
    <th id="building" style="width:16.6%">楼号</th>
    <th id="room" style="width:16.6%">室号</th>
    <th id="type" style="width:16.6%">告警类型</th>
    <th id="info" style="width:16.6%">告警信息</th>
    </tr>
</table>
</div>

<!-- 填充数据的表格  -->
<div style="height:auto" id="tbodydiv">
<table border="1" id="table" style="display:none;"></table>
<!-- 分页导航  -->
<div class="holder" style="text-align:center"></div>
</div>
</div>
</body>
</html>