package com.company.enam;

public enum Direction {
    UP("Up"),
    DOWN("Down"),
    LEFT("Left"),
    RIGHT("Right");

    private String title;

    Direction(String title){
        this.title = title;
    }

    public String getTitle(){
        return title;
    }

}