package com.zf.mo.multhread.express;

import com.zf.mo.utils.SleepTool;

public class TestWN {

    private static final Express express = new Express(0,Express.CITY);
    private static class ChangeKM extends Thread{
        @Override
        public void run() {
            express.waitKM();
        }
    }

    private static class ChangeSite extends Thread{
        @Override
        public void run() {
            express.waitSite();
        }
    }

    public static void main(String[] args) {

        for (int i = 0; i <3 ; i++) {
            new ChangeKM().start();
        }

        for (int i = 0; i <3 ; i++) {
            new ChangeSite().start();
        }

        SleepTool.sleepSeconds(1);

        express.changeSite();



    }
}
