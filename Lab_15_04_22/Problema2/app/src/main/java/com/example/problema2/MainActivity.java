package com.example.problema2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button btnSalir, btnAcercaDe, btnEnviar;
    private EditText informacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        informacion = (EditText) findViewById(R.id.etMensaje);
        btnSalir = (Button) findViewById(R.id.salir);
        btnAcercaDe = (Button) findViewById(R.id.acercade);
        btnEnviar = (Button) findViewById(R.id.btnEnviar);

        enviar();
        acercaDe();
    }

    private void enviar(){
        btnEnviar.setOnClickListener((View v)->{
            Intent i = new Intent(this,SegundoActivity.class);
            EditText contenido = (EditText)findViewById(R.id.etMensaje);
            i.putExtra("Informacion", informacion.getText().toString() );
            startActivity(i);
        });
    }

    private void acercaDe(){
        btnAcercaDe.setOnClickListener((View v)-> {
            Intent i = new Intent(this, acerdaDe.class);
            startActivity(i);
        });
    }

    private void salir(){
        btnSalir.setOnClickListener((View v)-> {
            finish();
        });
    }


}