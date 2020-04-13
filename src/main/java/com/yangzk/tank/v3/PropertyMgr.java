package com.yangzk.tank.v3;

import java.io.IOException;
import java.util.Properties;

/**
 * 配置工具类
 */
public class PropertyMgr {
    //声明并初始化Porpeties配置工具类
    private static final Properties properties = new Properties();
    //构造方法私有化
    private PropertyMgr(){}
   static{
        try {
            //读取配置文件
            properties.load(PropertyMgr.class.getClassLoader().getResourceAsStream("config/config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过key获取配置文件中所对应的value值
     * @param key
     * @return
     */
    public static Object get(String key ){
       //返回key所对应的value值
       return properties.get(key);
    }

    public static void main(String[] args) {
        System.out.println(PropertyMgr.get("initTankCount"));
    }
}
