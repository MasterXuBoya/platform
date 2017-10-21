<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<link rel="stylesheet" type="text/css" href="/platform/static/css/operation.css"/>
<link rel="stylesheet" type="text/css" href="/platform/static/css/table.css"/>
<script type="text/javascript" src="/platform/static/js/operation.js"></script>
<script type="text/javascript" src="/platform/static/js/homepage.js"></script>
<script type="text/javascript" src="/platform/static/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="/platform/static/js/jPage.js"></script>
<link rel="stylesheet" type="text/css" href="/platform/static/css/jPage.css"/>
<title>run_stop</title>
</head>

<body onload="Loadcookiebr();loadbr();">
<!-- 信息选择栏（选择楼号等） -->
<div style="font-family:萍方-简;font-size:16px;height:66px;line-height:66px;width:99.6%px;background-color:white;vertical-align:middle;margin-top:10px;margin-left:2%;">
楼号：
<span><select class="choice" id="building" name="building" onchange="changeroom();">   
	<option value="all">全部</option>
</select> </span>

&nbsp;&nbsp;室号：
<span><select class="choice" id="room" name="room">  
	<option value="all">全部</option> 
</select> </span>

<input type="submit" value="查询" onclick="query()" class="button">
<input type="submit" value="开启电表" onclick="start()" class="button" style="margin-left:40px;width:15%;max-width:130px;">
<input type="submit" value="停止电表" onclick="stop()" class="button" style="background:#f2737e;width:15%;max-width:130px;">
</div>

<!-- 加载表格  -->
<div  id="information" style="table-layout:fixed;width:94%;margin-left:2%;margin-top:5px;">
<div style="width:100%;" id="theaddiv">
<table border="1" id="thead" style="display:none">
    <tr>
    <th style="width:5%"><input type="checkbox" id="all" onclick="checkall()"/></th>
    <th style="width:31.6%">楼号</th>
    <th style="width:31.6%">室号</th>
    <th style="width:31.6%">运行状态</th>
    </tr>
</table>
</div>
<!-- 填充数据的表格  -->
<div style="height:auto" id="tbodydiv">
<table border="1" id="table" style="display:none"></table>
<!-- 分页导航  -->
<div class="holder" style="text-align:center"></div>
</div>
</div>
</body>
</html>