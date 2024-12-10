package com.deeyat.d_garage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
import android.app.AlertDialog;
import androidx.annotation.NonNull;
import androidx.core.content.FileProvider;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

public class edit_profil extends AppCompatActivity {

    private String selectedJenisKelamin = "";

    private static final int PICK_IMAGE = 1;
    private static final int TAKE_PHOTO = 2;
    private static final int PERMISSION_REQUEST_CODE = 100;

    private ImageView ivProfilePic;
    private EditText inputNegara;
    private EditText inputJenisKelamin;
    private EditText inputTanggalLahir;
    private ImageButton imageButton1;
    private Button button10;
    private String currentPhotoPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profil);

        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(edit_profil.this, edit_profil_berhasil_diubah.class);
                startActivity(intent);
            }
        });

        // Inisialisasi view
        ivProfilePic = findViewById(R.id.ivProfilePic);
        inputNegara = findViewById(R.id.inputnegara);
        inputJenisKelamin = findViewById(R.id.inputjeniskelamin);
        inputTanggalLahir = findViewById(R.id.inputtanggallahir);
        imageButton1 = findViewById(R.id.imageButton1);
        button10 = findViewById(R.id.button10);

        // Listener untuk ivProfilePic
        ivProfilePic.setOnClickListener(v -> showImagePickerOptions());

        // Listener untuk navigasi ke home_page
        imageButton1.setOnClickListener(v -> {
            Intent intent = new Intent(edit_profil.this, akun_scroll.class);
            startActivity(intent);
            finish();
        });

        // Mengecek izin
        checkPermissions();

        // Konfigurasi input negara
        configureCountryInput();

        // Konfigurasi input jenis kelamin
        configureGenderInput();

        // Konfigurasi input tanggal lahir
        configureDateInput();

        // Listener tombol kirim
        button10.setOnClickListener(v -> {
            Intent intent = new Intent(edit_profil.this, akun_scroll.class);
            startActivity(intent);
        });
    }

    private void checkPermissions() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED ||
                ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED ||
                ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    PERMISSION_REQUEST_CODE);
        }
    }

    private void showImagePickerOptions() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Pilih Gambar")
                .setItems(new CharSequence[]{"Kamera", "Galeri"}, (dialog, which) -> {
                    if (which == 0) {
                        openCamera();
                    } else {
                        openGallery();
                    }
                })
                .create()
                .show();
    }

    private void openCamera() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            try {
                File photoFile = createImageFile();
                if (photoFile != null) {
                    Uri photoURI = FileProvider.getUriForFile(this, "com.deeyat.d_garage.fileprovider", photoFile);
                    takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                    startActivityForResult(takePictureIntent, TAKE_PHOTO);
                }
            } catch (IOException ex) {
                Toast.makeText(this, "Error creating image file", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void openGallery() {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        galleryIntent.setType("image/*");
        startActivityForResult(galleryIntent, PICK_IMAGE);
    }

    private File createImageFile() throws IOException {
        String imageFileName = "JPEG_" + System.currentTimeMillis() + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(imageFileName, ".jpg", storageDir);
        currentPhotoPath = image.getAbsolutePath();
        return image;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == PICK_IMAGE && data != null) {
                Uri selectedImageUri = data.getData();
                ivProfilePic.setImageURI(selectedImageUri);
            } else if (requestCode == TAKE_PHOTO) {
                File photoFile = new File(currentPhotoPath);
                ivProfilePic.setImageURI(Uri.fromFile(photoFile));
            }
        }
    }

    private void configureCountryInput() {
        final String[] negaraList = {
                "Indonesia", "Malaysia", "Singapura", "Thailand", "Filipina",
                "Brunei Darussalam", "Vietnam", "Laos", "Kamboja", "Myanmar"
        };

        final String[] negaraCodes = {
                "+62", "+60", "+65", "+66", "+63",
                "+673", "+84", "+856", "+855", "+95"
        };

        final int[] countryFlags = {
                R.drawable.indonesia, R.drawable.malaysia, R.drawable.singapore,
                R.drawable.thailand, R.drawable.philippines, R.drawable.brunei,
                R.drawable.vietnam, R.drawable.laos, R.drawable.cambodia, R.drawable.myanmar
        };

        inputNegara.setFocusable(false);
        inputNegara.setClickable(true);

        inputNegara.setOnClickListener(view -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(edit_profil.this);
            builder.setTitle("Pilih Negara");

            ArrayAdapter<String> adapter = new ArrayAdapter<>(edit_profil.this, R.layout.item_with_ripple, negaraList);
            builder.setAdapter(adapter, (dialog, which) -> {
                inputNegara.setHint(negaraCodes[which]);
                inputNegara.setCompoundDrawablesWithIntrinsicBounds(countryFlags[which], 0, 0, 0);
                Toast.makeText(edit_profil.this, "Negara: " + negaraList[which], Toast.LENGTH_SHORT).show();
            });
            builder.show();
        });
    }

    private void configureGenderInput() {
        inputJenisKelamin.setFocusable(false);
        inputJenisKelamin.setClickable(true);
        inputJenisKelamin.setCompoundDrawablesWithIntrinsicBounds(R.drawable.gender, 0, R.drawable.segitiga_bawah, 0);

        inputJenisKelamin.setOnClickListener(view -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(edit_profil.this);
            builder.setTitle("Pilih Jenis Kelamin");

            final String[] jenisKelaminList = {"Laki-laki", "Perempuan"};
            ArrayAdapter<String> adapter = new ArrayAdapter<>(edit_profil.this, R.layout.item_with_ripple, jenisKelaminList);

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
    }

    private void configureDateInput() {
        inputTanggalLahir.setFocusable(false);
        inputTanggalLahir.setClickable(true);

        inputTanggalLahir.setOnClickListener(view -> {
            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(edit_profil.this,
                    (view1, selectedYear, selectedMonth, selectedDay) -> {
                        String date = selectedDay + "/" + (selectedMonth + 1) + "/" + selectedYear;
                        inputTanggalLahir.setText(date);
                    }, year, month, day);
            datePickerDialog.show();
        });
    }
}
