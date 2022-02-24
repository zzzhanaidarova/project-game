package com.company;

import entity.Player;
import tile.TileManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {
    //screen setting
    final int originalTileSize = 16;
    final int scale = 3;
    public final int tileSize = originalTileSize * scale;
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol;
    public final int screenHeight = tileSize * maxScreenRow;

    //world setting
    public final int worldMaxCol = 50;
    public final int worldMaxRow = 50;
    public final int worldWidth = tileSize*worldMaxCol;
    public final int worldHeight = tileSize*worldMaxRow;
    
    int fps = 60;
    TileManager tileManager = new TileManager(this);
    KeyHandler key = new KeyHandler();
    Thread gameThread;
    
    public Player player = new Player(this, key);
    public CollisionChecker collisionChecker = new CollisionChecker(this);
    public AssetSetter aSetter = new AssetSetter(this);
    public SuperObject obj[] = new SuperObject[10];
    public GamePanel()
    {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.pink);
        this.setDoubleBuffered(true);
        this.addKeyListener(key);
        this.setFocusable(true);
    }

    public void startGameThread()
    {
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

        //TILE
        tileManager.draw(g2);


        //OBJECT
        for(int i = 0; i < obj.length; i++){
            if(obj[i] != null)
                obj[i].draw(g2, this);
        }

        //PLAYER
        player.draw(g2);
        g2.dispose();
    }
}
