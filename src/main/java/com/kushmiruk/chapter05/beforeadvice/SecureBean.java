package com.kushmiruk.chapter05.beforeadvice;

import org.apache.log4j.Logger;

public class SecureBean {
    private static final Logger LOGGER = Logger.getLogger(SecureBean.class);
    public void writeSecureMessage(){
        LOGGER.info("Every time i learn something new");
    }
}
