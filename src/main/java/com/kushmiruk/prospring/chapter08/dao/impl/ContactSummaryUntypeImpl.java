package com.kushmiruk.prospring.chapter08.dao.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service("contactSummaryUntype")
@Transactional
public class ContactSummaryUntypeImpl {
    private static final Logger LOGGER = Logger.getLogger(ContactSummaryUntypeImpl.class);

    @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly = true)
    public void displayAllContactSummary() {
        List result = em.createQuery("select c.firstName, c.lastName,t.telNumber" +
                " from Contact c left join c.contactTelDetails t" +
                " where t.telType='Home'").getResultList();
        int count = 0;

        for (Object aResult : result) {
            Object[] values = (Object[]) aResult;
            LOGGER.info(++count + ": " + values[0] + ", " + values[1] + ", " + values[2]);
        }
    }
}
