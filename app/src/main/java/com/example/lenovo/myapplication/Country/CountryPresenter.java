package com.example.lenovo.myapplication.Country;

import android.support.annotation.NonNull;
import android.widget.Toast;
import com.example.lenovo.myapplication.MainActivity;
import com.example.lenovo.myapplication.Retrofit.CountryList;
import com.example.lenovo.myapplication.Retrofit.CountryRepositoryImplementation;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class CountryPresenter implements CountryContract.CountryPresenterContract {

    private CountryContract.CountryViewContract countryViewContract;
    private CountryRepositoryImplementation countryRepositoryImplementation;

    CountryPresenter(CountryFragment countryFragment, CountryRepositoryImplementation countryRepositoryImplementation) {
        this.countryViewContract = countryFragment;
        this.countryRepositoryImplementation = countryRepositoryImplementation;
    }

    @Override
    public void getCountry() {
        /*Create handle for the RetrofitInstance interface*/
        Call<List<CountryList>> call = countryRepositoryImplementation.getCountryList();
        countryViewContract.showProgressDialog();
        call.enqueue(new Callback<List<CountryList>>() {
            @Override
            public void onResponse(@NonNull Call<List<CountryList>> call, @NonNull Response<List<CountryList>> response) {
               // progressDoalog.dismiss();
                countryViewContract.hideProgressDialog();
               countryViewContract.getCountryData(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<List<CountryList>> call, @NonNull Throwable t) {
                countryViewContract.hideProgressDialog();
            }
        });
    }
}
