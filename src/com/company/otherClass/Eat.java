package com.company.otherClass;

import java.util.Random;

import static com.company.setting.Constants.FIELD_SIZE;

public class Eat {

    private int xEat, yEat;
    private static Eat instance;
    private Random random;

    private Eat() {
        random = new Random();
    }

    public static Eat getInstance() {
        if (instance == null) {
            instance = new Eat();
        }
        return instance;
    }

    public void setNewEat() {

        xEat = random.nextInt(FIELD_SIZE - 2) + 1;
        yEat = random.nextInt(FIELD_SIZE - 2) + 1;
    }

    public int getX() {
        return xEat;
    }

    public int getY() {
        return yEat;
    }

}
