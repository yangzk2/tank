package com.yangzk.tank.v3.strategy;


import java.util.Arrays;

/**
 * 策略模式
 */
public class Main {
    public static void main(String[] args) {
        //int [] a = {9,3,2,5,7,1,4};
        //Cat[] a = {new Cat(3,3),new Cat(1,1),new Cat(5,5)};
        Dog[] a = {new Dog(3),new Dog(1),new Dog(5)};
        Sorter<Dog> sorter = new Sorter();
        sorter.sort(a, new DogComparator());
        System.out.println(Arrays.toString(a));
    }

}
