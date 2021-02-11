package com.zf.mo;

public class UserApp implements UserInterface,User2Interface {

    public static void main(String[] args) {
        UserApp userApp = new UserApp();
        userApp.run();
        UserInterface.staticMethod();
    }
    @Override
    public void hello() {

    }
    @Override
    public void run() {
        System.out.println("UserApp.run");
    }


}
