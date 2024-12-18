package com.deeyat.d_garage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class booking_servis_berhasil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_servis_berhasil);


        // Cari tombol dengan ID buttonok
        Button buttonOk = findViewById(R.id.buttonok);

        // Set listener untuk navigasi
        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigasi ke aktifitas_1
                Intent intent = new Intent(booking_servis_berhasil.this, aktifitas1.class);
                startActivity(intent);
            }
        });

    }
}