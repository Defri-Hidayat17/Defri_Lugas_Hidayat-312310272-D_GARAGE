package com.deeyat.d_garage;

import android.content.Intent;
import android.graphics.Color;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.text.style.ForegroundColorSpan;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class daftar_akun_page extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_akun_page);

        // Deklarasi untuk ImageView dan ImageButton
        ImageView imageView;
        ImageButton imageButton4;

        // Menghubungkan ImageView dengan ID di XML
        imageView = findViewById(R.id.imageButton);

        // Set OnClickListener untuk ImageView
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Mengarahkan kembali ke halaman log_in_page
                Intent intent = new Intent(daftar_akun_page.this, log_in_page.class); // Ganti dengan halaman yang sesuai
                startActivity(intent);
            }
        });

        // Menentukan TextView untuk kriteria
        TextView criteriaMinLength = findViewById(R.id.criteria_min_length);
        TextView criteriaUppercase = findViewById(R.id.criteria_uppercase);
        TextView criteriaLowercase = findViewById(R.id.criteria_lowercase);
        TextView criteriaNumber = findViewById(R.id.criteria_number);

        // Menentukan EditText untuk password
        EditText inputPassword = findViewById(R.id.inputPassword);

        // Menambahkan TextWatcher pada EditText untuk password
        inputPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String password = s.toString();

                // Tampilkan kriteria setelah ada input pertama
                if (password.length() > 0) {
                    criteriaMinLength.setVisibility(TextView.VISIBLE);
                    criteriaUppercase.setVisibility(TextView.VISIBLE);
                    criteriaLowercase.setVisibility(TextView.VISIBLE);
                    criteriaNumber.setVisibility(TextView.VISIBLE);
                } else {
                    // Sembunyikan kriteria jika password kosong
                    criteriaMinLength.setVisibility(TextView.GONE);
                    criteriaUppercase.setVisibility(TextView.GONE);
                    criteriaLowercase.setVisibility(TextView.GONE);
                    criteriaNumber.setVisibility(TextView.GONE);
                }

                // Validasi minimal 8 karakter
                if (password.length() >= 8) {
                    criteriaMinLength.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.centang, 0);
                } else {
                    criteriaMinLength.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0); // Tanda silang jika tidak valid
                }

                // Validasi huruf besar
                if (password.matches(".*[A-Z].*")) {
                    criteriaUppercase.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.centang, 0);
                } else {
                    criteriaUppercase.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0); // Tanda silang jika tidak valid
                }

                // Validasi huruf kecil
                if (password.matches(".*[a-z].*")) {
                    criteriaLowercase.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.centang, 0);
                } else {
                    criteriaLowercase.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0); // Tanda silang jika tidak valid
                }

                // Validasi angka
                if (password.matches(".*[0-9].*")) {
                    criteriaNumber.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.centang, 0);
                } else {
                    criteriaNumber.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0); // Tanda silang jika tidak valid
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        // Menambahkan TouchListener untuk menampilkan atau menyembunyikan password
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

        // Variabel untuk menyimpan status apakah kotak sudah tercentang
        boolean[] isChecked = {false};

        // Menghubungkan ImageButton untuk kotak centang
        imageButton4 = findViewById(R.id.imageButton4);

        // Set listener untuk menangani klik pada ImageButton
        imageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isChecked[0]) {
                    // Jika sudah tercentang, ganti dengan gambar kotak kosong
                    imageButton4.setImageResource(R.drawable.kotak); // Ganti dengan gambar kotak kosong
                } else {
                    // Jika belum tercentang, ganti dengan gambar centang
                    imageButton4.setImageResource(R.drawable.kotak_centang); // Ganti dengan gambar kotak yang ada centangnya
                }
                // Toggle status checked
                isChecked[0] = !isChecked[0];
            }
        });

// Menambahkan kode untuk mewarnai teks pada TextView
        TextView tvDaftar = findViewById(R.id.textView2);
        String text = "Saya menyetujui penyimpanan dan penggunaan data pribadi saya serta menyetujui ketentuan layanan dan kebijakan privasi";

// Membuat SpannableString untuk mengubah warna teks
        SpannableString spannableString = new SpannableString(text);

// Mewarnai bagian "Saya menyetujui penyimpanan dan penggunaan data pribadi saya serta menyetujui" dengan warna hitam
        spannableString.setSpan(new ForegroundColorSpan(Color.BLACK), 0, 77, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

// Mewarnai bagian "ketentuan layanan" dengan warna merah
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#FF0000")), 78, 95, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

// Mewarnai kata "dan" dengan warna hitam
        spannableString.setSpan(new ForegroundColorSpan(Color.BLACK), 96, 99, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

// Mewarnai bagian "kebijakan privasi" dengan warna merah
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#FF0000")), 100, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

// Menetapkan teks ke TextView
        tvDaftar.setText(spannableString);


        Button button2 = findViewById(R.id.button2);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Membuat Intent untuk menuju halaman verifikasi_wa_sms
                Intent intent = new Intent(daftar_akun_page.this, verifikasi_wa_sms.class);
                startActivity(intent);
            }
        });


    }

}