<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<link rel="stylesheet" type="text/css" href="/platform/static/css/warning.css"/>
<link rel="stylesheet" type="text/css" href="/platform/static/css/table.css"/>
<script language="javascript" src="/platform/static/js/jquery-3.2.1.min.js"></script>
<script language="javascript" src="/platform/static/js/inquiry.js"></script>
<script language="javascript" src="/platform/static/js/homepage.js"></script>
<script type="text/javascript" src="/platform/static/js/jPage.js"></script>
<link rel="stylesheet" type="text/css" href="/platform/static/css/jPage.css"/>
<title>data</title>
</head>
<body onload="Loadcookiebr();loadbr();loadtime();">
<!-- ��Ϣѡ������ѡ��¥�ŵȣ� -->
<div style="font-family:Ƽ��-��;font-size:16px;height:66px;line-height:66px;width:99.6%px;background-color:white;vertical-align:middle;margin-top:-4px;margin-left:2%;">
¥�ţ�
<span><select class="ichoice" id="building" style="font-size:16px;" onchange="changeroom();">  
	<option value="all">ȫ��</option>
</select> </span>

&nbsp;&nbsp;�Һţ�
<span><select class="ichoice" id="room" style="font-size:16px;"> 
	<option value="all">ȫ��</option>  
</select> </span>

&nbsp;&nbsp;&nbsp;&nbsp;ѡ��ʱ�䣺
<input type="datetime-local" id="start" class="time" value="������">
-
<input type="datetime-local" id="end" class="time" value="������">
<input type="submit" value="��ѯ" class="ibutton" onclick="dataquery()">
</div>

<!-- ���ر��  -->
<div  id="information" style="table-layout:fixed;width:96%;height:150px;margin-left:2%;margin-top:0px;">
<div style="width:100%;" id="theaddiv">
<table border="1" id="thead" style="display:none;">
    <tr>
    <th style="width:16.6%">ʱ��</th>
    <th style="width:16.6%">¥��</th>
    <th style="width:16.6%">�Һ�</th>
    <th style="width:16.6%">��ѹ</th>
    <th style="width:16.6%">����</th>
    <th style="width:16.6%">����</th>
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