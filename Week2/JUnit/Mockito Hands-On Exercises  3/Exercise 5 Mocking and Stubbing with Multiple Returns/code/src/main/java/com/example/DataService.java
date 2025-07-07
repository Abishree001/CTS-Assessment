package com.example;

public class DataService {
    private ExternalApi api;

    public DataService(ExternalApi api) {
        this.api = api;
    }

    public void printTwoFetches() {
        System.out.println("1st fetch: " + api.fetchData());
        System.out.println("2nd fetch: " + api.fetchData());
    }
}
