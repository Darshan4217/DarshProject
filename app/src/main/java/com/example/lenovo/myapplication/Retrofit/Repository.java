package com.example.lenovo.myapplication.Retrofit;

import retrofit2.Call;

import java.util.List;

public class Repository {

    interface  CountryRepository{

        Call<List<CountryList>> getCountryList();
    }
}
