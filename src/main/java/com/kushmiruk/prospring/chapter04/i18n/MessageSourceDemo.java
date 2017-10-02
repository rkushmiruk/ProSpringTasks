package com.kushmiruk.prospring.chapter04.i18n;

import org.apache.log4j.Logger;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Locale;

public class MessageSourceDemo {
    private static final Logger LOGGER = Logger.getLogger(MessageSourceDemo.class);

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("prospring/chapter04/META-INF/spring/i18n/app-context-xml.xml");
        context.refresh();
        Locale english = Locale.ENGLISH;
        Locale russian = new Locale("ru");

        LOGGER.info(context.getMessage("msg",null,english));
        LOGGER.info(context.getMessage("msg",null,russian));
        LOGGER.info(context.getMessage("nameMsg",new Object[]{"Roman","Kushmyruk"},english));


    }
}
