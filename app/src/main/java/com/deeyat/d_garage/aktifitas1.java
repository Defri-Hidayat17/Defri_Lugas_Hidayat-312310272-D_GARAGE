package com.deeyat.d_garage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class aktifitas1 extends AppCompatActivity {

    private ConstraintLayout mainLayout;
    private View scrollview1, scrollview2;
    private View textView17, textView18;
    private EditText searchField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aktifitas1);

        // Inisialisasi Views
        mainLayout = findViewById(R.id.constraintLayout); // ConstraintLayout utama
        scrollview1 = findViewById(R.id.scrollview1);
        scrollview2 = findViewById(R.id.scrollview2);
        textView17 = findViewById(R.id.textView17);
        textView18 = findViewById(R.id.textView18);
        searchField = findViewById(R.id.searchField);

        // Event Listener untuk textView18
        textView18.setOnClickListener(v -> {
            scrollview1.setVisibility(View.GONE); // Sembunyikan ScrollView1
            scrollview2.setVisibility(View.VISIBLE); // Tampilkan ScrollView2
            mainLayout.setBackgroundResource(R.drawable.aktifitas_2); // Ubah background
            searchField.setHint("Cari riwayat disini"); // Ubah hint
        });

        // Event Listener untuk textView17
        textView17.setOnClickListener(v -> {
            scrollview2.setVisibility(View.GONE); // Sembunyikan ScrollView2
            scrollview1.setVisibility(View.VISIBLE); // Tampilkan ScrollView1
            mainLayout.setBackgroundResource(R.drawable.sdg_berjalan); // Kembalikan background
            searchField.setHint("Cari aktifitas disini"); // Kembalikan hint
        });

        // Inisialisasi tombol imageButton7
        ImageButton imageButton7 = findViewById(R.id.imageButton7);

        // Tambahkan event listener untuk navigasi ke home_page
        imageButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(aktifitas1.this, home_page.class);
                startActivity(intent);
                finish(); // Opsional: menutup halaman saat ini
            }
        });

        // Inisialisasi ImageView navigasi ke home_page
        ImageView imageView98 = findViewById(R.id.imageView98);
        imageView98.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(aktifitas1.this, home_page.class);
                startActivity(intent);
            }
        });

        // Inisialisasi ImageView navigasi ke akun_scroll
        ImageView imageView99 = findViewById(R.id.imageView99);
        imageView99.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(aktifitas1.this, akun_scroll.class);
                startActivity(intent);
            }
        });
    }
}
