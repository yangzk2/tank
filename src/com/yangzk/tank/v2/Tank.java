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

    public final static int WIDTH = ResourceMgr.goodTankLeft.getWidth();//坦克宽度
    public final static int HEIGHT = ResourceMgr.goodTankLeft.getHeight();//坦克高度

    private Rectangle rectangle = new Rectangle();

    private Random random = new Random();//声明随机 暂时用再发射子弹上，随机发射子弹

    private boolean moving = Boolean.FALSE;//移动
    private TankFrame tankFrame;//坦克窗口
    private boolean living = true;//坦克死亡 默认活着
    private Group group = Group.BAD;//对坦克进行分组 默认为敌方坦克
    public Tank(int x, int y, Dir dir,TankFrame tankFrame,Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tankFrame = tankFrame;
        this.group = group;
        rectangle.x = this.x;
        rectangle.y = this.y;
        rectangle.width = WIDTH;
        rectangle.height = HEIGHT;
    }

    /**
     * 画板
     * @param graphics
     */
    public void paint(Graphics graphics) {
        if(!living) tankFrame.tanks.remove(this);
        //根据方向替换图片
        switch (dir){
            case LEFT:
                graphics.drawImage(this.group == Group.GOOD ?ResourceMgr.goodTankLeft : ResourceMgr.badTankLeft,x,y,null);
                break;
            case UP:
                graphics.drawImage(this.group == Group.GOOD ?ResourceMgr.goodTankUp : ResourceMgr.badTankUp,x,y,null);
                break;
            case RIGHT:
                graphics.drawImage(this.group == Group.GOOD ?ResourceMgr.goodTankRight : ResourceMgr.badTankRight,x,y,null);
                break;
            case DOWN:
                graphics.drawImage(this.group == Group.GOOD ?ResourceMgr.goodTankDown : ResourceMgr.badTankDown,x,y,null);
                break;

        }
        //画出坦克所在位置及大小
//        Color color = graphics.getColor();
//        graphics.setColor(Color.YELLOW);//设置坦克颜色
//        graphics.fillRect(x,y,WIDTH,HEIGHT);//设置坦克所在位置及大小
//        graphics.setColor(color);
        //如果是敌方坦克则自由移动
        if(this.group == Group.BAD) this.moving=Boolean.TRUE;
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

        //判断是不是敌方坦克并且随机打出子弹
        if (this.group == Group.BAD && random.nextInt(100) > 95)
            this.fire();//发射炮弹
        if(this.group == Group.BAD && random.nextInt(100) > 95)
        this.randomDir();//定义随机方向
        //边界检测
        this.boundsCheck();

        // update rectangle
        rectangle.x = this.x;
        rectangle.y = this.y;
    }

    /**
     * 边界检测
     */
    private void boundsCheck() {
        if(this.x < 2) x = 2;
        if(this.y < 28) y = 28;
        if(this.x > TankFrame.GAME_WIDTH - Tank.WIDTH - 2) x = TankFrame.GAME_WIDTH - Tank.WIDTH - 2;
        if(this.y > TankFrame.GAME_HEIGHT - Tank.HEIGHT - 2) y = TankFrame.GAME_HEIGHT - Tank.HEIGHT - 2;
    }

    /**
     * 随机方向
     */
    private void randomDir() {
        this.dir = Dir.values()[random.nextInt(4)];
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

    public Rectangle getRectangle() {
        return rectangle;
    }
}
