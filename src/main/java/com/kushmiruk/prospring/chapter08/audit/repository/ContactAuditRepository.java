package com.kushmiruk.prospring.chapter08.audit.repository;

import com.kushmiruk.prospring.chapter08.entity.ContactAudit;
import org.springframework.data.repository.CrudRepository;

public interface ContactAuditRepository extends CrudRepository<ContactAudit, Long> {
}
