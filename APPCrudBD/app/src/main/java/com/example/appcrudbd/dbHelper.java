package com.example.appcrudbd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class dbHelper extends  SQLiteOpenHelper{

    public dbHelper(Context context,String name,SQLiteDatabase.CursorFactory factory,int version){
        super(context,name,factory,version);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("create table contactos (codigo int primary key,nombre text,celular text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion)
    {

    }
}
