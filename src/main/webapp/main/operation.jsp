<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<link rel="stylesheet" type="text/css" href="/platform/static/css/operation.css"/>
<script type="text/javascript" src="/platform/static/js/operation.js"></script>
<title>operation</title>
<style type="text/css">
            html,body { height: 96%; width:99.5%;}
</style>
</head>

<body>
<!-- �˵�����3����ť -->
<div>
<a href="/platform/operation/run_stop.jsp" target="c_section">
<button id="run_stop" class="menu" onclick="changebackc();" style="background-color:#066b65;font-size:16px;color:white;margin-left:-0.5%;">
�����ͣ
</button>
</a>

<a href="/platform/operation/communication.jsp" target="c_section">
<button id="communication" class="menu" onclick="changebacka();">
ͨ�Ź���
</button>
</a>

<a href="/platform/operation/status.jsp" target="c_section">
<button id="status" class="menu" onclick="changebackb();">
�ն�״̬
</button>
</a>
</div>


<!-- ��Ϣ��ʾ�� -->
<div style="height:100%;width:100%;background-color:white;;margin-left:-1%;padding-left:0px;padding-right:0px;">
<iframe src="/platform/operation/run_stop.jsp" width="100%" height="100%" frameborder="0" name="c_section">
</iframe>
</div>




</body>
</html>