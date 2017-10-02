package com.kushmiruk.prospring.chapter07.dao;

import com.kushmiruk.prospring.chapter07.entity.Contact;

import java.util.List;

public interface ContactDao {
    List<Contact> findAll();

    List<Contact> findAllWithDetail();

    Contact findById(Long id);

    Contact save(Contact contact);

    void delete(Contact contact);
}
