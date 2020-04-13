package com.yangzk.tank.v3.factory.simple;

/**
 * 车
 */
public class Car implements Moveable{
    /**
     * 开车的方法
     */
    @Override
    public void go() {
        System.out.println("---------坐车-----------");
    }
}
