package com.yangzk.tank.v2;

import java.awt.*;

/**
 * 创建坦克类
 */
public class Tank {
    private int x,y;//坦克大小
    private Dir dir = Dir.DOWN;//坦克移动的方向
    private static final int SPEED = 10;//坦克的速度
    private boolean moving = Boolean.FALSE;//移动

    public Tank(int x, int y, Dir dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    /**
     * 画板
     * @param graphics
     */
    public void paint(Graphics graphics) {
        graphics.fillRect(x,y,50,50);
       this.move();//移动坦克
    }

    /**
     * 移动坦克
     */
    private void move() {
        //如果moving为false则坦克静止
        if(!moving) return;
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

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }
}
