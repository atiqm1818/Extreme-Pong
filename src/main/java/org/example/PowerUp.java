package org.example;

import java.awt.*;

public class PowerUp extends Rectangle {
    int id;
    public PowerUp(int xPos, int yPos, int width, int height, int id){
        super(xPos, yPos, width, height);
        this.id = id;
    }
    public void draw(Graphics g){
        g.setColor(Color.yellow);
        g.fillOval(x,y,width,height);
    }
}
