package com.example.bangundatar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    // Method untuk membuka LuasSegitigaActivity
    public void goToLuasSegitiga(View view) {
        Intent intent = new Intent(this, LuasSegitiga.class);
        startActivity(intent);
    }

    public void goToPersegi(View view) {
        Intent intent = new Intent(this, Persegi.class);
        startActivity(intent);
    }

    public void goToPersegipanjang(View view) {
        Intent intent = new Intent(this, Persegipanjang.class);
        startActivity(intent);
    }

    public void goToLingkaran(View view) {
        Intent intent = new Intent(this, Lingkaran.class);
        startActivity(intent);
    }
}
