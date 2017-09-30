package com.kushmiruk.chapter07;

import com.kushmiruk.chapter07.dao.ContactDao;
import com.kushmiruk.chapter07.domain.Contact;
import org.apache.log4j.Logger;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringHibernateSample {
    private static final Logger LOGGER = Logger.getLogger(SpringHibernateSample.class);

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("chapter07/META-INF/spring/app-context-xml.xml");
        context.refresh();

        ContactDao contactDao = (ContactDao) context.getBean("contactDao");

        for(Contact contact : contactDao.findAll()){
            LOGGER.info(contact);
        }
    }
}
