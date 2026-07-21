package com.dn5.springcore;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Greeter greeter() {
        return new Greeter();
    }
}