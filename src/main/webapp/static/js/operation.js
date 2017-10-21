
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
	   var obj = document.getElementById("communication");
	   obj.style.cssText = "background-color:#066b65;font-size:16px;color:white;"
	   var obj = document.getElementById("status");
	   obj.style.cssText = "background-color:#0e9c76;color:#e9e9e9;"
	   var obj = document.getElementById("run_stop");
	   obj.style.cssText = "background-color:#0e9c76;color:#e9e9e9;margin-left:-0.5%;"
}

function changebackb(){
	   var obj = document.getElementById("communication");
	   obj.style.cssText = "background-color:#0e9c76;color:#e9e9e9;"
	   var obj = document.getElementById("status");
	   obj.style.cssText = "background-color:#066b65;font-size:16px;color:white;"
	   var obj = document.getElementById("run_stop");
	   obj.style.cssText = "background-color:#0e9c76;color:#e9e9e9;margin-left:-0.5%;"
}

function changebackc(){
	   var obj = document.getElementById("communication");
	   obj.style.cssText = "background-color:#0e9c76;color:#e9e9e9;"
	   var obj = document.getElementById("status");
	   obj.style.cssText = "background-color:#0e9c76;color:#e9e9e9;"
	   var obj = document.getElementById("run_stop");
	   obj.style.cssText = "background-color:#066b65;font-size:16px;color:white;margin-left:-0.5%;"
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

/* 电表运行状态查询数据交互 */
function query(){
	$.ajax({
		type:'GET',
		url:'/platform/xhr/meter/data',
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
				var status;
				i=0;
				$.each(data,function(id,obj){
					if(obj['status'] == 1){
						status = "运行";
					}
					if(obj['status'] == 2){
						status = "停止";
					}
					if(obj['status'] == 0){
						status = "未下发地址";
					}
					if(i%2==1){
	            		tableDate += "<tr bgcolor=#f0f0f0><td width=5%><input type=checkbox name=checkboxID></td>"
	            					+"<td width=31.6% id='building" +i+ "'>"+obj['building']+"</td>"
	            					+"<td width=31.6% id='room" +i+ "'>"+obj['room']+"</td>"
	            					+"<td width=31.6%>"+status+"</td></tr>"
	            	}
	            	else{
	            		tableDate += "<tr bgcolor=white><td width=5%><input type=checkbox name=checkboxID></td>"
	            					+"<td width=31.6% id='building" +i+ "'>"+obj['building']+"</td>"
	            					+"<td width=31.6% id='room" +i+ "'>"+obj['room']+"</td>"
	            					+"<td width=31.6%>"+status+"</td></tr>"
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

/* 电表开启控制交互 */
function start(){
	var checkArray = document.getElementsByName("checkboxID");
	var count = 0; 
	var jsonArray = [];
	var index = 0;
	for (var i = 0; i < checkArray.length; i++) {
		if(checkArray[i].checked == true){
			var jsonObject = {
							"building":document.getElementById("building"+i).innerHTML,
							"room":document.getElementById("room"+i).innerHTML
							};
			jsonArray[index++] = jsonObject;
			count++;
		}
		
	}
	if(count == 0){  
		//至此，说明没有标签被选择到，可以进行相应的操作  
		alert("请选择要开启的电表！");  
	} 
	else{
		flag = confirm("确认开启？");
		if (flag == true){
			$.ajax({
				type:'POST',
				url:'/platform/command/start_stop',
				async: false,
				data:{
					"data": JSON.stringify(jsonArray),
					"command":1
				},
				dataType:'json',
				success:function(data){
							if (data["errno"] == 0){
								alert("开启电表命令下发成功,请3分钟后查询并确认电表状态");
							}
							else{
								alert(data["error"]);
							}
						}
					});
		}
	}
}

/* 电表停止控制交互 */
function stop(){
	var checkArray = document.getElementsByName("checkboxID");
	var count = 0; 
	var jsonArray = [];
	var index = 0;
	for (var i = 0; i < checkArray.length; i++) {
		if(checkArray[i].checked == true){
			var jsonObject = {
							"building":document.getElementById("building"+i).innerHTML,
							"room":document.getElementById("room"+i).innerHTML
							};
			jsonArray[index++] = jsonObject;
			count++;
		}
		
	}
	if(count == 0){  
		//至此，说明没有标签被选择到，可以进行相应的操作  
		alert("请选择要开启的电表！");  
	} 
	else{
		flag = confirm("确认停止？");
		var temp = 0;
		if (flag == true){
			$.ajax({
				type:'POST',
				url:'/platform/command/start_stop',
				async: false,
				data:{
					"data": JSON.stringify(jsonArray),
					"command":0
				},
				dataType:'json',
				success:function(data){
							if (data["errno"] == 0){
								alert("开启电表命令下发成功,请3分钟后查询并确认电表状态");
							}
							else{
								alert(data["error"]);
							}
						}
			});
		}  
	}
	
}

/* 暂时没有！ */
/* 暂无通信状态查询数据交互 */
function comquery(){
	$.ajax({
		type:'GET',
		url:'/platform/xhr/terminal/data',
		data:{
			"IMEI":$("#IMEI").val()
		},
		dataType:'json',
		success:function(data){
			if(getJsonObjLength(data[0]) != 0){
				var tableDate = "";
				$.each(data,function(id,obj){
					tableDate += "<tr><td>"+obj['IMEI']+"</td>"
									+"<td>"+obj['sim']+"</td>"
									+"<td>"+obj['simRemain']+"</td></tr>"
					$("table").html(tableDate);
				})
			}
			else{
				if (data["errno"] != 0){
            	alert("无相关数据！");
				}
            }
		}
	});
}

/* 暂无 终端状态查询数据交互 */
function statusquery(){
	$.ajax({
		type:'GET',
		url:'/platform/xhr/terminal/data',
		data:{
			"IMEI":$("#IMEI").val()
		},
		dataType:'json',
		success:function(data){
			if(getJsonObjLength(data[0]) != 0){
				var tableDate = "";
				$.each(data,function(id,obj){
					tableDate += "<tr><td>"+obj['IMEI']+"</td>"
									+"<td>"+obj['status']+"</td></tr>"
					$("table").html(tableDate);
				})
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
	var table=$("<table id=table>");
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