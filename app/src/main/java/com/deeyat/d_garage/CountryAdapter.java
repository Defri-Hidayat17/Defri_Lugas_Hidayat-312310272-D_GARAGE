package com.deeyat.d_garage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CountryAdapter extends BaseAdapter {
    private Context context;
    private String[] countryNames;  // Gunakan array untuk nama negara
    private List<Integer> countryFlags;  // List untuk bendera negara

    public CountryAdapter(Context context, String[] countryNames, List<Integer> countryFlags) {
        this.context = context;
        this.countryNames = countryNames;
        this.countryFlags = countryFlags;
    }

    @Override
    public int getCount() {
        return countryNames.length;  // Mengembalikan panjang array negara
    }

    @Override
    public Object getItem(int position) {
        return countryNames[position];  // Mengembalikan negara berdasarkan posisi
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(android.R.layout.simple_spinner_item, parent, false);
        }

        // Inisialisasi komponen tampilan
        TextView textView = convertView.findViewById(android.R.id.text1);
        ImageView imageView = new ImageView(context);

        // Set gambar bendera negara dan nama negara
        imageView.setImageResource(countryFlags.get(position));
        textView.setText(countryNames[position]);

        return convertView;
    }
}
