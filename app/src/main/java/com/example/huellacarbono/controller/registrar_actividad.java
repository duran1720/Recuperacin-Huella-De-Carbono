package com.example.huellacarbono.controller;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import com.example.huellacarbono.R;
import com.example.huellacarbono.model.ActividadCarbono;
import com.example.huellacarbono.model.ActividadCarbonoDao;

public class registrar_actividad extends AppCompatActivity {

    Spinner spTipo;
    EditText edtCantidad, edtFecha;
    Button btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_actividad);

        spTipo = findViewById(R.id.spTipo);
        edtCantidad = findViewById(R.id.edtCantidad);
        edtFecha = findViewById(R.id.edtFecha);
        btnGuardar = findViewById(R.id.btnGuardar);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.tipos_actividad,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spTipo.setAdapter(adapter);

        btnGuardar.setOnClickListener(v -> guardarActividad());
    }

    private void guardarActividad() {

        if (edtCantidad.getText().toString().isEmpty() ||
                edtFecha.getText().toString().isEmpty()) {
            Toast.makeText(this, "Complete todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }

        String tipo = spTipo.getSelectedItem().toString();
        double cantidad = Double.parseDouble(edtCantidad.getText().toString());
        String fecha = edtFecha.getText().toString();

        ActividadCarbono actividad = new ActividadCarbono(tipo, cantidad, fecha);
        ActividadCarbonoDao dao = new ActividadCarbonoDao(this);
        dao.insertar(actividad);

        Toast.makeText(this, "Actividad guardada correctamente", Toast.LENGTH_SHORT).show();
        finish();
    }
}
