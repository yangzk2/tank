package com.yangzk.tank.v3.factory.simple;

/**
 * 魔法扫帚
 */
public class Broom implements Moveable{
    @Override
    public void go() {
        System.out.println("乘坐魔法扫帚");
    }
}
