package com.deeyat.d_garage;

import android.Manifest;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.Calendar;

public class home_servis extends AppCompatActivity {

    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1;

    private EditText inputLokasi;
    private EditText inputTanggalServis, inputJamServis; // Deklarasi EditText untuk tanggal dan jam

    private boolean[] isChecked13 = {false};
    private boolean[] isChecked14 = {false};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_servis);

        // Inisialisasi tombol navigasi
        ImageButton imageButton7 = findViewById(R.id.imageButton7);
        imageButton7.setOnClickListener(v -> {
            Intent intent = new Intent(home_servis.this, home_page.class);
            startActivity(intent);
            finish(); // Opsional: menutup halaman saat ini
        });

        //button9
        Button button9 = findViewById(R.id.button9);
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(home_servis.this, home_servis_berhasil.class);
                startActivity(intent);
            }
        });

        // Inisialisasi EditText lokasi
        inputLokasi = findViewById(R.id.inputlokasi);
        inputLokasi.setOnClickListener(v -> {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                getLocationAndDisplay();
            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, LOCATION_PERMISSION_REQUEST_CODE);
            }
        });

        // Inisialisasi EditText tanggal dan jam
        inputTanggalServis = findViewById(R.id.inputtanggalservis);
        inputJamServis = findViewById(R.id.inputjamservis);

        // Listener untuk tanggal dan jam
        inputTanggalServis.setOnClickListener(v -> showDatePickerDialog());
        inputJamServis.setOnClickListener(v -> showTimePickerDialog());

        // Inisialisasi ImageButton untuk checkbox
        ImageButton imageButton13 = findViewById(R.id.imageButton13);
        ImageButton imageButton14 = findViewById(R.id.imageButton14);

        // Listener untuk checkbox
        imageButton13.setOnClickListener(v -> {
            if (isChecked13[0]) {
                imageButton13.setImageResource(R.drawable.kotak16); // Ganti dengan gambar kotak kosong
            } else {
                imageButton13.setImageResource(R.drawable.centang_ingatsaya); // Ganti dengan gambar centang
            }
            isChecked13[0] = !isChecked13[0];
        });

        imageButton14.setOnClickListener(v -> {
            if (isChecked14[0]) {
                imageButton14.setImageResource(R.drawable.kotak16); // Ganti dengan gambar kotak kosong
            } else {
                imageButton14.setImageResource(R.drawable.centang_ingatsaya); // Ganti dengan gambar centang
            }
            isChecked14[0] = !isChecked14[0];
        });
    }

    private void getLocationAndDisplay() {
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

            if (location != null) {
                double latitude = location.getLatitude();
                double longitude = location.getLongitude();
                String locationText = "Lat: " + latitude + ", Long: " + longitude;

                inputLokasi.setText(locationText);
            } else {
                inputLokasi.setHint("Tidak dapat menemukan lokasi");
            }
        } else {
            inputLokasi.setHint("Izin lokasi tidak tersedia");
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @androidx.annotation.NonNull String[] permissions, @androidx.annotation.NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == LOCATION_PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                getLocationAndDisplay();
            } else {
                inputLokasi.setHint("Izin lokasi ditolak");
            }
        }
    }

    private void showDatePickerDialog() {
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                home_servis.this,
                (view, year1, month1, dayOfMonth) -> {
                    String selectedDate = dayOfMonth + "/" + (month1 + 1) + "/" + year1;
                    inputTanggalServis.setText(selectedDate);
                },
                year, month, day
        );

        datePickerDialog.show();
    }

    private void showTimePickerDialog() {
        final Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(
                home_servis.this,
                (view, hourOfDay, minuteOfHour) -> {
                    String selectedTime = String.format("%02d:%02d", hourOfDay, minuteOfHour);
                    inputJamServis.setText(selectedTime);
                },
                hour, minute, true
        );

        timePickerDialog.show();
    }
}
