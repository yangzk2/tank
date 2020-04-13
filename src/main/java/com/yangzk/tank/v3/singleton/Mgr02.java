package com.yangzk.tank.v3.singleton;

/**
 * 懒汉式
 * 解决了资源浪费问题 但是同时又带来线程不安全的问题
 *
 */
public class Mgr02 {
    //实例化Mgr02
    private static volatile Mgr02 INSTANCE;//volatile 保证原子的可见性
    //构造私有化
    private Mgr02(){}

    /**
     * 全局同意访问点
     * @return
     */
    public static final Mgr02 getInstance(){
        if(null == INSTANCE){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new Mgr02();
        }
        return INSTANCE;
    }


    /**
     * 测试案例
     * @param args
     */
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()-> System.out.println(Mgr02.getInstance().hashCode())).start();
        }
    }
}
