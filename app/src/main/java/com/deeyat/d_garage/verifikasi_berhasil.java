package com.deeyat.d_garage;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;

public class verifikasi_berhasil extends AppCompatActivity {

    // Deklarasi komponen UI
    private ImageButton imageButton1;  // Tombol untuk navigasi ke kode_otp
    private ImageButton imageButton6;  // Tombol untuk navigasi ke biodata_page
    private ImageView imageView2;  // Gambar yang akan dianimasikan

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verifikasi_berhasil);  // Pastikan layout sesuai

        // Inisialisasi komponen
        imageButton1 = findViewById(R.id.imageButton1);  // Tombol untuk navigasi ke kode_otp
        imageButton6 = findViewById(R.id.imageButton6);  // Tombol untuk navigasi ke biodata_page
        imageView2 = findViewById(R.id.imageView2);  // Gambar yang dianimasikan

        // Set OnClickListener untuk tombol navigasi ke kode_otp (imageButton1)
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigasi ke halaman kode_otp
                Intent intent = new Intent(verifikasi_berhasil.this, kode_otp_new.class);  // Ganti dengan kode_otp
                startActivity(intent);
                finish();  // Menutup activity ini setelah navigasi
            }
        });

        // Set OnClickListener untuk tombol navigasi ke biodata_page (imageButton6)
        imageButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigasi ke halaman biodata_page
                Intent intent = new Intent(verifikasi_berhasil.this, biodata_page.class);  // Ganti dengan biodata_page
                startActivity(intent);
                finish();  // Menutup activity ini setelah navigasi
            }
        });

        // Gunakan Handler untuk menunggu 2 detik sebelum menampilkan ImageView
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Set ImageView menjadi visible
                imageView2.setVisibility(View.VISIBLE);

                // Load animasi zoom in
                Animation zoomIn = AnimationUtils.loadAnimation(verifikasi_berhasil.this, R.anim.zoom_in);
                // Terapkan animasi pada ImageView
                imageView2.startAnimation(zoomIn);
            }
        }, 2000); // Delay 2 detik (2000 ms)
    }
}
