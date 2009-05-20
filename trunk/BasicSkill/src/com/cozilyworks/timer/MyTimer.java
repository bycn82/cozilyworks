package com.cozilyworks.timer;

import java.util.Timer;
import java.util.TimerTask;

public class MyTimer {

	public static void main(String[] args) throws InterruptedException {
		MyTimerTask t=new MyTimerTask();
		Timer timer=new Timer();
		timer.schedule(t, 3,1000);
		Thread.sleep(5000);
		timer.cancel();
	}

}
class MyTimerTask extends TimerTask{

	@Override
	public void run() {
		System.out.println("on time invoked");
	}
	
}
