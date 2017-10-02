package com.kushmiruk.prospring.chapter03.methodreplacement;

import org.apache.log4j.Logger;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.StopWatch;

public class MethodReplacementExample {
    private static final Logger LOGGER = Logger.getLogger(MethodReplacementExample.class);

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("prospring/chapter03/META-INF/spring/methodreplacement/app-context-xml.xml");
        context.refresh();

        ReplacementTarget replacementTarget = (ReplacementTarget) context.getBean("replacementTarget");
        ReplacementTarget standardTarget = (ReplacementTarget) context.getBean("standardTarget");

        displayInfo(replacementTarget);
        displayInfo(standardTarget);

    }

    public static void displayInfo(ReplacementTarget target) {
        LOGGER.info(target.formatMessage("Hello World"));

        StopWatch stopWatch = new StopWatch();
        stopWatch.start("perfTest");

        for (int x = 0; x < 1000000; x++) {
            String out = target.formatMessage("foo");
        }

        stopWatch.stop();
        LOGGER.info("100000 gets took " + stopWatch.getTotalTimeMillis() + " ms");
    }
}
