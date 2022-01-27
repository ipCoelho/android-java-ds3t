package com.example.libri_ds3t;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.libri_ds3t.helpers.DateFormatter;

public class CadastroUsuario extends AppCompatActivity {

//    Graphical Interface components attributes
    private EditText txtNome;
    private EditText txtSobreNome;
    private EditText txtEmail;
    private EditText txtLogin;
    private EditText txtSenha;
    private Button btnCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadratro_usuario);

//        Receives the graphical components of the Activity
        this.txtNome = findViewById(R.id.txtNome);
        this.txtSobreNome = findViewById(R.id.txtSobrenome);
        this.txtEmail = findViewById(R.id.txtEmail);
        this.txtLogin = findViewById(R.id.txtLogin);
        this.txtSenha = findViewById(R.id.txtSenha);
        this.txtNome = findViewById(R.id.txtNome);

        this.btnCadastrar = findViewById(R.id.btnCadastrar);

        btnCadastrar.setOnClickListener( (view) -> {
            if (!validate()) {
                Toast.makeText(this, "TODOS OS CAMPOS DEVEM SER PREENCHIDOS!", Toast.LENGTH_LONG).show();
                return;
            }

//            Recording the date in SQLite
            String sNome = txtNome.getText().toString();
            String sSobreNome = txtNome.getText().toString();
            String sEmail = txtNome.getText().toString();
            String sLogin = txtNome.getText().toString();
            String sSenha = txtNome.getText().toString();

//        Record Date
        DateFormatter df = new DateFormatter();
        String sDate = df.getDate();


        });
    }

//    Validation Function
    public boolean validate(){
        return (
            !txtNome.getText().toString().isEmpty() &&
            !txtSobreNome.getText().toString().isEmpty() &&
            !txtEmail.getText().toString().isEmpty() &&
            !txtLogin.getText().toString().isEmpty() &&
            !txtSenha.getText().toString().isEmpty()
        );
    }
}