package com.sontekin.fid.service;

public class GreetingService {
    private final String greeting;

    public GreetingService(String greeting) {
        this.greeting = greeting;
    }

    public String getGreeting(String name) {
        return greeting + " " + name;
    }
}
