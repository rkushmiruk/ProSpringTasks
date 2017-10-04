package com.kushmiruk.prospring.chapter08.audit;

import com.kushmiruk.prospring.chapter08.audit.service.ContactAuditService;
import com.kushmiruk.prospring.chapter08.entity.ContactAudit;
import org.apache.log4j.Logger;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Date;

public class SpringAuditSample {
    private static final Logger LOGGER = Logger.getLogger(SpringAuditSample.class);

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("prospring/chapter08/META-INF/spring/audit/app-context-xml.xml");
        context.refresh();

        ContactAuditService contactAuditService = (ContactAuditService) context.getBean("contactAuditService");

        LOGGER.info("Add new contact");
        ContactAudit contactAudit = new ContactAudit();
        contactAudit.setFirstName("Jim");
        contactAudit.setLastName("Beam");
        contactAudit.setBirthDate(new Date());

        contactAuditService.save(contactAudit);

        contactAuditService.findAll().forEach(LOGGER::info);

        LOGGER.info(contactAuditService.findById(1L));
    }
}
