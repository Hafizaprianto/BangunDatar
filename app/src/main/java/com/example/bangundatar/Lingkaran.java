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

public class Lingkaran extends AppCompatActivity {
    private EditText editTextJariJari, editTextHasilLingkaran;
    private Button buttonHitungLingkaran;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lingkaran);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Menghubungkan variabel dengan ID di layout XML
        editTextJariJari = findViewById(R.id.editTextjarijari);
        editTextHasilLingkaran = findViewById(R.id.editTexthasillingkaran);
        buttonHitungLingkaran = findViewById(R.id.button8);

        // Menetapkan aksi saat tombol diklik
        buttonHitungLingkaran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitungLuasLingkaran();
            }
        });
    }

    private void hitungLuasLingkaran() {
        // Memeriksa apakah input jari-jari kosong
        if (editTextJariJari.getText().toString().isEmpty()) {
            Toast.makeText(this, "Masukkan jari-jari lingkaran", Toast.LENGTH_SHORT).show();
            return;
        }

        // Mendapatkan nilai jari-jari dari EditText
        double jariJari = Double.parseDouble(editTextJariJari.getText().toString());

        // Menghitung luas lingkaran dengan π * r^2
        double luas = Math.PI * jariJari * jariJari;

        // Menampilkan hasil pada EditText hasil
        editTextHasilLingkaran.setText(String.format("%.2f", luas));
    }
}
