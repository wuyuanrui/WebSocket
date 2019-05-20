<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<style type="text/css">
	*{
		margin: 0px;
		padding: 0
	}
	.box .head{
		width: 80%;
		margin: 10px auto;
		
	}
	.box .head h1{
		text-align: center;
		color: pink;
	}

	.box .content{
		border: 3px solid pink;
		width: 60%;
		height: 500px;
		margin: 0px auto;
		overflow: auto;
	}
	.box .content .inner{
		font-size: 15px;
	}

	.box .sub{
		border: 3px solid pink;
		width: 60%;
		margin: 0px auto;
		text-align: center;
	}
	.box .sub .first{
		line-height: 3em;

	}
	.box .sub .secound{
		padding: 10px 40px;
		background-color: pink;

	}
</style>
</head>

<body>

<div class="box">
	<div class="head">
		<h1>欢迎来到：武软锐的聊天室</h1>
	</div>
	<hr>
	<div class="content">
		<p class="inner"></p>
	</div>
	<div class="sub">
		<input class="first" size="100" type="text" />
		<input  class="secound"  type="button" value="发送" onclick="send()"/>
	</div>

</div>



	
	<script type="text/javascript">
	var websocket=null; 
	if('WebSocket' in window){
		websocket=new WebSocket("ws://wyr.wuroob.top/ws/WeChat")
		websocket.onopen=function(){
			
			};
		websocket.onerror=function(){
			alert("连接失败")
			};
		websocket.onmessage=function(event){
			setMessage(event.data);
				console.log(event);
			};
		websocket.onclose=function(){
			alert("连接中断");
			}
			
		window.onbeforeunload=function(){
			closs();
			};
		}else{
			alert("不支持");
		}

	//关闭的时候
	function closs(){
		wbsocket.onclose=function(){
			wbsocket.close();
		}
		}

	//接受消息
	function setMessage(str){
			document.getElementsByClassName("inner")[0].innerHTML+=str+"<br>";
		}

	//发送数据给服务器
	function send(){
		var val=document.getElementsByClassName("first")[0].value;
		websocket.send(val);
		}

	
</script>
</body>
</html>