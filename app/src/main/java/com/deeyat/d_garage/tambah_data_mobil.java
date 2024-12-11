package com.deeyat.d_garage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class tambah_data_mobil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_data_mobil);

        // Elemen yang akan diberikan animasi zoom in
        final ImageView imageView70 = findViewById(R.id.imageView70);
        final ImageView imageView71 = findViewById(R.id.imageView71);
        final TextView textView65 = findViewById(R.id.textView65);
        final ImageButton imageButton72 = findViewById(R.id.imageButton72);

        final Button button4 = findViewById(R.id.button4);

        // Animasi zoom in
        Animation zoomIn = AnimationUtils.loadAnimation(this, R.anim.zoom_in);

        // Set klik listener untuk tombol
        button4.setOnClickListener(v -> {
            // Mengatur visibility ke visible sebelum animasi dimulai
            imageView70.setVisibility(View.VISIBLE);
            imageView71.setVisibility(View.VISIBLE);
            textView65.setVisibility(View.VISIBLE);
            imageButton72.setVisibility(View.VISIBLE);

            // Jalankan animasi pada view yang diinginkan
            imageView70.startAnimation(zoomIn);
            imageView71.startAnimation(zoomIn);
            textView65.startAnimation(zoomIn);
            imageButton72.startAnimation(zoomIn);
        });

        // Tambahkan klik listener untuk imageView72
        imageButton72.setOnClickListener(v -> {
            Intent intent = new Intent(tambah_data_mobil.this, kendaraan_saya.class);
            startActivity(intent);
        });
    }
}
