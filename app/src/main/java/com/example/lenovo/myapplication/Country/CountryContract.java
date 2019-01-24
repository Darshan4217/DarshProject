package com.example.lenovo.myapplication.Country;

import com.example.lenovo.myapplication.Retrofit.CountryList;

import java.util.List;

public class CountryContract {

    interface CountryViewContract{

        void  getCountryData(List<CountryList> countryLists);
        void showProgressDialog();
        void hideProgressDialog();
    }

    interface  CountryPresenterContract{

        void getCountry();

    }
}
