package com.yangzk.tank.v2;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 继承frame类  让自己就是一个窗口类
 * 重写paint方法
 * Graphics画板：画出小方块
 */
public class TankFrame extends Frame {

    Tank myTank = new Tank(200,200,Dir.DOWN);
    public TankFrame() throws HeadlessException {
        this.setVisible(true);//展示窗口
        this.setSize(800,600);//设置窗口大小
        this.setResizable(false);//设置窗口是否可以改变大小
        this.setTitle("坦克大战");
        //添加键盘监听事件
        this.addKeyListener(new myKeyListener());
        //监听windows窗口是否关闭窗口事件
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);//关闭窗口
            }
        });
    }

    /**
     * 画板
     * @param graphics
     */
    @Override
    public void paint(Graphics graphics){
        myTank.paint(graphics);
    }

    /**
     * 创建键盘监听事件
     */
    class myKeyListener extends KeyAdapter{

        boolean bL = false;
        boolean bU = false;
        boolean bR = false;
        boolean bD = false;

        /**
         * 键盘按下调用 移动坦克
         * @param e
         */
        @Override
        public void keyPressed(KeyEvent e) {
           int key = e.getKeyCode();//获取键盘code值
           switch (key){
               case KeyEvent.VK_LEFT:
                   bL = true;
                   break;
               case KeyEvent.VK_UP:
                  bU = true;
                   break;
               case KeyEvent.VK_RIGHT:
                   bR = true;
                   break;
               case KeyEvent.VK_DOWN:
                   bD = true;
                   break;
               default:
                   break;
           }
            //设置坦克方向
           setMinTankDir();

        }

        /**
         * 键盘抬起调用 停止坦克
         * @param e
         */
        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();//获取键盘code值
            switch (key){
                case KeyEvent.VK_LEFT:
                    bL = false;
                    break;
                case KeyEvent.VK_UP:
                    bU = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = false;
                    break;
                default:
                    break;
            }
            //设置坦克方向
            setMinTankDir();
        }

        /**
         * 设定坦克方向
         */
        private void setMinTankDir() {
            if(!bL && !bU && !bR && !bD) myTank.setMoving(Boolean.FALSE);
            else  myTank.setMoving(Boolean.TRUE);
            if (bL) myTank.setDir(Dir.LEFT);
            if (bU) myTank.setDir(Dir.UP);
            if (bR) myTank.setDir(Dir.RIGHT);
            if (bD) myTank.setDir(Dir.DOWN);


        }

    }
}
