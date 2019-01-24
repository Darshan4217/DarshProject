package com.example.lenovo.myapplication.Retrofit;

import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface CountryApiService {

    @GET("/photos")
    Call<List<CountryList>> getAllCountry();
}
