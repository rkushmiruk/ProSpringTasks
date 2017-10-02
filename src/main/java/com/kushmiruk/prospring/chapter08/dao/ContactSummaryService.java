package com.kushmiruk.prospring.chapter08.dao;

import com.kushmiruk.prospring.chapter08.entity.ContactSummary;

import java.util.List;

public interface ContactSummaryService {
    List<ContactSummary> findAll();

}
