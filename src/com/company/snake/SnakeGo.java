package com.company.snake;

import com.company.enam.Direction;

public class SnakeGo {

    private Snake snake;
    private static SnakeGo instance;
    int xTime1, yTime1, xTime2, yTime2;

    private SnakeGo() {
        snake = Snake.getInstance();
    }

    public static SnakeGo getInstance() {
        if (instance == null) {
            instance = new SnakeGo();
        }
        return instance;
    }

    public void setGoSnake(Direction direction) {
        xTime1 = (int) snake.getXArr().get(0);
        yTime1 = (int) snake.getYArr().get(0);
        switch (direction) {
            case UP -> snake.getXArr().set(0, xTime1 - 1);
            case DOWN -> snake.getXArr().set(0, xTime1 + 1);
            case LEFT -> snake.getYArr().set(0, yTime1 - 1);
            case RIGHT -> snake.getYArr().set(0, yTime1 + 1);
        }
        xTime2 = xTime1;
        yTime2 = yTime1;
        for (int i = 1; i < snake.getXArr().size(); i++) {
            xTime1 = (int) snake.getXArr().get(i);
            yTime1 = (int) snake.getYArr().get(i);
            snake.getXArr().set(i, xTime2);
            snake.getYArr().set(i, yTime2);
            xTime2 = xTime1;
            yTime2 = yTime1;
        }
    }
}
