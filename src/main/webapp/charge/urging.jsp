<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<link rel="stylesheet" type="text/css" href="/platform/static/css/table.css"/>
<link rel="stylesheet" type="text/css" href="/platform/static/css/charge.css"/>
<script type="text/javascript" src="/platform/static/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="/platform/static/js/charge.js"></script>
<script type="text/javascript" src="/platform/static/js/jPage.js"></script>
<link rel="stylesheet" type="text/css" href="/platform/static/css/jPage.css"/>
<title>urging</title>
</head>

<body onload="loadbr();">
<!-- 信息选择栏（选择楼号等） -->
<div style="font-family:萍方-简;font-size:16px;height:66px;line-height:66px;width:99.6%px;background-color:white;vertical-align:middle;margin-top:10px;margin-left:1.9%;">
楼号：
<span><select class="cchoice" id="building" onchange="changeroom();"> 
	<option value="all">全部</option>  
</select> </span>

&nbsp;&nbsp;室号：
<span><select class="cchoice" id="room"> 
	<option value="all">全部</option>  
</select> </span>

<input type="submit" value="查询" onclick="urgingquery()" class="cbutton">
<input type="submit" value="查询欠费用户" onclick="allurgingquery()" class="cbutton" style="width:25%;max-width:130px;">
</div>


<!-- 加载表格  -->
<div  id="information" style="table-layout:fixed;width:96%;height:auto;margin-left:2%;margin-top:5px;">
<div style="width:100%;" id="theaddiv">
<table border="1" id="thead" style="display:none;">
    <tr>
    <th style="width:5%"><input type="checkbox" id="all" onclick="checkall()" /></th>
    <th style="width:31.67%">楼号</th>
    <th style="width:31.67%">室号</th>
    <th style="width:31.67%">当前余额</th>
    </tr>
</table>
</div>

<!-- 填充数据的表格  -->
<div style="height:310px" id="tbodydiv">
<table border="1" id="table" style="display:none;"></table>
<!-- 分页导航  -->
<div class="holder" style="text-align:center"></div>
</div>
</div>

<!-- 催费模板  -->
<div style="font-family:萍方-简;font-size:14px;color:#6a6969;margin-left:2%;">
催费内容：<br/>
<textarea name="urging" style="font-family:萍方-简;font-size:12px;color:#6a6969;width:97%;height:100px;margin-top:5px;line-height:15px;border:solid 1px #0e9c76;outline:none;padding-top:5px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;您的电力账户已欠费，请尽快缴费!</textarea>
<br/>
<input type="submit" value="催费下发" onclick="urging()" class="cbutton" style="background-color:#0e9c76;margin-top:5px;float:right;margin-right:3%;min-width:80px;">
</div>
</body>
</html>