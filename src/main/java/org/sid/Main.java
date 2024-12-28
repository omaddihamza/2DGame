package org.sid;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Create a window
        JFrame window = new JFrame();
        //this tel the window properly close when user clicks the x button
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("2D Adventure");

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);
        window.pack();

        window.setLocationRelativeTo(null);
        // Make the window visible
        window.setVisible(true);
        gamePanel.startGameThread();
    }
}