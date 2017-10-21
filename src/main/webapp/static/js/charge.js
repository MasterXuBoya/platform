/* 初始化时间选择控件 */
function loadtime(){
	var date = new Date();
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    var hour = date.getHours();
    var minute = date.getMinutes();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    
    if (hour >= 0 && hour <= 9) {
        hour = "0" + hour;
    }
    
    if (minute >= 0 && minute <= 9) {
    	minute = "0" + minute;
    }
    
    var currentdate = date.getFullYear() + "-" + month + "-" + strDate
            + "T" + hour + ":" + minute;
    $("#end").val(currentdate);

    var stratdate = date.getFullYear() + "-" + month + "-" + strDate
    		+ "T00:00";
    $("#start").val(stratdate);
}

/* 在下拉框中加载楼号  */
function loadbr(){
	cbuilding = getCookie("cbuilding");
	croom = getCookie("croom");
	allbuilding = new Array(); 
	allbuilding = cbuilding.split(",");
	allroom = new Array(); 
	allroom = croom.split(",");
	for (i = 0;i < allbuilding.length; i++){
		$("#building").append("<option value="+ allbuilding[i] +">"+ allbuilding[i] +"</option>");
	} 
}

/* 根据楼号在下拉框中加载室号  */
function changeroom(){
	if ($("#building").val() == "all"){
		$("#room").empty();
		$("#room").append("<option value=all>全部</option>");
	}
	else{
		var room =  new Array(); 
		var myselect = document.getElementById("building");
		index = parseInt(myselect.selectedIndex) - 1;
		room = allroom[index].split(".");
		$("#room").empty();
		$("#room").append("<option value=all>全部</option>");
		for (i = 0;i < room.length; i++){
			$("#room").append("<option value="+ room[i] +">"+ room[i] +"</option>");
		} 
	}
}

/* 读取cookie */
function getCookie(cname)
{
	var name = cname + "=";
	var ca = parent.document.cookie.split(';');
	for(var i=0; i<ca.length; i++) {
		var c = ca[i].trim();
		if (c.indexOf(name)==0) return c.substring(name.length,c.length);
	}
	return null;
}

/* 人工充值交互 */
function recharge(){
	if($("#money").val() == "" || $("#money").val() == "请输入充值金额"){
		alert("请输入充值金额！");
	}
	else{
		flag = window.confirm("确认向: "+$("#building").val()+" 楼"+$("#room").val()+" 室的用户充值"+$("#money").val()+"元？");
		if (flag == true){
			$.ajax({
				type:'POST',
				url:'/platform/deposit',
				data:{
					"building":$("#building").val(),
					"room":$("#room").val(),
					"money":$("#money").val()
				},
				dataType:'json',
				success:function(data){
					if (data["errno"] == 0) {
						alert("充值成功！");
					}
					else{
						alert(data["error"]);
					}
				}
			});
		}
	}
}

/* 余额查询数据交互 */
function balancequery(){
	$.ajax({
		type:'GET',
		url:'/platform/xhr/remain',
		data:{
			"building":$("#building").val(),
			"room":$("#room").val()
		},
		dataType:'json',
		success:function(data){
			if (data["errno"] != undefined && data["errno"] != 0) {
				alert(data["error"]);
				return;
			}
			$("#thead").show();
			$("#table").show();
			var rowlength=getJsonObjLength(data[0]);
			var length=getJsonObjLength(data);

			if(rowlength != 0){
				CreateTable(length,6);
				var tableDate = "";
				i=1;
				$.each(data,function(id,obj){
					if(i%2==0){
	            		tableDate += "<tr bgcolor=#f0f0f0><td width=20%>"+obj['building']+"</td>"
	            					+"<td width=20%>"+obj['room']+"</td>"
	            					+"<td width=20%>"+obj['name']+"</td>"
	            					+"<td width=20%>"+obj['phone']+"</td>"
	            					+"<td width=20%>"+obj['remain']+"</td></tr>"
	            	}
	            	else{
	            		tableDate += "<tr bgcolor=white><td width=20%>"+obj['building']+"</td>"
	            					+"<td width=20%>"+obj['room']+"</td>"
	            					+"<td width=20%>"+obj['name']+"</td>"
	            					+"<td width=20%>"+obj['phone']+"</td>"
	            					+"<td width=20%>"+obj['remain']+"</td></tr>"
	            	}
					i++;
				})
	            $("#table").html(tableDate);
				//分页
				$(function(){
				    $("div.holder").jPages({
				      containerID : "table", //存放表格的窗口标签ID
				      previous : "←", //指示首页的按钮
				      next : "→",//指示尾页的按钮
				      perPage : 14,//每页显示表格的行数
				      delay : 0 //分页时动画持续时间，0表示无动画
				    });
				  });
			}
			else{
				if (data["errno"] != 0){
            	alert("无相关数据！");
				}
            }
		}
	});
}

