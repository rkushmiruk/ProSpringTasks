package com.kushmiruk.prospring.chapter08.jpa.service.impl;

import com.kushmiruk.prospring.chapter08.jpa.service.ContactSummaryService;
import com.kushmiruk.prospring.chapter08.entity.ContactSummary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service("contactSummaryService")
@Transactional
public class ContactSummaryServiceImpl implements ContactSummaryService {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(readOnly = true)
    public List<ContactSummary> findAll() {
        return entityManager.createQuery("Select new com.kushmiruk.prospring.chapter08.entity.ContactSummary (" +
                "c.firstName, c.lastName, t.telNumber) " +
                "from Contact c left join c.contactTelDetails t " +
                "where t.telType='Home'", ContactSummary.class).getResultList();
    }

}
