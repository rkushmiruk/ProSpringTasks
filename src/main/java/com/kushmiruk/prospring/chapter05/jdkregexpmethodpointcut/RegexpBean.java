package com.kushmiruk.prospring.chapter05.jdkregexpmethodpointcut;

import org.apache.log4j.Logger;

public class RegexpBean {
    private static final Logger LOGGER = Logger.getLogger(RegexpBean.class);

    public void foo1() {
        LOGGER.info("foo1");
    }

    public void foo2() {
        LOGGER.info("foo2");
    }

    public void bar() {
        LOGGER.info("bar");
    }
}
