package com.example.huellacarbono.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class ActividadCarbonoDao {

    ConexionBD conexion;
    SQLiteDatabase db;

    public ActividadCarbonoDao(Context context) {
        conexion = new ConexionBD(context);
    }

    public void insertar(ActividadCarbono a) {
        db = conexion.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(Constantes.COL_TIPO, a.getTipoActividad());
        cv.put(Constantes.COL_CANTIDAD, a.getCantidad());
        cv.put(Constantes.COL_EMISIONES, a.getEmisionesCO2());
        cv.put(Constantes.COL_FECHA, a.getFecha());
        db.insert(Constantes.TABLA, null, cv);

    }

    public ArrayList<ActividadCarbono> listar() {
        ArrayList<ActividadCarbono> lista = new ArrayList<>();
        db = conexion.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + Constantes.TABLA, null);

        while (c.moveToNext()) {
            ActividadCarbono a = new ActividadCarbono();
            a.setId(c.getInt(0));
            a.setTipoActividad(c.getString(1));
            a.setCantidad(c.getDouble(2));
            a.setEmisionesCO2(c.getDouble(3));
            a.setFecha(c.getString(4));
            lista.add(a);
        }

        return lista;
    }

    // 🔥 RESULTADO FINAL
    public double obtenerHuellaTotal() {
        double total = 0;
        db = conexion.getReadableDatabase();
        Cursor c = db.rawQuery(
                "SELECT SUM(" + Constantes.COL_EMISIONES + ") FROM " + Constantes.TABLA,
                null
        );

        if (c.moveToFirst()) {
            total = c.getDouble(0);
        }


        return total;
    }
}
