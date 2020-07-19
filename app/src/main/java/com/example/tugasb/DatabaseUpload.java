package com.example.tugasb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseUpload extends SQLiteOpenHelper {
    private static final String DATABASE_NAME= "uploadbuku.db";
    private static final int DATABASE_VERSION= 1;
    public DatabaseUpload(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase datab){
        String sql ="create table buku(jdlbku text primary key, jnsbku text null, by text null, thntrbt text null, sinopsis text null);";
        Log.d("Data", "onCreate: "+sql);
        datab.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2){

    }
}
