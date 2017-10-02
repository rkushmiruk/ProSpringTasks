package com.kushmiruk.prospring.chapter03.collectioninject.xml;

import org.apache.log4j.Logger;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class CollectionInjection {
    private static final Logger LOGGER = Logger.getLogger(CollectionInjection.class);
    private Map<String, Object> map;
    private Properties props;
    private Set set;
    private List list;

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("prospring/chapter03/META-INF/spring/collectioninject/app-context-xml.xml");
        context.refresh();

        CollectionInjection injection = (CollectionInjection) context.getBean("injectCollection");
        injection.displayInfo();
    }

    public void displayInfo() {
        LOGGER.info("Map Contents:\n");
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            LOGGER.info("key: " + entry.getKey() + "- value: " + entry.getValue());
        }
        LOGGER.info("\nProperties contents:\n");
        for (Map.Entry<Object, Object> entry : props.entrySet()) {
            LOGGER.info("key: " + entry.getKey() + "- value: " + entry.getValue());
        }
        LOGGER.info("\nSet contents:");
        for (Object obj : set) {
            LOGGER.info("Value: " + obj);
        }
        LOGGER.info("\nList contents:");
        for (Object obj : list) {
            LOGGER.info("Value: " + obj);
        }

    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public void setProps(Properties props) {
        this.props = props;
    }

    public void setSet(Set set) {
        this.set = set;
    }

    public void setList(List list) {
        this.list = list;
    }
}
