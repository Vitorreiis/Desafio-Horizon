package com.desafiohorizon.cadastro_pacientes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText inputNome;
    private EditText inputIdade;
    private EditText inputTempCorp;
    private EditText inputPeriodoTosse;
    private EditText inputPeriodoDorCabeca;
    private Switch switchSimNao;
    private EditText inputQtdSemanasVisitadas;
    private TextView resultadoConsulta;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputNome = findViewById(R.id.inputNome);
        inputIdade = findViewById(R.id.inputIdade);
        inputTempCorp = findViewById(R.id.inputTempCorp);
        inputPeriodoTosse = findViewById(R.id.inputPeriodoTosse);
        inputPeriodoDorCabeca = findViewById(R.id.inputPeriodoDorCabeca);
        switchSimNao = findViewById(R.id.switchSimNao);
        inputQtdSemanasVisitadas = findViewById(R.id.inputQntSemanasVisitadas);
        resultadoConsulta = findViewById(R.id.resultadoConsulta)
    }

    public void consultar(View view){
        String nome = inputNome.getText().toString();
        Double idade = Double.parseDouble(inputIdade.getText().toString());
        Double tempCorp = Double.parseDouble(inputTempCorp.getText().toString());
        Double periodoTosse = Double.parseDouble(inputPeriodoTosse.getText().toString());
        Double periodoDorCabeca = Double.parseDouble(inputPeriodoDorCabeca.getText().toString());
        String switchSimNao = switchSimNao.getText().toString();
        Double qntSemanasVisitadas = Double.parseDouble(inputQtdSemanasVisitadas.getText().toString());
    }
}