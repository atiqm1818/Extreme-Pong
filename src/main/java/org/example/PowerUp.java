package org.example;

import java.awt.*;

public class PowerUp extends Rectangle {
    int id;
    boolean used = false;
    public PowerUp(int xPos, int yPos, int width, int height, int id){
        super(xPos, yPos, width, height);
        this.id = id;
    }
    public void draw(Graphics g){
        switch (id){
            case 0:
                g.setColor(Color.yellow);
                break;
            case 1:
                g.setColor(Color.green);
                break;
            case 2:
                g.setColor(Color.red);
                break;
        }
        g.fillOval(x,y,width,height);
    }
}
