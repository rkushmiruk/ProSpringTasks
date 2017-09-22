package com.kushmiruk.chapter05.beforeadvice;

import org.apache.log4j.Logger;
import org.springframework.aop.framework.ProxyFactory;

public class SecurityExample {
    private static final Logger LOGGER = Logger.getLogger(SecurityExample.class);

    public static void main(String[] args) {
        SecurityManager manager = new SecurityManager();
        SecureBean secureBean = getSecureBean();

        manager.login("Roman", "pwd");
        secureBean.writeSecureMessage();
        manager.logout();

        try {
            manager.login("Dima", "pwd");
            secureBean.writeSecureMessage();
        } catch (SecurityException e) {
            LOGGER.info("Exception Caught: " + e.getMessage());
        } finally {
            manager.logout();
        }

        try {
            secureBean.writeSecureMessage();
        } catch (SecurityException e) {
            LOGGER.info("Exception Caught: " + e.getMessage());
        }
    }

    private static SecureBean getSecureBean() {
        SecureBean target = new SecureBean();
        SecurityBeforeAdvice securityAdvice = new SecurityBeforeAdvice();
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.addAdvice(securityAdvice);
        return (SecureBean) proxyFactory.getProxy();
    }
}
