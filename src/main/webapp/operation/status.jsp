<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<link rel="stylesheet" type="text/css" href="/platform/static/css/operation.css"/>
<link rel="stylesheet" type="text/css" href="/platform/static/css/table.css"/>
<script type="text/javascript" src="/platform/static/js/table.js"></script>
<script type="text/javascript" src="/platform/static/js/operation.js"></script>
<script type="text/javascript" src="/platform/static/js/jquery-3.2.1.min.js"></script>
<title>communication</title>
<title>status</title>
</head>


<body  onload="cb()">
<div style="font-family:萍方-简;font-size:16px;height:66px;line-height:66px;width:99.6%px;background-color:white;vertical-align:middle;margin-top:10px;margin-left:2%;">

IMEI号：
<span><select class="imeichoice" id="IMEI" name="IMEI">  
    <option value="1">321654978235372</option>  
    <option value="2">296457322374624</option>  
</select> </span>

<input type="submit" value="查询" onclick="statusquery()" class="button">
</div>

<!-- 加载表格  -->
<div  style="width:96%;height:300px;margin-top:5px;margin-left:2%;">
<table border="1" id="thead" >
    <tr>
    <th style="width:20%">IMEI号</th>
    <th style="width:80%">运行状态</th>
    </tr>
</table>

<table border="1" id="table" >
    <tr>
    <td style="width:20%">3</td>
    <td style="width:80%">4</td>
    </tr>
    <tr>
    <td>5</td>
    <td>6</td>
    </tr>
</table>
</div>
</body>
</html>