<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<link rel="stylesheet" type="text/css" href="/platform/static/css/user.css"/>
<link rel="stylesheet" type="text/css" href="/platform/static/css/table.css"/>
<script type="text/javascript" src="/platform/static/js/user.js"></script>
<script type="text/javascript" src="/platform/static/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="/platform/static/js/jPage.js"></script>
<link rel="stylesheet" type="text/css" href="/platform/static/css/jPage.css"/>
<title>user</title>
<style type="text/css">
            html,body { height: 96%; width:99.5%;}
</style>
</head>

<body style="background-color:#efeff4;">
<!-- 菜单栏的3个按钮 -->
<div>
<button id="operator" class="menu" onclick="">
操作员管理
</button>
</div>

<!-- 信息显示栏 -->
<div style="height:100%;width:100%;background-color:white;margin-top:0px;margin-left:-1%;">
<div style="margin-left:2.5%;font-family:萍方-简;">
操作员账号：
<input type="text" id="account" size=18 value="例：admin" style="color:#6a6969;border-style:solid;border-color:#0e9c76;border-width:1.5px;height:30px;width:158px;padding-left:10px;outline:none;margin-top:26px;"
	   onfocus="this.value = ''">
&nbsp;&nbsp;操作员姓名：
<input type="text" id="name" size=18 value="例：张三" style="color:#6a6969;border-style:solid;border-color:#0e9c76;border-width:1.5px;height:30px;width:158px;padding-left:10px;outline:none;margin-top:26px;"
	   onfocus="this.value = ''">
<input type="submit" value="查询" class="sub" onclick="query()">
<input type="submit" value="新增" class="sub" onclick="openNew()">
<input type="submit" value="查询全部账户" class="sub" onclick="queryall()" style="width:20%;maxwidth:300px;text-aligh:center;">
</div>

<!-- 加载表格  -->
<div  id="information" style="table-layout:fixed;width:96%;height:auto;margin-left:2.5%;margin-top:20px;">
<div style="width:100%;" id="theaddiv">
<table border="1" id="thead" style="display:none;">
    <tr style="height:35px;">
    <th style="width:18%">操作员账号</th>
    <th style="width:18%">操作员姓名</th>
    <th style="width:18%">电话</th>
    <th style="width:18%">邮箱</th>
    <th style="width:18%">权限</th>
    <th style="width:10%">编辑</th>
    </tr>
</table>
</div>

<!-- 填充数据的表格  -->
<div style="height:auto" id="tbodydiv">
<table border="1" id="table" style="display:none;"></table>
<!-- 分页导航  -->
<div class="holder" style="text-align:center"></div>
</div>
</div>
</div>

<!-- 弹出新增窗口 -->
<script>
function openNew(){
	   document.getElementById("new").style.display="";
	}
function closeNew(){
	   document.getElementById("new").style.display="none";
	}
</script>

<!-- 用户新增窗口 -->
<div id="new" style="display:none; POSITION:absolute; left:400px; top:60px; width:299px; height:380px; border:1px solid #888; background-color:white;position: absolute;top: 50%;left: 50%;-webkit-transform: translate(-50%, -50%);-moz-transform: translate(-50%, -50%);
                       -ms-transform: translate(-50%, -50%);-o-transform: translate(-50%, -50%);transform: translate(-50%, -50%);">
<div class="ttitle">用户新增</div>
<div style="margin-left:30px;margin-top:8px;font-size:14px;">
账号：<input type="text" class="tinput" id="newaccount" size=20 value="请输入账号" onfocus="this.value = ''"><br/>

密码：<input type="password" class="tinput" id="newpassword" size=20 value="请输入密码" onfocus="this.value = ''"><br/>

姓名：<input type="text" class="tinput" id="newname" size=20 value="请输入姓名" onfocus="this.value = ''"><br/>

手机：<input type="text" class="tinput" id="newphone" size=20 value="请输入手机号码" onfocus="this.value = ''"><br/>

邮箱：<input type="text" class="tinput" id="newemail" size=20 value="请输入邮箱" onfocus="this.value = ''"><br/>

权限：
<span><select id="newauthority" class="authority">  
 	<option value="0">初级</option>
    <option value="1">中级</option>  
    <option value="2">高级</option>  
</select> </span>
</div>

<input type="submit" value="保存" class="tbutton" style="margin-left:70px;background-color:#0e9c76;" onclick="newAccount()">
<input type="submit" value="关闭" class="tbutton" style="background-color:#f2737e;" onclick="closeNew()">
</div>

<!-- 弹出编辑窗口 -->
<script>
function openEdit(){
	   document.getElementById("edit").style.display="";
	}
function closeEdit(){
	   document.getElementById("edit").style.display="none";
	}
</script>

<!-- 用户编辑窗口 -->
<div id="edit" style="display:none; POSITION:absolute; left:400px; top:60px; width:299px; height:380px; border:1px solid #888; background-color:white;position: absolute;top: 50%;left: 50%;-webkit-transform: translate(-50%, -50%);-moz-transform: translate(-50%, -50%);
                       -ms-transform: translate(-50%, -50%);-o-transform: translate(-50%, -50%);transform: translate(-50%, -50%);">
<div class="ttitle">用户编辑</div>
<div style="margin-left:30px;margin-top:8px;font-size:14px;">
账号：<input type="text" class="tinput" id="editaccount" size=20 value="请输入账号" onfocus="this.value = ''"><br/>

密码：<input type="password" class="tinput" id="editpassword" size=20 value="请输入密码" onfocus="this.value = ''"><br/>

姓名：<input type="text" class="tinput" id="editname" size=20 value="请输入姓名" onfocus="this.value = ''"><br/>

手机：<input type="text" class="tinput" id="editphone" size=20 value="请输入手机号码" onfocus="this.value = ''"><br/>

邮箱：<input type="text" class="tinput" id="editemail" size=20 value="请输入邮箱" onfocus="this.value = ''"><br/>

权限：
<span><select id="editauthority" class="authority">  
 	<option value="0">初级</option>
    <option value="1">中级</option>  
    <option value="2">高级</option>  
</select> </span>
</div>

<input type="submit" value="保存" class="tbutton" style="margin-left:70px;background-color:#0e9c76;" onclick="EditAccountTrans()">
<input type="submit" value="关闭" class="tbutton" style="background-color:#f2737e;" onclick="closeEdit()">

</div>

</body>
</html>