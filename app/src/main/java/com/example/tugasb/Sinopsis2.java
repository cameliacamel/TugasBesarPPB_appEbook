package com.example.tugasb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Sinopsis2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sinopsis2);

    }
    public void back_sinopsis2(View view) {
        Intent intent = new Intent(Sinopsis2.this, Baca.class);
        startActivity(intent);
    }
}
