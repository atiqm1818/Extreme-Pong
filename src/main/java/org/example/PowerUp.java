package org.example;

import java.awt.*;

public class PowerUp extends Rectangle {
    //id for type of power up
    int id;
    public PowerUp(int xPos, int yPos, int width, int height, int id){
        super(xPos, yPos, width, height);
        this.id = id;
    }
    //method to draw power ups
    public void draw(Graphics g){
        switch (id) {
            case 0 -> g.setColor(Color.yellow);
            case 1 -> g.setColor(Color.green);
            case 2 -> g.setColor(Color.red);
        }
        g.fillOval(x,y,width,height);
    }
}