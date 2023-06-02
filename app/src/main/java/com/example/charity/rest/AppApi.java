package com.example.charity.rest;


import com.example.charity.domain.Product;
import com.example.charity.domain.Vacancy;
import com.example.charity.map.Place;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface AppApi {
    @GET("api/cmaps/{id}")
    Call<Product> getId(@Path("id") long id);

    @GET("api/cmaps")
    Call<List<Product>> getAll();

    @GET("api/chelpers")
    Call<List<Place>> getAll2();

    @GET("api/vacancies")
    Call<List<Vacancy>> getAll3();
}
