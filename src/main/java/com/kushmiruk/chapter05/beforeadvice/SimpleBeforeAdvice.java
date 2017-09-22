package com.kushmiruk.chapter05.beforeadvice;

import org.apache.log4j.Logger;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;

public class SimpleBeforeAdvice implements MethodBeforeAdvice {
    private static final Logger LOGGER = Logger.getLogger(SimpleBeforeAdvice.class);

    public static void main(String[] args) {
        MessageWriter target = new MessageWriter();

        ProxyFactory pf = new ProxyFactory();
        pf.addAdvice(new SimpleBeforeAdvice());
        pf.setTarget(target);

        MessageWriter proxy = (MessageWriter) pf.getProxy();
        proxy.writeMessage();
    }

    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        LOGGER.info("Before method: "+method.getName());
    }
}
