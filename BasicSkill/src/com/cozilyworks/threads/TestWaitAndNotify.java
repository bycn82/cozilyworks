package com.cozilyworks.threads;

public class TestWaitAndNotify{
	public static void main(String[] args){
		Object lock=new Object();
		A a=new A(lock);
		B b=new B(lock);
		a.start();
		b.start();
	}
}

class A extends Thread{
	private Object lock;
	public A(Object l){
		this.lock=l;
	}
	public void run(){
		//同步了lock,于是需要得到拥有lock的权利才能够执行
		synchronized(lock){
			for(int i=1;i<50;i++){
				if(i%5==0){
					try{
						//告诉一个放弃拥有lock的权利的人说,大家都有权利
						//如果是nofityAll,那么就告诉全部
						lock.notify();
						Thread.sleep(1000);
						//放弃了拥有lock的权利
						lock.wait();
						//Thread.sleep(1000);
					}catch(InterruptedException e){
						e.printStackTrace();
					}
				}
				System.out.println(this.getClass().getSimpleName()+" : "+i);
			}
		}
	}
}

class B extends Thread{
	private Object lock;
	public B(Object l){
		this.lock=l;
	}
	public void run(){
		synchronized(lock){
			for(int i=1;i<50;i++){
				if(i%5==0){
					try{
						lock.notify();
						Thread.sleep(1000);
						lock.wait();
					}catch(InterruptedException e){
						e.printStackTrace();
					}
				}
				System.out.println(this.getClass().getSimpleName()+" : "+i);
			}
		}
	}
}