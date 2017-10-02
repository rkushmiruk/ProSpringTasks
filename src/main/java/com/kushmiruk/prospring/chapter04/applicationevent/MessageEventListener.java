package com.kushmiruk.prospring.chapter04.applicationevent;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationListener;

public class MessageEventListener implements ApplicationListener<MessageEvent> {
    private static final Logger LOGGER = Logger.getLogger(MessageEventListener.class);

    @Override
    public void onApplicationEvent(MessageEvent messageEvent) {
        MessageEvent msgEvent = messageEvent;
        LOGGER.info("Received: "+msgEvent.getMsg());

    }
}
