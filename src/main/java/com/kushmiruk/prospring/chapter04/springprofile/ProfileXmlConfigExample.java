package com.kushmiruk.prospring.chapter04.springprofile;

import org.apache.log4j.Logger;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

public class ProfileXmlConfigExample {
    private static final Logger LOGGER = Logger.getLogger(ProfileXmlConfigExample.class);

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
//        context.getEnvironment().setActiveProfiles("kindergarten");
        context.load("prospring/chapter04/META-INF/spring/springprofile/*-context-xml.xml");
        context.refresh();

        FoodProviderService foodProviderService = (FoodProviderService) context.getBean("foodProviderService");

        //Edit run main configuration -Dspring.profiles.active="kindergarten"
        List<Food> lunchSet = foodProviderService.provideLunchSet();
        for (Food food : lunchSet) {
            LOGGER.info("Food: " + food.getName());
        }
    }
}
