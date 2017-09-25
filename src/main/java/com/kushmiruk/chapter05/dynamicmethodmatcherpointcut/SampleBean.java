package com.kushmiruk.chapter05.dynamicmethodmatcherpointcut;

import org.apache.log4j.Logger;

public class SampleBean {
    private static final Logger LOGGER = Logger.getLogger(SampleBean.class);

    public void foo(int x) {
        LOGGER.info("Invoked foo() with: " + x);
    }

    public void bar() {
        LOGGER.info("Invoked bar()");
    }

}
