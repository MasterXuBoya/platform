/* 表格的间隔背景  */
function cb(){
  var table = document.getElementById("table");
  var rows = table.rows.length;
  for(var i=0;i<rows;i++){
   if(i%2 == 0){
      table.rows[i].style.backgroundColor = "white";
   }
   if(i%2 == 1){
	  table.rows[i].style.backgroundColor = "#f0f0f0";
	   }
 }
}