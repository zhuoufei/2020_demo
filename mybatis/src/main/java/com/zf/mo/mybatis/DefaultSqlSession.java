package com.zf.mo.mybatis;

import org.apache.ibatis.exceptions.TooManyResultsException;

import javax.xml.ws.WebServiceException;
import java.lang.reflect.Proxy;
import java.util.List;

public class DefaultSqlSession implements SqlSession {

    private final Configuation conf;

    private Executor executor;

    public DefaultSqlSession(Configuation conf){
        this.conf = conf;
        executor = new DefaultExecutor(conf);
    }

    @Override
    public <T> T selectOne(String statement,Object parameter) {
        System.out.println("statement:"+statement);
        System.out.println("parameter:"+parameter);
        List<T> list = this.selectList(statement, parameter);
        if(list.size() == 1){
            return list.get(0);
        }else if(list.size() > 1){
            throw new TooManyResultsException("Expected one result (or null) to be returned by selectOne(), but found: " + list.size());
        }else{
            return null;
        }
    }

    @Override
    public <E> List<E> selectList(String statement,Object parameter) {
        MappedStatement mappedStatement = conf.getMappedStatementMap().get(statement);
        System.out.println("mappedStatement:"+mappedStatement);
        executor.query(mappedStatement,null);
        return null;
    }

    @Override
    public <T> T getMapper(Class<T> var1) {
        ProxyInvocationHandler h = new ProxyInvocationHandler(this);
        return (T)Proxy.newProxyInstance(var1.getClassLoader(),new Class[]{var1},h);
    }

    @Override
    public void close() throws WebServiceException {

    }
}
