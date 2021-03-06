package com.kushmiruk.prospring.chapter02.annotation;

import org.springframework.stereotype.Service;

@Service("messageProvider")
public class HelloWorldMessageProvider implements MessageProvider {

    @Override
    public String getMessage() {
        return "Hello World!";
    }
}
