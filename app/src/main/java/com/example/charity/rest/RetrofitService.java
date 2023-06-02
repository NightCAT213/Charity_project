package com.example.charity.rest;

import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class RetrofitService {
    private static final String URL = "http://192.168.0.51:8080";
    private static Retrofit retrofit;
    public static Retrofit getInstance() {
        if (retrofit == null) return create();
        return retrofit;
    }

    private static Retrofit create() {
        return new Retrofit.Builder().baseUrl(URL).addConverterFactory(MoshiConverterFactory.create()).build();
    }

}
