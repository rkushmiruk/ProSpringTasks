package com.kushmiruk.videocourse.core.app;

public class Client {
    private Integer id;
    private String fullName;
    private String greeting;

    public Client(Integer  id, String fullName,String greeting) {
        this.id = id;
        this.fullName = fullName;
        this.greeting = greeting;
    }

    public Client() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }
}
