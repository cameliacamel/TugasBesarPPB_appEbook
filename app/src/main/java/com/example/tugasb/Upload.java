package com.example.tugasb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;


public class Upload extends FragmentActivity implements View.OnClickListener {
Database db;
Button logout;
Button upload;
ImageButton backupload;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);
        db = new Database(this);

        logout = (Button)findViewById(R.id.btn_logout);
        upload = (Button)findViewById(R.id.btn_upload);
        backupload = findViewById(R.id.back_upload);

        upload.setOnClickListener(this);

        Boolean checkSession = db.checkSession("ada");
        if (checkSession == false) {
            Intent loginIntent = new Intent(Upload.this, Login.class);
            startActivity(loginIntent);
            finish();
        }

        //back upload
        backupload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backuploadIntent = new Intent(Upload.this, MainActivity.class);
                startActivity( backuploadIntent);
                finish();
            }
        });

        //logout tmbl
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean updtSession = db.upgradeSession("kosong", 1);
                if (updtSession == true){
                    signout();
                    Toast.makeText(getApplicationContext(), "Berhasil Keluar", Toast.LENGTH_SHORT). show();
                    Intent loginIntent = new Intent(Upload.this, Login.class);
                    startActivity(loginIntent);
                    finish();


                }
            }
        });
    }

    private void signout() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }


    @Override
    public void onClick(View v) {
        if (v == upload){

        }

    }
}
