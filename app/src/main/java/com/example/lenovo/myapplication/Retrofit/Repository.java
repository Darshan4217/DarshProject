package com.example.lenovo.myapplication.Retrofit;

import io.reactivex.Observable;

import java.util.List;

public class Repository {

    interface  CountryRepository{

        Observable<List<CountryList>> getCountryList();
    }
}
