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

/* 判断是否从首页跳转到数据查询 */
function load(){
	 if (parent.document.getElementById("1") != null){
		 document.getElementById("data").click();
	    }
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

/* 更改选中的后背景函数：changeback*() */
function changebacka(){
	   var obj = document.getElementById("warning");
	   obj.style.cssText = "background-color:#066b65;font-size:16px;color:white;margin-left:-0.5%;"
	   var obj = document.getElementById("data");
	   obj.style.cssText = "background-color:#0e9c76;color:#e9e9e9;"
	   var obj = document.getElementById("dairy");
	   obj.style.cssText = "background-color:#0e9c76;color:#e9e9e9;"
}

function changebackb(){
	   var obj = document.getElementById("warning");
	   obj.style.cssText = "background-color:#0e9c76;color:#e9e9e9;margin-left:-0.5%;"
	   var obj = document.getElementById("data");
	   obj.style.cssText = "background-color:#066b65;font-size:16px;color:white;"
	   var obj = document.getElementById("dairy");
	   obj.style.cssText = "background-color:#0e9c76;color:#e9e9e9;"
}

function changebackc(){
	   var obj = document.getElementById("warning");
	   obj.style.cssText = "background-color:#0e9c76;color:#e9e9e9;margin-left:-0.5%;"
	   var obj = document.getElementById("data");
	   obj.style.cssText = "background-color:#0e9c76;color:#e9e9e9;"
	   var obj = document.getElementById("dairy");
	   obj.style.cssText = "background-color:#066b65;font-size:16px;color:white;"
}

/* 时间格式化函数 */
Date.prototype.format = function (format) {
    var o = {
        "M+": this.getMonth() + 1, //month
        "d+": this.getDate(), //day
        "h+": this.getHours(), //hour
        "m+": this.getMinutes(), //minute
        "s+": this.getSeconds(), //second
    }
    if (/(y+)/.test(format)) format = format.replace(RegExp.$1,(this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o) if (new RegExp("(" + k + ")").test(format))format = format.replace(RegExp.$1,RegExp.$1.length == 1 ? o[k] :("00" + o[k]).substr(("" + o[k]).length));
    return format;
}

/* 告警查询数据交互 */
function warningquery(){
	var start=new Date($("#start").val()).format('yyyy-MM-dd hh:mm:ss');
	var end=new Date($("#end").val()).format('yyyy-MM-dd hh:mm:ss');
	$.ajax({
		type:'GET',
		url:'/platform/alarm/query',
		data:{
			"begin":start,
			"end":end
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
		            		tableDate += "<tr bgcolor=\"#f0f0f0\"><td width=\"16.6%\">"+obj['time']+"</td>"
		            					+"<td width=\"16.6%\">"+obj['IMEI']+"</td>"
		            					+"<td width=\"16.6%\">"+obj['building']+"</td>"
		            					+"<td width=\"16.6%\">"+obj['room']+"</td>"
		            					+"<td width=\"16.6%\">"+obj['type']+"</td>"
		            					+"<td width=\"16.6%\">"+obj['info']+"</td></tr>"
		            	}
		            	else{
		            		tableDate += "<tr bgcolor=\"white\"><td width=\"16.6%\">"+obj['time']+"</td>"
        								+"<td width=\"16.6%\">"+obj['IMEI']+"</td>"
        								+"<td width=\"16.6%\">"+obj['building']+"</td>"
        								+"<td width=\"16.6%\">"+obj['room']+"</td>"
        								+"<td width=\"16.6%\">"+obj['type']+"</td>"
        								+"<td width=\"16.6%\">"+obj['info']+"</td></tr>"
		            	}
		                i++;          
		        })
	            $("#table").html(tableDate);
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

/* 数据查询交互 */
function dataquery(){
	var start=new Date($("#start").val()).format('yyyy-MM-dd hh:mm:ss');
	var end=new Date($("#end").val()).format('yyyy-MM-dd hh:mm:ss');
	$.ajax({
		type:'GET',
		url:'/platform/data/query',
		data:{
			"begin":start,
			"end":end,
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
	            		tableDate += "<tr bgcolor=\"#f0f0f0\"><td width=\"16.6%\">"+obj['time']+"</td>"
	            					+"<td width=\"16.6%\">"+obj['building']+"</td>"
	            					+"<td width=\"16.6%\">"+obj['room']+"</td>"
	            					+"<td width=\"16.6%\">"+obj['voltage']+"</td>"
	            					+"<td width=\"16.6%\">"+obj['current']+"</td>"
	            					+"<td width=\"16.6%\">"+obj['power']+"</td></tr>"
	            	}
	            	else{
	            		tableDate += "<tr bgcolor=\"white\"><td width=\"16.6%\">"+obj['time']+"</td>"
	            					+"<td width=\"16.6%\">"+obj['building']+"</td>"
	            					+"<td width=\"16.6%\">"+obj['room']+"</td>"
	            					+"<td width=\"16.6%\">"+obj['voltage']+"</td>"
	            					+"<td width=\"16.6%\">"+obj['current']+"</td>"
	            					+"<td width=\"16.6%\">"+obj['power']+"</td></tr>"
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
				if(data["errno"] != 0){
					alert("无相关数据！");
				}
            }
		}
	});
}

/** 日志查询交互 */
function dairyquery(){
	var start=new Date($("#start").val()).format('yyyy-MM-dd hh:mm:ss');
	var end=new Date($("#end").val()).format('yyyy-MM-dd hh:mm:ss');
	$.ajax({
		type:'GET',
		url:'/platform/log/query',
		data:{
			"begin":start,
			"end":end
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
				CreateTable(3,length);
				var tableDate = "";
				i=1;
				$.each(data,function(id,obj){
					if(i%2==0){
	            		tableDate += "<tr bgcolor=\"#f0f0f0\"><td width=\"20%\">"+obj['time']+"</td>"
	            					+"<td width=\"20%\">"+obj['operation']+"</td>"
	            					+"<td width=\"60%\">"+obj['info']+"</td></tr>"
	            	}
	            	else{
	            		tableDate += "<tr bgcolor=\"white\"><td width=\"20%\">"+obj['time']+"</td>"
	            					+"<td width=\"20%\">"+obj['operation']+"</td>"
	            					+"<td width=\"60%\">"+obj['info']+"</td></tr>"
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

/* json数据长度 */
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