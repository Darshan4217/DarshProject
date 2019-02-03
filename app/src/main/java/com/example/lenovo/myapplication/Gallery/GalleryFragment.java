package com.example.lenovo.myapplication.Gallery;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.*;
import com.example.lenovo.myapplication.R;
import com.example.lenovo.myapplication.base.BaseFragment;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class GalleryFragment extends BaseFragment {

    View view;
    RadioGroup radioGroup;
    RadioButton radioDarshan, radioSwanand, radioPrabhat;
    CheckBox checkBoxDarshan,checkBoxSwanand, checkBoxPrabhat;
    private ArrayList<String> options = new ArrayList<>();

    public static GalleryFragment newInstance() {
        return new GalleryFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_gallery, container, false);
        radioGroup = view.findViewById(R.id.radioGroup);
        radioDarshan = view.findViewById(R.id.radioDarshan);
        radioSwanand = view.findViewById(R.id.radioSwanand);
        radioPrabhat = view.findViewById(R.id.radioPabhat);

        checkBoxDarshan = view.findViewById(R.id.checkBoxDarshan);
        checkBoxSwanand = view.findViewById(R.id.checkBoxSwanand);
        checkBoxPrabhat = view.findViewById(R.id.checkBoxPrabhat);

        checkBoxDarshan.setOnCheckedChangeListener(onCheckedChangeListener);
        checkBoxSwanand.setOnCheckedChangeListener(onCheckedChangeListener);
        checkBoxPrabhat.setOnCheckedChangeListener(onCheckedChangeListener);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = group.findViewById(checkedId);

                Toast.makeText(getActivity(),radioButton.getText()+"ID:"+radioButton.getId(),Toast.LENGTH_LONG).show();
            }
        });

        return view;

    }

    private CheckBox.OnCheckedChangeListener onCheckedChangeListener
            = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            switch (buttonView.getId()) {
                case R.id.checkBoxDarshan:
                    if (isChecked) options.add("Darshan");
                    else options.remove("Darshan");
                    break;
                case R.id.checkBoxSwanand:
                    if (isChecked) options.add("Swanand");
                    else options.remove("Swanand");
                    break;
                case R.id.checkBoxPrabhat:
                    if (isChecked) options.add("Prabhat");
                    else options.remove("Prabhat");
                    break;

            }
            Toast.makeText(getActivity(),options.toString(),Toast.LENGTH_LONG).show();
        }
    };


    @Override
    protected String getTitle() {
        return "Gallery";
    }
}
