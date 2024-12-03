package com.deeyat.d_garage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class akun extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_akun);

        // Inisialisasi tombol imageButton7
        ImageButton imageButton7 = findViewById(R.id.imageButton7);

        // Tambahkan event listener untuk navigasi ke home_page
        imageButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(akun.this, home_page.class);
                startActivity(intent);
                finish(); // Opsional: menutup halaman saat ini
            }
        });

        TextView textView12 = findViewById(R.id.textView12);
        textView12.setText(Html.fromHtml("<u>defrilugas46@gmail.com</u>"));


        EditText editTextpengaturanakun = findViewById(R.id.inputpengaturanakun);

        editTextpengaturanakun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(akun.this, pengaturan_akun.class);
                startActivity(intent);
                finish(); // Opsional: menutup halaman saat ini
            }
        });


    }
}