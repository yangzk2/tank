package com.yangzk.tank.v2;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * 图片工具类
 * 旋转图片
 */
public class ImageUtil {
    /**
     *
     * @param bufferedimage 传过来的图片
     * @param degree 角度
     * @return
     */
    public static BufferedImage rotateImage(final BufferedImage bufferedimage,
                                final int degree){
        int width = bufferedimage.getWidth();
        int height = bufferedimage.getHeight();
        int type = bufferedimage.getColorModel().getTransparency();
        BufferedImage img;
        Graphics2D graphics2D;
        (graphics2D = (img = new BufferedImage(width,height,type))
                .createGraphics()).setRenderingHint(
                        RenderingHints.KEY_INTERPOLATION,
                        RenderingHints.VALUE_INTERPOLATION_BILINEAR);

        graphics2D.rotate(Math.toRadians(degree),width/2,height/2);
        graphics2D.drawImage(bufferedimage,0,0,null);
        graphics2D.dispose();
        return img;
    }
}
