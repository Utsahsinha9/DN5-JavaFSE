package com.dn5.springcore;

public class EmailService implements MessageService {
    @Override
    public String getMessage() {
        return "Hello from EmailService!";
    }
}