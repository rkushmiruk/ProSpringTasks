package com.kushmiruk.prospring.chapter05.afterreturningadvice;

import org.apache.log4j.Logger;
import org.springframework.aop.framework.ProxyFactory;

public class AfterReturningAdviceExample {
    private static final Logger LOGGER = Logger.getLogger(AfterReturningAdviceExample.class);

    private static KeyGenerator getKeyGenerator() {
        KeyGenerator generator = new KeyGenerator();
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(generator);
        proxyFactory.addAdvice(new WeakKeyCheckAdvice());
        return (KeyGenerator) proxyFactory.getProxy();
    }

    public static void main(String[] args) {
        KeyGenerator keyGenerator = getKeyGenerator();
        try {
            for (int x = 0; x < 10; x++) {
                long key = keyGenerator.getKey();
                LOGGER.info("Key: " + key);
            }
        } catch (SecurityException e) {
            LOGGER.info("WEAK Key Generated " + e.getMessage());
        }
    }
}
