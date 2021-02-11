package com.zf.mo.demo;

import java.util.HashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class TaskExecutionWebServer {

    private static final int NTHREADS = 10;


    public static void main(String[] args) {

        int i = Runtime.getRuntime().availableProcessors();
        System.out.println(i);

//        System.out.println("this is 4:"+Integer.toBinaryString(4));
//        System.out.println("this is 6:"+Integer.toBinaryString(6));
//        System.out.println("this is 4&6:"+ Integer.toBinaryString(4&6));
//        System.out.println("this is 4|6:"+ Integer.toBinaryString(4|6));
//        System.out.println("this is ~:"+ Integer.toBinaryString(~4));
//        System.out.println("this is 4^6:"+ Integer.toBinaryString(4^6));
//        System.out.println("345%5="+345%4);
//        System.out.println("345&3="+(345&3));
    }
}
