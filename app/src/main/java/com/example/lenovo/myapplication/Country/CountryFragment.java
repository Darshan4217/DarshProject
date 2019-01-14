package com.example.lenovo.myapplication.Country;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.lenovo.myapplication.R;
import com.example.lenovo.myapplication.base.BackButtonSupportFragment;
import com.example.lenovo.myapplication.base.BaseFragment;

public class CountryFragment extends BaseFragment implements BackButtonSupportFragment {

    private Toast toast;
    private boolean consumingBackPress = true;

    public static CountryFragment newInstance() {
        return new CountryFragment();
    }

    public CountryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_country_list, container, false);

        Button btnDetail = view.findViewById(R.id.btnDetail);
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
            toast = Toast.makeText(getActivity(), "Press back once more to quit the application", Toast.LENGTH_LONG);
            toast.show();
            consumingBackPress = false;
            return true; //consumed
        }
        toast.cancel();
        return false; //delegated
    }
}
