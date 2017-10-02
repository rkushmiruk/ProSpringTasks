package com.kushmiruk.prospring.chapter04.springenvironment;

import org.apache.log4j.Logger;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;

import java.util.HashMap;
import java.util.Map;

public class EnvironmentSample {
    private static final Logger LOGGER = Logger.getLogger(EnvironmentSample.class);

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.refresh();

        ConfigurableEnvironment environment = context.getEnvironment();
        MutablePropertySources propertySources = environment.getPropertySources();

        Map<String,Object> appMap = new HashMap();
        appMap.put("application.home","application_home");
        appMap.put("user.home","user_home");
        propertySources.addFirst(new MapPropertySource("PROSPRING4_MAP",appMap));

        LOGGER.info("user.home: "+System.getProperty("user.home"));
        LOGGER.info("JAVA_HOME: "+System.getenv("JAVA_HOME"));

        LOGGER.info("user.home: "+environment.getProperty("user.home"));
        LOGGER.info("JAVA_HOME: "+environment.getProperty("JAVA_HOME"));

        LOGGER.info("application.home: "+environment.getProperty("application.home"));
    }
}
