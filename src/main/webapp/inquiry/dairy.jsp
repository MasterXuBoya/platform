<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>dairy</title>
<link rel="stylesheet" type="text/css" href="/platform/static/css/warning.css"/>
<link rel="stylesheet" type="text/css" href="/platform/static/css/table.css"/>
<script language="javascript" src="/platform/static/js/jquery-3.2.1.min.js"></script>
<script language="javascript" src="/platform/static/js/inquiry.js"></script>
<script type="text/javascript" src="/platform/static/js/jPage.js"></script>
<link rel="stylesheet" type="text/css" href="/platform/static/css/jPage.css"/>
</head>

<body onload="loadtime();">

<div style="margin-top:20px;margin-left:2%;font-family:Ƽ��-��;">
ѡ��ʱ�䣺
<input type="datetime-local" id="start" class="time" value="������">
-
<input type="datetime-local" id="end" class="time" value="������">

<!-- ����
&nbsp;&nbsp;&nbsp;&nbsp;ѡ����־���ͣ�
<span><select id="iselect" name="type" style="font-size:14px">  
    <option value="1">����</option>  
    <option value="2">�쳣�澯</option>  
</select> </span>
-->
<input type="submit" value="��ѯ" class="ibutton" onclick="dairyquery()" style="margin-left:15px">
</div>

<!-- ���ر��  -->
<div  id="information" style="table-layout:fixed;width:96%;height:50px;margin-left:2%;margin-top:20px;">
<div style="width:100%;" id="theaddiv">
<table border="1" id="thead" style="display:none;">
    <tr>
	<th style="width:20%">ʱ��</th>
	<th style="width:20%">����Ա</th>
    <th style="width:60%">��־��Ϣ</th>
    </tr>
</table>
</div>

<!-- ������ݵı��  -->
<div style="auto" id="tbodydiv">
<table border="1" id="table" style="display:none;"></table>
<!-- ��ҳ����  -->
<div class="holder" style="text-align:center"></div>
</div>
</div>
</body>
</html>