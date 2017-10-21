
    


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