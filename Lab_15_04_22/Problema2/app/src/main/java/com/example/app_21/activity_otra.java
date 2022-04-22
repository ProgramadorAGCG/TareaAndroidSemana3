package com.example.app_21;

import androidx.appcompat.app.AppCompatActivity;



import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
public class activity_otra extends AppCompatActivity implements View.OnClickListener{
    TextView tvidr,tvnombrer,tvprecior;
    Button btnvolver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otra);
        tvidr=(TextView) findViewById(R.id.tvidr);
        tvnombrer=(TextView) findViewById(R.id.tvnombrer);
        tvprecior=(TextView) findViewById(R.id.tvprecior);
        btnvolver=(Button) findViewById(R.id.btnvolver);
        btnvolver.setOnClickListener(this);
        cargarDatos();
    }
    void cargarDatos(){
        //obtener los claves que se encuentran en un Objeto de clase Intent
        Bundle datos=this.getIntent().getExtras();
        //imprimir claves en los TextView
        tvidr.setText("ID : "+datos.getInt("id2"));
        tvnombrer.setText("PRODUCTO : "+datos.getString("nom"));
        tvprecior.setText("PRECIO : "+datos.getDouble("pre"));
    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
