<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<link rel="stylesheet" type="text/css" href="/platform/static/css/warning.css"/>
<link rel="stylesheet" type="text/css" href="/platform/static/css/table.css"/>
<script language="javascript" src="/platform/static/js/jquery-3.2.1.min.js"></script>
<script language="javascript" src="/platform/static/js/inquiry.js"></script>
<script language="javascript" src="/platform/static/js/homepage.js"></script>
<script type="text/javascript" src="/platform/static/js/jPage.js"></script>
<link rel="stylesheet" type="text/css" href="/platform/static/css/jPage.css"/>
<title>data</title>
</head>
<body onload="Loadcookiebr();loadbr();loadtime();">
<!-- 信息选择栏（选择楼号等） -->
<div style="font-family:萍方-简;font-size:16px;height:66px;line-height:66px;width:99.6%px;background-color:white;vertical-align:middle;margin-top:-4px;margin-left:2%;">
楼号：
<span><select class="ichoice" id="building" style="font-size:16px;" onchange="changeroom();">  
	<option value="all">全部</option>
</select> </span>

&nbsp;&nbsp;室号：
<span><select class="ichoice" id="room" style="font-size:16px;"> 
	<option value="all">全部</option>  
</select> </span>

&nbsp;&nbsp;&nbsp;&nbsp;选择时间：
<input type="datetime-local" id="start" class="time" value="年月日">
-
<input type="datetime-local" id="end" class="time" value="年月日">
<input type="submit" value="查询" class="ibutton" onclick="dataquery()">
</div>

<!-- 加载表格  -->
<div  id="information" style="table-layout:fixed;width:96%;height:150px;margin-left:2%;margin-top:0px;">
<div style="width:100%;" id="theaddiv">
<table border="1" id="thead" style="display:none;">
    <tr>
    <th style="width:16.6%">时间</th>
    <th style="width:16.6%">楼号</th>
    <th style="width:16.6%">室号</th>
    <th style="width:16.6%">电压</th>
    <th style="width:16.6%">电流</th>
    <th style="width:16.6%">电量</th>
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