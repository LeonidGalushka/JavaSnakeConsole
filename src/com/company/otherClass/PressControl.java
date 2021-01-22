package com.company.otherClass;

public class PressControl {

    private boolean up;
    private boolean down;
    private boolean left;
    private boolean right;

    private static PressControl instance;

    private PressControl() {
        up = down = left = right = false;
    }

    public static PressControl getInstance() {
        if (instance == null) {
            instance = new PressControl();
        }
        return instance;
    }

    public boolean getUp() {
        return up;
    }

    public boolean getDown() {
        return down;
    }

    public boolean getLeft() {
        return left;
    }

    public boolean getRight() {
        return right;
    }

    public void pastUp() {
        this.up = true;
        down = left = right = false;
    }

    public void pastDown() {
        this.down = true;
        up = left = right = false;
    }

    public void pastLeft() {
        this.left = true;
        up = down = right = false;
    }

    public void pastRight() {
        this.right = true;
        down = left = up = false;
    }

}
