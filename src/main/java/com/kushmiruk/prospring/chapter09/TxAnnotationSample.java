package com.kushmiruk.prospring.chapter09;

import com.kushmiruk.prospring.chapter09.entity.Contact;
import com.kushmiruk.prospring.chapter09.service.ContactService;
import org.apache.log4j.Logger;
import org.springframework.context.support.GenericXmlApplicationContext;


import java.util.Date;

public class TxAnnotationSample {
    private static final Logger LOGGER = Logger.getLogger(TxAnnotationSample.class);

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("prospring/chapter09/META-INF/spring/app-context-xml.xml");
        context.refresh();

        ContactService contactService = (ContactService) context.getBean("contactService");

        Contact contact = new Contact();
        contact.setFirstName("Jim");
        contact.setLastName("Beam");
        contact.setBirthDate(new Date());

        contactService.save(contact);

        contactService.findAll().forEach(LOGGER::info);

        LOGGER.info(contactService.countAll());
    }
}
