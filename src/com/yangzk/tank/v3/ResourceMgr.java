package com.yangzk.tank.v3;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * 加载静态资源类
 */
public class ResourceMgr {

    public static BufferedImage goodTankLeft, goodTankUp, goodTankRight, goodTankDown;//加载坦克图片
    public static BufferedImage badTankLeft, badTankUp, badTankRight, badTankDown;//加载坦克图片

    public static BufferedImage bulletLeft, bulletUp, bullRight, bulletDown;//加载子弹图片
    public static BufferedImage[] explodes = new BufferedImage[16];

    static{
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
}
