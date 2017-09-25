package com.kushmiruk.chapter05.staticmethodmatcherpointcut;

import org.apache.log4j.Logger;

public class BeanTwo {
    private static final Logger LOGGER = Logger.getLogger(BeanTwo.class);

    public void foo() {
        LOGGER.info("foo");
    }

    public void bar() {
        LOGGER.info("bar");
    }
}
