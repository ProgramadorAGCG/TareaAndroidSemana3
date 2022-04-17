package com.example.ejercicio_02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private String[] nombres = { "maruja", "michael", "kevin", "yami", "raul", "ronal", "anival", "fiorela", "rut", "sara",
                                "Eus", "jose", "Karen", "rocio", "max", "alvaro", "jenifer", "karol", "mariela", "pedro"};
    private String[] numeros = { "966505097", "954370726", "944617411", "96680912", "947457421", "944612451", "912617411",
                                "944617411", "944617411", "944617411","944617411", "944617411", "944617411", "944617411",
                                "944617411", "944617411", "944617411", "944617411", "944617411", "944617411"};
    private TextView txtTitulo;
    private ListView lvLista;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtTitulo = findViewById(R.id.txtTitulo);
        lvLista = findViewById(R.id.lvLista);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_nombres, nombres);
        lvLista.setAdapter(adapter);
        lvLista.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        txtTitulo.setText("El Telefono de "+ lvLista.getItemAtPosition(i) + " es "+ numeros[i]);
    }
}