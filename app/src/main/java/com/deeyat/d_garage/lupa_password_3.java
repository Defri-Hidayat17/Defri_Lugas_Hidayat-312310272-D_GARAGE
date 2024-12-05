package com.deeyat.d_garage;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class lupa_password_3 extends AppCompatActivity {

    ImageButton imageButton1;
    TextView textView9;
    private CountDownTimer countDownTimer;
    private static final long START_TIME_IN_MILLIS = 120000; // 2 menit (120000 ms)
    private boolean timerRunning = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lupa_password3);

        // Inisialisasi komponen
        imageButton1 = findViewById(R.id.imageButton1);
        textView9 = findViewById(R.id.textView9);

        // Set OnClickListener untuk tombol kembali
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Pindah ke halaman lupa_password_2
                Intent intent = new Intent(lupa_password_3.this, lupa_password_2.class);
                startActivity(intent);
                finish(); // Menyelesaikan activity saat ini
            }
        });

        // Set OnClickListener untuk mengklik teks "Kirim Ulang Kode"
        textView9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!timerRunning) {
                    startCountdown();
                }
            }
        });

        // Inisialisasi tombol btn_masuk dan set OnClickListener
        View btnMasuk = findViewById(R.id.btn_masuk2);

        btnMasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent untuk membuka activity lupa_password_4
                Intent intent = new Intent(lupa_password_3.this, lupa_password_4.class);
                startActivity(intent);
            }
        });
    }

    // Fungsi untuk memulai countdown timer
    private void startCountdown() {
        textView9.setText("Kirim Ulang Kode (02:00)"); // Menampilkan waktu awal

        countDownTimer = new CountDownTimer(START_TIME_IN_MILLIS, 1000) { // Hitung mundur setiap detik
            @Override
            public void onTick(long millisUntilFinished) {
                long minutes = millisUntilFinished / 60000;
                long seconds = (millisUntilFinished % 60000) / 1000;
                textView9.setText(String.format("Kirim Ulang Kode (%02d:%02d)", minutes, seconds));
            }

            @Override
            public void onFinish() {
                // Ketika hitungan mundur selesai, kembalikan teks ke "Kirim Ulang Kode"
                textView9.setText("Kirim Ulang Kode");
                timerRunning = false;
            }
        }.start();

        timerRunning = true;
    }

    // Menghentikan countdown jika activity dihentikan
    @Override
    protected void onStop() {
        super.onStop();
        if (countDownTimer != null) {
            countDownTimer.cancel(); // Stop timer jika Activity dihentikan
        }
    }
}
