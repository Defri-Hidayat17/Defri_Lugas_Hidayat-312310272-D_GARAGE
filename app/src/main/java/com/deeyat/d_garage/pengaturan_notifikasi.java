package com.deeyat.d_garage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class pengaturan_notifikasi extends AppCompatActivity {

    private boolean isTrackOn = false;  // Menyimpan status switch pertama
    private boolean isTrack2On = false; // Menyimpan status switch kedua
    private boolean isTrack3On = false; // Menyimpan status switch ketiga
    private boolean isTrack4On = false; // Menyimpan status switch keempat (tambahan)
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengaturan_notifikasi);

        // Inisialisasi SharedPreferences
        sharedPreferences = getSharedPreferences("NotificationSettings", MODE_PRIVATE); // Pastikan SharedPreferences menggunakan key yang berbeda

        // Memuat status terakhir dari SharedPreferences
        isTrackOn = sharedPreferences.getBoolean("track1Status", false);
        isTrack2On = sharedPreferences.getBoolean("track2Status", false);
        isTrack3On = sharedPreferences.getBoolean("track3Status", false);
        isTrack4On = sharedPreferences.getBoolean("track4Status", false); // Memuat status switch ke-4

        // Inisialisasi ImageButton untuk navigasi
        ImageButton imageButton9 = findViewById(R.id.imageButton9);

        // Menambahkan event listener untuk ImageButton (Navigasi ke Akun)
        imageButton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent untuk berpindah ke halaman akun
                Intent intent = new Intent(pengaturan_notifikasi.this, akun_scroll.class);
                startActivity(intent);
            }
        });

        // Inisialisasi ImageView untuk track dan thumb pertama
        final ImageView trackImageView = findViewById(R.id.imageView13);
        final ImageView thumbImageView = findViewById(R.id.imageView36);

        // Inisialisasi ImageView untuk track dan thumb kedua
        final ImageView trackImageView2 = findViewById(R.id.imageView15);
        final ImageView thumbImageView2 = findViewById(R.id.imageView24);

        // Inisialisasi ImageView untuk track dan thumb ketiga
        final ImageView trackImageView3 = findViewById(R.id.imageView16);
        final ImageView thumbImageView3 = findViewById(R.id.imageView35);

        // Inisialisasi ImageView untuk track dan thumb keempat (tambahan)
        final ImageView trackImageView4 = findViewById(R.id.imageView17);  // Ganti ID sesuai dengan ID gambar ke-4 Anda
        final ImageView thumbImageView4 = findViewById(R.id.imageView37);  // Ganti ID sesuai dengan ID thumb ke-4 Anda

        // Atur gambar dan posisi awal switch pertama
        if (isTrackOn) {
            trackImageView.setImageResource(R.drawable.track_on);
            thumbImageView.setTranslationX(72f);
        } else {
            trackImageView.setImageResource(R.drawable.track_off);
            thumbImageView.setTranslationX(0f);
        }

        // Atur gambar dan posisi awal switch kedua
        if (isTrack2On) {
            trackImageView2.setImageResource(R.drawable.track_on);
            thumbImageView2.setTranslationX(72f);
        } else {
            trackImageView2.setImageResource(R.drawable.track_off);
            thumbImageView2.setTranslationX(0f);
        }

        // Atur gambar dan posisi awal switch ketiga
        if (isTrack3On) {
            trackImageView3.setImageResource(R.drawable.track_on);
            thumbImageView3.setTranslationX(72f);
        } else {
            trackImageView3.setImageResource(R.drawable.track_off);
            thumbImageView3.setTranslationX(0f);
        }

        // Atur gambar dan posisi awal switch keempat
        if (isTrack4On) {
            trackImageView4.setImageResource(R.drawable.track_on);  // Ganti gambar track ke-4 ke ON
            thumbImageView4.setTranslationX(72f);  // Geser thumb ke kanan
        } else {
            trackImageView4.setImageResource(R.drawable.track_off); // Ganti gambar track ke-4 ke OFF
            thumbImageView4.setTranslationX(0f);  // Geser thumb ke kiri
        }

        // Menambahkan event listener untuk toggle switch track pertama (track on/off)
        trackImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toggle status track pertama
                isTrackOn = !isTrackOn;

                // Simpan status ke SharedPreferences
                sharedPreferences.edit().putBoolean("track1Status", isTrackOn).apply();

                // Ubah gambar track dan geser thumb sesuai dengan status
                if (isTrackOn) {
                    trackImageView.setImageResource(R.drawable.track_on);  // Ganti gambar track ke ON
                    thumbImageView.animate().translationX(72f).setDuration(200);  // Geser thumb ke kanan
                } else {
                    trackImageView.setImageResource(R.drawable.track_off); // Ganti gambar track ke OFF
                    thumbImageView.animate().translationX(0f).setDuration(200);  // Geser thumb ke kiri
                }
            }
        });

        // Menambahkan event listener untuk toggle switch track kedua (track on/off)
        trackImageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toggle status track kedua
                isTrack2On = !isTrack2On;

                // Simpan status ke SharedPreferences
                sharedPreferences.edit().putBoolean("track2Status", isTrack2On).apply();

                // Ubah gambar track dan geser thumb sesuai dengan status
                if (isTrack2On) {
                    trackImageView2.setImageResource(R.drawable.track_on);  // Ganti gambar track ke ON
                    thumbImageView2.animate().translationX(72f).setDuration(200);  // Geser thumb ke kanan
                } else {
                    trackImageView2.setImageResource(R.drawable.track_off); // Ganti gambar track ke OFF
                    thumbImageView2.animate().translationX(0f).setDuration(200);  // Geser thumb ke kiri
                }
            }
        });

        // Menambahkan event listener untuk toggle switch track ketiga (track on/off)
        trackImageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toggle status track ketiga
                isTrack3On = !isTrack3On;

                // Simpan status ke SharedPreferences
                sharedPreferences.edit().putBoolean("track3Status", isTrack3On).apply();

                // Ubah gambar track dan geser thumb sesuai dengan status
                if (isTrack3On) {
                    trackImageView3.setImageResource(R.drawable.track_on);  // Ganti gambar track ke ON
                    thumbImageView3.animate().translationX(72f).setDuration(200);  // Geser thumb ke kanan
                } else {
                    trackImageView3.setImageResource(R.drawable.track_off); // Ganti gambar track ke OFF
                    thumbImageView3.animate().translationX(0f).setDuration(200);  // Geser thumb ke kiri
                }
            }
        });

        // Menambahkan event listener untuk toggle switch track keempat (track on/off)
        trackImageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toggle status track keempat
                isTrack4On = !isTrack4On;

                // Simpan status ke SharedPreferences
                sharedPreferences.edit().putBoolean("track4Status", isTrack4On).apply();

                // Ubah gambar track dan geser thumb sesuai dengan status
                if (isTrack4On) {
                    trackImageView4.setImageResource(R.drawable.track_on);  // Ganti gambar track ke ON
                    thumbImageView4.animate().translationX(72f).setDuration(200);  // Geser thumb ke kanan
                } else {
                    trackImageView4.setImageResource(R.drawable.track_off); // Ganti gambar track ke OFF
                    thumbImageView4.animate().translationX(0f).setDuration(200);  // Geser thumb ke kiri
                }
            }
        });
    }
}
