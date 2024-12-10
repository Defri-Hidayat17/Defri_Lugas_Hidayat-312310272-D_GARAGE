package com.deeyat.d_garage;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class pengaturan_akun extends AppCompatActivity {

    private boolean isTrackOn = false;  // Menyimpan status switch pertama
    private boolean isTrack2On = false; // Menyimpan status switch kedua
    private boolean isTrack3On = false; // Menyimpan status switch ketiga
    private boolean isZoomedIn = false; // Menyimpan status apakah zoom-in sudah diterapkan
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
        isTrack3On = sharedPreferences.getBoolean("track3Status", false);

        // Inisialisasi ImageButton untuk navigasi
        ImageButton imageButton9 = findViewById(R.id.imageButton9);

        // Menambahkan event listener untuk ImageButton (Navigasi ke Akun)
        imageButton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent untuk berpindah ke halaman akun
                Intent intent = new Intent(pengaturan_akun.this, akun_scroll.class);
                startActivity(intent);
            }
        });

        // Di dalam onCreate()
        Button button5 = findViewById(R.id.button5);

        // Set listener untuk button5
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent untuk berpindah ke activity lupa_password
                Intent intent = new Intent(pengaturan_akun.this, ubah_password.class);
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

        // Elemen yang akan diberikan animasi zoom in
        final ImageView imageView20 = findViewById(R.id.imageView20);
        final ImageView imageView22 = findViewById(R.id.imageView22);
        final ImageView imageView25 = findViewById(R.id.imageView25);
        final ImageView imageView26 = findViewById(R.id.imageView26);
        final TextView textView24 = findViewById(R.id.textView24);
        final ImageView imageView30 = findViewById(R.id.imageView30);


        // Tombol pemicu animasi zoom in
        final ImageView imageView23 = findViewById(R.id.imageView23);

        // Tombol untuk kembali (zoom out)
        final ImageView imageViewBack = findViewById(R.id.imageView26); // Tombol kembali

        // Tambahkan event listener untuk animasi zoom in
        imageView23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isZoomedIn) {
                    setVisibleWithAnimation(imageView20);
                    setVisibleWithAnimation(imageView22);
                    setVisibleWithAnimation(imageView25);
                    setVisibleWithAnimation(imageView26);
                    setVisibleWithAnimation(textView24);
                    setVisibleWithAnimation(imageView30);
                    isZoomedIn = true; // Menandakan elemen sudah di-zoom in
                }
            }
        });

        // Event listener untuk tombol kembali (zoom out)
        imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isZoomedIn) {
                    setGoneWithAnimation(imageView20);
                    setGoneWithAnimation(imageView22);
                    setGoneWithAnimation(imageView25);
                    setGoneWithAnimation(imageView26);
                    setGoneWithAnimation(textView24);
                    setGoneWithAnimation(imageView30);
                    isZoomedIn = false; // Menandakan elemen sudah disembunyikan
                }
            }
        });

        // Menambahkan event listener untuk imageView25 (navigasi ke hapus_akun_berhasil)
        imageView25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent untuk berpindah ke activity hapus_akun_berhasil setelah animasi zoom-in selesai
                Intent intent = new Intent(pengaturan_akun.this, hapus_akun_berhasil.class);
                startActivity(intent);
            }
        });

        // Atur gambar dan posisi awal switch pertama
        if (isTrackOn) {
            trackImageView.setImageResource(R.drawable.track_on_blue);
            thumbImageView.setImageResource(R.drawable.thumb_on);
            thumbImageView.setTranslationX(63f);
        } else {
            trackImageView.setImageResource(R.drawable.track_off);
            thumbImageView.setImageResource(R.drawable.thumb_off);
            thumbImageView.setTranslationX(0f);
        }

        // Atur gambar dan posisi awal switch kedua
        if (isTrack2On) {
            trackImageView2.setImageResource(R.drawable.track_on_blue);
            thumbImageView2.setImageResource(R.drawable.thumb_on);
            thumbImageView2.setTranslationX(63f);
        } else {
            trackImageView2.setImageResource(R.drawable.track_off);
            thumbImageView2.setImageResource(R.drawable.thumb_off);
            thumbImageView2.setTranslationX(0f);
        }

        // Atur gambar dan posisi awal switch ketiga
        if (isTrack3On) {
            trackImageView3.setImageResource(R.drawable.track_on_blue);
            thumbImageView3.setImageResource(R.drawable.thumb_on);
            thumbImageView3.setTranslationX(63f);
        } else {
            trackImageView3.setImageResource(R.drawable.track_off);
            thumbImageView3.setImageResource(R.drawable.thumb_off);
            thumbImageView3.setTranslationX(0f);
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
                    trackImageView.setImageResource(R.drawable.track_on_blue);  // Ganti gambar track ke ON
                    thumbImageView.setImageResource(R.drawable.thumb_on);
                    thumbImageView.animate().translationX(63f).setDuration(200);  // Geser thumb ke kanan
                } else {
                    trackImageView.setImageResource(R.drawable.track_off); // Ganti gambar track ke OFF
                    thumbImageView.setImageResource(R.drawable.thumb_off);
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
                    trackImageView2.setImageResource(R.drawable.track_on_blue);  // Ganti gambar track ke ON
                    thumbImageView2.setImageResource(R.drawable.thumb_on);
                    thumbImageView2.animate().translationX(63f).setDuration(200);  // Geser thumb ke kanan
                } else {
                    trackImageView2.setImageResource(R.drawable.track_off); // Ganti gambar track ke OFF
                    thumbImageView2.setImageResource(R.drawable.thumb_off);
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
                    trackImageView3.setImageResource(R.drawable.track_on_blue);  // Ganti gambar track ke ON
                    thumbImageView3.setImageResource(R.drawable.thumb_on);
                    thumbImageView3.animate().translationX(63f).setDuration(200);  // Geser thumb ke kanan
                } else {
                    trackImageView3.setImageResource(R.drawable.track_off); // Ganti gambar track ke OFF
                    thumbImageView3.setImageResource(R.drawable.thumb_off);
                    thumbImageView3.animate().translationX(0f).setDuration(200);  // Geser thumb ke kiri
                }
            }
        });
    }

    // Metode untuk menampilkan elemen dengan animasi zoom in
    private void setVisibleWithAnimation(View view) {
        ScaleAnimation zoomIn = new ScaleAnimation(
                0.0f, 1.0f,  // Scale X (dari 0 ke 1)
                0.0f, 1.0f,  // Scale Y (dari 0 ke 1)
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f); // Pusat skala
        zoomIn.setDuration(300);  // Durasi animasi 300ms
        view.setVisibility(View.VISIBLE);
        view.startAnimation(zoomIn);  // Memulai animasi zoom in
    }

    // Metode untuk menyembunyikan elemen dengan animasi zoom out
    private void setGoneWithAnimation(View view) {
        ScaleAnimation zoomOut = new ScaleAnimation(
                1.0f, 0.0f,  // Scale X (dari 1 ke 0)
                1.0f, 0.0f,  // Scale Y (dari 1 ke 0)
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f); // Pusat skala
        zoomOut.setDuration(300);  // Durasi animasi 300ms
        view.startAnimation(zoomOut);  // Memulai animasi zoom out
        view.setVisibility(View.GONE);  // Setelah animasi selesai, sembunyikan elemen
    }
}
