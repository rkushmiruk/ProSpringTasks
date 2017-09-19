package com.kushmiruk.chapter04.javaconfig;

import org.springframework.context.support.GenericXmlApplicationContext;

public class JavaConfigXmlExample {
    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("chapter04/META-INF/spring/javaconfig/app-context-xml.xml");
        context.refresh();

        MessageRenderer renderer = context.getBean("messageRenderer", MessageRenderer.class);

        renderer.render();
    }
}
