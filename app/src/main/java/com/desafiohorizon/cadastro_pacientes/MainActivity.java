package com.desafiohorizon.cadastro_pacientes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
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

    private String nome;
    private Double idade;
    private Double tempCorp;
    private Double periodoTosse;
    private Double periodoDorCabeca;
    private Double qntSemanasVisitadas;
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

        String nome = inputNome.getText().toString();
        Double idade = Double.parseDouble(inputIdade.getText().toString());
        Double tempCorp = Double.parseDouble(inputTempCorp.getText().toString());
        Double periodoTosse = Double.parseDouble(inputPeriodoTosse.getText().toString());
        Double periodoDorCabeca = Double.parseDouble(inputPeriodoDorCabeca.getText().toString());
        Double qntSemanasVisitadas = Double.parseDouble(inputQtdSemanasVisitadas.getText().toString());

        if(isChecked && qntSemanasVisitadas<=6 && periodoTosse>5 && periodoDorCabeca>5 && tempCorp>37){
            resultadoConsulta.setText(pacienteInternado);
        } else if (isChecked && qntSemanasVisitadas<=6) {
            resultadoConsulta.setText(pacienteQuarentena);
        } else if (idade>60 || idade<10) {
            if (tempCorp>37 || periodoDorCabeca>3 || periodoTosse>5) {
                resultadoConsulta.setText(pacienteQuarentena);
            }
        } else if (idade>10 && idade<60 && tempCorp>37 && periodoDorCabeca>7 && periodoTosse>7) {
            resultadoConsulta.setText(pacienteQuarentena);
        }else {
            resultadoConsulta.setText(pacienteLiberado
            );
        }
    }
}

