package com.kushmiruk.prospring.chapter04.javaconfig;

import com.kushmiruk.prospring.chapter02.annotation.MessageProvider;

public class ConfigurableMessageProvider implements MessageProvider {
    private String message = "This is a configurable messsage";

    public ConfigurableMessageProvider(String message) {
        this.message = message;
    }

    public ConfigurableMessageProvider() {
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
