package com.yangzk.tank.v3;

import java.awt.*;

/**
 * 子弹类
 */
public class Bullet {

    private static final int SPEED = Integer.parseInt((String)PropertyMgr.get("bulletSpeed"));

    private int x,y;//子弹发出的位置
    public final static int WIDTH = ResourceMgr.getInstance().getBulletLeft().getWidth();//子弹高度
    public final static int HEIGHT = ResourceMgr.getInstance().getBulletLeft().getHeight();//子弹高度
    private ResourceMgr resounceMgr = ResourceMgr.getInstance();//获取内存中的资源实例
    private Rectangle rectangle = new Rectangle();

    //方向
    private Dir dir;

    private boolean living = true;//子弹死亡 默认活着
    private TankFrame tankFrame; //坦克窗口
    private Group group = Group.BAD;//对子弹进行分组 默认为敌方子弹

    public Bullet(int x, int y, Dir dir, TankFrame tankFrame, Group group){
        this.x = x;
        this.y = y;
        this.dir =dir;
        this.tankFrame = tankFrame;
        this.group = group;
        rectangle.x = this.x;
        rectangle.y = this.y;
        rectangle.width = WIDTH;
        rectangle.height = HEIGHT;
        //实例化时将子弹添加到bullets中
        tankFrame.bullets.add(this);
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
                graphics.drawImage(resounceMgr.getBulletLeft(),x,y,null);
                break;
            case UP:
                graphics.drawImage(resounceMgr.getBulletUp(),x,y,null);
                break;
            case RIGHT:
                graphics.drawImage(resounceMgr.getBullRight(),x,y,null);
                break;
            case DOWN:
                graphics.drawImage(resounceMgr.getBulletDown(),x,y,null);
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

        // update rectangle
        rectangle.x = this.x;
        rectangle.y = this.y;

        //如果x小于0或者小于0 或者x大于游戏窗口宽度或者y大于游戏窗口高度 子弹死亡
        if(x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) living = false;


    }

    /**
     * 子弹与坦克碰撞
     * 碰撞检测
     * @param tank
     */
    public void collideWith(Tank tank) {
        if(this.group == tank.getGroup()) return;

        //TODO: 用一个Rectangle来记录子弹和坦克的位置
       // Rectangle rectangle1 = new Rectangle(this.x,this.y,WIDTH,HEIGHT);
        //Rectangle rectangle2 = new Rectangle(tank.getX(),tank.getY(),Tank.WIDTH,Tank.HEIGHT);

        if(this.rectangle.intersects(tank.getRectangle())){//判断是否相交
            tank.die();//坦克死亡移除
            this.die();//子弹死亡移除
            //子弹打中坦克爆炸位置
            int eX = tank.getX() + Tank.WIDTH/2 - Explode.WIDTH/2;
            int eY = tank.getY() + Tank.HEIGHT/2 - Explode.HEIGHT/2;
            tankFrame.explodes.add(new Explode(eX,eY,tankFrame));
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
