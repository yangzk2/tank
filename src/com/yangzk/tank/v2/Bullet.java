package com.yangzk.tank.v2;

import java.awt.*;

/**
 * 子弹
 */
public class Bullet {

    private static final int SPEED = 8;

    private int x,y;//子弹发出的位置
    public final static int WIDTH = ResourceMgr.bulletLeft.getWidth();//子弹高度
    public final static int HEIGHT = ResourceMgr.bulletLeft.getHeight();//子弹高度
    //方向
    private Dir dir;

    private boolean living = true;
    private TankFrame tankFrame;
    private Group group = Group.BAD;

    public Bullet(int x,int y, Dir dir,TankFrame tankFrame,Group group){
        this.x = x;
        this.y = y;
        this.dir =dir;
        this.tankFrame = tankFrame;
        this.group = group;
    }

    /**
     * 画板 进行画子弹
     * @param graphics
     */
    public void paint(Graphics graphics){
        if(!living){
            tankFrame.bullets.remove(this);
        }
        //根据方向替换图片
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
        if(x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) living = false;


    }

    /**
     * 子弹与坦克碰撞
     * 碰撞检测
     * @param tank
     */
    public void collideWith(Tank tank) {
        if(this.group == tank.getGroup()) return;
        //TODO: 用一个Rectangle来记录子弹的位置
        Rectangle rectangle1 = new Rectangle(this.x,this.y,WIDTH,HEIGHT);
        Rectangle rectangle2 = new Rectangle(tank.getX(),tank.getY(),Tank.WIDTH,Tank.HEIGHT);

        if(rectangle1.intersects(rectangle2)){//判断是否相交
            tank.die();
            this.die();
        }
    }

    /**
     * 子弹命中消失
     */
    private void die() {
        this.living = false;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
