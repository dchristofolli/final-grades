package com.dchristofolli.finalgrades.v1.dto;

public class AlunoResult {
    private Long id;
    private String nome;
    private double notaFinal;

    public AlunoResult(Long id, String nome, double notaFinal) {
        this.id = id;
        this.nome = nome;
        this.notaFinal = notaFinal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(double notaFinal) {
        this.notaFinal = notaFinal;
    }
}
