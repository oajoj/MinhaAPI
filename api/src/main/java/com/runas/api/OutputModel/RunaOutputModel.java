package com.runas.api.OutputModel;

public class RunaOutputModel {
    private String nome;
    private String glifo;
    private String camada;
    private String calice;

    public RunaOutputModel() {
    }

    public RunaOutputModel(String nome, String glifo, String camada, String calice) {
        this.nome = nome;
        this.glifo = glifo;
        this.camada = camada;
        this.calice = calice;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGlifo() {
        return this.glifo;
    }

    public void setGlifo(String glifo) {
        this.glifo = glifo;
    }

    public String getCamada() {
        return this.camada;
    }

    public void setCamada(String camada) {
        this.camada = camada;
    }

    public String getCalice() {
        return this.calice;
    }

    public void setCalice(String calice) {
        this.calice = calice;
    }

}
