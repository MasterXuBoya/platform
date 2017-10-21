<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<link rel="stylesheet" type="text/css" href="/platform/static/css/inquiry.css"/>
<script type="text/javascript" src="/platform/static/js/inquiry.js"></script>
<title>inquiry</title>
<style type="text/css">
            html,body { height: 96%; width:99.5%;}
</style>
</head>


<body style="background-color:#efeff4;" onload="load()">

<!-- 菜单栏的3个按钮 -->
<div>
<a href="/platform/inquiry/warning.jsp" target="i_section">
<button id="warning" class="imenu" onclick="changebacka();" style="background-color:#066b65;font-size:16px;color:white;margin-left:-0.5%;">
异常告警
</button>
</a>

<a href="/platform/inquiry/data.jsp" target="i_section" name="data">
<button id="data" class="imenu" onclick="changebackb();">
数据查询
</button>
</a>

<a href="/platform/inquiry/dairy.jsp" target="i_section">
<button id="dairy" class="imenu" onclick="changebackc();">
日志查询
</button>
</a>
</div>

<!-- 信息显示栏 -->
<div style="height:100%;width:100%;background-color:white;;margin-left:-1%;padding-left:0px;padding-right:0px;">
<iframe src="/platform/inquiry/warning.jsp" width="100%" height="100%" frameborder="0" name="i_section">
</iframe>
</div>

</body>

</html>