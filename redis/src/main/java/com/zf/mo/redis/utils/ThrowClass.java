package com.zf.mo.redis.utils;

public class ThrowClass {


    private static String run(String p1,String p2){
        assert p1 == null : "p1 should not be null";
        assert p2 != null : "p2 should not be null";
        return (p1+p2);

    }

    private static void run2(){

    }

    public static void main(String[] args) {
        run(null ,"123");
    }
}
