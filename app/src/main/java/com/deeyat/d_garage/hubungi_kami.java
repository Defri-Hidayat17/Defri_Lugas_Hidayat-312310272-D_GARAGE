package com.deeyat.d_garage;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

public class hubungi_kami extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hubungi_kami);

        // Inisialisasi tombol imageButton7 dan event listener navigasi ke akun_scroll
        ImageButton imageButton7 = findViewById(R.id.imageButton7);
        imageButton7.setOnClickListener(v -> {
            // Menavigasi ke halaman akun_scroll
            Intent intent = new Intent(hubungi_kami.this, akun_scroll.class);
            startActivity(intent);
        });
    }
}
