package com.kushmiruk.prospring.chapter04.factorybean;

import org.apache.log4j.Logger;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.security.MessageDigest;

public class MessageDigestExample {
    private static final Logger LOGGER = Logger.getLogger(MessageDigestExample.class);

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("prospring/chapter04/META-INF/spring/factorybean/app-context-xml.xml");
        context.refresh();

        MessageDigester messageDigester = (MessageDigester) context.getBean("digester");
        messageDigester.digest("Hello World!");

        MessageDigest digest = (MessageDigest) context.getBean("shaDigest");

        MessageDigestFactoryBean factoryBean = (MessageDigestFactoryBean) context.getBean("&shaDigest");

        try{
            MessageDigest shaDigest = factoryBean.getObject();
            LOGGER.info(shaDigest.digest("Hello World".getBytes()));
            LOGGER.info(digest.equals(shaDigest));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
