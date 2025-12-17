package com.example.huellacarbono.controller;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.huellacarbono.R;
import com.example.huellacarbono.model.ActividadCarbono;
import com.example.huellacarbono.model.ActividadCarbonoDao;
import java.util.ArrayList;

public class lista_actividades extends AppCompatActivity {

    ListView listActividades;
    TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_actividades);

        listActividades = findViewById(R.id.listActividades);
        txtResultado = findViewById(R.id.txtResultado);

        ActividadCarbonoDao dao = new ActividadCarbonoDao(this);

        ArrayList<ActividadCarbono> lista = dao.listar();
        double total = dao.obtenerHuellaTotal();

        ArrayAdapter<ActividadCarbono> adapter =
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, lista);

        listActividades.setAdapter(adapter);
        txtResultado.setText("Huella total: " + total + " kg CO₂");
    }
}
