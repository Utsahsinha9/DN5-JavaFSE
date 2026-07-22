package com.dn5.springcore;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Notifier notifier() {
        return new SmsNotifier();
    }

    @Bean
    public OrderService orderService() {
        // constructor injection: dependency passed directly
        return new OrderService(notifier());
    }

    @Bean
    public ReportService reportService() {
        ReportService service = new ReportService();
        // setter injection: dependency assigned after construction
        service.setNotifier(notifier());
        return service;
    }
}