package com.deeyat.d_garage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class hubungi_kami extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hubungi_kami);

        // Inisialisasi tombol imageButton7 dan event listener navigasi ke akun_scroll
        ImageButton imageButton7 = findViewById(R.id.imageButton7);
        imageButton7.setOnClickListener(v -> {
            // Menavigasi ke halaman akun_scroll
            Intent intent = new Intent(hubungi_kami.this, akun_scroll.class);
            startActivity(intent);
        });

        EditText editTextWhatsApp = findViewById(R.id.inputwhatsapp);
        editTextWhatsApp.setOnClickListener(view -> {
            // Nomor telepon dalam format internasional
            String phoneNumber = "6289509371705";

            if (phoneNumber.isEmpty()) {
                Toast.makeText(this, "Nomor telepon tidak boleh kosong", Toast.LENGTH_SHORT).show();
                return;
            }

            // Format URL WhatsApp
            String url = "https://wa.me/" + phoneNumber;

            // Debugging
            Log.d("WhatsAppIntent", "Generated URL: " + url);

            // Intent untuk membuka WhatsApp
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            intent.setPackage("com.whatsapp"); // Menargetkan WhatsApp

            // Periksa apakah aplikasi WhatsApp tersedia
            try {
                startActivity(intent);
            } catch (ActivityNotFoundException e) {
                // Jika WhatsApp reguler tidak ada, coba WhatsApp Business
                intent.setPackage("com.whatsapp.w4b");
                try {
                    startActivity(intent);
                } catch (ActivityNotFoundException ex) {
                    Toast.makeText(this, "WhatsApp tidak tersedia di perangkat ini", Toast.LENGTH_SHORT).show();
                }
            }
        });


        EditText editTextEmail = findViewById(R.id.inputemail);
        editTextEmail.setOnClickListener(view -> {
            // Ambil email dari hint
            String email = editTextEmail.getHint().toString();

            // Validasi email
            if (email.isEmpty() || !email.contains("@")) {
                Toast.makeText(this, "Email tidak valid", Toast.LENGTH_SHORT).show();
                return;
            }

            // Intent dengan schema mailto:
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:" + email));

            // Tambahkan debugging
            Log.d("EmailIntent", "Generated URI: " + intent.getData());

            // Coba buka intent
            try {
                startActivity(intent);
            } catch (ActivityNotFoundException e) {
                Toast.makeText(this, "Aplikasi email tidak ditemukan di perangkat ini", Toast.LENGTH_SHORT).show();
            }
        });

        ImageView imageViewInstagram = findViewById(R.id.imageView59);
        imageViewInstagram.setOnClickListener(view -> {
            // URL profil Instagram (ganti dengan URL profil Anda)
            String instagramProfile = "https://www.instagram.com/defrilugashidayat"; // Ganti dengan username Anda

            // Intent untuk membuka URL
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(instagramProfile));
            intent.setPackage("com.instagram.android"); // Menentukan aplikasi Instagram secara langsung

            // Periksa apakah ada aplikasi Instagram yang mendukung intent ini
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            } else {
                // Jika aplikasi Instagram tidak ditemukan, buka di browser
                intent.setPackage(null); // Menghilangkan pembatasan aplikasi
                startActivity(intent);
            }
        });


        ImageView imageViewFacebook = findViewById(R.id.imageView60);
        imageViewFacebook.setOnClickListener(view -> {
            // URL halaman atau profil Facebook Anda
            String facebookProfile = "https://www.facebook.com/defri.l.hidayat.5"; // Ganti dengan URL profil Anda

            // Intent untuk membuka URL
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(facebookProfile));
            intent.setPackage("com.facebook.katana"); // Menentukan aplikasi Facebook secara langsung

            // Periksa apakah ada aplikasi Facebook yang mendukung intent ini
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            } else {
                // Jika aplikasi Facebook tidak ditemukan, buka di browser
                intent.setPackage(null); // Menghilangkan pembatasan aplikasi
                startActivity(intent);
            }
        });


        ImageView imageViewYouTube = findViewById(R.id.imageView62);
        imageViewYouTube.setOnClickListener(view -> {
            // URL channel YouTube Anda
            String youtubeURL = "https://www.youtube.com/@DeeYatt17"; // Ganti dengan channel Anda

            // Intent untuk membuka URL
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(youtubeURL));

            // Coba buka aplikasi YouTube secara langsung
            intent.setPackage("com.google.android.youtube");

            // Periksa apakah aplikasi YouTube tersedia di perangkat
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            } else {
                // Jika aplikasi YouTube tidak ditemukan, buka di browser
                intent.setPackage(null); // Menghilangkan pembatasan aplikasi
                startActivity(intent);
            }
        });


        ImageView imageView = findViewById(R.id.imageView61);
        imageView.setOnClickListener(view -> {
            // URL yang ingin dibuka di browser
            String url = "https://setirkanan.co.id/servis/bengkel/servicepoint/servis";

            // Intent untuk membuka URL di browser
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));

            // Menambahkan log untuk memastikan URL benar
            Log.d("BrowserIntent", "Generated URL: " + url);

            // Menggunakan Intent.createChooser untuk memberikan pilihan aplikasi browser
            try {
                startActivity(Intent.createChooser(intent, "Pilih aplikasi browser"));
            } catch (ActivityNotFoundException e) {
                Toast.makeText(this, "Tidak ada aplikasi browser yang tersedia", Toast.LENGTH_SHORT).show();
            }
        });



    }
}
