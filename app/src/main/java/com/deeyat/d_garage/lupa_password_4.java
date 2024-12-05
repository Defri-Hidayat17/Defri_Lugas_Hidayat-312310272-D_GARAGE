package com.deeyat.d_garage;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;

public class lupa_password_4 extends AppCompatActivity {

    ImageButton imageButton1;
    ImageButton imageButton6;
    ImageView imageView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lupa_password4);  // Pastikan layout sesuai

        // Inisialisasi komponen ImageButton
        imageButton1 = findViewById(R.id.imageButton1);
        imageButton6 = findViewById(R.id.imageButton6);
        imageView2 = findViewById(R.id.imageView2);

        // Set OnClickListener untuk tombol back (imageButton1)
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Menavigasi kembali ke halaman sebelumnya (lupa_password_3)
                onBackPressed();  // Menggunakan metode onBackPressed() untuk kembali ke activity sebelumnya
            }
        });

        // Set OnClickListener untuk tombol imageButton6 (navigasi ke log_in_page)
        imageButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Menavigasi ke halaman log_in_page
                Intent intent = new Intent(lupa_password_4.this, log_in_page.class);  // Pastikan nama Activity sesuai
                startActivity(intent);
                finish();  // Optional: Jika ingin menutup current Activity setelah navigasi
            }
        });

        // Gunakan Handler untuk menunggu 2 detik sebelum menampilkan ImageView
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Set ImageView menjadi visible
                imageView2.setVisibility(View.VISIBLE);

                // Load animasi zoom in
                Animation zoomIn = AnimationUtils.loadAnimation(lupa_password_4.this, R.anim.zoom_in);
                // Terapkan animasi pada ImageView
                imageView2.startAnimation(zoomIn);
            }
        }, 2000); // Delay 2 detik (2000 ms)
    }
}
