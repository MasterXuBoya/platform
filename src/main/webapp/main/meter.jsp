<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="/platform/static/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="/platform/static/css/terminal.css"/>
<script type="text/javascript" src="/platform/static/js/meter.js"></script>
<title>meter</title>
<style type="text/css">
            html,body { height: 96%; width:99.5%;}
</style>
</head>


<body style="background-color:#efeff4;">
<!-- 菜单栏的2个按钮 -->
<div>
<a href="/platform/terminal/m_add.jsp" target="t_section" >
<button id="m_add" class="menu" onclick="changebacka();" style="width:10%;background-color:#066b65;font-size:16px;color:white;margin-left:0.15%;margin-top:5px;max-width:130px;min-width:80px;">
电表增加
</button>
</a>

<a href="/platform/terminal/m_delete.jsp" target="t_section">
<button id="m_delete" class="menu" onclick="changebackb();" style="width:10%;max-width:130px;min-width:80px;">
电表删除
</button>
</a>

</div>

<!-- 信息显示栏 -->
<div style="height:100%;width:100%;background-color:white;;margin-left:-1%;padding-left:0px;padding-right:0px;">
<iframe src="/platform/terminal/m_add.jsp" width="100%" height="100%" frameborder="0" name="t_section">
</iframe>
</div>

</body>
</html>