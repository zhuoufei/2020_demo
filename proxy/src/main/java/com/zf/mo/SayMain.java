package com.zf.mo;

import sun.misc.ProxyGenerator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class SayMain {

    public static void main(String[] args) {

        try {
            SayInterface sayHello = new SayHello();
//        sayHello.say();
            SayInterface obj = (SayInterface)new SayProxy().getInstance(sayHello);
            obj.say();
            //写入磁盘
            byte[] $Proxy0s = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{SayInterface.class});
            FileOutputStream os = new FileOutputStream("E://$Proxy0.class");
            os.write($Proxy0s);
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
