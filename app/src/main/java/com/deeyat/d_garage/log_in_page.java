package com.deeyat.d_garage;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.method.PasswordTransformationMethod;
import android.text.style.ForegroundColorSpan;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.EditText;
import android.widget.TextView;

public class log_in_page extends AppCompatActivity {
    ImageView imageView;
    ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in_page);

        // Menghubungkan ImageView dengan ID di XML
        imageView = findViewById(R.id.imageButton2);

        // Set OnClickListener untuk ImageView
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Mengarahkan kembali ke WelcomePage
                Intent intent = new Intent(log_in_page.this, welcomepage.class);
                startActivity(intent);
            }
        });

        EditText inputPassword = findViewById(R.id.inputPassword);

// Tambahkan properti padding jika perlu untuk memperbaiki posisi klik
        inputPassword.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    int drawableRight = 2; // Posisi drawable di kanan
                    if (inputPassword.getCompoundDrawables()[drawableRight] != null) {
                        // Hitung batas klik ikon mata
                        int drawableWidth = inputPassword.getCompoundDrawables()[drawableRight].getBounds().width();
                        if (event.getRawX() >= (inputPassword.getRight() - drawableWidth - inputPassword.getPaddingEnd())) {
                            // Periksa InputType untuk menentukan apakah password sedang tersembunyi
                            if (inputPassword.getTransformationMethod() instanceof PasswordTransformationMethod) {
                                // Menampilkan password
                                inputPassword.setTransformationMethod(null);
                                inputPassword.setCompoundDrawablesWithIntrinsicBounds(R.drawable.lock, 0, R.drawable.eye, 0); // Ganti ikon mata
                            } else {
                                // Menyembunyikan password
                                inputPassword.setTransformationMethod(new PasswordTransformationMethod());
                                inputPassword.setCompoundDrawablesWithIntrinsicBounds(R.drawable.lock, 0, R.drawable.eye_off, 0); // Ganti ikon mata silang
                            }
                            // Pastikan cursor tetap di akhir teks
                            inputPassword.setSelection(inputPassword.getText().length());
                            return true;
                        }
                    }
                }
                return false;
            }
        });


        // Menambahkan kode untuk mewarnai teks pada TextView
        TextView tvDaftar = findViewById(R.id.tv_daftar);
        String text = "Belum Punya Akun? Daftar Sekarang";

        // Membuat SpannableString untuk mengubah warna teks
        SpannableString spannableString = new SpannableString(text);

        // Mewarnai bagian "Belum Punya Akun?" dengan warna hitam
        spannableString.setSpan(new ForegroundColorSpan(Color.BLACK), 0, 17, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        // Mewarnai bagian "Daftar Sekarang" dengan warna biru
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#0781D9")), 18, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        // Menetapkan teks ke TextView
        tvDaftar.setText(spannableString);

        // Menambahkan klik listener pada bagian "Daftar Sekarang"
        tvDaftar.setMovementMethod(LinkMovementMethod.getInstance());
        tvDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Menavigasi ke halaman DaftarPage saat "Daftar Sekarang" diklik
                Intent intent = new Intent(log_in_page.this, daftar_akun_page.class);
                startActivity(intent);
            }
        });

// Variabel untuk menyimpan status apakah kotak sudah tercentang
        boolean[] isChecked = {false};

// Menghubungkan ImageButton untuk kotak centang
        ImageButton imageButton5 = findViewById(R.id.imageButton5);

// Set listener untuk menangani klik pada ImageButton
        imageButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isChecked[0]) {
                    // Jika sudah tercentang, ganti dengan gambar kotak kosong
                    imageButton5.setImageResource(R.drawable.kotak_ingatsaya); // Ganti dengan gambar kotak kosong
                } else {
                    // Jika belum tercentang, ganti dengan gambar centang
                    imageButton5.setImageResource(R.drawable.centang_ingatsaya); // Ganti dengan gambar kotak yang ada centangnya
                }
                // Toggle status checked
                isChecked[0] = !isChecked[0];
            }
        });

// Menghubungkan TextView dengan ID di XML
        TextView textView = findViewById(R.id.textView3);

// Set OnClickListener untuk TextView
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Menavigasi ke halaman lupa_password
                Intent intent = new Intent(log_in_page.this, lupa_password.class);
                startActivity(intent);
            }
        });

        Button button;
        Button btn_masuk =findViewById(R.id.btn_masuk);
        btn_masuk.setOnClickListener(view -> {
            Intent intent = new Intent(log_in_page.this, home_page.class);
            startActivity(intent);
        });

    }
}

