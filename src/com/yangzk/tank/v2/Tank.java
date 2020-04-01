package com.yangzk.tank.v2;

public class Tank {
    public static void main(String[] args) {
        TankFrame frame = new TankFrame();

        while(true){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            frame.repaint();
        }
    }
}
