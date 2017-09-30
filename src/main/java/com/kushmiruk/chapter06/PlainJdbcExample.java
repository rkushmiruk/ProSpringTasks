package com.kushmiruk.chapter06;

import com.kushmiruk.chapter06.dao.ContactDao;
import com.kushmiruk.chapter06.domain.Contact;
import org.apache.log4j.Logger;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

public class PlainJdbcExample {
    private static final Logger LOGGER = Logger.getLogger(PlainJdbcExample.class);

    private static ContactDao contactDao;

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("chapter06/META-INF/spring/app-context-xml.xml");
        context.refresh();
        contactDao = (ContactDao) context.getBean("contactDao");

        List<Contact> contactList = contactDao.findAll();

        for (Contact contact : contactList) {
            LOGGER.info(contact);
        }

        LOGGER.info(contactDao.findFirstNameById(2L));
        LOGGER.info(contactDao.findLastNameById(2L));
        LOGGER.info(contactDao.findAll());

        for (Contact contact : contactDao.findAllWithDetail()) {
            LOGGER.info(contact);
        }

        Contact contact = new Contact();
        contact.setId(2L);
        contact.setFirstName("Dima");
        contact.setLastName("Lunchenko");
        contactDao.update(contact);

        LOGGER.info(contactDao.findAll());
    }
}
