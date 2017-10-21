<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>dairy</title>
<link rel="stylesheet" type="text/css" href="/platform/static/css/warning.css"/>
<link rel="stylesheet" type="text/css" href="/platform/static/css/table.css"/>
<script language="javascript" src="/platform/static/js/jquery-3.2.1.min.js"></script>
<script language="javascript" src="/platform/static/js/inquiry.js"></script>
<script type="text/javascript" src="/platform/static/js/jPage.js"></script>
<link rel="stylesheet" type="text/css" href="/platform/static/css/jPage.css"/>
</head>

<body onload="loadtime();">

<div style="margin-top:20px;margin-left:2%;font-family:萍方-简;">
选择时间：
<input type="datetime-local" id="start" class="time" value="年月日">
-
<input type="datetime-local" id="end" class="time" value="年月日">

<!-- 暂无
&nbsp;&nbsp;&nbsp;&nbsp;选择日志类型：
<span><select id="iselect" name="type" style="font-size:14px">  
    <option value="1">操作</option>  
    <option value="2">异常告警</option>  
</select> </span>
-->
<input type="submit" value="查询" class="ibutton" onclick="dairyquery()" style="margin-left:15px">
</div>

<!-- 加载表格  -->
<div  id="information" style="table-layout:fixed;width:96%;height:50px;margin-left:2%;margin-top:20px;">
<div style="width:100%;" id="theaddiv">
<table border="1" id="thead" style="display:none;">
    <tr>
	<th style="width:20%">时间</th>
	<th style="width:20%">操作员</th>
    <th style="width:60%">日志信息</th>
    </tr>
</table>
</div>

<!-- 填充数据的表格  -->
<div style="auto" id="tbodydiv">
<table border="1" id="table" style="display:none;"></table>
<!-- 分页导航  -->
<div class="holder" style="text-align:center"></div>
</div>
</div>
</body>
</html>