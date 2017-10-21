
/** 更改选中的后背景函数：changeback*() */
function changebacka(){
	   var obj = document.getElementById("add_delete");
	   obj.style.cssText = "background-color:#066b65;font-size:16px;color:white;margin-left:-0.5%;"
	   var obj = document.getElementById("change");
	   obj.style.cssText = "background-color:#0e9c76;color:#e9e9e9;"
	   var obj = document.getElementById("frequency");
	   obj.style.cssText = "background-color:#0e9c76;color:#e9e9e9;"
}

function changebackb(){
	   var obj = document.getElementById("add_delete");
	   obj.style.cssText = "background-color:#0e9c76;color:#e9e9e9;margin-left:-0.5%;"
	   var obj = document.getElementById("change");
	   obj.style.cssText = "background-color:#066b65;font-size:16px;color:white;"
	   var obj = document.getElementById("frequency");
	   obj.style.cssText = "background-color:#0e9c76;color:#e9e9e9;"
}

function changebackc(){
	   var obj = document.getElementById("add_delete");
	   obj.style.cssText = "background-color:#0e9c76;color:#e9e9e9;margin-left:-0.5%;"
	   var obj = document.getElementById("change");
	   obj.style.cssText = "background-color:#0e9c76;color:#e9e9e9;"
	   var obj = document.getElementById("frequency");
	   obj.style.cssText = "background-color:#066b65;font-size:16px;color:white;"
}


/* IMEI号查询数据交互 */
function query(){
	$.ajax({
		type:'GET',
		url:'/platform/terminal/query',
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
				CreateTable(length,2);
				var tableDate = "";
				i=1;
				$.each(data,function(id,obj){
					if(i%2==0){
	            		tableDate += "<tr bgcolor=#f0f0f0><td width=10%>"+i+"</td>"
	            					+"<td width=50%>"+obj['IMEI']+"</td></tr>"
	            	}
	            	else{
	            		tableDate += "<tr bgcolor=white><td width=10%>"+i+"</td>"
	            					+"<td width=50%>"+obj['IMEI']+"</td></tr>"
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


/** 增加采集器数据交互 */
function add(){
	if( $("#imei").val() == "" || $("#imei").val() == "请输入终端号"){
		alert("输入信息不正确");
	}
	else{
		flag = window.confirm("是否要增加IMEI号为: "+$("#imei").val()+" 的采集器？");
		if (flag == true){
			$.ajax({
				type:'POST',
				url:'/platform/terminal/add',
				data:{
					"imei":$("#imei").val()
				},
				dataType:'json',
				success:function(data){
					if (data["errno"] == 0) {
						alert("添加成功！");
						Loadcookieimei();
					}
					else{
						alert(data["error"]);
					}
				}
			});
		}
	}
}

/** 删除采集器数据交互 */
function remove(){
	if( $("#imei").val() == "" || $("#imei").val() == "请输入终端号"){
		alert("输入信息不正确");
	}
	else{
		flag = window.confirm("是否要删除IMEI号为: "+$("#imei").val()+" 的采集器？");
		if (flag == true){
			$.ajax({
				type:'POST',
				url:'/platform/terminal/remove',
				data:{
					"imei":$("#imei").val()
				},
				dataType:'json',
				success:function(data){
					if (data["errno"] == 0) {
						alert("删除成功！");
						Loadcookieimei();
					}
					else{
						alert(data["error"]);
					}
				}
			});
		}
	}
}

/** 更改采集器数据交互 */
function change(){
	if( $("#oldimei").val() == "" || $("#oldimei").val() == "请输入原终端号" || $("#newimei").val() == "" || $("#newimei").val() == "请输入新终端号"){
		alert("输入信息不正确");
	}
	else{
		flag = window.confirm("是否要将原终端号为: "+$("#oldimei").val()+" 的采集器更换为终端号为："+$("#newimei").val()+"的采集器？");
		if (flag == true){
			$.ajax({
				type:'POST',
				url:'/platform/terminal/change',
				data:{
					"oldImei":$("#oldimei").val(),
					"newImei":$("#newimei").val()
				},
				dataType:'json',
				success:function(data){
					if (data["errno"] == 0) {
						alert("更改成功！");
						Loadcookieimei();
					}
					else{
						alert(data["error"]);
					}
				}
			});
		}
	}
}

/** 更改频率数据交互 */
function frequency(){
	if( $("#heartbeattime").val() == "" || $("heartbeattime").val() == "例：10" || $("#missiontime").val() == "" || $("#missiontime").val() == "例：600"){
		alert("请输入完整信息！");
	}
	else{
		flag = window.confirm("是否要修改心跳时间为: "+$("#heartbeattime").val()+"秒， 任务时间为："+$("#missiontime").val()+"分钟？");
		if (flag == true){
			$.ajax({
				type:'POST',
				url:'/platform/terminal/frequency',
				data:{
					"imei":$("#imei").val(),
					"time1":$("#heartbeattime").val(),
					"time2":$("#missiontime").val()
				},
				dataType:'json',
				success:function(data){
					if (data["errno"] == 0) {
						alert("设置成功！");
						Loadcookieimei();
					}
					else{
						alert(data["error"]);
					}
				}
			});
		}
	}
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