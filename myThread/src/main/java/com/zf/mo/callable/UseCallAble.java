package com.zf.mo.callable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class UseCallAble implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {

        System.out.println("callable 开始计算。。。。");
        int sum = 0;
        for (int i =0;i<1000;i++){
            sum += i;
        }
        System.out.println("callable 计算结果为sum:"+sum);
        return sum;
    }

    public static void main(String[] args) throws Exception{

        UseCallAble useCallAble = new UseCallAble();
        FutureTask<Integer> futureTask = new FutureTask<Integer>(useCallAble);
        new Thread(futureTask).start();
        Random random = new Random();
        if(random.nextBoolean()){
            System.out.println("返回结果："+futureTask.get());
        }else{
            futureTask.cancel(true);
            System.out.println("callable 中断");
        }
    }

}
