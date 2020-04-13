package com.yangzk.tank.v3.factory.simple;

/**
 * 工厂模式
 */
public class Main {
    public static void main(String[] args) {
      /*  Car car = new Car();
        car.go();
        Plane plane = new Plane();
        plane.go();*/
      /*Moveable moveable = new Plane();
      moveable.go();*/
        SimpleVehicleFactory simpleVehicleFactory = new SimpleVehicleFactory();
        simpleVehicleFactory.createCar().go();
        simpleVehicleFactory.createPlance().go();
        simpleVehicleFactory.createBroom().go();
    }
}
