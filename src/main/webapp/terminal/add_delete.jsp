<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<script language="javascript" src="/platform/static/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="/platform/static/js/terminal.js"></script>
<script type="text/javascript" src="/platform/static/js/homepage.js"></script>
<link rel="stylesheet" type="text/css" href="/platform/static/css/terminal.css" />
<link rel="stylesheet" type="text/css" href="/platform/static/css/table.css"/>
<script type="text/javascript" src="/platform/static/js/jPage.js"></script>
<link rel="stylesheet" type="text/css" href="/platform/static/css/jPage.css"/>
<title>add_delete</title>
</head>

<body style="font-family:萍方-简;font-size:16px;line-height:40px;">
<div style="margin-left:2%;margin-top:20px;">
终端IMEI号：
<input type="text" id="imei" size=18 value="请输入终端号" style="color:#6a6969;border-style:solid;border-color:#0e9c76;border-width:1.5px;height:30px;width:18%;min-width:150px;padding-left:10px;outline:none;"
	   onkeyup="value=value.replace(/[^\d]/g,'')" onfocus="this.value = ''">
<input type="submit" value="增加" onclick="add()" class="addsubmit" style="max-width:100px;min-width:80px;margin-left:20px;">
<input type="submit" value="删除" onclick="remove()" class="addsubmit" style="max-width:100px;min-width:80px;background-color:#f2737e;margin-left:20px;">
<input type="submit" value="查询" class="addsubmit" onclick="query()" style="max-width:100px;min-width:80px;margin-left:20px;">

<!-- 加载表格  -->
<div  id="information" style="table-layout:fixed;width:50%;height:auto;margin-left:100px;margin-top:20px;">
<div style="width:100%;" id="theaddiv">
<table border="1" id="thead" style="display:none;">
    <tr>
    <th style="width:10%">序号</th>
    <th style="width:50%">IMEI号</th>
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

</div>
</body>
</html>