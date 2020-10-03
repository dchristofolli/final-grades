package com.dchristofolli.finalgrades.v1.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Nota {
    private Long id;
    private Double Prova1;
    private Double Prova2;
    private Double Prova3;
    private Double peso;

    public Nota(Long id, Double prova1, Double prova2, Double prova3, Double peso) {
        this.id = id;
        Prova1 = prova1;
        Prova2 = prova2;
        Prova3 = prova3;
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "Nota{" +
            "id=" + id +
            ", Prova1=" + Prova1 +
            ", Prova2=" + Prova2 +
            ", Prova3=" + Prova3 +
            ", peso=" + peso +
            '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getProva1() {
        return Prova1;
    }

    public void setProva1(Double prova1) {
        Prova1 = prova1;
    }

    public Double getProva2() {
        return Prova2;
    }

    public void setProva2(Double prova2) {
        Prova2 = prova2;
    }

    public Double getProva3() {
        return Prova3;
    }

    public void setProva3(Double prova3) {
        Prova3 = prova3;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }
}
