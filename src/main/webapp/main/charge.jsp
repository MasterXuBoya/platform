<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<link rel="stylesheet" type="text/css" href="/platform/static/css/charge.css"/>
<script type="text/javascript" src="/platform/static/js/charge.js"></script>
<script type="text/javascript" src="/platform/static/js/homepage.js"></script>
<title>terminal</title>
<style type="text/css">
            html,body { height: 96%; width:99.5%;}
</style>
</head>

<body style="background-color:#efeff4;" onload="Loadcookiebr();">
<!-- 菜单栏的4个按钮 -->
<div>
<a href="/platform/charge/recharge.jsp" target="c_section">
<button id="recharge" class="menu" onclick="changebackd();"  style="background-color:#066b65;font-size:16px;color:white;margin-left:-0.5%;">
人工充值
</button>
</a>

<a href="/platform/charge/balance.jsp" target="c_section">
<button id="balance" class="menu" onclick="changebacka();">
余额查询
</button>
</a>

<a href="/platform/charge/payment.jsp" target="c_section">
<button id="payment" class="menu" onclick="changebackb();">
缴费查询
</button>
</a>

<a href="/platform/charge/urging.jsp" target="c_section">
<button id="urging" class="menu" onclick="changebackcc();">
催费控制
</button>
</a>
</div>


<!-- 信息显示栏 -->
<div style="height:100%;width:100%;background-color:white;;margin-left:-1%;padding-left:0px;padding-right:0px;">
<iframe src="/platform/charge/recharge.jsp" width="100%" height="100%" frameborder="0" name="c_section">
</iframe>
</div>



</body>
</html>