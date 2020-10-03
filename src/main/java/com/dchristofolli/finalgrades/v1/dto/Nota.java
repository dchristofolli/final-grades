package com.dchristofolli.finalgrades.v1.dto;

public class Nota {
    private Long id;
    private double Prova1;
    private double Prova2;
    private double Prova3;
    private double peso;

    public Nota(Long id, double prova1, double prova2, double prova3, double peso) {
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

    public double getProva1() {
        return Prova1;
    }

    public void setProva1(double prova1) {
        Prova1 = prova1;
    }

    public double getProva2() {
        return Prova2;
    }

    public void setProva2(double prova2) {
        Prova2 = prova2;
    }

    public double getProva3() {
        return Prova3;
    }

    public void setProva3(double prova3) {
        Prova3 = prova3;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
}
