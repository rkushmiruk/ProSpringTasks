package com.kushmiruk.prospring.chapter04.springenvironment;

import org.apache.log4j.Logger;
import org.springframework.context.support.GenericXmlApplicationContext;

public class PlaceHolderSample {
    private static final Logger LOGGER = Logger.getLogger(PlaceHolderSample.class);

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("prospring/chapter04/META-INF/spring/springenvironment/app-context-xml.xml");
        context.refresh();

        AppProperty appProperty = (AppProperty) context.getBean("appProperty");

        LOGGER.info("application.home: " + appProperty.getApplicationHome());
        //need add local-override="true" to configure file xml
        LOGGER.info("user.home: " + appProperty.getUserHome());
    }
}
