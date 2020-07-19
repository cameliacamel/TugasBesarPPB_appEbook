package com.example.tugasb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new Database(this);

    }
    public void pindah1(View view) {
        Boolean updtSession = db.upgradeSession("kosong", 1);
        if (updtSession == true){

            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.clear();
            editor.apply();
            Toast.makeText(getApplicationContext(), "Berhasil Keluar", Toast.LENGTH_SHORT). show();
            Intent intent = new Intent(MainActivity.this, Login.class);
            startActivity(intent);
            finish();
        }

    }
    public void pindah2(View view) {
        Intent intent = new Intent(MainActivity.this, Baca.class);
        startActivity(intent);
    }
    public void pindah3(View view) {
        Intent intent = new Intent(MainActivity.this, Upload.class);
        startActivity(intent);
    }
    @Override
    protected void onStart() {
        super.onStart();
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        if (!(sharedPreferences.getString("username",null) != null))
        {
            Intent i = new Intent(MainActivity.this,MainActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(i);
        }
    }
}
