package com.kushmiruk.chapter05.staticmethodmatcherpointcut;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.log4j.Logger;

public class SimpleAdvice implements MethodInterceptor {
    private static final Logger LOGGER = Logger.getLogger(SimpleAdvice.class);

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        LOGGER.info(">> Invoking " + invocation.getMethod().getName());
        Object retVal = invocation.proceed();
        LOGGER.info(">> Done");
        return retVal;
    }
}
