package org.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class GamePanelTest {

    @Test
    void lengthenPaddle() {
        //ensuring paddles height is changed by correct amount when lengthened
        Paddle paddle = new Paddle(0, 200, 25, 100, 1);
        GamePanel panel = new GamePanel();
        panel.lengthenPaddle(paddle);
        assertEquals(paddle.height, 200);
    }

    @Test
    void slowMotionBallXValue() {
        //checking to make sure speed is halved in x direction
        GamePanel panel = new GamePanel();
        Ball ball = new Ball(0,0, 20, 20);
        int initialXSpeed = ball.xVelocity;
        panel.slowMotionBall(ball);
        assertEquals(initialXSpeed/2, ball.xVelocity);
    }

    @Test
    void slowMotionBallYValue() {
        //checking to make sure speed is halved in y direction
        GamePanel panel = new GamePanel();
        Ball ball = new Ball(0,0, 20, 20);
        int initialYSpeed = ball.yVelocity;
        panel.slowMotionBall(ball);
        assertEquals(initialYSpeed/2, ball.yVelocity);
    }

    @Test
    void randomTrajectoryBall() {
        //checking to make sure some value (either x or y) is changed
        GamePanel panel = new GamePanel();
        Ball ball = new Ball(0,0, 20, 20);
        int [] initialTrajectory = {ball.xVelocity, ball.yVelocity};
        panel.randomTrajectoryBall(ball);
        assertFalse(Arrays.equals(initialTrajectory, new int [] {ball.xVelocity, ball.yVelocity}));
    }
}