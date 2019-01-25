package com.example.lenovo.myapplication.Country;

import com.example.lenovo.myapplication.Retrofit.CountryList;
import io.reactivex.Observer;

import java.util.List;

class CountryContract {

    interface CountryViewContract{

        void  getCountryData(List<CountryList> countryLists);
        void showProgressDialog();
        void hideProgressDialog();
    }

    interface  CountryPresenterContract{

       // void getCountry();
        void getCountry();

    }
}
