package com.runas.api.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class RunaModel {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull @NotBlank
    private String nome;

    @NotNull @NotBlank
    private String glifo;

    @NotNull @NotBlank
    private String camada;

    @NotNull @NotBlank
    private String calice;

    public RunaModel() {

    }

    public RunaModel(String nome, String glifo, String camada, String calice) {
        this.nome = nome;
        this.glifo = glifo;
        this.camada = camada;
        this.calice = calice;
    }

    public RunaModel atualizar(String nome, String glifo, String camada, String calice){
        this.nome = nome;
        this.glifo = glifo;
        this.camada = camada;
        this.calice = calice;
        return this;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
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
