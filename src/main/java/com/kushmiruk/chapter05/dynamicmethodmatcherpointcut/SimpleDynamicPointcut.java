package com.kushmiruk.chapter05.dynamicmethodmatcherpointcut;

import org.apache.log4j.Logger;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;

import java.lang.reflect.Method;

public class SimpleDynamicPointcut extends DynamicMethodMatcherPointcut {
    private static final Logger LOGGER = Logger.getLogger(SimpleDynamicPointcut.class);

    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        LOGGER.info("Static check for " + method.getName());
        return "foo".equals(method.getName());
    }

    @Override
    public boolean matches(Method method, Class<?> targetClass, Object... args) {
        LOGGER.info("Dynamic check for " + method.getName());
        int x = (Integer) args[0];
        return x != 100;
    }

    @Override
    public ClassFilter getClassFilter() {
        return new ClassFilter() {
            @Override
            public boolean matches(Class<?> clazz) {
                return clazz == SampleBean.class;
            }
        };
    }
}
