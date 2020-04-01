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
    //创建坦克
    Tank myTank = new Tank(200,200,Dir.DOWN,this);
    //创建子弹
    Bullet bullet = new Bullet(300,300,Dir.DOWN);
    static final int GAME_WIDTH = 800, GAME_HEIGHT = 600; //游戏窗口大小
    public TankFrame() throws HeadlessException {
        this.setVisible(true);//展示窗口
        this.setSize(GAME_WIDTH,GAME_HEIGHT);//设置窗口大小
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
    private Image offScreenImage = null;
    @Override
    public void update(Graphics graphics){
        if(offScreenImage == null){//判断如果图像为空创建一个图像
            offScreenImage = this.createImage(GAME_WIDTH,GAME_HEIGHT);
        }
        //获得画板
        Graphics graphicsOffScreen = offScreenImage.getGraphics();
        Color color = graphicsOffScreen.getColor();//获得当前画板颜色
        graphicsOffScreen.setColor(Color.BLACK);//设置画板颜色
        graphicsOffScreen.fillRect(0,0,GAME_WIDTH,GAME_HEIGHT);//设置圆角
        graphicsOffScreen.setColor(color);//设置回原有画板颜色
        this.paint(graphicsOffScreen);//调用画板
        graphics.drawImage(offScreenImage,0,0,null);//一次性写入到屏幕上
    }
    /**
     * 画板
     * @param graphics
     */
    @Override
    public void paint(Graphics graphics){
        myTank.paint(graphics);
        bullet.paint(graphics);
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
                case KeyEvent.VK_CONTROL:
                    myTank.fire();
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
