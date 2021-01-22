package com.company.snake;

import java.util.ArrayList;
import java.util.List;

import static com.company.setting.Constants.*;

public class Snake {

    private static Snake instance;
    private List<Integer> xArr;
    private List<Integer> yArr;

    private Snake() {
        xArr = new ArrayList<>();
        yArr = new ArrayList<>();
        SnakeNewGame();
    }

    private void SnakeNewGame() {
        for (int i = 0; i < SIZE_SNAKE_NEW_GAME; i++) {
            xArr.add(FIELD_SIZE / 2 - i);
            yArr.add(FIELD_SIZE / 2);
        }
    }

    public static Snake getInstance() {
        if (instance == null) {
            instance = new Snake();
        }
        return instance;
    }

    public ArrayList getXArr() {
        return (ArrayList) xArr;
    }

    public ArrayList getYArr() {
        return (ArrayList) yArr;
    }
}
