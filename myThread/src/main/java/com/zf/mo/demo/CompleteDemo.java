package com.zf.mo.demo;

import com.zf.mo.utils.SleepTool;

import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class CompleteDemo {

    private static long startTime = System.currentTimeMillis();
    private static AtomicInteger atomicInteger = new AtomicInteger();
    private static class Work implements Callable<Integer> {
        Random r = new Random();
        @Override
        public Integer call() throws Exception {
            int i = r.nextInt(100);
            SleepTool.sleepMillSeconds(i);
            System.out.println("系统时间差:"+(System.currentTimeMillis()-startTime));
            atomicInteger.addAndGet(i);
            return i;
        }
    }

    public static void main(String[] args)throws Exception {

        ExecutorService pool = Executors.newFixedThreadPool(10);
        //先执行完成先返回线程的结果
        CompletionService<Integer> completionService = new ExecutorCompletionService<Integer>(pool);
        for (int i = 0; i < 10; i++) {
            Future<Integer> future = completionService.submit(new Work());
            Integer integer = future.get();
            System.out.println("执行任务消耗时间:"+integer);
        }

        //----------------------------------------------------
//        ExecutorService pool = Executors.newFixedThreadPool(10);
//        for (int i = 0; i < 10; i++) {
//            Future<Integer> future = pool.submit(new Work());
//            Integer integer = future.get();
//            System.out.println("执行任务消耗时间:"+integer);
//        }


    }

}
