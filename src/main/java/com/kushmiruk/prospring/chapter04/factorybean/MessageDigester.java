package com.kushmiruk.prospring.chapter04.factorybean;

import org.apache.log4j.Logger;

import java.security.MessageDigest;

public class MessageDigester {
    private static final Logger LOGGER = Logger.getLogger(MessageDigester.class);
    private MessageDigest messageDigest1;
    private MessageDigest messageDigest2;

    public void digest(String msg) {
        LOGGER.info("Using digest1");
        digest(msg, messageDigest1);

        LOGGER.info("Using digest2");
        digest(msg, messageDigest2);
    }

    private void digest(String msg, MessageDigest digest) {
        LOGGER.info("Using algorithm: " + digest.getAlgorithm());
        digest.reset();
        byte[] bytes = msg.getBytes();
        byte[] out = digest.digest(bytes);
        LOGGER.info(out);
    }

    public void setMessageDigest1(MessageDigest messageDigest1) {
        this.messageDigest1 = messageDigest1;
    }

    public void setMessageDigest2(MessageDigest messageDigest2) {
        this.messageDigest2 = messageDigest2;
    }
}
