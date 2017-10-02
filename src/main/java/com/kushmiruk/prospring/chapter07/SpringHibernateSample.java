package com.kushmiruk.prospring.chapter07;

import com.kushmiruk.prospring.chapter07.dao.ContactDao;
import com.kushmiruk.prospring.chapter07.entity.Contact;
import com.kushmiruk.prospring.chapter07.entity.ContactTelDetail;
import org.apache.log4j.Logger;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Date;
import java.util.List;

public class SpringHibernateSample {
    private static final Logger LOGGER = Logger.getLogger(SpringHibernateSample.class);

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("prospring/chapter07/META-INF/spring/app-context-xml.xml");
        context.refresh();

        ContactDao contactDao = (ContactDao) context.getBean("contactDao");

//        contactDao.findAll().forEach(LOGGER::info);
//        listContactsWithDetail(contactDao.findAll());
//        listContactsWithDetail(contactDao.findAllWithDetail());
        LOGGER.info(contactDao.findById(1L));

        Contact contact = new Contact();
        contact.setFirstName("Michael");
        contact.setLastName("Jackson");
        contact.setBirthDate(new Date());

        ContactTelDetail contactTelDetail = new ContactTelDetail("Home", "111111");
        contact.addContactTelDetail(contactTelDetail);

        contactTelDetail = new ContactTelDetail("Mobile", "222222");
        contact.addContactTelDetail(contactTelDetail);

        contactDao.save(contact);

        contactDao.delete(contactDao.findById(1L));

        listContactsWithDetail(contactDao.findAllWithDetail());
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
