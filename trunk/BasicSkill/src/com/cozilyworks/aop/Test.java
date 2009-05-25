package com.cozilyworks.aop;
public class Test {

    /** *//**
     * @param args
     */
    public static void main(String[] args) {
        Foo foo = new StaticProxy(new FooImpl());
        String message = foo.getMessage("Wing");
        System.out.println(message);
    }

}
