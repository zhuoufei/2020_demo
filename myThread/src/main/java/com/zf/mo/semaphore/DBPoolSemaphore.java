package com.zf.mo.semaphore;

import com.zf.mo.utils.DBConnection;

import java.sql.Connection;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class DBPoolSemaphore {

    private final static int POOL_SIZE = 10;
    private static LinkedList<Connection> pool = new LinkedList();
    private Semaphore useful,useless;

    public DBPoolSemaphore(){
        useful = new Semaphore(POOL_SIZE);
        useless = new Semaphore(0);
    }

    static {
        for (int i = 0; i < POOL_SIZE; i++) {
            pool.add(new DBConnection());
        }
    }

    public void returnConn(Connection conn) throws Exception{
        if(conn != null){
            useless.acquire();
            synchronized (pool){
                pool.addLast(conn);
            }
            useful.release();
        }
    }

    public Connection takeConn()throws Exception{
        Connection connection = null;
        useful.acquire();
        synchronized (pool){
            connection = pool.removeFirst();
        }
        useless.release();
        return connection;
    }


}
