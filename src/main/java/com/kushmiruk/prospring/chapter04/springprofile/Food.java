package com.kushmiruk.prospring.chapter04.springprofile;

public class Food {
    private String name;

    public Food(String name) {
        this.name = name;
    }

    public Food() {
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
