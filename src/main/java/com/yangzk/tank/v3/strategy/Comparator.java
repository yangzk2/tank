package com.yangzk.tank.v3.strategy;

/**
 * 自定义比较器 策略模式
 * @param <T>
 */
@FunctionalInterface
public interface Comparator<T> {

    int compare(T o1,T o2);
}
