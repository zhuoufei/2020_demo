package com.zf.mo.utils;

public class Permission {

    public static final int ALLOW_SELECT = 1 << 0;// 0001

    public static final int ALLOW_INSERT = 1 << 1;//0010

    public static final int ALLOW_UPDATE = 1 << 2;//0100

    public static final int ALLOW_DELETE = 1 << 3;//1000
    //存储当前的权限状态
    private int flag;

    public void setPer(int per){
        flag = per;
    }
    //增加用户权限
    public void enable(int per){
        flag = flag | per;
    }
    //删除用户权限
    public void disPer(int per){
        flag = flag&~per;
    }
    //判断用户的权限
    public boolean isAllow(int per){
        return ((flag&per) == per);
    }
    //判断用户没有的权限
    public boolean isNotAllow(int per){
        return (flag&per) == 0;
    }

    public static void main(String[] args) {
        int flag = 15;
        Permission permission = new Permission();
        permission.setPer(flag);
        permission.disPer(ALLOW_UPDATE|ALLOW_DELETE);
        System.out.println(permission.isNotAllow(ALLOW_SELECT));
        System.out.println(permission.isNotAllow(ALLOW_INSERT));
        System.out.println(permission.isNotAllow(ALLOW_UPDATE));

    }
}
