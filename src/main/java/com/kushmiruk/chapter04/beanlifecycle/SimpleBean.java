package com.kushmiruk.chapter04.beanlifecycle;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.support.GenericXmlApplicationContext;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class SimpleBean implements InitializingBean, DisposableBean {
    private static final Logger LOGGER = Logger.getLogger(SimpleBean.class);
    private static final String DEFAULT_NAME = "Luke Kushmyruk";
    private String name;
    private int age = Integer.MIN_VALUE;

    @PostConstruct
    public void initPost() {
        LOGGER.info("Initializing bean by initPost() method");

        LOGGER.info("Using default name in initPost method");
        name = "Princess Lea";
        LOGGER.info("Using default age in initPost method");
        age = 35;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        LOGGER.info("Initializing bean by initializing bean interface");
        LOGGER.info("Using default name in interface");
        name = "Luke Skywalker";
        LOGGER.info("Using default age in interface");
        age = 25;
    }

    public void init() {
        LOGGER.info("Initializing bean by init() method");

        LOGGER.info("Using default name in init method");
        name = DEFAULT_NAME;
        LOGGER.info("Using default age in init method");
        age = 22;
    }

    @PreDestroy
    public void preDestroy() {
        LOGGER.info("Destroying bean by preDestroy annotation");
    }

    @Override
    public void destroy() {
        LOGGER.info("Destroying bean by disposable bean interface");
    }

    public void destroyMethod() {
        LOGGER.info("Destroying bean by destroy method");
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("chapter04/META-INF/spring/beanlifecycle/app-context-xml.xml");
        context.registerShutdownHook();
        context.refresh();

        SimpleBean simpleBean1 = (SimpleBean) context.getBean("simpleBean1");
        LOGGER.info(simpleBean1);
        SimpleBean simpleBean2 = (SimpleBean) context.getBean("simpleBean2");
        LOGGER.info(simpleBean2);
        SimpleBean simpleBean3 = (SimpleBean) context.getBean("simpleBean3");
        LOGGER.info(simpleBean3);
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
