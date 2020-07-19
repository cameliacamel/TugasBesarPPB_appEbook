package com.example.tugasb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageButton;

public class Sinopsis extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sinopsis);

//        WebView webView = (WebView) findViewById(R.id.wv_buku1);
//        String text =" Cinta, walaupun sudah berlalu sekian lama, tetap saja, saat dikenang begitu manis.\n" +
//                "\n" +
//                "Milea, dia kembali ke tahun 1990 untuk menceritakan seorang laki-laki yang pernah menjadi seseorang yang sangat dicintainya, Dilan.";
//
//                webView.loadData("<p style=\"text-align: left\">"+ text +"</p>", "text/html", "UTF-8");

    }
    public void back_sinopsis(View view) {
        Intent intent = new Intent(Sinopsis.this, Baca.class);
        startActivity(intent);
    }


}
