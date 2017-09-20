package com.kushmiruk.videocourse.core.firstapp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    private Client client;
    private EventLogger eventLogger;
    private Event event;

    public App(Client client, EventLogger eventLogger) {
        this.client = client;
        this.eventLogger = eventLogger;
    }

    public Event logEvent(){
        event.setMsg(event.getMsg().replaceAll(String.valueOf(client.getId()),client.getFullName()));
        eventLogger.logEvent(event);
        return event;
    }

    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("videocourse/core/firstapp/app-context-xml.xml");

        App app = (App) context.getBean("app");

        System.out.println(app.logEvent());
        Thread thread = new Thread();
        try {
            thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(app.logEvent());


    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Event getEvent() {
        return event;
    }
}
