package org.sid;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {
    // SCREEN SETTING
    final int originalTileSize = 16; //16x16 tile
    final int scale = 3;
    final int tileSize = originalTileSize * scale; //48x48 tile
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol; //768 pixels
    final int screenHeight = tileSize * maxScreenRow; //768 pixels

    //FPS
    int FPS = 60;

    KeyHandler keyHandler = new KeyHandler();
    Thread gameThread;

    //set player"s default position
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;

    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        // if set to true, all the drawing from this component will be done in an offscreen painting buffer
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler);
        //with this, this gamepanel can be focused to receive key input
        this.setFocusable(true);
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000 / FPS; // 0.01666 second
        //returns the current value of the running java virtual machine's high-resolution time source in nanoseconds
        double nextDrawTime = System.nanoTime() + drawInterval;
      while (gameThread !=null){
          //update information such as character position
          update();
          //draw the screen with the update information
          repaint();

          try {
              double remainingTime = nextDrawTime - System.nanoTime();
              remainingTime = remainingTime / 1000000;
              if(remainingTime < 0){
                  remainingTime = 0;
              }
              Thread.sleep((long) remainingTime);
              nextDrawTime += drawInterval;
          } catch (InterruptedException e) {
              throw new RuntimeException(e);
          }
      }
    }

    public void update(){

    if (keyHandler.upPressed == true){
        playerY -= playerSpeed;
    }else if (keyHandler.downPressed == true){
        playerY += playerSpeed;
    }else if (keyHandler.leftPressed == true){
        playerX -= playerSpeed;
    }else if (keyHandler.rightPressed == true){
        playerX += playerSpeed;
    }

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.white);
        g2d.fillRect(playerX, playerY, tileSize, tileSize);
        g2d.dispose();
    }

}
