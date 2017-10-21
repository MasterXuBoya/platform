/* 在下拉框中加载imei号  */
function loadmeter(){
	Loadcookieimei();
	//加载imei号
	cbuilding = getCookie("cimei");
	allimei = new Array(); 
	allimei = cbuilding.split(",");
	for (i = 0;i < allimei.length; i++){
		$("#imei").append("<option value="+ allimei[i] +">"+ allimei[i] +"</option>");
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

/** 更改选中的后背景函数：changeback*() */
function changebacka(){
	   var obj = document.getElementById("m_add");
	   obj.style.cssText = "background-color:#066b65;font-size:16px;color:white;margin-left:0.15%;margin-top:5px;max-width:130px;min-width:80px;"
	   var obj = document.getElementById("m_delete");
	   obj.style.cssText = "background-color:#0e9c76;color:#e9e9e9;max-width:130px;min-width:80px;"
	   var obj = document.getElementById("change");
}

function changebackb(){
	   var obj = document.getElementById("m_add");
	   obj.style.cssText = "background-color:#0e9c76;color:#e9e9e9;margin-left:0.15%;margin-top:5px;max-width:130px;min-width:80px;"
	   var obj = document.getElementById("m_delete");
	   obj.style.cssText = "background-color:#066b65;font-size:16px;color:white;max-width:130px;min-width:80px;"
}


/** 增加电表提交数据 */
function m_add(){
	var imei = document.getElementById("imei").value;
	var addmeterIdArray = document.getElementsByName("meterId");
	var addbuildingArray = document.getElementsByName("building");
	var addroomArray = document.getElementsByName("room");
	var jsonArray = [];
	for (var i = 0; i < addmeterIdArray.length; i++) {
		var jsonObject = {
						"meterId":addmeterIdArray[i].value,
						"building":addbuildingArray[i].value,
						"room":addroomArray[i].value
						};
		jsonArray[i] = jsonObject;
		
	}
	flag = window.confirm("是否要向终端号为:"+imei+" 的设备添加电表？");
	if (flag == true){ 
		$.ajax({
			type:'POST',
			url:'/platform/meter/add',
			async: false,
			data:{
				"imei":$("#imei").val(),
				"data":JSON.stringify(jsonArray)
			},
			dataType:'json',
			success:function(data){
				if (data["errno"] == 0) {
					alert("添加成功！");
				}
				else{
					alert(data["error"]);
				}
			}
		});
	}
}

/** 删除电表提交数据 */
function m_delete(){
	if( $("#building").val() == "" || $("#building").val() == "请输入楼号" || $("#room").val() == "" || $("#building").val() == "请输入室号"){
		alert("输入信息不正确");
	}
	else{
		flag = window.confirm("是否要删除楼号为: "+$("#building").val()+" ,室号为: "+$("#room").val()+" 的电表？");
		if (flag == true){
			$.ajax({
				type:'POST',
				url:'/platform/meter/remove',
				data:{
					"building":$("#building").val(),
					"room":$("#room").val()
				},
				dataType:'json',
				success:function(data){
					if (data["errno"] == 0) {
						alert("删除成功！");
					}
					else{
						alert(data["error"]);
					}
				}
			});
		}
	}
}



/*  增加行（电表-楼号-室号） */
function add() {
	if($('#information').children().length < 10)
		$("#information").append($("#add_div").clone());
	else
		alert("已达到添加上限！");
}

/*  删除行（电表-楼号-室号） */
function del() {
	$("#add_div").remove();
}