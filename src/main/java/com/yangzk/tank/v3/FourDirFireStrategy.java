package com.yangzk.tank.v3;

/**
 * 四方开火策略
 */
public class FourDirFireStrategy implements FireStrategy{

    private static final FourDirFireStrategy fourDirFireStrategy = new FourDirFireStrategy();

    private FourDirFireStrategy() {
    }

     public static FourDirFireStrategy getInstance(){
        return fourDirFireStrategy;
     }

    /**
     * 默认发出一个子弹
     * @param tank
     */
    @Override
    public void fire(Tank tank) {
        int bx = tank.getX() + Tank.WIDTH/2 - Bullet.WIDTH/2;
        int by = tank.getY() + Tank.HEIGHT/2 - Bullet.HEIGHT/2;

        Dir[] dirs = Dir.values();
        for(Dir dir : dirs){
            new Bullet(bx,by,dir,tank.getTankFrame(),tank.getGroup());
        }
        if(tank.getGroup() == Group.GOOD) new Thread(()->new Audio("audio/tank_fire.wav").play()).start();
    }
}
