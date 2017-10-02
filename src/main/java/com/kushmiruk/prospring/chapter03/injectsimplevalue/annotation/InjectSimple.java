package com.kushmiruk.prospring.chapter03.injectsimplevalue.annotation;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service("injectSimple")
public class InjectSimple {
    private static final Logger LOGGER = Logger.getLogger(InjectSimple.class);
    @Value("Roman")
    private String name;
    @Value("22")
    private int age;
    @Value("1.752")
    private float height;
    @Value("true")
    private boolean programmer;
    @Value("10000000")
    private Long ageInSeconds;

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:chapter03/META-INF/spring/injectsimplevalue/app-context-annotation.xml");
        context.refresh();

        InjectSimple simple = (InjectSimple) context.getBean("injectSimple");
        LOGGER.info(simple);
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
