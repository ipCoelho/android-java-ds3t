package com.example.libri_ds3t;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class FeedLivro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_livro);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Log.d("IDITEM:", String.valueOf(item.getItemId()));

        switch (item.getItemId()) {
            case R.id.menu_cadastrar_livro:
                startActivity(new Intent(this, CadastroLivro.class));
                break;

            case R.id.menu_feed_livro:
                startActivity(new Intent(this, FeedLivro.class));
                break;

            case R.id.menu_sair:
                startActivity(new Intent(this, MainActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}