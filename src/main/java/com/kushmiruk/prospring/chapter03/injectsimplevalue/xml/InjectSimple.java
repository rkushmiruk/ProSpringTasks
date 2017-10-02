package com.kushmiruk.prospring.chapter03.injectsimplevalue.xml;

import org.apache.log4j.Logger;
import org.springframework.context.support.GenericXmlApplicationContext;

public class InjectSimple {
    private static final Logger LOGGER = Logger.getLogger(InjectSimple.class);
    private String name;
    private int age;
    private float height;
    private boolean programmer;
    private Long ageInSeconds;

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:chapter03/META-INF/spring/injectsimplevalue/app-context-xml.xml");
        context.refresh();

        InjectSimple simple = (InjectSimple) context.getBean("injectSimple");
        LOGGER.info(simple);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setProgrammer(boolean programmer) {
        this.programmer = programmer;
    }

    public void setAgeInSeconds(Long ageInSeconds) {
        this.ageInSeconds = ageInSeconds;
    }

    @Override
    public String toString() {
        return "InjectSimple{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                ",Is programmer=" + programmer +
                ", ageInSeconds=" + ageInSeconds +
                '}';
    }
}
