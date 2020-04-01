package com.yangzk.tank.v2;

import java.awt.*;

/**
 * 创建坦克类
 */
public class Tank {
    private int x,y;//坦克所在位置
    private static int WIDTH =50 , HEIGHT =50;//坦克大小
    private Dir dir = Dir.DOWN;//坦克移动的方向
    private static final int SPEED = 5;//坦克的速度
    private boolean moving = Boolean.FALSE;//移动
    private TankFrame tankFrame;//坦克窗口
    public Tank(int x, int y, Dir dir,TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tankFrame = tankFrame;
    }

    /**
     * 画板
     * @param graphics
     */
    public void paint(Graphics graphics) {
        //画出坦克所在位置及大小
        Color color = graphics.getColor();
        graphics.setColor(Color.YELLOW);//设置坦克颜色
        graphics.fillRect(x,y,WIDTH,HEIGHT);//设置坦克所在位置及大小
        graphics.setColor(color);
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

    /**
     * 发射子弹
     */
    public void fire() {
        tankFrame.bullets.add(new Bullet(this.x,this.y,this.dir,tankFrame));
    }
}
