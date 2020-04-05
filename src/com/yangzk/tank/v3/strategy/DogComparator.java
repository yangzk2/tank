package com.yangzk.tank.v3.strategy;

/**
 * 比较狗的大小
 */
public class DogComparator implements Comparator<Dog> {
    @Override
    public int compare(Dog o1, Dog o2) {
        if(o1.food >  o2.food) return 1;
        else if(o1.food <  o2.food) return -1;
        else return 0;
    }
}
