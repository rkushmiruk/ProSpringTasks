package com.kushmiruk.chapter04.javaconfig;

import com.kushmiruk.chapter02.annotation.MessageProvider;

public interface MessageRenderer {
    void render();
    void setMessageProvider(MessageProvider messageprovider);
    MessageProvider getMessageProvider();
}
