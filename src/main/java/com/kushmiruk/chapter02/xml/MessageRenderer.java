package com.kushmiruk.chapter02.xml;

public interface MessageRenderer {
    void render();

    void setMessageProvider(MessageProvider provider);

    MessageProvider getMessageProvider();
}
