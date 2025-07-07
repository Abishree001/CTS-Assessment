package com.example;

public class AlertService {
    private Notifier notifier;

    public AlertService(Notifier notifier) {
        this.notifier = notifier;
    }

    public void raiseAlert(String msg) {
        notifier.send(msg);
    }
}
