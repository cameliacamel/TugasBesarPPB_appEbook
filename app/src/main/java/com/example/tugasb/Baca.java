package com.example.tugasb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Baca extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baca);
    }

    public void back_baca(View view) {
        Intent intent = new Intent(Baca.this, MainActivity.class);
        startActivity(intent);
    }
    public void buku1(View view) {
        Intent intent = new Intent(Baca.this, Sinopsis.class);
        startActivity(intent);
    }
    public void buku2(View view) {
        Intent intent = new Intent(Baca.this, Sinopsis2.class);
        startActivity(intent);
    }

}
