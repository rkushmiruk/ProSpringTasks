package com.kushmiruk.prospring.chapter03.hierarchicalcontext.xml;

import org.apache.log4j.Logger;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HierarchicalContextUsage {
    private static final Logger LOGGER = Logger.getLogger(HierarchicalContextUsage.class);

    public static void main(String[] args) {
        GenericXmlApplicationContext parentContext = new GenericXmlApplicationContext();
        parentContext.load("prospring/chapter03/META-INF/spring/hierarchicalcontext/parent-app-context-xml.xml");
        parentContext.refresh();

        GenericXmlApplicationContext childContext = new GenericXmlApplicationContext();
        childContext.load("prospring/chapter03/META-INF/spring/hierarchicalcontext/child-app-context-xml.xml");
        childContext.setParent(parentContext);
        childContext.refresh();

        SimpleTarget target1 = (SimpleTarget) childContext.getBean("target1");
        SimpleTarget target2 = (SimpleTarget) childContext.getBean("target2");
        SimpleTarget target3 = (SimpleTarget) childContext.getBean("target3");

        LOGGER.info(target1.getVal()); //Bean in Parent
        LOGGER.info(target2.getVal()); //Bean in Child
        LOGGER.info(target3.getVal()); //Bean in Parent
    }
}
