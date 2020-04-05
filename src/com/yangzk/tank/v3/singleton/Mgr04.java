package com.yangzk.tank.v3.singleton;

/**
 * 懒汉式
 * 为了优化上一个版本所带来的性能比较低的问题紧接着又出现了以下写法的单例模式
 * 就是先判断是不是该对象是不是已经创建出来了 如果当前实例不为空则直接返回，否则则对其进行加锁 这样相比上一个版本
 * 确实可以提高我们大大的提高的了效率 当然仔细看一下这个方法其实还是有问题的她依然是线程不安全的
 * 如在多线程环境下访问该实例依然可能会造成线程安全问题 故而又出现了下面一种单例写法
 */
public class Mgr04 {
    //实例化Mgr02
    private static volatile Mgr04 INSTANCE;
    //构造私有化
    private Mgr04(){}

    /**
     * 全局同意访问点
     * @return
     */
    public static final Mgr04 getInstance(){
        if(null == INSTANCE){
            synchronized(Mgr04.class) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                INSTANCE = new Mgr04();
            }
        }
        return INSTANCE;
    }


    /**
     * 测试案例
     * @param args
     */
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()-> System.out.println(Mgr04.getInstance().hashCode())).start();
        }
    }
}
