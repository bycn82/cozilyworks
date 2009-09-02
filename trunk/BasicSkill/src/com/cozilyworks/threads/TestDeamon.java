package com.cozilyworks.threads;

import java.util.Date;

public class TestDeamon{
	public static void main(String[] args){
		MyDeamon deamon=new MyDeamon();	
		//把一个线程设置为守护线程
		deamon.setDaemon(true);
		deamon.start();
		//main先别结束
		try{
			Thread.sleep(2000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		//main结束了,守护也没有意义了,就退出
		//如果還有線程在,都需要繼續守護
	}
}

class MyDeamon extends Thread{
	public void run(){
		while(true){
			System.out.println(new Date().toLocaleString());
			try{
				Thread.sleep(500);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
}
