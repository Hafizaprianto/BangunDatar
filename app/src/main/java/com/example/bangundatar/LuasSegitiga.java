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

public class LuasSegitiga extends AppCompatActivity {
    private EditText editTextAlas, editTextTinggi, editTexthasilSegitiga;
    private Button buttonHitung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_luas_segitiga);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Menghubungkan variabel dengan ID di layout XML
        editTextAlas = findViewById(R.id.editTextalas);
        editTextTinggi = findViewById(R.id.editTexttinggi);
        editTexthasilSegitiga = findViewById(R.id.editTexthasilsegitiga);
        buttonHitung = findViewById(R.id.button5);

        // Menetapkan aksi saat tombol diklik
        buttonHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitungLuasSegitiga();
            }
        });
    }

    private void hitungLuasSegitiga() {
        // Memeriksa apakah input kosong
        if (editTextAlas.getText().toString().isEmpty() || editTextTinggi.getText().toString().isEmpty()) {
            Toast.makeText(this, "Masukkan alas dan tinggi", Toast.LENGTH_SHORT).show();
            return;
        }

        // Mendapatkan nilai alas dan tinggi dari EditText
        double alas = Double.parseDouble(editTextAlas.getText().toString());
        double tinggi = Double.parseDouble(editTextTinggi.getText().toString());

        // Menghitung luas segitiga
        double luas = 0.5 * alas * tinggi;

        // Menampilkan hasil pada EditText hasil
        editTexthasilSegitiga.setText(String.valueOf(luas));
    }
}
