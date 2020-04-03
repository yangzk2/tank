package com.yangzk.tank.v2;

import java.awt.*;
import java.util.Random;

/**
 * 创建坦克类
 */
public class Tank {
    private int x,y;//坦克所在位置
    private Dir dir = Dir.DOWN;//坦克移动的方向
    private static final int SPEED = 2;//坦克的速度

    public final static int WIDTH = ResourceMgr.tankLeft.getWidth();//坦克宽度
    public final static int HEIGHT = ResourceMgr.tankLeft.getHeight();//坦克高度

    private Random random = new Random();//声明随机 暂时用再发射子弹上，随机发射子弹

    private boolean moving = Boolean.TRUE;//移动
    private TankFrame tankFrame;//坦克窗口
    private boolean living = true;//坦克死亡 默认活着
    private Group group = Group.BAD;//对坦克进行分组 默认为敌方坦克
    public Tank(int x, int y, Dir dir,TankFrame tankFrame,Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tankFrame = tankFrame;
        this.group = group;
    }

    /**
     * 画板
     * @param graphics
     */
    public void paint(Graphics graphics) {
        if(!living){
            tankFrame.tanks.remove(this);
        }
        //根据方向替换图片
        switch (dir){
            case LEFT:
                graphics.drawImage(ResourceMgr.tankLeft,x,y,null);
                break;
            case UP:
                graphics.drawImage(ResourceMgr.tankUp,x,y,null);
                break;
            case RIGHT:
                graphics.drawImage(ResourceMgr.tankRight,x,y,null);
                break;
            case DOWN:
                graphics.drawImage(ResourceMgr.tankDown,x,y,null);
                break;

        }
        //画出坦克所在位置及大小
//        Color color = graphics.getColor();
//        graphics.setColor(Color.YELLOW);//设置坦克颜色
//        graphics.fillRect(x,y,WIDTH,HEIGHT);//设置坦克所在位置及大小
//        graphics.setColor(color);
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
        //随机打出子弹
        if (random.nextInt(10) > 8) this.fire();
    }

    /**
     * 发射子弹
     */
    public void fire() {
        int bx = this.x + Tank.WIDTH/2 - Bullet.WIDTH/2;
        int by = this.y + Tank.HEIGHT/2 - Bullet.HEIGHT/2;
        tankFrame.bullets.add(new Bullet(bx,by,this.dir,tankFrame,this.group));
        if(this.group == Group.GOOD) new Thread(()->new Audio("audio/tank_fire.wav").play()).start();
    }

    /**
     * 坦克爆炸消失
     */
    public void die() {
        this.living = false;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
