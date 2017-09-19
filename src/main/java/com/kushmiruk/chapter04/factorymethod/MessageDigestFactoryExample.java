package com.kushmiruk.chapter04.factorymethod;

import com.kushmiruk.chapter04.factorybean.MessageDigester;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MessageDigestFactoryExample {
    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("chapter04/META-INF/spring/factorymethod/app-context-xml.xml");
        context.refresh();

        MessageDigester messageDigester = (MessageDigester) context.getBean("digester");
        messageDigester.digest("Hello World!");
    }
}
