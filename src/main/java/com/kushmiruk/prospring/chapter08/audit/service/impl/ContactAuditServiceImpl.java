package com.kushmiruk.prospring.chapter08.audit.service.impl;

import com.google.common.collect.Lists;
import com.kushmiruk.prospring.chapter08.audit.repository.ContactAuditRepository;
import com.kushmiruk.prospring.chapter08.audit.service.ContactAuditService;
import com.kushmiruk.prospring.chapter08.entity.ContactAudit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("contactAuditService")
@Transactional
public class ContactAuditServiceImpl implements ContactAuditService {
    @Autowired
    private ContactAuditRepository contactAuditRepository;

    @Override
    @Transactional(readOnly = true)
    public List<ContactAudit> findAll() {
        return Lists.newArrayList(contactAuditRepository.findAll());
    }

    @Override
    public ContactAudit findById(Long id) {
        return contactAuditRepository.findOne(id);
    }

    @Override
    public ContactAudit save(ContactAudit contactAudit) {
        return contactAuditRepository.save(contactAudit);
    }
}
