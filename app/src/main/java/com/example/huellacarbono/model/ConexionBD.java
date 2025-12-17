package com.example.huellacarbono.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ConexionBD extends SQLiteOpenHelper {

    public ConexionBD(Context context) {
        super(context, Constantes.DB_NAME, null, Constantes.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + Constantes.TABLA + "(" +
                Constantes.COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Constantes.COL_TIPO + " TEXT, " +
                Constantes.COL_CANTIDAD + " REAL, " +
                Constantes.COL_EMISIONES + " REAL, " +
                Constantes.COL_FECHA + " TEXT)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Constantes.TABLA);
        onCreate(db);
    }
}
