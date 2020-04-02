package com.yangzk.tank.v2;

public class Main {
    private static final int TIMEMILLIS = 50;

    public static void main(String[] args){

        TankFrame frame = new TankFrame();
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
