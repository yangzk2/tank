package com.yangzk.tank.v3.strategy;

/**
 * 根据高度进行比较猫的大小
 */
public class CatHeightComparator implements Comparator<Cat> {

    @Override
    public int compare(Cat o1, Cat o2) {
        if(o1.height >  o2.height) return 1;
        else if(o1.height <  o2.height) return -1;
        else return 0;
    }
}
