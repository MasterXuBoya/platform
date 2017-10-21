<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<link rel="stylesheet" type="text/css" href="/platform/static/css/charge.css"/>
<link rel="stylesheet" type="text/css" href="/platform/static/css/table.css"/>
<script type="text/javascript" src="/platform/static/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="/platform/static/js/payment.js"></script>
<script type="text/javascript" src="/platform/static/js/charge.js"></script>
<script type="text/javascript" src="/platform/static/js/jPage.js"></script>
<link rel="stylesheet" type="text/css" href="/platform/static/css/jPage.css"/>
<title>payment</title>
</head>


<body onload="loadbr();loadtime();">
<!-- 信息选择栏（选择楼号等） -->
<div style="font-family:萍方-简;font-size:16px;height:66px;line-height:66px;width:99.6%px;background-color:white;vertical-align:middle;margin-top:10px;margin-left:1.9%;">
楼号：
<span><select class="cchoice" id="building" name="building" onchange="changeroom();" style="width:8%;">
	<option value="all">全部</option>
</select> </span>

&nbsp;&nbsp;室号：
<span><select class="cchoice" id="room" name="room"  style="width:8%;">
	<option value="all">全部</option>  
</select> </span>

&nbsp;&nbsp;查询时间：
<input type="datetime-local" class="time" step="60" id="start" value="年月日">
-
<input type="datetime-local" class="time" step="60" id="end" value="年月日">

<input type="submit" value="查询" onclick="paymentquery()" class="cbutton">
</div>



<!-- 原时间选择区域
<div style="margin-left:20px;">
查询时间：
<input type="date" class="time" min="2013-01-01" value="年月日">
-
<input type="date" class="time" min="2013-01-01" value="年月日">

<button id="three" class="select" onclick="changebacka();" style="margin-left:15px;">
近三月
</button>

<button id="half" class="select" onclick="changebackb();">
近半年
</button>

<button id="year" class="select" onclick="changebackc();">
近一年
</button>
</div>
-->

<!-- 加载表格  -->
<div  id="information" style="table-layout:fixed;width:96%;height:auto;margin-left:2%;margin-top:20px;">
<div style="width:100%;" id="theaddiv">
<table border="1" id="thead" style="display:none;">
    <tr>
    <th style="width:20%">缴费时间</th>
    <th style="width:20%">楼号</th>
    <th style="width:20%">室号</th>
    <th style="width:20%">缴费金额</th>
    <th style="width:20%">当前余额</th>
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