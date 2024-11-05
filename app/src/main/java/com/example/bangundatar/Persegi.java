package com.example.bangundatar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Persegi extends AppCompatActivity {
    private EditText editTextSisi, editTexthasilPersegi;
    private Button buttonHitungPersegi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_persegi);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Menghubungkan variabel dengan ID di layout XML
        editTextSisi = findViewById(R.id.editTextsisi);
        editTexthasilPersegi = findViewById(R.id.editTexthasilpersegi);
        buttonHitungPersegi = findViewById(R.id.button6);

        // Menetapkan aksi saat tombol diklik
        buttonHitungPersegi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitungLuasPersegi();
            }
        });
    }

    private void hitungLuasPersegi() {
        // Memeriksa apakah input sisi kosong
        if (editTextSisi.getText().toString().isEmpty()) {
            Toast.makeText(this, "Masukkan panjang sisi persegi", Toast.LENGTH_SHORT).show();
            return;
        }

        // Mendapatkan nilai sisi dari EditText
        double sisi = Double.parseDouble(editTextSisi.getText().toString());

        // Menghitung luas persegi
        double luas = sisi * sisi;

        // Menampilkan hasil pada EditText hasil
        editTexthasilPersegi.setText(String.valueOf(luas));
    }
}
