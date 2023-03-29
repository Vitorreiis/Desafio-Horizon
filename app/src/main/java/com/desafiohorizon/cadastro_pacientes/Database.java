package com.desafiohorizon.cadastro_pacientes;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {

    private static final String nome = "bancoPacientes.db";
    private static final int versao = 1;

    public Database(Context context){
        super(context, nome, null, versao);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE paciente (id integer primary key autoincrement, nome varchar(50), idade integer, tempCorp integer, periodoTosse integer, periodoDorCabeca integer, qntSemanasVisitadas integer)");
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {}
}
