package com.deeyat.d_garage;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class aktifitas2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aktifitas2);

        // Inisialisasi tombol imageButton7
        ImageButton imageButton7 = findViewById(R.id.imageButton7);

        // Tambahkan event listener untuk navigasi ke home_page
        imageButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(aktifitas2.this, home_page.class);
                startActivity(intent);
                finish(); // Opsional: menutup halaman saat ini
            }
        });

        // Inisialisasi TextView textView18
        TextView textView17 = findViewById(R.id.textView17);

        // Tambahkan event listener untuk navigasi ke aktifitas_1
        textView17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(aktifitas2.this, aktifitas1.class);
                startActivity(intent);
            }
        });

        ImageView imageView98 =findViewById(R.id.imageView98);
        imageView98.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(aktifitas2.this, home_page.class);
                startActivity(intent);
            }
        });

        ImageView imageView99 =findViewById(R.id.imageView99);
        imageView99.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(aktifitas2.this, akun_scroll.class);
                startActivity(intent);
            }
        });
    }
}