package com.kushmiruk.chapter07.dao;

import com.kushmiruk.chapter07.domain.Contact;

import java.util.List;

public interface ContactDao {
    List<Contact> findAll();

    List<Contact> findAllWithDetail();

    Contact findById(Long id);

    Contact save(Contact contact);

    void delete(Contact contact);
}