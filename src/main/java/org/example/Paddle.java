package org.example;
import java.awt.*;
import java.awt.event.*;

public class Paddle extends Rectangle{
    int id;
    int yVelocity;
    int speed = 10;
    public Paddle(int xPos, int yPos, int PADDLE_WIDTH, int PADDLE_HEIGHT, int id){
        super(xPos,yPos,PADDLE_WIDTH, PADDLE_HEIGHT);
        this.id = id;
    }
    public void keyPressed(KeyEvent e){
        //switch case to check if up/down (player 2) is pressed or if w/s (player 1) are pressed
        switch (id) {
            case 1 -> {
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    setYDirection(-speed);
                    move();
                }
                if (e.getKeyCode() == KeyEvent.VK_S) {
                    setYDirection(speed);
                    move();
                }
            }
            case 2 -> {
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    setYDirection(-speed);
                    move();
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    setYDirection(speed);
                    move();
                }
            }
        }
    }
    public void keyReleased(KeyEvent e){
        //switch case to check if up/down (player 2) is pressed or if w/s (player 1) are pressed
        switch (id) {
            case 1 -> {
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    setYDirection(0);
                    move();
                }
                if (e.getKeyCode() == KeyEvent.VK_S) {
                    setYDirection(0);
                    move();
                }
            }
            case 2 -> {
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    setYDirection(0);
                    move();
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    setYDirection(0);
                    move();
                }
            }
        }
    }
    public void setYDirection(int y){
        yVelocity = y;
    }
    public void move(){
        y += yVelocity;
    }
    //method to draw paddles
    public void draw(Graphics g){
        if(id == 1){
            g.setColor(Color.cyan);
        }
        else{
            g.setColor(Color.pink);
        }
            g.fillRect(x, y, width, height);
    }
}