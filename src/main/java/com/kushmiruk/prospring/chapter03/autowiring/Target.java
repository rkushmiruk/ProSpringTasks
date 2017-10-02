package com.kushmiruk.prospring.chapter03.autowiring;

import org.apache.log4j.Logger;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Target {
    private static final Logger LOGGER = Logger.getLogger(Target.class);
    private Foo foo;
    private Foo foo2;
    private Bar bar;

    public Target() {

    }

    public Target(Foo foo) {
        LOGGER.info("Target foo set");
    }

    public Target(Foo foo, Bar bar) {
        LOGGER.info("Target foo,bar set");
    }

    public void setFoo(Foo foo) {
        this.foo = foo;
        LOGGER.info("Property foo set");
    }

    public void setFoo2(Foo foo2) {
        this.foo2 = foo2;
        LOGGER.info("Property foo2 set");
    }

    public void setBar(Bar bar) {
        this.bar = bar;
        LOGGER.info("Property bar set");
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("prospring/chapter03/META-INF/spring/autowiring/app-context-xml.xml");
        context.refresh();

        Target t = null;
        LOGGER.info("Using byName:\n");
        t = (Target) context.getBean("targetByName");

        LOGGER.info("Using byType:\n");
        t = (Target) context.getBean("targetByType");

        LOGGER.info("Using constructor:\n");
        t = (Target) context.getBean("targetByConstructor");

    }
}
