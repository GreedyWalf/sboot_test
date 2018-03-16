<#assign ctx=request.contextPath/>
<html>
<head>
    <meta charset="UTF-8">
    <script src="http://cdn.bootcss.com/sockjs-client/1.1.1/sockjs.min.js"></script>
    <script src="http://cdn.bootcss.com/stomp.js/2.3.3/stomp.js"></script>
    <script src="http://cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
    <#--<script src="${ctx!}/static/jquery.js"></script>-->
</head>

<body onload="disConnect();">
    <noscript>
        <h2>你的浏览器不支持webSocket</h2>
    </noscript>

    <div>
        <div>
            <button id="connect" onclick="connect();">连接</button>
            <button id="disConnect" onclick="disConnect();">断开连接</button>
        </div>

        <div id="conversationDiv">
            <label>输入你的名字：</label>
            <input type="text" id="name" />
            <button id="sendName" onclick="sendName();">发送</button>
            <p id="response"></p>
        </div>
    </div>
</body>


<script>
    var stompClient = null;
    function setConnected(connected) {
        document.getElementById("connect").disabled = connected;
        document.getElementById("disConnect").disabled = !connected;
        document.getElementById("conversationDiv").style.visibility = connected ? "visible" : "hidden";

        $("#response").html();
    }


    function connect(){
        var socket = new SockJS("${ctx!}/endpointWisely");
        stompClient = Stomp.over(socket);
        stompClient.connect({},function (frame) {
            setConnected(true);
            console.log("Connected: " + frame);
            stompClient.subscribe("${ctx!}/topic/getResponse",function (response) {
                showResponse(JSON.parse(response.body).responseMessage);
            });
        });
    }

    function disConnect() {
        if(stompClient != null){
            stompClient.disconnect();
        }

        setConnected(false);
        console.log("DisConnected");
    }

    function sendName(){
        var name = $("#name").val();
        console.log("name: " + name);
        stompClient.send("/welCome", {}, JSON.stringify({'name':name}));
    }

    function showResponse(message){
        $("#response").html(message);
    }

</script>
</html>