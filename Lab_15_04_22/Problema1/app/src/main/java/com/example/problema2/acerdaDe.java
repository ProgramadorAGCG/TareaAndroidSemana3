package com.example.problema2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class acerdaDe extends AppCompatActivity {

    private Button btnVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerda_de);
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