package com.kushmiruk.chapter03.beanfactory;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

public class XmlConfigWithBeanFactory {
    private static final Logger LOGGER = Logger.getLogger(XmlConfigWithBeanFactory.class);
    private static final String ORACLE_BEAN_NAME = "oracle";

    public static void main(String[] args) {
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions("chapter03/META-INF/spring/beanfactory/xml-bean-factory-config");

        Oracle oracle = (Oracle) factory.getBean(ORACLE_BEAN_NAME);

        LOGGER.info(oracle.defineMeaningOfLife());
    }
}
