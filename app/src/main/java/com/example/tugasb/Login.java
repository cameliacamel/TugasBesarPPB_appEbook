package com.example.tugasb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    Database db;
    Button login;
    EditText username,password;
    TextView register;

    long time;
    Toast back;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = new Database(this);

        username = (EditText)findViewById(R.id.et_login_username);
        password = (EditText)findViewById(R.id.et_login_password);
        login = (Button)findViewById(R.id.btn_login);
        register = (TextView)findViewById(R.id.tv_register);
        //register
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(Login.this, Register.class);
                startActivity(registerIntent);
                finish();
            }
        });

        //back login

        //login
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strUsername = username.getText().toString();
                String strPassword = password.getText().toString();
                Boolean masuk = db.checkLogin(strUsername, strPassword);

                if (masuk == true) {
                    Boolean updateSession = db.upgradeSession("ada", 1);
//
                    if (updateSession == true){
                        Toast.makeText(getApplicationContext(), "Berhasil Masuk", Toast.LENGTH_SHORT).show();
                        Intent uploadIntent = new Intent(Login.this, MainActivity.class);
                        startActivity(uploadIntent);
                        login();
                        finish();
                    }
                }
                else {
                    Toast.makeText(getApplicationContext(), "Masuk Gagal", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        if (sharedPreferences.getString("username",null) != null)
        {
            Intent i = new Intent(Login.this,MainActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(i);
        }
    }

    public void login(){
        String strUsername = username.getText().toString();
        String strPassword = password.getText().toString();

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username",strUsername);
        editor.putString("password",strPassword);
        editor.apply();

    }

    @Override
    public void onBackPressed() {


        if (time + 2000 > System.currentTimeMillis())
        {

            Intent i = new Intent(Intent.ACTION_MAIN);
            i.addCategory(Intent.CATEGORY_HOME);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(i);
            back.cancel();
        }
        else
        {
           back = Toast.makeText(this, "press back again", Toast.LENGTH_SHORT);
           back.show();
        }
        time = System.currentTimeMillis();

    }
}
