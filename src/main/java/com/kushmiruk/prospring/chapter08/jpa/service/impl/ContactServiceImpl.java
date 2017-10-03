package com.kushmiruk.prospring.chapter08.jpa.service.impl;

import com.kushmiruk.prospring.chapter08.jpa.service.ContactService;
import com.kushmiruk.prospring.chapter08.entity.Contact;
import com.kushmiruk.prospring.chapter08.entity.Contact_;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.List;

@Service("jpaContactService")
@Transactional
public class ContactServiceImpl implements ContactService {
    private static final Logger LOGGER = Logger.getLogger(ContactServiceImpl.class);
    private static final String ALL_CONTACT_NATIVE_QUERY =
            "select id,first_name, last_name, birth_date, version from contact";

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
        if (contact.getId() == null) {
            LOGGER.info("Inserting new contact");
            em.persist(contact);
        } else {
            em.merge(contact);
            LOGGER.info("Updating new contact");
        }
        return contact;
    }

    @Override
    public void delete(Contact contact) {
        Contact mergedContact = em.merge(contact);
        em.remove(mergedContact);

        LOGGER.info("Contact with id: " + contact.getId() + " was deleted");
    }

    @Override
    @Transactional(readOnly = true)
    public List<Contact> findAllByNativeQuery() {
        return em.createNativeQuery(ALL_CONTACT_NATIVE_QUERY, "contactResult").getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Contact> findByCriteriaQuery(String firstName, String lastName) {
        LOGGER.info("Finding contact for firstName: " + firstName
                + " and lastName: " + lastName);

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Contact> criteriaQuery = cb.createQuery(Contact.class);
        Root<Contact> contactRoot = criteriaQuery.from(Contact.class);
        contactRoot.fetch(Contact_.contactTelDetails, JoinType.LEFT);
        contactRoot.fetch(Contact_.hobbies, JoinType.LEFT);
        criteriaQuery.select(contactRoot).distinct(true);
        Predicate criteria = cb.conjunction();

        if (firstName != null) {
            Predicate p = cb.equal(contactRoot.get(Contact_.firstName), firstName);
            criteria = cb.and(criteria, p);
        }
        if (lastName != null) {
            Predicate p = cb.equal(contactRoot.get(Contact_.lastName), lastName);
            criteria = cb.and(criteria, p);
        }

        criteriaQuery.where(criteria);

        return em.createQuery(criteriaQuery).getResultList();
    }
}
