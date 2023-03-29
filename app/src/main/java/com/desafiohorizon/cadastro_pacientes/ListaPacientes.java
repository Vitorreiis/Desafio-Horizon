package com.desafiohorizon.cadastro_pacientes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class ListaPacientes extends AppCompatActivity {

    List<Paciente> lPaciente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pacientes);

        ListView lvPacientes = findViewById(R.id.listPacientes);
        PacienteDAO pacienteDAO = new PacienteDAO(this);
        lPaciente = pacienteDAO.listar();

        ArrayAdapter<Paciente> adapter = new ArrayAdapter<Paciente>(this, android.R.layout.simple_list_item_1, lPaciente);

        lvPacientes.setAdapter(adapter);
    }
}