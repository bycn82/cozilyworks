package com.cozilyworks.aop;
public class TestAOP {

    /** *//**
     * @param args
     */
    public static void main(String[] args) {
        AOPHandler handler = new AOPHandler();
        Object proxy = handler.bind(new FooImpl());
        
        String message = ((Foo) proxy).getMessage("Wing");
        
        System.out.println(message);
    }

}
