package com.kushmiruk.chapter05.beforeadvice;

import org.apache.log4j.Logger;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class SecurityBeforeAdvice implements MethodBeforeAdvice {
    private static final Logger LOGGER = Logger.getLogger(SecurityBeforeAdvice.class);
    private SecurityManager securityManager;

    public SecurityBeforeAdvice() {
        this.securityManager = new SecurityManager();
    }


    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        UserInfo user = securityManager.getLoggedOnUser();

        if (user == null) {
            LOGGER.info("No user authenticated");
            throw new SecurityException("You must login before attemting to invoke the method"
                    + method.getName());

        } else if ("Roman".equals(user.getUserName())) {
            LOGGER.info("Logged in user is " + user.getUserName());
        } else {
            LOGGER.info("Logged in uesr is " + user.getUserName() + "Is not okay");
            throw new SecurityException("Is not allowed access to method" + method.getName());
        }
    }
}
