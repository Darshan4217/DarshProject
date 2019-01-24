package com.example.lenovo.myapplication.Country;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.lenovo.myapplication.R;
import com.example.lenovo.myapplication.Retrofit.CountryList;

import java.util.List;

public class CountryListAdapter extends RecyclerView.Adapter<CountryListAdapter.CountryListViewHolder> {

    private List<CountryList> dataList;

    CountryListAdapter(List<CountryList> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public CountryListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.recyclerview_items, viewGroup, false);
        return new CountryListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryListViewHolder countryListViewHolder, int position) {
        countryListViewHolder.txtCountry.setText(dataList.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class CountryListViewHolder extends RecyclerView.ViewHolder {
        final View mView;
        TextView txtCountry;

        CountryListViewHolder(@NonNull View itemView) {
            super(itemView);
            mView = itemView;
            txtCountry = mView.findViewById(R.id.txtCountry);
        }
    }
}
