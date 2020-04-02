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
            tankLeft = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankL.gif"));
            tankUp = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankU.gif"));
            tankRight = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankR.gif"));
            tankDown = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankD.gif"));
            //将子弹图片加载进入内存中
            bulletLeft = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletL.gif"));
            bulletUp = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletU.gif"));
            bullRight = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletR.gif"));
            bulletDown = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletD.gif"));
            //将爆炸图片加载进入内存中
            for(int i = 0; i < 16; i++) explodes[i] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/e"+(i+1)+".gif"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
