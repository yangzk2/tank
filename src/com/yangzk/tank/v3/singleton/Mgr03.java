package com.yangzk.tank.v3.singleton;

/**
 * 懒汉式
 * 解决了资源浪费问题 但是同时又带来线程不安全的问题
 * 为了解决懒汉式单例上一个版本所带来的线程不安全问题 这个时候对线程进行加锁
 * 但是同时又随之带来了另外的一个问题 就是性能问题 加锁必然 会导致性能上效率比较低
 */
public class Mgr03 {
    //实例化Mgr02
    private static Mgr03 INSTANCE; //vloatile 保证原子的可见性
    //构造私有化
    private Mgr03(){}

    /**
     * 全局同意访问点
     * @return
     */
    public static synchronized Mgr03 getInstance(){
        if(null == INSTANCE){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new Mgr03();
        }
        return INSTANCE;
    }


    /**
     * 测试案例
     * @param args
     */
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()-> System.out.println(Mgr03.getInstance().hashCode())).start();
        }
    }
}
