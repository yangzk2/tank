package com.yangzk.tank.v2;



import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * 继承frame类  让自己就是一个窗口类
 * 重写paint方法
 * Graphics画板：画出小方块
 */
public class TankFrame extends Frame {
    //创建坦克
    Tank myTank = new Tank(200,400,Dir.DOWN,this,Group.GOOD);
    List<Bullet> bullets = new ArrayList();
    List<Tank> tanks = new ArrayList<>();
    Explode explode = new Explode(100,100,this);
    //创建子弹
    Bullet bullet = new Bullet(300,300,Dir.DOWN,this,Group.GOOD);
    static final int GAME_WIDTH = 800, GAME_HEIGHT = 600; //游戏窗口大小
    public TankFrame() throws HeadlessException {
        this.setVisible(true);//展示窗口
        this.setSize(GAME_WIDTH,GAME_HEIGHT);//设置窗口大小
        this.setResizable(false);//设置窗口是否可以改变大小
        this.setTitle("坦克大战");
        //添加键盘监听事件
        this.addKeyListener(new myKeyListener());
        //监听windows窗口是否关闭窗口事件
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);//关闭窗口
            }
        });
    }

    /**
     * 画板之前调用 创建双缓冲区
     */
    private Image offScreenImage = null;
    @Override
    public void update(Graphics graphics){
        if(offScreenImage == null){//判断如果图像为空创建一个图像
            offScreenImage = this.createImage(GAME_WIDTH,GAME_HEIGHT);
        }
        //获得画板
        Graphics graphicsOffScreen = offScreenImage.getGraphics();
        Color color = graphicsOffScreen.getColor();//获得当前画板颜色
        graphicsOffScreen.setColor(Color.BLACK);//设置画板颜色
        graphicsOffScreen.fillRect(0,0,GAME_WIDTH,GAME_HEIGHT);//设置圆角
        graphicsOffScreen.setColor(color);//设置回原有画板颜色
        this.paint(graphicsOffScreen);//调用画板
        graphics.drawImage(offScreenImage,0,0,null);//一次性写入到屏幕上
    }
    /**
     * 画板
     * @param graphics
     */
    @Override
    public void paint(Graphics graphics){
        Color color = graphics.getColor();
        graphics.setColor(Color.WHITE);
        graphics.drawString("子弹的数量:"+bullets.size(),10,60);
        graphics.drawString("敌人的数量:"+tanks.size(),10,80);
        graphics.setColor(color);
        myTank.paint(graphics);
       // bullet.paint(graphics);
        for(int i = 0 ; i < bullets.size();i++){
            bullets.get(i).paint(graphics);
        }
        for(int i = 0 ; i < tanks.size();i++){
            tanks.get(i).paint(graphics);
        }
        for(int i =0; i<bullets.size(); i++){
            for(int j =0; j<tanks.size(); j++){
                bullets.get(i).collideWith(tanks.get(j));
            }
        }
        explode.paint(graphics);
        //error 当方法检测到对象的并发修改，但不允许这种修改时，抛出Exception in thread "AWT-EventQueue-0" java.util.ConcurrentModificationException 解决办法就是换一种写法用fori进行处理
        //例如，某个线程在 Collection 上进行迭代时，通常不允许另一个线性修改该 Collection。通常在这些情况下，迭代的结果是不明确的。如果检测到这种行为，一些迭代器实现（包括 JRE 提供的所有通用 collection 实现）可能选择抛出此异常。执行该操作的迭代器称为快速失败 迭代器，因为迭代器很快就完全失败，而不会冒着在将来某个时间任意发生不确定行为的风险。
        // 注意，此异常不会始终指出对象已经由不同 线程并发修改。如果单线程发出违反对象协定的方法调用序列，则该对象可能抛出此异常。例如，如果线程使用快速失败迭代器在 collection 上迭代时直接修改该 collection，则迭代器将抛出此异常。
        // 所以出现这种异常的通畅情况是使用了Iterator的原因，比如list。
        /*for(Bullet bullet : bullets){
            bullet.paint(graphics);
        }*/
    }



    /**
     * 创建键盘监听事件
     */
    class myKeyListener extends KeyAdapter{

        boolean bL = false;
        boolean bU = false;
        boolean bR = false;
        boolean bD = false;

        /**
         * 键盘按下调用 移动坦克
         * @param e
         */
        @Override
        public void keyPressed(KeyEvent e) {
           int key = e.getKeyCode();//获取键盘code值
           switch (key){
               case KeyEvent.VK_LEFT:
                   bL = true;
                   break;
               case KeyEvent.VK_UP:
                  bU = true;
                   break;
               case KeyEvent.VK_RIGHT:
                   bR = true;
                   break;
               case KeyEvent.VK_DOWN:
                   bD = true;
                   break;
               default:
                   break;
           }
            //设置坦克方向
           setMinTankDir();

        }

        /**
         * 键盘抬起调用 停止坦克
         * @param e
         */
        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();//获取键盘code值
            switch (key){
                case KeyEvent.VK_LEFT:
                    bL = false;
                    break;
                case KeyEvent.VK_UP:
                    bU = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = false;
                    break;
                case KeyEvent.VK_CONTROL:
                    myTank.fire();
                    break;
                default:
                    break;
            }
            //设置坦克方向
            setMinTankDir();
        }

        /**
         * 设定坦克方向
         */
        private void setMinTankDir() {
            if(!bL && !bU && !bR && !bD) myTank.setMoving(Boolean.FALSE);
            else  myTank.setMoving(Boolean.TRUE);
            if (bL) myTank.setDir(Dir.LEFT);
            if (bU) myTank.setDir(Dir.UP);
            if (bR) myTank.setDir(Dir.RIGHT);
            if (bD) myTank.setDir(Dir.DOWN);


        }

    }
}
