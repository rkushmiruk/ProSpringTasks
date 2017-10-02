package com.kushmiruk.prospring.chapter04.javaconfig;

import com.kushmiruk.prospring.chapter02.annotation.MessageProvider;

public interface MessageRenderer {
    void render();
    void setMessageProvider(MessageProvider messageprovider);
    MessageProvider getMessageProvider();
}
