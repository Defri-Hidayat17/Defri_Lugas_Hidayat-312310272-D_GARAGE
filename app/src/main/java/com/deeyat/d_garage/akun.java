package com.deeyat.d_garage;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class akun extends AppCompatActivity {

    private boolean isZoomedIn = false; // Menyimpan status apakah elemen sudah di-zoom in

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


        EditText editTextVouchersaya = findViewById(R.id.inputVouchersaya);
        editTextVouchersaya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(akun.this, voucher_saya.class);
                startActivity(intent);
                finish();
            }
        });

        EditText editTextinputtentangkami = findViewById(R.id.inputtentangkami);
        editTextinputtentangkami.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new  Intent(akun.this, tentang_kami.class);
                startActivity(intent);
                finish();
            }
        });

        EditText editTextinputmobilsaya = findViewById(R.id.inputmobilsaya);
        editTextinputmobilsaya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new  Intent(akun.this, mobil_saya.class);
                startActivity(intent);
                finish();
            }
        });

        // Inisialisasi EditText dan ImageView yang lainnya
        final EditText inputLogout = findViewById(R.id.inputlogout); // Menggunakan inputlogout
        final ImageView imageView30 = findViewById(R.id.imageView30);
        final ImageView imageView27 = findViewById(R.id.imageView27);
        final ImageView imageView28 = findViewById(R.id.imageView28);
        final TextView textView24 = findViewById(R.id.textView24); // Ganti imageView24 menjadi textView24
        final ImageView imageView31 = findViewById(R.id.imageView31); // Menambahkan imageView31
        final ImageView imageView33 = findViewById(R.id.imageView33);

        // Set listener untuk inputlogout (untuk menampilkan zoom-in pada elemen)
        inputLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isZoomedIn) {
                    // Menyembunyikan semua elemen terlebih dahulu dengan visibilitas GONE
                    setGone(imageView30);
                    setGone(imageView27);
                    setGone(imageView28);
                    setGone(textView24); // Menyembunyikan textView24 juga
                    setGone(imageView31);
                    setGone(imageView33);

                    // Menampilkan elemen dengan animasi zoom-in
                    setVisibleWithAnimation(imageView30);
                    setVisibleWithAnimation(imageView27);
                    setVisibleWithAnimation(imageView28);
                    setVisibleWithAnimation(textView24); // Menampilkan textView24 juga
                    setVisibleWithAnimation(imageView31);
                    setVisibleWithAnimation(imageView33);
                    isZoomedIn = true; // Menandakan elemen sudah di-zoom in
                }
            }
        });

        // Set listener untuk imageView33 (untuk zoom-out dan menyembunyikan elemen)
        imageView33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isZoomedIn) {
                    // Menyembunyikan elemen dengan animasi zoom-out
                    setGoneWithAnimation(imageView30);
                    setGoneWithAnimation(imageView27);
                    setGoneWithAnimation(imageView28);
                    setGoneWithAnimation(textView24); // Menyembunyikan textView24
                    setGoneWithAnimation(imageView31);
                    setGoneWithAnimation(imageView33);

                    isZoomedIn = false; // Menandakan elemen sudah disembunyikan
                }
            }
        });

        // Set listener untuk imageView31 untuk navigasi ke log_in_page
        imageView31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigasi ke log_in_page
                Intent intent = new Intent(akun.this, log_in_page.class);
                startActivity(intent);
                finish(); // Opsional: menutup halaman saat ini
            }
        });
    }

    // Metode untuk menampilkan elemen dengan animasi zoom-in
    private void setVisibleWithAnimation(View view) {
        ScaleAnimation zoomIn = new ScaleAnimation(
                0.0f, 1.0f,  // Scale X (dari 0 ke 1)
                0.0f, 1.0f,  // Scale Y (dari 0 ke 1)
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f); // Pusat skala
        zoomIn.setDuration(300);  // Durasi animasi 300ms
        view.setVisibility(View.VISIBLE);
        view.startAnimation(zoomIn);  // Memulai animasi zoom-in
    }

    // Metode untuk menyembunyikan elemen dengan animasi zoom-out
    private void setGoneWithAnimation(View view) {
        ScaleAnimation zoomOut = new ScaleAnimation(
                1.0f, 0.0f,  // Scale X (dari 1 ke 0)
                1.0f, 0.0f,  // Scale Y (dari 1 ke 0)
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f); // Pusat skala
        zoomOut.setDuration(300);  // Durasi animasi 300ms
        view.startAnimation(zoomOut);  // Memulai animasi zoom-out
        view.setVisibility(View.GONE);  // Setelah animasi selesai, sembunyikan elemen
    }

    // Metode untuk menyembunyikan elemen dengan visibilitas GONE tanpa animasi
    private void setGone(View view) {
        view.setVisibility(View.GONE);
    }
}
