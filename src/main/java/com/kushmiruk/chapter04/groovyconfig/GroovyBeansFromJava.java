package com.kushmiruk.chapter04.groovyconfig;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericGroovyApplicationContext;

public class GroovyBeansFromJava {
    private static final Logger LOGGER = Logger.getLogger(GroovyBeansFromJava.class);

    public static void main(String[] args) {
        ApplicationContext context =
                new GenericGroovyApplicationContext("chapter04/META-INF/spring/groovyconfig/beans");

        Contact contact = (Contact) context.getBean("contact");
        LOGGER.info(contact);
    }
}
