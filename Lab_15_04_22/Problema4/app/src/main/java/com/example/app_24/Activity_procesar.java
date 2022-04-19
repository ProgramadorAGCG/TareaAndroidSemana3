package com.example.app_24;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Activity_procesar extends AppCompatActivity implements
        View.OnClickListener {
            TextView tvClienteR,tvGeneroR,tvPeliculaR,tvCAdultosR,tvCNiñosR,
            tvMontoAdultos,tvMontoNiños,tvMontoConfiteria,tvTotalPagar;
            EditText edtCFamiliar,edtCPersonal;
            CheckBox chkFamiliar,chkPersonal;
            ImageView imgPelicula;
            Button btnCalcular,btnVolver;
    //
    int posGenero,pospelicula,canAdultos,canNiños;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_procesar);
        tvClienteR=(TextView) findViewById(R.id.tvClienteR);
        tvGeneroR=(TextView) findViewById(R.id.tvGeneroR);
        tvPeliculaR=(TextView) findViewById(R.id.tvPeliculaR);
        tvCAdultosR=(TextView) findViewById(R.id.tvCAdultosR);
        tvCNiñosR=(TextView) findViewById(R.id.tvCNiñosR);
        tvMontoAdultos=(TextView) findViewById(R.id.tvMontoAdultos);
        tvMontoNiños=(TextView) findViewById(R.id.tvMontoNiños);
        tvMontoConfiteria=(TextView)
                findViewById(R.id.tvMontoConfiteria);
        tvTotalPagar=(TextView) findViewById(R.id.tvTotalPagar);
        edtCFamiliar=(EditText) findViewById(R.id.edtCFamiliarR);
        edtCPersonal=(EditText) findViewById(R.id.edtCPersonalR);
        chkFamiliar=(CheckBox) findViewById(R.id.chkFamiliar);
        chkPersonal=(CheckBox) findViewById(R.id.chkPersonal);
        imgPelicula=(ImageView) findViewById(R.id.imgPeliculaR);
        btnCalcular=(Button) findViewById(R.id.btnCalcular);
        btnVolver=(Button) findViewById(R.id.btnVolver);
        btnCalcular.setOnClickListener(this);
        btnVolver.setOnClickListener(this);
        chkFamiliar.setOnClickListener(this);
        chkPersonal.setOnClickListener(this);
        cargarDatos();
    }
    public void onClick(View v) {
        if(v==chkFamiliar){
            if(chkFamiliar.isChecked()){
                edtCFamiliar.setEnabled(true);
                edtCFamiliar.requestFocus();
            }
            else{
                edtCFamiliar.setEnabled(false);
                edtCFamiliar.setText("0");
            }
        }
        else if(v==chkPersonal){
            if(chkPersonal.isChecked()){
                edtCPersonal.setEnabled(true);
                edtCPersonal.requestFocus();
            }
            else{
                edtCPersonal.setEnabled(false);
                edtCPersonal.setText("0");
            }
        }
        else if(v==btnCalcular){
            double pre,mAdultos,mNiños,mConfiteria,total;
            int cFamiliar,cPersonal;
            if(posGenero==0 && pospelicula==0)
                pre=35.5;
            else if(posGenero==0 && pospelicula==1)
                pre=32.5;
            else if(posGenero==1 && pospelicula==0)
                pre=30.5;
            else if(posGenero==1 && pospelicula==1)
                pre=28.3;
            else if(posGenero==1 && pospelicula==2)
                pre=25.5;
            else if(posGenero==2 && pospelicula==0)
                pre=45.5;
            else if(posGenero==2 && pospelicula==1)
                pre=40.3;
            else if(posGenero==2 && pospelicula==2)
                pre=43;
            else if(posGenero==2 && pospelicula==3)
                pre=38.9;
            else if(posGenero==3 && pospelicula==0)
                pre=58.9;
            else if(posGenero==3 && pospelicula==1)
                pre=57;
            else if(posGenero==3 && pospelicula==2)
                pre=60;
            else if(posGenero==3 && pospelicula==3)
                pre=65.5;
            else
                pre=57.8;
            //

            cFamiliar=Integer.parseInt(edtCFamiliar.getText().toString());

            cPersonal=Integer.parseInt(edtCPersonal.getText().toString());
            mAdultos=canAdultos*pre;
            mNiños=(pre-10)*canNiños;
            mConfiteria=cFamiliar*35.4+cPersonal*12.9;
            total=mAdultos+mNiños+mConfiteria;
            tvMontoAdultos.setText("Monto Adultos S/. :"+mAdultos);
            tvMontoNiños.setText("Monto niños S/. :"+mNiños);
            tvMontoConfiteria.setText("Monto cofitería S/.:"+mConfiteria);
            tvTotalPagar.setText("Monto Total S/. :"+total);

        }
        else if(v==btnVolver){
            Intent intent=new Intent(this,MainActivity.class);
            startActivity(intent);
        }
    }
    void cargarDatos(){
        Bundle datos=this.getIntent().getExtras();
        canAdultos= datos.getInt("asientoAdultos");
        canNiños=datos.getInt("asientoNiños");
        tvClienteR.setText("Cliente : " +datos.getString("cliente"));
        tvGeneroR.setText("Genero : "+datos.getString("nombreGenero"));
                tvPeliculaR.setText("Pelicula : "+datos.getString("nombrePelicula"));
                        tvCAdultosR.setText("Cantidad Asientos Adultos : "+canAdultos);
                                tvCNiñosR.setText("Cantidad Asientos Niños : "+canNiños);
        //
        posGenero=datos.getInt("posicionGenero");
        pospelicula=datos.getInt("posicionPelicula");
        //
        int resId;

        resId=this.getResources().getIdentifier("p"+posGenero+pospelicula,"drawable",this.getPackageName());
                imgPelicula.setImageResource(resId);
    }
}