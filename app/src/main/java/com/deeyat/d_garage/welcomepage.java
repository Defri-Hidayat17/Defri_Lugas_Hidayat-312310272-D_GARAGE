package com.deeyat.d_garage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class welcomepage extends AppCompatActivity {
    Button button; // Ganti ImageView menjadi Button

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcomepage);

        // Inisialisasi Button dengan ID dari XML
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigasi ke log_in_page
                startActivity(new Intent(welcomepage.this, log_in_page.class));
            }
        });
    }
}
