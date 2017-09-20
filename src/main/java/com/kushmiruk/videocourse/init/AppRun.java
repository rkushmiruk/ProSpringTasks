package com.kushmiruk.videocourse.init;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppRun {
    public static void main(String[] args) {
        ConfigurableApplicationContext appCtx =
                new ClassPathXmlApplicationContext("videocourse/init/app-context-xml.xml");

        SomeService service = appCtx.getBean(SomeService.class);
        service.call();

        appCtx.close();
    }
}
