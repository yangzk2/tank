package com.yangzk.tank.v2;

import java.awt.*;

/**
 * 子弹
 */
public class Bullet {

    private static final int SPEED = 8;

    private int x,y;//子弹发出的位置
    private static int WIDTH =10 , HEIGHT =10;//子弹大小
    //方向
    private Dir dir;

    private boolean live = true;
    private TankFrame tankFrame;

    public Bullet(int x,int y, Dir dir,TankFrame tankFrame){
        this.x = x;
        this.y = y;
        this.dir =dir;
        this.tankFrame = tankFrame;
    }

    /**
     * 画板 进行画子弹
     * @param graphics
     */
    public void paint(Graphics graphics){
        if(!live){
            tankFrame.bullets.remove(this);
        }
        switch (dir){
            case LEFT:
                graphics.drawImage(ResourceMgr.bulletLeft,x,y,null);
                break;
            case UP:
                graphics.drawImage(ResourceMgr.bulletUp,x,y,null);
                break;
            case RIGHT:
                graphics.drawImage(ResourceMgr.bullRight,x,y,null);
                break;
            case DOWN:
                graphics.drawImage(ResourceMgr.bulletDown,x,y,null);
                break;
        }

//        Color color = graphics.getColor();
//        graphics.setColor(Color.RED);//设置子弹颜色
//
//        graphics.fillOval(x,y,WIDTH,HEIGHT);//设置子弹发射位置及大小
//        graphics.setColor(color);//设置子弹颜色
        //子弹移动
        this.move();
    }

    /**
     * 子弹移动
     */
    private void move() {
        switch (dir){
            case LEFT:
                x-=SPEED;
                break;
            case UP:
                y-=SPEED;
                break;
            case RIGHT:
                x+=SPEED;
                break;
            case DOWN:
                y+=SPEED;
                break;
        }
        if(x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) live = false;


    }
}
