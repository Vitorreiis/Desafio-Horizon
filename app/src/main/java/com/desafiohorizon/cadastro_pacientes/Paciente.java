package com.desafiohorizon.cadastro_pacientes;

public class Paciente {

    //variaveis
    private String nome;
    private int idade;
    private int tempCorp;
    private int periodoTosse;
    private int periodoDorCabeca;
    private int qntSemanasVisitadas;
    private boolean isChecked;

    //construtor
    public Paciente(
            String nome,
            int idade,
            int tempCorp,
            int periodoTosse,
            int periodoDorCabeca,
            int qntSemanasVisitadas
    ){
        this.nome = nome;
        this.idade = idade;
        this.tempCorp = tempCorp;
        this.periodoTosse = periodoTosse;
        this.periodoDorCabeca = periodoDorCabeca;
        this.qntSemanasVisitadas = qntSemanasVisitadas;
    }


    //Criação de getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getTempCorp() {
        return tempCorp;
    }

    public void setTempCorp(int tempCorp) {
        this.tempCorp = tempCorp;
    }

    public double getPeriodoTosse() {
        return periodoTosse;
    }

    public void setPeriodoTosse(int periodoTosse) {
        this.periodoTosse = periodoTosse;
    }

    public double getPeriodoDorCabeca() {
        return periodoDorCabeca;
    }

    public void setPeriodoDorCabeca(int periodoDorCabeca) {
        this.periodoDorCabeca = periodoDorCabeca;
    }

    public double getQntSemanasVisitadas() {
        return qntSemanasVisitadas;
    }

    public void setQntSemanasVisitadas(int qntSemanasVisitadas) {
        this.qntSemanasVisitadas = qntSemanasVisitadas;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    @Override
    public String toString(){
        return nome + ", " + idade + " anos";
    }
}
