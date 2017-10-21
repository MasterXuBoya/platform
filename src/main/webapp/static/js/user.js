/* 用户信息查询数据交互 */
function query(){ 
	if ($("#account").val() == "" || $("#name").val() == ""){
		alert("请输入正确信息");
	}
	else{
		$.ajax({
			type:'GET',
			url:'/platform/user/get',
			data:{
				"account":$("#account").val(),
				"name":$("#name").val()
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
					i=0;
					$.each(data,function(id,obj){
						if(i%2==1){
		            		tableDate += "<tr bgcolor=#f0f0f0 height=35px><td width=18% id='account" +i+ "'>"+obj['account']+"</td>"
		            					+"<td width=18% id='name" +i+ "' >"+obj['name']+"</td>"
		            					+"<td width=18% id='phone" +i+ "' >"+obj['phone']+"</td>"
		            					+"<td width=18% id='email" +i+ "' >"+obj['email']+"</td>"
		            					+"<td width=18% id='authority" +i+ "' >"+obj['authority']+"</td>"
		            					+"<td width=10%><input type=button class=edit value=编辑 id='edit" +i+ "' onclick=editAccount(" +i+ ")></td></tr>"
		            	}
		            	else{
		            		tableDate += "<tr bgcolor=white height=35px><td width=18% id='account" +i+ "' >"+obj['account']+"</td>"
		            					+"<td width=18% id='name" +i+ "' >"+obj['name']+"</td>"
		            					+"<td width=18% id='phone" +i+ "' >"+obj['phone']+"</td>"
		            					+"<td width=18% id='email" +i+ "' >"+obj['email']+"</td>"
		            					+"<td width=18% id='authority" +i+ "' >"+obj['authority']+"</td>"
		            					+"<td width=10%><input type=button class=edit value=编辑 onclick=editAccount(" +i+ ")></td></tr>"
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
					      perPage : 12,//每页显示表格的行数
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
}

/* 查询全部用户  */
function queryall(){
	$.ajax({
		type:'GET',
		url:'/platform/user/get',
		data:{
			"account":"all",
			"name":"all"
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
				i=0;
				$.each(data,function(id,obj){
					if(i%2==1){
	            		tableDate += "<tr bgcolor=#f0f0f0 height=35px><td width=18% id='account" +i+ "'>"+obj['account']+"</td>"
	            					+"<td width=18% id='name" +i+ "' >"+obj['name']+"</td>"
	            					+"<td width=18% id='phone" +i+ "' >"+obj['phone']+"</td>"
	            					+"<td width=18% id='email" +i+ "' >"+obj['email']+"</td>"
	            					+"<td width=18% id='authority" +i+ "' >"+obj['authority']+"</td>"
	            					+"<td width=10%><input type=button class=edit value=编辑 id='edit" +i+ "' onclick=editAccount(" +i+ ")></td></tr>"
	            	}
	            	else{
	            		tableDate += "<tr bgcolor=white height=35px><td width=18% id='account" +i+ "' >"+obj['account']+"</td>"
	            					+"<td width=18% id='name" +i+ "' >"+obj['name']+"</td>"
	            					+"<td width=18% id='phone" +i+ "' >"+obj['phone']+"</td>"
	            					+"<td width=18% id='email" +i+ "' >"+obj['email']+"</td>"
	            					+"<td width=18% id='authority" +i+ "' >"+obj['authority']+"</td>"
	            					+"<td width=10%><input type=button class=edit value=编辑 onclick=editAccount(" +i+ ")></td></tr>"
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
				      perPage : 12,//每页显示表格的行数
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

/* 新增账户数据交互  */
function newAccount(){
	$.ajax({
		type:'POST',
		url:'/platform/user/modify',
		data:{
			"type":1,
			"account":$("#newaccount").val(),
			"password":$("#newpassword").val(),
			"name":$("#newname").val(),
			"phone":$("#newphone").val(),
			"email":$("#newemail").val(),
			"authority":$("#newauthority").val()
		},
		dataType:'json',
		success:function(data){
			if (data["errno"] == 0)
				alert("已保存新用户！")
            else
            	alert("保存失败！");
		}
	});
}

/* 编辑账户数据交互  */
function editAccount(number){
	document.getElementById("edit").style.display="";
	var account=document.getElementById("account"+number).innerHTML;
	var name=document.getElementById("name"+number).innerHTML;
	var phone=document.getElementById("phone"+number).innerHTML;
	var email=document.getElementById("email"+number).innerHTML;
	var authority=document.getElementById("authority"+number).innerHTML;
	$("#editaccount").val(account);
	$("#editname").val(name);
	$("#editphone").val(phone);
	$("#editemail").val(email);
	$("#editauthority").val(authority);
}

function EditAccountTrans(){
	$.ajax({
		type:'POST',
		url:'/platform/user/modify',
		data:{
			"type":0,
			"account":$("#editaccount").val(),
			"password":$("#editpassword").val(),
			"name":$("#editname").val(),
			"phone":$("#editphone").val(),
			"email":$("#editemail").val(),
			"authority":$("#editauthority").val()
		},
		dataType:'json',
		success:function(data){
			if (data["errno"] == 0)
				alert("已更新用户信息！")
            else
            	alert("更新失败！");
		}
	});
}