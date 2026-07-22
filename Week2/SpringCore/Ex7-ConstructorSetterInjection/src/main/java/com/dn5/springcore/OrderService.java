package com.dn5.springcore;

public class OrderService {

    private final Notifier notifier;

    // Constructor injection: Notifier is REQUIRED for this class to function at
    // all,
    // so it's passed in at construction time and stored as final (immutable once
    // set)
    public OrderService(Notifier notifier) {
        this.notifier = notifier;
    }

    public void placeOrder(String item) {
        System.out.println("Order placed for: " + item);
        notifier.send("Your order for " + item + " has been placed.");
    }
}