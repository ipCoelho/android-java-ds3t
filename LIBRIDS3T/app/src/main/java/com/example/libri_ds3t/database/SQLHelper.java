package com.example.libri_ds3t.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLHelper extends SQLiteOpenHelper
{
//    Attributes for connection and creating the Date Base
    private static final String DB_NAME = "Libri";
    private static final int DB_VERSION = 1;
    private static SQLHelper INSTANCE;

//    Method for recovering the SQLite connection
    public static SQLHelper getInstance(Context context){
        if (INSTANCE == null){
            INSTANCE = new SQLHelper(context);
        }

        return INSTANCE;
    }


    public SQLHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE tbl_usuario" +
                "(cod_usuario INTEGER PRIMARY KEY, " +
                "nome TEXT," +
                "sobrenome TEXT," +
                "email TEXT," +
                "login TEXT," +
                "senha TEXT," +
                "created_date DATETIME);"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
