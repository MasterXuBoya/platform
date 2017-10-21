/* 登陆对话框 */
function closeLogin(){
	window.open("","_self");  
	window.close();
	}

/* 设置cookie */
function setCookie(name,value)
{
	  var d = new Date();
	  d.setTime(d.getTime()+(10*24*60*60*1000));
	  var expires = "expires="+d.toGMTString();
	  document.cookie = name + "=" + value;
}

/* 加载函数 */
function load(){
	
	/* 右上角显示账户名 */
	var url=location.href; 
	var account=url.split("?")[1];
	$("#login").val("欢迎您，"+account+"！  退出登录");
	
	/* 验证是否已登录 */
	var username = sessionStorage.username; 
	if(username != account){
		   alert("请登录！");
		   window.location.href = "Meter/main/login.jsp?";
		}
	
	/* 储存楼号、室号、imei号cookie */
	Loadcookiebr();
	Loadcookieimei();
}

function Loadcookiebr(){
	//查询楼号室号
	$.ajax({
		type:'GET',
		url:'/platform/meter/query',
		dataType:'json',
		success:function(data){
			if (data["errno"] != undefined && data["errno"] != 0) {
				alert(data["error"]);
				return;
			}
			var length=getJsonObjLength(data[0]);
			var allbuilding = new Array(length);
			var allroom = new Array(length);
			if (length != 0){
				i=0;
				$.each(data,function(id,obj){
					allbuilding[i]=obj['building'];
					allroom[i]=obj['room'];
					i++;
				})
				setCookie("cbuilding",allbuilding);
				setCookie("croom",allroom);
			}
            else{
            	alert("楼号、室号未加载！");
            }
		}
	});
}


function Loadcookieimei(){
	//查询IMEI号
	$.ajax({
		type:'GET',
		url:'/platform/terminal/query',
		dataType:'json',
		success:function(data){
			if (data["errno"] != undefined && data["errno"] != 0) {
				alert(data["error"]);
				return;
			}
			var length=getJsonObjLength(data[0]);
			var allimei = new Array(length);
			if (length != 0){
				i = 0;
				$.each(data,function(id,obj){
					allimei[i]=obj['IMEI'];
					i++;
				})
				setCookie("cimei",allimei);
			}
            else{
            	alert("imei号未加载！");
            }
		}
	});
}

/* 注销登录跳转 */
function logoff(){
	flag = confirm("您确定要退出登录？");
	if (flag == true)
		window.location.href="/platform/main/login.jsp";
}


/* 登录验证数据交互 */
function login(){
	var account = $("#loginaccount").val();
	var password = $("#loginpassword").val();
	$.ajax({
		type:'POST',
		url:'/platform/display/login',
		data:{
			"account":account,
			"password":password
		},
		dataType:'json',
		success:function(data){
			sessionStorage.username = account;
			if (data["errno"] == 0){
				switch (data["authority"])
				{
				case 1:	
					window.location.href = "/platform/main/homepage_1.jsp?"+account;
					break;
				case 2:	
					window.location.href = "/platform/main/homepage_2.jsp?"+account;
					break;
				case 3:	
					window.location.href = "/platform/main/homepage_3.jsp?"+account;
					break;
				case 4:	
					window.location.href = "/platform/main/homepage_4.jsp?"+account;
					break;
				}
			}
            else{
            	alert("登陆失败，请检查您的账号及密码。");
            }
		}
	});
} 

/* json数据长度 */
function getJsonObjLength(jsonObj) {
    var Length = 0;
    for (var item in jsonObj) {
        Length++;
    }
    return Length;
}

/* 更改选中的后背景函数：changeback*() */
function changebackm(){
	   var obj = document.getElementById("mainpage");
	   obj.style.cssText = "background-image:url(/platform/static/pic/click_back.png);color:#066b65;font-weight:bold;background-size:100%;"
	   var obj = document.getElementById("meter");
	   obj.style.cssText = "background-color:white;color:#6a6969;"
	   var obj = document.getElementById("terminal");
	   obj.style.cssText = "background-color:white;color:#6a6969;"
	   var obj = document.getElementById("inquiry");
	   obj.style.cssText = "background-color:white;color:#6a6969;"
	   var obj = document.getElementById("charge");
	   obj.style.cssText = "background-color:white;color:#6a6969;"
	   var obj = document.getElementById("operation");
	   obj.style.cssText = "background-color:white;color:#6a6969;"
	   var obj = document.getElementById("user");
	   obj.style.cssText = "background-color:white;color:#6a6969;"
		   //清除首页跳转缓存
		   for(i=0;i<100;i++){
				var inputx=document.getElementById("1");
				document.getElementById("header").removeChild(inputx);
			}
}

function changebackmm(){
	   var obj = document.getElementById("mainpage");
	   obj.style.cssText = "background-color:white;color:#6a6969;"
	   var obj = document.getElementById("meter");
	   obj.style.cssText = "background-image:url(/platform/static/pic/click_back.png);color:#066b65;font-weight:bold;background-size:100%;"
	   var obj = document.getElementById("terminal");
	   obj.style.cssText = "background-color:white;color:#6a6969;"
	   var obj = document.getElementById("inquiry");
	   obj.style.cssText = "background-color:white;color:#6a6969;"
	   var obj = document.getElementById("charge");
	   obj.style.cssText = "background-color:white;color:#6a6969;"
	   var obj = document.getElementById("operation");
	   obj.style.cssText = "background-color:white;color:#6a6969;"
	   var obj = document.getElementById("user");
	   obj.style.cssText = "background-color:white;color:#6a6969;"
		 //清除首页跳转缓存
		   for(i=0;i<100;i++){
				var inputx=document.getElementById("1");
				document.getElementById("header").removeChild(inputx);
			}
}

