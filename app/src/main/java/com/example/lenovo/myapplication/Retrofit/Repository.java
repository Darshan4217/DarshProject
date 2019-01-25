package com.example.lenovo.myapplication.Retrofit;

import io.reactivex.Observable;
import io.reactivex.Single;

import java.util.List;

public class Repository {

    interface  CountryRepository{

        Single<List<CountryList>> getCountryList();
    }
}
