package com.kushmiruk.prospring.chapter05.afterreturningadvice;

import org.apache.log4j.Logger;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;

public class SimpleAfterReturningAdvice implements AfterReturningAdvice {
    private static final Logger LOGGER = Logger.getLogger(SimpleAfterReturningAdvice.class);

    public static void main(String[] args) {
        MessageWriter target = new MessageWriter();
        ProxyFactory proxyFactory = new ProxyFactory();

        proxyFactory.setTarget(target);
        proxyFactory.addAdvice(new SimpleAfterReturningAdvice());
        MessageWriter proxy = (MessageWriter) proxyFactory.getProxy();

        proxy.writeMessage();
    }

    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        LOGGER.info(" ");
        LOGGER.info("After method: "+method.getName());
    }
}
