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
<!-- �˵�����3����ť -->
<div>
<button id="operator" class="menu" onclick="">
����Ա����
</button>
</div>

<!-- ��Ϣ��ʾ�� -->
<div style="height:100%;width:100%;background-color:white;margin-top:0px;margin-left:-1%;">
<div style="margin-left:2.5%;font-family:Ƽ��-��;">
����Ա�˺ţ�
<input type="text" id="account" size=18 value="����admin" style="color:#6a6969;border-style:solid;border-color:#0e9c76;border-width:1.5px;height:30px;width:158px;padding-left:10px;outline:none;margin-top:26px;"
	   onfocus="this.value = ''">
&nbsp;&nbsp;����Ա������
<input type="text" id="name" size=18 value="��������" style="color:#6a6969;border-style:solid;border-color:#0e9c76;border-width:1.5px;height:30px;width:158px;padding-left:10px;outline:none;margin-top:26px;"
	   onfocus="this.value = ''">
<input type="submit" value="��ѯ" class="sub" onclick="query()">
<input type="submit" value="����" class="sub" onclick="openNew()">
<input type="submit" value="��ѯȫ���˻�" class="sub" onclick="queryall()" style="width:20%;maxwidth:300px;text-aligh:center;">
</div>

<!-- ���ر��  -->
<div  id="information" style="table-layout:fixed;width:96%;height:auto;margin-left:2.5%;margin-top:20px;">
<div style="width:100%;" id="theaddiv">
<table border="1" id="thead" style="display:none;">
    <tr style="height:35px;">
    <th style="width:18%">����Ա�˺�</th>
    <th style="width:18%">����Ա����</th>
    <th style="width:18%">�绰</th>
    <th style="width:18%">����</th>
    <th style="width:18%">Ȩ��</th>
    <th style="width:10%">�༭</th>
    </tr>
</table>
</div>

<!-- ������ݵı��  -->
<div style="height:auto" id="tbodydiv">
<table border="1" id="table" style="display:none;"></table>
<!-- ��ҳ����  -->
<div class="holder" style="text-align:center"></div>
</div>
</div>
</div>

<!-- ������������ -->
<script>
function openNew(){
	   document.getElementById("new").style.display="";
	}
function closeNew(){
	   document.getElementById("new").style.display="none";
	}
</script>

<!-- �û��������� -->
<div id="new" style="display:none; POSITION:absolute; left:400px; top:60px; width:299px; height:380px; border:1px solid #888; background-color:white;position: absolute;top: 50%;left: 50%;-webkit-transform: translate(-50%, -50%);-moz-transform: translate(-50%, -50%);
                       -ms-transform: translate(-50%, -50%);-o-transform: translate(-50%, -50%);transform: translate(-50%, -50%);">
<div class="ttitle">�û�����</div>
<div style="margin-left:30px;margin-top:8px;font-size:14px;">
�˺ţ�<input type="text" class="tinput" id="newaccount" size=20 value="�������˺�" onfocus="this.value = ''"><br/>

���룺<input type="password" class="tinput" id="newpassword" size=20 value="����������" onfocus="this.value = ''"><br/>

������<input type="text" class="tinput" id="newname" size=20 value="����������" onfocus="this.value = ''"><br/>

�ֻ���<input type="text" class="tinput" id="newphone" size=20 value="�������ֻ�����" onfocus="this.value = ''"><br/>

���䣺<input type="text" class="tinput" id="newemail" size=20 value="����������" onfocus="this.value = ''"><br/>

Ȩ�ޣ�
<span><select id="newauthority" class="authority">  
 	<option value="0">����</option>
    <option value="1">�м�</option>  
    <option value="2">�߼�</option>  
</select> </span>
</div>

<input type="submit" value="����" class="tbutton" style="margin-left:70px;background-color:#0e9c76;" onclick="newAccount()">
<input type="submit" value="�ر�" class="tbutton" style="background-color:#f2737e;" onclick="closeNew()">
</div>

<!-- �����༭���� -->
<script>
function openEdit(){
	   document.getElementById("edit").style.display="";
	}
function closeEdit(){
	   document.getElementById("edit").style.display="none";
	}
</script>

<!-- �û��༭���� -->
<div id="edit" style="display:none; POSITION:absolute; left:400px; top:60px; width:299px; height:380px; border:1px solid #888; background-color:white;position: absolute;top: 50%;left: 50%;-webkit-transform: translate(-50%, -50%);-moz-transform: translate(-50%, -50%);
                       -ms-transform: translate(-50%, -50%);-o-transform: translate(-50%, -50%);transform: translate(-50%, -50%);">
<div class="ttitle">�û��༭</div>
<div style="margin-left:30px;margin-top:8px;font-size:14px;">
�˺ţ�<input type="text" class="tinput" id="editaccount" size=20 value="�������˺�" onfocus="this.value = ''"><br/>

���룺<input type="password" class="tinput" id="editpassword" size=20 value="����������" onfocus="this.value = ''"><br/>

������<input type="text" class="tinput" id="editname" size=20 value="����������" onfocus="this.value = ''"><br/>

�ֻ���<input type="text" class="tinput" id="editphone" size=20 value="�������ֻ�����" onfocus="this.value = ''"><br/>

���䣺<input type="text" class="tinput" id="editemail" size=20 value="����������" onfocus="this.value = ''"><br/>

Ȩ�ޣ�
<span><select id="editauthority" class="authority">  
 	<option value="0">����</option>
    <option value="1">�м�</option>  
    <option value="2">�߼�</option>  
</select> </span>
</div>

<input type="submit" value="����" class="tbutton" style="margin-left:70px;background-color:#0e9c76;" onclick="EditAccountTrans()">
<input type="submit" value="�ر�" class="tbutton" style="background-color:#f2737e;" onclick="closeEdit()">

</div>

</body>
</html>