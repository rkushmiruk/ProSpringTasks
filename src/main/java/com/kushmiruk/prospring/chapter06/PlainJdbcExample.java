package com.kushmiruk.prospring.chapter06;

import com.kushmiruk.prospring.chapter06.dao.ContactDao;
import com.kushmiruk.prospring.chapter06.domain.Contact;
import org.apache.log4j.Logger;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

public class PlainJdbcExample {
    private static final Logger LOGGER = Logger.getLogger(PlainJdbcExample.class);

    private static ContactDao contactDao;

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("prospring/chapter06/META-INF/spring/app-context-xml.xml");
        context.refresh();
        contactDao = (ContactDao) context.getBean("contactDao");

        List<Contact> contactList = contactDao.findAll();

        contactList.forEach(LOGGER::info);

        LOGGER.info(contactDao.findFirstNameById(2L));
        LOGGER.info(contactDao.findLastNameById(2L));
        LOGGER.info(contactDao.findAll());

        contactDao.findAllWithDetail().forEach(LOGGER::info);

        Contact contact = new Contact();
        contact.setId(2L);
        contact.setFirstName("Dima");
        contact.setLastName("Lunchenko");
        contactDao.update(contact);

        LOGGER.info(contactDao.findAll());
    }
}
