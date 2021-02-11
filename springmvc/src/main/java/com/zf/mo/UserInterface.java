package com.zf.mo;

public interface UserInterface {

    void hello();

    static void staticMethod(){
        System.out.println("UserInterface.staticMethod");
    }

    default void run(){
        System.out.println("UserInterface.run");
    }
}
