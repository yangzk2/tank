package com.yangzk.tank.v2;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * 加载资源
 */
public class ResourceMgr {

    public static BufferedImage tankLeft, tankUp, tankRight, tankDown;//加载坦克图片

    public static BufferedImage bulletLeft, bulletUp, bullRight, bulletDown;//加载子弹图片
    public static BufferedImage[] explodes = new BufferedImage[16];

    static{
        try {
            //将坦克图片加载进入内存中
            tankUp = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/GoodTank1.png"));
            tankLeft = ImageUtil.rotateImage(tankUp,-90);
            tankRight = ImageUtil.rotateImage(tankUp,90);
            tankDown = ImageUtil.rotateImage(tankUp,180);
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
