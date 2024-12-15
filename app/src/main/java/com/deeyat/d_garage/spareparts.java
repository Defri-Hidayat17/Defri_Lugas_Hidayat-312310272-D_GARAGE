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

    Button button1, button2, button3, button4, button5, button6, button7, button8;

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

        TextView textView000068 = findViewById(R.id.textView000068);
        textView000068.setText(Html.fromHtml("<u>Busi</u>"));

        TextView textView0000068 = findViewById(R.id.textView0000068);
        textView0000068.setText(Html.fromHtml("<u>Filter Oli</u>"));

        TextView textView00000068 = findViewById(R.id.textView00000068);
        textView00000068.setText(Html.fromHtml("<u>Car Care</u>"));

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
        initializeImageView(R.id.imageView000002, "https://www.top1.co.id/produk/detail/DURATION-SPARK-PLUG-ULTRA-IRIDIUM");
        initializeImageView(R.id.imageView000004, "https://www.top1.co.id/produk/detail/DURATION-SPARK-PLUG-RACING");
        initializeImageView(R.id.imageView0000002, "https://www.top1.co.id/produk/detail/DURATION-OIL-FILTER");
        initializeImageView(R.id.imageView0000004, "https://www.top1.co.id/produk/detail/TOP-1-OIL-FILTER");
        initializeImageView(R.id.imageView00000002, "https://www.top1.co.id/produk/detail/INTERIOR-PROTECTANT");

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
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);

        button1.setOnClickListener(v -> {
            resetAllButtonBackgrounds(button1);
            v.setBackgroundResource(R.drawable.button_spareparts1);
            setVisibility(View.VISIBLE, View.GONE, View.GONE, View.GONE, View.GONE, View.GONE, View.GONE, View.GONE, View.GONE, View.GONE);
        });

        button2.setOnClickListener(v -> {
            resetAllButtonBackgrounds(button2);
            v.setBackgroundResource(R.drawable.button_spareparts1);
            setVisibility(View.GONE, View.GONE, View.GONE, View.VISIBLE, View.GONE, View.GONE, View.GONE, View.GONE, View.GONE, View.GONE);
        });

        button3.setOnClickListener(v -> {
            resetAllButtonBackgrounds(button3);
            v.setBackgroundResource(R.drawable.button_spareparts1);
            setVisibility(View.GONE, View.GONE, View.GONE, View.GONE, View.VISIBLE, View.GONE, View.GONE, View.GONE, View.GONE, View.GONE);
        });

        button4.setOnClickListener(v -> {
            resetAllButtonBackgrounds(button4);
            v.setBackgroundResource(R.drawable.button_spareparts1);
            setVisibility(View.GONE, View.GONE, View.GONE, View.GONE, View.GONE, View.VISIBLE, View.GONE, View.GONE, View.GONE, View.GONE);
        });

        button5.setOnClickListener(v -> {
            resetAllButtonBackgrounds(button5);
            v.setBackgroundResource(R.drawable.button_spareparts1);
            setVisibility(View.GONE, View.GONE, View.GONE, View.GONE, View.GONE, View.GONE, View.VISIBLE, View.GONE, View.GONE, View.GONE);
        });

        button6.setOnClickListener(v -> {
            resetAllButtonBackgrounds(button6);
            v.setBackgroundResource(R.drawable.button_spareparts1);
            setVisibility(View.GONE, View.GONE, View.GONE, View.GONE, View.GONE, View.GONE, View.GONE, View.VISIBLE, View.GONE, View.GONE);
        });

        button7.setOnClickListener(v -> {
            resetAllButtonBackgrounds(button7);
            v.setBackgroundResource(R.drawable.button_spareparts1);
            setVisibility(View.GONE, View.GONE, View.GONE, View.GONE, View.GONE, View.GONE, View.GONE, View.GONE, View.VISIBLE, View.GONE);

        });

        button8.setOnClickListener(v -> {
            resetAllButtonBackgrounds(button8);
            v.setBackgroundResource(R.drawable.button_spareparts1);
            setVisibility(View.GONE, View.GONE, View.GONE, View.GONE, View.GONE, View.GONE, View.GONE, View.GONE, View.GONE, View.VISIBLE);
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

    private void resetAllButtonBackgrounds(Button buttonToSkip) {
        if (button1 != null && button1 != buttonToSkip) button1.setBackgroundResource(R.drawable.button_spareparts);
        if (button2 != null && button2 != buttonToSkip) button2.setBackgroundResource(R.drawable.button_spareparts);
        if (button3 != null && button3 != buttonToSkip) button3.setBackgroundResource(R.drawable.button_spareparts);
        if (button4 != null && button4 != buttonToSkip) button4.setBackgroundResource(R.drawable.button_spareparts);
        if (button5 != null && button5 != buttonToSkip) button5.setBackgroundResource(R.drawable.button_spareparts);
        if (button6 != null && button6 != buttonToSkip) button6.setBackgroundResource(R.drawable.button_spareparts);
        if (button7 != null && button7 != buttonToSkip) button7.setBackgroundResource(R.drawable.button_spareparts);
        if (button8 != null && button8 != buttonToSkip) button8.setBackgroundResource(R.drawable.button_spareparts);
    }



    // Metode untuk mengatur visibilitas ScrollView berdasarkan pilihan
    private void setScrollViewVisibility(int selectedIndex) {
        findViewById(R.id.scroolviewevolution).setVisibility(selectedIndex == 0 ? View.VISIBLE : View.GONE);
        findViewById(R.id.scroolviewzenzation).setVisibility(selectedIndex == 1 ? View.VISIBLE : View.GONE);
        findViewById(R.id.scroolviewhpsport).setVisibility(selectedIndex == 2 ? View.VISIBLE : View.GONE);
        resetAllButtonBackgrounds(null);
    }


    // Metode untuk mengatur visibilitas komponen
    private void setVisibility(int inputTypeOliVisibility, int evolutionVisibility, int zenzationVisibility, int oliTransmisiVisibility, int oligardanVisibility, int airradiatorVisibility, int minyakremVisibility, int busiVisibility, int filteroliVisibility, int carcareVisibility) {
        findViewById(R.id.inputtypeoli).setVisibility(inputTypeOliVisibility);
        findViewById(R.id.scroolviewevolution).setVisibility(evolutionVisibility);
        findViewById(R.id.scroolviewzenzation).setVisibility(zenzationVisibility);
        findViewById(R.id.olitransmisi).setVisibility(oliTransmisiVisibility);
        findViewById(R.id.oligardan).setVisibility(oligardanVisibility);
        findViewById(R.id.airradiator).setVisibility(airradiatorVisibility);
        findViewById(R.id.minyakrem).setVisibility(minyakremVisibility);
        findViewById(R.id.busi).setVisibility(busiVisibility);
        findViewById(R.id.filteroli).setVisibility(filteroliVisibility);
        findViewById(R.id.carcare).setVisibility(carcareVisibility);

    }
}