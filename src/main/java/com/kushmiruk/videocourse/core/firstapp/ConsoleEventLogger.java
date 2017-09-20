package com.kushmiruk.videocourse.core.firstapp;

import org.apache.log4j.Logger;

public class ConsoleEventLogger implements EventLogger {
    private static final Logger LOGGER = Logger.getLogger(ConsoleEventLogger.class);

    public void logEvent(Event event) {
        LOGGER.info(event.toString());
    }
}
