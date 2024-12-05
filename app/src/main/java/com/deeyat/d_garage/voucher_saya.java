package com.deeyat.d_garage;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class voucher_saya extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voucher_saya);

        // Inisialisasi tombol imageButton7
        ImageButton imageButton7 = findViewById(R.id.imageButton7);

        // Tambahkan event listener untuk navigasi ke home_page
        imageButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(voucher_saya.this, akun.class);
                startActivity(intent);
                finish(); // Opsional: menutup halaman saat ini
            }
        });
    }
}