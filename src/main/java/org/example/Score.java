package org.example;
import java.awt.*;

public class Score extends Rectangle{
    private static int GAME_WIDTH;
    private static int GAME_HEIGHT;
    int p1;
    int p2;
    public Score(int gameWidth, int gameHeight){
        Score.GAME_WIDTH = gameWidth;
        Score.GAME_HEIGHT = gameHeight;
    }
    public void draw(Graphics g){
        g.setColor(Color.white);
        g.setFont(new Font("Consolas", Font.PLAIN, 60));
        g.drawLine(GAME_WIDTH/2, 0, GAME_WIDTH/2, GAME_HEIGHT);
        g.drawString(String.valueOf(p1/10) + String.valueOf(p1%10), GAME_WIDTH/2 - 85, 50);
        g.drawString(String.valueOf(p2/10) + String.valueOf(p2%10), GAME_WIDTH/2 + 20, 50);
    }
}
