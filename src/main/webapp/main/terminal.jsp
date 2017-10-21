<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<link rel="stylesheet" type="text/css" href="/platform/static/css/terminal.css"/>
<script type="text/javascript" src="/platform/static/js/terminal.js"></script>
<title>terminal</title>
<style type="text/css">
            html,body { height: 96%; width:99.5%;}
</style>
</head>

<body style="background-color:#efeff4;">
<!-- 菜单栏的3个按钮 -->
<div style="margin-top:-8px;">
<a href="/platform/terminal/add_delete.jsp" target="t_section">
<button id="add_delete" onclick="changebacka();" style="background-color:#066b65;font-size:16px;color:white;margin-left:-0.5%;">
采集器增加/删除
</button>
</a>

<a href="/platform/terminal/change.jsp" target="t_section">
<button id="change" class="menu" onclick="changebackb();">
采集器更换
</button>
</a>

<a href="/platform/terminal/frequency.jsp" target="t_section">
<button id="frequency" class="menu" onclick="changebackc();">
采集频率设置
</button>
</a>
</div>

<!-- 信息显示栏 -->
<div style="height:100%;width:100%;background-color:white;;margin-left:-1%;padding-left:0px;padding-right:0px;">
<iframe src="/platform/terminal/add_delete.jsp" width="99%" height="100%" frameborder="0" name="t_section">
</iframe>
</div>

</body>
</html>