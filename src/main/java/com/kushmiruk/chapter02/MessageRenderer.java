package com.kushmiruk.chapter02;

/**
 * Created by roman on 25.07.17.
 */
public interface MessageRenderer {
    void render();
    void setMessageProvider(MessageProvider provider);
    MessageProvider getMessageProvider();
}
