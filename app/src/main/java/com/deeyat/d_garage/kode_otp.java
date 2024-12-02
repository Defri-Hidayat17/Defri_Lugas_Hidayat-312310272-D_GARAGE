package com.deeyat.d_garage;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class kode_otp extends AppCompatActivity {

    private TextView btnKirimUlang;  // Mengubah btnKirimUlang menjadi TextView
    private CountDownTimer countDownTimer;
    private TextView textView12; // Referensi untuk textView12
    private boolean isTimerRunning = false; // Flag untuk mengecek status timer

    // Durasi countdown (2 menit = 120 detik = 120000 ms)
    private static final long START_TIME_IN_MILLIS = 120000; // 2 menit

    // Deklarasi tombol btn_masuk2
    private Button btnMasuk2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kode_otp);

        // Inisialisasi tombol back
        ImageButton imageButton10 = findViewById(R.id.imageButton10);

        // Menambahkan listener untuk tombol back
        imageButton10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Membuka halaman verifikasi_wa_sms
                Intent intent = new Intent(kode_otp.this, verifikasi_wa_sms.class);
                startActivity(intent);
                // Menyelesaikan activity ini, sehingga pengguna tidak bisa kembali ke halaman ini menggunakan tombol back
                finish();
            }
        });

        // Mendapatkan referensi ke TextView untuk status verifikasi
        textView12 = findViewById(R.id.textView12);

        // Mendapatkan data dari Intent untuk menentukan metode verifikasi
        String verifikasiMetode = getIntent().getStringExtra("verifikasi_metode");

        // Menentukan teks berdasarkan metode verifikasi
        if (verifikasiMetode != null) {
            if (verifikasiMetode.equals("WhatsApp")) {
                setTextWithColor("Kami telah mengirimkan kode OTP via WhatsApp ke nomor Anda", "WhatsApp");
            } else if (verifikasiMetode.equals("SMS")) {
                setTextWithColor("Kami telah mengirimkan kode OTP via SMS ke nomor Anda", "SMS");
            }
        }

        // Menginisialisasi tombol Kirim Ulang (sekarang TextView)
        btnKirimUlang = findViewById(R.id.textView9);

        // Menambahkan listener untuk TextView Kirim Ulang
        btnKirimUlang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Memastikan bahwa timer hanya bisa dimulai jika belum berjalan
                if (!isTimerRunning) {
                    startCountDown();
                }
            }
        });

        // Inisialisasi tombol btn_masuk2
        btnMasuk2 = findViewById(R.id.btn_masuk2);

        // Set OnClickListener untuk tombol btn_masuk2
        btnMasuk2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigasi ke halaman verifikasi_berhasil
                Intent intent = new Intent(kode_otp.this, verifikasi_berhasil.class);
                startActivity(intent);  // Mulai aktivitas VerifikasiBerhasil
                finish();  // Optional: Menutup aktivitas ini setelah navigasi (agar pengguna tidak bisa kembali)
            }
        });
    }

    // Metode untuk memulai countdown
    private void startCountDown() {
        // Menampilkan waktu countdown pada textView9
        btnKirimUlang.setVisibility(View.VISIBLE);

        // Mengatur flag timer aktif
        isTimerRunning = true;

        // Mulai hitung mundur selama 2 menit (120 detik = 120000 ms)
        countDownTimer = new CountDownTimer(START_TIME_IN_MILLIS, 1000) { // 1 detik interval
            @Override
            public void onTick(long millisUntilFinished) {
                long minutes = millisUntilFinished / 60000;
                long seconds = (millisUntilFinished % 60000) / 1000;
                // Menampilkan waktu countdown dalam format (menit:detik)
                btnKirimUlang.setText(String.format("Kirim Ulang Kode (%02d:%02d)", minutes, seconds));
            }

            @Override
            public void onFinish() {
                // Ketika timer selesai, ubah teks TextView kembali
                btnKirimUlang.setText("Kirim Ulang Kode");
                isTimerRunning = false; // Reset flag ketika timer selesai
            }
        }.start();
    }

    // Metode untuk mengubah teks dan memberi warna pada kata tertentu
    private void setTextWithColor(String text, String targetWord) {
        // Membuat objek SpannableString dari teks
        SpannableString spannableString = new SpannableString(text);

        // Mencari posisi dari kata yang ditargetkan dan memberi warna merah
        int start = text.indexOf(targetWord);
        int end = start + targetWord.length();

        // Menggunakan ForegroundColorSpan untuk memberi warna
        spannableString.setSpan(new ForegroundColorSpan(Color.RED), start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        // Set spannableString ke TextView
        textView12.setText(spannableString);
    }
}
