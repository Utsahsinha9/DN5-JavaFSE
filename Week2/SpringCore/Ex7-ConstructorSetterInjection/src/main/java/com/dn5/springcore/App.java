package com.dn5.springcore;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        System.out.println("--- Constructor Injection (OrderService) ---");
        OrderService orderService = context.getBean(OrderService.class);
        orderService.placeOrder("Laptop");

        System.out.println("\n--- Setter Injection (ReportService) ---");
        ReportService reportService = context.getBean(ReportService.class);
        reportService.generateReport();

        context.close();
    }
}