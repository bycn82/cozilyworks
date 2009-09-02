package com.cozilyworks.threads;

public class TestJoin{
	public static void main(String[] arg){
		ThreadOne t=new ThreadOne();
		t.start();
		System.out.println("begin");
		try{
			t.join();
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		//由于t join进来,所以,需要等待t的结束,才能进行
		System.out.println("end");
	}
}

class ThreadOne extends Thread{
	public void run(){
		stop4(2);
		System.err.println("start");
		stop4(2000);
		System.err.println("stop");
		stop4(2);
	}
	public void stop4(long millis){
		try{
			Thread.sleep(millis);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}
