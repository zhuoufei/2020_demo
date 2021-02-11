package com.zf.mo.multhread.express;

public class Express {

    public static String CITY = "ShangHai";

    private int km;

    private String site;

    public Express(int km,String site){
        this.km = km;
        this.site = site;
    }

    public synchronized void changeKM(){
        this.km = 101;
        notifyAll();
    }

    public synchronized void changeSite(){
        this.site = "BeiJing";
        notifyAll();
    }

    public synchronized void waitKM(){
        while(km <=100){
            try {
                System.out.println(Thread.currentThread().getId()+" before");
                wait();
                System.out.println(Thread.currentThread().getId()+"waitKM");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getId()+"waitKM this is notify");
    }

    public synchronized void waitSite(){

        while(CITY.equals(site)){
            try {
                System.out.println(Thread.currentThread().getId()+"before");
                wait();
                System.out.println(Thread.currentThread().getId()+"waitSite");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getId()+"waitSite is notify ");
        }
    }


}