/* 缴费查询数据交互 */
function paymentquery(){
	var start=new Date($("#start").val()).format('yyyy-MM-dd hh:mm:ss');
	var end=new Date($("#end").val()).format('yyyy-MM-dd hh:mm:ss');
	$.ajax({
		type:'GET',
		url:'/platform/xhr/payment',
		data:{
			"building":$("#building").val(),
			"room":$("#room").val(),
			"start":start,
			"over":end
		},
		dataType:'json',
		success:function(data){
			if (data["errno"] != undefined && data["errno"] != 0) {
				alert(data["error"]);
				return;
			}
			$("#thead").show();
			$("#table").show();
			var rowlength=getJsonObjLength(data[0]);
			var length=getJsonObjLength(data);
				
			if(rowlength != 0){
				CreateTable(length,5);
				var tableDate = "";
				i=1;
				$.each(data,function(id,obj){
					if(i%2==0){
	            		tableDate += "<tr bgcolor=#f0f0f0><td width=20%>"+obj['time']+"</td>"
	            					+"<td width=20%>"+obj['building']+"</td>"
	            					+"<td width=20%>"+obj['room']+"</td>"
	            					+"<td width=20%>"+obj['payment']+"</td>"
	            					+"<td width=20%>"+obj['remain']+"</td></tr>"
	            	}
	            	else{
	            		tableDate += "<tr bgcolor=white><td width=20%>"+obj['time']+"</td>"
	            					+"<td width=20%>"+obj['building']+"</td>"
	            					+"<td width=20%>"+obj['room']+"</td>"
	            					+"<td width=20%>"+obj['payment']+"</td>"
	            					+"<td width=20%>"+obj['remain']+"</td></tr>"
	            	}
					i++;
				})
	            $("#table").html(tableDate); 
				//分页
				$(function(){
				    $("div.holder").jPages({
				      containerID : "table", //存放表格的窗口标签ID
				      previous : "←", //指示首页的按钮
				      next : "→",//指示尾页的按钮
				      perPage : 14,//每页显示表格的行数
				      delay : 0 //分页时动画持续时间，0表示无动画
				    });
				  });
			}
			else{
				if (data["errno"] != 0){
            	alert("无相关数据！");
				}
            }
		}
	});
}

/* 全选框 */
function checkall(){
	var checkArray = document.getElementsByName("checkboxID");
	for ( var i = 0; i < checkArray.length; i++) { 
		if ($("#all")[0].checked == true)
			checkArray[i].checked = true;
		else
			checkArray[i].checked = false;
	}
}

