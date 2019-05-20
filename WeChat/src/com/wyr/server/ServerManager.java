package com.wyr.server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ServerManager {
	public static Collection<Server> user= Collections.synchronizedList(new ArrayList<Server>());
	
	public static void add(Server server){
		user.add(server);
		System.out.println("用户："+server+"进入聊天室当前人数："+user.size());
	}
	
	public static void remove(Server server){
		user.remove(server);
		System.out.println("用户："+server+"推出聊天室当前人数："+user.size());
		
	}
	
	//调用每个User调取传送消息 群发
	public static void broacast(String msg,int num) throws IOException{
		for(Server s:user){
			s.sendMessage(msg);
			s.sendNum(num);
		}	
	}
	
	//获取在线人数
	public static int getTotal(){
		return user.size();
	}
	
}
