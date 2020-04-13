package lesson_1;

import javax.swing.*;
import java.awt.*;

public class GameCanvas extends JPanel {

    MainCircles listener;
    long lastFrameTime;
    float startGameTime = System.nanoTime() * 0.000000001f;

    Background bg;

    GameCanvas(MainCircles listener) {
        this.listener = listener;
        lastFrameTime = System.nanoTime();
        bg = new Background(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //60 frames per second
        long currentTime = System.nanoTime();
        float deltaTime = (currentTime - lastFrameTime) * 0.000000001f;
        lastFrameTime = currentTime;
        listener.onCanvasRepainted(this, g, deltaTime);
        try {
            Thread.sleep(17);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        float gameTime = (System.nanoTime() * 0.000000001f - startGameTime);
        if (gameTime > 51f) {gameTime=0f; startGameTime = System.nanoTime() * 0.000000001f;}
        bg.update(gameTime);
        repaint();
    }

    public int getLeft() { return 0; }
    public int getRight() { return getWidth() - 1; }
    public int getTop() { return 0; }
    public int getBottom() { return getHeight() - 1; }

}
