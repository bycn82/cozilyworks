package com.cozilyworks.concurrent;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * ExecuteService 提供一个环境,用来跑线程的,但是这个环境只允许有限个线程在运行
 */
public class TestThreadService {
	public static void main(String args[]) throws InterruptedException {
		//通过Executors获得一个环境
		ExecutorService exec = Executors.newFixedThreadPool(3);
		//往里面塞,这个过程是不阻塞的,但是里面只能用3个同时运行
		for (int i = 0; i < 10; i++) {
			A a = new A(String.valueOf(i));
			exec.execute(a);
			B b = new B(String.valueOf(i));
			exec.execute(b);
			System.out.println("go");
		}
		
		exec.shutdown();
	}
}

class A implements Runnable {
	private String name;

	public A(String i) {
		this.name = i;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + "  A  " + name);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}

	}

}

class B implements Runnable {
	private String name;

	public B(String i) {
		this.name = i;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + "  B  " + name);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}

	}

}