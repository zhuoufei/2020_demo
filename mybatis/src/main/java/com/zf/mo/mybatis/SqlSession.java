package com.zf.mo.mybatis;

import com.sun.xml.internal.ws.Closeable;

import java.util.List;

public interface SqlSession extends Closeable {

    <T> T selectOne(String statement,Object parameter);

    <E> List<E> selectList(String statement,Object parameter);

    <T> T getMapper(Class<T> var1);


}
