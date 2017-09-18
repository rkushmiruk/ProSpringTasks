package com.kushmiruk.chapter03.collectioninject.annotation;

import org.apache.log4j.Logger;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

@Service("injectCollection")
public class CollectionInjection {
    private static final Logger LOGGER = Logger.getLogger(CollectionInjection.class);
    @Resource(name="map")
    private Map<String, Object> map;
    @Resource(name="props")
    private Properties props;
    @Resource(name="set")
    private Set set;
    @Resource(name="list")
    private List list;

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("chapter03/META-INF/spring/collectioninject/app-context-annotation.xml");
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
}
