package com.kushmiruk.chapter05.aroundadvice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.log4j.Logger;
import org.springframework.util.StopWatch;

import java.lang.reflect.Method;

public class ProfilingInterceptor implements MethodInterceptor {
    private static final Logger LOGGER = Logger.getLogger(ProfilingInterceptor.class);

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        StopWatch sw = new StopWatch();
        sw.start(methodInvocation.getMethod().getName());
        Object returnValue = methodInvocation.proceed();
        sw.stop();
        dumpInfo(methodInvocation, sw.getTotalTimeMillis());
        return returnValue;
    }

    private void dumpInfo(MethodInvocation methodInvocation, long ms) {
        Method method = methodInvocation.getMethod();
        Object target = methodInvocation.getThis();
        Object[] args = methodInvocation.getArguments();

        LOGGER.info("Executed method: " + method.getName());
        LOGGER.info("On object of type: " + target.getClass().getName());
        LOGGER.info("With arguments: ");
        for (int x = 0; x < args.length; x++) {
            LOGGER.info("  > " + args[x]);
        }
        LOGGER.info("\n");
        LOGGER.info("Took: " + ms + " ms");

    }
}
