package com.desafiohorizon.cadastro_pacientes;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class PacienteDAO {

    private Database data;
    private SQLiteDatabase db;

    public PacienteDAO(Context context){
        data = new Database(context);
        db = data.getWritableDatabase();
    }

    public long inserir (Paciente paciente){
        ContentValues contentValues = new ContentValues();

        contentValues.put("nome", paciente.getNome());
        contentValues.put("idade", paciente.getIdade());
        contentValues.put("tempCorp", paciente.getTempCorp());
        contentValues.put("periodoTosse", paciente.getPeriodoTosse());
        contentValues.put("periodoDorCabeca", paciente.getPeriodoDorCabeca());
        contentValues.put("qntSemanasVisitadas", paciente.getQntSemanasVisitadas());

        return db.insert("paciente", null, contentValues);
    }
}
