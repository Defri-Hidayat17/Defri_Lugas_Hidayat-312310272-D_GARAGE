package com.deeyat.d_garage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class lupa_password_2 extends AppCompatActivity {

    ImageButton imageButton1;
    EditText inputPasswordBaru, konfirmasipasswordbaru;
    boolean isPasswordVisible = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lupa_password2);

        // Inisialisasi komponen UI
        imageButton1 = findViewById(R.id.imageButton1);
        inputPasswordBaru = findViewById(R.id.inputPasswordBaru);
        konfirmasipasswordbaru = findViewById(R.id.konfirmasipasswordbaru);

        // Set OnClickListener untuk tombol kembali
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Pindah ke halaman lupa_password
                Intent intent = new Intent(lupa_password_2.this, lupa_password.class);
                startActivity(intent);
                finish(); // Menyelesaikan activity saat ini
            }
        });

        // Inisialisasi tombol btn_masuk
        View btnMasuk = findViewById(R.id.btn_masuk);

        // Set OnClickListener untuk tombol btn_masuk
        btnMasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent untuk membuka activity lupa_password_3
                Intent intent = new Intent(lupa_password_2.this, lupa_password_3.class);
                startActivity(intent);
            }
        });

        // Menambahkan fungsi toggle untuk ikon mata di EditText inputPasswordBaru
        setupPasswordToggle(inputPasswordBaru);

        // Menambahkan fungsi toggle untuk ikon mata di EditText konfirmasipasswordbaru
        setupPasswordToggle(konfirmasipasswordbaru);
    }

    private void setupPasswordToggle(EditText editText) {
        editText.setOnTouchListener((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_UP) {
                int drawableRight = 2; // Indeks drawable kanan
                if (editText.getCompoundDrawables()[drawableRight] != null) {
                    int drawableWidth = editText.getCompoundDrawables()[drawableRight].getBounds().width();
                    if (event.getRawX() >= (editText.getRight() - drawableWidth - editText.getPaddingEnd())) {
                        if (isPasswordVisible) {
                            // Menyembunyikan password
                            editText.setTransformationMethod(new PasswordTransformationMethod());
                            editText.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.eye_off, 0);
                        } else {
                            // Menampilkan password
                            editText.setTransformationMethod(null);
                            editText.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.eye, 0);
                        }
                        isPasswordVisible = !isPasswordVisible;
                        editText.setSelection(editText.getText().length());
                        return true;
                    }
                }
            }
            return false;
        });
    }
}
