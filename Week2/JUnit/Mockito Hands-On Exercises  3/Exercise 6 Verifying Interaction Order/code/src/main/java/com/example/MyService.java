package com.example;

public class MyService {
    private ActionPerformer performer;

    public MyService(ActionPerformer performer) {
        this.performer = performer;
    }

    public void doWork() {
        performer.start();
        performer.perform();
        performer.end();
    }
}
