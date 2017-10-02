package com.kushmiruk.prospring.chapter04.resource;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

import java.io.File;

public class ResourceDemo {
    private static final Logger LOGGER = Logger.getLogger(ResourceDemo.class);

    public static void main(String[] args) throws Exception {
        ApplicationContext context =new ClassPathXmlApplicationContext();

        File file = File.createTempFile("test","txt");
        file.deleteOnExit();

        LOGGER.info(file.getPath());
        Resource res1 = context.getResource("file://"+file.getPath());
        LOGGER.info(res1.getClass());
        Resource res2 = context.getResource("classpath:test.txt");
        LOGGER.info(res2.getClass());
        Resource res3= context.getResource("http://www.google.com");
        LOGGER.info(res3.getClass());
        LOGGER.info(res3.getURL().getContent());

    }

}
