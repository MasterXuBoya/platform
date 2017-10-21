<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<link rel="stylesheet" type="text/css" href="/platform/static/css/charge.css"/>
<script type="text/javascript" src="/platform/static/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="/platform/static/js/charge.js"></script>
<title>recharge</title>
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

&nbsp;&nbsp;&nbsp;&nbsp;充值金额：
<input type="text" id="money" size=18 value="请输入充值金额" style="color:#6a6969;border-style:solid;border-color:#0e9c76;border-width:1.5px;height:30px;width:15.3%;padding-left:10px;outline:none;font-size:16px;"
	   onfocus="this.value = ''" onkeyup="value=value.replace(/[^\d]/g,'')">&nbsp;&nbsp;元
<input type="submit" value="充值" onclick="recharge()" class="cbutton" style="background-color:#0e9c76;margin-left:2.8%;">
</div>
</body>
</html>