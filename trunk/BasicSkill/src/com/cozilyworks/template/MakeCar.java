package com.cozilyworks.template;

//汽车组装抽象类
public abstract class MakeCar {
    //组装车头
    abstract void makeHead();
    //组装车身
    abstract void makeBody();
    //组装车尾
    abstract void makeTail();
    //测试
    abstract boolean checkMake();

    public void make() {
        System.out.println("Start make car...");
        makeHead();
        makeBody();
        makeTail();
        if (checkMake()) {
            System.out.println("Make OK.");
        } else {
            System.out.println("Make Failure.");
        }
  }
}