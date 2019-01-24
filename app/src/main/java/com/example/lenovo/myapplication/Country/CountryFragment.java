package com.example.lenovo.myapplication.Country;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;
import com.example.lenovo.myapplication.R;
import com.example.lenovo.myapplication.Retrofit.CountryApiService;
import com.example.lenovo.myapplication.Retrofit.CountryList;
import com.example.lenovo.myapplication.Retrofit.CountryRepositoryImplementation;
import com.example.lenovo.myapplication.Retrofit.RetrofitClientInstance;
import com.example.lenovo.myapplication.base.BackButtonSupportFragment;
import com.example.lenovo.myapplication.base.BaseFragment;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CountryFragment extends BaseFragment implements BackButtonSupportFragment, CountryContract.CountryViewContract {

    View view;
    Button btnDetail;
    FrameLayout countryListLayout;
    private Toast toast;
    private boolean consumingBackPress = true;
    RecyclerView recycler_view;
    ProgressDialog progressDialog;
    CountryRepositoryImplementation countryRepositoryImplementation;
    CountryPresenter countryPresenter;
    CountryListAdapter countryListAdapter;

    public static CountryFragment newInstance() {
        return new CountryFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_country_list, container, false);
        btnDetail = view.findViewById(R.id.btnDetail);
        recycler_view = view.findViewById(R.id.recycler_view);

        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Loading.....");

        CountryApiService service = RetrofitClientInstance.getRetrofitInstance().create(CountryApiService.class);
        countryRepositoryImplementation = new CountryRepositoryImplementation(service);
        countryPresenter = new CountryPresenter(CountryFragment.this, countryRepositoryImplementation);

        countryPresenter.getCountry();


        btnDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add(CountryDetailFragment.newInstance());
            }
        });

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    protected String getTitle() {
        return "Country List";
    }

    @Override
    public boolean onBackPressed() {
        //return true when handled by yourself
        if (consumingBackPress) {
            //This is actually a terrible thing to do and totally against the guidelines
            // Ideally you shouldn't handle the backpress ever, so really think twice about what
            // you are doing and whether you are getting hacky
            toast = Toast.makeText(getActivity(), "Press back once more to quit the application", Toast.LENGTH_LONG);
            toast.show();
            consumingBackPress = false;
            return true; //consumed
        }
        toast.cancel();
        return false; //delegated

    }

    @Override
    public void getCountryData(List<CountryList> countryLists) {
        countryListAdapter = new CountryListAdapter(countryLists);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recycler_view.setLayoutManager(layoutManager);
        recycler_view.setAdapter(countryListAdapter);


    }

    @Override
    public void showProgressDialog() {
        progressDialog.show();

    }

    @Override
    public void hideProgressDialog() {
        progressDialog.hide();

    }
}
