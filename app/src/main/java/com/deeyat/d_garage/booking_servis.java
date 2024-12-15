package com.deeyat.d_garage;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.Calendar;

public class booking_servis extends AppCompatActivity {

    private EditText inputTanggalServis, inputJamServis; // Deklarasi EditText untuk tanggal dan jam

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_servis);

        // Menghubungkan EditText untuk input tanggal dan jam servis
        inputTanggalServis = findViewById(R.id.inputtanggalservis);
        inputJamServis = findViewById(R.id.inputjamservis);

        // Set listener untuk menampilkan DatePickerDialog
        inputTanggalServis.setOnClickListener(v -> showDatePickerDialog());

        // Set listener untuk menampilkan TimePickerDialog
        inputJamServis.setOnClickListener(v -> showTimePickerDialog());

        // Variabel untuk menyimpan status masing-masing tombol
        boolean[] isChecked13 = {false};
        boolean[] isChecked14 = {false};

        // Menghubungkan ImageButton untuk kotak centang
        ImageButton imageButton13 = findViewById(R.id.imageButton13);
        ImageButton imageButton14 = findViewById(R.id.imageButton14);

        // Set listener untuk menangani klik pada ImageButton13
        imageButton13.setOnClickListener(v -> {
            if (isChecked13[0]) {
                imageButton13.setImageResource(R.drawable.kotak16); // Ganti dengan gambar kotak kosong
            } else {
                imageButton13.setImageResource(R.drawable.centang_ingatsaya); // Ganti dengan gambar centang
            }
            isChecked13[0] = !isChecked13[0];
        });

        // Set listener untuk menangani klik pada ImageButton14
        imageButton14.setOnClickListener(v -> {
            if (isChecked14[0]) {
                imageButton14.setImageResource(R.drawable.kotak16); // Ganti dengan gambar kotak kosong
            } else {
                imageButton14.setImageResource(R.drawable.centang_ingatsaya); // Ganti dengan gambar centang
            }
            isChecked14[0] = !isChecked14[0];
        });
    }

    private void showDatePickerDialog() {
        // Mendapatkan tanggal saat ini
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        // Membuat dialog pemilih tanggal
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                booking_servis.this,
                (view, year1, month1, dayOfMonth) -> {
                    // Format tanggal (misalnya: 15/12/2024)
                    String selectedDate = dayOfMonth + "/" + (month1 + 1) + "/" + year1;
                    inputTanggalServis.setText(selectedDate);
                },
                year, month, day
        );

        // Menampilkan dialog
        datePickerDialog.show();
    }

    private void showTimePickerDialog() {
        // Mendapatkan waktu saat ini
        final Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        // Membuat dialog pemilih waktu
        TimePickerDialog timePickerDialog = new TimePickerDialog(
                booking_servis.this,
                (view, hourOfDay, minuteOfHour) -> {
                    // Format waktu (misalnya: 14:30)
                    String selectedTime = String.format("%02d:%02d", hourOfDay, minuteOfHour);
                    inputJamServis.setText(selectedTime);
                },
                hour, minute, true // Parameter terakhir menentukan format 24 jam
        );

        // Menampilkan dialog
        timePickerDialog.show();

        // Inisialisasi tombol imageButton7
        ImageButton imageButton7 = findViewById(R.id.imageButton7);

        // Tambahkan event listener untuk navigasi ke home_page
        imageButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(booking_servis.this, home_page.class);
                startActivity(intent);
                finish(); // Opsional: menutup halaman saat ini
            }
        });

        //button9
        Button button9 = findViewById(R.id.button9);
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(booking_servis.this, booking_servis_berhasil.class);
                startActivity(intent);
            }
        });
    }
}
