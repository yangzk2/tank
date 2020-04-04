package com.yangzk.tank.v3.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 懒汉式 双重检测锁
 * 这种单例模式一种比较完美的写法 既解决了资源浪费的问题 又解决了线程安全问题及性能低的问题
 * 当然这种单例的写法也变的 复杂了起来
 * 那么有没有更简单的一种单例的写法呢 问题只有一个答案 那就是当然有 请看下种写法
 * 当然 这种写法也不是最安全的写法 因为它没法办法防止反射的破坏
 */
public class Mgr05 {
    //实例化Mgr02
    private static Mgr05 INSTANCE;
    //构造私有化
    private Mgr05(){
    }

    /**
     * 全局同意访问点
     * @return
     */
    public static final Mgr05 getInstance(){
        if(null == INSTANCE){
            synchronized(Mgr05.class) {
                if(null == INSTANCE){
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    INSTANCE = new Mgr05();
                }
            }
        }
        return INSTANCE;
    }


    /**
     * 测试案例
     * @param args
     */
    public static void main(String[] args) {
       /* for (int i = 0; i < 100; i++) {
            new Thread(()-> System.out.println(Mgr05.getInstance().hashCode())).start();
        }*/
        try {
            Constructor<Mgr05> declaredConstructor = Mgr05.class.getDeclaredConstructor(null);
            declaredConstructor.setAccessible(true);
            Mgr05 mgr05 = declaredConstructor.newInstance();
            Mgr05 mgr051 = declaredConstructor.newInstance();
            System.out.println(mgr05 == mgr051);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
