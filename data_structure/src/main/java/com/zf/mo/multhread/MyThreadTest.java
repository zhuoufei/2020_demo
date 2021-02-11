package com.zf.mo.multhread;

public class MyThreadTest {

    public static void main(String[] args) {
        Thread thread = new Thread();
        thread.interrupt();
        boolean interrupted = thread.isInterrupted();

    }
}
