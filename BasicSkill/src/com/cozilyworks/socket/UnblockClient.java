package com.cozilyworks.socket;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class UnblockClient{
	public static void main(String[] args){
		try{
			InetSocketAddress ia=new InetSocketAddress(InetAddress.getLocalHost(),8710);
			SocketChannel client=SocketChannel.open();
			client.connect(ia);
			client.configureBlocking(false);
			sendMessage(client);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static int sendMessage(SocketChannel client){
		System.out.println("Inside SendMessage");
		String msg=null;
		ByteBuffer bytebuf;
		int nBytes=0;
		msg="It's message from client!";
		System.out.println("msg is "+msg);
		bytebuf=ByteBuffer.wrap(msg.getBytes());
		for(int i=0;i<3;i++){
			try{
				nBytes=client.write(bytebuf);
			}catch(IOException e){
				e.printStackTrace();
			}
			System.out.println(i+" finished");
		}
		try{
			Thread.sleep(500);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		try{
			client.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		return nBytes;
	}
}