package com.yangzk.tank.v3.factory.simple;

/**
 * 车辆工厂
 */
public class SimpleVehicleFactory {
    /**
     * 创建车
     * @return
     */
    public Car createCar(){
        return new Car();
    }

    /**
     * 创建飞机
     * @return
     */
    public Plane createPlance(){
        return new Plane();
    }


    /**
     * 创建魔法扫帚
     * @return
     */
    public Broom createBroom(){
        return new Broom();
    }
}
