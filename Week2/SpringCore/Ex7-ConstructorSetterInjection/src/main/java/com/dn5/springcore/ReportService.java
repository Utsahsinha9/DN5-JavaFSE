package com.dn5.springcore;

public class ReportService {

    private Notifier notifier;

    // Setter injection: Notifier is OPTIONAL here — a report can still be generated
    // without sending a notification, so it's not forced through the constructor
    public void setNotifier(Notifier notifier) {
        this.notifier = notifier;
    }

    public void generateReport() {
        System.out.println("Report generated.");
        if (notifier != null) {
            notifier.send("Your report is ready.");
        } else {
            System.out.println("No notifier configured — skipping notification.");
        }
    }
}