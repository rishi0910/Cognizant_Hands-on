package com.rishi.mockito_stubbing_exercise;

public class MyService {
    private final ExternalApi externalApi;

    // Constructor Injection
    public MyService(ExternalApi externalApi) {
        this.externalApi = externalApi;
    }

    public String fetchData() {
        return externalApi.getData();
    }
}