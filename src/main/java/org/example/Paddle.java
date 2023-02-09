package org.example;
import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;

public class Paddle extends Rectangle{
    int id;
    int yVelocity;
    int speed = 10;
    boolean isLenghtened = false;
    public Paddle(int xPos, int yPos, int PADDLE_WIDTH, int PADDLE_HEIGHT, int id){
        super(xPos,yPos,PADDLE_WIDTH, PADDLE_HEIGHT);
        this.id = id;
    }
    public void keyPressed(KeyEvent e){
        switch(id){
            case 1:
                if(e.getKeyCode() == KeyEvent.VK_W){
                    setYDirection(-speed);
                    move();
                }
                if(e.getKeyCode() == KeyEvent.VK_S){
                    setYDirection(speed);
                    move();
                }
                break;
            case 2:
                if(e.getKeyCode() == KeyEvent.VK_UP){
                    setYDirection(-speed);
                    move();
                }
                if(e.getKeyCode() == KeyEvent.VK_DOWN){
                    setYDirection(speed);
                    move();
                }
                break;
        }
    }
    public void keyReleased(KeyEvent e){
        switch(id){
            case 1:
                if(e.getKeyCode() == KeyEvent.VK_W){
                    setYDirection(0);
                    move();
                }
                if(e.getKeyCode() == KeyEvent.VK_S){
                    setYDirection(0);
                    move();
                }
                break;
            case 2:
                if(e.getKeyCode() == KeyEvent.VK_UP){
                    setYDirection(0);
                    move();
                }
                if(e.getKeyCode() == KeyEvent.VK_DOWN){
                    setYDirection(0);
                    move();
                }
                break;
        }
    }
    public void setYDirection(int y){
        yVelocity = y;
    }
    public void move(){
        y += yVelocity;
    }
    public void draw(Graphics g){
        if(id == 1){
            g.setColor(Color.cyan);
        }
        else{
            g.setColor(Color.pink);
        }
            g.fillRect(x, y, width, height);
    }
    public void lengthenPaddle(){
        isLenghtened = true;
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                isLenghtened = false;
            }
        };
        long delay = 1000000;
        Timer timer = new Timer("Timer");
        timer.schedule(task, delay);
    }
}
