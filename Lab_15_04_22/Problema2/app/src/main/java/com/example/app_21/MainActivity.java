package com.example.app_21;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText edtnombre,edtid,edtprecio;
    Button  btnenviar,btnfinalizar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtid = (EditText) findViewById(R.id.edtid);
        edtnombre = (EditText) findViewById(R.id.edtnombre);
        edtprecio = (EditText) findViewById(R.id.edtprecio);
        btnenviar=(Button) findViewById(R.id.btnenviar);
        btnfinalizar=(Button) findViewById(R.id.btnfinalizar);
        btnenviar.setOnClickListener(this);
        btnfinalizar.setOnClickListener(this);
    }
    public void onClick(View v) {
        if(v==btnenviar){
            //leer id,nombre,precio
            String nombre;
            int id;
            double precio;
            nombre=edtnombre.getText().toString();
            id=Integer.parseInt(edtid.getText().toString());
            precio=Double.parseDouble(edtprecio.getText().toString());
            //crear un objeto de la clase Intent
            Intent intent=new Intent(this,activity_otra.class);
            //crear las claves "variables" dfentro del objeto "intent"
            intent.putExtra("id2",id);
            intent.putExtra("nom",nombre);
            intent.putExtra("pre",precio);
            //direccionar a la actividad "Mainotra"
            startActivity(intent);
        }else{
            finish();
        }
    }
}
