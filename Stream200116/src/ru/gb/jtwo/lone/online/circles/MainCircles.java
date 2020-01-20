package ru.gb.jtwo.lone.online.circles;

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
        initApplication();
        GameCanvas canvas = new GameCanvas(this);
        canvas.addMouseListener(new MouseAdapter() {
           // * Реализовать добавление новых кружков по клику используя ТОЛЬКО массивы
           //** Реализовать по клику другой кнопки удаление кружков (никаких эррейЛист)
            //control + тач непашет так как это не совсем тоже самое что нажать правую кнопку мыши
            //тач двумя пальцами пашет
            @Override
            public void mousePressed(MouseEvent e) {
                if(e.getButton()== MouseEvent.BUTTON1) {
                    int x = e.getX();
                    int y = e.getY();
                    for (int i = 0; i < sprites.length; i++) {
                        boolean is_drop = x >= sprites[i].getWidth() && x <= sprites[i].getRight() && y >= sprites[i].getTop() && y <= sprites[i].getBottom();
                        if (is_drop) {
                            Sprite[] sprites2 = new Sprite[sprites.length - 1];
                            for (int k = 0; k < i; k++) {
                                sprites2[k] = sprites[k];
                            }
                            for (int k = i + 1; k < sprites.length; k++) {
                                sprites2[k - 1] = sprites[k];
                            }
                            sprites = sprites2;
                        }
                    }
                }
                if(e.getButton() == MouseEvent.BUTTON3){
                    Sprite[] sprites2 = new Sprite[sprites.length +1];
                    for(int i = 0;i <sprites.length; i++ ){
                        sprites2[i] = sprites[i];
                    }
                    sprites2[sprites.length] = new Ball();
                    sprites = sprites2;
                }
            }
        });
        Background background = new Background(canvas);
        background.start();
        add(canvas, BorderLayout.CENTER);
        setTitle("Circles");
        setVisible(true);
    }

    private void initApplication() {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i] = new Ball();
        }
    }

    public void onDrawFrame(GameCanvas canvas, Graphics g, float deltaTime) {
        update(canvas, deltaTime); // obnovlenie // S = v * t
        render(canvas, g); // otrisovka
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
