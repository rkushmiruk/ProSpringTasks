package com.kushmiruk.prospring.chapter08.audit;

import org.springframework.data.domain.AuditorAware;

public class AuditorAwareBean implements AuditorAware<String> {
    @Override
    public String getCurrentAuditor() {
        return "Kushmyruk";
    }
}
