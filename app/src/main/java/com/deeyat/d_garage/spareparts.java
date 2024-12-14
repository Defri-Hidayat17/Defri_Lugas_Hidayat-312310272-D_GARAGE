package com.deeyat.d_garage;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

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

        TextView textView68 = findViewById(R.id.textView68);
        textView68.setText(Html.fromHtml("<u>Oli Transmisi</u>"));

        TextView textView068 = findViewById(R.id.textView068);
        textView068.setText(Html.fromHtml("<u>Oli Gardan</u>"));

        TextView textView0068 = findViewById(R.id.textView0068);
        textView0068.setText(Html.fromHtml("<u>Air Radiator</u>"));

        TextView textView00068 = findViewById(R.id.textView00068);
        textView00068.setText(Html.fromHtml("<u>Minyak Rem</u>"));

        // Event listener untuk membuka URL pada setiap ImageView
        initializeImageView(R.id.imageView75, "https://www.top1.co.id/produk/detail/EVOLUTION-5W-30-API-SP");
        initializeImageView(R.id.imageView2, "https://www.top1.co.id/produk/detail/EVOLUTION-0W-20-API-SP");
        initializeImageView(R.id.imageView3, "https://www.top1.co.id/produk/detail/EVOLUTION-5W-40-API-SP");
        initializeImageView(R.id.imageView4, "https://www.top1.co.id/produk/detail/EVOLUTION-5W-40-API-SP");
        initializeImageView(R.id.imageView6, "https://www.top1.co.id/produk/detail/EVOLUTION-DIESEL-5W-40-API-CJ-4");
        initializeImageView(R.id.imageView12, "https://www.top1.co.id/produk/detail/ZENZATION-5W-30-API-SP");
        initializeImageView(R.id.imageView14, "https://www.top1.co.id/produk/detail/ZENZATION-5W-40-API-SP");
        initializeImageView(R.id.imageView16, "https://www.top1.co.id/produk/detail/ZENZATION-0W-20-API-SN");
        initializeImageView(R.id.imageView18, "https://www.top1.co.id/produk/detail/ZENZATION-5W-30-API-SN");
        initializeImageView(R.id.imageView22, "https://www.top1.co.id/produk/detail/ZENZATION-SUV-5W-30-API-SN");
        initializeImageView(R.id.imageView24, "https://www.top1.co.id/produk/detail/ZENZATION-10W-40-API-SN");
        initializeImageView(R.id.imageView26, "https://www.top1.co.id/produk/detail/ZENZATION-DIESEL-5W-30-API-CJ-4");
        initializeImageView(R.id.imageView28, "https://www.top1.co.id/produk/detail/ZENZATION-DIESEL-10W-40-API-CJ-4");
        initializeImageView(R.id.imageView32, "https://www.top1.co.id/produk/detail/HP-SPORT-10W-40-API-SN");
        initializeImageView(R.id.imageView34, "https://www.top1.co.id/produk/detail/HP-SPORT-15W-40-API-SN");
        initializeImageView(R.id.imageView02, "https://www.top1.co.id/produk/detail/ATF-LIFETIME-DIII");
        initializeImageView(R.id.imageView04, "https://www.top1.co.id/produk/detail/ATF-EVOLUTION-MV");
        initializeImageView(R.id.imageView06, "https://www.top1.co.id/produk/detail/ATF-CVT");
        initializeImageView(R.id.imageView08, "https://www.top1.co.id/produk/detail/ATF-MV-PLUS");
        initializeImageView(R.id.imageView002, "https://www.top1.co.id/produk/detail/SGO-80W-90-API-GL-4");
        initializeImageView(R.id.imageView004, "https://www.top1.co.id/produk/detail/SGO-90-API-GL-5");
        initializeImageView(R.id.imageView006, "https://www.top1.co.id/produk/detail/SGO-140-API-GL-5");
        initializeImageView(R.id.imageView0002, "https://www.top1.co.id/produk/detail/POWER-COOLANT");
        initializeImageView(R.id.imageView0004, "https://www.top1.co.id/produk/detail/ULTIMATE-COOLANT");
        initializeImageView(R.id.imageView00002, "https://www.top1.co.id/produk/detail/BRAKE-FLUID-DOT-3");
        initializeImageView(R.id.imageView00004, "https://www.top1.co.id/produk/detail/BRAKE-FLUID-DOT-4");

        // Inisialisasi inputTypeOli dan konfigurasi dialog pemilihan
        EditText inputTypeOli = findViewById(R.id.inputtypeoli);
        inputTypeOli.setFocusable(false);
        inputTypeOli.setClickable(true);
        inputTypeOli.setCompoundDrawablesWithIntrinsicBounds(R.drawable.search, 0, R.drawable.segitiga_bawah, 0);

        inputTypeOli.setOnClickListener(view -> {
            inputTypeOli.setCompoundDrawablesWithIntrinsicBounds(R.drawable.search, 0, R.drawable.segitiga_atas, 0);
            AlertDialog.Builder builder = new AlertDialog.Builder(spareparts.this);
            builder.setTitle("Pilih Opsi");

            final String[] options = {"EVOLUTION SERIES", "ZENZATION SERIES", "HP SPORT SERIES"};
            ArrayAdapter<String> adapter = new ArrayAdapter<>(spareparts.this, R.layout.item_with_ripple, options);

            builder.setAdapter(adapter, (dialog, which) -> {
                inputTypeOli.setHint(options[which]);
                setScrollViewVisibility(which);
            });

            builder.setOnDismissListener(dialog -> inputTypeOli.setCompoundDrawablesWithIntrinsicBounds(R.drawable.search, 0, R.drawable.segitiga_bawah, 0));
            builder.show();
        });

        // Inisialisasi tombol button1 dan button2 untuk mengatur visibilitas komponen
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);

        button1.setOnClickListener(v -> {
            setVisibility(View.VISIBLE, View.GONE, View.GONE, View.GONE, View.GONE, View.GONE, View.GONE);
        });

        button2.setOnClickListener(v -> {
            setVisibility(View.GONE, View.GONE, View.GONE, View.VISIBLE, View.GONE, View.GONE, View.GONE);
        });

        button3.setOnClickListener(v -> {
            setVisibility(View.GONE, View.GONE, View.GONE, View.GONE, View.VISIBLE, View.GONE, View.GONE);
        });

        button4.setOnClickListener(v -> {
            setVisibility(View.GONE, View.GONE, View.GONE, View.GONE, View.GONE, View.VISIBLE, View.GONE);
        });

        button5.setOnClickListener(v -> {
            setVisibility(View.GONE, View.GONE, View.GONE, View.GONE, View.GONE, View.GONE, View.VISIBLE);
        });

    }

    // Metode untuk menginisialisasi ImageView dengan URL
    private void initializeImageView(int imageViewId, String url) {
        ImageView imageView = findViewById(imageViewId);
        imageView.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);
        });
    }

    // Metode untuk mengatur visibilitas ScrollView berdasarkan pilihan
    private void setScrollViewVisibility(int selectedIndex) {
        findViewById(R.id.scroolviewevolution).setVisibility(selectedIndex == 0 ? View.VISIBLE : View.GONE);
        findViewById(R.id.scroolviewzenzation).setVisibility(selectedIndex == 1 ? View.VISIBLE : View.GONE);
        findViewById(R.id.scroolviewhpsport).setVisibility(selectedIndex == 2 ? View.VISIBLE : View.GONE);
    }

    // Metode untuk mengatur visibilitas komponen
    private void setVisibility(int inputTypeOliVisibility, int evolutionVisibility, int zenzationVisibility, int oliTransmisiVisibility, int oligardanVisibility, int airradiatorVisibility, int minyakremVisibility) {
        findViewById(R.id.inputtypeoli).setVisibility(inputTypeOliVisibility);
        findViewById(R.id.scroolviewevolution).setVisibility(evolutionVisibility);
        findViewById(R.id.scroolviewzenzation).setVisibility(zenzationVisibility);
        findViewById(R.id.olitransmisi).setVisibility(oliTransmisiVisibility);
        findViewById(R.id.oligardan).setVisibility(oligardanVisibility);
        findViewById(R.id.airradiator).setVisibility(airradiatorVisibility);
        findViewById(R.id.minyakrem).setVisibility(minyakremVisibility);
    }
}
