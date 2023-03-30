package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaddleTest {
    @Test
    void movePositive() {
        //checking to make sure move method actually changes paddle's position
        Paddle paddle = new Paddle(0, 200, 25, 100, 1);
        int initialPos = paddle.y;
        paddle.yVelocity = 1;
        paddle.move();
        assertNotEquals(initialPos, paddle.y);
    }
    @Test
    void moveNegative() {
        //checking to make sure move method actually changes paddle's position
        Paddle paddle = new Paddle(0, 200, 25, 100, 1);
        int initialPos = paddle.y;
        paddle.yVelocity = -1;
        paddle.move();
        assertNotEquals(initialPos, paddle.y);
    }

    @Test
    void setYDirectionNegative(){
        Paddle paddle = new Paddle(0, 200, 25, 100, 1);
        int initialY = paddle.yVelocity;
        paddle.setYDirection(-1);
        assertNotEquals(initialY, paddle.yVelocity);
    }

    @Test
    void setYDirectionPositive(){
        Paddle paddle = new Paddle(0, 200, 25, 100, 1);
        int initialY = paddle.yVelocity;
        paddle.setYDirection(1);
        assertNotEquals(initialY, paddle.yVelocity);
    }
}