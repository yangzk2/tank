package com.yangzk.tank.v3;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.io.IOException;

/**
 * 加载静态资源类
 */
public final class ResourceMgr {
    private static final ResourceMgr INSTANCE =new ResourceMgr();
    private BufferedImage goodTankLeft, goodTankUp, goodTankRight, goodTankDown;//加载坦克图片
    private BufferedImage badTankLeft, badTankUp, badTankRight, badTankDown;//加载坦克图片
    private BufferedImage bulletLeft, bulletUp, bullRight, bulletDown;//加载子弹图片
    private BufferedImage[] explodes = new BufferedImage[16];
    //构造方法私有化
    private ResourceMgr(){
        if(null != INSTANCE){
            throw new RuntimeException("不允许实例化多个对象");
        }
        try {
            //将我方坦克图片加载进入内存中
            goodTankUp = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/GoodTank1.png"));
            goodTankLeft = ImageUtil.rotateImage(goodTankUp,-90);
            goodTankRight = ImageUtil.rotateImage(goodTankUp,90);
            goodTankDown = ImageUtil.rotateImage(goodTankUp,180);
            //将敌方坦克图片加载进入内存中
            badTankUp = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/BadTank1.png"));
            badTankLeft = ImageUtil.rotateImage(badTankUp,-90);
            badTankRight = ImageUtil.rotateImage(badTankUp,90);
            badTankDown = ImageUtil.rotateImage(badTankUp,180);
            //将子弹图片加载进入内存中
            bulletUp = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletU.png"));
            bulletLeft = ImageUtil.rotateImage(bulletUp,-90);
            bullRight = ImageUtil.rotateImage(bulletUp,90);
            bulletDown = ImageUtil.rotateImage(bulletUp,180);
            //将爆炸图片加载进入内存中
            for(int i = 0; i < 16; i++) explodes[i] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/e"+(i+1)+".gif"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //创建对象唯一入口
    public static final ResourceMgr getInstance(){
        return INSTANCE;
    }


    public BufferedImage getGoodTankLeft() {
        return goodTankLeft;
    }

    public BufferedImage getGoodTankUp() {
        return goodTankUp;
    }

    public BufferedImage getGoodTankRight() {
        return goodTankRight;
    }

    public BufferedImage getGoodTankDown() {
        return goodTankDown;
    }

    public BufferedImage getBadTankLeft() {
        return badTankLeft;
    }

    public BufferedImage getBadTankUp() {
        return badTankUp;
    }

    public BufferedImage getBadTankRight() {
        return badTankRight;
    }

    public BufferedImage getBadTankDown() {
        return badTankDown;
    }

    public BufferedImage getBulletLeft() {
        return bulletLeft;
    }

    public BufferedImage getBulletUp() {
        return bulletUp;
    }

    public BufferedImage getBullRight() {
        return bullRight;
    }

    public BufferedImage getBulletDown() {
        return bulletDown;
    }

    public BufferedImage[] getExplodes() {
        return explodes;
    }

    public static void main(String[] args) {
        ResourceMgr instance1 = ResourceMgr.getInstance();
        ResourceMgr instance2 =  ResourceMgr.getInstance();
        System.out.println(instance1 == instance2);
        BufferedImage badTankLeft1 = ResourceMgr.getInstance().getBadTankLeft();
        BufferedImage badTankLeft2 = ResourceMgr.getInstance().getBadTankLeft();
        System.out.println(badTankLeft1==badTankLeft2);

    }
}
