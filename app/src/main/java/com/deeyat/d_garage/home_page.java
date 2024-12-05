package com.deeyat.d_garage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class home_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        // Inisialisasi tombol
        ImageButton imageButton11 = findViewById(R.id.imageButton11);

        // Tambahkan event listener untuk navigasi
        imageButton11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home_page.this, notifikasi_page.class);
                startActivity(intent);
            }
        });

        // Inisialisasi TextView textView18
        ImageButton imageButton24 = findViewById(R.id.imageButton24);

        // Tambahkan event listener untuk navigasi ke aktifitas_2
        imageButton24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home_page.this, aktifitas_1.class);
                startActivity(intent);
            }
        });

        // Inisialisasi Imagebutton18
        ImageButton imageButton18 = findViewById(R.id.imageButton18);
        imageButton18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(home_page.this, kendaraan_saya.class);
                startActivity(intent);
            }
        });

        // Inisialisasi Imagebutton14
        ImageButton imageButton14 = findViewById(R.id.imageButton14);
        imageButton14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(home_page.this, lokasi_bengkel.class);
                startActivity(intent);
            }
        });

        // Inisialisasi TextView textView18
        ImageButton imageButton23 = findViewById(R.id.imageButton23);

        // Tambahkan event listener untuk navigasi ke aktifitas_2
        imageButton23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home_page.this, akun.class);
                startActivity(intent);
            }
        });
    }
}
