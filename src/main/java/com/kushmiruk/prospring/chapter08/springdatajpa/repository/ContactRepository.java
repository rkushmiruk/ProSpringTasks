package com.kushmiruk.prospring.chapter08.springdatajpa.repository;

import com.kushmiruk.prospring.chapter08.entity.Contact;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ContactRepository extends CrudRepository<Contact, Long> {
    List<Contact> findByFirstName(String firstName);

    List<Contact> findByFirstNameAndLastName(String firstName, String lastName);
}