function changebackt(){
	   var obj = document.getElementById("mainpage");
	   obj.style.cssText = "background-color:white;color:#6a6969;"
	   var obj = document.getElementById("meter");
	   obj.style.cssText = "background-color:white;color:#6a6969;"
	   var obj = document.getElementById("terminal");
	   obj.style.cssText = "background-image:url(/platform/static/pic/click_back.png);color:#066b65;font-weight:bold;background-size:100%;"
	   var obj = document.getElementById("inquiry");
	   obj.style.cssText = "background-color:white;color:#6a6969;"
	   var obj = document.getElementById("charge");
	   obj.style.cssText = "background-color:white;color:#6a6969;"
	   var obj = document.getElementById("operation");
	   obj.style.cssText = "background-color:white;color:#6a6969;"
	   var obj = document.getElementById("user");
	   obj.style.cssText = "background-color:white;color:#6a6969;"
		 //清除首页跳转缓存
		   for(i=0;i<100;i++){
				var inputx=document.getElementById("1");
				document.getElementById("header").removeChild(inputx);
			}
}

function changebacki(){
	   var obj = document.getElementById("mainpage");
	   obj.style.cssText = "background-color:white;color:#6a6969;"
	   var obj = document.getElementById("meter");
	   obj.style.cssText = "background-color:white;color:#6a6969;"
	   var obj = document.getElementById("terminal");
	   obj.style.cssText = "background-color:white;color:#6a6969;"
	   var obj = document.getElementById("inquiry");
	   obj.style.cssText = "background-image:url(/platform/static/pic/click_back.png);color:#066b65;font-weight:bold;background-size:100%;"
	   var obj = document.getElementById("charge");
	   obj.style.cssText = "background-color:white;color:#6a6969;"
	   var obj = document.getElementById("operation");
	   obj.style.cssText = "background-color:white;color:#6a6969;"
	   var obj = document.getElementById("user");
	   obj.style.cssText = "background-color:white;color:#6a6969;"
		 //清除首页跳转缓存
		   for(i=0;i<100;i++){
				var inputx=document.getElementById("1");
				document.getElementById("header").removeChild(inputx);
			}
}

function changebackc(){
	   var obj = document.getElementById("mainpage");
	   obj.style.cssText = "background-color:white;color:#6a6969;"
	   var obj = document.getElementById("meter");
	   obj.style.cssText = "background-color:white;color:#6a6969;"
	   var obj = document.getElementById("terminal");
	   obj.style.cssText = "background-color:white;color:#6a6969;"
	   var obj = document.getElementById("inquiry");
	   obj.style.cssText = "background-color:white;color:#6a6969;"
	   var obj = document.getElementById("charge");
	   obj.style.cssText = "background-image:url(/platform/static/pic/click_back.png);color:#066b65;font-weight:bold;background-size:100%;"
	   var obj = document.getElementById("operation");
	   obj.style.cssText = "background-color:white;color:#6a6969;"
	   var obj = document.getElementById("user");
	   obj.style.cssText = "background-color:white;color:#6a6969;"
		 //清除首页跳转缓存
		   for(i=0;i<100;i++){
				var inputx=document.getElementById("1");
				document.getElementById("header").removeChild(inputx);
			}
}

function changebacko(){
	   var obj = document.getElementById("mainpage");
	   obj.style.cssText = "background-color:white;color:#6a6969;"
	   var obj = document.getElementById("meter");
	   obj.style.cssText = "background-color:white;color:#6a6969;"
	   var obj = document.getElementById("terminal");
	   obj.style.cssText = "background-color:white;color:#6a6969;"
	   var obj = document.getElementById("inquiry");
	   obj.style.cssText = "background-color:white;color:#6a6969;"
	   var obj = document.getElementById("charge");
	   obj.style.cssText = "background-color:white;color:#6a6969;"
	   var obj = document.getElementById("operation");
	   obj.style.cssText = "background-image:url(/platform/static/pic/click_back.png);color:#066b65;font-weight:bold;background-size:100%;"
	   var obj = document.getElementById("user");
	   obj.style.cssText = "background-color:white;color:#6a6969;"
		 //清除首页跳转缓存
		   for(i=0;i<100;i++){
				var inputx=document.getElementById("1");
				document.getElementById("header").removeChild(inputx);
			}
}

function changebacku(){
	   var obj = document.getElementById("mainpage");
	   obj.style.cssText = "background-color:white;color:#6a6969;"
	   var obj = document.getElementById("meter");
	   obj.style.cssText = "background-color:white;color:#6a6969;"
	   var obj = document.getElementById("terminal");
	   obj.style.cssText = "background-color:white;color:#6a6969;"
	   var obj = document.getElementById("inquiry");
	   obj.style.cssText = "background-color:white;color:#6a6969;"
	   var obj = document.getElementById("charge");
	   obj.style.cssText = "background-color:white;color:#6a6969;"
	   var obj = document.getElementById("operation");
	   obj.style.cssText = "background-color:white;color:#6a6969;"
	   var obj = document.getElementById("user");
	   obj.style.cssText = "background-image:url(/platform/static/pic/click_back.png);color:#066b65;font-weight:bold;background-size:100%;"
		 //清除首页跳转缓存
		   for(i=0;i<100;i++){
				var inputx=document.getElementById("1");
				document.getElementById("header").removeChild(inputx);
			}
}