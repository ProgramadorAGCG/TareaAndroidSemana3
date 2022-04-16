package com.example.problema2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SegundoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundo);
        String informacionRecuperada = getIntent().getStringExtra("Informacion");
        TextView informacion = (TextView)findViewById(R.id.tvInfo);
        informacion.setText(informacionRecuperada);
    }
    public void Salir(){
        finish();
    }

}