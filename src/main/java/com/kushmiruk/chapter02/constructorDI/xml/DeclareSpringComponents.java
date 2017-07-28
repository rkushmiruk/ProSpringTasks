package com.kushmiruk.chapter02.constructorDI.xml;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DeclareSpringComponents {
    private static final Logger LOGGER = Logger.getLogger(DeclareSpringComponents.class);

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "chapter02/META-INF/spring/constructorDI/app-context-xml.xml"
        );
        MessageProvider messageProvider = context.getBean("messageProvider", MessageProvider.class);
       LOGGER.info(messageProvider.getMessage());
    }
}
