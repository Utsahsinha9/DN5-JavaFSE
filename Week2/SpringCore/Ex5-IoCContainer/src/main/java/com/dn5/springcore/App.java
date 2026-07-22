package com.dn5.springcore;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        System.out.println("\n--- Singleton scope test ---");
        Engine s1 = context.getBean("singletonEngine", Engine.class);
        Engine s2 = context.getBean("singletonEngine", Engine.class);
        s1.start();
        System.out.println("Same instance? " + (s1 == s2));

        System.out.println("\n--- Prototype scope test ---");
        Engine p1 = context.getBean("prototypeEngine", Engine.class);
        Engine p2 = context.getBean("prototypeEngine", Engine.class);
        p1.start();
        System.out.println("Same instance? " + (p1 == p2));

        context.close();
    }
}