/* 催费查询数据交互 */
function urgingquery(){
	$.ajax({
		type:'GET',
		url:'/platform/xhr/remain',
		data:{
			"building":$("#building").val(),
			"room":$("#room").val()
		},
		dataType:'json',
		success:function(data){
			if (data["errno"] != undefined && data["errno"] != 0) {
				alert(data["error"]);
				return;
			}
			$("#thead").show();
			$("#table").show();
			var rowlength=getJsonObjLength(data[0]);
			var length=getJsonObjLength(data);
				
			if(rowlength != 0){
				CreateTable(length,4);
				var tableDate = "";
				i=0;
				$.each(data,function(id,obj){
					if(i%2==0){
	            		tableDate += "<tr bgcolor=#f0f0f0><td width=5%><input type=checkbox name=checkboxID></td>"
	            					+"<td width=31.67% id='building" +i+ "'>"+obj['building']+"</td>"
	            					+"<td width=31.67% id='room" +i+ "'>"+obj['room']+"</td>"
	            					+"<td width=31.67%>"+obj['remain']+"</td></tr>"
	            	}
	            	else{
	            		tableDate += "<tr bgcolor=white><td width=5%><input type=checkbox name=checkboxID></td>"
	            					+"<td width=31.67% id='building" +i+ "'>"+obj['building']+"</td>"
	            					+"<td width=31.67% id='room" +i+ "'>"+obj['room']+"</td>"
	            					+"<td width=31.67%>"+obj['remain']+"</td></tr>"
	            	}
					i++;                  
				})
	            $("#table").html(tableDate);
				//分页
				$(function(){
				    $("div.holder").jPages({
				      containerID : "table", //存放表格的窗口标签ID
				      previous : "←", //指示首页的按钮
				      next : "→",//指示尾页的按钮
				      perPage : 10,//每页显示表格的行数
				      delay : 0 //分页时动画持续时间，0表示无动画
				    });
				  });
			}
			else{
				if (data["errno"] != 0){
            	alert("无相关数据！");
				}
            }
		}
	});
}


/* 查询全部欠费用户数据交互 */
function allurgingquery(){
	$.ajax({
		type:'GET',
		url:'/platform/xhr/arrearage',
		dataType:'json',
		success:function(data){
			if (data["errno"] != undefined && data["errno"] != 0) {
				alert(data["error"]);
				return;
			}
			$("#thead").show();
			$("#table").show();
			var length=getJsonObjLength(data[0]);
			if(length != 0){
				CreateTable(length,4);
				var tableDate = "";
				i=0;
				$.each(data,function(id,obj){
					if(i%2==0){
	            		tableDate += "<tr bgcolor=#f0f0f0><td width=5%><input type=checkbox name=checkboxID></td>"
	            					+"<td width=31.67% id='building" +i+ "'>"+obj['building']+"</td>"
	            					+"<td width=31.67% id='room" +i+ "'>"+obj['room']+"</td>"
	            					+"<td width=31.67%>"+obj['remain']+"</td></tr>"
	            	}
	            	else{
	            		tableDate += "<tr bgcolor=white><td width=5%><input type=checkbox name=checkboxID></td>"
	            					+"<td width=31.67% id='building" +i+ "'>"+obj['building']+"</td>"
	            					+"<td width=31.67% id='room" +i+ "'>"+obj['room']+"</td>"
	            					+"<td width=31.67%>"+obj['remain']+"</td></tr>"
	            	}
					i++;            
				})
	            $("#table").html(tableDate);
				//分页
				$(function(){
				    $("div.holder").jPages({
				      containerID : "table", //存放表格的窗口标签ID
				      previous : "←", //指示首页的按钮
				      next : "→",//指示尾页的按钮
				      perPage : 10,//每页显示表格的行数
				      delay : 0 //分页时动画持续时间，0表示无动画
				    });
				  });
			}
			else{
				if (data["errno"] != 0){
            	alert("无相关数据！");
				}
            }
		}
	});
}


/* 催费下发数据交互 */
function urging(){
	var count = 0;  
	var checkArray = document.getElementsByName("checkboxID");
	for ( var i = 0; i < checkArray.length; i++) {  
        if(checkArray[i].checked == true){ 
        	building=document.getElementById("building"+i).innerHTML;
        	room=document.getElementById("room"+i).innerHTML;
        	$.ajax({
        		type:'POST',
        		url:'/platform/reminder',
        		async: false,
        		data:{
        			"building":building,
        			"room":room
        		},
        		dataType:'json',
        		success:function(data){
                    if (data["errno"] == 0){
                    	alert("楼号："+building+"室号："+room+"催费成功！");
                    	query();
                    }
                    else{
                    	alert("无相关数据！");
                    }
        		} 
        	});
        	count ++;  
        }  
	}
	if(count == 0){  
        //说明没有标签被选择到，可以进行相应的操作  
        alert("请选择需要催费的用户！")  
    }  
}

