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
<title>change</title>
</head>
<body style="font-family:Ƽ��-��;font-size:16px;line-height:40px;">

<div style="margin-left:2%;margin-top:20px;">
ԭ�ն�IMEI�ţ�
<input type="text" id="oldimei" size=18 value="������ԭ�ն˺�" style="color:#6a6969;border-style:solid;border-color:#0e9c76;border-width:1.5px;height:30px;width:18%;min-width:150px;padding-left:10px;outline:none;"
	   onkeyup="value=value.replace(/[^\d]/g,'')" onfocus="this.value = ''"><br>
</div>

<div style="margin-top:20px;margin-left:2%;">
���ն�IMEI�ţ�
<input type="text" id="newimei" size=18 value="���������ն˺�" style="color:#6a6969;border-style:solid;border-color:#0e9c76;border-width:1.5px;height:30px;width:18%;min-width:150px;padding-left:10px;outline:none;"
	   onkeyup="value=value.replace(/[^\d]/g,'')" onfocus="this.value = ''">
<input type="submit" value="�ύ" class="addsubmit" onclick="change()" style="max-width:100px;margin-left:20px;">
</div>

</body>
</html>