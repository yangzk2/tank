package com.yangzk.tank.v2;

import java.awt.*;

public class Tank {
    private int x,y;
    private Dir dir = Dir.DOWN;//坦克移动的方向
    private static final int SPEED = 10;//坦克的速度

    public Tank(int x, int y, Dir dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public void paint(Graphics graphics) {
        graphics.fillRect(x,y,50,50);
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

    public void setDir(Dir dir) {
        this.dir = dir;
    }
    public Dir getDir() {
        return dir;
    }
}
