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
<div class="col-md-4 col-lg-4 col-sm-2" style="padding-left:0px;padding-right:0px;"></div>
<div id="Login" class="col-md-4 col-lg-4 col-sm-8" style="padding-left:0px;padding-right:0px;top:50%; height:35%; margin-top:-200px; border:1px solid #888; background-color:white;">
    <div id="loginheader">&nbsp;&nbsp;<img src="/platform/static/pic/LOGO2.png" width="25" height="25" style="vertical-align:middle"/>&nbsp;&nbsp;�ѱȿƼ�</div>
    <div style="font-family:Ƽ��-��;font-size:18px;margin-left:10%;margin-top:5%;">
        �˺ţ�
        <input type="text" class="input" id="loginaccount" size=20 value="�������˺�" onfocus="this.value = ''"><br/>

        ���룺
        <input type="password" class="input" id="loginpassword" size=20 value="����������" onfocus="this.value = ''"><br/>

        <a href="" style="font-family:Ƽ��-��;font-size:10px;color:blue;text-decoration:none;padding-left:45%;">ע��һ�����˺�</a>
        <a href="" style="font-family:Ƽ��-��;font-size:10px;color:blue;text-decoration:none;paddin-left:5%;">�������룿</a><br/>

        <input type="submit" value="��¼" class="submit" style="margin-left:5%;background-color:#0e9c76;" onclick="login();">
        <input type="submit" value="�ر�" class="submit" style="background-color:#f2737e;margin-left:10px;" onclick="closeLogin();">
    </div>
</div>

</body>
</html>