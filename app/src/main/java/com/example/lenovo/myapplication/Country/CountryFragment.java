package com.example.lenovo.myapplication.Country;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.FrameLayout;
import com.example.lenovo.myapplication.DashBoardActivity;
import com.example.lenovo.myapplication.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CountryFragment extends Fragment {

    View view;
    Button btnDetail;
    FrameLayout countryListLayout;
    public CountryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_country_list, container, false);
        countryListLayout = view.findViewById(R.id.countryListLayout);


        btnDetail = view.findViewById(R.id.btnDetail);

        btnDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((DashBoardActivity)getActivity()).addFragment(CountryFragment.this, new CountryDetailFragment());
            }
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        updateToolbar();
    }

    public void updateToolbar(){
         ((DashBoardActivity) getActivity()).getSupportActionBar().setTitle("CountryList");
    }
}
