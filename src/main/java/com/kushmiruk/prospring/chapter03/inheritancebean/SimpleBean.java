package com.kushmiruk.prospring.chapter03.inheritancebean;

import org.apache.log4j.Logger;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SimpleBean {
    private static final Logger LOGGER = Logger.getLogger(SimpleBean.class);
    private String name;
    private int age;

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("prospring/chapter03/META-INF/spring/inheritancebean/app-context-xml.xml");
        context.refresh();

        SimpleBean parent = (SimpleBean) context.getBean("inheritParent");
        SimpleBean child = (SimpleBean) context.getBean("inheritChild");

        LOGGER.info("Parent:\n" + parent);
        LOGGER.info("Child:\n" + child);
    }

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
}
