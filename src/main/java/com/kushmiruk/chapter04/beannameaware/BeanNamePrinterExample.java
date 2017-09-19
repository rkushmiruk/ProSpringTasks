package com.kushmiruk.chapter04.beannameaware;

import org.springframework.context.support.GenericXmlApplicationContext;

public class BeanNamePrinterExample {
    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("chapter04/META-INF/spring/beannameaware/app-context-xml.xml");
        context.refresh();

        BeanNamePrinter bean = (BeanNamePrinter) context.getBean("beanNamePrinter");
        bean.doSmth();
    }
}
