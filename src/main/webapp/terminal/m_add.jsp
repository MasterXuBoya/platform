<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<link rel="stylesheet" type="text/css" href="/platform/static/css/terminal.css"/>
<script language="javascript" src="/platform/static/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="/platform/static/js/meter.js"></script>
<script type="text/javascript" src="/platform/static/js/homepage.js"></script>
<title>c_add</title>
</head>

<body style="font-family:Ƽ��-��;font-size:16px;" onload="loadmeter();">
<div style="margin-left:2%;margin-top:20px;line-height:40px;">
�ն�IMEI�ţ�
<span><select class="choice" id="imei" style="font-size:16px;min-width:180px;"></select> </span>
</div>

<div style="margin-top:-25px;margin-left:1.8%;">
<div id="information" style="display:inline;">
<div id="add_div">
<br>
����ţ�
<input type="text" name="meterId" class="addmeterId" size=18 value="����������" onfocus="this.value = ''" onkeyup="value=value.replace(/[^\d]/g,'')">
&nbsp;&nbsp;���λ�ã�
<input type="text" name="building" class="addbuilding" size=18 value="¥�� ��:01" onfocus="this.value = ''" onkeyup="value=value.replace(/[^\d]/g,'')">
-
<input type="text" name="room" class="addroom" size=18 value="�Һ� ��:101" onfocus="this.value = ''" onkeyup="value=value.replace(/[^\d]/g,'')">
</div>
</div>

<div style="display:inline;">
<!-- ���Ӻ�ɾ��Ԫ�صİ�ť -->
&nbsp;&nbsp;
<input type="button" value=" " style="background-image:url(/platform/static/pic/terminal/add.png);width:30px;height:30px;border:none;outline:none;cursor:hand;" onclick="add()">
<input type="button" value=" " style="background-image:url(/platform/static/pic/terminal/delete.png);width:30px;height:30px;border:none;outline:none;cursor:hand;margin-left:10px;" onclick="del()">

&nbsp;&nbsp;&nbsp;
<input type="button" value="�ύ" id="addsubmit" class="addsubmit" onclick="m_add()">
</div>
</div>


</body>
</html>