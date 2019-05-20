package com.wyr.server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ServerManager {
	public static Collection<Server> user= Collections.synchronizedList(new ArrayList<Server>());
	
	public static void add(Server server){
		user.add(server);
		System.out.println("�û���"+server+"���������ҵ�ǰ������"+user.size());
	}
	
	public static void remove(Server server){
		user.remove(server);
		System.out.println("�û���"+server+"�Ƴ������ҵ�ǰ������"+user.size());
		
	}
	
	//����ÿ��User��ȡ������Ϣ Ⱥ��
	public static void broacast(String msg,int num) throws IOException{
		for(Server s:user){
			s.sendMessage(msg);
			s.sendNum(num);
		}	
	}
	
	//��ȡ��������
	public static int getTotal(){
		return user.size();
	}
	
}
