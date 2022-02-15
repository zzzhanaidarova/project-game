package com.company;

import javax.swing.*;
import java.awt.*;
import  javax.swing.JPanel;

public class GamePanel extends JPanel {
    // screen setting
    final int originalTitleSize = 16;
    final int scale = 3;
    final int titleSize = originalTitleSize * scale;
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = titleSize * maxScreenCol;
    final int screenHeight = titleSize * maxScreenRow;

    public GamePanel () {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.pink);
        this.setDoubleBuffered(true);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.getHSBColor(160, 200, 230));
        g2.fillRect(100, 100, titleSize, titleSize);
        g2.dispose();
    }
}
