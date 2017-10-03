package com.kushmiruk.prospring.chapter08.jpa;

import com.kushmiruk.prospring.chapter08.jpa.service.ContactService;
import com.kushmiruk.prospring.chapter08.jpa.service.ContactSummaryService;
import com.kushmiruk.prospring.chapter08.jpa.service.impl.ContactSummaryUntypeImpl;
import com.kushmiruk.prospring.chapter08.entity.Contact;
import org.apache.log4j.Logger;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

public class SpringJpaSample {
    private static final Logger LOGGER = Logger.getLogger(SpringJpaSample.class);

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("prospring/chapter08/META-INF/spring/jpa/app-context-xml.xml");
        context.refresh();

        ContactService contactService = (ContactService) context.getBean("jpaContactService");

        ContactSummaryUntypeImpl contactSummaryUntype = (ContactSummaryUntypeImpl)
                context.getBean("contactSummaryUntype");

        ContactSummaryService contactSummaryService = (ContactSummaryService)
                context.getBean("contactSummaryService");


        contactService.findAll().forEach(LOGGER::info);
        listContactsWithDetail(contactService.findAllWithDetail());
        LOGGER.info(contactService.findById(1L));
        contactSummaryUntype.displayAllContactSummary();
        contactSummaryService.findAll().forEach(LOGGER::info);
        contactService.findAllByNativeQuery().forEach(LOGGER::info);
        LOGGER.info(contactService.findByCriteriaQuery("John", "Smith"));
    }

    private static void listContactsWithDetail(List<Contact> contacts) {
        LOGGER.info("Listing contacts with details:");

        for (Contact contact : contacts) {
            LOGGER.info(contact);
            if (contact.getContactTelDetails() != null) {
                contact.getContactTelDetails().forEach(LOGGER::info);
            }
            if (contact.getHobbies() != null) {
                contact.getHobbies().forEach(LOGGER::info);
            }
        }
    }

}
