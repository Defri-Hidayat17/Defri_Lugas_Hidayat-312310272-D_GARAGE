package com.deeyat.d_garage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class lupa_password extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lupa_password);

        // Deklarasi untuk ImageView dan ImageButton
        ImageView imageView;
        ImageButton imageButton3;

        // Menghubungkan ImageView dengan ID di XML
        imageView = findViewById(R.id.imageButton3);

        // Set OnClickListener untuk ImageView
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Mengarahkan kembali ke halaman log_in_page
                Intent intent = new Intent(lupa_password.this, log_in_page.class); // Ganti dengan halaman yang sesuai
                startActivity(intent);
            }
        });

        // Inisialisasi tombol btn_masuk
        View btnMasuk = findViewById(R.id.btn_masuk);

        // Set OnClickListener untuk tombol btn_masuk
        btnMasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent untuk membuka activity lupa_password_2
                Intent intent = new Intent(lupa_password.this, lupa_password_2.class);
                startActivity(intent);
            }
        });

    }
}