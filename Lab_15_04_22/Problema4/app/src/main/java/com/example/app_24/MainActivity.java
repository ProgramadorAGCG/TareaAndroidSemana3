package com.example.app_24;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements
        View.OnClickListener, AdapterView.OnItemSelectedListener{
    EditText edtCliente,edtCAdultos,edtCNiños;
    Spinner spnPelicula;
    RadioButton rbtnComedias,rbtnDramaticas,rbtnTerror,rbtnInfantiles;
    Button btnProcesar;
    //variables globales
    int posGenero,posPelicula;
    String nomGenero,nomPelicula;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtCliente=(EditText) findViewById(R.id.edtCliente);
        edtCAdultos=(EditText) findViewById(R.id.edtCAdultos);
        edtCNiños=(EditText) findViewById(R.id.edtCNiños);
        spnPelicula=(Spinner) findViewById(R.id.spnPelicula);
        rbtnComedias=(RadioButton) findViewById(R.id.rbtnComedias);
        rbtnDramaticas=(RadioButton)
                findViewById(R.id.rbtnDramaticas);
        rbtnTerror=(RadioButton) findViewById(R.id.rbtnTerror);
        rbtnInfantiles=(RadioButton)
                findViewById(R.id.rbtnInfantiles);
        btnProcesar=(Button) findViewById(R.id.btnProcesar);
        spnPelicula.setOnItemSelectedListener(this);
        rbtnComedias.setOnClickListener(this);
        rbtnDramaticas.setOnClickListener(this);
        rbtnTerror.setOnClickListener(this);
        rbtnInfantiles.setOnClickListener(this);
        btnProcesar.setOnClickListener(this);
    }
    public void onClick(View v) {
        //validar que radio se pulso o selecciono
        if(v==rbtnComedias){
            posGenero=0;
            nomGenero="Comedias";
            //arreglo lineal que almacene las peliculas del genero  comedias
            String peliculas[]={"Super cool","¿Qué pasó ayer?"};
            //crear un adaptador con el valor del arreglo "peliculas"
            ArrayAdapter<String> adapter=new
                    ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1,peliculas);
            //            //
            spnPelicula.setAdapter(adapter);
        }
        else  if(v==rbtnDramaticas){
            posGenero=1;
            nomGenero="Dramaticas";
            String peliculas[]={"Lo imposible","12 años de esclavitud","Historias cruzadas"};
                    //crear un adaptador con el valor del arreglo "peliculas"
                    ArrayAdapter<String> adapter=new
                            ArrayAdapter<String>(this,
                            android.R.layout.simple_list_item_1,peliculas);
            //            //
            spnPelicula.setAdapter(adapter);
        }
        else  if(v==rbtnTerror){
                posGenero=2;
                nomGenero="Terror";
                String peliculas[]={"Annabelle 3","Nosotros","Un lugar en silencio","Halloween"};
                        //crear un adaptador con el valor del arreglo "peliculas"
                        ArrayAdapter<String> adapter=new
                                ArrayAdapter<String>(this,
                                android.R.layout.simple_list_item_1,peliculas);
                //            //
                spnPelicula.setAdapter(adapter);
        }
        else  if(v==rbtnInfantiles){
                    posGenero=3;
                    nomGenero="Infantiles";
                    String peliculas[]={"Alvin y las ardillas","Arthur y los Minimoys","Bolt","Cars","Encantada"};
                            //crear un adaptador con el valor del arreglo "peliculas"
                            ArrayAdapter<String> adapter=new
                                    ArrayAdapter<String>(this,
                                    android.R.layout.simple_list_item_1,peliculas);
                    //            //
                    spnPelicula.setAdapter(adapter);
        }
        else if(v==btnProcesar){
                        //leer cajas
                        String cliente;
                        int cAAdultos,cANiños;
                        cliente=edtCliente.getText().toString();

                        cAAdultos=Integer.parseInt(edtCAdultos.getText().toString());
                        cANiños=Integer.parseInt(edtCNiños.getText().toString());
                        //crear objeto de la clase Intent
                        Intent intent=new Intent(this,Activity_procesar.class);
                        //crear claves dentro del objeto "intent"
                        intent.putExtra("cliente",cliente);
                        intent.putExtra("nombreGenero",nomGenero);
                        intent.putExtra("nombrePelicula",nomPelicula);
                        intent.putExtra("asientoAdultos",cAAdultos);
                        intent.putExtra("asientoNiños",cANiños);
                        intent.putExtra("posicionGenero",posGenero);
                        intent.putExtra("posicionPelicula",posPelicula);
                        //direccionar
                        startActivity(intent);
                    }
                }
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int
                position, long id) {
                    posPelicula=spnPelicula.getSelectedItemPosition();
                    nomPelicula=spnPelicula.getSelectedItem().toString();
                }
                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            }
