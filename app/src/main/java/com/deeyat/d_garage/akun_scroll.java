package com.deeyat.d_garage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.app.AlertDialog;

import androidx.core.content.FileProvider;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class akun_scroll extends AppCompatActivity {

    private static final int PICK_IMAGE = 1;
    private static final int TAKE_PHOTO = 2;
    private static final int PERMISSION_REQUEST_CODE = 100;

    private ImageView ivProfilePic;
    private String currentPhotoPath;
    private boolean isZoomedIn = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_akun_scroll);

        ivProfilePic = findViewById(R.id.ivProfilePic);
        ivProfilePic.setOnClickListener(v -> showImagePickerOptions());

        // Mengecek izin
        checkPermissions();

        // Inisialisasi tombol imageButton7 dan event listener navigasi ke home_page
        ImageButton imageButton7 = findViewById(R.id.imageButton7);
        imageButton7.setOnClickListener(v -> {
            Intent intent = new Intent(akun_scroll.this, home_page.class);
            startActivity(intent);
        });

        TextView textView12 = findViewById(R.id.textView12);
        textView12.setText(Html.fromHtml("<u>defrilugas46@gmail.com</u>"));

        EditText editTextpengaturanakun = findViewById(R.id.inputpengaturanakun);
        editTextpengaturanakun.setOnClickListener(v -> {
            Intent intent = new Intent(akun_scroll.this, pengaturan_akun.class);
            startActivity(intent);
        });

        EditText editTextVouchersaya = findViewById(R.id.inputVouchersaya);
        editTextVouchersaya.setOnClickListener(v -> {
            Intent intent = new Intent(akun_scroll.this, voucher_saya.class);
            startActivity(intent);
        });

        EditText editTextinputtentangkami = findViewById(R.id.inputtentangkami);
        editTextinputtentangkami.setOnClickListener(v -> {
            Intent intent = new  Intent(akun_scroll.this, tentang_kami.class);
            startActivity(intent);
        });

        EditText editTextinputmobilsaya = findViewById(R.id.inputmobilsaya);
        editTextinputmobilsaya.setOnClickListener(v -> {
            Intent intent = new  Intent(akun_scroll.this, mobil_saya.class);
            startActivity(intent);
        });

        ImageView imageView98 = findViewById(R.id.imageView98);
        imageView98.setOnClickListener(v -> {
            Intent intent = new Intent(akun_scroll.this, home_page.class);
            startActivity(intent);
        });

        ImageView imageView99 = findViewById(R.id.imageView99);
        imageView99.setOnClickListener(v -> {
            Intent intent = new Intent(akun_scroll.this, aktifitas1.class);
            startActivity(intent);
        });

        EditText editTextinputeditprofil = findViewById(R.id.inputeditprofil);
        editTextinputeditprofil.setOnClickListener(v -> {
            Intent intent = new  Intent(akun_scroll.this, edit_profil.class);
            startActivity(intent);
        });

        EditText editTextinputnotifikasi = findViewById(R.id.inputnotifikasi);
        editTextinputnotifikasi.setOnClickListener(v -> {
            Intent intent = new  Intent(akun_scroll.this, pengaturan_notifikasi.class);
            startActivity(intent);
        });

        EditText editTextinputhubungikami = findViewById(R.id.inputhubungikami);
        editTextinputhubungikami.setOnClickListener(v -> {
            Intent intent = new Intent(akun_scroll.this, hubungi_kami.class);
            startActivity(intent);
        });

        final EditText inputLogout = findViewById(R.id.inputlogout);
        final ImageView imageView30 = findViewById(R.id.imageView30);
        final ImageView imageView27 = findViewById(R.id.imageView27);
        final ImageView imageView28 = findViewById(R.id.imageView28);
        final TextView textView24 = findViewById(R.id.textView24);
        final ImageView imageView31 = findViewById(R.id.imageView31);
        final ImageView imageView33 = findViewById(R.id.imageView33);

        inputLogout.setOnClickListener(v -> {
            if (!isZoomedIn) {
                setGone(imageView30);
                setGone(imageView27);
                setGone(imageView28);
                setGone(textView24);
                setGone(imageView31);
                setGone(imageView33);

                setVisibleWithAnimation(imageView30);
                setVisibleWithAnimation(imageView27);
                setVisibleWithAnimation(imageView28);
                setVisibleWithAnimation(textView24);
                setVisibleWithAnimation(imageView31);
                setVisibleWithAnimation(imageView33);
                isZoomedIn = true;
            }
        });

        imageView33.setOnClickListener(v -> {
            if (isZoomedIn) {
                setGoneWithAnimation(imageView30);
                setGoneWithAnimation(imageView27);
                setGoneWithAnimation(imageView28);
                setGoneWithAnimation(textView24);
                setGoneWithAnimation(imageView31);
                setGoneWithAnimation(imageView33);

                isZoomedIn = false;
            }
        });

        imageView31.setOnClickListener(v -> {
            Intent intent = new Intent(akun_scroll.this, log_in_page.class);
            startActivity(intent);
            finish();
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
                saveImageToExternalStorage(selectedImageUri);
            } else if (requestCode == TAKE_PHOTO) {
                File photoFile = new File(currentPhotoPath);
                ivProfilePic.setImageURI(Uri.fromFile(photoFile));
                saveImageToExternalStorage(Uri.fromFile(photoFile));
            }
        }
    }

    // Menyimpan gambar ke penyimpanan eksternal
    private void saveImageToExternalStorage(Uri imageUri) {
        Bitmap bitmap = null;
        try {
            bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri);
            File externalStorageDir = Environment.getExternalStorageDirectory();
            File savedImageFile = new File(externalStorageDir, "profile_image_" + System.currentTimeMillis() + ".jpg");

            try (FileOutputStream fos = new FileOutputStream(savedImageFile)) {
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
                Toast.makeText(this, "Foto berhasil disimpan di eksternal storage", Toast.LENGTH_SHORT).show();
            }
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Gagal menyimpan foto", Toast.LENGTH_SHORT).show();
        }
    }

    private void setGone(View view) {
        view.setVisibility(View.GONE);
    }

    private void setGoneWithAnimation(View view) {
        view.setVisibility(View.GONE);
        Animation anim = new ScaleAnimation(1f, 0f, 1f, 0f);
        anim.setDuration(300);
        view.startAnimation(anim);
    }

    private void setVisibleWithAnimation(View view) {
        view.setVisibility(View.VISIBLE);
        Animation anim = new ScaleAnimation(0f, 1f, 0f, 1f);
        anim.setDuration(300);
        view.startAnimation(anim);
    }
}
