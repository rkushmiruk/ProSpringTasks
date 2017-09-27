package com.kushmiruk.chapter06;

import com.kushmiruk.chapter06.dao.ContactDao;
import com.kushmiruk.chapter06.domain.Contact;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

public class PlainJdbcExample {
    private static ContactDao contactDao;

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("chapter06/META-INF/spring/app-context-xml.xml");
        context.refresh();
        contactDao = (ContactDao) context.getBean("contactDao");

        List<Contact> contactList = contactDao.findAll();

        for (Contact contact : contactList) {
            System.out.println(contactList);
        }
    }
}
