package com.example.app_23;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Toast;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /**
     * Funcion llamada al pulsar en el boton de Toast
     * @param View v - Parametro obligado
     */
    public void onClicK_Toast(View v){
        mensaje("Se ha pulsado Toast");
    }
    /**
     * Funcion llamada al pulsar en el boton de DialogBuilder
     * @param View v - Parametro obligado
     */
    public void onClicK_DialogBuilder(View v){
        alerta("Se ha pulsado DialogBuilder");
    }

    /**
     * Funcion llamada al pulsar en el boton de AlertBox
     * @param View v - Parametro obligado
     */
    public void onClicK_AlertBox(View v){
        eleccion("Se ha pulsado AlertBox.\nElije opción:");
    }

    /**
     * Mensaje en pantalla que desaparece tras un tiempo (SHORT o LONG)
     * @param String cadena
     */
    public void mensaje(String cadena){
        Toast.makeText(this, cadena, Toast.LENGTH_SHORT).show();
    }

    /**
     * Mensaje en pantalla que desaparece tras pulsar Atras
     * @param String cadena
     */
    public void alerta(String cadena) {
        //se prepara la alerta creando nueva instancia
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        //seleccionamos la cadena a mostrar
        dialogBuilder.setMessage(cadena);
        //elegimo un titulo y configuramos para que se pueda quitar
        dialogBuilder.setCancelable(true).setTitle("Titulo de la alerta");
        //mostramos el dialogBuilder
        dialogBuilder.create().show();
    }

    /**
     * Mensaje en pantalla que desaparece tras pulsar alguna de sus opciones
     * @param String cadena
     */
    public void eleccion(String cadena){
        //se prepara la alerta creando nueva instancia
        AlertDialog.Builder alertbox = new AlertDialog.Builder(this);
        //seleccionamos la cadena a mostrar
        alertbox.setMessage(cadena);
        //elegimos un positivo SI y creamos un Listener
        alertbox.setPositiveButton("Si", new DialogInterface.OnClickListener() {
            //Funcion llamada cuando se pulsa el boton Si
            public void onClick(DialogInterface arg0, int arg1) {
                mensaje("Pulsado el botón SI");
            }
        });

        //elegimos un positivo NO y creamos un Listener
        alertbox.setNegativeButton("No", new DialogInterface.OnClickListener() {
            //Funcion llamada cuando se pulsa el boton No
            public void onClick(DialogInterface arg0, int arg1) {
                mensaje("Pulsado el botón NO");
            }
        });

        //mostramos el alertbox
        alertbox.show();

    }
}