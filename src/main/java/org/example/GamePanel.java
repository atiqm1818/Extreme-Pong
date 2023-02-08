package org.example;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
public class GamePanel extends JPanel implements Runnable{
    private static final int GAME_WIDTH = 1000;
    private static final int GAME_HEIGHT = (int)(GAME_WIDTH * (0.5555));
    private static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH, GAME_HEIGHT);
    private static final int BALL_DIAMETER = 20;
    private static final int PADDLE_WIDTH = 25;
    private static final int PADDLE_HEIGHT = 100;
    Thread gameThread;
    Image image;
    Graphics graphics;
    Random random;
    Paddle p1;
    Paddle p2;
    Ball ball;
    Score score;
    PowerUp powerUp;

    public GamePanel(){
        newPaddles();
        newBall();
        newPowerUp();
        score = new Score(GAME_WIDTH, GAME_HEIGHT);
        this.setFocusable(true);
        this.addKeyListener(new ActionListener());
        this.setPreferredSize(SCREEN_SIZE);

        gameThread = new Thread(this);
        gameThread.start();
    }
    public void newBall(){
        random = new Random();
        ball = new Ball((GAME_WIDTH / 2) - (BALL_DIAMETER / 2), (GAME_HEIGHT / 2) - (BALL_DIAMETER / 2), BALL_DIAMETER, BALL_DIAMETER);
    }
    public void newPaddles(){
        p1 = new Paddle(0, (GAME_HEIGHT/2) - (PADDLE_HEIGHT/2), PADDLE_WIDTH, PADDLE_HEIGHT, 1);
        p2 = new Paddle(GAME_WIDTH - PADDLE_WIDTH, (GAME_HEIGHT/2) - (PADDLE_HEIGHT/2), PADDLE_WIDTH, PADDLE_HEIGHT, 2);
    }
    public void newPowerUp(){
        powerUp = new PowerUp(random.nextInt(GAME_WIDTH/2 - 200 - BALL_DIAMETER, GAME_WIDTH/2 + 200 - BALL_DIAMETER), random.nextInt(GAME_HEIGHT/2 - 300 - BALL_DIAMETER ,GAME_HEIGHT/2 + 300 - BALL_DIAMETER), BALL_DIAMETER+25, BALL_DIAMETER+25, 0);//random.nextInt(3)
    }
    public void paint(Graphics g){
        image = createImage(getWidth(), getHeight());
        graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image, 0, 0, this);
    }
    public void draw(Graphics g){
        p1.draw(g);
        p2.draw(g);
        ball.draw(g);
        score.draw(g);
        powerUp.draw(g);
    }
    public void move(){
        p1.move();
        p2.move();
        ball.move();
    }
    public void checkCollision(){
        //stops ball at top / bottom window edges
        if(ball.y <= 0){
            ball.setYDirection(-ball.yVelocity);
        }
        if(ball.y >= GAME_HEIGHT - BALL_DIAMETER){
            ball.setYDirection(-ball.yVelocity);
        }

        //check for collision with paddles
        if(ball.intersects(p1)){
            ball.xVelocity = -ball.xVelocity;
            ball.xVelocity++;//speeding up ball
            if(ball.yVelocity > 0){
                ball.yVelocity++;//speeding up ball
            }
            else{
                ball.yVelocity--;
            }
            ball.setXDirection(ball.xVelocity);
            ball.setYDirection(ball.yVelocity);
        }
        if(ball.intersects(p2)){
            ball.xVelocity = -ball.xVelocity;
            ball.xVelocity--;//speeding up ball
            if(ball.yVelocity > 0){
                ball.yVelocity++;//speeding up ball
            }
            else{
                ball.yVelocity--;
            }
            ball.setXDirection(ball.xVelocity);
            ball.setYDirection(ball.yVelocity);
        }

        //check collision with power ups
        if(ball.intersects(powerUp)){//check to see if ball intersects power up
            if(ball.xVelocity > 0){
                givePowerUp(1);
            }
            else{
                givePowerUp(2);
            }
        }
        //stops paddles at window edges
        if(p1.y <= 0){
            p1.y = 0;
        }
        if(p1.y >= GAME_HEIGHT - PADDLE_HEIGHT){
            p1.y = GAME_HEIGHT - PADDLE_HEIGHT;
        }
        if(p2.y <= 0){
            p2.y = 0;
        }
        if(p2.y >= GAME_HEIGHT - PADDLE_HEIGHT){
            p2.y = GAME_HEIGHT - PADDLE_HEIGHT;
        }
        //gives player a point and resets board
        if(ball.x <= 0){
            score.p2++;
            resetBoard();
        }
        if(ball.x >= GAME_WIDTH - BALL_DIAMETER){
            score.p1++;
            resetBoard();
        }
    }
    //TODO: Finish givePowerUp Method and its cases (slow mo, random trajectory, and long paddle)
    public void givePowerUp(int paddleId){
            switch(powerUp.id){
                case 0://longer paddle power up
                    if(paddleId == 1){
                        p1.lengthenPaddle();
                    }
                    else{
                        p2.lengthenPaddle();
                    }
                    break;
                case 1://slow mo ball power up
                    slowMotionBall();
                    break;
                case 2:// random trajectory power up
                    randomTrajectoryBall();
                    break;
            }

    }
    //power up methods
    public void slowMotionBall(){

    }
    public void randomTrajectoryBall(){

    }
    public void resetBoard(){
        newPaddles();
        newBall();
        newPowerUp();
    }
    public void run(){
        //game loop
        long lastTime = System.nanoTime();
        double amountOfTics = 60;
        double ns = 1000000000 / amountOfTics;
        double delta = 0;
        while(true){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            if(delta >= 1){
                move();
                checkCollision();
                repaint();
                delta--;
            }
        }
    }
    public class ActionListener extends KeyAdapter{
        public void keyPressed(KeyEvent e){
            p1.keyPressed(e);
            p2.keyPressed(e);
        }
        public void keyReleased(KeyEvent e){
            p1.keyReleased(e);
            p2.keyReleased(e);
        }
    }
}
