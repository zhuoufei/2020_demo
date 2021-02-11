package com.zf.mo.mybatis;



import com.sun.deploy.util.ReflectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DefaultExecutor implements Executor {

    private final Configuation conf;

    public DefaultExecutor(Configuation conf){
        this.conf = conf;
    }
    @Override
    public <E> List<E> query(MappedStatement ms, Object param) {
        System.out.println("DefaultExecutor:"+ms.getSql());

        return null;
    }
}
