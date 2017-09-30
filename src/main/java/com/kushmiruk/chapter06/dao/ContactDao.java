package com.kushmiruk.chapter06.dao;

import com.kushmiruk.chapter06.domain.Contact;

import java.util.List;

public interface ContactDao {
    List<Contact> findAll();

    List<Contact> findAllWithDetail();

    List<Contact> findByFirstName(String firstName);

    Contact findById(Long id);

    void insert(Contact contact);

    void update(Contact contact);

    void delete(Contact contact);

    String findFirstNameById(Long id);

    String findLastNameById(Long id);

}
