package com.desafiohorizon.cadastro_pacientes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private EditText inputNome;
    private EditText inputIdade;
    private EditText inputTempCorp;
    private EditText inputPeriodoTosse;
    private EditText inputPeriodoDorCabeca;
    private Switch switchSimNao;
    private EditText inputQtdSemanasVisitadas;
    private TextView resultadoConsulta;
    private boolean isChecked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Pegando os values do formulário
        inputNome = findViewById(R.id.inputNome);
        inputIdade = findViewById(R.id.inputIdade);
        inputTempCorp = findViewById(R.id.inputTempCorp);
        inputPeriodoTosse = findViewById(R.id.inputPeriodoTosse);
        inputPeriodoDorCabeca = findViewById(R.id.inputPeriodoDorCabeca);
        switchSimNao = findViewById(R.id.switchSimNao);
        inputQtdSemanasVisitadas = findViewById(R.id.inputQntSemanasVisitadas);
        resultadoConsulta = findViewById(R.id.resultadoConsulta);

        switchSimNao.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                isChecked = checked;
            }
        });
    }

    public void consultar(View view) {
        //Variaveis
        String pacienteQuarentena = "Paciente deve ficar em quarentena";
        String pacienteLiberado = "Paciente liberado";
        String pacienteInternado = "Paciente deverá ser internado";

        Paciente paciente = new Paciente(
                inputNome.getText().toString(),
                Integer.parseInt(inputIdade.getText().toString()),
                Integer.parseInt(inputTempCorp.getText().toString()),
                Integer.parseInt(inputPeriodoTosse.getText().toString()),
                Integer.parseInt(inputPeriodoDorCabeca.getText().toString()),
                Integer.parseInt(inputQtdSemanasVisitadas.getText().toString())
        );

        PacienteDAO pacienteDAO = new PacienteDAO(this);
        long id = pacienteDAO.inserir(paciente);

        if(isChecked && paciente.getQntSemanasVisitadas()<=6 && paciente.getPeriodoTosse()>5 && paciente.getPeriodoDorCabeca()>5 && paciente.getTempCorp()>37){
            resultadoConsulta.setText(pacienteInternado);
        } else if (isChecked && paciente.getQntSemanasVisitadas()<=6) {
            resultadoConsulta.setText(pacienteQuarentena);
        } else if (paciente.getIdade()>60 || paciente.getIdade()<10) {
            if (paciente.getTempCorp()>37 || paciente.getPeriodoDorCabeca()>3 || paciente.getPeriodoTosse()>5) {
                resultadoConsulta.setText(pacienteQuarentena);
            }
        } else if (paciente.getIdade()>10 && paciente.getIdade()<60 && paciente.getTempCorp()>37 && paciente.getPeriodoDorCabeca()>7 && paciente.getPeriodoTosse()>7) {
            resultadoConsulta.setText(pacienteQuarentena);
        }else {
            resultadoConsulta.setText(pacienteLiberado
            );
        }

            Toast.makeText(this, "Paciente Salvo , id: " +id, Toast.LENGTH_LONG).show();
    }

    public void listar (View view){
        Intent iListaPaciente = new Intent(this, ListaPacientes.class);
        startActivity(iListaPaciente);
    }
}

