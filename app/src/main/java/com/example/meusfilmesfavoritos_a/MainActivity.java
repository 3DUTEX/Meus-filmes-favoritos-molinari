package com.example.meusfilmesfavoritos_a;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.nio.channels.SelectionKey;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText editTextNome;
    Spinner spinner;
    RadioButton radioFilme, radioSerie;
    RatingBar ratingNota;
    Button buttonCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        associaJavaXml();

        carregaCategorias();

        buttonCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean validado = validarCampos();
                if(validado){
                    Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean validarCampos() {
        String nome = editTextNome.getText().toString();
        if (nome.trim().length() < 2) {
            editTextNome.setError("Mínimo 2 letras");
            return false;
        }
        else if(spinner.getSelectedItemPosition() == 0){
            Toast.makeText(this, "Selecione um gênero", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if(!radioSerie.isChecked() && !radioFilme.isChecked()){
            Toast.makeText(this, "Marque um botão", Toast.LENGTH_SHORT).show();
       }

        return true;
    }

//        if(!radioSerie.isChecked() && !radioFilme.isChecked()){
//            Toast.makeText(MainActivity.this, "É série ou filme", Toast.LENGTH_SHORT).show();
//        }

    private void carregaCategorias() {
        ArrayList vetorGeneros = new ArrayList();
        vetorGeneros.add("Selecione o gênero");
        vetorGeneros.add("Ação");
        vetorGeneros.add("Aventura");
        vetorGeneros.add("Comédia");
        vetorGeneros.add("Drama");
        vetorGeneros.add("Romance");
        vetorGeneros.add("Sci-fi");
        vetorGeneros.add("Suspense");
        vetorGeneros.add("Terror");

        ArrayAdapter adapter = new
                ArrayAdapter(MainActivity.this,
                android.R.layout.simple_spinner_dropdown_item, vetorGeneros);

    }

    private void associaJavaXml() {
        editTextNome = findViewById(R.id.editTextNome);
        spinner = findViewById(R.id.spinner);
        radioFilme = findViewById(R.id.radioFilme);
        radioSerie = findViewById(R.id.radioSerie);
        ratingNota = findViewById(R.id.ratingNota);
        buttonCadastrar = findViewById(R.id.buttonCadastrar);
    }
}