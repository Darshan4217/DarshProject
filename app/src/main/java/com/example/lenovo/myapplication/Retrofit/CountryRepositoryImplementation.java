package com.example.lenovo.myapplication.Retrofit;

import io.reactivex.Observable;

import java.util.List;

public class CountryRepositoryImplementation implements  Repository.CountryRepository {

    CountryApiService countryApiService;

    public  CountryRepositoryImplementation(CountryApiService countryApiService){
        this.countryApiService = countryApiService;

    }
   /* @Override
    public Call<List<CountryList>> getCountryList() {
        return countryApiService.getAllCountry();
    }*/

    @Override
    public Observable<List<CountryList>> getCountryList() {
        return countryApiService.getAllCountry();
    }
}
