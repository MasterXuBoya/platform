<!-- 只具有查询权限的人员 -->

<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script language="javascript" src="/platform/static/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="/platform/static/js/homepage.js"></script>
<meta name="viewport" content="width=device-width,height=device-height, initial-scale=1.0">
<link rel="stylesheet" href="/platform/static/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="/platform/static/css/homepage.css" />
<style type="text/css">
            html,body { height: 100%;max-width:2000px;min-width:1000px;}
</style>
</head>


<body onload="load()">
<!-- 标题栏 -->
<div id="header" class="col-md-12 col-sm-12" style="position:absolute;z-index:1;padding:0;">
<div class="col-md-6 col-sm-6">
&nbsp;&nbsp;&nbsp;<img src="/platform/static/pic/LOGO2.png" width="30" height="30" style="vertical-align:middle;margin-left:-10px;"/>
&nbsp;钛比科技&nbsp;&nbsp;智慧电表管理平台
</div>
<div class="col-md-6  col-sm-6">
<input type="button" id="login" value="欢迎您，" title="点击这里退出登录" onclick="logoff()" style="font-family:萍方-简;font-size:12px;color:white;outline:none;border:none;background:transparent;float:right;">
</div>
</div>

<div style="height:100%;position:absolute;z-index:0;padding-top:65px;width:100%;" >
<!-- 导航栏内的6按钮 -->
<div id="menu" style="height:100%;padding-left:0px;padding-right:0px;" class="col-md-2 col-lg-2 col-sm-3">
<a href="/platform/main/mainpage.jsp" target="section">
<button id="mainpage" class="button" onmouseover="this.className='d_over'" onmouseout="this.className='d_out'" onclick="this.className='d_click';changebackm();" style="background-image:url(/platform/static/pic/click_back.png);color:#066b65;font-weight:bold;background-size:100%;">
&nbsp;&nbsp;
<img src="/platform/static/pic/mainpage.png" style="vertical-align:middle"/>
&nbsp;&nbsp;主页面板
</button>
</a>

<a href="/platform/main/noauthority.jsp" target="section">
<button id="terminal" class="button" onmouseover="this.className='d_over'" onmouseout="this.className='d_out'" onclick="this.className='d_click';changebackt();">
&nbsp;&nbsp;
<img src="/platform/static/pic/terminal management.png" style="vertical-align:middle"/>
&nbsp;&nbsp;采集器管理<br>
</button>
</a>

<a href="/platform/main/noauthority.jsp" target="section">
<button id="meter" class="button" onmouseover="this.className='d_over'" onmouseout="this.className='d_out'" onclick="this.className='d_click';changebackmm();">
&nbsp;&nbsp;
<img src="/platform/static/pic/meter.png" style="vertical-align:middle"/>
&nbsp;&nbsp;电表管理<br>
</button>
</a>


<a href="/platform/main/inquiry.jsp" target="section">
<button id="inquiry" class="button" onmouseover="this.className='d_over'" onmouseout="this.className='d_out'" onclick="this.className='d_click';changebacki();">
&nbsp;&nbsp;
<img src="/platform/static/pic/inquiry.png" style="vertical-align:middle"/>
&nbsp;&nbsp;查询功能<br>
</button>
</a>

<a href="/platform/main/noauthority.jsp" target="section">
<button id="charge" class="button" onmouseover="this.className='d_over'" onmouseout="this.className='d_out'" onclick="this.className='d_click';changebackc();">
&nbsp;&nbsp;
<img src="/platform/static/pic/charge.png" style="vertical-align:middle"/>
&nbsp;&nbsp;费控管理<br>
</button>
</a>

<a href="/platform/main/noauthority.jsp" target="section">
<button id="operation" class="button" onmouseover="this.className='d_over'" onmouseout="this.className='d_out'" onclick="this.className='d_click';changebacko();">
&nbsp;&nbsp;
<img src="/platform/static/pic/operation management.png" style="vertical-align:middle"/>
&nbsp;&nbsp;运行管理<br>
</button>
</a>

<a href="/platform/main/noauthority.jsp" target="section">
<button id="user" class="button" onmouseover="this.className='d_over'" onmouseout="this.className='d_out'" onclick="this.className='d_click';changebacku();">
&nbsp;&nbsp;
<img src="/platform/static/pic/user management.png" style="vertical-align:middle"/>
&nbsp;&nbsp;用户管理<br>
</button>
</a>
</div>


<!-- 右侧页面分块 -->
<div id="rightsection" class="col-md-10 col-lg-10 col-sm-9" style="height:100%;padding-left:0px;padding-right:0px;background-color:#efeff4;">
<iframe src="/platform/main/mainpage.jsp" width="98%" height="98%" frameborder="0" name="section" style="margin-top:1%;margin-left:1%;">
</iframe>
</div>
</div>

</body>
</html>