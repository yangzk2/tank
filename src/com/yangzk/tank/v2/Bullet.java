package com.yangzk.tank.v2;

import java.awt.*;

/**
 * 子弹
 */
public class Bullet {

    private static final int SPEED = 8;

    private int x,y;
    private static int WIDTH =20 , HEIGHT =20;
    //方向
    private Dir dir;

    public Bullet(int x,int y, Dir dir){
        this.x = x;
        this.y = y;
        this.dir =dir;
    }

    /**
     * 画板 进行画子弹
     * @param graphics
     */
    public void paint(Graphics graphics){
        Color color = graphics.getColor();
        graphics.setColor(Color.RED);//设置子弹颜色
        graphics.fillOval(x,y,WIDTH,HEIGHT);//设置子弹大小宽高
        graphics.setColor(color);//设置子弹颜色
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
    }
}
