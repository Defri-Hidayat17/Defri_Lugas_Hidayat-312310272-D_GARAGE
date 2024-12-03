package com.deeyat.d_garage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.support.v7.app.AppCompatActivity;

public class verifikasi_wa_sms extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verifikasi_wa_sms);

        // Deklarasi dan inisialisasi tombol back (imageButton7)
        ImageButton imageButton7 = findViewById(R.id.imageButton7);

        // Set OnClickListener untuk tombol back (imageButton7)
        imageButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent untuk navigasi ke halaman daftar_akun_page
                Intent intent = new Intent(verifikasi_wa_sms.this, daftar_akun_page.class);
                startActivity(intent);
                // Optional: Menyelesaikan aktivitas saat ini
                finish(); // Menghindari pengguna kembali ke halaman verifikasi_wa_sms
            }
        });

        // Inisialisasi tombol imageButton8 dan imageButton9
        ImageButton imageButton8 = findViewById(R.id.imageButton8);  // WA
        ImageButton imageButton9 = findViewById(R.id.imageButton9);  // SMS

        // Set OnClickListener untuk imageButton8 (WA)
        imageButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent untuk membuka halaman kode_otp
                Intent intent = new Intent(verifikasi_wa_sms.this, kode_otp_new.class);
                intent.putExtra("verifikasi_metode", "WhatsApp"); // Mengirimkan data WhatsApp
                startActivity(intent);
            }
        });

        // Set OnClickListener untuk imageButton9 (SMS)
        imageButton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent untuk membuka halaman kode_otp
                Intent intent = new Intent(verifikasi_wa_sms.this, kode_otp_new.class);
                intent.putExtra("verifikasi_metode", "SMS"); // Mengirimkan data SMS
                startActivity(intent);
            }
        });
    }
}
