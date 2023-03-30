package org.example;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class BallTest {

    @Test
    void setXDirection() {
        Ball ball = new Ball(0,0,20,20);
        int initialXDir = ball.xVelocity;
        Random random = new Random();
        ball.setXDirection(random.nextInt(2));
        assertNotEquals(initialXDir, ball.xVelocity);
    }

    @Test
    void setYDirection() {
        Ball ball = new Ball(0,0,20,20);
        int initialYDir = ball.yVelocity;
        Random random = new Random();
        ball.setYDirection(random.nextInt(2));
        assertNotEquals(initialYDir, ball.yVelocity);

    }
}