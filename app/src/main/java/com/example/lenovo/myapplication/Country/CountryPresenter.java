package com.example.lenovo.myapplication.Country;

import com.example.lenovo.myapplication.Retrofit.CountryList;
import com.example.lenovo.myapplication.Retrofit.CountryRepositoryImplementation;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

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
        countryRepositoryImplementation.getCountryList().
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<CountryList>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        countryViewContract.showProgressDialog();
                    }

                    @Override
                    public void onSuccess(List<CountryList> countryLists) {
                        countryViewContract.hideProgressDialog();
                        countryViewContract.getCountryData(countryLists);
                    }

                    @Override
                    public void onError(Throwable e) {
                        countryViewContract.hideProgressDialog();

                    }
                });
    }
    /*@Override
    public void getCountry() {
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
    }*/
}
