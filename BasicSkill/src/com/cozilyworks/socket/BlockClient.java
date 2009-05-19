package com.cozilyworks.socket;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class BlockClient{
	public static void main(String[] args){
		try{
			Socket sk=new Socket(InetAddress.getLocalHost(),5678);
			PrintWriter bw=new PrintWriter(new OutputStreamWriter(sk.getOutputStream()));
			int i=0;
			while(true){
				bw.println(i++);
				bw.flush();
				Thread.sleep(5000);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}