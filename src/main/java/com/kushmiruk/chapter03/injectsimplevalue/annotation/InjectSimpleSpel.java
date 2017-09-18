package com.kushmiruk.chapter03.injectsimplevalue.annotation;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service("injectSimpleSpel")
public class InjectSimpleSpel {
    private static final Logger LOGGER = Logger.getLogger(InjectSimpleSpel.class);
    @Value("#{injectSimpleConfig.name}")
    private String name;
    @Value("#{injectSimpleConfig.age+12}")
    private int age;
    @Value("#{injectSimpleConfig.height}")
    private float height;
    @Value("#{injectSimpleConfig.programmer}")
    private boolean programmer;
    @Value("#{injectSimpleConfig.ageInSeconds}")
    private Long ageInSeconds;

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("chapter03/META-INF/spring/injectsimplevalue/app-context-annotation.xml");
        context.refresh();

        InjectSimpleSpel simple = (InjectSimpleSpel) context.getBean("injectSimpleSpel");
        LOGGER.info(simple);

    }

    @Override
    public String toString() {
        return "InjectSimpleSpel{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", programmer=" + programmer +
                ", ageInSeconds=" + ageInSeconds +
                '}';
    }
}
