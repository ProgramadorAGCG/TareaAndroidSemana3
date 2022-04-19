package com.example.problema2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SegundoActivity extends AppCompatActivity {

    private Button btnVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundo);
        String informacionRecuperada = getIntent().getStringExtra("Informacion");
        TextView informacion = (TextView)findViewById(R.id.tvInfo);
        informacion.setText(informacionRecuperada);
        btnVolver = (Button) findViewById(R.id.btnVolver);
        volver();
    }

    private void volver(){
        btnVolver.setOnClickListener((View v)->{
            Intent i = new Intent(this,MainActivity.class);
            startActivity(i);
        });
    }

}