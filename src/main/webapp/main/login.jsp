<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<script language="javascript" src="/platform/static/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="/platform/static/js/homepage.js"></script>
<link rel="stylesheet" href="/platform/static/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="/platform/static/css/homepage.css" />
<meta name="viewport" content="width=device-width,height=device-height, initial-scale=1.0">
<style type="text/css">
            html,body { height: 100%;width:100%;}
</style>
<title>login</title>
</head>

<body style="background-image:url(/platform/static/pic/loginBG.jpg);background-size:cover;">
<div style="padding-left:0px;padding-right:0px;"></div>
<div id="Login" style="padding-left:0px;padding-right:0px;height:250px; width:380px; position: absolute;top: 50%;left: 50%;-webkit-transform: translate(-50%, -50%);-moz-transform: translate(-50%, -50%);
                       -ms-transform: translate(-50%, -50%);-o-transform: translate(-50%, -50%);transform: translate(-50%, -50%);border:1px solid #888; background-color:white;">
<div id="loginheader">&nbsp;&nbsp;<img src="/platform/static/pic/LOGO2.png" width="25" height="25" style="vertical-align:middle"/>&nbsp;&nbsp;�ѱȿƼ�</div>
<div style="font-family:Ƽ��-��;font-size:18px;margin-left:10%;margin-top:5%;">
�˺ţ�
<input type="text" class="input" id="loginaccount" size=20 value="�������˺�" onfocus="this.value = ''"><br/>

���룺
<input type="password" class="input" id="loginpassword" size=20 value="����������" onfocus="this.value = ''"><br/>

<!-- 
<a href="" style="font-family:Ƽ��-��;font-size:10px;color:blue;text-decoration:none;padding-left:45%;">ע��һ�����˺�</a>
<a href="" style="font-family:Ƽ��-��;font-size:10px;color:blue;text-decoration:none;paddin-left:5%;">�������룿</a><br/>
 -->
<input type="submit" value="��¼" class="submit" style="width:50%;margin-left:20%;background-color:#0e9c76; border-radius:8px;" onclick="login();">
</div>
</div>
		
</body>
</html>