package com.yangzk.tank.v3.strategy;

/**
 * 根据宽度比较猫的大小
 */
public class CatWidthComparator implements Comparator<Cat> {

    @Override
    public int compare(Cat o1, Cat o2) {
        if(o1.weight >  o2.weight) return 1;
        else if(o1.weight <  o2.weight) return -1;
        else return 0;
    }
}
