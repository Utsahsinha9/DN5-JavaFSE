package com.dn5.springcore;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class Engine {

    public Engine() {
        System.out.println("Engine: constructor called");
    }

    @PostConstruct
    public void init() {
        System.out.println("Engine: @PostConstruct - starting up, ready to inject dependencies used here");
    }

    public void start() {
        System.out.println("Engine: running");
    }

    @PreDestroy
    public void cleanup() {
        System.out.println("Engine: @PreDestroy - shutting down, releasing resources");
    }
}