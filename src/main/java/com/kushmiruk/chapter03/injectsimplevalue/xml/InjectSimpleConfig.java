package com.kushmiruk.chapter03.injectsimplevalue.xml;

public class InjectSimpleConfig {
    private String name = "Roman";
    private int age = 22;
    private float height = 1.752f;
    private boolean programmer = true;
    private Long ageInSeconds = 100984321122L;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public float getHeight() {
        return height;
    }

    public boolean isProgrammer() {
        return programmer;
    }

    public Long getAgeInSeconds() {
        return ageInSeconds;
    }
}
