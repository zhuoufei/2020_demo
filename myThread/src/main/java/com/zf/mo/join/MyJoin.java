package com.zf.mo.join;

import com.zf.mo.utils.SleepTool;

public class MyJoin {

    private static class JumpQueue implements Runnable{

        private Thread thread;
        public JumpQueue(Thread thread){
            this.thread = thread;
        }
        public void run() {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" terminted.");
        }
    }

    public static void main(String[] args) {

        Thread mainThread = Thread.currentThread();

        for (int i = 0; i <10 ; i++) {

            Thread thread = new Thread(new JumpQueue(mainThread), String.valueOf(i));
            System.out.println(mainThread.getName()+" : jump in "+thread.getName());
            thread.start();
            mainThread = thread;
        }
        SleepTool.sleepSeconds(2);
        System.out.println("main thread is end " );

    }
}
