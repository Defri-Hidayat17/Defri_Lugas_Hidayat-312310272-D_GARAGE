package com.deeyat.d_garage;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class lokasi_bengkel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lokasi_bengkel);

        // Inisialisasi tombol imageButton7 untuk navigasi ke home_page
        ImageButton imageButton7 = findViewById(R.id.imageButton7);
        imageButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {;
                // Navigasi ke halaman home_page
                Intent intent = new Intent(lokasi_bengkel.this, home_page.class);
                startActivity(intent);
                finish(); // Menutup halaman saat ini
            }
        });


        // Mengecek apakah izin sudah diberikan
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED ||
                ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                        != PackageManager.PERMISSION_GRANTED) {

            // Jika izin belum diberikan, maka meminta izin
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                            Manifest.permission.ACCESS_COARSE_LOCATION},
                    1);
        }

// Inisialisasi ImageView untuk navigasi ke Google Maps
        ImageView imageView45 = findViewById(R.id.imageView45);
        imageView45.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Koordinat dalam format desimal: -6.2906983370903395, 106.95547847955834
                String geoUri = "geo:0,0?q=-6.290796924942013, 106.95548155468741"; // Menggunakan format geo dengan query
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(geoUri));
                intent.setPackage("com.google.android.apps.maps");

                // Pastikan aplikasi Google Maps tersedia
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                } else {
                    // Handle jika Google Maps tidak tersedia
                    Toast.makeText(lokasi_bengkel.this, "Google Maps tidak tersedia!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // Menangani hasil permintaan izin
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Izin diberikan, Anda bisa mengakses lokasi
                Toast.makeText(this, "Izin lokasi diberikan!", Toast.LENGTH_SHORT).show();
            } else {
                // Izin ditolak, beri penjelasan atau fallback jika perlu
                Toast.makeText(this, "Izin lokasi diperlukan untuk menampilkan peta", Toast.LENGTH_LONG).show();
            }
        }
    }
}
