package com.company;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    public boolean bottomUp, bottomDown, bottomLeft, bottomRight;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_UP)
        {
            bottomUp = true;
        }
        if (code == KeyEvent.VK_DOWN)
        {
            bottomDown = true;
        }
        if (code == KeyEvent.VK_RIGHT)
        {
            bottomRight = true;
        }
        if(code == KeyEvent.VK_LEFT)
        {
            bottomLeft = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_UP)
        {
            bottomUp = false;
        }
        if (code == KeyEvent.VK_DOWN)
        {
            bottomDown = false;
        }
        if (code == KeyEvent.VK_RIGHT)
        {
            bottomRight = false;
        }
        if(code == KeyEvent.VK_LEFT)
        {
            bottomLeft = false;
        }
    }
}
