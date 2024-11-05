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

public class Persegipanjang extends AppCompatActivity {
    private EditText editTextPanjang, editTextLebar, editTextHasilPersegiPanjang;
    private Button buttonHitungPersegiPanjang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_persegipanjang);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Menghubungkan variabel dengan ID di layout XML
        editTextPanjang = findViewById(R.id.editTextpanjang);
        editTextLebar = findViewById(R.id.editTextlebar);
        editTextHasilPersegiPanjang = findViewById(R.id.editTexthasilpersegipanjang);
        buttonHitungPersegiPanjang = findViewById(R.id.button7);

        // Menetapkan aksi saat tombol diklik
        buttonHitungPersegiPanjang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitungLuasPersegiPanjang();
            }
        });
    }

    private void hitungLuasPersegiPanjang() {
        // Memeriksa apakah input panjang dan lebar kosong
        if (editTextPanjang.getText().toString().isEmpty() || editTextLebar.getText().toString().isEmpty()) {
            Toast.makeText(this, "Masukkan panjang dan lebar persegi panjang", Toast.LENGTH_SHORT).show();
            return;
        }

        // Mendapatkan nilai panjang dan lebar dari EditText
        double panjang = Double.parseDouble(editTextPanjang.getText().toString());
        double lebar = Double.parseDouble(editTextLebar.getText().toString());

        // Menghitung luas persegi panjang
        double luas = panjang * lebar;

        // Menampilkan hasil pada EditText hasil
        editTextHasilPersegiPanjang.setText(String.valueOf(luas));
    }
}
