package com.deeyat.d_garage;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class pengaturan_akun extends AppCompatActivity {

    private boolean isTrackOn = false;  // Menyimpan status switch pertama
    private boolean isTrack2On = false; // Menyimpan status switch kedua
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengaturan_akun);  // Layout yang sesuai

        // Inisialisasi SharedPreferences
        sharedPreferences = getSharedPreferences("SwitchStatus", MODE_PRIVATE);

        // Memuat status terakhir dari SharedPreferences
        isTrackOn = sharedPreferences.getBoolean("track1Status", false);
        isTrack2On = sharedPreferences.getBoolean("track2Status", false);

        // Inisialisasi ImageButton untuk navigasi
        ImageButton imageButton9 = findViewById(R.id.imageButton9);

        // Menambahkan event listener untuk ImageButton (Navigasi ke Akun)
        imageButton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent untuk berpindah ke halaman akun
                Intent intent = new Intent(pengaturan_akun.this, akun.class);
                startActivity(intent);
            }
        });

        // Inisialisasi ImageView untuk track dan thumb pertama
        final ImageView trackImageView = findViewById(R.id.imageView13);
        final ImageView thumbImageView = findViewById(R.id.imageView14);

        // Inisialisasi ImageView untuk track dan thumb kedua
        final ImageView trackImageView2 = findViewById(R.id.imageView15);
        final ImageView thumbImageView2 = findViewById(R.id.imageView21);

        // Atur gambar dan posisi awal switch pertama
        if (isTrackOn) {
            trackImageView.setImageResource(R.drawable.track_on);
            thumbImageView.setTranslationX(83f);
        } else {
            trackImageView.setImageResource(R.drawable.track_off);
            thumbImageView.setTranslationX(0f);
        }

        // Atur gambar dan posisi awal switch kedua
        if (isTrack2On) {
            trackImageView2.setImageResource(R.drawable.track_on);
            thumbImageView2.setTranslationX(83f);
        } else {
            trackImageView2.setImageResource(R.drawable.track_off);
            thumbImageView2.setTranslationX(0f);
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
                    thumbImageView.animate().translationX(83f).setDuration(200);  // Geser thumb ke kanan
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
                    thumbImageView2.animate().translationX(83f).setDuration(200);  // Geser thumb ke kanan
                } else {
                    trackImageView2.setImageResource(R.drawable.track_off); // Ganti gambar track ke OFF
                    thumbImageView2.animate().translationX(0f).setDuration(200);  // Geser thumb ke kiri
                }
            }
        });
    }
}
