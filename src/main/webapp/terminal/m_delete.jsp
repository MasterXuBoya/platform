<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<script language="javascript" src="/platform/static/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="/platform/static/js/meter.js"></script>
<link rel="stylesheet" type="text/css" href="/platform/static/css/terminal.css" />
<title>m_delete</title>
</head>
<body style="font-family:萍方-简;font-size:16px;line-height:40px;">

<div style="margin-left:2%;margin-top:20px;">
电表位置：
<input type="text" size=18 id="building" value="楼号 例:01" style="color:#6a6969;border-style:solid;border-color:#0e9c76;border-width:1.5px;height:30px;width:158px;padding-left:10px;outline:none;"
	   onfocus="this.value = ''" onkeyup="value=value.replace(/[^\d]/g,'')">
-
<input type="text" size=18 id="room" value="室号 例:101" style="color:#6a6969;border-style:solid;border-color:#0e9c76;border-width:1.5px;height:30px;width:158px;padding-left:10px;outline:none;"
	   onkeyup="value=value.replace(/[^\d]/g,'')" onfocus="this.value = ''">
<input type="submit" value="提交" class="addsubmit" onclick="m_delete()" style="max-width:100px;margin-left:20px;">
</div>

</body>
</html>