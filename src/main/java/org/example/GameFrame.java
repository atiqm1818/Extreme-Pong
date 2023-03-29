package org.example;
import java.awt.*;

import javax.swing.*;
public class GameFrame extends JFrame{
    private GamePanel panel;
    public GameFrame(){
        //creating and customizing game panel and game frame
        panel = new GamePanel();
        this.add(panel);
        this.setTitle("Pong Game");
        this.setResizable(false);
        this.setBackground(Color.black);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

}