/** 时间格式化函数 */
Date.prototype.format = function (format) {
    var o = {
        "M+": this.getMonth() + 1, //month
        "d+": this.getDate(), //day
        "h+": this.getHours(), //hour
        "m+": this.getMinutes(), //minute
        "s+": this.getSeconds(), //second
        "q+": Math.floor((this.getMonth() + 3) / 3), //quarter
        "S": this.getMilliseconds() //millisecond
    }
    if (/(y+)/.test(format)) format = format.replace(RegExp.$1,(this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o) if (new RegExp("(" + k + ")").test(format))format = format.replace(RegExp.$1,RegExp.$1.length == 1 ? o[k] :("00" + o[k]).substr(("" + o[k]).length));
    return format;
}

/** json数据长度 */
function getJsonObjLength(jsonObj) {
    var Length = 0;
    for (var item in jsonObj) {
        Length++;
    }
    return Length;
}

/* 动态生成表格函数 */
function CreateTable(rowCount,cellCount)
{ 
	var table=$("<table id=\"table\">");
	   for(var i=0;i<rowCount;i++)
	   {
		   var tr=$("<tr></tr>");
		   tr.appendTo(table);
	      for(var j=0;j<cellCount;j++)
	      {
	  	    	var td=$("<td></td>");
	  	    	td.appendTo(tr);
	      }
	   }
	   $("#information").append("</table>");
}

/* 更改选中的后背景函数：changeback*() */
function changebacka(){
	   var obj = document.getElementById("balance");
	   obj.style.cssText = "background-color:#066b65;font-size:16px;color:white;"
	   var obj = document.getElementById("payment");
	   obj.style.cssText = "background-color:#0e9c76;color:#e9e9e9;"
	   var obj = document.getElementById("urging");
	   obj.style.cssText = "background-color:#0e9c76;color:#e9e9e9;"
	   var obj = document.getElementById("recharge");
	   obj.style.cssText = "background-color:#0e9c76;color:#e9e9e9;margin-left:-0.5%;"
}

function changebackb(){
	   var obj = document.getElementById("balance");
	   obj.style.cssText = "background-color:#0e9c76;color:#e9e9e9;"
	   var obj = document.getElementById("payment");
	   obj.style.cssText = "background-color:#066b65;font-size:16px;color:white;"
	   var obj = document.getElementById("urging");
	   obj.style.cssText = "background-color:#0e9c76;color:#e9e9e9;"
	   var obj = document.getElementById("recharge");
	   obj.style.cssText = "background-color:#0e9c76;color:#e9e9e9;margin-left:-0.5%;"
}

function changebackcc(){
	   var obj = document.getElementById("balance");
	   obj.style.cssText = "background-color:#0e9c76;color:#e9e9e9;"
	   var obj = document.getElementById("payment");
	   obj.style.cssText = "background-color:#0e9c76;color:#e9e9e9;"
	   var obj = document.getElementById("urging");
	   obj.style.cssText = "background-color:#066b65;font-size:16px;color:white;"
	   var obj = document.getElementById("recharge");
	   obj.style.cssText = "background-color:#0e9c76;color:#e9e9e9;margin-left:-0.5%;"
}

function changebackd(){
	   var obj = document.getElementById("balance");
	   obj.style.cssText = "background-color:#0e9c76;color:#e9e9e9;"
	   var obj = document.getElementById("payment");
	   obj.style.cssText = "background-color:#0e9c76;color:#e9e9e9;"
	   var obj = document.getElementById("urging");
	   obj.style.cssText = "background-color:#0e9c76;color:#e9e9e9;"
	   var obj = document.getElementById("recharge");
	   obj.style.cssText = "background-color:#066b65;font-size:16px;color:white;margin-left:-0.5%;"
}