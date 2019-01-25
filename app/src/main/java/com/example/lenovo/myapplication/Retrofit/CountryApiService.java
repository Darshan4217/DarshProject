package com.example.lenovo.myapplication.Retrofit;

import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;
import retrofit2.http.GET;
import io.reactivex.Observable;

public interface CountryApiService {

    /*@GET("/photos")
    Call<List<CountryList>> getAllCountry();*/

    @GET("/photos")
    Single<List<CountryList>> getAllCountry();
}
