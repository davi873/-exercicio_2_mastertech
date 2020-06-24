package br.com.matertech.api.model;

public class Empresa {
    private String nome;
    private String cnpj;
    private double capital_social;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public double getCapital_social() {
        return capital_social;
    }

    public void setCapital_social(double capital_social) {
        this.capital_social = capital_social;
    }
}
