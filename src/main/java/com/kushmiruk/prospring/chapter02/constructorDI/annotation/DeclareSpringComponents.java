package com.kushmiruk.prospring.chapter02.constructorDI.annotation;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class DeclareSpringComponents {
    private static final Logger LOGGER = Logger.getLogger(DeclareSpringComponents.class);

    public static void main(String[] args) {
        ApplicationContext context = new GenericXmlApplicationContext(
                "classpath:chapter02/META-INF/spring/constructorDI/app-context-annotation.xml"
        );
       MessageProvider messageProvider = context.getBean("messageProvider", MessageProvider.class);
       LOGGER.info(messageProvider.getMessage());
    }
}
