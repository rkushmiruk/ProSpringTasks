package com.kushmiruk.chapter04.applicationcontextaware;

import org.apache.log4j.Logger;
import org.springframework.context.support.GenericXmlApplicationContext;

import javax.annotation.PreDestroy;

public class DestructiveBean {
    private static final Logger LOGGER = Logger.getLogger(DestructiveBean.class);
    private String name;
    private int age = Integer.MIN_VALUE;

    @PreDestroy
    public void preDestroy() {
        LOGGER.info("Destroying bean by preDestroy annotation");
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("chapter04/META-INF/spring/applicationcontextaware/app-context-xml.xml");
        context.registerShutdownHook();
        context.refresh();

        DestructiveBean bean = (DestructiveBean) context.getBean("destructiveBean");
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
