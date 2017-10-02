package com.kushmiruk.prospring.chapter05.beforeadvice;

import org.apache.log4j.Logger;

public class MessageWriter {
    private static final Logger LOGGER = Logger.getLogger(MessageWriter.class);

    public void writeMessage(){
        LOGGER.info("Hello!");
    }
}
