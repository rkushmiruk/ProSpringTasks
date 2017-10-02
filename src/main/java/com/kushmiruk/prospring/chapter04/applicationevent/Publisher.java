package com.kushmiruk.prospring.chapter04.applicationevent;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Publisher implements ApplicationContextAware {
    private ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    public void publish(String message) {
        context.publishEvent(new MessageEvent(this, message));
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("prospring/chapter04/META-INF/spring/applicationevent/app-context-xml.xml");
        context.refresh();

        Publisher pub = (Publisher) context.getBean("publisher");
        pub.publish("Hello world!");
        pub.publish("The quick brown fox jumped over the lazy dog");
    }
}
