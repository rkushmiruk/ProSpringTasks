package com.kushmiruk.chapter04.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigSimpleExample {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        MessageRenderer renderer = (MessageRenderer) context.getBean("renderer");
        renderer.render();
    }
}
