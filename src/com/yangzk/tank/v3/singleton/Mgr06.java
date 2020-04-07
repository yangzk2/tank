package com.yangzk.tank.v3.singleton;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 静态内部类写法
 * 懒汉式单例模式
 * 这种单例写法结合了懒汉式与饿汉式的优点 算的上是一种比较完美的单例写法了
 * 既没有产生性能上的问题 有没有造成资源的浪费
 * 也阻止了反射的破环和序列化破环问题
 * 当然 我们的java的作者就为我们提供了一种单例的写法就是枚举式单例
 */
public class Mgr06 implements Serializable{

    private static final long serialVersionUID = 8526934037791845468L;

    //构造私有化
    private Mgr06(){
        if(null != LAZY.INSTANCE){//解决反射破环单例的问题
            throw new RuntimeException("不允许实例化多个对象");
        }
    }
    //私有化内部类 只有当被调用的时候才会被初始化
    private static class LAZY{
        private static final Mgr06 INSTANCE = new Mgr06();
    }

    /**
     * 全局同意访问点
     * @return
     */
    public static final Mgr06 getInstance(){
       return LAZY.INSTANCE;
    }

    //重写readResovle方法防止单例被序列化反序列化破环
    private Object readResolve(){
        return LAZY.INSTANCE;
    }
    /**
     * 测试案例
     * @param args
     */
    public static void main(String[] args) {
        /*for (int i = 0; i < 100; i++) {
            new Thread(()-> System.out.println(Mgr06.getInstance().hashCode())).start();
        }*/

        try {
            Constructor<Mgr06> declaredConstructor = Mgr06.class.getDeclaredConstructor(null);
            declaredConstructor.setAccessible(true);
            Mgr06 mgr06 = declaredConstructor.newInstance();
            Mgr06 mgr061 = declaredConstructor.newInstance();
            System.out.println("mgr06.hashCode():"+ mgr06.hashCode());
            System.out.println("mgr061.hashCode():"+mgr061.hashCode());
            System.out.println("反射实例化后的实例是不是同一个：");
            System.out.println(mgr06 == mgr061);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
       /* Mgr06 instance1 = Mgr06.getInstance();
        Mgr06 instance2 = null;
        try {
            //序列化
            //创建一个文件输出流
            FileOutputStream fileOutputStream = new FileOutputStream("Mgr06.java");
            //创建一个对象输出流
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            //将对象输出到一个文件中
            objectOutputStream.writeObject(instance1);
            objectOutputStream.flush();
            objectOutputStream.close();
            fileOutputStream.close();
            //反序列化
            FileInputStream fileInputStream = new FileInputStream("Mgr06.java");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            instance2 = (Mgr06)objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
            System.out.println("比较序列化之前和之后是不是同一个对象:");
            System.out.println(instance1==instance2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/


    }
}
