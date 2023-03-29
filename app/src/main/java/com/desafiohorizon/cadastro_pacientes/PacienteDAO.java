package com.desafiohorizon.cadastro_pacientes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class PacienteDAO {

    private Database data;
    private SQLiteDatabase db;

    public PacienteDAO(Context context){
        data = new Database(context);
        db = data.getWritableDatabase();
    }

    //Função que insere um novo paciente no banco de dados
    public long inserir (Paciente paciente){
        ContentValues contentValues = new ContentValues();

        contentValues.put("nome", paciente.getNome());
        contentValues.put("idade", paciente.getIdade());
        contentValues.put("tempCorp", paciente.getTempCorp());
        contentValues.put("periodoTosse", paciente.getPeriodoTosse());
        contentValues.put("periodoDorCabeca", paciente.getPeriodoDorCabeca());
        contentValues.put("qntSemanasVisitadas", paciente.getQntSemanasVisitadas());

        Cursor cursor = db.rawQuery("SELECT * FROM paciente WHERE nome = ?", new String[] {paciente.getNome()});

        if (cursor.getCount() == 0){
            //Paciente não existe
            return db.insert("paciente", null, contentValues);
        } else {
            //Paciente existe existe
            return -1;
        }
    }

    //Função que percorre a tabela do banco de dados e retorna a lista de todos os pacientes cadastrados
    public List<Paciente> listar(){

        List<Paciente> lista = new ArrayList<Paciente>();

        Cursor cursor = db.rawQuery("SELECT * FROM paciente", null);

        while(cursor.moveToNext()){
            lista.add(new Paciente(cursor.getString(1), cursor.getInt(2), cursor.getInt(3), cursor.getInt(4), cursor.getInt(5), cursor.getInt(6)));
        }

        return lista;
    }
}
