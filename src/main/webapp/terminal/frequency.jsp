<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<script language="javascript" src="/platform/static/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="/platform/static/js/terminal.js"></script>
<link rel="stylesheet" type="text/css" href="/platform/static/css/terminal.css" />
<script type="text/javascript" src="/platform/static/js/meter.js"></script>
<script type="text/javascript" src="/platform/static/js/homepage.js"></script>
<title>frequency</title>
</head>
<body style="font-family:Ƽ��-��;font-size:16px;line-height:40px;" onload="loadmeter();">

<div style="margin-left:2%;margin-top:20px;line-height:40px;">
�ն�IMEI�ţ�&nbsp;&nbsp;&nbsp;
<span><select class="choice" id="imei" style="font-size:16px;min-width:180px;"></select> </span>
</div>

<div style="margin-left:2%;margin-top:20px;line-height:40px;">
����ʱ�����ã�
<input type="text" id="heartbeattime" size=18 value="����10" style="color:#6a6969;border-style:solid;border-color:#0e9c76;border-width:1.5px;height:30px;width:8%;min-width:50px;padding-left:10px;outline:none;"
	   onkeyup="value=value.replace(/[^\d]/g,'')" onfocus="this.value = ''">&nbsp;��
&nbsp;&nbsp;&nbsp;����ʱ�����ã�
<input type="text" id="missiontime" size=18 value="����600" style="color:#6a6969;border-style:solid;border-color:#0e9c76;border-width:1.5px;height:30px;width:8%;min-width:50px;padding-left:10px;outline:none;"
	   onkeyup="value=value.replace(/[^\d]/g,'')" onfocus="this.value = ''">&nbsp;��
<input type="submit" value="�ύ" class="addsubmit" onclick="frequency()" style="max-width:100px;margin-left:20px;">

</div>

</body>
</html>