package com.kushmiruk.prospring.chapter09.service.impl;

import com.google.common.collect.Lists;
import com.kushmiruk.prospring.chapter09.entity.Contact;
import com.kushmiruk.prospring.chapter09.repository.ContactRepository;
import com.kushmiruk.prospring.chapter09.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("contactService")
@Transactional
public class ContactServiceImpl implements ContactService {
    @Autowired
    private ContactRepository contactRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Contact> findAll() {
        return Lists.newArrayList(contactRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Contact findById(Long id) {
        return contactRepository.findOne(id);
    }

    @Override
    @Transactional
    public Contact save(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    @Transactional(propagation = Propagation.NEVER)
    public Long countAll() {
        return contactRepository.countAllContacts();
    }

    @Override
    @Transactional
    public void delete(Contact contact) {
        contactRepository.delete(contact);
    }


}
