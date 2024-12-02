package com.deeyat.d_garage;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.Calendar;

public class biodata_page extends AppCompatActivity {

    private String selectedJenisKelamin = "";  // Variabel untuk menyimpan jenis kelamin yang dipilih

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biodata_page);

        // Inisialisasi komponen
        final EditText inputNegara = findViewById(R.id.inputnegara); // EditText untuk negara
        final EditText inputJenisKelamin = findViewById(R.id.inputjeniskelamin); // EditText untuk jenis kelamin
        final EditText inputTanggalLahir = findViewById(R.id.inputtanggallahir); // EditText untuk tanggal lahir
        ImageButton imageButton1 = findViewById(R.id.imageButton1); // ImageButton untuk kembali
        Button button3 = findViewById(R.id.button3); // Button untuk navigasi ke home_page

        // Logika untuk tombol Kirim
        button3.setOnClickListener(view -> {
            // Navigasi ke home_page
            Intent intent = new Intent(biodata_page.this, home_page.class);
            startActivity(intent);
        });

        // Daftar negara dan kode GSM
        final String[] negaraList = {
                "Indonesia", "Malaysia", "Singapura", "Thailand", "Filipina",
                "Brunei Darussalam", "Vietnam", "Laos", "Kamboja", "Myanmar"
        };

        final String[] negaraCodes = {
                "+62", "+60", "+65", "+66", "+63",
                "+673", "+84", "+856", "+855", "+95"
        };

        // Daftar bendera negara
        final int[] countryFlags = {
                R.drawable.indonesia, R.drawable.malaysia, R.drawable.singapore,
                R.drawable.thailand, R.drawable.philippines, R.drawable.brunei,
                R.drawable.vietnam, R.drawable.laos, R.drawable.cambodia, R.drawable.myanmar
        };

        // Nonaktifkan input dan fokus pada EditText negara
        inputNegara.setFocusable(false);
        inputNegara.setClickable(true);

        // Set listener untuk input negara
        inputNegara.setOnClickListener(view -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(biodata_page.this);
            builder.setTitle("Pilih Negara");

            ArrayAdapter<String> adapter = new ArrayAdapter<>(biodata_page.this, R.layout.item_with_ripple, negaraList);
            builder.setAdapter(adapter, (dialog, which) -> {
                inputNegara.setHint(negaraCodes[which]);
                inputNegara.setCompoundDrawablesWithIntrinsicBounds(countryFlags[which], 0, 0, 0);
                Toast.makeText(biodata_page.this, "Negara: " + negaraList[which], Toast.LENGTH_SHORT).show();
            });
            builder.show();
        });

        // Listener untuk input jenis kelamin
        inputJenisKelamin.setFocusable(false);
        inputJenisKelamin.setClickable(true);
        inputJenisKelamin.setCompoundDrawablesWithIntrinsicBounds(R.drawable.gender, 0, R.drawable.segitiga_bawah, 0);

        inputJenisKelamin.setOnClickListener(view -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(biodata_page.this);
            builder.setTitle("Pilih Jenis Kelamin");

            final String[] jenisKelaminList = {"Laki-laki", "Perempuan"};
            ArrayAdapter<String> adapter = new ArrayAdapter<>(biodata_page.this, R.layout.item_with_ripple, jenisKelaminList);

            builder.setAdapter(adapter, (dialog, which) -> {
                if (which == 0) {
                    inputJenisKelamin.setHint("Laki-laki");
                    inputJenisKelamin.setCompoundDrawablesWithIntrinsicBounds(R.drawable.male, 0, R.drawable.segitiga_bawah, 0);
                    selectedJenisKelamin = "Laki-laki";
                } else if (which == 1) {
                    inputJenisKelamin.setHint("Perempuan");
                    inputJenisKelamin.setCompoundDrawablesWithIntrinsicBounds(R.drawable.female, 0, R.drawable.segitiga_bawah, 0);
                    selectedJenisKelamin = "Perempuan";
                }
            });

            inputJenisKelamin.setCompoundDrawablesWithIntrinsicBounds(R.drawable.gender, 0, R.drawable.segitiga_atas, 0);

            builder.setOnDismissListener(dialog -> {
                if (selectedJenisKelamin.equals("Laki-laki")) {
                    inputJenisKelamin.setCompoundDrawablesWithIntrinsicBounds(R.drawable.male, 0, R.drawable.segitiga_bawah, 0);
                } else if (selectedJenisKelamin.equals("Perempuan")) {
                    inputJenisKelamin.setCompoundDrawablesWithIntrinsicBounds(R.drawable.female, 0, R.drawable.segitiga_bawah, 0);
                } else {
                    inputJenisKelamin.setCompoundDrawablesWithIntrinsicBounds(R.drawable.gender, 0, R.drawable.segitiga_bawah, 0);
                }
            });
            builder.show();
        });

        // Menangani klik inputTanggalLahir
        inputTanggalLahir.setFocusable(false);
        inputTanggalLahir.setClickable(true);

        inputTanggalLahir.setOnClickListener(view -> {
            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(biodata_page.this,
                    (view1, selectedYear, selectedMonth, selectedDay) -> {
                        String date = selectedDay + "/" + (selectedMonth + 1) + "/" + selectedYear;
                        inputTanggalLahir.setText(date);
                    }, year, month, day);
            datePickerDialog.show();
        });

        // Menangani klik ImageButton untuk pindah ke halaman verifikasi
        imageButton1.setOnClickListener(view -> {
            Intent intent = new Intent(biodata_page.this, verifikasi_berhasil.class);
            startActivity(intent);
        });
    }
}
