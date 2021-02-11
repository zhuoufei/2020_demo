package com.zf.mo.mybatis;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Collection;

public class ProxyInvocationHandler implements InvocationHandler {

    private SqlSession sqlSession;
    public ProxyInvocationHandler(SqlSession sqlSession){
        this.sqlSession = sqlSession;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Class<?> returnType = method.getReturnType();
        String name = method.getDeclaringClass().getName();
        System.out.println("ProxyInvocationHandler.name:"+name);
        if(Collection.class.isAssignableFrom(returnType)){
           return sqlSession.selectList(name+"."+method.getName(),args==null?null:args[0]);
        }else{
            return sqlSession.selectOne(name+"."+method.getName(),args==null?null:args[0]);
        }
    }

}
