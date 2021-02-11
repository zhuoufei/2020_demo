package com.zf.mo.mybatis;

import java.util.List;

public interface Executor {

    <E> List<E> query(MappedStatement ms,Object param);
}
