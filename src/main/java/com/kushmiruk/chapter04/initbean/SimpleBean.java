package com.kushmiruk.chapter04.initbean;

import org.apache.log4j.Logger;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SimpleBean {
    private static final Logger LOGGER = Logger.getLogger(SimpleBean.class);
    private static final String DEFAULT_NAME = "Luke Kushmyruk";
    private String name;
    private int age = Integer.MIN_VALUE;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "SimpleBean{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void init() {
        LOGGER.info("Initializing bean");

        if (name == null) {
            LOGGER.info("Using default name");
            name = DEFAULT_NAME;
        }
        if (age == Integer.MIN_VALUE) {
            LOGGER.info("Using default age");
            age = 22;
        }
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("chapter04/initbean/app-context-xml.xml");
        context.refresh();

        SimpleBean simpleBean1 = (SimpleBean) context.getBean("simpleBean1");
        LOGGER.info(simpleBean1);
        SimpleBean simpleBean2 = (SimpleBean) context.getBean("simpleBean2");
        LOGGER.info(simpleBean2);
        SimpleBean simpleBean3 = (SimpleBean) context.getBean("simpleBean3");
        LOGGER.info(simpleBean3);

    }
}
