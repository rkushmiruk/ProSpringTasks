package com.kushmiruk.chapter03.injectsimplevalue.annotation;

import org.springframework.stereotype.Component;

@Component("injectSimpleConfig")
public class InjectSimpleConfig {
    public String name = "Roman";
    public int age = 22;
    public float height = 1.752f;
    public boolean programmer = true;
    public Long ageInSeconds = 100440940L;
}
