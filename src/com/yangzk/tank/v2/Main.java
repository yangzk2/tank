package com.yangzk.tank.v2;

/**
 * 坦克大战启动类
 */
public class Main {
    private static final int TIMEMILLIS = 50;

    public static void main(String[] args){

        TankFrame frame = new TankFrame();
        //读取配置文件中配置的敌方坦克数量
        int initTankCount = Integer.parseInt((String) PropertyMgr.get("initTankCount"));
        //初始化敌方坦克
        for(int i = 0 ; i < initTankCount ; i++){
            frame.tanks.add(new Tank(50 + i*80,200,Dir.DOWN,frame,Group.BAD));
        }
        //new Thread(()->new Audio("audio/war1.wav").loop()).start();
        while(true){
            try {
                Thread.sleep(TIMEMILLIS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            frame.repaint();
        }
    }
}
