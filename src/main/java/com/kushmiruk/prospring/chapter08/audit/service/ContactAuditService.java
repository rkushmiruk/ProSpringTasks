package com.kushmiruk.prospring.chapter08.audit.service;

import com.kushmiruk.prospring.chapter08.entity.ContactAudit;

import java.util.List;

public interface ContactAuditService {
    List<ContactAudit> findAll();

    ContactAudit findById(Long id);

    ContactAudit save(ContactAudit contactAudit);
}
