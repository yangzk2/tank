package com.yangzk.tank.v1;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 坦克大战
 */
public class Tank {
    public static void main(String[] args) {
        Frame frame = new Frame();//创建一个新窗口
        frame.setVisible(true);//展示窗口
        frame.setSize(800,600);//设置窗口大小
        frame.setResizable(false);//设置窗口是否可以改变大小
        frame.setTitle("坦克大战");
        //监听windows窗口是否关闭窗口事件
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);//关闭窗口
            }
        });
    }
}
