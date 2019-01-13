package com.example.lenovo.myapplication.Country;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.myapplication.DashBoardActivity;
import com.example.lenovo.myapplication.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CountryDetailFragment extends Fragment {

    public static final int REQUEST_CODE = 1000;

    View view;

    public CountryDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         view =  inflater.inflate(R.layout.fragment_country_detail, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        updateToolbar();
    }

    public void updateToolbar(){
        ((DashBoardActivity) getActivity()).getSupportActionBar().setTitle("CountryDetails");
        ((DashBoardActivity)getActivity()).showToolbarBackArrow();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Fragment targetFragment = getTargetFragment();
        if (targetFragment != null) {
            targetFragment.onActivityResult(getTargetRequestCode(), 100, null);
        }
    }
}
