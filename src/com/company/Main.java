package com.company;

import com.company.otherClass.PressControl;
import com.company.snake.SnakeGo;
import com.company.thread.ThreadPress;
import com.company.thread.ThreadUI;
import com.company.ui.Field;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ThreadUI.threadUIStart(PressControl.getInstance(), SnakeGo.getInstance(), Field.getInstance());
        ThreadPress.threadPressStart(new Scanner(System.in), PressControl.getInstance());
    }
}