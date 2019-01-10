package com.example.lenovo.myapplication.Country;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import com.example.lenovo.myapplication.DashBoardActivity;
import com.example.lenovo.myapplication.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CountryFragment extends Fragment {

    View view;
    Button btnDetail;
    public CountryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_country_list, container, false);
        updateToolbar();
        btnDetail = view.findViewById(R.id.btnDetail);

        btnDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new CountryDetailFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_layout, fragment, fragment.getClass().getSimpleName()).addToBackStack(null).commit();
            }
        });
        return view;
    }

     public void updateToolbar(){
         ((DashBoardActivity) getActivity()).getSupportActionBar().setTitle("CountryList");
    }
   }
