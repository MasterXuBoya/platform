window.onresize = function(){
	document.location.reload();
}

/** 三个部分的页面跳转 */
function opendata(){
	parent.document.getElementById("inquiry").click();
	parent.document.getElementById("inquiry").onmouseout();
	var inputx= document.createElement("input");
	inputx.setAttribute("type", "button");
	inputx.setAttribute("id", "1");
	inputx.style.display="none";
    parent.document.getElementById("header").appendChild(inputx);
}

function openwarning(){
	parent.document.getElementById("inquiry").click();
	parent.document.getElementById("inquiry").onmouseout();
}

function openrecharge(){
	parent.document.getElementById("charge").click();
	parent.document.getElementById("charge").onmouseout();
}

/** 数据查询 */
function query(){
	$.ajax({
		type:'GET',
		url:'/platform/display/day',
		dataType:'json',
		success:function(data){
			if(getJsonObjLength(data) != 0){
				$("#power").append(data["power"]);
				$("#payment").append(data["payment"]);
				$("#alarm").append(data["alarm"]);
			}
			else{
				alert("暂无数据。");
			}
		}
	});
}

/** 绘图部分数据查询 */
function querygraph(){
	$.ajax({
		type:'GET',
		url:'/platform/display/homechart',
		dataType:'json',
		success:function(data){
			var length=getJsonObjLength(data[0]);
			var powerdata=new Array(length);
			var time=new Array(length);
			if(length != 0){
				i=0;
				$.each(data,function(id,obj){
					time[i]=obj['timeId'];
					powerdata[i]=obj['electricity'];
					i++;
				})
				graph(time,powerdata);
			}
			else{
				alert("暂无数据。");
			}
		}
	});
}

//折线图绘制
function graph(time,powerdata){
	var myChart = echarts.init(document.getElementById('main'));
	var option = {
		    tooltip : {
		        trigger: 'axis',
		        axisPointer: {
		        type: 'cross',
		        }
		    },
		    grid: {
		        left: '3%',
		        right: '4%',
		        bottom: '6%',
		        containLabel: true
		    },
		    xAxis : [
		        {
		            type : 'category',
		            name : '时间/小时',
		            boundaryGap : false,
		            nameLocation : 'middle',
		            nameGap : '24',
		            nameTextStyle : '萍方-简',
		            data : [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24]
		        }
		    ],
		    yAxis : [
		        {
		            type : 'value',
		            name : '每小时用电量/度',
		            nameLocation : 'end',
		        }
		    ],
		    series : [
		        {
		            name:'用电量',
		            type:'line',
		            stack: '总量',
		            label: {
		                normal: {
		                    show: true,
		                    position: 'top',
		                }
		            },
		            itmeStyle:{
		            	normal:{}
		            },
		            data:powerdata
		        }
		    ]
		};


	myChart.setOption(option);
}

/** json数据长度 */
function getJsonObjLength(jsonObj) {
    var Length = 0;
    for (var item in jsonObj) {
        Length++;
    }
    return Length;
}