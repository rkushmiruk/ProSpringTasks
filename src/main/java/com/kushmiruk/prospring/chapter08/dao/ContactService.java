package com.kushmiruk.prospring.chapter08.dao;

import com.kushmiruk.prospring.chapter08.entity.Contact;

import java.util.List;

public interface ContactService {
    List<Contact> findAll();

    List<Contact> findAllWithDetail();

    Contact findById(Long id);

    Contact save(Contact contact);

    void delete(Contact contact);
}
