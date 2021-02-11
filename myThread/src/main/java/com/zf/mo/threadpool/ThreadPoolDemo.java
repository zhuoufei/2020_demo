package com.zf.mo.threadpool;

import com.zf.mo.utils.SleepTool;

import java.util.Random;
import java.util.concurrent.*;

public class ThreadPoolDemo {

    static class Work implements Runnable{
        private String taskName;
        public Work(String taskName){
            this.taskName = taskName;
        }
        private Random r = new Random();
        @Override
        public void run() {
            System.out.println("this is work "+Thread.currentThread().getName());
            SleepTool.sleepMillSeconds(r.nextInt(100)*5);
        }
    }

    static class CallWork implements Callable<String> {
        public CallWork(String taskName){
            this.taskName = taskName;
        }
        private String taskName;

        private Random r = new Random();
        @Override
        public String call() throws Exception {
            System.out.println("this is callwork "+Thread.currentThread().getName());
            SleepTool.sleepMillSeconds(r.nextInt(10)*5);
            return taskName+r.nextInt(100)*5;
        }
    }

    static class IRejectedExecutionHandler implements RejectedExecutionHandler{
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            new Thread(r).start();
        }
    }


    public static void main(String[] args) {

//        ThreadPoolExecutor pool = new ThreadPoolExecutor(2,4,10,TimeUnit.NANOSECONDS,new ArrayBlockingQueue<Runnable>(5),new IRejectedExecutionHandler());
//        for (int i = 0;i<20;i++){
//            pool.execute(new Work("WORK"));
//        }

//        ThreadPoolExecutor pool2 = new ThreadPoolExecutor(2, 2, 10, TimeUnit.MILLISECONDS,
//                new LinkedBlockingQueue<>());
//        for (int i = 0;i<20;i++){
//            Future<String> future = pool2.submit(new CallWork("CALLWORK"));
//            String result = null;
//            try {
//                result = future.get();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } catch (ExecutionException e) {
//                e.printStackTrace();
//            }
//            System.out.println("result:"+result);
//        }
////        pool.shutdown();
//        pool2.shutdown();


//        Runnable command,
//        long initialDelay,
//        long period,
//        TimeUnit unit
        ScheduledThreadPoolExecutor pool = new ScheduledThreadPoolExecutor(4);


//        ScheduledFuture<String> schedule = pool.schedule(new CallWork("Call_work"), 10, TimeUnit.MICROSECONDS);
//        try {
//            String s = schedule.get();
//            System.out.println("result:"+s);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }

        ScheduledFuture<?> schedule = pool.scheduleAtFixedRate(new Work("call_work"), 0, 10,
                TimeUnit.MICROSECONDS);
        try {
            Object o = schedule.get();
            System.out.println(o);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        pool.shutdown();



    }
}
