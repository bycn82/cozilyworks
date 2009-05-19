package com.cozilyworks.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class BlockServer{
	public static void main(String[] args){
		try{
			ServerSocket ss=new ServerSocket(5678);
			Socket s=ss.accept();
			BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
			while(true){
				String str=br.readLine();
				System.out.println(str);
			}
			//s.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}