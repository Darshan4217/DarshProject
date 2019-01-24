package com.example.lenovo.myapplication.Country;

import android.support.annotation.NonNull;
import android.widget.Toast;
import com.example.lenovo.myapplication.MainActivity;
import com.example.lenovo.myapplication.Retrofit.CountryList;
import com.example.lenovo.myapplication.Retrofit.CountryRepositoryImplementation;
import io.reactivex.Observer;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
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
    public Observer<List<CountryList>> getCountry() {

         countryRepositoryImplementation.getCountryList().
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<CountryList>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<CountryList> countryLists) {
                        countryViewContract.hideProgressDialog();
                        countryViewContract.getCountryData(countryLists);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

        return null;
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
