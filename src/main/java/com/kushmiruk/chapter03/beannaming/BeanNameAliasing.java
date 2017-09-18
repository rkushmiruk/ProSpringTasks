package com.kushmiruk.chapter03.beannaming;

import org.apache.log4j.Logger;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BeanNameAliasing {
    private static final Logger LOGGER = Logger.getLogger(BeanNameAliasing.class);
    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("chapter03/META-INF/spring/beannaming/app-context-xml.xml");
        context.refresh();

        String s1 = (String) context.getBean("name1");
        String s2 = (String) context.getBean("name2");
        String s3 = (String) context.getBean("name3");
        String s4 = (String) context.getBean("name4");
        String s5 = (String) context.getBean("name5");
        String s6 = (String) context.getBean("name6");

        LOGGER.info(s1==s2);
        LOGGER.info(s2==s3);
        LOGGER.info(s3==s4);
        LOGGER.info(s4==s5);
        LOGGER.info(s5==s6);
    }
}
