package com.kushmiruk.prospring.chapter07;

import com.kushmiruk.prospring.chapter07.dao.ContactDao;
import org.apache.log4j.Logger;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringHibernateSample {
    private static final Logger LOGGER = Logger.getLogger(SpringHibernateSample.class);

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("prospring/chapter07/META-INF/spring/app-context-xml.xml");
        context.refresh();

        ContactDao contactDao = (ContactDao) context.getBean("contactDao");

        contactDao.findAll().forEach(LOGGER::info);
    }
}
