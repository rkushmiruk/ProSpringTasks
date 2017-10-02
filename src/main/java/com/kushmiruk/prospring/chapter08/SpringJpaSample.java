package com.kushmiruk.prospring.chapter08;

import com.kushmiruk.prospring.chapter08.dao.ContactService;
import com.kushmiruk.prospring.chapter08.dao.ContactSummaryService;
import com.kushmiruk.prospring.chapter08.dao.impl.ContactSummaryUntypeImpl;
import com.kushmiruk.prospring.chapter08.entity.Contact;
import org.apache.log4j.Logger;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

public class SpringJpaSample {
    private static final Logger LOGGER = Logger.getLogger(SpringJpaSample.class);

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("prospring/chapter08/META-INF/spring/app-context-xml.xml");
        context.refresh();

        ContactService contactDao = (ContactService) context.getBean("jpaContactService");

        ContactSummaryUntypeImpl contactSummaryUntype = (ContactSummaryUntypeImpl)
                context.getBean("contactSummaryUntype");

        ContactSummaryService contactSummaryService = (ContactSummaryService)
                context.getBean("contactSummaryService");


//        contactDao.findAll().forEach(LOGGER::info);
//        listContactsWithDetail(contactDao.findAllWithDetail());
//        LOGGER.info(contactDao.findById(1L));

//        contactSummaryUntype.displayAllContactSummary();
        contactSummaryService.findAll().forEach(LOGGER::info);
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
