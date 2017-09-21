package com.kushmiruk.videocourse.core.app;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

public class App {
    private Client client;
    private Map<EventType, EventLogger> eventLoggers;
    private Event event;

    public App(Client client, Map<EventType, EventLogger> eventLoggers) {
        this.client = client;
        this.eventLoggers = eventLoggers;
    }

    public void logEvent(EventType eventType) {
        EventLogger logger = eventLoggers.get(eventType);
        if (logger == null) {
            logger = eventLoggers.get(EventType.DEFAULT);
        }
        Event event = getEvent();
        event.setMsg(event.getMsg().replaceAll(String.valueOf(client.getId()), client.getFullName())
                +" "+client.getGreeting());
        logger.logEvent(event);
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                new ClassPathXmlApplicationContext("videocourse/core/app/app-context-xml.xml");
        context.registerShutdownHook();

        App app = (App) context.getBean("app");
        app.logEvent(null);
        app.logEvent(EventType.INFO);
        Thread thread = new Thread();
        try {
            thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        app.logEvent(EventType.ERROR);
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Event getEvent() {
        return event;
    }
}
