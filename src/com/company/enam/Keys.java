package com.company.enam;

public enum Keys {

    W("W"),
    w("w"),
    D("D"),
    d("d"),
    A("A"),
    a("a"),
    S("S"),
    s("s");

    private String title;

    Keys(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
