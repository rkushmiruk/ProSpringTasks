package com.kushmiruk.prospring.chapter09.service;


import com.kushmiruk.prospring.chapter09.entity.Contact;

import java.util.List;

public interface ContactService {
    List<Contact> findAll();

    Contact findById(Long id);

    Contact save(Contact contact);

    Long countAll();

    void delete(Contact contact);
}
