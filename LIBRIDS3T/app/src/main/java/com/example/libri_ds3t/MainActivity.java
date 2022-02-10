package com.example.libri_ds3t;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText txtLogin;
    private EditText txtSenha;
    private Button btnEntrar;
    private Button btnCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtLogin = findViewById(R.id.txtUsuario);
        txtSenha = findViewById(R.id.txtSenhaLogin);
        btnEntrar = findViewById(R.id.btnEntrarLogin);
        btnCadastrar = findViewById(R.id.btnCadastrarLogin);
    }
}