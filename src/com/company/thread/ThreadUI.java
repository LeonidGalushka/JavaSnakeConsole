package com.company.thread;

import com.company.enam.Direction;
import com.company.ui.Field;
import com.company.otherClass.PressControl;
import com.company.snake.SnakeGo;

import static com.company.setting.Constants.SPEED_SNAKE;

public class ThreadUI {

    public static void threadUIStart(PressControl pressControl, SnakeGo snakeGo, Field field){

        Thread threadUI = new Thread(() -> {

            while (true) {
                try {
                    Thread.sleep(SPEED_SNAKE);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (pressControl.getUp()) {
                    snakeGo.setGoSnake(Direction.UP);
                }
                if (pressControl.getDown()) {
                    snakeGo.setGoSnake(Direction.DOWN);
                }
                if (pressControl.getRight()) {
                    snakeGo.setGoSnake(Direction.RIGHT);
                }
                if (pressControl.getLeft()) {
                    snakeGo.setGoSnake(Direction.LEFT);
                }
                field.drawSnakeAndEat();
                field.checkEat();
                field.drawField();
            }
        });

        threadUI.start();
    }
}
