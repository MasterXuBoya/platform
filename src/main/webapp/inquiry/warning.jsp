<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<link rel="stylesheet" type="text/css" href="/platform/static/css/warning.css"/>
<link rel="stylesheet" type="text/css" href="/platform/static/css/table.css"/>
<script type="text/javascript" src="/platform/static/js/warning.js"></script>
<script language="javascript" src="/platform/static/js/jquery-3.2.1.min.js"></script>
<script language="javascript" src="/platform/static/js/inquiry.js"></script>
<script type="text/javascript" src="/platform/static/js/jPage.js"></script>
<link rel="stylesheet" type="text/css" href="/platform/static/css/jPage.css"/>
<title>warning</title>
</head>

<body onload="loadtime()">

<div style="margin-left:2%;margin-top:20px;font-family:Ƽ��-��;">
ѡ��ʱ�䣺
<input type="datetime-local" id="start" class="time" step="60" value="������">
-
<input type="datetime-local" id="end" class="time" step="60" value="������">

<input type="submit" value="��ѯ" onclick="warningquery()" class="ibutton">

<!-- ʱ���3����ť  -->
<!--
<button id="week" class="select" onclick="cb();" style="margin-left:20px;">
��һ��
</button>

<button id="month" class="select" onclick="changebackb();">
��һ��
</button>

<button id="year" class="select" onclick="changebackc();">
��һ��
</button>
 -->
</div>

<!-- ���ر��  -->
<div  id="information" style="table-layout:fixed;width:96%;height:30px;margin-left:2%;margin-top:20px;">
<div style="width:100%;" id="theaddiv">
<table border="1" id="thead" style="display:none;">
    <tr>
    <th id="time" style="width:16.6%">ʱ��</th>
    <th id="imei" style="width:16.6%">�ն�IMEI</th>
    <th id="building" style="width:16.6%">¥��</th>
    <th id="room" style="width:16.6%">�Һ�</th>
    <th id="type" style="width:16.6%">�澯����</th>
    <th id="info" style="width:16.6%">�澯��Ϣ</th>
    </tr>
</table>
</div>

<!-- ������ݵı��  -->
<div style="height:auto" id="tbodydiv">
<table border="1" id="table" style="display:none;"></table>
<!-- ��ҳ����  -->
<div class="holder" style="text-align:center"></div>
</div>
</div>
</body>
</html>