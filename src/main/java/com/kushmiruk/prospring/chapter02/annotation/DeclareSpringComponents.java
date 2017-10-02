package com.kushmiruk.prospring.chapter02.annotation;

import org.apache.log4j.Logger;
import org.springframework.context.support.GenericXmlApplicationContext;

public class DeclareSpringComponents {
    private static final Logger LOGGER = Logger.getLogger(DeclareSpringComponents.class);

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("prospring/chapter02/META-INF/spring/annotation/app-context-annotation.xml");
        context.refresh();

        MessageProvider messageProvider = context.getBean("messageProvider", MessageProvider.class);
        LOGGER.info(messageProvider.getMessage());

        MessageRenderer messageRenderer = context.getBean("messageRenderer",MessageRenderer.class);
        messageRenderer.render();
    }
}
