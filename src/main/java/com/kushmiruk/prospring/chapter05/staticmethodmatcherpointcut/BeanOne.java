package com.kushmiruk.prospring.chapter05.staticmethodmatcherpointcut;

import org.apache.log4j.Logger;

public class BeanOne {
    private static final Logger LOGGER = Logger.getLogger(BeanOne.class);

    public void foo() {
        LOGGER.info("foo");
    }

    public void bar() {
        LOGGER.info("bar");
    }
}
