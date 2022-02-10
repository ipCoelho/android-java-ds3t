package com.example.libri_ds3t;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.libri_ds3t.database.SQLHelper;
import com.example.libri_ds3t.helpers.DateFormat;

public class CadastroLivro extends AppCompatActivity {
    private EditText txtTitulo;
    private EditText txtDescricao;
    private EditText txtFoto;
    private Button btnCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_livro);

        txtTitulo = findViewById(R.id.txtTitulo);
        txtDescricao = findViewById(R.id.txtDescricao);
        txtFoto = findViewById(R.id.txtFoto);
        btnCadastrar = findViewById(R.id.btnCadastrarLivro);

        btnCadastrar.setOnClickListener((view) -> {
            if(!validate()) {
                Toast.makeText(this,"TODOS OS CAMPOS DEVEM SER PREENCHIDOS!",Toast.LENGTH_LONG).show();
                return;
            }

            AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle(getString(R.string.titulo_cadastro_livro))
                .setMessage(getString(R.string.mensagem_cadastro_livro))
                .setPositiveButton(R.string.cadUsuario, (dialog1, wich) -> {
                    /** GRAVAÇÃO DOS DADOS NO SQLITE **/
                    String sTitulo = txtTitulo.getText().toString();
                    String sDescricao = txtDescricao.getText().toString();
                    String sFoto = txtFoto.getText().toString();

                    /** DATA DA GRAVAÇÃO **/
                    DateFormat dateFormat = new DateFormat();
                    String sData = dateFormat.getDate();

                    boolean cadastroLivro = SQLHelper.getInstance(this).addBook(1, sTitulo, sDescricao, sFoto, sData);

                    if (cadastroLivro) {
                        Toast.makeText(this, R.string.cadastro_ok, Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(this, R.string.cadastro_erro, Toast.LENGTH_LONG).show();
                    }
                })
                .setNegativeButton(R.string.cancelar, (dialog1, wich)->{})
                .create();
            dialog.show();
        });


    }

    public boolean validate() {
        return (
            !txtTitulo.getText().toString().isEmpty() &&
            !txtDescricao.getText().toString().isEmpty() &&
            !txtFoto.getText().toString().isEmpty()
        );
    }
}