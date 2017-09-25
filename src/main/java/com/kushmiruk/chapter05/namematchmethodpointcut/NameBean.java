package com.kushmiruk.chapter05.namematchmethodpointcut;

import org.apache.log4j.Logger;

public class NameBean {
    private static final Logger LOGGER = Logger.getLogger(NameBean.class);

    public void foo() {
        LOGGER.info("foo");
    }

    public void foo(int x) {
        LOGGER.info("foo " + x);
    }

    public void bar() {
        LOGGER.info("bar");
    }

    public void yup() {
        LOGGER.info("yup");
    }
}
