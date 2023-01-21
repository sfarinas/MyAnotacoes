package com.example.myanotacoes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private AnotacaoPreferencia preferencia;
    private EditText editAnotacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferencia = new AnotacaoPreferencia( getApplicationContext() );

        FloatingActionButton BotaoSalvar = findViewById(R.id.BotaoSalvar);
        editAnotacao = findViewById(R.id.editAnotacao);
        BotaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Validar entrada de dados
                String textoRecuperado = editAnotacao.getText().toString();
                if ( textoRecuperado.equals("") ){
                    Snackbar.make(view, "Digite sua primeira Anotação", Snackbar.LENGTH_LONG).show();
                }else {
                    preferencia.salvarAnotacao( textoRecuperado );
                    Snackbar.make(view, "Anotação Salva com Sucesso", Snackbar.LENGTH_LONG).show();
                }

                //Snackbar.make(view, "Preencha a anotação", Snackbar.LENGTH_LONG).show();
            }
        });
        //Recuperar Anotacao
        String anotacao = preferencia.recuperarAnotacao();
        if ( !anotacao.equals("") ){
            editAnotacao.setText( anotacao );
        }
    }
}