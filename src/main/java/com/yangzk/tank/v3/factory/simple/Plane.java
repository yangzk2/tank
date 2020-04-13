package com.yangzk.tank.v3.factory.simple;

public class Plane implements Moveable{
    /**
     * 开飞机的方法
     */
    @Override
    public void go() {
        System.out.println("-------坐飞机-------------");
    }
}
