package com.deeyat.d_garage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;

public class edit_profil_berhasil_diubah extends AppCompatActivity {

    // Deklarasi komponen UI
    private ImageButton imageButton6;  // Tombol untuk navigasi ke biodata_page
    private ImageView imageView18;  // Gambar yang akan dianimasikan

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profil_berhasil_diubah);

        // Inisialisasi komponen
        ImageButton imageButton6 = findViewById(R.id.imageButton6);
        ImageView imageView18 = findViewById(R.id.imageView18);

        // Set OnClickListener untuk tombol navigasi ke log in page (imageButton6)
        imageButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigasi ke halaman biodata_page
                Intent intent = new Intent(edit_profil_berhasil_diubah.this, akun_scroll.class);  // Ganti dengan biodata_page
                startActivity(intent);
                finish();  // Menutup activity ini setelah navigasi
            }
        });

        // Gunakan Handler untuk menunggu 2 detik sebelum menampilkan ImageView
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Set ImageView menjadi visible
                imageView18.setVisibility(View.VISIBLE);

                // Load animasi zoom in
                Animation zoomIn = AnimationUtils.loadAnimation(edit_profil_berhasil_diubah.this, R.anim.zoom_in);
                // Terapkan animasi pada ImageView
                imageView18.startAnimation(zoomIn);
            }
        }, 2000); // Delay 2 detik (2000 ms)
    }
}
