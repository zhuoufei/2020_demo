package com.zf.mo.utils;

import com.sun.xml.internal.messaging.saaj.util.Base64;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.concurrent.TimeUnit;

public class SleepTool {

    public static void  sleepSeconds(int time){
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void sleepMillSeconds(int time){
        try {
            TimeUnit.MILLISECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String str = "9.89";
        BigDecimal bstr = new BigDecimal(str);
        if(bstr.compareTo(BigDecimal.ZERO) > 0 ){
            System.out.println(bstr.setScale(2, RoundingMode.HALF_UP));
        }else{
            System.out.println("1111111111");
        }
    }
}
