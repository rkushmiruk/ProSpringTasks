package com.kushmiruk.prospring.chapter03.lookupmethodinjection;

import org.apache.log4j.Logger;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.StopWatch;

public class LookupDemo {
    private static final Logger LOGGER = Logger.getLogger(LookupDemo.class);

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("prospring/chapter03/META-INF/spring/lookupmethodinjection/app-context-xml.xml");
        context.refresh();

        DemoBean abstractBean = (DemoBean) context.getBean("abstractLookupBean");
        DemoBean standardBean = (DemoBean) context.getBean("standardLookupBean");

        displayInfo(standardBean);
        displayInfo(abstractBean);
    }

    public static void displayInfo(DemoBean bean) {
        MyHelper helper1 = bean.getMyHelper();
        MyHelper helper2 = bean.getMyHelper();

        LOGGER.info("Helper Instances the same?: " + (helper1 == helper2));
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("lookupDemo");

        for (int x = 0; x < 100000; x++) {
            MyHelper helper = bean.getMyHelper();
            helper.doHelpful();
        }

        stopWatch.stop();

        LOGGER.info("100000 gets took " + stopWatch.getTotalTimeMillis() + " ms");
    }
}
