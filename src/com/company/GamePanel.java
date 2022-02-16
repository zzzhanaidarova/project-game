package com.company;

import entity.Player;

import javax.swing.*;
import java.awt.*;
import  javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {
    // screen setting
    final int originalTitleSize = 16;
    final int scale = 3;
    public final int titleSize = originalTitleSize * scale;
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = titleSize * maxScreenCol;
    final int screenHeight = titleSize * maxScreenRow;

    //Frame per second
    int fps = 60;

    KeyHandler key = new KeyHandler();
    Thread gameThread;
    Player player = new Player(this, key);
    //setting player's first position
    int playerX = screenWidth/2;
    int playerY = screenHeight/2;
    int playerSpeed = 5;

    public GamePanel () {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.pink);
        this.setDoubleBuffered(true);
        this.addKeyListener(key);
        this.setFocusable(true);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double interval = 1000000000/fps; //1 second = 10^9 nanoseconds
        double nextTime = System.nanoTime() + interval;
        while (gameThread != null)
        {
            update();
            repaint();

            try {
                double left = nextTime - System.nanoTime();
                left = left/1000000;
                if (left < 0)
                {
                    left = 0;
                }
                Thread.sleep((long) left);
                nextTime += interval;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void update() {
        player.update();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        player.draw(g2);
        g2.dispose();
    }
}
