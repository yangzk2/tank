package com.yangzk.tank.v2;

import java.awt.*;

/**
 * 子弹与坦克命中爆炸
 */
public class Explode {



    public final static int WIDTH = ResourceMgr.explodes[0].getWidth();//子弹高度
    public final static int HEIGHT = ResourceMgr.explodes[0].getHeight();//子弹高度
    private int x,y;//爆炸发出的位置


    private boolean living = true;
    private TankFrame tankFrame;

    private int step = 0;

    public Explode(int x, int y, TankFrame tankFrame){
        this.x = x;
        this.y = y;
        this.tankFrame = tankFrame;
    }

    /**
     * 画板  画出爆炸效果图片
     * @param graphics
     */
    public void paint(Graphics graphics){

       graphics.drawImage(ResourceMgr.explodes[step++],x,y,null);
       if(step >= ResourceMgr.explodes.length)//如果step等于爆炸图片数组的长度 设置回默认值
           step = 0;
    }

}
