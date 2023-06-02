package com.example.charity.rest;

public class MapsApiService {
    private static AppApi helloApi;
    public static AppApi getInstance(){
        if(helloApi == null) return create();
        return helloApi;
    }

    private static AppApi create() {
        return RetrofitService.getInstance().create(AppApi.class);
    }
}