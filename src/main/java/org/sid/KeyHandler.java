package org.sid;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//the listner interface for receiving keyboard events (keystrokes )
public class KeyHandler implements KeyListener {

    public boolean upPressed, downPressed, leftPressed, rightPressed;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
     //returns the integer keycode associated with the in this event
      int key = e.getKeyCode();
      if (key == KeyEvent.VK_W) {
          upPressed = true;
      }
      if (key == KeyEvent.VK_S) {
          downPressed = true;
      }
      if (key == KeyEvent.VK_A) {
          leftPressed = true;
      }
      if (key == KeyEvent.VK_D) {
          rightPressed = true;
      }
    }

    @Override
    public void keyReleased(KeyEvent e) {
       int key = e.getKeyCode();
       if (key == KeyEvent.VK_W) {
           upPressed = false;
       }
       if (key == KeyEvent.VK_S) {
           downPressed = false;
       }
       if (key == KeyEvent.VK_A) {
           leftPressed = false;
       }
       if (key == KeyEvent.VK_D) {
           rightPressed = false;
       }
    }
}