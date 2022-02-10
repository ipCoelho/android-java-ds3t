package com.example.libri_ds3t.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class SQLHelper extends SQLiteOpenHelper
{
    /** ATRIBUTOS DE CONEXÃO E CRIAÇÃO DO BANCO DE DADOS **/
    private static final String DB_NAME = "libri";
    private static final int DB_VERSION = 1;
    private static SQLHelper INSTANCE;

    /** MÉTODO DE RECUPERAÇÃO DA CONEXÃO COM O SQLITE **/
    public static SQLHelper getInstance(Context context){
        if(INSTANCE == null){
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
                "(cod_usuario INTEGER PRIMARY KEY," +
                "nome TEXT," +
                "sobrenome TEXT," +
                "email TEXT," +
                "login TEXT," +
                "senha TEXT," +
                "created_date DATETIME);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {}//FIM DO MÉTODO onUpgrade

    /** CRIAÇÃ DO MÉTODO DE INSERÇÃO DE DADOS DE USUÁRIO**/
    public boolean addUser(String nome, String sobrenome, String email,
                           String login, String senha, String created_data){

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        try{
            sqLiteDatabase.beginTransaction();

            ContentValues values = new ContentValues();

            values.put("nome", nome);
            values.put("sobrenome", sobrenome);
            values.put("email", email);
            values.put("login", login);
            values.put("senha", senha);
            values.put("created_date", created_data);

            sqLiteDatabase.insertOrThrow("tbl_usuario",
                                         null,
                                         values);

            sqLiteDatabase.setTransactionSuccessful();

            return true;


        }catch (Exception e){

            Log.d("SQLERRO", e.getMessage());
            return false;

        }finally {

            if(sqLiteDatabase.isOpen()){
                sqLiteDatabase.endTransaction();
            }

        }

    }

}//FIM DA CLASSE SQLHelper












