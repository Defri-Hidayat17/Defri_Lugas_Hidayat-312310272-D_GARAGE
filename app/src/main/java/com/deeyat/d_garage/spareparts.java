package com.deeyat.d_garage;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;

public class spareparts extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spareparts);

        // Inisialisasi tombol imageButton7 dan event listener navigasi ke home_page
        ImageButton imageButton7 = findViewById(R.id.imageButton7);
        imageButton7.setOnClickListener(v -> {
            Intent intent = new Intent(spareparts.this, home_page.class);
            startActivity(intent);
        });

        EditText inputTypeOli = findViewById(R.id.inputtypeoli);
        inputTypeOli.setFocusable(false);
        inputTypeOli.setClickable(true);
        inputTypeOli.setCompoundDrawablesWithIntrinsicBounds(R.drawable.search, 0, R.drawable.segitiga_bawah, 0);

        inputTypeOli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputTypeOli.setCompoundDrawablesWithIntrinsicBounds(R.drawable.search, 0, R.drawable.segitiga_atas, 0); // Ubah ke atas saat diklik
                AlertDialog.Builder builder = new AlertDialog.Builder(spareparts.this);
                builder.setTitle("Pilih Opsi");

                final String[] options = {"EVOLUTION SERIES", "ZENZATION SERIES", "HP SPORT SERIES"};
                ArrayAdapter<String> adapter = new ArrayAdapter<>(spareparts.this, R.layout.item_with_ripple, options);

                builder.setAdapter(adapter, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        inputTypeOli.setHint(options[which]); // Mengubah hint berdasarkan pilihan yang dipilih
                    }
                });

                builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialog) {
                        inputTypeOli.setCompoundDrawablesWithIntrinsicBounds(R.drawable.search, 0, R.drawable.segitiga_bawah, 0); // Kembali ke bawah setelah dismiss
                    }
                });

                builder.show();
            }
        });




    }
}