package lesson_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainCircles extends JFrame {
    private static final int POS_X = 400;
    private static final int POS_Y = 200;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;

    Sprite[] sprites = new Sprite[10];

    private Sprite[] arrayLengthChange(Sprite[] sprites, int newLength) {
        if (newLength>=0) {
            Sprite[] arr = new Sprite[newLength];
            System.arraycopy(sprites, 0, arr, 0, sprites.length < newLength ? sprites.length : newLength);
            return arr;
        }
        return sprites;
    }

    public static void main(String[] args) {
       SwingUtilities.invokeLater(new Runnable() {
           @Override
           public void run() {
               new MainCircles();
           }
       });
    }

    private MainCircles() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        GameCanvas canvas = new GameCanvas(this);
        add(canvas, BorderLayout.CENTER);
        setTitle("Circles");
        initApplication();
        setVisible(true);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                onMouseClick(e);
            }
        });
    }

    private void onMouseClick(MouseEvent e)  {
        if (e.getButton() == 1) {
            sprites = arrayLengthChange(sprites,sprites.length + 1);
            sprites[sprites.length-1] = new Ball();

        }
        if (e.getButton() == 3 || e.getButton() == 2) {
            sprites = arrayLengthChange(sprites,sprites.length - 1);
        }
    }

    private void initApplication() {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i] = new Ball();
        }
    }

    void onCanvasRepainted(GameCanvas canvas, Graphics g, float deltaTime) {
        update(canvas, deltaTime);
        render(canvas, g);
    }

    private void update(GameCanvas canvas, float deltaTime) {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].update(canvas, deltaTime);
        }
    }

    private void render(GameCanvas canvas, Graphics g) {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].render(canvas, g);
        }
    }
}
