package com.kushmiruk.prospring.chapter08.dao.impl;

import com.kushmiruk.prospring.chapter08.dao.ContactService;
import com.kushmiruk.prospring.chapter08.entity.Contact;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service("jpaContactService")
@Transactional
public class ContactServiceImpl implements ContactService {
    private static final Logger LOGGER = Logger.getLogger(ContactServiceImpl.class);

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional(readOnly = true)
    public List<Contact> findAll() {
        return em.createNamedQuery("Contact.findAll", Contact.class).getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Contact> findAllWithDetail() {
        return em.createNamedQuery("Contact.findAllWithDetail", Contact.class).getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public Contact findById(Long id) {
        return em.createNamedQuery("Contact.findById", Contact.class).setParameter("id", id).getSingleResult();
    }

    @Override
    public Contact save(Contact contact) {
        return null;
    }

    @Override
    public void delete(Contact contact) {

    }
}
