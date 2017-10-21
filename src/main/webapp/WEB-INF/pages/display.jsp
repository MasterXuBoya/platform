<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>钛比科技智慧电表管理平台</title>
    <script src="/static/js/jquery.min.js"></script>

    <script>
        $(document).ready(function(){
            document.getElementById("showmessage").innerHTML="<p>"+"654321"+"</p>";
        })
    </script>
</head>
<body>
<button id="testButton" onclick="callpay()">异步传输</button>
<div id = "showmessage" >
    <p>123</p>
</div>
<img src="/static/pic/titleall.png" width = "100%" height = "150%" align="center"/>

<script>
    function callpay()
    {
        document.getElementById("showmessage").innerHTML="<p>"+"3121123"+"</p>";
        $.ajax({
            type:'GET',
            url:'/getTotalNumber',
            data: {
            },
            dataType: 'json',
            error: function(XMLHttpRequest, textStatus, errorThrown){
                alert(XMLHttpRequest.status);
            },
            success:function(data){
                var data = data["key"]["password"];
                document.getElementById("showmessage").innerHTML="<p>"+data+"</p>";
            }
        });
    }

    function numberInit() {

    }
</script>
</body>
</html>
