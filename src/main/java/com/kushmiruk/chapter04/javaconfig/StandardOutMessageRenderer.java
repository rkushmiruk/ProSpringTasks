package com.kushmiruk.chapter04.javaconfig;

import com.kushmiruk.chapter02.annotation.MessageProvider;
import org.apache.log4j.Logger;

public class StandardOutMessageRenderer implements MessageRenderer {
    private static final Logger LOGGER = Logger.getLogger(StandardOutMessageRenderer.class);
    private MessageProvider messageProvider;

    @Override
    public void render() {
        if (messageProvider == null) {
            throw new RuntimeException();
        }
        LOGGER.info(messageProvider.getMessage());
    }

    @Override
    public void setMessageProvider(MessageProvider messageProvider) {
        this.messageProvider = messageProvider;
    }

    @Override
    public MessageProvider getMessageProvider() {
        return this.messageProvider;
    }
}
