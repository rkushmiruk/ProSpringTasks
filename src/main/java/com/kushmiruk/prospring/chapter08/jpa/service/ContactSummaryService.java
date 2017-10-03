package com.kushmiruk.prospring.chapter08.jpa.service;

import com.kushmiruk.prospring.chapter08.entity.ContactSummary;

import java.util.List;

public interface ContactSummaryService {
    List<ContactSummary> findAll();

}
