package com.company.otherClass;

import com.company.snake.Snake;

import static com.company.setting.Constants.FIELD_SIZE;

public class CrashWithWall {

    private static CrashWithWall instance;

    private CrashWithWall() {
    }

    public static CrashWithWall getInstance() {
        if (instance == null) {
            instance = new CrashWithWall();
        }
        return instance;
    }

    public boolean isCrash(Snake snake) {

        for (int i = 1; i < snake.getXArr().size(); i++)
            if (snake.getXArr().get(0) == snake.getXArr().get(i) && snake.getYArr().get(0) == snake.getYArr().get(i)) return true;

        if ((int) snake.getXArr().get(0) == 0 || (int) snake.getXArr().get(0) == FIELD_SIZE - 1 ||
                (int) snake.getYArr().get(0) == 0 || (int) snake.getYArr().get(0) == FIELD_SIZE - 1) return true;

        return false;
    }
}
