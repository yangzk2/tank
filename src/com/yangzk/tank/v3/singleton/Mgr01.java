package com.yangzk.tank.v3.singleton;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 饿汉式
 * 类加载到内存后，就实例化一个单例，JVM保证线程安全
 * 简单实用，推荐使用
 * 唯一缺点：不管使用与否，类装载时就完成实例化
 *
 */
public class Mgr01 implements  Serializable{
    //实例化Mgr01
    private static final Mgr01 INSTANCE = new Mgr01();
    //构造私有化
    private Mgr01(){
        if(null != INSTANCE){
            throw new RuntimeException("不允许实例化多个对象");
        }
    }

    /**
     * 全局同意访问点
     * @return
     */
    public static Mgr01 getInstance(){
        return INSTANCE;
    }

    /**
     * 测试案例
     * @param args
     */
    public static void main(String[] args) {
       /* Mgr01 instance1 = Mgr01.getInstance();
        Mgr01 instance2 = Mgr01.getInstance();
        System.out.println(instance1 == instance2);*/


       /* for (int i = 0; i < 100; i++) {
            new Thread(()-> System.out.println(Mgr07.getInstance().hashCode())).start();
        }*/

        /*try {
            Constructor<Mgr01> declaredConstructor = Mgr01.class.getDeclaredConstructor(null);
            declaredConstructor.setAccessible(true);
            Mgr01 mgr01 = declaredConstructor.newInstance();
            Mgr01 mgr011 = declaredConstructor.newInstance();
            System.out.println(mgr01 == mgr011);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }*/


       /* Mgr01 instance1 = Mgr01.getInstance();
        Mgr01 instance2 = null;
        try {
            //序列化
            //创建一个文件输出流
            FileOutputStream fileOutputStream = new FileOutputStream("Mgr01.java");
            //创建一个对象输出流
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            //将对象输出到一个文件中
            objectOutputStream.writeObject(instance1);
            objectOutputStream.flush();
            objectOutputStream.close();
            fileOutputStream.close();
            //反序列化
            FileInputStream fileInputStream = new FileInputStream("Mgr01.java");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            instance2 = (Mgr01)objectInputStream.readObject();
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
    //重写readResovle方法防止单例被序列化反序列化破环
    private Object readResolve(){
        return INSTANCE;
    }
}
