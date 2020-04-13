package com.yangzk.tank.v3;

/**
 * 默认的开火策略
 */
public class DefaultFireStrategy implements FireStrategy{

    private static final DefaultFireStrategy defaultFireStrategy = new DefaultFireStrategy();

    private DefaultFireStrategy() {
    }

     public static DefaultFireStrategy getInstance(){
        return defaultFireStrategy;
     }

    /**
     * 默认发出一个子弹
     * @param tank
     */
    @Override
    public void fire(Tank tank) {
        int bx = tank.getX() + Tank.WIDTH/2 - Bullet.WIDTH/2;
        int by = tank.getY() + Tank.HEIGHT/2 - Bullet.HEIGHT/2;

        new Bullet(bx,by,tank.getDir(),tank.getTankFrame(),tank.getGroup());
        if(tank.getGroup() == Group.GOOD) new Thread(()->new Audio("audio/tank_fire.wav").play()).start();
    }
}
