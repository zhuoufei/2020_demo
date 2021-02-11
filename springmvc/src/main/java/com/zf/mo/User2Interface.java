package com.zf.mo;

public interface User2Interface {
    default void run(){
        System.out.println("UserInterface.run");
    }
}
