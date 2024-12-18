package com.deeyat.d_garage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.StyleSpan;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

public class home_servis_berhasil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_servis_berhasil);

        // Cari tombol dengan ID buttonok
        Button buttonOk = findViewById(R.id.buttonok);

        // Set listener untuk navigasi
        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigasi ke aktifitas_1
                Intent intent = new Intent(home_servis_berhasil.this, aktifitas1.class);
                startActivity(intent);
            }
        });

        // Pastikan EditText dengan ID inputlokasi ada di layout XML
        EditText inputLokasi = findViewById(R.id.inputlokasi);

        // Teks untuk ditampilkan
        String text1 = "Rumah";
        String text2 = "\nPerumahan Papan Indah 1 Blok i35/5";

        // Membuat SpannableString
        SpannableString spannableString = new SpannableString(text1 + text2);

        // Mengatur gaya dan ukuran untuk "Rumah"
        spannableString.setSpan(new StyleSpan(Typeface.BOLD), 0, text1.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new AbsoluteSizeSpan(15, true), 0, text1.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        // Mengatur gaya dan ukuran untuk "Perumahan Papan Indah 1 Blok i35/5"
        spannableString.setSpan(new StyleSpan(Typeface.NORMAL), text1.length(), spannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new AbsoluteSizeSpan(13, true), text1.length(), spannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        // Menampilkan teks pada EditText
        inputLokasi.setText(spannableString);

        // Memastikan EditText tidak fokus dan hanya untuk tampilan
        inputLokasi.setFocusable(false);
        inputLokasi.setFocusableInTouchMode(false);

        // ID lingkaran biru
        int[] circleIds = {
                R.id.lingkaranbiru01, R.id.lingkaranbiru, R.id.lingkaranbiru1,
                R.id.lingkaranbiru2, R.id.lingkaranbiru3, R.id.lingkaranbiru4,
                R.id.lingkaranbiru5, R.id.lingkaranbiru6, R.id.lingkaranbiru7,
                R.id.lingkaranbiru8, R.id.lingkaranbiru9, R.id.lingkaranbiru10,
                R.id.lingkaranbiru11, R.id.lingkaranbiru12, R.id.lingkaranbiru13
        };

        // Motor yang akan bergerak
        ImageView motorImage = findViewById(R.id.imageView102);

        // Deklarasi Handler
        Handler handler = new Handler();
        final int[] currentIndex = {0}; // Gunakan array untuk akses di dalam Runnable

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                // Reset semua lingkaran ke abu-abu
                for (int id : circleIds) {
                    ImageView circle = findViewById(id);
                    if (circle != null) {
                        circle.setImageResource(R.drawable.lingkaran_abuabu);
                    }
                }

                // Set 5 lingkaran menjadi biru
                for (int i = 0; i < 5; i++) {
                    int index = (currentIndex[0] + i) % circleIds.length;
                    ImageView circle = findViewById(circleIds[index]);
                    if (circle != null) {
                        circle.setImageResource(R.drawable.lingkaran_biru);
                    }
                }

                // Perbarui posisi motor mengikuti lingkaran biru aktif
                int activeIndex = currentIndex[0] % circleIds.length;
                ImageView activeCircle = findViewById(circleIds[activeIndex]);

                if (activeCircle != null) {
                    // Menggunakan ConstraintSet untuk memperbarui posisi motor
                    ConstraintLayout constraintLayout = findViewById(R.id.constraintLayout);
                    ConstraintSet constraintSet = new ConstraintSet();
                    constraintSet.clone(constraintLayout);

                    // Menghitung horizontalBias dalam rentang 0.25 hingga 0.75
                    float horizontalBias = 0.25f + ((activeIndex / (float) circleIds.length) * 0.5f); // Rentang antara 0.25 dan 0.75

                    // Set bias horizontal motor untuk mengikuti lingkaran biru aktif
                    constraintSet.setHorizontalBias(R.id.imageView102, horizontalBias);

                    // Terapkan perubahan constraint
                    constraintSet.applyTo(constraintLayout);
                }

                // Geser ke lingkaran berikutnya
                currentIndex[0]++;

                // Jalankan ulang setelah 300ms
                handler.postDelayed(this, 300);
            }
        };

        // Mulai animasi
        handler.post(runnable);
    }
}
