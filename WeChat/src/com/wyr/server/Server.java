package com.wyr.server;

import java.io.IOException;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/ws/WeChat")
public class Server {
	private  Session session;
	
	//将前端传递过来的Session，保存在服务端
	@OnOpen
	public  void onopen(Session session) throws IOException{
		this.session=session;
		ServerManager.add(this);
		sendMessage("欢迎屌丝登场！");
	}
	
	//当前用户退出当前的Websocket服务器
	@OnClose
	public  void onclose(){
		ServerManager.remove(this);
	}
	
	//客户端发消息过来
	@OnMessage
	public  void onmessage(String msg,Session session) throws IOException{
		System.out.println("来自客户端的消息"+msg);
		//消息群发
		int num=ServerManager.getTotal();
		ServerManager.broacast(msg,num);
	}
	
	@OnError
	public  void error(Session session,Throwable error){
		System.out.println("出错了");
		error.printStackTrace();
	}
	
	//单独发送给当前用户
	public  void sendMessage(String msg) throws IOException{
		this.session.getBasicRemote().sendText(msg);
		
	}
	
	//单独发送人数
	public  void sendNum(int i) throws IOException{
		this.session.getBasicRemote().sendText(String.valueOf(i));
	}
	
	
	
	
	
}
