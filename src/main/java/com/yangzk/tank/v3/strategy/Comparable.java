package com.yangzk.tank.v3.strategy;

/**
 * 自定义Comparable接口用于实现排序
 */
public interface Comparable<T> {
    /**
     * 比较方法
     * @param t
     */
    int compareTo(T t);
}
