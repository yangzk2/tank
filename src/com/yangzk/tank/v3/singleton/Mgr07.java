package com.yangzk.tank.v3.singleton;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 枚举式单例
 *  最完美的单例 也是官方最推荐的
 *
 *  枚举没有午餐的构造方法
 *  jdk层面就已经屏蔽了反射对枚举类的创建
 */
public enum  Mgr07 {

    INSTANCE;
    public static Mgr07 getInstance(){
        return INSTANCE;
    }


    /**
     * 测试案例
     * @param args
     */
    public static void main(String[] args) {
        /*for (int i = 0; i < 100; i++) {
            new Thread(()-> System.out.println(Mgr07.getInstance().hashCode())).start();
        }*/

        try {
            Constructor<Mgr07> declaredConstructor = Mgr07.class.getDeclaredConstructor(String.class,int.class);
            declaredConstructor.setAccessible(true);
            Mgr07 mgr07 = (Mgr07)declaredConstructor.newInstance();
            Mgr07 mgr071 = declaredConstructor.newInstance();
            System.out.println(mgr07 == mgr071);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
      /*  Mgr07 instance1 = Mgr07.getInstance();
        Mgr07 instance2 = null;
        try {
            //序列化
            //创建一个文件输出流
            FileOutputStream fileOutputStream = new FileOutputStream("Mgr07.java");
            //创建一个对象输出流
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            //将对象输出到一个文件中
            objectOutputStream.writeObject(instance1);
            objectOutputStream.flush();
            objectOutputStream.close();
            fileOutputStream.close();
            //反序列化
            FileInputStream fileInputStream = new FileInputStream("Mgr07.java");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            instance2 = (Mgr07)objectInputStream.readObject();
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
