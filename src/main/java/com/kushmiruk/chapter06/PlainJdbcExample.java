package com.kushmiruk.chapter06;

import com.kushmiruk.chapter06.dao.ContactDao;
import com.kushmiruk.chapter06.dao.impl.JdbcContactDao;
import com.kushmiruk.chapter06.domain.Contact;

import java.util.List;

public class PlainJdbcExample {
    private static ContactDao contactDao = new JdbcContactDao();

    public static void main(String[] args) {
        List<Contact> contactList = contactDao.findAll();

        for (Contact contact : contactList) {
            System.out.println(contactList);
        }
    }
}
