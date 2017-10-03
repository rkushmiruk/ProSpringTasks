package com.kushmiruk.prospring.chapter08.springdatajpa;

import com.kushmiruk.prospring.chapter08.springdatajpa.service.ContactService;
import org.apache.log4j.Logger;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringDataJpaSample {
    private static final Logger LOGGER = Logger.getLogger(SpringDataJpaSample.class);

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("prospring/chapter08/META-INF/spring/springdatajpa/app-context-xml.xml");
        context.refresh();

        ContactService contactService = (ContactService) context.getBean("springJpaContactService");

        LOGGER.info(contactService.findAll());
        LOGGER.info(contactService.findByFirstName("Roman"));
        LOGGER.info(contactService.findByFirstNameAndLastName("John","Smith"));

    }
}
