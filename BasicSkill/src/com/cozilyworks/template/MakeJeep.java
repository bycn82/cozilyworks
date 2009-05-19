package com.cozilyworks.template;

//吉普车组装类  
public class MakeJeep extends MakeCar {
	// 组装车头
	void makeHead() {
		System.out.println("Make Jeep head.");
	}

	// 组装车身
	void makeBody() {
		System.out.println("Make Jeep body.");
	}

	// 组装车尾
	void makeTail() {
		System.out.println("Make Jeep tail.");
	}

	// 测试
	boolean checkMake() {
		return true;
	}
}