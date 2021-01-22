package com.company.thread;

import com.company.enam.Keys;
import com.company.otherClass.PressControl;

import java.util.Scanner;

public class ThreadPress {

    public static void threadPressStart(Scanner in, PressControl pressControl) {

        Thread threadPress = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String pastPress = "";
            while (true) {
                String ch = in.nextLine();
                if (ch.equals(Keys.W.getTitle()) || ch.equals(Keys.w.getTitle())) {
                    if (pastPress.equals("")) continue; // startGame
                    if (pastPress.equals(Keys.S.getTitle())) continue;
                    pressControl.pastUp();
                    pastPress = Keys.W.getTitle();
                }
                if (ch.equals(Keys.S.getTitle()) || ch.equals(Keys.s.getTitle())) {
                    if (pastPress.equals(Keys.W.getTitle())) continue;
                    pressControl.pastDown();
                    pastPress = Keys.S.getTitle();
                }
                if (ch.equals(Keys.D.getTitle()) || ch.equals(Keys.d.getTitle())) {
                    if (pastPress.equals(Keys.A.getTitle())) continue;
                    pressControl.pastRight();
                    pastPress = Keys.D.getTitle();
                }
                if (ch.equals(Keys.A.getTitle()) || ch.equals(Keys.a.getTitle())) {
                    if (pastPress.equals(Keys.D.getTitle())) continue;
                    pressControl.pastLeft();
                    pastPress = Keys.A.getTitle();
                }
            }
        });

        threadPress.start();
    }
}
