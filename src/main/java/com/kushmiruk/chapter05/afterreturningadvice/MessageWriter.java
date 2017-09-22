package com.kushmiruk.chapter05.afterreturningadvice;

import org.apache.log4j.Logger;

public class MessageWriter {
    private static final Logger LOGGER = Logger.getLogger(MessageWriter.class);

    public void writeMessage(){
        LOGGER.info("Hello!");
    }
}
