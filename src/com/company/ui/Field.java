package com.company.ui;

import com.company.otherClass.CrashWithWall;
import com.company.otherClass.Eat;
import com.company.otherClass.TextColor;
import com.company.snake.AddBlockSnake;
import com.company.snake.Snake;

import static com.company.setting.Constants.*;

public class Field {

    private String[][] arrayField;
    private static Field instance;
    private Eat eat;
    private Snake snake;
    private AddBlockSnake addBlockSnake;
    private CrashWithWall crashWithWall;

    public static Field getInstance() {
        if (instance == null) {
            instance = new Field();
        }
        return instance;
    }

    private Field() {
        arrayField = new String[FIELD_SIZE][FIELD_SIZE];
        eat = Eat.getInstance();
        snake = Snake.getInstance();
        addBlockSnake = AddBlockSnake.getInstance();
        crashWithWall = CrashWithWall.getInstance();
        //start of the game
        clearField();
        drawField();
        correctGenerationEatToField();
        drawEat();
    }

    private void clearField() {
        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                if (i == 0 || i == FIELD_SIZE - 1 || j == 0 || j == FIELD_SIZE - 1) {
                    arrayField[i][j] = FIELD_BORDER_SYMBOL;
                } else {
                    arrayField[i][j] = FIELD_SYMBOL;
                }
            }
        }
    }

    public synchronized void drawField() {
        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                System.out.print(TextColor.setTextColor(arrayField[i][j], TEXT_COLOR_FIELD));
            }
            System.out.println();
        }
    }

    public synchronized void drawShake() {

        if (crashWithWall.isCrash(snake)) {
            System.out.println(TextColor.setTextColor(TEXT_GAME_OVER, TEXT_COLOR_FINAL_TEXT));
            System.exit(0);
        }
        for (int i = 0; i < snake.getXArr().size(); i++) {
            arrayField[(int) snake.getXArr().get(i)][(int) snake.getYArr().get(i)] =
                    (i == 0 ? TextColor.setTextColor(SYMBOL_SNAKE_HEAD, TEXT_COLOR_HEAD_SHAKE) : TextColor.setTextColor(SYMBOL_SNAKE_BODY, TEXT_COLOR_BODY_SHAKE));
        }
    }

    public synchronized void drawSnakeAndEat() {
        clearField();
        drawEat();
        drawShake();
    }

    public void correctGenerationEatToField() {
        while (true) {
            eat.setNewEat();
            for (int i = 0; i < snake.getXArr().size(); i++)
                if (eat.getX() == (int) snake.getXArr().get(i) && eat.getY() == (int) snake.getYArr().get(i)) continue;
            break;
        }
    }

    public void drawEat() {
        arrayField[eat.getX()][eat.getY()] = TextColor.setTextColor(SYMBOL_EAT, TEXT_COLOR_EAT);
    }

    public void checkEat() {
        if ((int) snake.getYArr().get(0) == eat.getY() && (int) snake.getXArr().get(0) == eat.getX()) {
            addBlockSnake.snakeAdd();
            correctGenerationEatToField();
            drawEat();
        }
    }
}
