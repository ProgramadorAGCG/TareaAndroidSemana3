package com.example.problema2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity{

    private Button btnSalir, btnAcercaDe, btnEnviar;
    private EditText informacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSalir = (Button) findViewById(R.id.salir);
        btnAcercaDe = (Button) findViewById(R.id.acercade);
        btnEnviar = (Button) findViewById(R.id.btnEnviar);

        enviar();
        acercaDe();
        salir();
    }

    private void enviar(){
        btnEnviar.setOnClickListener((View v)->{

            EditText contenido = (EditText)findViewById(R.id.etMensaje);

            String texto = contenido.getText().toString();

            if(texto.length() == 0){
                AlertDialog.Builder mensajeError = new AlertDialog.Builder(this);
                mensajeError.setTitle("Error");
                mensajeError.setMessage("No se ha ingresado nada en el campo de texto");
                mensajeError.setPositiveButton("Aceptar", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface arg0, int arg1) {

                    }
                });
                mensajeError.show();
            }else{
                Intent i = new Intent(this,SegundoActivity.class);
                i.putExtra("Informacion", texto);
                startActivity(i);
            }


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