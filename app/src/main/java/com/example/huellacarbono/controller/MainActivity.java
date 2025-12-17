package com.example.huellacarbono.controller;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.example.huellacarbono.R;

public class MainActivity extends AppCompatActivity {

    Button btnRegistrar, btnVer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRegistrar = findViewById(R.id.btnRegistrar);
        btnVer = findViewById(R.id.btnVer);

        btnRegistrar.setOnClickListener(v ->
                startActivity(new Intent(this, registrar_actividad.class)));

        btnVer.setOnClickListener(v ->
                startActivity(new Intent(this, lista_actividades.class)));
    }
}
