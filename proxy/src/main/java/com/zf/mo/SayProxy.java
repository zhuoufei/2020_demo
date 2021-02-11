package com.zf.mo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class SayProxy implements InvocationHandler {

    private Object obj;

    public Object getInstance(Object obj){
        this.obj = obj;
        Class<?> clazz = obj.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("this is before.......");
        Object invoke = method.invoke(obj, args);
        System.out.println("this is after.......");
        return invoke;
    }
}
