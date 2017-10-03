package com.kushmiruk.prospring.chapter08.springdatajpa.service.impl;

import com.google.common.collect.Lists;
import com.kushmiruk.prospring.chapter08.entity.Contact;
import com.kushmiruk.prospring.chapter08.springdatajpa.repository.ContactRepository;
import com.kushmiruk.prospring.chapter08.springdatajpa.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service("springJpaContactService")
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
    public List<Contact> findByFirstName(String firstName) {
        return contactRepository.findByFirstName(firstName);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Contact> findByFirstNameAndLastName(String firstName, String lastName) {
        return contactRepository.findByFirstNameAndLastName(firstName,lastName);
    }
}
