package ru.gb.jtwo.lone.online.circles;

import java.awt.*;
//Написать класс Бэкграунд, изменяющий цвет канвы в зависимости от времени
public class Background extends Thread{
    private GameCanvas canvas;
    long lastFrameTime = System.nanoTime();

    public Background(GameCanvas canvas) {
        this.canvas = canvas;
    }

    @Override
    public void run() {
        super.run();
        float a =15;
        float b =15;
        float c =15;
        while (true){

        canvas.setBackground(Color.getHSBColor(a,b,c));
            long currentTime = System.nanoTime();
            float deltaTime = (currentTime - lastFrameTime) * 0.000000001f;
        try {
            Thread.sleep(666);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        a=b;
        b=a+c;
        c = deltaTime;
        }

    }
}
