package com.kushmiruk.chapter02.annotation;

public interface MessageRenderer {
    void render();

    void setMessageProvider(MessageProvider provider);

    MessageProvider getMessageProvider();
}
