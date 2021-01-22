package com.company.snake;

public class AddBlockSnake {

    private static AddBlockSnake instance;
    private Snake snake;

    private AddBlockSnake() {
        snake = Snake.getInstance();
    }

    public static AddBlockSnake getInstance() {
        if (instance == null) {
            instance = new AddBlockSnake();
        }
        return instance;
    }

    public void snakeAdd() {
        // crawling down
        if ((int) snake.getXArr().get(snake.getXArr().size() - 2) < (int) snake.getXArr().get(snake.getXArr().size() - 1)) {
            snake.getXArr().add((int) snake.getXArr().get(snake.getXArr().size() - 1) + 1);
            snake.getYArr().add((int) snake.getYArr().get(snake.getYArr().size() - 1));
        }
        // crawling up
        else if ((int) snake.getXArr().get(snake.getXArr().size() - 2) > (int) snake.getXArr().get(snake.getXArr().size() - 1)) {
            snake.getXArr().add((int) snake.getXArr().get(snake.getXArr().size() - 1) - 1);
            snake.getYArr().add((int) snake.getYArr().get(snake.getYArr().size() - 1));
        }
        // crawling left
        else if ((int) snake.getYArr().get(snake.getYArr().size() - 2) > (int) snake.getYArr().get(snake.getYArr().size() - 1)) {
            snake.getYArr().add((int) snake.getYArr().get(snake.getYArr().size() - 1) + 1);
            snake.getXArr().add(snake.getXArr().get(snake.getXArr().size() - 1));
        }
        // crawling right
        else if ((int) snake.getYArr().get(snake.getYArr().size() - 2) > (int) snake.getYArr().get(snake.getYArr().size() - 1)) {
            snake.getYArr().add((int) snake.getYArr().get(snake.getYArr().size() - 1) - 1);
            snake.getXArr().add(snake.getXArr().get(snake.getXArr().size() - 1));
        }
    }
}
