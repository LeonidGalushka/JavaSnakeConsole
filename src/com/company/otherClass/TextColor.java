package com.company.otherClass;

import static com.company.setting.Constants.*;

public class TextColor {

    public static String setTextColor(String text, String color) {
        switch (color) {
            case "RED":
                return ANSI_RED + text + ANSI_RESET;
            case "WHITE":
                return ANSI_WHITE + text + ANSI_RESET;
            case "GREEN":
                return ANSI_GREEN + text + ANSI_RESET;
            case "BLUE":
                return ANSI_BLUE + text + ANSI_RESET;
            case "YELLOW":
                return ANSI_YELLOW + text + ANSI_RESET;
            case "BLACK":
                return ANSI_BLACK + text + ANSI_RESET;
            case "PURPLE":
                return ANSI_PURPLE + text + ANSI_RESET;
            case "CYAN":
                return ANSI_CYAN + text + ANSI_RESET;
        }
        return text;
    }
}
