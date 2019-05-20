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
	
	//��ǰ�˴��ݹ�����Session�������ڷ����
	@OnOpen
	public  void onopen(Session session) throws IOException{
		this.session=session;
		ServerManager.add(this);
		sendMessage("��ӭ��˿�ǳ���");
	}
	
	//��ǰ�û��˳���ǰ��Websocket������
	@OnClose
	public  void onclose(){
		ServerManager.remove(this);
	}
	
	//�ͻ��˷���Ϣ����
	@OnMessage
	public  void onmessage(String msg,Session session) throws IOException{
		System.out.println("���Կͻ��˵���Ϣ"+msg);
		//��ϢȺ��
		int num=ServerManager.getTotal();
		ServerManager.broacast(msg,num);
	}
	
	@OnError
	public  void error(Session session,Throwable error){
		System.out.println("������");
		error.printStackTrace();
	}
	
	//�������͸���ǰ�û�
	public  void sendMessage(String msg) throws IOException{
		this.session.getBasicRemote().sendText(msg);
		
	}
	
	//������������
	public  void sendNum(int i) throws IOException{
		this.session.getBasicRemote().sendText(String.valueOf(i));
	}
	
	
	
	
	
}
